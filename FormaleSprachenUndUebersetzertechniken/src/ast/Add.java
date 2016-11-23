package ast;

import rekursiverAbstieg.Token;

public class Add extends Binary {
    public Add(ExprNode left, Token addToken, ExprNode right) {
        super(left, addToken, right);
    }
}
