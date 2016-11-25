package ast;

import ast.visitor.IVisitor;
import rekursiverAbstieg.Token;

public class UMinus extends Unary {

	public UMinus(ExprNode left, Token token) {
		super(left, token);
	}

    public <T> T accept(IVisitor<T> visitor) {
    	return visitor.visit(this); 
    }
}