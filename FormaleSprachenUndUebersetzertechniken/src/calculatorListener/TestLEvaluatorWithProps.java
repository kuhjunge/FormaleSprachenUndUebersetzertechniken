package calculatorListener;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import calculatorListener.grammatik.*;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TestLEvaluatorWithProps {
	/** Sample "calculator" using property of nodes */
	public static class EvaluatorWithProps extends LExprBaseListener {
		/** maps nodes to integers with Map<ParseTree,Integer> */
		ParseTreeProperty<Integer> values = new ParseTreeProperty<Integer>();
		Map<String, Integer> memory = new HashMap<String, Integer>();

		/** Need to pass e's value out of rule s : e ; */
		@Override
		public void exitPrintExpr(LExprParser.PrintExprContext ctx) {
			setValue(ctx, getValue(ctx.e())); // like: int s() { return e(); }
		}

		@Override
		public void exitAssign(LExprParser.AssignContext ctx) {
			String id = ctx.ID().getText(); // id is left-hand side of '='
			int value = getValue(ctx.e()); // compute value of expression on right
			memory.put(id, value); // store it in our memory
			setValue(ctx, value); // like: int s() { return e(); }
		}
		
		@Override
		public void exitParens(LExprParser.ParensContext ctx) {
			setValue(ctx, getValue(ctx.e())); 
		}

		@Override
		public void exitClear(LExprParser.ClearContext ctx) {
			memory = new HashMap<String, Integer>();
		}

		@Override
		public void exitVar(LExprParser.VarContext ctx) {
			int left = 0;
			String id = ctx.ID().getText();
			if (memory.containsKey(id)) {
				left = memory.get(id);
				System.out.println("test 3");
			}
			setValue(ctx, left);
			System.out.println("test 2");
		}

		@Override
		public void exitMain(LExprParser.MainContext ctx) {
			setValue(ctx,getValue(ctx.s().get(ctx.s().size() - 1)));
		}
		
		@Override
		public void exitDiv(LExprParser.DivContext ctx) {
			int left = getValue(ctx.e(0)); // e '*' e # Mult
			int right = getValue(ctx.e(1));
			setValue(ctx, left / right);
		}

		@Override
		public void exitMul(LExprParser.MulContext ctx) {
			int left = getValue(ctx.e(0)); // e '*' e # Mult
			int right = getValue(ctx.e(1));
			setValue(ctx, left * right);
		}

		@Override
		public void exitAdd(LExprParser.AddContext ctx) {
			int left = getValue(ctx.e(0)); // e '+' e # Add
			int right = getValue(ctx.e(1));
			setValue(ctx, left + right);
		}

		@Override
		public void exitSub(LExprParser.SubContext ctx) {
			int left = getValue(ctx.e(0)); // e '+' e # Add
			int right = getValue(ctx.e(1));
			setValue(ctx, left - right);
		}

		@Override
		public void exitMinus(LExprParser.MinusContext ctx) {
			int left = getValue(ctx.e()); // e '+' e # Add
			setValue(ctx, -left);
		}

		@Override
		public void exitSma(LExprParser.SmaContext ctx) {
			int left = getValue(ctx.e(0)); // e '+' e # Add
			int right = getValue(ctx.e(1));
			setValue(ctx, (left < right) ? 1 : 0);
		}

		@Override
		public void exitGre(LExprParser.GreContext ctx) {
			int left = getValue(ctx.e(0)); // e '+' e # Add
			int right = getValue(ctx.e(1));
			setValue(ctx, (left < right) ? 1 : 0);
		}

		@Override
		public void exitExp(LExprParser.ExpContext ctx) {
			int left = getValue(ctx.e(0)); // e '+' e # Add
			int right = getValue(ctx.e(1));
			setValue(ctx, (int) Math.pow(left, right));
		}

		@Override
		public void exitInt(LExprParser.IntContext ctx) {
			String intText = ctx.INT().getText(); // INT # Int
			setValue(ctx, Integer.valueOf(intText));
		}

		public void setValue(ParseTree node, int value) {
			values.put(node, value);
		}

		public int getValue(ParseTree node) {
			return values.get(node);
		}
	}

	public static void main(String[] args) throws Exception {
		String inputFile = null;
		if (args.length > 0)
			inputFile = args[0];
		InputStream is = System.in;
		if (inputFile != null) {
			is = new FileInputStream(inputFile);
		}
		ANTLRInputStream input = new ANTLRInputStream(is);
		LExprLexer lexer = new LExprLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		LExprParser parser = new LExprParser(tokens);
		parser.setBuildParseTree(true); // tell ANTLR to build a parse tree
		ParseTree tree = parser.s(); // parse
		// show tree in text form
		System.out.println(tree.toStringTree(parser));

		ParseTreeWalker walker = new ParseTreeWalker();
		EvaluatorWithProps evalProp = new EvaluatorWithProps();
		walker.walk(evalProp, tree);
		System.out.println("properties result = " + evalProp.getValue(tree));
	}
}