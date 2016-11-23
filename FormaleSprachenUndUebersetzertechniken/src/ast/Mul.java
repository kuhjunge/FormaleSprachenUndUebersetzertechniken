package ast;

import rekursiverAbstieg.Token;

public class Mul extends Binary {

	public Mul(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);
	}
}
