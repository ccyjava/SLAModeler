package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 31: AtomicExpr ::= CallExpr </b>
 */
public class AtomicCallExpr extends Ast implements IAtomicExpr {
	private ICallExpr _CallExpr;

	public ICallExpr getCallExpr() {
		return _CallExpr;
	}

	public AtomicCallExpr(IToken leftIToken, IToken rightIToken,
			ICallExpr _CallExpr) {
		super(leftIToken, rightIToken);

		this._CallExpr = _CallExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AtomicCallExpr))
			return false;
		if (!super.equals(o))
			return false;
		AtomicCallExpr other = (AtomicCallExpr) o;
		if (!_CallExpr.equals(other._CallExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_CallExpr.hashCode());
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
