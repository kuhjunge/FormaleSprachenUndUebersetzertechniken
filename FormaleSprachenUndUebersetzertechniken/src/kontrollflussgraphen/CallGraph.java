package kontrollflussgraphen;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.MultiMap;
import org.antlr.v4.runtime.misc.OrderedHashSet;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.stringtemplate.v4.ST;

import kontrollflussgraphen.grammatik.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CallGraph {

	public static final String testinput = "char c;" + "\r\n" + "int x;" + "\r\n" + "int f1(int y, char d) {" + "\r\n"
			+ " int i;" + "\r\n" + " if (i!=0) {" + "\r\n" + " if (i==1) x=1;" + "\r\n" + " if (i==2) x=2;" + "\r\n"
			+ " if (i==3) x=3;" + "\r\n" + " }" + "\r\n" + " if (i==4) { y=4;} else {y=0;}" + "\r\n"
			+ " if (i==5) { y=5;}" + "\r\n" + " for (i=0; i<=3; i=i+1) {" + "\r\n" + " x=3;" + "\r\n" + " y=5;" + "\r\n"
			+ " }" + "\r\n" + "}" + "\r\n" + "int f2(int y, char d) {" + "\r\n" + " int j;" + "\r\n"
			+ " for (j=0; j<=3; j=j+1) {" + "\r\n" + " x=3;" + "\r\n" + " y=5;" + "\r\n" + " if (j==3) x=3; else y=1;"
			+ "\r\n" + " }" + "\r\n" + " if (i==4) { y=4;}" + "\r\n" + "}";

	public static final String testinput2 = "void a(int x) { int y; if (y == 3) { b(); c(); } else {y = 4;} "
			+ "for (i=0;i<=3;i=i+1){if(i==2) e(); d(); } }";

	/**
	 * A graph model of the output. Tracks call from one function to another by
	 * mapping function to list of called functions. E.g., f -> [g, h] Can dump
	 * DOT two ways (StringBuilder and ST). Sample output: digraph G { ... setup
	 * ... f -> g; g -> f; g -> h; h -> h; }
	 */
	static class Graph {
		// I'm using org.antlr.v4.runtime.misc: OrderedHashSet, MultiMap
		Set<String> nodes = new OrderedHashSet<String>(); // list of functions
		MultiMap<String, String> edges = // caller->callee
				new MultiMap<String, String>();

		public void edge(String source, String target) {
			edges.map(source, target);
		}

		public String toString() {
			return "edges: " + edges.toString() + ", functions: " + nodes;
		}

		public String toDOT() {
			StringBuilder buf = new StringBuilder();
			buf.append("digraph G {\n");
			buf.append("  ranksep=.25;\n");
			buf.append("  edge [arrowsize=.5]\n");
			buf.append("  node [fontname=\"ArialNarrow\",\n");
			buf.append("        fontsize=12];\n");
			buf.append("  ");
			for (String node : nodes) { // print all nodes first
				buf.append(node);
				buf.append("; ");
			}
			buf.append("\n");
			for (String src : edges.keySet()) {
				for (String trg : edges.get(src)) {
					buf.append("  ");
					buf.append(src);
					buf.append(" -> ");
					buf.append(trg);
					buf.append(";\n");
				}
			}
			buf.append("}\n");
			return buf.toString();
		}

		/**
		 * Fill StringTemplate: digraph G { rankdir=LR; <edgePairs:{edge|
		 * <edge.a> -> <edge.b>;}; separator="\n"> <childless:{f | <f>;};
		 * separator="\n"> }
		 * 
		 * Just as an example. Much cleaner than buf.append method
		 */
		public ST toST() {
			ST st = new ST("digraph G {\n" + "  ranksep=.25; \n" + "  edge [arrowsize=.5]\n"
					+ "  node [shape=circle, fontname=\"ArialNarrow\",\n"
					+ "        fontsize=12, fixedsize=true, height=.45];\n" + "  <funcs:{f | <f>; }>\n"
					+ "  <edgePairs:{edge| <edge.a> -> <edge.b>;}; separator=\"\\n\">\n" + "}\n");
			st.add("edgePairs", edges.getPairs());
			st.add("funcs", nodes);
			return st;
		}
	}

	static class FunctionListener extends CymbolBaseListener {
		Graph graph = new Graph();
		String currentFunctionName = null;
		int number = 0;
		List<String> lastIf = new ArrayList<>();
		boolean elsePart = false;
		final String rootName = "root";

		@Override
		public void enterFile(CymbolParser.FileContext ctx) {
			currentFunctionName = rootName;
			graph.nodes.add(currentFunctionName);
		}

		@Override
		public void enterVarDeclExtern(CymbolParser.VarDeclExternContext ctx) {
			putNodeIn(getName(ctx.getText()));
		}

		@Override
		public void enterFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
			currentFunctionName = rootName;
			putNodeIn(getName(ctx.ID().getText()));
		}

		@Override
		public void exitFunctionDecl(CymbolParser.FunctionDeclContext ctx) {
			currentFunctionName = rootName;
		}

		@Override
		public void enterNormalstat(CymbolParser.NormalstatContext ctx) {
			putNodeIn(getName(ctx.getText()));

		}

		private String getName(String name) {
			return "\"" + number++ + " " + name.replaceAll(";", "") + "\"";
		}

		private void putNodeIn(String str) {
			String oldFunctionName = currentFunctionName;
			currentFunctionName = str;
			graph.nodes.add(currentFunctionName);
			if (!graph.edges.containsKey(oldFunctionName)) {
				List<String> l = new ArrayList<>();
				l.add(currentFunctionName);
				graph.edges.put(oldFunctionName, l);
			} else {
				graph.edges.get(oldFunctionName).add(currentFunctionName);
			}
		}

		@Override
		public void enterIfelseStat(CymbolParser.IfelseStatContext ctx) {
			lastIf.add(currentFunctionName);
			currentFunctionName = lastIf.get(lastIf.size() - 2);
			elsePart = true;
		}

		@Override
		public void enterIfstat(CymbolParser.IfstatContext ctx) {
			lastIf.add(getName("if " + ctx.expr().getText()));
			// lastIf.add(getName("if"));
			putNodeIn(lastIf.get(lastIf.size() - 1));
		}

		@Override
		public void exitIfstat(CymbolParser.IfstatContext ctx) {
			String exitname = getName("iend");
			putNodeIn(exitname);
			if (elsePart == false) {
				graph.edges.get(lastIf.get(lastIf.size() - 1)).add(exitname);

			} else {
				elsePart = false;
				List<String> l = new ArrayList<>();
				l.add(exitname);
				graph.edges.put(lastIf.get(lastIf.size() - 1), l);
				lastIf.remove(lastIf.size() - 1);
			}
			lastIf.remove(lastIf.size() - 1);
		}

		@Override
		public void enterForstat(CymbolParser.ForstatContext ctx) {
			String name = getName("for");
			putNodeIn(name);
			lastIf.add(name);
			currentFunctionName = name;
		}

		@Override
		public void exitForstat(CymbolParser.ForstatContext ctx) {
			String exitNode = getName("f-end");
			List<String> l = new ArrayList<>();
			l.add(lastIf.get(lastIf.size() - 1));
			// Kante zwischen letzten Statement -> for
			graph.edges.put(currentFunctionName, l);
			// add exitNode
			currentFunctionName = lastIf.get(lastIf.size() - 1);
			putNodeIn(exitNode);
			lastIf.remove(lastIf.size() - 1);
		}

		@Override
		public void exitCall(CymbolParser.CallContext ctx) {
			String funcName = ctx.ID().getText();
			// map current function to the callee
			graph.edge(currentFunctionName, funcName);
		}
	}

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRInputStream(testinput.toCharArray(), testinput.length());
		CymbolLexer lexer = new CymbolLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CymbolParser parser = new CymbolParser(tokens);
		parser.setBuildParseTree(true);
		ParseTree tree = parser.file();
		// show tree in text form
		// System.out.println(tree.toStringTree(parser));

		ParseTreeWalker walker = new ParseTreeWalker();
		FunctionListener collector = new FunctionListener();
		walker.walk(collector, tree);
		// System.out.println(collector.graph.toString());
		System.out.println(collector.graph.toDOT());

		// Here's another example that uses StringTemplate to generate output
		// System.out.println(collector.graph.toST().render());
	}
}