package ast.visitor;

import ast.*;

public interface IVisitor<T> {
	T visit(HeteroAST en);

	T visit(Add n);
	
	T visit(Sub n);

	T visit(UMinus n);

	T visit(Mul n);

	T visit(Div n);

	T visit(Int n);
}
