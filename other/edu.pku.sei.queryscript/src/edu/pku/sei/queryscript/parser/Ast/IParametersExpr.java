package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 * is implemented by: <b>
 *<ul>
 *<li>SingleParameterExpr
 *<li>MoreParametersExpr
 *<li>EmptyParameterExpr
 *<li>VariableDeclaration
 *</ul>
 *</b>
 */
public interface IParametersExpr {
	public IToken getLeftIToken();

	public IToken getRightIToken();

	void accept(Visitor v);

	void accept(ArgumentVisitor v, Object o);

	Object accept(ResultVisitor v);

	Object accept(ResultArgumentVisitor v, Object o);
}
