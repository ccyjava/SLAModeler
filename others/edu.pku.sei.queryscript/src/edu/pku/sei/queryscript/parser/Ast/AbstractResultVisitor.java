package edu.pku.sei.queryscript.parser.Ast;

public abstract class AbstractResultVisitor implements ResultVisitor,
		ResultArgumentVisitor {
	public abstract Object unimplementedVisitor(String s);

	public Object visit(AstToken n) {
		return unimplementedVisitor("visit(AstToken)");
	}

	public Object visit(AstToken n, Object o) {
		return unimplementedVisitor("visit(AstToken, Object)");
	}

	public Object visit(Statements n) {
		return unimplementedVisitor("visit(Statements)");
	}

	public Object visit(Statements n, Object o) {
		return unimplementedVisitor("visit(Statements, Object)");
	}

	public Object visit(AlternativeState n) {
		return unimplementedVisitor("visit(AlternativeState)");
	}

	public Object visit(AlternativeState n, Object o) {
		return unimplementedVisitor("visit(AlternativeState, Object)");
	}

	public Object visit(QueryState n) {
		return unimplementedVisitor("visit(QueryState)");
	}

	public Object visit(QueryState n, Object o) {
		return unimplementedVisitor("visit(QueryState, Object)");
	}

	public Object visit(IfState n) {
		return unimplementedVisitor("visit(IfState)");
	}

	public Object visit(IfState n, Object o) {
		return unimplementedVisitor("visit(IfState, Object)");
	}

	public Object visit(IfElseState n) {
		return unimplementedVisitor("visit(IfElseState)");
	}

	public Object visit(IfElseState n, Object o) {
		return unimplementedVisitor("visit(IfElseState, Object)");
	}

	public Object visit(Function n) {
		return unimplementedVisitor("visit(Function)");
	}

	public Object visit(Function n, Object o) {
		return unimplementedVisitor("visit(Function, Object)");
	}

	public Object visit(SingleParameterExpr n) {
		return unimplementedVisitor("visit(SingleParameterExpr)");
	}

	public Object visit(SingleParameterExpr n, Object o) {
		return unimplementedVisitor("visit(SingleParameterExpr, Object)");
	}

	public Object visit(MoreParametersExpr n) {
		return unimplementedVisitor("visit(MoreParametersExpr)");
	}

	public Object visit(MoreParametersExpr n, Object o) {
		return unimplementedVisitor("visit(MoreParametersExpr, Object)");
	}

	public Object visit(EmptyParameterExpr n) {
		return unimplementedVisitor("visit(EmptyParameterExpr)");
	}

	public Object visit(EmptyParameterExpr n, Object o) {
		return unimplementedVisitor("visit(EmptyParameterExpr, Object)");
	}

	public Object visit(QueryExpr n) {
		return unimplementedVisitor("visit(QueryExpr)");
	}

	public Object visit(QueryExpr n, Object o) {
		return unimplementedVisitor("visit(QueryExpr, Object)");
	}

	public Object visit(CheckOnlyExpr n) {
		return unimplementedVisitor("visit(CheckOnlyExpr)");
	}

	public Object visit(CheckOnlyExpr n, Object o) {
		return unimplementedVisitor("visit(CheckOnlyExpr, Object)");
	}

	public Object visit(EnforceExpr n) {
		return unimplementedVisitor("visit(EnforceExpr)");
	}

	public Object visit(EnforceExpr n, Object o) {
		return unimplementedVisitor("visit(EnforceExpr, Object)");
	}

	public Object visit(AndExpr n) {
		return unimplementedVisitor("visit(AndExpr)");
	}

	public Object visit(AndExpr n, Object o) {
		return unimplementedVisitor("visit(AndExpr, Object)");
	}

	public Object visit(OrExpr n) {
		return unimplementedVisitor("visit(OrExpr)");
	}

	public Object visit(OrExpr n, Object o) {
		return unimplementedVisitor("visit(OrExpr, Object)");
	}

	public Object visit(NotExpr n) {
		return unimplementedVisitor("visit(NotExpr)");
	}

	public Object visit(NotExpr n, Object o) {
		return unimplementedVisitor("visit(NotExpr, Object)");
	}

	public Object visit(LogicRelationalExpr n) {
		return unimplementedVisitor("visit(LogicRelationalExpr)");
	}

	public Object visit(LogicRelationalExpr n, Object o) {
		return unimplementedVisitor("visit(LogicRelationalExpr, Object)");
	}

	public Object visit(EqualExpr n) {
		return unimplementedVisitor("visit(EqualExpr)");
	}

	public Object visit(EqualExpr n, Object o) {
		return unimplementedVisitor("visit(EqualExpr, Object)");
	}

	public Object visit(GreaterExpr n) {
		return unimplementedVisitor("visit(GreaterExpr)");
	}

	public Object visit(GreaterExpr n, Object o) {
		return unimplementedVisitor("visit(GreaterExpr, Object)");
	}

	public Object visit(LessExpr n) {
		return unimplementedVisitor("visit(LessExpr)");
	}

	public Object visit(LessExpr n, Object o) {
		return unimplementedVisitor("visit(LessExpr, Object)");
	}

	public Object visit(RelationalArithExpr n) {
		return unimplementedVisitor("visit(RelationalArithExpr)");
	}

	public Object visit(RelationalArithExpr n, Object o) {
		return unimplementedVisitor("visit(RelationalArithExpr, Object)");
	}

	public Object visit(PlusExpr n) {
		return unimplementedVisitor("visit(PlusExpr)");
	}

	public Object visit(PlusExpr n, Object o) {
		return unimplementedVisitor("visit(PlusExpr, Object)");
	}

	public Object visit(MinusExpr n) {
		return unimplementedVisitor("visit(MinusExpr)");
	}

	public Object visit(MinusExpr n, Object o) {
		return unimplementedVisitor("visit(MinusExpr, Object)");
	}

	public Object visit(ArithAtomicExpr n) {
		return unimplementedVisitor("visit(ArithAtomicExpr)");
	}

	public Object visit(ArithAtomicExpr n, Object o) {
		return unimplementedVisitor("visit(ArithAtomicExpr, Object)");
	}

	public Object visit(AtomicLiteralExpr n) {
		return unimplementedVisitor("visit(AtomicLiteralExpr)");
	}

	public Object visit(AtomicLiteralExpr n, Object o) {
		return unimplementedVisitor("visit(AtomicLiteralExpr, Object)");
	}

	public Object visit(AtomicVariableExpr n) {
		return unimplementedVisitor("visit(AtomicVariableExpr)");
	}

	public Object visit(AtomicVariableExpr n, Object o) {
		return unimplementedVisitor("visit(AtomicVariableExpr, Object)");
	}

	public Object visit(AtomicSelfExpr n) {
		return unimplementedVisitor("visit(AtomicSelfExpr)");
	}

	public Object visit(AtomicSelfExpr n, Object o) {
		return unimplementedVisitor("visit(AtomicSelfExpr, Object)");
	}

	public Object visit(AtomicCallExpr n) {
		return unimplementedVisitor("visit(AtomicCallExpr)");
	}

	public Object visit(AtomicCallExpr n, Object o) {
		return unimplementedVisitor("visit(AtomicCallExpr, Object)");
	}

	public Object visit(ParenQueryExpr n) {
		return unimplementedVisitor("visit(ParenQueryExpr)");
	}

	public Object visit(ParenQueryExpr n, Object o) {
		return unimplementedVisitor("visit(ParenQueryExpr, Object)");
	}

	public Object visit(StringPrimitiveLiteralExpr n) {
		return unimplementedVisitor("visit(StringPrimitiveLiteralExpr)");
	}

	public Object visit(StringPrimitiveLiteralExpr n, Object o) {
		return unimplementedVisitor("visit(StringPrimitiveLiteralExpr, Object)");
	}

	public Object visit(IntegerPrimitiveLiteralExpr n) {
		return unimplementedVisitor("visit(IntegerPrimitiveLiteralExpr)");
	}

	public Object visit(IntegerPrimitiveLiteralExpr n, Object o) {
		return unimplementedVisitor("visit(IntegerPrimitiveLiteralExpr, Object)");
	}

	public Object visit(BooleanPrimitiveLiteralExpr n) {
		return unimplementedVisitor("visit(BooleanPrimitiveLiteralExpr)");
	}

	public Object visit(BooleanPrimitiveLiteralExpr n, Object o) {
		return unimplementedVisitor("visit(BooleanPrimitiveLiteralExpr, Object)");
	}

	public Object visit(NullLiteralExpr n) {
		return unimplementedVisitor("visit(NullLiteralExpr)");
	}

	public Object visit(NullLiteralExpr n, Object o) {
		return unimplementedVisitor("visit(NullLiteralExpr, Object)");
	}

	public Object visit(CallLoopExpr n) {
		return unimplementedVisitor("visit(CallLoopExpr)");
	}

	public Object visit(CallLoopExpr n, Object o) {
		return unimplementedVisitor("visit(CallLoopExpr, Object)");
	}

	public Object visit(CallModelPropertyExpr n) {
		return unimplementedVisitor("visit(CallModelPropertyExpr)");
	}

	public Object visit(CallModelPropertyExpr n, Object o) {
		return unimplementedVisitor("visit(CallModelPropertyExpr, Object)");
	}

	public Object visit(FunctionCallExpr n) {
		return unimplementedVisitor("visit(FunctionCallExpr)");
	}

	public Object visit(FunctionCallExpr n, Object o) {
		return unimplementedVisitor("visit(FunctionCallExpr, Object)");
	}

	public Object visit(AttributeCallExpr n) {
		return unimplementedVisitor("visit(AttributeCallExpr)");
	}

	public Object visit(AttributeCallExpr n, Object o) {
		return unimplementedVisitor("visit(AttributeCallExpr, Object)");
	}

	public Object visit(CollectionOperationCallExpr n) {
		return unimplementedVisitor("visit(CollectionOperationCallExpr)");
	}

	public Object visit(CollectionOperationCallExpr n, Object o) {
		return unimplementedVisitor("visit(CollectionOperationCallExpr, Object)");
	}

	public Object visit(ObjectOperationCallExpr n) {
		return unimplementedVisitor("visit(ObjectOperationCallExpr)");
	}

	public Object visit(ObjectOperationCallExpr n, Object o) {
		return unimplementedVisitor("visit(ObjectOperationCallExpr, Object)");
	}

	public Object visit(MoreArgumentsExpr n) {
		return unimplementedVisitor("visit(MoreArgumentsExpr)");
	}

	public Object visit(MoreArgumentsExpr n, Object o) {
		return unimplementedVisitor("visit(MoreArgumentsExpr, Object)");
	}

	public Object visit(SingleArgumentsExpr n) {
		return unimplementedVisitor("visit(SingleArgumentsExpr)");
	}

	public Object visit(SingleArgumentsExpr n, Object o) {
		return unimplementedVisitor("visit(SingleArgumentsExpr, Object)");
	}

	public Object visit(EmptyArgumentsExpr n) {
		return unimplementedVisitor("visit(EmptyArgumentsExpr)");
	}

	public Object visit(EmptyArgumentsExpr n, Object o) {
		return unimplementedVisitor("visit(EmptyArgumentsExpr, Object)");
	}

	public Object visit(SelectLoopExpr n) {
		return unimplementedVisitor("visit(SelectLoopExpr)");
	}

	public Object visit(SelectLoopExpr n, Object o) {
		return unimplementedVisitor("visit(SelectLoopExpr, Object)");
	}

	public Object visit(CollectLoopExpr n) {
		return unimplementedVisitor("visit(CollectLoopExpr)");
	}

	public Object visit(CollectLoopExpr n, Object o) {
		return unimplementedVisitor("visit(CollectLoopExpr, Object)");
	}

	public Object visit(ForAllLoopExpr n) {
		return unimplementedVisitor("visit(ForAllLoopExpr)");
	}

	public Object visit(ForAllLoopExpr n, Object o) {
		return unimplementedVisitor("visit(ForAllLoopExpr, Object)");
	}

	public Object visit(ExistLoopExpr n) {
		return unimplementedVisitor("visit(ExistLoopExpr)");
	}

	public Object visit(ExistLoopExpr n, Object o) {
		return unimplementedVisitor("visit(ExistLoopExpr, Object)");
	}

	public Object visit(VariableDeclaration n) {
		return unimplementedVisitor("visit(VariableDeclaration)");
	}

	public Object visit(VariableDeclaration n, Object o) {
		return unimplementedVisitor("visit(VariableDeclaration, Object)");
	}

	public Object visit(BoolType n) {
		return unimplementedVisitor("visit(BoolType)");
	}

	public Object visit(BoolType n, Object o) {
		return unimplementedVisitor("visit(BoolType, Object)");
	}

	public Object visit(StringType n) {
		return unimplementedVisitor("visit(StringType)");
	}

	public Object visit(StringType n, Object o) {
		return unimplementedVisitor("visit(StringType, Object)");
	}

	public Object visit(IntType n) {
		return unimplementedVisitor("visit(IntType)");
	}

	public Object visit(IntType n, Object o) {
		return unimplementedVisitor("visit(IntType, Object)");
	}

	public Object visit(QName n) {
		return unimplementedVisitor("visit(QName)");
	}

	public Object visit(QName n, Object o) {
		return unimplementedVisitor("visit(QName, Object)");
	}

	public Object visit(SimpleName n) {
		return unimplementedVisitor("visit(SimpleName)");
	}

	public Object visit(SimpleName n, Object o) {
		return unimplementedVisitor("visit(SimpleName, Object)");
	}

	public Object visit(Ast n) {
		if (n instanceof AstToken)
			return visit((AstToken) n);
		else if (n instanceof Statements)
			return visit((Statements) n);
		else if (n instanceof AlternativeState)
			return visit((AlternativeState) n);
		else if (n instanceof QueryState)
			return visit((QueryState) n);
		else if (n instanceof IfState)
			return visit((IfState) n);
		else if (n instanceof IfElseState)
			return visit((IfElseState) n);
		else if (n instanceof Function)
			return visit((Function) n);
		else if (n instanceof SingleParameterExpr)
			return visit((SingleParameterExpr) n);
		else if (n instanceof MoreParametersExpr)
			return visit((MoreParametersExpr) n);
		else if (n instanceof EmptyParameterExpr)
			return visit((EmptyParameterExpr) n);
		else if (n instanceof QueryExpr)
			return visit((QueryExpr) n);
		else if (n instanceof CheckOnlyExpr)
			return visit((CheckOnlyExpr) n);
		else if (n instanceof EnforceExpr)
			return visit((EnforceExpr) n);
		else if (n instanceof AndExpr)
			return visit((AndExpr) n);
		else if (n instanceof OrExpr)
			return visit((OrExpr) n);
		else if (n instanceof NotExpr)
			return visit((NotExpr) n);
		else if (n instanceof LogicRelationalExpr)
			return visit((LogicRelationalExpr) n);
		else if (n instanceof EqualExpr)
			return visit((EqualExpr) n);
		else if (n instanceof GreaterExpr)
			return visit((GreaterExpr) n);
		else if (n instanceof LessExpr)
			return visit((LessExpr) n);
		else if (n instanceof RelationalArithExpr)
			return visit((RelationalArithExpr) n);
		else if (n instanceof PlusExpr)
			return visit((PlusExpr) n);
		else if (n instanceof MinusExpr)
			return visit((MinusExpr) n);
		else if (n instanceof ArithAtomicExpr)
			return visit((ArithAtomicExpr) n);
		else if (n instanceof AtomicLiteralExpr)
			return visit((AtomicLiteralExpr) n);
		else if (n instanceof AtomicVariableExpr)
			return visit((AtomicVariableExpr) n);
		else if (n instanceof AtomicSelfExpr)
			return visit((AtomicSelfExpr) n);
		else if (n instanceof AtomicCallExpr)
			return visit((AtomicCallExpr) n);
		else if (n instanceof ParenQueryExpr)
			return visit((ParenQueryExpr) n);
		else if (n instanceof StringPrimitiveLiteralExpr)
			return visit((StringPrimitiveLiteralExpr) n);
		else if (n instanceof IntegerPrimitiveLiteralExpr)
			return visit((IntegerPrimitiveLiteralExpr) n);
		else if (n instanceof BooleanPrimitiveLiteralExpr)
			return visit((BooleanPrimitiveLiteralExpr) n);
		else if (n instanceof NullLiteralExpr)
			return visit((NullLiteralExpr) n);
		else if (n instanceof CallLoopExpr)
			return visit((CallLoopExpr) n);
		else if (n instanceof CallModelPropertyExpr)
			return visit((CallModelPropertyExpr) n);
		else if (n instanceof FunctionCallExpr)
			return visit((FunctionCallExpr) n);
		else if (n instanceof AttributeCallExpr)
			return visit((AttributeCallExpr) n);
		else if (n instanceof CollectionOperationCallExpr)
			return visit((CollectionOperationCallExpr) n);
		else if (n instanceof ObjectOperationCallExpr)
			return visit((ObjectOperationCallExpr) n);
		else if (n instanceof MoreArgumentsExpr)
			return visit((MoreArgumentsExpr) n);
		else if (n instanceof SingleArgumentsExpr)
			return visit((SingleArgumentsExpr) n);
		else if (n instanceof EmptyArgumentsExpr)
			return visit((EmptyArgumentsExpr) n);
		else if (n instanceof SelectLoopExpr)
			return visit((SelectLoopExpr) n);
		else if (n instanceof CollectLoopExpr)
			return visit((CollectLoopExpr) n);
		else if (n instanceof ForAllLoopExpr)
			return visit((ForAllLoopExpr) n);
		else if (n instanceof ExistLoopExpr)
			return visit((ExistLoopExpr) n);
		else if (n instanceof VariableDeclaration)
			return visit((VariableDeclaration) n);
		else if (n instanceof BoolType)
			return visit((BoolType) n);
		else if (n instanceof StringType)
			return visit((StringType) n);
		else if (n instanceof IntType)
			return visit((IntType) n);
		else if (n instanceof QName)
			return visit((QName) n);
		else if (n instanceof SimpleName)
			return visit((SimpleName) n);
		throw new UnsupportedOperationException("visit("
				+ n.getClass().toString() + ")");
	}

	public Object visit(Ast n, Object o) {
		if (n instanceof AstToken)
			return visit((AstToken) n, o);
		else if (n instanceof Statements)
			return visit((Statements) n, o);
		else if (n instanceof AlternativeState)
			return visit((AlternativeState) n, o);
		else if (n instanceof QueryState)
			return visit((QueryState) n, o);
		else if (n instanceof IfState)
			return visit((IfState) n, o);
		else if (n instanceof IfElseState)
			return visit((IfElseState) n, o);
		else if (n instanceof Function)
			return visit((Function) n, o);
		else if (n instanceof SingleParameterExpr)
			return visit((SingleParameterExpr) n, o);
		else if (n instanceof MoreParametersExpr)
			return visit((MoreParametersExpr) n, o);
		else if (n instanceof EmptyParameterExpr)
			return visit((EmptyParameterExpr) n, o);
		else if (n instanceof QueryExpr)
			return visit((QueryExpr) n, o);
		else if (n instanceof CheckOnlyExpr)
			return visit((CheckOnlyExpr) n, o);
		else if (n instanceof EnforceExpr)
			return visit((EnforceExpr) n, o);
		else if (n instanceof AndExpr)
			return visit((AndExpr) n, o);
		else if (n instanceof OrExpr)
			return visit((OrExpr) n, o);
		else if (n instanceof NotExpr)
			return visit((NotExpr) n, o);
		else if (n instanceof LogicRelationalExpr)
			return visit((LogicRelationalExpr) n, o);
		else if (n instanceof EqualExpr)
			return visit((EqualExpr) n, o);
		else if (n instanceof GreaterExpr)
			return visit((GreaterExpr) n, o);
		else if (n instanceof LessExpr)
			return visit((LessExpr) n, o);
		else if (n instanceof RelationalArithExpr)
			return visit((RelationalArithExpr) n, o);
		else if (n instanceof PlusExpr)
			return visit((PlusExpr) n, o);
		else if (n instanceof MinusExpr)
			return visit((MinusExpr) n, o);
		else if (n instanceof ArithAtomicExpr)
			return visit((ArithAtomicExpr) n, o);
		else if (n instanceof AtomicLiteralExpr)
			return visit((AtomicLiteralExpr) n, o);
		else if (n instanceof AtomicVariableExpr)
			return visit((AtomicVariableExpr) n, o);
		else if (n instanceof AtomicSelfExpr)
			return visit((AtomicSelfExpr) n, o);
		else if (n instanceof AtomicCallExpr)
			return visit((AtomicCallExpr) n, o);
		else if (n instanceof ParenQueryExpr)
			return visit((ParenQueryExpr) n, o);
		else if (n instanceof StringPrimitiveLiteralExpr)
			return visit((StringPrimitiveLiteralExpr) n, o);
		else if (n instanceof IntegerPrimitiveLiteralExpr)
			return visit((IntegerPrimitiveLiteralExpr) n, o);
		else if (n instanceof BooleanPrimitiveLiteralExpr)
			return visit((BooleanPrimitiveLiteralExpr) n, o);
		else if (n instanceof NullLiteralExpr)
			return visit((NullLiteralExpr) n, o);
		else if (n instanceof CallLoopExpr)
			return visit((CallLoopExpr) n, o);
		else if (n instanceof CallModelPropertyExpr)
			return visit((CallModelPropertyExpr) n, o);
		else if (n instanceof FunctionCallExpr)
			return visit((FunctionCallExpr) n, o);
		else if (n instanceof AttributeCallExpr)
			return visit((AttributeCallExpr) n, o);
		else if (n instanceof CollectionOperationCallExpr)
			return visit((CollectionOperationCallExpr) n, o);
		else if (n instanceof ObjectOperationCallExpr)
			return visit((ObjectOperationCallExpr) n, o);
		else if (n instanceof MoreArgumentsExpr)
			return visit((MoreArgumentsExpr) n, o);
		else if (n instanceof SingleArgumentsExpr)
			return visit((SingleArgumentsExpr) n, o);
		else if (n instanceof EmptyArgumentsExpr)
			return visit((EmptyArgumentsExpr) n, o);
		else if (n instanceof SelectLoopExpr)
			return visit((SelectLoopExpr) n, o);
		else if (n instanceof CollectLoopExpr)
			return visit((CollectLoopExpr) n, o);
		else if (n instanceof ForAllLoopExpr)
			return visit((ForAllLoopExpr) n, o);
		else if (n instanceof ExistLoopExpr)
			return visit((ExistLoopExpr) n, o);
		else if (n instanceof VariableDeclaration)
			return visit((VariableDeclaration) n, o);
		else if (n instanceof BoolType)
			return visit((BoolType) n, o);
		else if (n instanceof StringType)
			return visit((StringType) n, o);
		else if (n instanceof IntType)
			return visit((IntType) n, o);
		else if (n instanceof QName)
			return visit((QName) n, o);
		else if (n instanceof SimpleName)
			return visit((SimpleName) n, o);
		throw new UnsupportedOperationException("visit("
				+ n.getClass().toString() + ")");
	}
}
