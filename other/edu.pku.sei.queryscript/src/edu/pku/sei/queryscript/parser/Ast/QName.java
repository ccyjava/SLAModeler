package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 *<em>
 *<li>Rule 60:  QName ::= SimpleName
 *</em>
 *<p>
 * <b>
 *<li>Rule 59: QName ::= QName :: SimpleName </b>
 */
public class QName extends Ast implements IQName {
	private IQName _QName;
	private SimpleName _SimpleName;

	public IQName getQName() {
		return _QName;
	}

	public SimpleName getSimpleName() {
		return _SimpleName;
	}

	public QName(IToken leftIToken, IToken rightIToken, IQName _QName,
			SimpleName _SimpleName) {
		super(leftIToken, rightIToken);

		this._QName = _QName;
		this._SimpleName = _SimpleName;
		initialize();
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof QName))
			return false;
		if (!super.equals(o))
			return false;
		QName other = (QName) o;
		if (!_QName.equals(other._QName))
			return false;
		if (!_SimpleName.equals(other._SimpleName))
			return false;
		return true;
	}

	public int hashCode() {
		int hash = super.hashCode();
		hash = hash * 31 + (_QName.hashCode());
		hash = hash * 31 + (_SimpleName.hashCode());
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
