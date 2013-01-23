package org.oxford.comlab.requiem.evaluator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

import org.oxford.comlab.requiem.rewriter.Clause;
import org.oxford.comlab.requiem.rewriter.FunctionalTerm;
import org.oxford.comlab.requiem.rewriter.Term;
import org.oxford.comlab.requiem.rewriter.Variable;

public class Evaluator {
	
	private ArrayList<Clause> pruneEmptyPredicates(ArrayList<Clause> clauses, HashMap<String,String> mappings){
		
		ArrayList<Clause> result = new ArrayList<Clause>();
		
		boolean toBePruned;
		
		for(Clause c: clauses){
			toBePruned = false;
			for(Term bodyAtom : c.getBody()){
				if(!mappings.containsKey(bodyAtom.getName())){
					toBePruned = true;
					break;
				}
			}
			if(!toBePruned){
				result.add(c);
			}
		}
		
		return result;
	}
	
	public String getSQL(ArrayList<Clause> rewriting, HashMap<String,String> mappings) throws Exception {	
		
		rewriting = this.pruneEmptyPredicates(rewriting, mappings);
		
		if(rewriting.size() > 0){
			String result = "";
			Clause clause;
			
			for(int i=0; i<rewriting.size(); i++){
				clause = rewriting.get(i);
				
				if(clause.getHead().getName().equals("Q")){
					if(i!=0)	
						result += " UNION \n";
					result += getSQL(rewriting.get(i), mappings);
				}
				else{
					return null;
					
				}
			}
			
			result += ";";
			return result;
		}
		return "";
	}
	
	private String getSQL(Clause clause, HashMap<String,String> mappings){
		String result = "";
		
		ArrayList<String> selectParts = new ArrayList<String>();
		ArrayList<String> fromParts = new ArrayList<String>();
		ArrayList<String> whereParts = new ArrayList<String>();

		
		HashMap<String,String> mappingVariables = new HashMap<String,String>();
		
		for(int i = 0; i < clause.getBody().length; i ++){
			Term bodyAtom = clause.getBody()[i];
			
			fromParts.add("(" + mappings.get(bodyAtom.getName()) + ") AS T" + i);
			
			for(int j=0; j<bodyAtom.getArity(); j++){
				//variable
				if(bodyAtom.getArgument(j) instanceof Variable){
					Variable var = (Variable) bodyAtom.getArgument(j);
					if(!mappingVariables.containsKey(var.getName())){
						mappingVariables.put(var.getName(), "T" + i + ".C" + j);
					}
					//Shared variable
					else{
						whereParts.add(mappingVariables.get(var.getName()) + " = " + "T" + i + ".C" + j);
						mappingVariables.put(var.getName(), "T" + i + ".C" + j);
					}
				}
				//constant
				if(bodyAtom.getArgument(j) instanceof FunctionalTerm){
					FunctionalTerm cons = (FunctionalTerm) bodyAtom.getArgument(j);
					whereParts.add("T" + i + ".C" + j + " = '" + cons.getName().substring(1, cons.getName().length()-1) + "'");
				}
			}
		}
		
		for(Term vc: clause.getHead().getArguments()){
			//variable 
			if(vc instanceof Variable){
				selectParts.add(mappingVariables.get(vc.getName()));
			}
			//constant
			if(vc instanceof FunctionalTerm){
				selectParts.add("'" + vc.getName() + "'");
			}
		}
		
		result = "SELECT ";
		for(int s=0; s<selectParts.size(); s++){
			if(s!=0)
				result += ", ";
			result += selectParts.get(s);
		}
		
		result += " FROM ";
		
		for(int f=0; f<fromParts.size(); f++){
			if(f!=0)
				result += ", ";
			result += fromParts.get(f);
		}
		
		if(whereParts.size() > 0){
			result += " WHERE ";
			
			for(int w=0; w<whereParts.size(); w++){
				if(w!=0)
					result += " AND ";
				result += whereParts.get(w);
			}
		}	
		
		return result;
	}
	
	public boolean evaluateSQL(String[] connectionData, String query, JTextArea textArea) throws Exception{
		Connection conn = null;
        Statement stmt = null;
	    ResultSet rs = null;
	    ResultSetMetaData rsmd;
	    try {
	    	long begin = System.currentTimeMillis();
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DriverManager.registerDriver(new org.postgresql.Driver());
			
	        conn = DriverManager.getConnection(connectionData[0]+connectionData[1]+"?user="+connectionData[2]+"&password="+connectionData[3]);
	        conn.setAutoCommit(false);
	        stmt = conn.createStatement();//java.sql.ResultSet.TYPE_FORWARD_ONLY,java.sql.ResultSet.CONCUR_READ_ONLY);
	        stmt.setFetchSize(50);
	        
	        rs = stmt.executeQuery(query);
	        
	        rsmd = rs.getMetaData();
	        int numCols = rsmd.getColumnCount();
	        int numRows = 0;
	        while (rs.next()){
		         for (int i = 1; i <= numCols; i++){
		        	 //System.out.print(rs.getString(i)+"\t");
		        	 textArea.append(rs.getString(i)+"\t");
		         }
		         //System.out.println();
		         textArea.append("\n");
		         numRows++;
	         }
	        long end = System.currentTimeMillis();
	        textArea.append("-------------------------------\n");
	        if(numRows == 1){
	        	textArea.append("1 row retrieved in " + Long.toString(end - begin) + " millisec.");
	        }
	        else{
	        	textArea.append(numRows + " rows retrieved in " + Long.toString(end - begin) + " millisec.");
	        }
	        
		}
		finally {
		        if (rs != null) {
		            try {
		                rs.close();
		            } catch (SQLException sqlEx) { } // ignore
		            rs = null;
		        }
		        if (stmt != null) {
		            try {
		                stmt.close();
		            } catch (SQLException sqlEx) { } // ignore
		            stmt = null;
		        }
		    }
		return true;
	}

}
