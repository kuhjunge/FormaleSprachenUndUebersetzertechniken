package calculator;

import org.testng.annotations.Test;

import calculator.grammatik.*;
import calculator.interpreterGrammatik.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class CalculatorTestNG {
  final String end = "\n";
	
  @Test(dataProvider = "dp")
  public void f(String s, int erg) {
	  int localErg =0;
      ANTLRInputStream input = new ANTLRInputStream(s.toCharArray(), s.length());
      LabeledExprLexer lexer = new LabeledExprLexer(input);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      LabeledExprParser parser = new LabeledExprParser(tokens);
      localErg = new EvalVisitor().visit(parser.prog());
      Assert.assertTrue(erg == localErg);
  }

  @Test(dataProvider = "dp")
  public void f2(String s, int erg) {
      ANTLRInputStream input = new ANTLRInputStream(s.toCharArray(), s.length());
      ExprParser parser = new ExprParser(null); // share single parser instance
      parser.setBuildParseTree(false); 
      ExprLexer lexer = new ExprLexer(input);
      lexer.setLine(0);           // notify lexer of input position
      lexer.setCharPositionInLine(0);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      parser.setInputStream(tokens); // notify parser of new token stream
      parser.prog();                 // start the parser
      System.out.println(erg + " <- " + s);
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
		new Object[] { "a = 5+2" + end  + "#" + end+ "a+7" + end,7},
		new Object[] { "195" + end + "a = 5" + end + "b = 6" + end + "c = 2*a - b" + end + "(a+b)* c" + end ,44}, // Jan-Erik Test (195 & 44)
    };
  }
}

