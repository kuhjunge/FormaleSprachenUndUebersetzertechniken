package ast;

import rekursiverAbstieg.Token;

public class UnaryNode extends ExprNode {
	private ExprNode left;

	public UnaryNode(ExprNode left, Token token) {
		super(token);
		this.left = left;
	}

	@Override
	public String toStringTree() {
		if (this.left == null)
			return this.toString();
		StringBuilder buf = new StringBuilder();
		buf.append("(");
		buf.append(this.toString());
		buf.append(' ');
		buf.append(this.left.toStringTree());		
		buf.append(")");
		return buf.toString();
	}

	public ExprNode getLeft(){
		return this.left;
	}
}
