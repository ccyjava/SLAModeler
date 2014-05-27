--
-- The OCL Parser
--

%options escape=$
%options la=2
%options table=java
%options fp=QueryScriptParser,prefix=TK_
%options error-maps
%options scopes
%options margin=4
%options noserialize
%options package=edu.pku.sei.queryscript.parser
%options template=dtParserTemplateD.g
%options import_terminals=QueryScriptLexer.g
%options programming_language=java
--%options action=("*.java", "/.", "./")
%options ParseTable=lpg.runtime.ParseTable
%options ast_directory=./Ast,automatic_ast=toplevel,var=nt,visitor=default 

$KeyWords
	self
	inv
	pre
	post
	endpackage
	def
	if
	then
	else
	endif
	and
	or
	xor
	not
	implies
	let
	in
	true
	false

	--
	-- the following appear to have been omitted from the list of
	-- OCL reserved words in Section 7.4.9.  They will be treated 
	-- as unreserved for compliance
	--
	body
	derive
	init
	null
--  return  -- don't need a keyword for LPG purposes

	--
	-- the remainder of the LPG keywords are defined as such for the
	-- purpose of constructing the CST grammar.  They are not OCL
	-- reserved words
	--		
	Set
	Bag
	Sequence
	Collection
	OrderedSet

	iterate
	forAll
	exists
	isUnique
	any
	one

	collect
	select
	reject
	collectNested
	sortedBy

	closure

	oclIsKindOf
	oclIsTypeOf
	oclAsType
	oclIsNew
	oclIsUndefined
	oclIsInvalid
	oclIsInState
	allInstances

	String
	Integer
	UnlimitedNatural
	Real
	Boolean
	Tuple
	OclAny
	OclVoid
	Invalid
	OclMessage
	
	OclInvalid
	
	context
	package
	
	--
	-- the following are not used in the OCL concrete syntax, but
	-- are defined as reserved words in the Spec 7.4.9
	--
	attr
	oper
	
	query
$End

%Globals
    /.import lpg.runtime.*;
    ./
%End
$Identifier
	IDENTIFIER
$End

$Terminals
	
	NUMERIC_OPERATION

	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL
	
	PLUS     ::= '+'
	MINUS    ::= '-'
	MULTIPLY ::= '*'
	DIVIDE   ::= '/'

	GREATER       ::= '>'
	LESS          ::= '<'
	EQUAL         ::= '='
	GREATER_EQUAL ::= '>='
	LESS_EQUAL    ::= '<='
	NOT_EQUAL     ::= '<>'

	LPAREN   ::= '('
	RPAREN   ::= ')'
	LBRACE   ::= '{'
	RBRACE   ::= '}'
	LBRACKET ::= '['
	RBRACKET ::= ']'

	ARROW      ::= '->'
	BAR        ::= '|'
	COMMA      ::= ','
	COLON      ::= ':'
	COLONCOLON ::= '::'
	SEMICOLON  ::= ';'
	DOT        ::= '.'
	DOTDOT     ::= '..'
	ATPRE      ::= '@pre'

	CARET        ::= '^'
	CARETCARET   ::= '^^'
	QUESTIONMARK ::= '?'
	
	DOLLAR		 ::= '$'
	SHARP		 ::= '#'
	PERCENT		 ::= '%'

$End

$EOF
    EOF_TOKEN
$End

$ERROR
    ERROR_TOKEN
$End

$Start
	goal
$End


$Rules

------------------------

goal ::= Statements
goal ::= Function

Statements ::= Statements Statement
Statements ::= Statement

Statement$AlternativeState ::= QueryExpr '#' Statement
Statement$QueryState ::= QueryExpr ';'
Statement$IfState ::= if LogicExpr then Statements endif
Statement$IfElseState ::= if LogicExpr then Statements$ThenStatements else Statements$ElseStatements endif

Function ::= query SimpleName '(' ParametersExpr ')' ':' TypeName '{' Statements '}'

ParametersExpr$SingleParameterExpr ::= VariableDeclaration
ParametersExpr$MoreParametersExpr ::= ParametersExpr ',' VariableDeclaration
ParametersExpr$EmptyParameterExpr ::= $empty

QueryExpr ::= LogicExpr
QueryExpr ::= QueryExpr ',' LogicExpr
QueryExpr$CheckOnlyExpr ::= '[' '$' QueryExpr ']'
QueryExpr$EnforceExpr ::= '[' '%' QueryExpr ']'
------------------------

LogicExpr$AndExpr ::= LogicExpr and RelationalExpr

LogicExpr$OrExpr ::= LogicExpr or RelationalExpr

LogicExpr$NotExpr ::= not RelationalExpr

LogicExpr$LogicRelationalExpr ::= RelationalExpr

-----------------------


RelationalExpr$EqualExpr ::= ArithExpr$LeftArithExpr '=' ArithExpr$RightArithExpr

RelationalExpr$GreaterExpr ::= ArithExpr$LeftArithExpr '>' ArithExpr$RightArithExpr

RelationalExpr$LessExpr ::= ArithExpr$LeftArithExpr '<' ArithExpr$RightArithExpr

RelationalExpr$RelationalArithExpr ::= ArithExpr


-------------------------

ArithExpr$PlusExpr ::= ArithExpr '+' AtomicExpr
ArithExpr$MinusExpr ::= ArithExpr '-' AtomicExpr

ArithExpr$ArithAtomicExpr ::= AtomicExpr

-----------------------------------------

AtomicExpr$AtomicLiteralExpr ::= LiteralExpr

AtomicExpr$AtomicVariableExpr ::= VariableExpr

AtomicExpr$AtomicSelfExpr ::= self

AtomicExpr$AtomicCallExpr ::= CallExpr

AtomicExpr$ParenQueryExpr ::= '(' QueryExpr ')'



------------------------

LiteralExpr ::= PrimitiveLiteralExpr

---------------------------

PrimitiveLiteralExpr$StringPrimitiveLiteralExpr ::=  STRING_LITERAL

PrimitiveLiteralExpr$IntegerPrimitiveLiteralExpr ::=  INTEGER_LITERAL

PrimitiveLiteralExpr$BooleanPrimitiveLiteralExpr ::= true | false

PrimitiveLiteralExpr$NullLiteralExpr ::= null

--------------------------

CallExpr$CallLoopExpr ::= LoopExpr 
CallExpr$CallModelPropertyExpr ::= ModelPropertyExpr
CallExpr$FunctionCallExpr ::= SimpleName '(' ArgumentsExpr ')'
----------------------------

ModelPropertyExpr$AttributeCallExpr ::= AtomicExpr '.' SimpleName
ModelPropertyExpr$CollectionOperationCallExpr ::= AtomicExpr '->' SimpleName '(' ArgumentsExpr ')'
ModelPropertyExpr$ObjectOperationCallExpr ::= AtomicExpr '.' SimpleName '(' ArgumentsExpr ')'

--------------------------------

ArgumentsExpr$MoreArgumentsExpr ::= ArgumentsExpr ',' LogicExpr

ArgumentsExpr$SingleArgumentsExpr ::= LogicExpr

ArgumentsExpr$EmptyArgumentsExpr ::= $empty

--------------------------------

LoopExpr$SelectLoopExpr ::= AtomicExpr '->' select '(' VariableDeclaration '|' QueryExpr ')'
LoopExpr$CollectLoopExpr ::= AtomicExpr '->' collect '(' VariableDeclaration '|' QueryExpr ')'
LoopExpr$ForAllLoopExpr ::= AtomicExpr '->' forAll '(' VariableDeclaration '|' QueryExpr ')'
LoopExpr$ExistLoopExpr ::= AtomicExpr '->' exists '(' VariableDeclaration '|' QueryExpr ')'

-----------------------------------

VariableDeclaration ::= SimpleName ':' TypeName

-----------------------------------

VariableExpr ::= SimpleName

TypeName ::= PrimitiveTypeName

PrimitiveTypeName$BoolType ::= Boolean
PrimitiveTypeName$StringType ::= String
PrimitiveTypeName$IntType ::= Integer

TypeName ::= QName


QName ::= QName '::' SimpleName
QName ::= SimpleName
SimpleName ::= IDENTIFIER
-----------------------------------




$End
