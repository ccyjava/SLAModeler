package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 29: AtomicExpr ::= VariableExpr </b>
 */
public class AtomicVariableExpr extends Ast implements IAtomicExpr {
	private SimpleName _VariableExpr;

	public SimpleName getVariableExpr() {
		return _VariableExpr;
	}

	public AtomicVariableExpr(IToken leftIToken, IToken rightIToken,
			SimpleName _VariableExpr) {
		super(leftIToken, rightIToken);

		this._VariableExpr = _VariableExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AtomicVariableExpr))
			return false;
		if (!super.equals(o))
			return false;
		AtomicVariableExpr other = (AtomicVariableExpr) o;
		if (!_VariableExpr.equals(other._VariableExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_VariableExpr.hashCode());
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
