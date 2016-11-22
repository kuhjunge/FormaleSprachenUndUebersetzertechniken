package ast;

import rekursiverAbstieg.Token;

public class DivNode extends BinaryNode {

	public DivNode(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);	}

}