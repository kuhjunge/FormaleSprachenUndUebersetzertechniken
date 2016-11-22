package ast;

import org.testng.annotations.Test;

import ast.ImplParser.RecursiveDecentParser;
import rekursiverAbstieg.Lexer;
import rekursiverAbstieg.RecursiveDecentLexer;

import org.testng.annotations.DataProvider;

public class ASTTestNG {
	final String end = "\n";

	@Test(dataProvider = "dp")
	public void f(String s) {
		Lexer lexer = new RecursiveDecentLexer(s);
		RecursiveDecentParser parser = new RecursiveDecentParser(lexer);
		HeteroAST ast = parser.statlist();
		System.out.println(ast.toStringTree());
	}

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { " 3 + 4 * 5" + this.end},
			new Object[] { " ( 3 + 4 ) * 5" + this.end},
			new Object[] { " 1 + 2  + (5 * 4) + 5" + this.end},
			new Object[] { " 10 / 2" + this.end},
			new Object[] { " 1 + 2 + 3" + this.end}, };
	}
}
