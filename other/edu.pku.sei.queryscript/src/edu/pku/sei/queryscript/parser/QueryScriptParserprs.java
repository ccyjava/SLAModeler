package edu.pku.sei.queryscript.parser;

public class QueryScriptParserprs implements lpg.runtime.ParseTable,
		QueryScriptParsersym {
	public final static int ERROR_SYMBOL = 103;

	public final int getErrorSymbol() {
		return ERROR_SYMBOL;
	}

	public final static int SCOPE_UBOUND = 12;

	public final int getScopeUbound() {
		return SCOPE_UBOUND;
	}

	public final static int SCOPE_SIZE = 13;

	public final int getScopeSize() {
		return SCOPE_SIZE;
	}

	public final static int MAX_NAME_LENGTH = 19;

	public final int getMaxNameLength() {
		return MAX_NAME_LENGTH;
	}

	public final static int NUM_STATES = 84;

	public final int getNumStates() {
		return NUM_STATES;
	}

	public final static int NT_OFFSET = 103;

	public final int getNtOffset() {
		return NT_OFFSET;
	}

	public final static int LA_STATE_OFFSET = 583;

	public final int getLaStateOffset() {
		return LA_STATE_OFFSET;
	}

	public final static int MAX_LA = 1;

	public final int getMaxLa() {
		return MAX_LA;
	}

	public final static int NUM_RULES = 61;

	public final int getNumRules() {
		return NUM_RULES;
	}

	public final static int NUM_NONTERMINALS = 23;

	public final int getNumNonterminals() {
		return NUM_NONTERMINALS;
	}

	public final static int NUM_SYMBOLS = 126;

	public final int getNumSymbols() {
		return NUM_SYMBOLS;
	}

	public final static int SEGMENT_SIZE = 8192;

	public final int getSegmentSize() {
		return SEGMENT_SIZE;
	}

	public final static int START_STATE = 62;

	public final int getStartState() {
		return START_STATE;
	}

	public final static int IDENTIFIER_SYMBOL = 2;

	public final int getIdentifier_SYMBOL() {
		return IDENTIFIER_SYMBOL;
	}

	public final static int EOFT_SYMBOL = 44;

	public final int getEoftSymbol() {
		return EOFT_SYMBOL;
	}

	public final static int EOLT_SYMBOL = 44;

	public final int getEoltSymbol() {
		return EOLT_SYMBOL;
	}

	public final static int ACCEPT_ACTION = 521;

	public final int getAcceptAction() {
		return ACCEPT_ACTION;
	}

	public final static int ERROR_ACTION = 522;

	public final int getErrorAction() {
		return ERROR_ACTION;
	}

	public final static boolean BACKTRACK = false;

	public final boolean getBacktrack() {
		return BACKTRACK;
	}

	public final int getStartSymbol() {
		return lhs(0);
	}

	public final boolean isValidForParser() {
		return QueryScriptParsersym.isValidForParser;
	}

	public interface IsNullable {
		public final static byte isNullable[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 };
	};

	public final static byte isNullable[] = IsNullable.isNullable;

	public final boolean isNullable(int index) {
		return isNullable[index] != 0;
	}

	public interface ProsthesesIndex {
		public final static byte prosthesesIndex[] = { 0, 8, 14, 15, 16, 17,
				18, 19, 20, 13, 12, 7, 6, 5, 11, 3, 21, 10, 22, 23, 2, 4, 9, 1 };
	};

	public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;

	public final int prosthesesIndex(int index) {
		return prosthesesIndex[index];
	}

	public interface IsKeyword {
		public final static byte isKeyword[] = { 0, 0, 0, 0, 0, 0, 1, 1, 1, 1,
				0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 0, 0 };
	};

	public final static byte isKeyword[] = IsKeyword.isKeyword;

	public final boolean isKeyword(int index) {
		return isKeyword[index] != 0;
	}

	public interface BaseCheck {
		public final static byte baseCheck[] = { 0, 1, 1, 2, 1, 3, 2, 5, 7, 10,
				1, 3, 0, 1, 3, 4, 4, 3, 3, 2, 1, 3, 3, 3, 1, 3, 3, 1, 1, 1, 1,
				1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 4, 3, 6, 6, 3, 1, 0, 8, 8, 8, 8,
				3, 1, 1, 1, 1, 1, 1, 3, 1, 1, -1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, -2, 0, -3, 0, -17, 0, 0, 0, -32, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, -6, 0, -62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, -7, 0, -83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -9, 0,
				-13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -28, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, -51, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, -72, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -84, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, -16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -18, 0, -78, 0, 0,
				-25, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -26, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, -57, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -61, 0,
				-10, -11, 0, -58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				-12, 0, -73, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -74, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, -75, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, -76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -4, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, -27, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -52,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -5, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, -29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -30, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, -22, 0, 0, 0, 0, 0, 0, 0, 0, 0, -23, 0, 0, 0, 0, 0, 0,
				0, 0, 0, -24, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 0, 0, 0, 0, 0, 0,
				0, 0, -21, 0, 0, 0, 0, 0, 0, 0, 0, -70, 0, -31, 0, -14, -15,
				-53, 0, -54, 0, -19, -55, 0, -56, 0, -33, 0, 0, 0, 0, 0, -34,
				0, -35, 0, 0, -36, 0, -59, 0, -37, -38, -39, -40, -41, -42,
				-43, -44, -45, -46, -47, -48, 0, -49, -50, -60, -63, -64, -65,
				-66, -67, -68, -69, -71, -77, -79, -80, -81, -82, 0 };
	};

	public final static byte baseCheck[] = BaseCheck.baseCheck;

	public final int baseCheck(int index) {
		return baseCheck[index];
	}

	public final static byte rhs[] = baseCheck;

	public final int rhs(int index) {
		return rhs[index];
	};

	public interface BaseAction {
		public final static char baseAction[] = { 20, 20, 20, 15, 15, 13, 13,
				13, 13, 21, 22, 22, 22, 12, 12, 12, 12, 11, 11, 11, 11, 10, 10,
				10, 10, 9, 9, 9, 2, 2, 2, 2, 2, 3, 6, 6, 6, 6, 6, 5, 5, 5, 8,
				8, 8, 16, 16, 16, 7, 7, 7, 7, 14, 4, 17, 18, 18, 18, 17, 19,
				19, 1, 21, 98, 114, 28, 29, 31, 33, 39, 40, 130, 20, 290, 273,
				4, 11, 132, 239, 465, 15, 493, 76, 2, 90, 98, 114, 28, 29, 31,
				33, 39, 40, 130, 20, 290, 273, 4, 19, 160, 90, 98, 114, 28, 29,
				31, 33, 39, 40, 130, 20, 290, 273, 4, 152, 174, 90, 98, 114,
				28, 29, 31, 33, 39, 40, 130, 20, 290, 273, 4, 139, 188, 75, 98,
				114, 28, 29, 31, 33, 39, 40, 130, 20, 290, 273, 3, 90, 98, 114,
				28, 29, 31, 33, 39, 40, 130, 20, 290, 273, 5, 1, 98, 114, 28,
				29, 31, 33, 39, 40, 130, 20, 290, 273, 3, 37, 98, 114, 28, 29,
				31, 33, 39, 40, 130, 20, 290, 273, 3, 61, 98, 114, 28, 29, 31,
				33, 39, 40, 130, 20, 290, 273, 3, 104, 98, 114, 28, 29, 31, 33,
				39, 40, 130, 20, 290, 471, 129, 98, 114, 28, 29, 31, 33, 39,
				40, 130, 20, 482, 239, 494, 239, 59, 476, 104, 98, 114, 28, 29,
				31, 33, 39, 40, 130, 20, 290, 500, 104, 98, 114, 28, 29, 31,
				33, 39, 40, 130, 20, 290, 501, 129, 98, 114, 28, 29, 31, 33,
				39, 40, 130, 20, 482, 16, 60, 153, 151, 512, 129, 98, 114, 28,
				29, 31, 33, 39, 40, 130, 20, 482, 52, 54, 514, 160, 513, 104,
				98, 114, 28, 29, 31, 33, 39, 40, 130, 20, 290, 516, 104, 98,
				114, 28, 29, 31, 33, 39, 40, 130, 20, 290, 517, 104, 98, 114,
				28, 29, 31, 33, 39, 40, 130, 20, 290, 518, 104, 98, 114, 28,
				29, 31, 33, 39, 40, 130, 20, 290, 519, 117, 98, 114, 28, 29,
				31, 33, 39, 40, 130, 20, 466, 117, 98, 114, 28, 29, 31, 33, 39,
				40, 130, 20, 502, 117, 98, 114, 28, 29, 31, 33, 39, 40, 130,
				20, 507, 141, 98, 114, 28, 29, 31, 33, 39, 40, 130, 19, 141,
				98, 114, 28, 29, 31, 33, 39, 40, 130, 18, 141, 98, 114, 28, 29,
				31, 33, 39, 40, 130, 17, 141, 98, 114, 28, 29, 31, 33, 39, 40,
				497, 141, 98, 114, 28, 29, 31, 33, 39, 40, 498, 141, 98, 114,
				28, 29, 31, 33, 39, 40, 499, 141, 98, 495, 28, 29, 31, 33, 39,
				40, 141, 98, 496, 28, 29, 31, 33, 39, 40, 16, 60, 240, 505,
				161, 144, 239, 505, 239, 505, 166, 239, 505, 239, 505, 167, 10,
				515, 54, 514, 508, 173, 509, 227, 504, 510, 246, 511, 239, 505,
				248, 250, 252, 254, 179, 182, 180, 189, 191, 190, 192, 200, 11,
				209, 71, 78, 203, 114, 243, 256, 257, 220, 221, 204, 4, 222,
				226, 234, 235, 522, 522 };
	};

	public final static char baseAction[] = BaseAction.baseAction;

	public final int baseAction(int index) {
		return baseAction[index];
	}

	public final static char lhs[] = baseAction;

	public final int lhs(int index) {
		return lhs[index];
	};

	public interface TermCheck {
		public final static byte termCheck[] = { 0, 0, 1, 2, 0, 4, 5, 6, 7, 8,
				9, 0, 11, 12, 13, 0, 0, 2, 2, 0, 1, 0, 1, 2, 23, 4, 5, 6, 7, 8,
				9, 27, 11, 12, 13, 0, 35, 0, 1, 2, 0, 4, 5, 6, 7, 8, 9, 0, 11,
				12, 13, 36, 37, 38, 39, 44, 40, 41, 42, 0, 23, 0, 1, 2, 43, 4,
				5, 6, 7, 8, 9, 0, 11, 12, 13, 0, 1, 2, 0, 4, 5, 6, 7, 8, 9, 0,
				11, 12, 13, 28, 0, 1, 2, 22, 4, 5, 6, 7, 8, 9, 22, 11, 12, 13,
				0, 1, 2, 0, 4, 5, 6, 7, 8, 9, 0, 11, 12, 0, 1, 2, 0, 4, 5, 6,
				7, 8, 9, 0, 11, 0, 1, 2, 18, 4, 5, 6, 7, 8, 9, 0, 11, 0, 1, 2,
				0, 4, 5, 6, 7, 8, 9, 0, 0, 0, 3, 16, 17, 0, 14, 15, 0, 0, 1,
				24, 25, 26, 0, 0, 0, 3, 3, 19, 20, 0, 14, 15, 10, 10, 34, 0, 0,
				30, 0, 32, 31, 0, 33, 14, 15, 0, 0, 0, 0, 3, 0, 3, 16, 17, 19,
				20, 0, 19, 20, 0, 0, 16, 17, 16, 17, 0, 0, 21, 3, 21, 14, 15,
				0, 14, 15, 10, 0, 0, 0, 3, 3, 3, 0, 0, 1, 3, 10, 10, 10, 29, 0,
				0, 10, 3, 3, 0, 0, 2, 2, 0, 10, 10, 0, 1, 0, 1, 0, 1, 0, 1, 0,
				1, 0, 0, 0, 0, 0, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 18,
				18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0 };
	};

	public final static byte termCheck[] = TermCheck.termCheck;

	public final int termCheck(int index) {
		return termCheck[index];
	}

	public interface TermAction {
		public final static char termAction[] = { 0, 522, 202, 583, 522, 556,
				557, 552, 558, 559, 560, 522, 380, 272, 344, 522, 522, 583,
				583, 53, 215, 522, 202, 583, 529, 556, 557, 552, 558, 559, 560,
				116, 380, 272, 344, 522, 100, 522, 202, 583, 522, 556, 557,
				552, 558, 559, 560, 522, 380, 272, 344, 487, 484, 491, 492,
				521, 578, 579, 577, 522, 530, 522, 202, 583, 78, 556, 557, 552,
				558, 559, 560, 522, 380, 272, 344, 1, 202, 583, 522, 556, 557,
				552, 558, 559, 560, 522, 380, 272, 344, 531, 522, 202, 583,
				270, 556, 557, 552, 558, 559, 560, 461, 380, 272, 344, 522,
				202, 583, 522, 556, 557, 552, 558, 559, 560, 522, 380, 272,
				522, 202, 583, 522, 556, 557, 552, 558, 559, 560, 522, 380, 47,
				202, 583, 292, 556, 557, 552, 558, 559, 560, 24, 380, 522, 202,
				583, 522, 556, 557, 552, 558, 559, 560, 522, 27, 522, 356, 452,
				443, 522, 402, 391, 13, 522, 463, 423, 413, 433, 522, 522, 522,
				356, 368, 80, 227, 46, 402, 391, 554, 563, 84, 26, 23, 528, 25,
				146, 245, 522, 232, 402, 391, 22, 522, 21, 522, 356, 522, 356,
				452, 443, 80, 227, 14, 80, 227, 45, 58, 452, 443, 452, 443,
				522, 522, 538, 489, 537, 402, 391, 522, 402, 391, 506, 522,
				522, 522, 368, 368, 356, 522, 522, 467, 356, 565, 566, 573,
				229, 522, 522, 572, 356, 356, 522, 12, 583, 583, 522, 571, 570,
				522, 469, 522, 472, 522, 474, 522, 258, 42, 275, 522, 522, 522,
				522, 522, 305, 522, 522, 522, 522, 522, 522, 522, 522, 522,
				522, 522, 522, 318, 331 };
	};

	public final static char termAction[] = TermAction.termAction;

	public final int termAction(int index) {
		return termAction[index];
	}

	public interface Asb {
		public final static byte asb[] = { 0, 1, 48, 75, 54, 55, 20, 21, 53,
				23, 94, 97, 29, 37, 62, 101, 77, 14, 75, 34, 55, 55, 55, 55,
				55, 53, 53, 54, 52, 55, 55, 85, 52, 34, 32, 62, 62, 62, 62, 62,
				20, 21, 21, 26, 26, 26, 105, 105, 29, 34, 108, 50, 54, 75, 75,
				75, 75, 77, 77, 75, 108, 89, 52, 32, 110, 110, 110, 110, 34,
				34, 89, 112, 51, 53, 53, 53, 53, 116, 75, 34, 34, 34, 34, 52,
				64 };
	};

	public final static byte asb[] = Asb.asb;

	public final int asb(int index) {
		return asb[index];
	}

	public interface Asr {
		public final static byte asr[] = { 0, 12, 6, 1, 2, 4, 5, 7, 8, 9, 11,
				13, 43, 0, 2, 39, 38, 36, 37, 0, 1, 20, 19, 26, 24, 25, 34, 16,
				17, 21, 30, 32, 14, 15, 3, 10, 0, 12, 6, 1, 2, 4, 5, 7, 8, 9,
				11, 13, 44, 0, 35, 23, 13, 12, 11, 4, 5, 7, 8, 9, 2, 6, 1, 0,
				12, 6, 1, 4, 5, 7, 8, 9, 11, 13, 28, 2, 0, 6, 1, 4, 5, 7, 8, 9,
				11, 10, 3, 2, 0, 42, 40, 41, 2, 0, 31, 33, 0, 32, 30, 3, 0, 34,
				14, 15, 0, 3, 21, 0, 22, 0, 18, 0, 10, 18, 3, 29, 27, 0 };
	};

	public final static byte asr[] = Asr.asr;

	public final int asr(int index) {
		return asr[index];
	}

	public interface Nasb {
		public final static byte nasb[] = { 0, 1, 14, 13, 13, 13, 14, 14, 13,
				14, 14, 14, 14, 4, 14, 14, 13, 13, 13, 14, 13, 13, 13, 13, 13,
				13, 13, 13, 4, 13, 13, 9, 1, 14, 14, 14, 14, 14, 14, 14, 14,
				14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 4, 13, 12, 12, 12, 12,
				13, 13, 12, 14, 7, 1, 14, 14, 14, 14, 14, 14, 14, 7, 14, 4, 13,
				13, 13, 13, 14, 13, 14, 14, 14, 14, 1, 4 };
	};

	public final static byte nasb[] = Nasb.nasb;

	public final int nasb(int index) {
		return nasb[index];
	}

	public interface Nasr {
		public final static byte nasr[] = { 0, 15, 1, 0, 1, 13, 0, 19, 0, 1,
				22, 0, 14, 1, 0 };
	};

	public final static byte nasr[] = Nasr.nasr;

	public final int nasr(int index) {
		return nasr[index];
	}

	public interface TerminalIndex {
		public final static byte terminalIndex[] = { 0, 11, 102, 19, 34, 35,
				37, 56, 57, 61, 12, 52, 15, 45, 49, 50, 1, 2, 18, 17, 23, 16,
				20, 48, 5, 6, 7, 13, 14, 21, 22, 29, 30, 31, 46, 47, 70, 71,
				75, 76, 89, 90, 93, 100, 101, 33, 36, 3, 4, 8, 9, 10, 24, 25,
				26, 27, 28, 38, 39, 40, 41, 42, 43, 44, 51, 53, 54, 55, 58, 59,
				60, 62, 63, 64, 65, 66, 67, 68, 69, 72, 73, 74, 77, 78, 79, 80,
				81, 82, 83, 84, 85, 86, 87, 88, 91, 92, 94, 95, 96, 97, 98, 99,
				103, 104 };
	};

	public final static byte terminalIndex[] = TerminalIndex.terminalIndex;

	public final int terminalIndex(int index) {
		return terminalIndex[index];
	}

	public interface NonterminalIndex {
		public final static byte nonterminalIndex[] = { 0, 110, 115, 0, 0, 0,
				0, 0, 0, 114, 113, 109, 108, 107, 112, 106, 0, 111, 0, 116,
				105, 0, 0, 0 };
	};

	public final static byte nonterminalIndex[] = NonterminalIndex.nonterminalIndex;

	public final int nonterminalIndex(int index) {
		return nonterminalIndex[index];
	}

	public interface ScopePrefix {
		public final static byte scopePrefix[] = { 1, 11, 19, 27, 64, 35, 41,
				73, 73, 47, 54, 60, 51 };
	};

	public final static byte scopePrefix[] = ScopePrefix.scopePrefix;

	public final int scopePrefix(int index) {
		return scopePrefix[index];
	}

	public interface ScopeSuffix {
		public final static byte scopeSuffix[] = { 9, 9, 9, 9, 71, 9, 9, 71,
				78, 9, 58, 58, 9 };
	};

	public final static byte scopeSuffix[] = ScopeSuffix.scopeSuffix;

	public final int scopeSuffix(int index) {
		return scopeSuffix[index];
	}

	public interface ScopeLhs {
		public final static byte scopeLhs[] = { 7, 7, 7, 7, 13, 8, 8, 13, 13,
				5, 12, 12, 2 };
	};

	public final static byte scopeLhs[] = ScopeLhs.scopeLhs;

	public final int scopeLhs(int index) {
		return scopeLhs[index];
	}

	public interface ScopeLa {
		public final static byte scopeLa[] = { 10, 10, 10, 10, 23, 10, 10, 23,
				35, 10, 21, 21, 10 };
	};

	public final static byte scopeLa[] = ScopeLa.scopeLa;

	public final int scopeLa(int index) {
		return scopeLa[index];
	}

	public interface ScopeStateSet {
		public final static byte scopeStateSet[] = { 1, 1, 1, 1, 22, 1, 1, 22,
				22, 1, 15, 15, 1 };
	};

	public final static byte scopeStateSet[] = ScopeStateSet.scopeStateSet;

	public final int scopeStateSet(int index) {
		return scopeStateSet[index];
	}

	public interface ScopeRhs {
		public final static byte scopeRhs[] = { 0, 115, 18, 117, 1, 37, 19,
				105, 0, 10, 0, 115, 18, 117, 1, 36, 19, 105, 0, 115, 18, 117,
				1, 38, 19, 105, 0, 115, 18, 117, 1, 39, 19, 105, 0, 119, 1,
				104, 20, 105, 0, 119, 1, 104, 19, 105, 0, 119, 1, 104, 0, 115,
				1, 0, 115, 33, 12, 0, 21, 0, 115, 31, 12, 0, 118, 35, 118, 34,
				114, 13, 0, 23, 0, 118, 34, 114, 13, 0, 35, 118, 23, 0 };
	};

	public final static byte scopeRhs[] = ScopeRhs.scopeRhs;

	public final int scopeRhs(int index) {
		return scopeRhs[index];
	}

	public interface ScopeState {
		public final static char scopeState[] = { 0, 275, 258, 368, 402, 391,
				356, 433, 423, 413, 452, 443, 215, 380, 344, 331, 318, 305,
				292, 245, 232, 202, 188, 116, 174, 100, 160, 84, 146, 132, 62,
				0 };
	};

	public final static char scopeState[] = ScopeState.scopeState;

	public final int scopeState(int index) {
		return scopeState[index];
	}

	public interface InSymb {
		public final static byte inSymb[] = { 0, 0, 123, 43, 13, 11, 104, 105,
				1, 112, 12, 115, 114, 118, 104, 114, 1, 19, 20, 115, 17, 16,
				25, 24, 26, 33, 31, 3, 32, 15, 14, 1, 34, 119, 114, 37, 36, 38,
				39, 104, 104, 105, 105, 112, 112, 112, 115, 115, 114, 125, 104,
				118, 3, 1, 1, 1, 1, 1, 1, 3, 10, 22, 35, 114, 117, 117, 117,
				117, 119, 119, 22, 122, 118, 18, 18, 18, 18, 120, 29, 115, 115,
				115, 115, 27, 118 };
	};

	public final static byte inSymb[] = InSymb.inSymb;

	public final int inSymb(int index) {
		return inSymb[index];
	}

	public interface Name {
		public final static String name[] = { "", "+", "-", "*", "/", ">", "<",
				"=", ">=", "<=", "<>", "(", ")", "{", "}", "[", "]", "->", "|",
				",", ":", "::", ";", ".", "..", "@pre", "^", "^^", "?", "$",
				"#", "%", "$empty", "NUMERIC_OPERATION", "STRING_LITERAL",
				"INTEGER_LITERAL", "REAL_LITERAL", "self", "inv", "pre",
				"post", "context", "package", "endpackage", "def", "if",
				"then", "else", "endif", "and", "or", "xor", "not", "implies",
				"let", "in", "true", "false", "body", "derive", "init", "null",
				"attr", "oper", "Set", "Bag", "Sequence", "Collection",
				"OrderedSet", "iterate", "forAll", "exists", "isUnique", "any",
				"one", "collect", "select", "reject", "collectNested",
				"sortedBy", "closure", "oclIsKindOf", "oclIsTypeOf",
				"oclAsType", "oclIsNew", "oclIsUndefined", "oclIsInvalid",
				"oclIsInState", "allInstances", "String", "Integer",
				"UnlimitedNatural", "Real", "Boolean", "Tuple", "OclAny",
				"OclVoid", "Invalid", "OclMessage", "OclInvalid", "query",
				"EOF_TOKEN", "IDENTIFIER", "INTEGER_RANGE_START",
				"ERROR_TOKEN", "goal", "Statements", "Statement", "QueryExpr",
				"LogicExpr", "SimpleName", "TypeName", "VariableDeclaration",
				"RelationalExpr", "ArithExpr", "AtomicExpr", "QName" };
	};

	public final static String name[] = Name.name;

	public final String name(int index) {
		return name[index];
	}

	public final int originalState(int state) {
		return -baseCheck[state];
	}

	public final int asi(int state) {
		return asb[originalState(state)];
	}

	public final int nasi(int state) {
		return nasb[originalState(state)];
	}

	public final int inSymbol(int state) {
		return inSymb[originalState(state)];
	}

	/**
	 * assert(! goto_default);
	 */
	public final int ntAction(int state, int sym) {
		return baseAction[state + sym];
	}

	/**
	 * assert(! shift_default);
	 */
	public final int tAction(int state, int sym) {
		int i = baseAction[state], k = i + sym;
		return termAction[termCheck[k] == sym ? k : i];
	}

	public final int lookAhead(int la_state, int sym) {
		int k = la_state + sym;
		return termAction[termCheck[k] == sym ? k : la_state];
	}
}
