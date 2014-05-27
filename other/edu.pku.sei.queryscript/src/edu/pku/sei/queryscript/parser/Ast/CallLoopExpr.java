package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 39: CallExpr ::= LoopExpr </b>
 */
public class CallLoopExpr extends Ast implements ICallExpr {
	private ILoopExpr _LoopExpr;

	public ILoopExpr getLoopExpr() {
		return _LoopExpr;
	}

	public CallLoopExpr(IToken leftIToken, IToken rightIToken,
			ILoopExpr _LoopExpr) {
		super(leftIToken, rightIToken);

		this._LoopExpr = _LoopExpr;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof CallLoopExpr))
			return false;
		if (!super.equals(o))
			return false;
		CallLoopExpr other = (CallLoopExpr) o;
		if (!_LoopExpr.equals(other._LoopExpr))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_LoopExpr.hashCode());
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
