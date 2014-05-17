package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 20: LogicExpr ::= RelationalExpr </b>
 */
public class LogicRelationalExpr extends Ast implements ILogicExpr {
	private IRelationalExpr _RelationalExpr;

	public IRelationalExpr getRelationalExpr() {
		return _RelationalExpr;
	}

	public LogicRelationalExpr(IToken leftIToken, IToken rightIToken,
			IRelationalExpr _RelationalExpr) {
		super(leftIToken, rightIToken);

		this._RelationalExpr = _RelationalExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof LogicRelationalExpr))
			return false;
		if (!super.equals(o))
			return false;
		LogicRelationalExpr other = (LogicRelationalExpr) o;
		if (!_RelationalExpr.equals(other._RelationalExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
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
