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
  public void f(String s, int erg) {
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
		new Object[] { " ( 3 + 4 ) * 5" + end,35},
		new Object[] { " 1 + 2  + (5 * 4) + 5" + end,28},
		new Object[] { "5+2" + end,7},
		new Object[] { "--3+7" + end,10},
		new Object[] { "3+-7*2" + end,-11},
		new Object[] { "2^2^3" + end,256},
		new Object[] { "2^2*2" + end,8},
		new Object[] { "3<5^2" + end,1},
		new Object[] { "2^8<10" + end,0},
		new Object[] { "a = 5+2" + end + "a+7" + end,14},
    };
  }
}
