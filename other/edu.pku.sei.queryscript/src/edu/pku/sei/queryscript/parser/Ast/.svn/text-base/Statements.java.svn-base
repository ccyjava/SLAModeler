package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<em>
 *<li>Rule 4:  Statements ::= Statement
 *</em>
 *<p>
 * <b>
 *<li>Rule 3: Statements ::= Statements Statement </b>
 */
public class Statements extends Ast implements IStatements {
	private IStatements _Statements;
	private IStatement _Statement;

	public IStatements getStatements() {
		return _Statements;
	}

	public IStatement getStatement() {
		return _Statement;
	}

	public Statements(IToken leftIToken, IToken rightIToken,
			IStatements _Statements, IStatement _Statement) {
		super(leftIToken, rightIToken);

		this._Statements = _Statements;
		this._Statement = _Statement;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Statements))
			return false;
		if (!super.equals(o))
			return false;
		Statements other = (Statements) o;
		if (!_Statements.equals(other._Statements))
			return false;
		if (!_Statement.equals(other._Statement))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_Statements.hashCode());
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
