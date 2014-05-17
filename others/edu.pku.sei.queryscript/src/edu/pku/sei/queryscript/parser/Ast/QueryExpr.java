package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<em>
 *<li>Rule 13:  QueryExpr ::= LogicExpr
 *</em>
 *<p>
 * <b>
 *<li>Rule 14: QueryExpr ::= QueryExpr , LogicExpr </b>
 */
public class QueryExpr extends Ast implements IQueryExpr {
	private IQueryExpr _QueryExpr;
	private ILogicExpr _LogicExpr;

	public IQueryExpr getQueryExpr() {
		return _QueryExpr;
	}

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public QueryExpr(IToken leftIToken, IToken rightIToken,
			IQueryExpr _QueryExpr, ILogicExpr _LogicExpr) {
		super(leftIToken, rightIToken);

		this._QueryExpr = _QueryExpr;
		this._LogicExpr = _LogicExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof QueryExpr))
			return false;
		if (!super.equals(o))
			return false;
		QueryExpr other = (QueryExpr) o;
		if (!_QueryExpr.equals(other._QueryExpr))
			return false;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_QueryExpr.hashCode());
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
