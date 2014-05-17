package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 46: ArgumentsExpr ::= LogicExpr </b>
 */
public class SingleArgumentsExpr extends Ast implements IArgumentsExpr {
	private ILogicExpr _LogicExpr;

	public ILogicExpr getLogicExpr() {
		return _LogicExpr;
	}

	public SingleArgumentsExpr(IToken leftIToken, IToken rightIToken,
			ILogicExpr _LogicExpr) {
		super(leftIToken, rightIToken);

		this._LogicExpr = _LogicExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SingleArgumentsExpr))
			return false;
		if (!super.equals(o))
			return false;
		SingleArgumentsExpr other = (SingleArgumentsExpr) o;
		if (!_LogicExpr.equals(other._LogicExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
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
