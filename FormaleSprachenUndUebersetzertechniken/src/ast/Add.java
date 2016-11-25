package ast;

import ast.visitor.IVisitor;
import rekursiverAbstieg.Token;

public class Add extends Binary {
    public Add(ExprNode left, Token addToken, ExprNode right) {
        super(left, addToken, right);
    }
    
    public <T> T accept(IVisitor<T> visitor) {
    	return visitor.visit(this); 
    }
}
