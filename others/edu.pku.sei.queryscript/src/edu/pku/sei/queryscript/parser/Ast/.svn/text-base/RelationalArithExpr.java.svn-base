package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 24: RelationalExpr ::= ArithExpr </b>
 */
public class RelationalArithExpr extends Ast implements IRelationalExpr {
	private IArithExpr _ArithExpr;

	public IArithExpr getArithExpr() {
		return _ArithExpr;
	}

	public RelationalArithExpr(IToken leftIToken, IToken rightIToken,
			IArithExpr _ArithExpr) {
		super(leftIToken, rightIToken);

		this._ArithExpr = _ArithExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof RelationalArithExpr))
			return false;
		if (!super.equals(o))
			return false;
		RelationalArithExpr other = (RelationalArithExpr) o;
		if (!_ArithExpr.equals(other._ArithExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_ArithExpr.hashCode());
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
