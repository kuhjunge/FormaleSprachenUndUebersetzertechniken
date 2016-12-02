package calculator;

import org.testng.annotations.Test;

import calculator.grammatik.LabeledExprLexer;
import calculator.grammatik.LabeledExprParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.DataProvider;

public class CalculatorTestNG {
  @Test(dataProvider = "dp")
  public void f(String s) {
      ANTLRInputStream input = new ANTLRInputStream(s.toCharArray(), s.length());
      LabeledExprLexer lexer = new LabeledExprLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      LabeledExprParser parser = new LabeledExprParser(tokens);
      ParseTree tree = parser.prog(); // parse
      EvalVisitor eval = new EvalVisitor();
      System.out.println("Ergebnis: " + eval.visit(tree));
  }

  @DataProvider
  public Object[][] dp() {
	  final String end = "\n";
    return new Object[][] {
		new Object[] { " ( 3 + 4 ) * 5" + end},
		new Object[] { " 1 + 2  + (5 * 4) + 5" + end},
    };
  }
}
