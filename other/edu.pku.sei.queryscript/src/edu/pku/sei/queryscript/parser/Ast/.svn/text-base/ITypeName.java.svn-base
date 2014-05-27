package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 * is implemented by: <b>
 *<ul>
 *<li>BoolType
 *<li>StringType
 *<li>IntType
 *<li>QName
 *<li>SimpleName
 *</ul>
 *</b>
 */
public interface ITypeName {
	public IToken getLeftIToken();

	public IToken getRightIToken();

	void accept(Visitor v);

	void accept(ArgumentVisitor v, Object o);

	Object accept(ResultVisitor v);

	Object accept(ResultArgumentVisitor v, Object o);
}
