package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 9: Function ::= query SimpleName ( ParametersExpr ) : TypeName {
 * Statements } </b>
 */
public class Function extends Ast implements IFunction {
	private SimpleName _SimpleName;
	private IParametersExpr _ParametersExpr;
	private ITypeName _TypeName;
	private IStatements _Statements;

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	/**
	 * The value returned by <b>getParametersExpr</b> may be <b>null</b>
	 */
	public IParametersExpr getParametersExpr() {
		return _ParametersExpr;
	}

	public ITypeName getTypeName() {
		return _TypeName;
	}

	public IStatements getStatements() {
		return _Statements;
	}

	public Function(IToken leftIToken, IToken rightIToken,
			SimpleName _SimpleName, IParametersExpr _ParametersExpr,
			ITypeName _TypeName, IStatements _Statements) {
		super(leftIToken, rightIToken);

		this._SimpleName = _SimpleName;
		this._ParametersExpr = _ParametersExpr;
		this._TypeName = _TypeName;
		this._Statements = _Statements;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Function))
			return false;
		if (!super.equals(o))
			return false;
		Function other = (Function) o;
		if (!_SimpleName.equals(other._SimpleName))
			return false;
		if (_ParametersExpr == null)
			if (other._ParametersExpr != null)
				return false;
			else
				; // continue
		else if (!_ParametersExpr.equals(other._ParametersExpr))
			return false;
		if (!_TypeName.equals(other._TypeName))
			return false;
		if (!_Statements.equals(other._Statements))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_SimpleName.hashCode());
		hash = hash * 31
				+ (_ParametersExpr == null ? 0 : _ParametersExpr.hashCode());
		hash = hash * 31 + (_TypeName.hashCode());
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
