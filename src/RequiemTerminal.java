import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.oxford.comlab.requiem.parser.ELHIOParser;
import org.oxford.comlab.requiem.rewriter.Clause;
import org.oxford.comlab.requiem.rewriter.Rewriter;
import org.oxford.comlab.requiem.rewriter.TermFactory;

	
public class RequiemTerminal {
		
	private static final TermFactory m_termFactory = new TermFactory(); 
	private static final ELHIOParser m_parser = new ELHIOParser(m_termFactory);
	private static final Rewriter m_rewriter = new Rewriter();

	/**
	 * @param args
	 * 0 - query file
	 * 1 - ontology file
	 * 2 - output path
	 * 3 - mode (N|F|G)
	 */
	public static void main(String[] args) throws Exception{
		
		if(args.length == 4 && (args[3].equals("N") || args[3].equals("F") || args[3].equals("G"))){
			String queryFile = args[0];
			String ontologyFile = args[1];
			String outputFilePrefix = args[2];
			String mode = args[3];
			
			ArrayList<Clause> original = m_parser.getClauses(ontologyFile);
			
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
			
			printResultToFile(outputFilePrefix + "RQM" + mode + "-", queryFile, ontologyFile, end-begin, rewriting.size(), query.m_canonicalRepresentation, rewriting);
			
		}
		else{
			throw new Exception("Use: java Requiem query.txt ontology.owl outPath mode(N|F|G)");
		}
	}
	
	private static void printResultToFile(String outputFilestr, String queryFile, String ontologyFile, long time, int rewritingSize, String query, ArrayList<Clause> rewriting) throws Exception{
		int counter = 0;
		File outputFile = new File(outputFilestr + counter + ".txt");
		while (outputFile.exists()) {
			counter++;
			outputFile = new File(outputFilestr + counter + ".txt");
		}
		
        FileWriter out = new FileWriter(outputFile);
        out.write("==================SUMMARY==================\n");
        out.write("Ontology file:             " + ontologyFile.substring(ontologyFile.lastIndexOf("/") + 1) + "\n"); 
        out.write("Query:                     " + query + "\n");
        out.write("Running time:              " + time + " milliseconds \n");
		out.write("Size of the rewriting (queries):     " + rewritingSize + "\n");
		int size = 0;
		for(Clause c: rewriting){
			size += c.toString().length();
		}
		out.write("Size of the rewriting (symbols):     " + size + "\n");
		
		//System.out.println("Size of the rewriting (symbols): " + size + "\n");
		out.write("==================SUMMARY==================\n");
		Collections.sort(rewriting, new Comparator<Clause>(){
			public int compare(Clause c1, Clause c2){
			    return c1.m_canonicalRepresentation.compareTo(c2.m_canonicalRepresentation);
			}
		});
		int i = 0;
		for(Clause c: rewriting){
			out.write(i++ + ": " + c.m_canonicalRepresentation + "\n");
		}
		
        out.close();
	}

}
