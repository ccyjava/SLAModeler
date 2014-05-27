package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 7: Statement ::= if LogicExpr then Statements endif </b>
 */
public class IfState extends Ast implements IStatement {
	private ILogicExpr _LogicExpr;
	private IStatements _Statements;

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public IStatements getStatements() {
		return _Statements;
	}

	public IfState(IToken leftIToken, IToken rightIToken,
			ILogicExpr _LogicExpr, IStatements _Statements) {
		super(leftIToken, rightIToken);

		this._LogicExpr = _LogicExpr;
		this._Statements = _Statements;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof IfState))
			return false;
		if (!super.equals(o))
			return false;
		IfState other = (IfState) o;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		if (!_Statements.equals(other._Statements))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LogicExpr.hashCode());
		hash = hash * 31 + (_Statements.hashCode());
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
