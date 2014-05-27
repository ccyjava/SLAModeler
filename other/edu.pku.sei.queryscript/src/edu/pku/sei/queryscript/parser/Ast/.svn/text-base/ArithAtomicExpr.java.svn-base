package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 27: ArithExpr ::= AtomicExpr </b>
 */
public class ArithAtomicExpr extends Ast implements IArithExpr {
	private IAtomicExpr _AtomicExpr;

	public IAtomicExpr getAtomicExpr() {
		return _AtomicExpr;
	}

	public ArithAtomicExpr(IToken leftIToken, IToken rightIToken,
			IAtomicExpr _AtomicExpr) {
		super(leftIToken, rightIToken);

		this._AtomicExpr = _AtomicExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ArithAtomicExpr))
			return false;
		if (!super.equals(o))
			return false;
		ArithAtomicExpr other = (ArithAtomicExpr) o;
		if (!_AtomicExpr.equals(other._AtomicExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_AtomicExpr.hashCode());
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
