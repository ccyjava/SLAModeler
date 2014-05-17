package edu.pku.sei.queryscript.parser.Ast;

public interface Visitor {
	void visit(AstToken n);

	void visit(Statements n);

	void visit(AlternativeState n);

	void visit(QueryState n);

	void visit(IfState n);

	void visit(IfElseState n);

	void visit(Function n);

	void visit(SingleParameterExpr n);

	void visit(MoreParametersExpr n);

	void visit(EmptyParameterExpr n);

	void visit(QueryExpr n);

	void visit(CheckOnlyExpr n);

	void visit(EnforceExpr n);

	void visit(AndExpr n);

	void visit(OrExpr n);

	void visit(NotExpr n);

	void visit(LogicRelationalExpr n);

	void visit(EqualExpr n);

	void visit(GreaterExpr n);

	void visit(LessExpr n);

	void visit(RelationalArithExpr n);

	void visit(PlusExpr n);

	void visit(MinusExpr n);

	void visit(ArithAtomicExpr n);

	void visit(AtomicLiteralExpr n);

	void visit(AtomicVariableExpr n);

	void visit(AtomicSelfExpr n);

	void visit(AtomicCallExpr n);

	void visit(ParenQueryExpr n);

	void visit(StringPrimitiveLiteralExpr n);

	void visit(IntegerPrimitiveLiteralExpr n);

	void visit(BooleanPrimitiveLiteralExpr n);

	void visit(NullLiteralExpr n);

	void visit(CallLoopExpr n);

	void visit(CallModelPropertyExpr n);

	void visit(FunctionCallExpr n);

	void visit(AttributeCallExpr n);

	void visit(CollectionOperationCallExpr n);

	void visit(ObjectOperationCallExpr n);

	void visit(MoreArgumentsExpr n);

	void visit(SingleArgumentsExpr n);

	void visit(EmptyArgumentsExpr n);

	void visit(SelectLoopExpr n);

	void visit(CollectLoopExpr n);

	void visit(ForAllLoopExpr n);

	void visit(ExistLoopExpr n);

	void visit(VariableDeclaration n);

	void visit(BoolType n);

	void visit(StringType n);

	void visit(IntType n);

	void visit(QName n);

	void visit(SimpleName n);

	void visit(Ast n);
}
