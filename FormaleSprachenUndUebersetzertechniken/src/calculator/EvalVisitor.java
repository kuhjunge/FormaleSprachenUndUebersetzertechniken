package calculator;

/***
 * Excerpted from "The Definitive ANTLR 4 Reference",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/tpantlr2 for more book information.
***/
import java.util.HashMap;
import java.util.Map;

import calculator.grammatik.*;

public class EvalVisitor extends LabeledExprBaseVisitor<Integer> {
	/** "memory" for our calculator; variable/value pairs go here */
	Map<String, Integer> memory = new HashMap<String, Integer>();

	/** ID '=' expr NEWLINE */
	@Override
	public Integer visitAssign(LabeledExprParser.AssignContext ctx) {
		String id = ctx.ID().getText(); // id is left-hand side of '='
		int value = visit(ctx.expr()); // compute value of expression on right
		memory.put(id, value); // store it in our memory
		return value;
	}

	/** expr NEWLINE */
	@Override
	public Integer visitPrintExpr(LabeledExprParser.PrintExprContext ctx) {
		Integer value = visit(ctx.expr()); // evaluate the expr child
		System.out.println(value);
		return value; // return dummy value
	}

	/** INT */
	@Override
	public Integer visitInt(LabeledExprParser.IntContext ctx) {
		return Integer.valueOf(ctx.INT().getText());
	}

	/** ID */
	@Override
	public Integer visitId(LabeledExprParser.IdContext ctx) {
		String id = ctx.ID().getText();
		if (memory.containsKey(id))
			return memory.get(id);
		return 0;
	}

	/** expr op=('*'|'/') expr */
	@Override
	public Integer visitMulDiv(LabeledExprParser.MulDivContext ctx) {
		int left = visit(ctx.expr(0)); // get value of left subexpression
		int right = visit(ctx.expr(1)); // get value of right subexpression
		if (ctx.op.getType() == LabeledExprParser.MUL)
			return left * right;
		return left / right; // must be DIV
	}

	/** expr op=('+'|'-') expr */
	@Override
	public Integer visitAddSub(LabeledExprParser.AddSubContext ctx) {
		int left = visit(ctx.expr(0)); // get value of left subexpression
		int right = visit(ctx.expr(1)); // get value of right subexpression
		if (ctx.op.getType() == LabeledExprParser.ADD)
			return left + right;
		return left - right; // must be SUB
	}

	/** expr op=('<'|'>') expr */
	@Override
	public Integer visitSmaGre(LabeledExprParser.SmaGreContext ctx) {
		int left = visit(ctx.expr(0)); // get value of left subexpression
		int right = visit(ctx.expr(1)); // get value of right subexpression
		if (ctx.op.getType() == LabeledExprParser.GRE) {
			if (left > right) {
				return 1;
			} else {
				return 0;
			}
		}
		if (left < right) {
			return 1;
		} else {
			return 0;
		}
	}

	/** expr op=('+'|'-') expr */
	@Override
	public Integer visitSub(LabeledExprParser.SubContext ctx) {
		int left = visit(ctx.expr()); // get value of left subexpression
		return -left; // must be SUB
	}

	/** expr op=('^') expr */
	@Override
	public Integer visitExp(LabeledExprParser.ExpContext ctx) {
		int left = visit(ctx.expr(0)); // get value of left subexpression
		int right = visit(ctx.expr(1)); // get value of right subexpression
		return (int) Math.pow(left, right);
	}

	@Override
	public Integer visitClear(LabeledExprParser.ClearContext ctx){
		memory.clear();
		return 0;
	} 

	/** '(' expr ')' */
	@Override
	public Integer visitParens(LabeledExprParser.ParensContext ctx) {
		return visit(ctx.expr()); // return child expr's value
	}
}
