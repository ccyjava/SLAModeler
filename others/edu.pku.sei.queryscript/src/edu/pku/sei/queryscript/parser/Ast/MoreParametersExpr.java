package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 11: ParametersExpr ::= ParametersExpr , VariableDeclaration </b>
 */
public class MoreParametersExpr extends Ast implements IParametersExpr {
	private IParametersExpr _ParametersExpr;
	private VariableDeclaration _VariableDeclaration;

	/**
	 * The value returned by <b>getParametersExpr</b> may be <b>null</b>
	 */
	public IParametersExpr getParametersExpr() {
		return _ParametersExpr;
	}

	public VariableDeclaration getVariableDeclaration() {
		return _VariableDeclaration;
	}

	public MoreParametersExpr(IToken leftIToken, IToken rightIToken,
			IParametersExpr _ParametersExpr,
			VariableDeclaration _VariableDeclaration) {
		super(leftIToken, rightIToken);

		this._ParametersExpr = _ParametersExpr;
		this._VariableDeclaration = _VariableDeclaration;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof MoreParametersExpr))
			return false;
		if (!super.equals(o))
			return false;
		MoreParametersExpr other = (MoreParametersExpr) o;
		if (_ParametersExpr == null)
			if (other._ParametersExpr != null)
				return false;
			else
				; // continue
		else if (!_ParametersExpr.equals(other._ParametersExpr))
			return false;
		if (!_VariableDeclaration.equals(other._VariableDeclaration))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31
				+ (_ParametersExpr == null ? 0 : _ParametersExpr.hashCode());
		hash = hash * 31 + (_VariableDeclaration.hashCode());
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
