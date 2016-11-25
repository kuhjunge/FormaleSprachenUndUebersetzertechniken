package ast;

import ast.visitor.IVisitor;
import rekursiverAbstieg.Token;

public class Div extends Binary {

	public Div(ExprNode left, Token token, ExprNode right) {
		super(left, token, right);	}

    public <T> T accept(IVisitor<T> visitor) {
    	return visitor.visit(this); 
    }
}