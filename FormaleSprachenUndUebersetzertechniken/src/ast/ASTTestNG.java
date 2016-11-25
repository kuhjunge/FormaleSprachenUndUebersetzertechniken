package ast;

import org.testng.annotations.Test;

import ast.implParser.RecursiveDecentParser;
import ast.visitor.IVisitor;
import ast.visitor.ToStringVisitorNT;
import ast.visitor.evalVisitorNT;
import rekursiverAbstieg.Lexer;
import rekursiverAbstieg.RecursiveDecentLexer;

import org.testng.annotations.DataProvider;

public class ASTTestNG {
	final String end = "\n";
	
	@Test(dataProvider = "dp")
	public void testStringVisitor(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		IVisitor<String> visitor = new ToStringVisitorNT();
		System.out.println("SV: " + ast.accept(visitor));
	}
	
	@Test(dataProvider = "dp")
	public void testEvalVisitor(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		IVisitor<Double> visitor = new evalVisitorNT();
		System.out.println("EV: " + ast.accept(visitor));
	}
	
	@Test(dataProvider = "dp")
	public void testStringVisitorTokenType(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		ToStringVisitorNT visitor = new ToStringVisitorNT();
		System.out.println("STT: " + visitor.printTokenType(ast));
	}
	
	@Test(dataProvider = "dp")
	public void testEvalVisitorTokenType(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		evalVisitorNT visitor = new evalVisitorNT();
		System.out.println("ETT: " + visitor.evalTokenType(ast));
	}

	@Test(dataProvider = "dp")
	public void testStringVisitorNodeType(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		ToStringVisitorNT visitor = new ToStringVisitorNT();
		System.out.println("SNT: " + visitor.printNodeType(ast));
	}
	
	@Test(dataProvider = "dp")
	public void testEvalVisitorNodeType(String s){
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		evalVisitorNT visitor = new evalVisitorNT();
		System.out.println("SET: " + visitor.evalNodeType(ast));
	}
	
	@Test(dataProvider = "dp")
	public void f(String s) {
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		System.out.println(ast.toStringTree());
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] {
			new Object[] { "10 - 20 " + this.end },
			new Object[] { "10 + 20 " + this.end },
			new Object[] { "10 - 22 " + this.end },
			new Object[] { "10 * 20 " + this.end },
			new Object[] { "10 / 20 " + this.end },
			new Object[] { "#20  " + this.end },
			new Object[] { "5 + (10 - 23)" + this.end },
			new Object[] { "(10 - 23)" + this.end },
			new Object[] { "1 + 2 + 3" + this.end },
			new Object[] { "		 20 	 " + this.end },
			new Object[] { "(10 - 20) * 525" + this.end },
			new Object[] { " 1 * 2 * 3" + this.end},
			new Object[] { " 3 + 4 * 5" + this.end},
			new Object[] { " ( 3 + 4 ) * 5" + this.end},
			new Object[] { " 1 + 2  + (5 * 4) + 5" + this.end},
			new Object[] { " 10 / 2" + this.end},
			new Object[] { " 1 + 2 + 3" + this.end},
			new Object[] { " 1 - 2 - 3" + this.end},
			new Object[] { " 1 / 2 / 3" + this.end},
			new Object[] { " 10 + 22  + (45 * 84) + 55 / #54" + this.end},
			};
	}
}
