package ast.visitor;

import ast.Add;
import ast.Div;
import ast.HeteroAST;
import ast.Int;
import ast.Mul;
import ast.Sub;
import ast.UMinus;

public class evalVisitorNT implements IVisitor<Double> {
	
	public Double evalNodeType(HeteroAST n){
		return n.accept(this);
	}

	@Override
	public Double visit(HeteroAST en) {
		return 0.0;
	}

	@Override
	public Double visit(Add n) {
		return  n.getLeft().accept(this) + n.getRight().accept(this);
	}

	@Override
	public Double visit(Sub n) {
		return  n.getLeft().accept(this) - n.getRight().accept(this);
	}

	@Override
	public Double visit(UMinus n) {
		return  - n.getLeft().accept(this);
	}

	@Override
	public Double visit(Mul n) {
		return n.getLeft().accept(this) * n.getRight().accept(this);
	}

	@Override
	public Double visit(Div n) {
		return n.getLeft().accept(this) / n.getRight().accept(this);
	}

	@Override
	public Double visit(Int n) {
		return (double) n.getValue();
	}

}
