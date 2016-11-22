package ast;

import rekursiverAbstieg.Token;

public class MulNode extends BinaryNode {

	public MulNode(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);
	}
}
