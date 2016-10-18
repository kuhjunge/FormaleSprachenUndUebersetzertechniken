package lexer;

import org.antlr.v4.runtime.*;



public class Test {
	public static void main(String[] args) throws Exception {
		CharStream input = null;
		// Pick an input stream (filename from commandline or stdin)
		if (args.length > 0){
			input = new ANTLRFileStream(args[0]);}
		else{
			//input = new ANTLRInputStream(System.in);
			}
		
		  ExprLexer lex = new ExprLexer(input);
		  Token t = lex.nextToken();
		  while (t.getType() != Token.EOF) {
			  //ExprLexer.EOF works as well
		  }
		  System.out.printf("%2d:%2d Typ-Code: %2d Lexem: %s\n",
				  t.getLine(),
				  t.getCharPositionInLine(),
				  t.getType(),
				  t.getText());
		  t = lex.nextToken();
	}
}