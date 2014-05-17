package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 42: ModelPropertyExpr ::= AtomicExpr . SimpleName </b>
 */
public class AttributeCallExpr extends Ast implements IModelPropertyExpr {
	private IAtomicExpr _AtomicExpr;
	private SimpleName _SimpleName;

	public IAtomicExpr getAtomicExpr() {
		return _AtomicExpr;
	}

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	public AttributeCallExpr(IToken leftIToken, IToken rightIToken,
			IAtomicExpr _AtomicExpr, SimpleName _SimpleName) {
		super(leftIToken, rightIToken);

		this._AtomicExpr = _AtomicExpr;
		this._SimpleName = _SimpleName;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AttributeCallExpr))
			return false;
		if (!super.equals(o))
			return false;
		AttributeCallExpr other = (AttributeCallExpr) o;
		if (!_AtomicExpr.equals(other._AtomicExpr))
			return false;
		if (!_SimpleName.equals(other._SimpleName))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_AtomicExpr.hashCode());
		hash = hash * 31 + (_SimpleName.hashCode());
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
