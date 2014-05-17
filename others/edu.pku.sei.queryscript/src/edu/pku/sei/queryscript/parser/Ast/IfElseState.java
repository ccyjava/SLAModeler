package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 8: Statement ::= if LogicExpr then Statements$ThenStatements
 * else Statements$ElseStatements endif </b>
 */
public class IfElseState extends Ast implements IStatement {
	private ILogicExpr _LogicExpr;
	private IStatements _ThenStatements;
	private IStatements _ElseStatements;

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public IStatements getThenStatements() {
		return _ThenStatements;
	}

	public IStatements getElseStatements() {
		return _ElseStatements;
	}

	public IfElseState(IToken leftIToken, IToken rightIToken,
			ILogicExpr _LogicExpr, IStatements _ThenStatements,
			IStatements _ElseStatements) {
		super(leftIToken, rightIToken);

		this._LogicExpr = _LogicExpr;
		this._ThenStatements = _ThenStatements;
		this._ElseStatements = _ElseStatements;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof IfElseState))
			return false;
		if (!super.equals(o))
			return false;
		IfElseState other = (IfElseState) o;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		if (!_ThenStatements.equals(other._ThenStatements))
			return false;
		if (!_ElseStatements.equals(other._ElseStatements))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LogicExpr.hashCode());
		hash = hash * 31 + (_ThenStatements.hashCode());
		hash = hash * 31 + (_ElseStatements.hashCode());
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
