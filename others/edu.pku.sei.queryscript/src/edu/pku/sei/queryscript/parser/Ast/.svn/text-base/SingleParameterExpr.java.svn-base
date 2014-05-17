package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 10: ParametersExpr ::= VariableDeclaration </b>
 */
public class SingleParameterExpr extends Ast implements IParametersExpr {
	private VariableDeclaration _VariableDeclaration;

	public VariableDeclaration getVariableDeclaration() {
		return _VariableDeclaration;
	}

	public SingleParameterExpr(IToken leftIToken, IToken rightIToken,
			VariableDeclaration _VariableDeclaration) {
		super(leftIToken, rightIToken);

		this._VariableDeclaration = _VariableDeclaration;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SingleParameterExpr))
			return false;
		if (!super.equals(o))
			return false;
		SingleParameterExpr other = (SingleParameterExpr) o;
		if (!_VariableDeclaration.equals(other._VariableDeclaration))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_VariableDeclaration.hashCode());
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
