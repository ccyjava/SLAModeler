package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 5: Statement ::= QueryExpr # Statement </b>
 */
public class AlternativeState extends Ast implements IStatement {
	private IQueryExpr _QueryExpr;
	private IStatement _Statement;

	public IQueryExpr getQueryExpr() {
		return _QueryExpr;
	}

	public IStatement getStatement() {
		return _Statement;
	}

	public AlternativeState(IToken leftIToken, IToken rightIToken,
			IQueryExpr _QueryExpr, IStatement _Statement) {
		super(leftIToken, rightIToken);

		this._QueryExpr = _QueryExpr;
		this._Statement = _Statement;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AlternativeState))
			return false;
		if (!super.equals(o))
			return false;
		AlternativeState other = (AlternativeState) o;
		if (!_QueryExpr.equals(other._QueryExpr))
			return false;
		if (!_Statement.equals(other._Statement))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_QueryExpr.hashCode());
		hash = hash * 31 + (_Statement.hashCode());
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
