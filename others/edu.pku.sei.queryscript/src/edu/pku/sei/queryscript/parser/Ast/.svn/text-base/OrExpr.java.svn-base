package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 18: LogicExpr ::= LogicExpr or RelationalExpr </b>
 */
public class OrExpr extends Ast implements ILogicExpr {
	private ILogicExpr _LogicExpr;
	private IRelationalExpr _RelationalExpr;

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public IRelationalExpr getRelationalExpr() {
		return _RelationalExpr;
	}

	public OrExpr(IToken leftIToken, IToken rightIToken, ILogicExpr _LogicExpr,
			IRelationalExpr _RelationalExpr) {
		super(leftIToken, rightIToken);

		this._LogicExpr = _LogicExpr;
		this._RelationalExpr = _RelationalExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof OrExpr))
			return false;
		if (!super.equals(o))
			return false;
		OrExpr other = (OrExpr) o;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		if (!_RelationalExpr.equals(other._RelationalExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LogicExpr.hashCode());
		hash = hash * 31 + (_RelationalExpr.hashCode());
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
