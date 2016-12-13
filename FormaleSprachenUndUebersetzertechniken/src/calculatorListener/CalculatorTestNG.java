package calculatorListener;

import org.testng.annotations.Test;

import calculatorListener.TestLEvaluatorWithProps.EvaluatorWithProps;
import calculatorListener.grammatik.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CalculatorTestNG {
  final String end = "\n";
	
  @Test(dataProvider = "dp")
  public void f(String s, int erg) {
	  int localErg =0;
      ANTLRInputStream input = new ANTLRInputStream(s.toCharArray(), s.length());
      LExprLexer lexer = new LExprLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      LExprParser parser = new LExprParser(tokens);
      parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
      ParseTree tree = parser.p(); // parse
      // show tree in text form
      System.out.println(tree.toStringTree(parser));

      ParseTreeWalker walker = new ParseTreeWalker();
      EvaluatorWithProps evalProp = new EvaluatorWithProps();
      walker.walk(evalProp, tree);
      localErg = evalProp.getValue(tree);
      System.out.println(localErg + " = " + erg);
      Assert.assertTrue(erg == localErg);
  }
  
  @DataProvider
  public Object[][] dp() {

    return new Object[][] {
    	new Object[] { " 5 * 5" + end,25},
    	new Object[] { " ( 3 + 4 ) * 5" + end,35},
    	new Object[] { " 3 + 4 * 5" + end,23},
		new Object[] { " 1 + 2  + (5 * 4) + 5" + end,28},
		new Object[] { "5+2" + end,7},
		new Object[] { "--3+7" + end,10},
		new Object[] { "3+-7*2" + end,-11},
		new Object[] { "2^2^3" + end,256},
		new Object[] { "2^2*2" + end,8},
		new Object[] { "3<5^2" + end,1},
		new Object[] { "2^8<10" + end,0},
		new Object[] { "a = 5+2" + end + "a+7" + end,14},
		new Object[] { "a" + end,0},
		new Object[] { "a = 5+2" + end  + "#" + end+ "a+7" + end,7},
		new Object[] { "195" + end + "a = 5" + end + "b = 6" + end + "c = 2*a - b" + end + "(a+b)* c" + end ,44}, // Jan-Erik Test (195 & 44)
    };
  }
}

