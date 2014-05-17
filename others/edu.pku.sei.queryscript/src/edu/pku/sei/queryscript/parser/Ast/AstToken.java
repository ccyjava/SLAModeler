package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

public class AstToken extends Ast implements IAstToken {
	public AstToken(IToken token) {
		super(token);
	}

	public IToken getIToken() {
		return leftIToken;
	}

	public String toString() {
		return leftIToken.toString();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof AstToken))
			return false;
		AstToken other = (AstToken) o;
		return getIToken().getILexStream() == other.getIToken().getILexStream()
				&& getIToken().getTokenIndex() == other.getIToken()
						.getTokenIndex();
	}

	public int hashCode() {
		int hash = 7;
		if (getIToken().getILexStream() != null)
			hash = hash * 31 + getIToken().getILexStream().hashCode();
		hash = hash * 31 + getIToken().getTokenIndex();
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
