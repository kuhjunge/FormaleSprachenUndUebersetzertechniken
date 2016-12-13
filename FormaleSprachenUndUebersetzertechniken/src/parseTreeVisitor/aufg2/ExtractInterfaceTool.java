package parseTreeVisitor.aufg2;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.*;

import parseTreeVisitor.aufg2.grammar.*;

import java.io.FileInputStream;
import java.io.InputStream;

public class ExtractInterfaceTool {
	public static void main(String[] args) throws Exception {

		String s = "import java.util.List;" + "\n" + "import java.util.Map;" + "\n" + "public class Demo {" + "\n"
				+ "void f(int x, String y) { }" + "\n" + "int[ ] g(/*no args*/) { return null; }" + "\n"
				+ "List<Map<String, Integer>>[] h() { return null; }" + "\n" + "}";

		ANTLRInputStream input = new ANTLRInputStream(s.toCharArray(), s.length());
		JavaLexer lexer = new JavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		ParseTree tree = parser.compilationUnit(); // parse

		ParseTreeWalker walker = new ParseTreeWalker(); // create standard
														// walker
		ExtractInterfaceListener extractor = new ExtractInterfaceListener(parser);
		walker.walk(extractor, tree); // initiate walk of tree with listener
	}
}