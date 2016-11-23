package ast;

import rekursiverAbstieg.Token;

public class Sub extends Binary {
	public Sub(ExprNode left, Token addToken, ExprNode right) {
		super(left, addToken, right);
	}
}
