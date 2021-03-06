package edu.pku.sei.queryscript.parser.Ast;

import lpg.runtime.IToken;

/**
 * is implemented by: <b>
 *<ul>
 *<li>AndExpr
 *<li>OrExpr
 *<li>NotExpr
 *<li>LogicRelationalExpr
 *<li>EqualExpr
 *<li>GreaterExpr
 *<li>LessExpr
 *<li>RelationalArithExpr
 *<li>PlusExpr
 *<li>MinusExpr
 *<li>ArithAtomicExpr
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
 *<li>MoreArgumentsExpr
 *<li>SingleArgumentsExpr
 *<li>EmptyArgumentsExpr
 *<li>SelectLoopExpr
 *<li>CollectLoopExpr
 *<li>ForAllLoopExpr
 *<li>ExistLoopExpr
 *<li>SimpleName
 *</ul>
 *</b>
 */
public interface IArgumentsExpr {
	public IToken getLeftIToken();

	public IToken getRightIToken();

	void accept(Visitor v);

	void accept(ArgumentVisitor v, Object o);

	Object accept(ResultVisitor v);

	Object accept(ResultArgumentVisitor v, Object o);
}
