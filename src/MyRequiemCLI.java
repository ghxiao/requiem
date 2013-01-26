import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.oxford.comlab.requiem.parser.ELHIOParser;
import org.oxford.comlab.requiem.rewriter.Clause;
import org.oxford.comlab.requiem.rewriter.Rewriter;
import org.oxford.comlab.requiem.rewriter.TermFactory;

	
public class MyRequiemCLI {
		
	private static final TermFactory m_termFactory = new TermFactory(); 
	private static final ELHIOParser m_parser = new ELHIOParser(m_termFactory);
	private static final Rewriter m_rewriter = new Rewriter();

	/**
	 * @param args
	 * 0 - query file
	 * 1 - ontology file
	 * 2 - mode (N|F|G)
	 */
	public static void main(String[] args) throws Exception{
		
		if(args.length == 3 && (args[2].equals("N") || args[2].equals("F") || args[2].equals("G"))){
			String queryFile = args[0];
			String ontologyFile = args[1];
			String mode = args[2];
			
			String ontologyURI = new File(ontologyFile).toURI().toString();
			
			System.err.println("ontology: " + ontologyURI);
			
			ArrayList<Clause> original = m_parser.getClauses(ontologyURI);
			
	    	Clause query = m_parser.getQueryFromFile(queryFile);
	    	if(query != null){
	    		original.add(query);
	    	}
	    	else{
	    		throw new Exception("Invalid query.");
	    	}

	    	long begin = System.currentTimeMillis();

			ArrayList<Clause> rewriting = m_rewriter.rewrite(original, mode);

	    	long end = System.currentTimeMillis();
			
			printResult(queryFile, ontologyFile, end-begin, rewriting.size(), query.m_canonicalRepresentation, rewriting);
			
		}
		else{
			throw new Exception("Use: java Requiem query.cq ontology.owl mode(N|F|G)");
		}
	}
	
	private static void printResult(String queryFile, String ontologyFile, long time, int rewritingSize, String query, ArrayList<Clause> rewriting) throws Exception{
        System.err.print("==================SUMMARY==================\n");
        System.err.print("Ontology file:             " + ontologyFile.substring(ontologyFile.lastIndexOf("/") + 1) + "\n"); 
        System.err.print("Query:                     " + query + "\n");
        System.err.print("Running time:              " + time + " milliseconds \n");
		System.err.print("Size of the rewriting (queries):     " + rewritingSize + "\n");
		int size = 0;
		for(Clause c: rewriting){
			size += c.toString().length();
		}
		System.err.print("Size of the rewriting (symbols):     " + size + "\n");
		
		//System.out.println("Size of the rewriting (symbols): " + size + "\n");
		System.err.print("==================SUMMARY==================\n");
		Collections.sort(rewriting, new Comparator<Clause>(){
			public int compare(Clause c1, Clause c2){
			    return c1.m_canonicalRepresentation.compareTo(c2.m_canonicalRepresentation);
			}
		});
		int i = 0;
		for(Clause c: rewriting){
			System.out.print(c.m_canonicalRepresentation + "\n");
		}
		
        System.out.close();
	}

}
