package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 12: ParametersExpr ::= $Empty </b>
 */
public class EmptyParameterExpr extends Ast implements IParametersExpr {
	public EmptyParameterExpr(IToken leftIToken, IToken rightIToken) {
		super(leftIToken, rightIToken);

		initialize();
	}

	public void accept(Visitor v) {
		v.visit(this);
	}

	public void accept(ArgumentVisitor v, Object o) {
		v.visit(this, o);
	}

	public Object accept(ResultVisitor v) {
		return v.visit(this);
	}

	public Object accept(ResultArgumentVisitor v, Object o) {
		return v.visit(this, o);
	}
}
