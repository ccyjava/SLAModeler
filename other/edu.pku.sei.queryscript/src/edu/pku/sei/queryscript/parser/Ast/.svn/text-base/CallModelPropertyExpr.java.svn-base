package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 40: CallExpr ::= ModelPropertyExpr </b>
 */
public class CallModelPropertyExpr extends Ast implements ICallExpr {
	private IModelPropertyExpr _ModelPropertyExpr;

	public IModelPropertyExpr getModelPropertyExpr() {
		return _ModelPropertyExpr;
	}

	public CallModelPropertyExpr(IToken leftIToken, IToken rightIToken,
			IModelPropertyExpr _ModelPropertyExpr) {
		super(leftIToken, rightIToken);

		this._ModelPropertyExpr = _ModelPropertyExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CallModelPropertyExpr))
			return false;
		if (!super.equals(o))
			return false;
		CallModelPropertyExpr other = (CallModelPropertyExpr) o;
		if (!_ModelPropertyExpr.equals(other._ModelPropertyExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_ModelPropertyExpr.hashCode());
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
