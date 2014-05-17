package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 23: RelationalExpr ::= ArithExpr$LeftArithExpr <
 * ArithExpr$RightArithExpr </b>
 */
public class LessExpr extends Ast implements IRelationalExpr {
	private IArithExpr _LeftArithExpr;
	private IArithExpr _RightArithExpr;

	public IArithExpr getLeftArithExpr() {
		return _LeftArithExpr;
	}

	public IArithExpr getRightArithExpr() {
		return _RightArithExpr;
	}

	public LessExpr(IToken leftIToken, IToken rightIToken,
			IArithExpr _LeftArithExpr, IArithExpr _RightArithExpr) {
		super(leftIToken, rightIToken);

		this._LeftArithExpr = _LeftArithExpr;
		this._RightArithExpr = _RightArithExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof LessExpr))
			return false;
		if (!super.equals(o))
			return false;
		LessExpr other = (LessExpr) o;
		if (!_LeftArithExpr.equals(other._LeftArithExpr))
			return false;
		if (!_RightArithExpr.equals(other._RightArithExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LeftArithExpr.hashCode());
		hash = hash * 31 + (_RightArithExpr.hashCode());
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
