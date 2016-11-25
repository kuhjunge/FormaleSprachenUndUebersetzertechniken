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
public class Int extends ExprNode {
	public Int(Token t) {
		super(t);
	}
	
	public int getValue(){
		return Integer.parseInt(token.text);
	}

    public <T> T accept(IVisitor<T> visitor) {
    	return visitor.visit(this); 
    }
}