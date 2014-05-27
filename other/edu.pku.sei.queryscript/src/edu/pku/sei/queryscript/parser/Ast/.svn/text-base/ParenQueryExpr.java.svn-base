package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 32: AtomicExpr ::= ( QueryExpr ) </b>
 */
public class ParenQueryExpr extends Ast implements IAtomicExpr {
	private IQueryExpr _QueryExpr;

	public IQueryExpr getQueryExpr() {
		return _QueryExpr;
	}

	public ParenQueryExpr(IToken leftIToken, IToken rightIToken,
			IQueryExpr _QueryExpr) {
		super(leftIToken, rightIToken);

		this._QueryExpr = _QueryExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ParenQueryExpr))
			return false;
		if (!super.equals(o))
			return false;
		ParenQueryExpr other = (ParenQueryExpr) o;
		if (!_QueryExpr.equals(other._QueryExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_QueryExpr.hashCode());
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
