package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 * is implemented by: <b>
 *<ul>
 *<li>Statements
 *<li>AlternativeState
 *<li>QueryState
 *<li>IfState
 *<li>IfElseState
 *<li>Function
 *</ul>
 *</b>
 */
public interface Igoal {
	public IToken getLeftIToken();

	public IToken getRightIToken();

	void accept(Visitor v);

	void accept(ArgumentVisitor v, Object o);

	Object accept(ResultVisitor v);

	Object accept(ResultArgumentVisitor v, Object o);
}
