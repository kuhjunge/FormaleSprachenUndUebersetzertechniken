package ast.visitor;

import ast.Add;
import ast.Div;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;

public class ToStringVisitorNT implements IVisitor<String> {
	
	public String printNodeType(HeteroAST n){
		return n.accept(this);
	}

	@Override
	public String visit(HeteroAST en) {
		return en.toString();
	}

	@Override
	public String visit(Add n) {
		return "("+ n.getLeft().accept(this) + n.toString() + n.getRight().accept(this) + ")";
	}

	@Override
	public String visit(Sub n) {
		return "("+ n.getLeft().accept(this) + n.toString() + n.getRight().accept(this) + ")";
	}

	@Override
	public String visit(UMinus n) {
		return "(" + n.toString() + n.getLeft().accept(this) +  ")";
	}

	@Override
	public String visit(Mul n) {
		return "("+ n.getLeft().accept(this) + n.toString() + n.getRight().accept(this) + ")";
	}

	@Override
	public String visit(Div n) {
		return "("+ n.getLeft().accept(this) + n.toString() + n.getRight().accept(this) + ")";
	}

	@Override
	public String visit(Int n) {
		return n.toString();
	}

}
