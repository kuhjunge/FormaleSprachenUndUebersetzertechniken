package rekursiverAbstieg;

/***
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic
 * Bookshelf. Copyrights apply to this code. It may not be used to create
 * training material, courses, books, articles, and the like. Contact us if you
 * are in doubt. We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book
 * information.
 ***/
public class TestLexer {
	public static void main(String[] args) {
		Lexer lexer = new RecursiveDecentLexer("10 + 20 \n");
		Token t = lexer.nextToken();
		while (t.type != Lexer.EOF_TYPE) {
			System.out.println(t);
			t = lexer.nextToken();
		}
		System.out.println(t); // EOF
	}
}
