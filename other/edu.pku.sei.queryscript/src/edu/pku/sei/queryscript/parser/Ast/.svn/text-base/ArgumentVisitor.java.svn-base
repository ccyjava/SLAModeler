package edu.pku.sei.queryscript.parser.Ast;

public interface ArgumentVisitor {
	void visit(AstToken n, Object o);

	void visit(Statements n, Object o);

	void visit(AlternativeState n, Object o);

	void visit(QueryState n, Object o);

	void visit(IfState n, Object o);

	void visit(IfElseState n, Object o);

	void visit(Function n, Object o);

	void visit(SingleParameterExpr n, Object o);

	void visit(MoreParametersExpr n, Object o);

	void visit(EmptyParameterExpr n, Object o);

	void visit(QueryExpr n, Object o);

	void visit(CheckOnlyExpr n, Object o);

	void visit(EnforceExpr n, Object o);

	void visit(AndExpr n, Object o);

	void visit(OrExpr n, Object o);

	void visit(NotExpr n, Object o);

	void visit(LogicRelationalExpr n, Object o);

	void visit(EqualExpr n, Object o);

	void visit(GreaterExpr n, Object o);

	void visit(LessExpr n, Object o);

	void visit(RelationalArithExpr n, Object o);

	void visit(PlusExpr n, Object o);

	void visit(MinusExpr n, Object o);

	void visit(ArithAtomicExpr n, Object o);

	void visit(AtomicLiteralExpr n, Object o);

	void visit(AtomicVariableExpr n, Object o);

	void visit(AtomicSelfExpr n, Object o);

	void visit(AtomicCallExpr n, Object o);

	void visit(ParenQueryExpr n, Object o);

	void visit(StringPrimitiveLiteralExpr n, Object o);

	void visit(IntegerPrimitiveLiteralExpr n, Object o);

	void visit(BooleanPrimitiveLiteralExpr n, Object o);

	void visit(NullLiteralExpr n, Object o);

	void visit(CallLoopExpr n, Object o);

	void visit(CallModelPropertyExpr n, Object o);

	void visit(FunctionCallExpr n, Object o);

	void visit(AttributeCallExpr n, Object o);

	void visit(CollectionOperationCallExpr n, Object o);

	void visit(ObjectOperationCallExpr n, Object o);

	void visit(MoreArgumentsExpr n, Object o);

	void visit(SingleArgumentsExpr n, Object o);

	void visit(EmptyArgumentsExpr n, Object o);

	void visit(SelectLoopExpr n, Object o);

	void visit(CollectLoopExpr n, Object o);

	void visit(ForAllLoopExpr n, Object o);

	void visit(ExistLoopExpr n, Object o);

	void visit(VariableDeclaration n, Object o);

	void visit(BoolType n, Object o);

	void visit(StringType n, Object o);

	void visit(IntType n, Object o);

	void visit(QName n, Object o);

	void visit(SimpleName n, Object o);

	void visit(Ast n, Object o);
}
