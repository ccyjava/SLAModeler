package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 41: CallExpr ::= SimpleName ( ArgumentsExpr ) </b>
 */
public class FunctionCallExpr extends Ast implements ICallExpr {
	private SimpleName _SimpleName;
	private IArgumentsExpr _ArgumentsExpr;

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	/**
	 * The value returned by <b>getArgumentsExpr</b> may be <b>null</b>
	 */
	public IArgumentsExpr getArgumentsExpr() {
		return _ArgumentsExpr;
	}

	public FunctionCallExpr(IToken leftIToken, IToken rightIToken,
			SimpleName _SimpleName, IArgumentsExpr _ArgumentsExpr) {
		super(leftIToken, rightIToken);

		this._SimpleName = _SimpleName;
		this._ArgumentsExpr = _ArgumentsExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof FunctionCallExpr))
			return false;
		if (!super.equals(o))
			return false;
		FunctionCallExpr other = (FunctionCallExpr) o;
		if (!_SimpleName.equals(other._SimpleName))
			return false;
		if (_ArgumentsExpr == null)
			if (other._ArgumentsExpr != null)
				return false;
			else
				; // continue
		else if (!_ArgumentsExpr.equals(other._ArgumentsExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_SimpleName.hashCode());
		hash = hash * 31
				+ (_ArgumentsExpr == null ? 0 : _ArgumentsExpr.hashCode());
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
