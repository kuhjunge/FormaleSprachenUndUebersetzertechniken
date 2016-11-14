package rekursiverAbstieg;

import static rekursiverAbstieg.RecursiveDecentLexer.*;

public class RecursiveDecentParser extends Parser {
	public RecursiveDecentParser(Lexer input) {
		super(input);
	}

	public void statlist() {
		do{		
			stat();
		}while( this.lookahead.type != EOF_TYPE);
	}

	public void stat() {
		if (this.lookahead.type == NL) {
			match(NL);
		} else {
			sum();
			match(NL);
		}
	}

	public void sum() {
		prod();
		while (this.lookahead.type == PLUS ||
				this.lookahead.type == MINUS) {
			if (this.lookahead.type == PLUS) {
				match(PLUS);
			} else if (this.lookahead.type == MINUS) {
				match(MINUS);
			} else {
				throw new Error("expecting PLUS or MINUS; found " + this.lookahead);
			}
			prod();
		}
	}
	
	public void prod() {
		term();
		while (this.lookahead.type == MULTI ||
				this.lookahead.type == DIV) {
			if (this.lookahead.type == MULTI) {
				match(MULTI);
			} else if (this.lookahead.type == DIV) {
				match(DIV);	
			} else {
				throw new Error("expecting MULTI or DIV; found " + this.lookahead);
			}
			term();
		}
	}

	public void term() {
		if (this.lookahead.type == PLUS) {
			match(PLUS);
			term();
		} else if (this.lookahead.type == MINUS) {
			match(MINUS);
			term();
		} else if (this.lookahead.type == LBRACK) {
			match(LBRACK);
			term();
			match(RBRACK);
		} else if (this.lookahead.type == INTEGER) {
			match(INTEGER);
		} else {
			throw new Error("expecting Integer RBRACK PLUS or MINUS; found " + this.lookahead);
		}
	}
}
