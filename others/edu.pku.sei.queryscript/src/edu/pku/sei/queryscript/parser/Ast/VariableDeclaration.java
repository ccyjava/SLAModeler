package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<b> <li>Rule 52: VariableDeclaration ::= SimpleName : TypeName </b>
 */
public class VariableDeclaration extends Ast implements IVariableDeclaration {
	private SimpleName _SimpleName;
	private ITypeName _TypeName;

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	public ITypeName getTypeName() {
		return _TypeName;
	}

	public VariableDeclaration(IToken leftIToken, IToken rightIToken,
			SimpleName _SimpleName, ITypeName _TypeName) {
		super(leftIToken, rightIToken);

		this._SimpleName = _SimpleName;
		this._TypeName = _TypeName;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof VariableDeclaration))
			return false;
		if (!super.equals(o))
			return false;
		VariableDeclaration other = (VariableDeclaration) o;
		if (!_SimpleName.equals(other._SimpleName))
			return false;
		if (!_TypeName.equals(other._TypeName))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_SimpleName.hashCode());
		hash = hash * 31 + (_TypeName.hashCode());
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
