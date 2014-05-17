package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 45: ArgumentsExpr ::= ArgumentsExpr , LogicExpr </b>
 */
public class MoreArgumentsExpr extends Ast implements IArgumentsExpr {
	private IArgumentsExpr _ArgumentsExpr;
	private ILogicExpr _LogicExpr;

	/**
	 * The value returned by <b>getArgumentsExpr</b> may be <b>null</b>
	 */
	public IArgumentsExpr getArgumentsExpr() {
		return _ArgumentsExpr;
	}

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public MoreArgumentsExpr(IToken leftIToken, IToken rightIToken,
			IArgumentsExpr _ArgumentsExpr, ILogicExpr _LogicExpr) {
		super(leftIToken, rightIToken);

		this._ArgumentsExpr = _ArgumentsExpr;
		this._LogicExpr = _LogicExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof MoreArgumentsExpr))
			return false;
		if (!super.equals(o))
			return false;
		MoreArgumentsExpr other = (MoreArgumentsExpr) o;
		if (_ArgumentsExpr == null)
			if (other._ArgumentsExpr != null)
				return false;
			else
				; // continue
		else if (!_ArgumentsExpr.equals(other._ArgumentsExpr))
			return false;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31
				+ (_ArgumentsExpr == null ? 0 : _ArgumentsExpr.hashCode());
		hash = hash * 31 + (_LogicExpr.hashCode());
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
