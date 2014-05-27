package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 44: ModelPropertyExpr ::= AtomicExpr . SimpleName (
 * ArgumentsExpr ) </b>
 */
public class ObjectOperationCallExpr extends Ast implements IModelPropertyExpr {
	private IAtomicExpr _AtomicExpr;
	private SimpleName _SimpleName;
	private IArgumentsExpr _ArgumentsExpr;

	public IAtomicExpr getAtomicExpr() {
		return _AtomicExpr;
	}

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	/**
	 * The value returned by <b>getArgumentsExpr</b> may be <b>null</b>
	 */
	public IArgumentsExpr getArgumentsExpr() {
		return _ArgumentsExpr;
	}

	public ObjectOperationCallExpr(IToken leftIToken, IToken rightIToken,
			IAtomicExpr _AtomicExpr, SimpleName _SimpleName,
			IArgumentsExpr _ArgumentsExpr) {
		super(leftIToken, rightIToken);

		this._AtomicExpr = _AtomicExpr;
		this._SimpleName = _SimpleName;
		this._ArgumentsExpr = _ArgumentsExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ObjectOperationCallExpr))
			return false;
		if (!super.equals(o))
			return false;
		ObjectOperationCallExpr other = (ObjectOperationCallExpr) o;
		if (!_AtomicExpr.equals(other._AtomicExpr))
			return false;
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
		hash = hash * 31 + (_AtomicExpr.hashCode());
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
