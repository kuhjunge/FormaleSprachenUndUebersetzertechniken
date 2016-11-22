package rekursiverAbstieg;

/***
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic
 * Bookshelf. Copyrights apply to this code. It may not be used to create
 * training material, courses, books, articles, and the like. Contact us if you
 * are in doubt. We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book
 * information.
 ***/
public abstract class Parser {
	private Lexer input; // from where do we get tokens?
	protected Token lookahead; // the current lookahead token

	public Parser(Lexer input) {
		this.input = input;
		consume();
	}

	/** If lookahead token type matches x, consume & return else error */
	public void match(int x) {
		if (this.lookahead.type == x) {
			consume();
		} else {
			throw new Error("expecting " + this.input.getTokenName(x) + "; found " + this.lookahead);
		}
	}

	public void consume() {
		this.lookahead = this.input.nextToken();
	}
}