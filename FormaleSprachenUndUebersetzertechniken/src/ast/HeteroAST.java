package ast;

import ast.visitor.IVisitor;
import rekursiverAbstieg.Token;

/***
 * Excerpted from "Language Implementation Patterns", published by The Pragmatic
 * Bookshelf. Copyrights apply to this code. It may not be used to create
 * training material, courses, books, articles, and the like. Contact us if you
 * are in doubt. We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/tpdsl for more book
 * information.
 ***/
public abstract class HeteroAST { // Heterogeneous AST node type
	protected Token token; // Node created from which token?
	
	public Token getToken(){
		return token;
	}

	public HeteroAST() {
	}

	public HeteroAST(Token t) {
		this.token = t;
	}

	/**
	 * Create node from token type; used mainly for imaginary tokens public
	 * HeteroAST(int tokenType) { this.token = new Token(tokenType); }
	 */
	
    public <T> T accept(IVisitor<T> visitor) {
    	return visitor.visit(this); 
    }

	/** Compute string for single node */
	@Override
	public String toString() {
		// return this.token.toString();
		return this.token.text;
	}

	/** Compute string for a whole tree not just node; default: print token */
	public String toStringTree() {
		return toString();
	}
}
