package edu.pku.sei.queryscript.parser;

import lpg.runtime.IPrsStream;
import lpg.runtime.LexParser;
import lpg.runtime.LexStream;
import lpg.runtime.LpgLexStream;
import lpg.runtime.Monitor;
import lpg.runtime.ParseTable;
import lpg.runtime.RuleAction;

public class QueryScriptLexer extends LpgLexStream implements
		QueryScriptParsersym, QueryScriptLexersym, RuleAction {
	private static ParseTable prs = new QueryScriptLexerprs();

	public ParseTable getParseTable() {
		return prs;
	}

	private LexParser lexParser = new LexParser(this, prs, this);

	public LexParser getParser() {
		return lexParser;
	}

	public int getToken(int i) {
		return lexParser.getToken(i);
	}

	public int getRhsFirstTokenIndex(int i) {
		return lexParser.getFirstToken(i);
	}

	public int getRhsLastTokenIndex(int i) {
		return lexParser.getLastToken(i);
	}

	public int getLeftSpan() {
		return lexParser.getToken(1);
	}

	public int getRightSpan() {
		return lexParser.getLastToken();
	}

	public QueryScriptLexer(String filename, int tab)
			throws java.io.IOException {
		super(filename, tab);
	}

	public QueryScriptLexer(char[] input_chars, String filename, int tab) {
		super(input_chars, filename, tab);
	}

	public QueryScriptLexer(char[] input_chars, String filename) {
		this(input_chars, filename, 1);
	}

	public QueryScriptLexer() {
	}

	public String[] orderedExportedSymbols() {
		return QueryScriptParsersym.orderedTerminalSymbols;
	}

	public LexStream getLexStream() {
		return (LexStream) this;
	}

	private void initializeLexer(IPrsStream prsStream, int start_offset,
			int end_offset) {
		if (getInputChars() == null)
			throw new NullPointerException("LexStream was not initialized");
		setPrsStream(prsStream);
		prsStream.makeToken(start_offset, end_offset, 0); // Token list must
															// start with a bad
															// token
	}

	private void addEOF(IPrsStream prsStream, int end_offset) {
		prsStream.makeToken(end_offset, end_offset,
				QueryScriptParsersym.TK_EOF_TOKEN); // and end with the end of
													// file token
		prsStream.setStreamLength(prsStream.getSize());
	}

	public void lexer(IPrsStream prsStream) {
		lexer(null, prsStream);
	}

	public void lexer(Monitor monitor, IPrsStream prsStream) {
		initializeLexer(prsStream, 0, -1);
		lexParser.parseCharacters(monitor); // Lex the input characters
		addEOF(prsStream, getStreamIndex());
	}

	public void lexer(IPrsStream prsStream, int start_offset, int end_offset) {
		lexer(null, prsStream, start_offset, end_offset);
	}

	public void lexer(Monitor monitor, IPrsStream prsStream, int start_offset,
			int end_offset) {
		if (start_offset <= 1)
			initializeLexer(prsStream, 0, -1);
		else
			initializeLexer(prsStream, start_offset - 1, start_offset - 1);

		lexParser.parseCharacters(monitor, start_offset, end_offset);

		addEOF(prsStream, (end_offset >= getStreamIndex() ? getStreamIndex()
				: end_offset + 1));
	}

	/**
	 * If a parse stream was not passed to this Lexical analyser then we simply
	 * report a lexical error. Otherwise, we produce a bad token.
	 */
	public void reportLexicalError(int startLoc, int endLoc) {
		IPrsStream prs_stream = getPrsStream();
		if (prs_stream == null)
			super.reportLexicalError(startLoc, endLoc);
		else {
			//
			// Remove any token that may have been processed that fall in the
			// range of the lexical error... then add one error token that spans
			// the error range.
			//
			for (int i = prs_stream.getSize() - 1; i > 0; i--) {
				if (prs_stream.getStartOffset(i) >= startLoc)
					prs_stream.removeLastToken();
				else
					break;
			}
			prs_stream.makeToken(startLoc, endLoc, 0); // add an error token to
														// the prsStream
		}
	}

	//
	// The Lexer contains an array of characters as the input stream to be
	// parsed.
	// There are methods to retrieve and classify characters.
	// The lexparser "token" is implemented simply as the index of the next
	// character in the array.
	// The Lexer extends the abstract class LpgLexStream with an implementation
	// of the abstract
	// method getKind. The template defines the Lexer class and the lexer()
	// method.
	// A driver creates the action class, "Lexer", passing an Option object to
	// the constructor.
	//
	QueryScriptKWLexer kwLexer;
	boolean printTokens;
	private final static int ECLIPSE_TAB_VALUE = 4;

	public int[] getKeywordKinds() {
		return kwLexer.getKeywordKinds();
	}

	public QueryScriptLexer(String filename) throws java.io.IOException {
		this(filename, ECLIPSE_TAB_VALUE);
		this.kwLexer = new QueryScriptKWLexer(getInputChars(),
				QueryScriptParsersym.TK_IDENTIFIER);
	}

	/*
	 * public QueryScriptLexer(Option option) throws java.io.IOException {
	 * this(option.getFileName(), ECLIPSE_TAB_VALUE); this.printTokens =
	 * option.printTokens(); this.kwLexer = new
	 * QueryScriptKWLexer(getInputChars(), QueryScriptParsersym.TK_IDENTIFIER);
	 * }
	 */
	public void initialize(char[] content, String filename) {
		super.initialize(content, filename);
		if (this.kwLexer == null)
			this.kwLexer = new QueryScriptKWLexer(getInputChars(),
					QueryScriptParsersym.TK_IDENTIFIER);
		else
			this.kwLexer.setInputChars(getInputChars());
	}

	final void makeToken(int kind) {
		int startOffset = getLeftSpan(), endOffset = getRightSpan();
		makeToken(startOffset, endOffset, kind);
		if (printTokens)
			printValue(startOffset, endOffset);
	}

	final void makeComment(int kind) {
		int startOffset = getLeftSpan(), endOffset = getRightSpan();
		super.getPrsStream().makeAdjunct(startOffset, endOffset, kind);
	}

	final void skipToken() {
		if (printTokens)
			printValue(getLeftSpan(), getRightSpan());
	}

	final void checkForKeyWord() {
		int startOffset = getLeftSpan(), endOffset = getRightSpan(), kwKind = kwLexer
				.lexer(startOffset, endOffset);
		makeToken(startOffset, endOffset, kwKind);
		if (printTokens)
			printValue(startOffset, endOffset);
	}

	//
	// This flavor of checkForKeyWord is necessary when the default kind
	// (which is returned when the keyword filter doesn't match) is something
	// other than _IDENTIFIER.
	//
	final void checkForKeyWord(int defaultKind) {
		int startOffset = getLeftSpan(), endOffset = getRightSpan(), kwKind = kwLexer
				.lexer(startOffset, endOffset);
		if (kwKind == QueryScriptParsersym.TK_IDENTIFIER)
			kwKind = defaultKind;
		makeToken(startOffset, endOffset, kwKind);
		if (printTokens)
			printValue(startOffset, endOffset);
	}

	final void printValue(int startOffset, int endOffset) {
		String s = new String(getInputChars(), startOffset, endOffset
				- startOffset + 1);
		System.out.print(s);
	}

	//
	//
	//
	public final static int tokenKind[] = {
			QueryScriptLexersym.Char_CtlCharNotWS, // 000 0x00
			QueryScriptLexersym.Char_CtlCharNotWS, // 001 0x01
			QueryScriptLexersym.Char_CtlCharNotWS, // 002 0x02
			QueryScriptLexersym.Char_CtlCharNotWS, // 003 0x03
			QueryScriptLexersym.Char_CtlCharNotWS, // 004 0x04
			QueryScriptLexersym.Char_CtlCharNotWS, // 005 0x05
			QueryScriptLexersym.Char_CtlCharNotWS, // 006 0x06
			QueryScriptLexersym.Char_CtlCharNotWS, // 007 0x07
			QueryScriptLexersym.Char_CtlCharNotWS, // 008 0x08
			QueryScriptLexersym.Char_HT, // 009 0x09
			QueryScriptLexersym.Char_LF, // 010 0x0A
			QueryScriptLexersym.Char_CtlCharNotWS, // 011 0x0B
			QueryScriptLexersym.Char_FF, // 012 0x0C
			QueryScriptLexersym.Char_CR, // 013 0x0D
			QueryScriptLexersym.Char_CtlCharNotWS, // 014 0x0E
			QueryScriptLexersym.Char_CtlCharNotWS, // 015 0x0F
			QueryScriptLexersym.Char_CtlCharNotWS, // 016 0x10
			QueryScriptLexersym.Char_CtlCharNotWS, // 017 0x11
			QueryScriptLexersym.Char_CtlCharNotWS, // 018 0x12
			QueryScriptLexersym.Char_CtlCharNotWS, // 019 0x13
			QueryScriptLexersym.Char_CtlCharNotWS, // 020 0x14
			QueryScriptLexersym.Char_CtlCharNotWS, // 021 0x15
			QueryScriptLexersym.Char_CtlCharNotWS, // 022 0x16
			QueryScriptLexersym.Char_CtlCharNotWS, // 023 0x17
			QueryScriptLexersym.Char_CtlCharNotWS, // 024 0x18
			QueryScriptLexersym.Char_CtlCharNotWS, // 025 0x19
			QueryScriptLexersym.Char_CtlCharNotWS, // 026 0x1A
			QueryScriptLexersym.Char_CtlCharNotWS, // 027 0x1B
			QueryScriptLexersym.Char_CtlCharNotWS, // 028 0x1C
			QueryScriptLexersym.Char_CtlCharNotWS, // 029 0x1D
			QueryScriptLexersym.Char_CtlCharNotWS, // 030 0x1E
			QueryScriptLexersym.Char_CtlCharNotWS, // 031 0x1F
			QueryScriptLexersym.Char_Space, // 032 0x20
			QueryScriptLexersym.Char_Exclamation, // 033 0x21
			QueryScriptLexersym.Char_DoubleQuote, // 034 0x22
			QueryScriptLexersym.Char_Sharp, // 035 0x23
			QueryScriptLexersym.Char_DollarSign, // 036 0x24
			QueryScriptLexersym.Char_Percent, // 037 0x25
			QueryScriptLexersym.Char_Ampersand, // 038 0x26
			QueryScriptLexersym.Char_SingleQuote, // 039 0x27
			QueryScriptLexersym.Char_LeftParen, // 040 0x28
			QueryScriptLexersym.Char_RightParen, // 041 0x29
			QueryScriptLexersym.Char_Star, // 042 0x2A
			QueryScriptLexersym.Char_Plus, // 043 0x2B
			QueryScriptLexersym.Char_Comma, // 044 0x2C
			QueryScriptLexersym.Char_Minus, // 045 0x2D
			QueryScriptLexersym.Char_Dot, // 046 0x2E
			QueryScriptLexersym.Char_Slash, // 047 0x2F
			QueryScriptLexersym.Char_0, // 048 0x30
			QueryScriptLexersym.Char_1, // 049 0x31
			QueryScriptLexersym.Char_2, // 050 0x32
			QueryScriptLexersym.Char_3, // 051 0x33
			QueryScriptLexersym.Char_4, // 052 0x34
			QueryScriptLexersym.Char_5, // 053 0x35
			QueryScriptLexersym.Char_6, // 054 0x36
			QueryScriptLexersym.Char_7, // 055 0x37
			QueryScriptLexersym.Char_8, // 056 0x38
			QueryScriptLexersym.Char_9, // 057 0x39
			QueryScriptLexersym.Char_Colon, // 058 0x3A
			QueryScriptLexersym.Char_SemiColon, // 059 0x3B
			QueryScriptLexersym.Char_LessThan, // 060 0x3C
			QueryScriptLexersym.Char_Equal, // 061 0x3D
			QueryScriptLexersym.Char_GreaterThan, // 062 0x3E
			QueryScriptLexersym.Char_QuestionMark, // 063 0x3F
			QueryScriptLexersym.Char_AtSign, // 064 0x40
			QueryScriptLexersym.Char_A, // 065 0x41
			QueryScriptLexersym.Char_B, // 066 0x42
			QueryScriptLexersym.Char_C, // 067 0x43
			QueryScriptLexersym.Char_D, // 068 0x44
			QueryScriptLexersym.Char_E, // 069 0x45
			QueryScriptLexersym.Char_F, // 070 0x46
			QueryScriptLexersym.Char_G, // 071 0x47
			QueryScriptLexersym.Char_H, // 072 0x48
			QueryScriptLexersym.Char_I, // 073 0x49
			QueryScriptLexersym.Char_J, // 074 0x4A
			QueryScriptLexersym.Char_K, // 075 0x4B
			QueryScriptLexersym.Char_L, // 076 0x4C
			QueryScriptLexersym.Char_M, // 077 0x4D
			QueryScriptLexersym.Char_N, // 078 0x4E
			QueryScriptLexersym.Char_O, // 079 0x4F
			QueryScriptLexersym.Char_P, // 080 0x50
			QueryScriptLexersym.Char_Q, // 081 0x51
			QueryScriptLexersym.Char_R, // 082 0x52
			QueryScriptLexersym.Char_S, // 083 0x53
			QueryScriptLexersym.Char_T, // 084 0x54
			QueryScriptLexersym.Char_U, // 085 0x55
			QueryScriptLexersym.Char_V, // 086 0x56
			QueryScriptLexersym.Char_W, // 087 0x57
			QueryScriptLexersym.Char_X, // 088 0x58
			QueryScriptLexersym.Char_Y, // 089 0x59
			QueryScriptLexersym.Char_Z, // 090 0x5A
			QueryScriptLexersym.Char_LeftBracket, // 091 0x5B
			QueryScriptLexersym.Char_BackSlash, // 092 0x5C
			QueryScriptLexersym.Char_RightBracket, // 093 0x5D
			QueryScriptLexersym.Char_Caret, // 094 0x5E
			QueryScriptLexersym.Char__, // 095 0x5F
			QueryScriptLexersym.Char_BackQuote, // 096 0x60
			QueryScriptLexersym.Char_a, // 097 0x61
			QueryScriptLexersym.Char_b, // 098 0x62
			QueryScriptLexersym.Char_c, // 099 0x63
			QueryScriptLexersym.Char_d, // 100 0x64
			QueryScriptLexersym.Char_e, // 101 0x65
			QueryScriptLexersym.Char_f, // 102 0x66
			QueryScriptLexersym.Char_g, // 103 0x67
			QueryScriptLexersym.Char_h, // 104 0x68
			QueryScriptLexersym.Char_i, // 105 0x69
			QueryScriptLexersym.Char_j, // 106 0x6A
			QueryScriptLexersym.Char_k, // 107 0x6B
			QueryScriptLexersym.Char_l, // 108 0x6C
			QueryScriptLexersym.Char_m, // 109 0x6D
			QueryScriptLexersym.Char_n, // 110 0x6E
			QueryScriptLexersym.Char_o, // 111 0x6F
			QueryScriptLexersym.Char_p, // 112 0x70
			QueryScriptLexersym.Char_q, // 113 0x71
			QueryScriptLexersym.Char_r, // 114 0x72
			QueryScriptLexersym.Char_s, // 115 0x73
			QueryScriptLexersym.Char_t, // 116 0x74
			QueryScriptLexersym.Char_u, // 117 0x75
			QueryScriptLexersym.Char_v, // 118 0x76
			QueryScriptLexersym.Char_w, // 119 0x77
			QueryScriptLexersym.Char_x, // 120 0x78
			QueryScriptLexersym.Char_y, // 121 0x79
			QueryScriptLexersym.Char_z, // 122 0x7A
			QueryScriptLexersym.Char_LeftBrace, // 123 0x7B
			QueryScriptLexersym.Char_VerticalBar, // 124 0x7C
			QueryScriptLexersym.Char_RightBrace, // 125 0x7D
			QueryScriptLexersym.Char_Tilde, // 126 0x7E

			Char_Acute, // for the acute accent 0xb4
			Char_AfterASCIINotAcute, // for all chars in range 0x80..0xfffe
										// excluding the acute accent
			Char_EOF // for '\uffff' or 65535
	};

	@Override
	public final int getKind(int i) // Classify character at ith location
	{
		char c = (i >= getStreamLength() ? '\uffff' : getCharValue(i));
		return (c < 128) ? // ASCII Character
		tokenKind[c]
				: (c == '\uffff') ? Char_EOF : (c == '\u00b4') ? Char_Acute
						: Char_AfterASCIINotAcute;
	}

	public void ruleAction(int ruleNumber) {
		switch (ruleNumber) {

		//
		// Rule 1: Token ::= Identifier
		//
		case 1: {
			checkForKeyWord();
			break;
		}

			//
			// Rule 2: Token ::= EscapedSQ
			//
		case 2: {
			makeToken(QueryScriptParsersym.TK_STRING_LITERAL);
			break;
		}

			//
			// Rule 3: Token ::= SingleQuote SLNotSQ SingleQuote
			//
		case 3: {
			makeToken(QueryScriptParsersym.TK_STRING_LITERAL);
			break;
		}

			//
			// Rule 4: Token ::= IntegerLiteral
			//
		case 4: {
			makeToken(QueryScriptParsersym.TK_INTEGER_LITERAL);
			break;
		}

			//
			// Rule 5: Token ::= RealLiteral
			//
		case 5: {
			makeToken(QueryScriptParsersym.TK_REAL_LITERAL);
			break;
		}

			//
			// Rule 6: Token ::= IntegerRangeStart
			//
		case 6: {
			makeToken(QueryScriptParsersym.TK_INTEGER_RANGE_START);
			break;
		}

			//
			// Rule 7: Token ::= SLC
			//
		case 7: {
			skipToken();
			break;
		}

			//
			// Rule 8: Token ::= / * Inside Stars /
			//
		case 8: {
			skipToken();
			break;
		}

			//
			// Rule 9: Token ::= WS
			//
		case 9: {
			skipToken();
			break;
		}

			//
			// Rule 10: Token ::= +
			//
		case 10: {
			makeToken(QueryScriptParsersym.TK_PLUS);
			break;
		}

			//
			// Rule 11: Token ::= -
			//
		case 11: {
			makeToken(QueryScriptParsersym.TK_MINUS);
			break;
		}

			//
			// Rule 12: Token ::= *
			//
		case 12: {
			makeToken(QueryScriptParsersym.TK_MULTIPLY);
			break;
		}

			//
			// Rule 13: Token ::= /
			//
		case 13: {
			makeToken(QueryScriptParsersym.TK_DIVIDE);
			break;
		}

			//
			// Rule 14: Token ::= (
			//
		case 14: {
			makeToken(QueryScriptParsersym.TK_LPAREN);
			break;
		}

			//
			// Rule 15: Token ::= )
			//
		case 15: {
			makeToken(QueryScriptParsersym.TK_RPAREN);
			break;
		}

			//
			// Rule 16: Token ::= >
			//
		case 16: {
			makeToken(QueryScriptParsersym.TK_GREATER);
			break;
		}

			//
			// Rule 17: Token ::= <
			//
		case 17: {
			makeToken(QueryScriptParsersym.TK_LESS);
			break;
		}

			//
			// Rule 18: Token ::= =
			//
		case 18: {
			makeToken(QueryScriptParsersym.TK_EQUAL);
			break;
		}

			//
			// Rule 19: Token ::= > =
			//
		case 19: {
			makeToken(QueryScriptParsersym.TK_GREATER_EQUAL);
			break;
		}

			//
			// Rule 20: Token ::= < =
			//
		case 20: {
			makeToken(QueryScriptParsersym.TK_LESS_EQUAL);
			break;
		}

			//
			// Rule 21: Token ::= < >
			//
		case 21: {
			makeToken(QueryScriptParsersym.TK_NOT_EQUAL);
			break;
		}

			//
			// Rule 22: Token ::= [
			//
		case 22: {
			makeToken(QueryScriptParsersym.TK_LBRACKET);
			break;
		}

			//
			// Rule 23: Token ::= ]
			//
		case 23: {
			makeToken(QueryScriptParsersym.TK_RBRACKET);
			break;
		}

			//
			// Rule 24: Token ::= {
			//
		case 24: {
			makeToken(QueryScriptParsersym.TK_LBRACE);
			break;
		}

			//
			// Rule 25: Token ::= }
			//
		case 25: {
			makeToken(QueryScriptParsersym.TK_RBRACE);
			break;
		}

			//
			// Rule 26: Token ::= - >
			//
		case 26: {
			makeToken(QueryScriptParsersym.TK_ARROW);
			break;
		}

			//
			// Rule 27: Token ::= |
			//
		case 27: {
			makeToken(QueryScriptParsersym.TK_BAR);
			break;
		}

			//
			// Rule 28: Token ::= ,
			//
		case 28: {
			makeToken(QueryScriptParsersym.TK_COMMA);
			break;
		}

			//
			// Rule 29: Token ::= :
			//
		case 29: {
			makeToken(QueryScriptParsersym.TK_COLON);
			break;
		}

			//
			// Rule 30: Token ::= : :
			//
		case 30: {
			makeToken(QueryScriptParsersym.TK_COLONCOLON);
			break;
		}

			//
			// Rule 31: Token ::= ;
			//
		case 31: {
			makeToken(QueryScriptParsersym.TK_SEMICOLON);
			break;
		}

			//
			// Rule 32: Token ::= .
			//
		case 32: {
			makeToken(QueryScriptParsersym.TK_DOT);
			break;
		}

			//
			// Rule 33: Token ::= . .
			//
		case 33: {
			makeToken(QueryScriptParsersym.TK_DOTDOT);
			break;
		}

			//
			// Rule 34: Token ::= @ p r e
			//
		case 34: {
			makeToken(QueryScriptParsersym.TK_ATPRE);
			break;
		}

			//
			// Rule 35: Token ::= ^
			//
		case 35: {
			makeToken(QueryScriptParsersym.TK_CARET);
			break;
		}

			//
			// Rule 36: Token ::= ^ ^
			//
		case 36: {
			makeToken(QueryScriptParsersym.TK_CARETCARET);
			break;
		}

			//
			// Rule 37: Token ::= ?
			//
		case 37: {
			makeToken(QueryScriptParsersym.TK_QUESTIONMARK);
			break;
		}

			//
			// Rule 38: Token ::= #
			//
		case 38: {
			makeToken(QueryScriptParsersym.TK_SHARP);
			break;
		}

			//
			// Rule 39: Token ::= $
			//
		case 39: {
			makeToken(QueryScriptParsersym.TK_DOLLAR);
			break;
		}

			//
			// Rule 40: Token ::= %
			//
		case 40: {
			makeToken(QueryScriptParsersym.TK_PERCENT);
			break;
		}

		default:
			break;
		}
		return;
	}
}
