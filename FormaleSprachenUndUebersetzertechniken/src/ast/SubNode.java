package ast;

import rekursiverAbstieg.Token;

public class SubNode extends BinaryNode {
	public SubNode(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);
	}
}
