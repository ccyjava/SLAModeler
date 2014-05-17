package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by: <b>
 *<ul>
 *<li>AtomicLiteralExpr
 *<li>AtomicVariableExpr
 *<li>AtomicSelfExpr
 *<li>AtomicCallExpr
 *<li>ParenQueryExpr
 *<li>StringPrimitiveLiteralExpr
 *<li>IntegerPrimitiveLiteralExpr
 *<li>BooleanPrimitiveLiteralExpr
 *<li>NullLiteralExpr
 *<li>CallLoopExpr
 *<li>CallModelPropertyExpr
 *<li>FunctionCallExpr
 *<li>AttributeCallExpr
 *<li>CollectionOperationCallExpr
 *<li>ObjectOperationCallExpr
 *<li>SelectLoopExpr
 *<li>CollectLoopExpr
 *<li>ForAllLoopExpr
 *<li>ExistLoopExpr
 *<li>BoolType
 *<li>StringType
 *<li>IntType
 *<li>SimpleName
 *</ul>
 *</b>
 */
public interface IAstToken {
	public IToken getLeftIToken();

	public IToken getRightIToken();

	void accept(Visitor v);

	void accept(ArgumentVisitor v, Object o);

	Object accept(ResultVisitor v);

	Object accept(ResultArgumentVisitor v, Object o);
}
