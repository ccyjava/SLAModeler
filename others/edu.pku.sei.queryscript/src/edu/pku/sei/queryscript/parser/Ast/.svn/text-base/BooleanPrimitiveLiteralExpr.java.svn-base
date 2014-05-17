package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 36: PrimitiveLiteralExpr ::= true <li>Rule 37:
 * PrimitiveLiteralExpr ::= false </b>
 */
public class BooleanPrimitiveLiteralExpr extends AstToken implements
		IPrimitiveLiteralExpr {
	public BooleanPrimitiveLiteralExpr(IToken token) {
		super(token);
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
