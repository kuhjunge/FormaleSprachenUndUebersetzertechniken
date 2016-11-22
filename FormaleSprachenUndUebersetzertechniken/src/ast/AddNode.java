package ast;

import rekursiverAbstieg.Token;

public class AddNode extends BinaryNode {
    public AddNode(ExprNode left, Token addToken, ExprNode right) {
        super(left, addToken, right);
    }
}
