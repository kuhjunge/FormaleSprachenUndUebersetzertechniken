package ueberdeckungstest;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import kontrollflussgraphen.CallGraph;
import kontrollflussgraphen.grammatik.*;

public class TestMetrics {
	
	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(CallGraph.testinput.toCharArray(), CallGraph.testinput.length());
		CymbolLexer lexer = new CymbolLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CymbolParser parser = new CymbolParser(tokens);
		ParseTree tree = parser.file();

		ParseTreeWalker walker = new ParseTreeWalker(); // create standard
														// walker
		MetricsListener extractor = new MetricsListener();
		walker.walk(extractor, tree);
	}
}
