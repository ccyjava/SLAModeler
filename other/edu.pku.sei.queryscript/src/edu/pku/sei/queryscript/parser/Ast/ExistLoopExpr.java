package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 51: LoopExpr ::= AtomicExpr -> exists ( VariableDeclaration |
 * QueryExpr ) </b>
 */
public class ExistLoopExpr extends Ast implements ILoopExpr {
	private IAtomicExpr _AtomicExpr;
	private VariableDeclaration _VariableDeclaration;
	private IQueryExpr _QueryExpr;

	public IAtomicExpr getAtomicExpr() {
		return _AtomicExpr;
	}

	public VariableDeclaration getVariableDeclaration() {
		return _VariableDeclaration;
	}

	public IQueryExpr getQueryExpr() {
		return _QueryExpr;
	}

	public ExistLoopExpr(IToken leftIToken, IToken rightIToken,
			IAtomicExpr _AtomicExpr, VariableDeclaration _VariableDeclaration,
			IQueryExpr _QueryExpr) {
		super(leftIToken, rightIToken);

		this._AtomicExpr = _AtomicExpr;
		this._VariableDeclaration = _VariableDeclaration;
		this._QueryExpr = _QueryExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof ExistLoopExpr))
			return false;
		if (!super.equals(o))
			return false;
		ExistLoopExpr other = (ExistLoopExpr) o;
		if (!_AtomicExpr.equals(other._AtomicExpr))
			return false;
		if (!_VariableDeclaration.equals(other._VariableDeclaration))
			return false;
		if (!_QueryExpr.equals(other._QueryExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_AtomicExpr.hashCode());
		hash = hash * 31 + (_VariableDeclaration.hashCode());
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
