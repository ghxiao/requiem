package org.oxford.comlab.requiem.parser;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.oxford.comlab.requiem.rewriter.Clause;
import org.oxford.comlab.requiem.rewriter.TermFactory;
import org.semanticweb.HermiT.Reasoner.Configuration;
import org.semanticweb.HermiT.owlapi.structural.OwlNormalization;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLException;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;


/**
 * Converts an ontology and a query into a set of clauses.
 */

public class ELHIOParser {
	
	private TermFactory m_termFactory;
	private OWLOntology ontology;
	
	public ELHIOParser(TermFactory termFactory){
		this.m_termFactory = termFactory;
	}
	
	/**
	 * Reads an ontology from the file specified by 'path' and 
	 * returns a list of clauses representing the ontology.
	 * @param path the ontology to be converted.
	 * @return a set of clauses representing the ontology.
	 * @throws OWLException
	 */
	public ArrayList<Clause> getClauses(String path) throws Exception
	{
		//System.out.println(path);
		//Create ontology manager and load ontology (OWL API)
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();		
		URI physicalURI = URI.create(path);
        ontology = manager.loadOntologyFromPhysicalURI(physicalURI);
         
        //Normalize ontology (HermiT)
        OwlNormalization normalization = new OwlNormalization(manager.getOWLDataFactory());
        normalization.processOntology(new Configuration(), ontology);

        //Clausify ontology
        ELHIOClausifier clausification = new ELHIOClausifier(this.m_termFactory, manager);
        ArrayList<Clause> clauses = clausification.getClauses(normalization);
        
        //Remove ontology from the ontology manager
        manager.removeOntology(ontology.getURI());
        
		return clauses;
	}
	
	/**
	 * Reads a query from the file specified by 'path' and 
	 * returns a clause representing the query (based on ANTLR).
	 * @param path the query to be converted.
	 * @return a clause representing the query.
	 * @throws Exception
	 */
	public Clause getQueryFromFile(String path) throws Exception{
		
		BufferedReader reader = new BufferedReader(new FileReader(path));
		
		String input;
		do{
			input = reader.readLine();
		}while(input.indexOf("//") == 0);
		
		ConjunctiveQueriesParser parser;
		byte currentBytes[] = input.getBytes();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(currentBytes);
		ANTLRInputStream inputst = null;
		
		try {
			inputst = new ANTLRInputStream(byteArrayInputStream);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			return null;
		}
		
		ConjunctiveQueriesLexer lexer = new ConjunctiveQueriesLexer(inputst);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ConjunctiveQueriesParser(tokens);
		
		try {
			parser.parse();
		} catch (Exception e) {
			return null;
		}
		
		if ((parser.getErrors().size() == 0) && (lexer.getErrors().size() == 0)) {
			return parser.getQuery();
		} else {
			return null;
		}
	}
	
	public Clause getQuery(String query) throws Exception{
		
		ConjunctiveQueriesParser parser;
		byte currentBytes[] = query.getBytes();
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(currentBytes);
		ANTLRInputStream inputst = null;
		
		try {
			inputst = new ANTLRInputStream(byteArrayInputStream);
		} catch (IOException e) {
			e.printStackTrace(System.err);
			return null;
		}
		
		ConjunctiveQueriesLexer lexer = new ConjunctiveQueriesLexer(inputst);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		parser = new ConjunctiveQueriesParser(tokens);
		
		try {
			parser.parse();
		} catch (Exception e) {
			return null;
		}
		
		if ((parser.getErrors().size() == 0) && (lexer.getErrors().size() == 0)) {
			return parser.getQuery();
		} else {
			return null;
		}
	}
	
	public int getNumberOfAxioms(){
	    return ontology == null? null: ontology.getAxioms().size();
	}
	
	public int getNumberOfConcepts(){
		return ontology == null? null: ontology.getReferencedClasses().size();
	}
	
	public int getNumberOfRoles(){
		return ontology == null? null: ontology.getReferencedObjectProperties().size();
	}

}
