package edu.pku.sei.queryscript.parser.Ast;

public interface ResultArgumentVisitor {
	Object visit(AstToken n, Object o);

	Object visit(Statements n, Object o);

	Object visit(AlternativeState n, Object o);

	Object visit(QueryState n, Object o);

	Object visit(IfState n, Object o);

	Object visit(IfElseState n, Object o);

	Object visit(Function n, Object o);

	Object visit(SingleParameterExpr n, Object o);

	Object visit(MoreParametersExpr n, Object o);

	Object visit(EmptyParameterExpr n, Object o);

	Object visit(QueryExpr n, Object o);

	Object visit(CheckOnlyExpr n, Object o);

	Object visit(EnforceExpr n, Object o);

	Object visit(AndExpr n, Object o);

	Object visit(OrExpr n, Object o);

	Object visit(NotExpr n, Object o);

	Object visit(LogicRelationalExpr n, Object o);

	Object visit(EqualExpr n, Object o);

	Object visit(GreaterExpr n, Object o);

	Object visit(LessExpr n, Object o);

	Object visit(RelationalArithExpr n, Object o);

	Object visit(PlusExpr n, Object o);

	Object visit(MinusExpr n, Object o);

	Object visit(ArithAtomicExpr n, Object o);

	Object visit(AtomicLiteralExpr n, Object o);

	Object visit(AtomicVariableExpr n, Object o);

	Object visit(AtomicSelfExpr n, Object o);

	Object visit(AtomicCallExpr n, Object o);

	Object visit(ParenQueryExpr n, Object o);

	Object visit(StringPrimitiveLiteralExpr n, Object o);

	Object visit(IntegerPrimitiveLiteralExpr n, Object o);

	Object visit(BooleanPrimitiveLiteralExpr n, Object o);

	Object visit(NullLiteralExpr n, Object o);

	Object visit(CallLoopExpr n, Object o);

	Object visit(CallModelPropertyExpr n, Object o);

	Object visit(FunctionCallExpr n, Object o);

	Object visit(AttributeCallExpr n, Object o);

	Object visit(CollectionOperationCallExpr n, Object o);

	Object visit(ObjectOperationCallExpr n, Object o);

	Object visit(MoreArgumentsExpr n, Object o);

	Object visit(SingleArgumentsExpr n, Object o);

	Object visit(EmptyArgumentsExpr n, Object o);

	Object visit(SelectLoopExpr n, Object o);

	Object visit(CollectLoopExpr n, Object o);

	Object visit(ForAllLoopExpr n, Object o);

	Object visit(ExistLoopExpr n, Object o);

	Object visit(VariableDeclaration n, Object o);

	Object visit(BoolType n, Object o);

	Object visit(StringType n, Object o);

	Object visit(IntType n, Object o);

	Object visit(QName n, Object o);

	Object visit(SimpleName n, Object o);

	Object visit(Ast n, Object o);
}
