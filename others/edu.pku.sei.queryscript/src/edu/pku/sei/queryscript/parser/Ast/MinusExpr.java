package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 26: ArithExpr ::= ArithExpr - AtomicExpr </b>
 */
public class MinusExpr extends Ast implements IArithExpr {
	private IArithExpr _ArithExpr;
	private IAtomicExpr _AtomicExpr;

	public IArithExpr getArithExpr() {
		return _ArithExpr;
	}

	public IAtomicExpr getAtomicExpr() {
		return _AtomicExpr;
	}

	public MinusExpr(IToken leftIToken, IToken rightIToken,
			IArithExpr _ArithExpr, IAtomicExpr _AtomicExpr) {
		super(leftIToken, rightIToken);

		this._ArithExpr = _ArithExpr;
		this._AtomicExpr = _AtomicExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof MinusExpr))
			return false;
		if (!super.equals(o))
			return false;
		MinusExpr other = (MinusExpr) o;
		if (!_ArithExpr.equals(other._ArithExpr))
			return false;
		if (!_AtomicExpr.equals(other._AtomicExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_ArithExpr.hashCode());
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
