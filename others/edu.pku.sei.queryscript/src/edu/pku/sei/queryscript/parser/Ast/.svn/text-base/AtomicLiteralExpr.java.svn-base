package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 28: AtomicExpr ::= LiteralExpr </b>
 */
public class AtomicLiteralExpr extends Ast implements IAtomicExpr {
	private ILiteralExpr _LiteralExpr;

	public ILiteralExpr getLiteralExpr() {
		return _LiteralExpr;
	}

	public AtomicLiteralExpr(IToken leftIToken, IToken rightIToken,
			ILiteralExpr _LiteralExpr) {
		super(leftIToken, rightIToken);

		this._LiteralExpr = _LiteralExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AtomicLiteralExpr))
			return false;
		if (!super.equals(o))
			return false;
		AtomicLiteralExpr other = (AtomicLiteralExpr) o;
		if (!_LiteralExpr.equals(other._LiteralExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LiteralExpr.hashCode());
		return hash;
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
