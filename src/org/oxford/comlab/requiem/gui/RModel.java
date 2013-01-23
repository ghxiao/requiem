package org.oxford.comlab.requiem.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextArea;

import org.oxford.comlab.requiem.evaluator.Evaluator;
import org.oxford.comlab.requiem.parser.ELHIOParser;
import org.oxford.comlab.requiem.rewriter.Clause;
import org.oxford.comlab.requiem.rewriter.Rewriter;
import org.oxford.comlab.requiem.rewriter.TermFactory;

public class RModel {
	
	private static final TermFactory m_termFactory = new TermFactory(); 
	private static final ELHIOParser m_parser = new ELHIOParser(m_termFactory);
	private static final Rewriter m_rewriter = new Rewriter();
	private static final Evaluator m_evaluator = new Evaluator();
	
	public String loadFile(File file) throws Exception{
		String result = "";
		
		BufferedReader reader = new BufferedReader(new FileReader(file));		
		String input;
		while((input = reader.readLine())!= null){
			result += input + "\n";
		}
		reader.close();
		
		return result;
	}
	
	public void saveFile(File file, String text) throws Exception{
        FileWriter out = new FileWriter(file);
        out.write(text);
		out.close();
	}
	
	public ArrayList<Clause> rewriteQuery(String queryText, String ontologyFilePath) throws Exception{
		
		ArrayList<Clause> original = new ArrayList<Clause>();
				
		original = m_parser.getClauses(ontologyFilePath);
		
		String queryInput = "";
		
		String[] queryTextLines = queryText.split("\\n");
		
		for(int i=0; i<queryTextLines.length; i++){
			if(queryTextLines[i].indexOf("//") != 0){
				queryInput = queryTextLines[i];
				break;
			}
		}
		
    	Clause query = m_parser.getQuery(queryInput);
    	if(query != null){
    		original.add(query);
    	}
    	else{
    		throw new Exception("Invalid Query");
    	}
		
		return m_rewriter.rewrite(original, "G");
	}
	
	public String getSQLQuery(String mappingsFile, ArrayList<Clause> clauses) throws Exception{
		
		String mappingsText = loadFile(new File(mappingsFile));
		
		//check if query is UCQ
		for(Clause c:clauses){
			if(!c.getHead().getName().equals("Q"))
				return null;
		}
		
		HashMap<String,String> mappings = new HashMap<String,String>();
		
		String[] queryTextLines = mappingsText.split("\\n");
		
		String predicate;
		String SQLstatement;
		String input;
		for(int i=0; i<queryTextLines.length; i++){
			input = queryTextLines[i];
			if(!input.equals("") && input.indexOf("//") != 0){
				predicate = input.substring(0, input.indexOf("-")).trim();
				SQLstatement = input.substring(input.indexOf(">")+1, input.length()).trim();
				mappings.put(predicate, SQLstatement);
			}
			
		}
		
		return m_evaluator.getSQL(clauses, mappings);
	}
	
	public boolean evaluateSQLQuery(String[] connectionData, String query, JTextArea textArea) throws Exception{
		return m_evaluator.evaluateSQL(connectionData, query, textArea);
	}
}
