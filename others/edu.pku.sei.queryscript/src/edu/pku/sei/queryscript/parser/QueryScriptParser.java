package edu.pku.sei.queryscript.parser;

import lpg.runtime.BadParseException;
import lpg.runtime.BadParseSymFileException;
import lpg.runtime.DeterministicParser;
import lpg.runtime.DiagnoseParser;
import lpg.runtime.ErrorToken;
import lpg.runtime.ILexStream;
import lpg.runtime.IToken;
import lpg.runtime.Monitor;
import lpg.runtime.NotDeterministicParseTableException;
import lpg.runtime.NullExportedSymbolsException;
import lpg.runtime.NullTerminalSymbolsException;
import lpg.runtime.ParseTable;
import lpg.runtime.PrsStream;
import lpg.runtime.RuleAction;
import lpg.runtime.UndefinedEofSymbolException;
import lpg.runtime.UnimplementedTerminalsException;
import edu.pku.sei.queryscript.parser.Ast.AlternativeState;
import edu.pku.sei.queryscript.parser.Ast.AndExpr;
import edu.pku.sei.queryscript.parser.Ast.ArithAtomicExpr;
import edu.pku.sei.queryscript.parser.Ast.Ast;
import edu.pku.sei.queryscript.parser.Ast.AtomicCallExpr;
import edu.pku.sei.queryscript.parser.Ast.AtomicLiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.AtomicSelfExpr;
import edu.pku.sei.queryscript.parser.Ast.AtomicVariableExpr;
import edu.pku.sei.queryscript.parser.Ast.AttributeCallExpr;
import edu.pku.sei.queryscript.parser.Ast.BoolType;
import edu.pku.sei.queryscript.parser.Ast.BooleanPrimitiveLiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.CallLoopExpr;
import edu.pku.sei.queryscript.parser.Ast.CallModelPropertyExpr;
import edu.pku.sei.queryscript.parser.Ast.CheckOnlyExpr;
import edu.pku.sei.queryscript.parser.Ast.CollectLoopExpr;
import edu.pku.sei.queryscript.parser.Ast.CollectionOperationCallExpr;
import edu.pku.sei.queryscript.parser.Ast.EmptyArgumentsExpr;
import edu.pku.sei.queryscript.parser.Ast.EmptyParameterExpr;
import edu.pku.sei.queryscript.parser.Ast.EnforceExpr;
import edu.pku.sei.queryscript.parser.Ast.EqualExpr;
import edu.pku.sei.queryscript.parser.Ast.ExistLoopExpr;
import edu.pku.sei.queryscript.parser.Ast.ForAllLoopExpr;
import edu.pku.sei.queryscript.parser.Ast.Function;
import edu.pku.sei.queryscript.parser.Ast.FunctionCallExpr;
import edu.pku.sei.queryscript.parser.Ast.GreaterExpr;
import edu.pku.sei.queryscript.parser.Ast.IArgumentsExpr;
import edu.pku.sei.queryscript.parser.Ast.IArithExpr;
import edu.pku.sei.queryscript.parser.Ast.IAtomicExpr;
import edu.pku.sei.queryscript.parser.Ast.ICallExpr;
import edu.pku.sei.queryscript.parser.Ast.ILiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.ILogicExpr;
import edu.pku.sei.queryscript.parser.Ast.ILoopExpr;
import edu.pku.sei.queryscript.parser.Ast.IModelPropertyExpr;
import edu.pku.sei.queryscript.parser.Ast.IParametersExpr;
import edu.pku.sei.queryscript.parser.Ast.IQName;
import edu.pku.sei.queryscript.parser.Ast.IQueryExpr;
import edu.pku.sei.queryscript.parser.Ast.IRelationalExpr;
import edu.pku.sei.queryscript.parser.Ast.IStatement;
import edu.pku.sei.queryscript.parser.Ast.IStatements;
import edu.pku.sei.queryscript.parser.Ast.ITypeName;
import edu.pku.sei.queryscript.parser.Ast.IfElseState;
import edu.pku.sei.queryscript.parser.Ast.IfState;
import edu.pku.sei.queryscript.parser.Ast.IntType;
import edu.pku.sei.queryscript.parser.Ast.IntegerPrimitiveLiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.LessExpr;
import edu.pku.sei.queryscript.parser.Ast.LogicRelationalExpr;
import edu.pku.sei.queryscript.parser.Ast.MinusExpr;
import edu.pku.sei.queryscript.parser.Ast.MoreArgumentsExpr;
import edu.pku.sei.queryscript.parser.Ast.MoreParametersExpr;
import edu.pku.sei.queryscript.parser.Ast.NotExpr;
import edu.pku.sei.queryscript.parser.Ast.NullLiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.ObjectOperationCallExpr;
import edu.pku.sei.queryscript.parser.Ast.OrExpr;
import edu.pku.sei.queryscript.parser.Ast.ParenQueryExpr;
import edu.pku.sei.queryscript.parser.Ast.PlusExpr;
import edu.pku.sei.queryscript.parser.Ast.QName;
import edu.pku.sei.queryscript.parser.Ast.QueryExpr;
import edu.pku.sei.queryscript.parser.Ast.QueryState;
import edu.pku.sei.queryscript.parser.Ast.RelationalArithExpr;
import edu.pku.sei.queryscript.parser.Ast.SelectLoopExpr;
import edu.pku.sei.queryscript.parser.Ast.SimpleName;
import edu.pku.sei.queryscript.parser.Ast.SingleArgumentsExpr;
import edu.pku.sei.queryscript.parser.Ast.SingleParameterExpr;
import edu.pku.sei.queryscript.parser.Ast.Statements;
import edu.pku.sei.queryscript.parser.Ast.StringPrimitiveLiteralExpr;
import edu.pku.sei.queryscript.parser.Ast.StringType;
import edu.pku.sei.queryscript.parser.Ast.VariableDeclaration;

public class QueryScriptParser extends PrsStream implements RuleAction {
	private boolean unimplementedSymbolsWarning = false;

	private static ParseTable prs = new QueryScriptParserprs();

	public ParseTable getParseTable() {
		return prs;
	}

	private DeterministicParser dtParser = null;

	public DeterministicParser getParser() {
		return dtParser;
	}

	private void setResult(Object object) {
		dtParser.setSym1(object);
	}

	public Object getRhsSym(int i) {
		return dtParser.getSym(i);
	}

	public int getRhsTokenIndex(int i) {
		return dtParser.getToken(i);
	}

	public IToken getRhsIToken(int i) {
		return super.getIToken(getRhsTokenIndex(i));
	}

	public int getRhsFirstTokenIndex(int i) {
		return dtParser.getFirstToken(i);
	}

	public IToken getRhsFirstIToken(int i) {
		return super.getIToken(getRhsFirstTokenIndex(i));
	}

	public int getRhsLastTokenIndex(int i) {
		return dtParser.getLastToken(i);
	}

	public IToken getRhsLastIToken(int i) {
		return super.getIToken(getRhsLastTokenIndex(i));
	}

	public int getLeftSpan() {
		return dtParser.getFirstToken();
	}

	public IToken getLeftIToken() {
		return super.getIToken(getLeftSpan());
	}

	public int getRightSpan() {
		return dtParser.getLastToken();
	}

	public IToken getRightIToken() {
		return super.getIToken(getRightSpan());
	}

	public int getRhsErrorTokenIndex(int i) {
		int index = dtParser.getToken(i);
		IToken err = super.getIToken(index);
		return (err instanceof ErrorToken ? index : 0);
	}

	public ErrorToken getRhsErrorIToken(int i) {
		int index = dtParser.getToken(i);
		IToken err = super.getIToken(index);
		return (ErrorToken) (err instanceof ErrorToken ? err : null);
	}

	public QueryScriptParser(ILexStream lexStream) {
		super(lexStream);

		try {
			super.remapTerminalSymbols(orderedTerminalSymbols(),
					QueryScriptParserprs.EOFT_SYMBOL);
		} catch (NullExportedSymbolsException e) {
		} catch (NullTerminalSymbolsException e) {
		} catch (UnimplementedTerminalsException e) {
			if (unimplementedSymbolsWarning) {
				java.util.ArrayList unimplemented_symbols = e.getSymbols();
				System.out
						.println("The Lexer will not scan the following token(s):");
				for (int i = 0; i < unimplemented_symbols.size(); i++) {
					Integer id = (Integer) unimplemented_symbols.get(i);
					System.out.println("    "
							+ QueryScriptParsersym.orderedTerminalSymbols[id
									.intValue()]);
				}
				System.out.println();
			}
		} catch (UndefinedEofSymbolException e) {
			throw new Error(
					new UndefinedEofSymbolException(
							"The Lexer does not implement the Eof symbol "
									+ QueryScriptParsersym.orderedTerminalSymbols[QueryScriptParserprs.EOFT_SYMBOL]));
		}

		try {
			dtParser = new DeterministicParser(this, prs, this);
		} catch (NotDeterministicParseTableException e) {
			throw new Error(
					new NotDeterministicParseTableException(
							"Regenerate QueryScriptParserprs.java with -NOBACKTRACK option"));
		} catch (BadParseSymFileException e) {
			throw new Error(
					new BadParseSymFileException(
							"Bad Parser Symbol File -- QueryScriptParsersym.java. Regenerate QueryScriptParserprs.java"));
		}
	}

	public String[] orderedTerminalSymbols() {
		return QueryScriptParsersym.orderedTerminalSymbols;
	}

	public String getTokenKindName(int kind) {
		return QueryScriptParsersym.orderedTerminalSymbols[kind];
	}

	public int getEOFTokenKind() {
		return QueryScriptParserprs.EOFT_SYMBOL;
	}

	public PrsStream getParseStream() {
		return (PrsStream) this;
	}

	public Ast parser() {
		return parser(null, 0);
	}

	public Ast parser(Monitor monitor) {
		return parser(monitor, 0);
	}

	public Ast parser(int error_repair_count) {
		return parser(null, error_repair_count);
	}

	public Ast parser(Monitor monitor, int error_repair_count) {
		dtParser.setMonitor(monitor);

		try {
			return (Ast) dtParser.parse();
		} catch (BadParseException e) {
			reset(e.error_token); // point to error token

			DiagnoseParser diagnoseParser = new DiagnoseParser(this, prs);
			diagnoseParser.diagnose(e.error_token);
		}

		return null;
	}

	//
	// Additional entry points, if any
	//

	public void ruleAction(int ruleNumber) {
		switch (ruleNumber) {

		//
		// Rule 1: goal ::= Statements
		//
		case 1:
			break;
		//
		// Rule 2: goal ::= Function
		//
		case 2:
			break;
		//
		// Rule 3: Statements ::= Statements Statement
		//
		case 3: {
			setResult(new Statements(getLeftIToken(), getRightIToken(),
					(IStatements) getRhsSym(1), (IStatement) getRhsSym(2)));
			break;
		}
			//
			// Rule 4: Statements ::= Statement
			//
		case 4:
			break;
		//
		// Rule 5: Statement ::= QueryExpr # Statement
		//
		case 5: {
			setResult(new AlternativeState(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(1), (IStatement) getRhsSym(3)));
			break;
		}
			//
			// Rule 6: Statement ::= QueryExpr ;
			//
		case 6: {
			setResult(new QueryState(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 7: Statement ::= if LogicExpr then Statements endif
			//
		case 7: {
			setResult(new IfState(getLeftIToken(), getRightIToken(),
					(ILogicExpr) getRhsSym(2), (IStatements) getRhsSym(4)));
			break;
		}
			//
			// Rule 8: Statement ::= if LogicExpr then Statements$ThenStatements
			// else Statements$ElseStatements endif
			//
		case 8: {
			setResult(new IfElseState(getLeftIToken(), getRightIToken(),
					(ILogicExpr) getRhsSym(2), (IStatements) getRhsSym(4),
					(IStatements) getRhsSym(6)));
			break;
		}
			//
			// Rule 9: Function ::= query SimpleName ( ParametersExpr ) :
			// TypeName { Statements }
			//
		case 9: {
			setResult(new Function(getLeftIToken(), getRightIToken(),
					(SimpleName) getRhsSym(2), (IParametersExpr) getRhsSym(4),
					(ITypeName) getRhsSym(7), (IStatements) getRhsSym(9)));
			break;
		}
			//
			// Rule 10: ParametersExpr ::= VariableDeclaration
			//
		case 10: {
			setResult(new SingleParameterExpr(getLeftIToken(),
					getRightIToken(), (VariableDeclaration) getRhsSym(1)));
			break;
		}
			//
			// Rule 11: ParametersExpr ::= ParametersExpr , VariableDeclaration
			//
		case 11: {
			setResult(new MoreParametersExpr(getLeftIToken(), getRightIToken(),
					(IParametersExpr) getRhsSym(1),
					(VariableDeclaration) getRhsSym(3)));
			break;
		}
			//
			// Rule 12: ParametersExpr ::= $Empty
			//
		case 12: {
			setResult(new EmptyParameterExpr(getLeftIToken(), getRightIToken()));
			break;
		}
			//
			// Rule 13: QueryExpr ::= LogicExpr
			//
		case 13:
			break;
		//
		// Rule 14: QueryExpr ::= QueryExpr , LogicExpr
		//
		case 14: {
			setResult(new QueryExpr(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(1), (ILogicExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 15: QueryExpr ::= [ $ QueryExpr ]
			//
		case 15: {
			setResult(new CheckOnlyExpr(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 16: QueryExpr ::= [ % QueryExpr ]
			//
		case 16: {
			setResult(new EnforceExpr(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 17: LogicExpr ::= LogicExpr and RelationalExpr
			//
		case 17: {
			setResult(new AndExpr(getLeftIToken(), getRightIToken(),
					(ILogicExpr) getRhsSym(1), (IRelationalExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 18: LogicExpr ::= LogicExpr or RelationalExpr
			//
		case 18: {
			setResult(new OrExpr(getLeftIToken(), getRightIToken(),
					(ILogicExpr) getRhsSym(1), (IRelationalExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 19: LogicExpr ::= not RelationalExpr
			//
		case 19: {
			setResult(new NotExpr(getLeftIToken(), getRightIToken(),
					(IRelationalExpr) getRhsSym(2)));
			break;
		}
			//
			// Rule 20: LogicExpr ::= RelationalExpr
			//
		case 20: {
			setResult(new LogicRelationalExpr(getLeftIToken(),
					getRightIToken(), (IRelationalExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 21: RelationalExpr ::= ArithExpr$LeftArithExpr =
			// ArithExpr$RightArithExpr
			//
		case 21: {
			setResult(new EqualExpr(getLeftIToken(), getRightIToken(),
					(IArithExpr) getRhsSym(1), (IArithExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 22: RelationalExpr ::= ArithExpr$LeftArithExpr >
			// ArithExpr$RightArithExpr
			//
		case 22: {
			setResult(new GreaterExpr(getLeftIToken(), getRightIToken(),
					(IArithExpr) getRhsSym(1), (IArithExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 23: RelationalExpr ::= ArithExpr$LeftArithExpr <
			// ArithExpr$RightArithExpr
			//
		case 23: {
			setResult(new LessExpr(getLeftIToken(), getRightIToken(),
					(IArithExpr) getRhsSym(1), (IArithExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 24: RelationalExpr ::= ArithExpr
			//
		case 24: {
			setResult(new RelationalArithExpr(getLeftIToken(),
					getRightIToken(), (IArithExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 25: ArithExpr ::= ArithExpr + AtomicExpr
			//
		case 25: {
			setResult(new PlusExpr(getLeftIToken(), getRightIToken(),
					(IArithExpr) getRhsSym(1), (IAtomicExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 26: ArithExpr ::= ArithExpr - AtomicExpr
			//
		case 26: {
			setResult(new MinusExpr(getLeftIToken(), getRightIToken(),
					(IArithExpr) getRhsSym(1), (IAtomicExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 27: ArithExpr ::= AtomicExpr
			//
		case 27: {
			setResult(new ArithAtomicExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 28: AtomicExpr ::= LiteralExpr
			//
		case 28: {
			setResult(new AtomicLiteralExpr(getLeftIToken(), getRightIToken(),
					(ILiteralExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 29: AtomicExpr ::= VariableExpr
			//
		case 29: {
			setResult(new AtomicVariableExpr(getLeftIToken(), getRightIToken(),
					(SimpleName) getRhsSym(1)));
			break;
		}
			//
			// Rule 30: AtomicExpr ::= self
			//
		case 30: {
			setResult(new AtomicSelfExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 31: AtomicExpr ::= CallExpr
			//
		case 31: {
			setResult(new AtomicCallExpr(getLeftIToken(), getRightIToken(),
					(ICallExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 32: AtomicExpr ::= ( QueryExpr )
			//
		case 32: {
			setResult(new ParenQueryExpr(getLeftIToken(), getRightIToken(),
					(IQueryExpr) getRhsSym(2)));
			break;
		}
			//
			// Rule 33: LiteralExpr ::= PrimitiveLiteralExpr
			//
		case 33:
			break;
		//
		// Rule 34: PrimitiveLiteralExpr ::= STRING_LITERAL
		//
		case 34: {
			setResult(new StringPrimitiveLiteralExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 35: PrimitiveLiteralExpr ::= INTEGER_LITERAL
			//
		case 35: {
			setResult(new IntegerPrimitiveLiteralExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 36: PrimitiveLiteralExpr ::= true
			//
		case 36: {
			setResult(new BooleanPrimitiveLiteralExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 37: PrimitiveLiteralExpr ::= false
			//
		case 37: {
			setResult(new BooleanPrimitiveLiteralExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 38: PrimitiveLiteralExpr ::= null
			//
		case 38: {
			setResult(new NullLiteralExpr(getRhsIToken(1)));
			break;
		}
			//
			// Rule 39: CallExpr ::= LoopExpr
			//
		case 39: {
			setResult(new CallLoopExpr(getLeftIToken(), getRightIToken(),
					(ILoopExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 40: CallExpr ::= ModelPropertyExpr
			//
		case 40: {
			setResult(new CallModelPropertyExpr(getLeftIToken(),
					getRightIToken(), (IModelPropertyExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 41: CallExpr ::= SimpleName ( ArgumentsExpr )
			//
		case 41: {
			setResult(new FunctionCallExpr(getLeftIToken(), getRightIToken(),
					(SimpleName) getRhsSym(1), (IArgumentsExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 42: ModelPropertyExpr ::= AtomicExpr . SimpleName
			//
		case 42: {
			setResult(new AttributeCallExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1), (SimpleName) getRhsSym(3)));
			break;
		}
			//
			// Rule 43: ModelPropertyExpr ::= AtomicExpr -> SimpleName (
			// ArgumentsExpr )
			//
		case 43: {
			setResult(new CollectionOperationCallExpr(getLeftIToken(),
					getRightIToken(), (IAtomicExpr) getRhsSym(1),
					(SimpleName) getRhsSym(3), (IArgumentsExpr) getRhsSym(5)));
			break;
		}
			//
			// Rule 44: ModelPropertyExpr ::= AtomicExpr . SimpleName (
			// ArgumentsExpr )
			//
		case 44: {
			setResult(new ObjectOperationCallExpr(getLeftIToken(),
					getRightIToken(), (IAtomicExpr) getRhsSym(1),
					(SimpleName) getRhsSym(3), (IArgumentsExpr) getRhsSym(5)));
			break;
		}
			//
			// Rule 45: ArgumentsExpr ::= ArgumentsExpr , LogicExpr
			//
		case 45: {
			setResult(new MoreArgumentsExpr(getLeftIToken(), getRightIToken(),
					(IArgumentsExpr) getRhsSym(1), (ILogicExpr) getRhsSym(3)));
			break;
		}
			//
			// Rule 46: ArgumentsExpr ::= LogicExpr
			//
		case 46: {
			setResult(new SingleArgumentsExpr(getLeftIToken(),
					getRightIToken(), (ILogicExpr) getRhsSym(1)));
			break;
		}
			//
			// Rule 47: ArgumentsExpr ::= $Empty
			//
		case 47: {
			setResult(new EmptyArgumentsExpr(getLeftIToken(), getRightIToken()));
			break;
		}
			//
			// Rule 48: LoopExpr ::= AtomicExpr -> select ( VariableDeclaration
			// | QueryExpr )
			//
		case 48: {
			setResult(new SelectLoopExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1),
					(VariableDeclaration) getRhsSym(5),
					(IQueryExpr) getRhsSym(7)));
			break;
		}
			//
			// Rule 49: LoopExpr ::= AtomicExpr -> collect ( VariableDeclaration
			// | QueryExpr )
			//
		case 49: {
			setResult(new CollectLoopExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1),
					(VariableDeclaration) getRhsSym(5),
					(IQueryExpr) getRhsSym(7)));
			break;
		}
			//
			// Rule 50: LoopExpr ::= AtomicExpr -> forAll ( VariableDeclaration
			// | QueryExpr )
			//
		case 50: {
			setResult(new ForAllLoopExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1),
					(VariableDeclaration) getRhsSym(5),
					(IQueryExpr) getRhsSym(7)));
			break;
		}
			//
			// Rule 51: LoopExpr ::= AtomicExpr -> exists ( VariableDeclaration
			// | QueryExpr )
			//
		case 51: {
			setResult(new ExistLoopExpr(getLeftIToken(), getRightIToken(),
					(IAtomicExpr) getRhsSym(1),
					(VariableDeclaration) getRhsSym(5),
					(IQueryExpr) getRhsSym(7)));
			break;
		}
			//
			// Rule 52: VariableDeclaration ::= SimpleName : TypeName
			//
		case 52: {
			setResult(new VariableDeclaration(getLeftIToken(),
					getRightIToken(), (SimpleName) getRhsSym(1),
					(ITypeName) getRhsSym(3)));
			break;
		}
			//
			// Rule 53: VariableExpr ::= SimpleName
			//
		case 53:
			break;
		//
		// Rule 54: TypeName ::= PrimitiveTypeName
		//
		case 54:
			break;
		//
		// Rule 55: PrimitiveTypeName ::= Boolean
		//
		case 55: {
			setResult(new BoolType(getRhsIToken(1)));
			break;
		}
			//
			// Rule 56: PrimitiveTypeName ::= String
			//
		case 56: {
			setResult(new StringType(getRhsIToken(1)));
			break;
		}
			//
			// Rule 57: PrimitiveTypeName ::= Integer
			//
		case 57: {
			setResult(new IntType(getRhsIToken(1)));
			break;
		}
			//
			// Rule 58: TypeName ::= QName
			//
		case 58:
			break;
		//
		// Rule 59: QName ::= QName :: SimpleName
		//
		case 59: {
			setResult(new QName(getLeftIToken(), getRightIToken(),
					(IQName) getRhsSym(1), (SimpleName) getRhsSym(3)));
			break;
		}
			//
			// Rule 60: QName ::= SimpleName
			//
		case 60:
			break;
		//
		// Rule 61: SimpleName ::= IDENTIFIER
		//
		case 61: {
			setResult(new SimpleName(getRhsIToken(1)));
			break;
		}

		default:
			break;
		}
		return;
	}
}
