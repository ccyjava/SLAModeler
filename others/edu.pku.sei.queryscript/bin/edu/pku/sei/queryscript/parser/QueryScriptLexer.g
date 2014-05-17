%options escape=$
%options la=2
%options fp=QueryScriptLexer,prefix=Char_
%options single-productions
%options noserialize
%options package=edu.pku.sei.queryscript.parser
%options template=LexerTemplateD.g
%options filter=QueryScriptKWLexer.g
%options export_terminals=("QueryScriptLexer.java", "TK_")

$Include
	LexerBasicMap.g
$End

$Export

	IDENTIFIER
	STRING_LITERAL
	INTEGER_LITERAL
	REAL_LITERAL
--	NUMERIC_OPERATION
	INTEGER_RANGE_START
	
	PLUS
	MINUS
	MULTIPLY
	DIVIDE

	GREATER
	LESS
	EQUAL
	GREATER_EQUAL
	LESS_EQUAL
	NOT_EQUAL

	LPAREN
	RPAREN
	LBRACE
	RBRACE
	LBRACKET
	RBRACKET

	ARROW
	BAR
	COMMA
	COLON
	COLONCOLON
	SEMICOLON
	DOT
	DOTDOT
	ATPRE
	
	CARET
	CARETCARET
	QUESTIONMARK
	
	SHARP
	DOLLAR
	PERCENT

$End

$Define
$kw_lexer_class /.QueryScriptKWLexer./
$End

$Terminals
	CtlCharNotWS

	LF   CR   HT   FF

	a b c d e f g h i j k l m n o p q r s t u v w x y z
	_

	A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

	0 1 2 3 4 5 6 7 8 9

	AfterASCIINotAcute
	Acute
	Space        ::= ' '
	LF           ::= NewLine
	CR           ::= Return
	HT           ::= HorizontalTab
	FF           ::= FormFeed
	DoubleQuote  ::= '"'
	SingleQuote  ::= "'"
	Percent      ::= '%'
	VerticalBar  ::= '|'
	Exclamation  ::= '!'
	AtSign       ::= '@'
	BackQuote    ::= '`'
	Tilde        ::= '~'
	Sharp        ::= '#'
	DollarSign   ::= '$'
	Ampersand    ::= '&'
	Caret        ::= '^'
	Colon        ::= ':'
	SemiColon    ::= ';'
	BackSlash    ::= '\'
	LeftBrace    ::= '{'
	RightBrace   ::= '}'
	LeftBracket  ::= '['
	RightBracket ::= ']'
	QuestionMark ::= '?'
	Comma        ::= ','
	Dot          ::= '.'
	LessThan     ::= '<'
	GreaterThan  ::= '>'
	Plus         ::= '+'
	Minus        ::= '-'
	Slash        ::= '/'
	Star         ::= '*'
	LeftParen    ::= '('
	RightParen   ::= ')'
	Equal        ::= '='

$End

$Start
	Token
$End

$Rules
	Token ::= Identifier
		/.$BeginAction
					checkForKeyWord();
		  $EndAction
		./

	-- an empty String literal looks just like an escaped single-quote
	Token ::= EscapedSQ
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

	Token ::= SingleQuote SLNotSQ SingleQuote
		/.$BeginAction
					makeToken($_STRING_LITERAL);
		  $EndAction
		./

--	Token ::= Acute SLNotSQOpt Acute
--		/.$BeginAction
--					makeToken($_STRING_LITERAL);
--		  $EndAction
--		./

--	Token ::= BackQuote SLNotSQOpt Acute
--		/.$BeginAction
--					makeToken($_STRING_LITERAL);
--		  $EndAction
--		./

	Token ::= IntegerLiteral
		/.$BeginAction
					makeToken($_INTEGER_LITERAL);
		  $EndAction
		./

	Token ::= RealLiteral
		/.$BeginAction
					makeToken($_REAL_LITERAL);
		  $EndAction
		./

--	Token ::= NumericOperation
--		/.$BeginAction
--					makeToken($_NUMERIC_OPERATION);
--		  $EndAction
--		./

	Token ::= IntegerRangeStart
		/.$BeginAction
					makeToken($_INTEGER_RANGE_START);
		  $EndAction
		./

	Token ::= SLC
		/.$BeginAction
					skipToken();
		  $EndAction
		./

    Token ::= '/' '*' Inside Stars '/'
        /.$BeginAction
                    skipToken();
          $EndAction
        ./

	Token ::= WS -- White Space is scanned but not added to output vector
		/.$BeginAction
					skipToken();
		  $EndAction
		./

	Token ::= '+'
		/.$BeginAction
					makeToken($_PLUS);
		  $EndAction
		./

	Token ::= '-'
		/.$BeginAction
					makeToken($_MINUS);
		  $EndAction
		./

	Token ::= '*'
		/.$BeginAction
					makeToken($_MULTIPLY);
		  $EndAction
		./

	Token ::= '/'
		/.$BeginAction
					makeToken($_DIVIDE);
		  $EndAction
		./

	Token ::= '('
		/.$BeginAction
					makeToken($_LPAREN);
		  $EndAction
		./

	Token ::= ')'
		/.$BeginAction
					makeToken($_RPAREN);
		  $EndAction
		./

	Token ::= '>'
		/.$BeginAction
					makeToken($_GREATER);
		  $EndAction
		./
		
	Token ::= '<'
		/.$BeginAction
					makeToken($_LESS);
		  $EndAction
		./

	Token ::= '='
		/.$BeginAction
					makeToken($_EQUAL);
		  $EndAction
		./

	Token ::= '>' '='
		/.$BeginAction
					makeToken($_GREATER_EQUAL);
		  $EndAction
		./

	Token ::= '<' '='
		/.$BeginAction
					makeToken($_LESS_EQUAL);
		  $EndAction
		./

	Token ::= '<' '>'
		/.$BeginAction
					makeToken($_NOT_EQUAL);
		  $EndAction
		./

	Token ::= '['
		/.$BeginAction
					makeToken($_LBRACKET);
		  $EndAction
		./

	Token ::= ']'
		/.$BeginAction
					makeToken($_RBRACKET);
		  $EndAction
		./

	Token ::= '{'
		/.$BeginAction
					makeToken($_LBRACE);
		  $EndAction
		./

	Token ::= '}'
		/.$BeginAction
					makeToken($_RBRACE);
		  $EndAction
		./

	Token ::= '-' '>'
		/.$BeginAction
					makeToken($_ARROW);
		  $EndAction
		./

	Token ::= '|'
		/.$BeginAction
					makeToken($_BAR);
		  $EndAction
		./

	Token ::= ','
		/.$BeginAction
					makeToken($_COMMA);
		  $EndAction
		./

	Token ::= ':'
		/.$BeginAction
					makeToken($_COLON);
		  $EndAction
		./

	Token ::= ':' ':'
		/.$BeginAction
					makeToken($_COLONCOLON);
		  $EndAction
		./

	Token ::= ';'
		/.$BeginAction
					makeToken($_SEMICOLON);
		  $EndAction
		./

	Token ::= '.'
		/.$BeginAction
					makeToken($_DOT);
		  $EndAction
		./

	Token ::= '.' '.'
		/.$BeginAction
					makeToken($_DOTDOT);
		  $EndAction
		./

	Token ::= '@' p r e
		/.$BeginAction
					makeToken($_ATPRE);
		  $EndAction
		./


	Token ::= '^'
		/.$BeginAction
					makeToken($_CARET);
		  $EndAction
		./

	Token ::= '^' '^'
		/.$BeginAction
					makeToken($_CARETCARET);
		  $EndAction
		./
		
	Token ::= '?'
		/.$BeginAction
					makeToken($_QUESTIONMARK);
		  $EndAction
		./
	Token ::= '#'
		/.$BeginAction
					makeToken($_SHARP);
		  $EndAction
		./
	Token ::= '$'
		/.$BeginAction
					makeToken($_DOLLAR);
		  $EndAction
		./
	Token ::= '%'
		/.$BeginAction
					makeToken($_PERCENT);
		  $EndAction
		./


    IntegerLiteral -> Integer
    --                | '0' LetterXx HexDigits

    RealLiteral -> Decimal
                 | Decimal Exponent
                 | Integer Exponent

    Inside ::= Inside Stars NotSlashOrStar
             | Inside '/'
             | Inside NotSlashOrStar
             | $empty

    Stars -> '*'
           | Stars '*'

    SLC -> '-' '-'
         | SLC NotEol

    Integer -> Digit
             | Integer Digit

    HexDigits -> HexDigit
               | HexDigits HexDigit

    Decimal -> Integer '.' Integer

    Exponent -> LetterEe Integer
              | LetterEe '-' Integer
              | LetterEe '+' Integer

    WSChar -> Space
            | LF
            | CR
            | HT
            | FF

    Letter -> LowerCaseLetter
            | UpperCaseLetter
            | _
            | AfterASCIINotAcute

    LowerCaseLetter -> a | b | c | d | e | f | g | h | i | j | k | l | m |
                       n | o | p | q | r | s | t | u | v | w | x | y | z

    UpperCaseLetter -> A | B | C | D | E | F | G | H | I | J | K | L | M |
                       N | O | P | Q | R | S | T | U | V | W | X | Y | Z

    Digit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9

    OctalDigit -> 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7

    a..fA..F -> a | b | c | d | e | f | A | B | C | D | E | F

    HexDigit -> Digit
              | a..fA..F

    OctalDigits3 -> OctalDigit
                  | OctalDigit OctalDigit
                  | OctalDigit OctalDigit OctalDigit

    LetterEe -> 'E'
              | 'e'

    LetterXx -> 'X'
              | 'x'

    WS -> WSChar
        | WS WSChar

    Identifier -> Letter
                | Identifier Letter
                | Identifier Digit
                | Identifier DollarSign
                | QuotedName

    SpecialNotStar -> '+' | '-' | '/' | '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                      '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                      '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    SpecialNotSlash -> '+' | '-' | -- exclude the star as well
                       '(' | ')' | '"' | '!' | '@' | '`' | '~' |
                       '%' | '&' | '^' | ':' | ';' | "'" | '\' | '|' | '{' | '}' |
                       '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    SpecialNotDQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | "'" | '|' | '{' | '}' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    SpecialNotSQ -> '+' | '-' | '/' | '(' | ')' | '*' | '!' | '@' | '`' | '~' |
                    '%' | '&' | '^' | ':' | ';' | '"' | '|' | '{' | '}' | '\' |
                    '[' | ']' | '?' | ',' | '.' | '<' | '>' | '=' | '#' | DollarSign

    NotSlashOrStar -> Letter
                    | Digit
                    | SpecialNotSlash
                    | WSChar

    NotEol -> Letter
            | Digit
            | Space
            | '*'
            | SpecialNotStar
            | HT
            | FF
            | CtlCharNotWS

    NotDQ -> Letter
           | Digit
           | SpecialNotDQ
           | Space
           | EscapedDQ
           --| '\' u HexDigit HexDigit HexDigit HexDigit
           --| '\' OctalDigit

    NotSQ -> Letter
           | Digit
           | SpecialNotSQ
           | Space
           | EscapedSQ
           --| '\' u HexDigit HexDigit HexDigit HexDigit
           --| '\' OctalDigit

	EscapedSQ -> SingleQuote SingleQuote

	-- maintain this for compatibility with the "...\"..." escapes in an
	-- escape mechanism (double-quotes) that isn't compliant, anyway
	EscapedDQ -> '\' DoubleQuote

	SLNotDQ -> NotDQ
	         | SLNotDQ NotDQ

	SLNotSQ -> NotSQ
	         | SLNotSQ NotSQ

	SLNotSQOpt -> $empty
	            | SLNotSQ

	QuotedName -> '"' SLNotDQ '"'

--	NumericOperation -> Integer '.' Identifier
--	NumericOperation -> Integer '.' '+'
--	NumericOperation -> Integer '.' '-'
--	NumericOperation -> Integer '.' '*'
--	NumericOperation -> Integer '.' '/'
--	NumericOperation -> Integer '.' '<'
--	NumericOperation -> Integer '.' '<' '='
--	NumericOperation -> Integer '.' '>' '='
--	NumericOperation -> Integer '.' '>'

	IntegerRangeStart -> Integer '.' '.'

$End