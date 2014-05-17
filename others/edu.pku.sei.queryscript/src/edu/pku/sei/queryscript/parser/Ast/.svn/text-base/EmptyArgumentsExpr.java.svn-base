package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 47: ArgumentsExpr ::= $Empty </b>
 */
public class EmptyArgumentsExpr extends Ast implements IArgumentsExpr {
	public EmptyArgumentsExpr(IToken leftIToken, IToken rightIToken) {
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
