package edu.pku.sei.queryscript.parser.Ast;

public interface ResultVisitor {
	Object visit(AstToken n);

	Object visit(Statements n);

	Object visit(AlternativeState n);

	Object visit(QueryState n);

	Object visit(IfState n);

	Object visit(IfElseState n);

	Object visit(Function n);

	Object visit(SingleParameterExpr n);

	Object visit(MoreParametersExpr n);

	Object visit(EmptyParameterExpr n);

	Object visit(QueryExpr n);

	Object visit(CheckOnlyExpr n);

	Object visit(EnforceExpr n);

	Object visit(AndExpr n);

	Object visit(OrExpr n);

	Object visit(NotExpr n);

	Object visit(LogicRelationalExpr n);

	Object visit(EqualExpr n);

	Object visit(GreaterExpr n);

	Object visit(LessExpr n);

	Object visit(RelationalArithExpr n);

	Object visit(PlusExpr n);

	Object visit(MinusExpr n);

	Object visit(ArithAtomicExpr n);

	Object visit(AtomicLiteralExpr n);

	Object visit(AtomicVariableExpr n);

	Object visit(AtomicSelfExpr n);

	Object visit(AtomicCallExpr n);

	Object visit(ParenQueryExpr n);

	Object visit(StringPrimitiveLiteralExpr n);

	Object visit(IntegerPrimitiveLiteralExpr n);

	Object visit(BooleanPrimitiveLiteralExpr n);

	Object visit(NullLiteralExpr n);

	Object visit(CallLoopExpr n);

	Object visit(CallModelPropertyExpr n);

	Object visit(FunctionCallExpr n);

	Object visit(AttributeCallExpr n);

	Object visit(CollectionOperationCallExpr n);

	Object visit(ObjectOperationCallExpr n);

	Object visit(MoreArgumentsExpr n);

	Object visit(SingleArgumentsExpr n);

	Object visit(EmptyArgumentsExpr n);

	Object visit(SelectLoopExpr n);

	Object visit(CollectLoopExpr n);

	Object visit(ForAllLoopExpr n);

	Object visit(ExistLoopExpr n);

	Object visit(VariableDeclaration n);

	Object visit(BoolType n);

	Object visit(StringType n);

	Object visit(IntType n);

	Object visit(QName n);

	Object visit(SimpleName n);

	Object visit(Ast n);
}
