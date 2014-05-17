package edu.pku.sei.queryscript.parser;

public class QueryScriptKWLexerprs implements lpg.runtime.ParseTable,
		QueryScriptKWLexersym {
	public final static int ERROR_SYMBOL = 0;

	public final int getErrorSymbol() {
		return ERROR_SYMBOL;
	}

	public final static int SCOPE_UBOUND = 0;

	public final int getScopeUbound() {
		return SCOPE_UBOUND;
	}

	public final static int SCOPE_SIZE = 0;

	public final int getScopeSize() {
		return SCOPE_SIZE;
	}

	public final static int MAX_NAME_LENGTH = 0;

	public final int getMaxNameLength() {
		return MAX_NAME_LENGTH;
	}

	public final static int NUM_STATES = 260;

	public final int getNumStates() {
		return NUM_STATES;
	}

	public final static int NT_OFFSET = 54;

	public final int getNtOffset() {
		return NT_OFFSET;
	}

	public final static int LA_STATE_OFFSET = 392;

	public final int getLaStateOffset() {
		return LA_STATE_OFFSET;
	}

	public final static int MAX_LA = 1;

	public final int getMaxLa() {
		return MAX_LA;
	}

	public final static int NUM_RULES = 64;

	public final int getNumRules() {
		return NUM_RULES;
	}

	public final static int NUM_NONTERMINALS = 2;

	public final int getNumNonterminals() {
		return NUM_NONTERMINALS;
	}

	public final static int NUM_SYMBOLS = 56;

	public final int getNumSymbols() {
		return NUM_SYMBOLS;
	}

	public final static int SEGMENT_SIZE = 8192;

	public final int getSegmentSize() {
		return SEGMENT_SIZE;
	}

	public final static int START_STATE = 65;

	public final int getStartState() {
		return START_STATE;
	}

	public final static int IDENTIFIER_SYMBOL = 0;

	public final int getIdentifier_SYMBOL() {
		return IDENTIFIER_SYMBOL;
	}

	public final static int EOFT_SYMBOL = 39;

	public final int getEoftSymbol() {
		return EOFT_SYMBOL;
	}

	public final static int EOLT_SYMBOL = 55;

	public final int getEoltSymbol() {
		return EOLT_SYMBOL;
	}

	public final static int ACCEPT_ACTION = 327;

	public final int getAcceptAction() {
		return ACCEPT_ACTION;
	}

	public final static int ERROR_ACTION = 328;

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
		return QueryScriptKWLexersym.isValidForParser;
	}

	public interface IsNullable {
		public final static byte isNullable[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0 };
	};

	public final static byte isNullable[] = IsNullable.isNullable;

	public final boolean isNullable(int index) {
		return isNullable[index] != 0;
	}

	public interface ProsthesesIndex {
		public final static byte prosthesesIndex[] = { 0, 2, 1 };
	};

	public final static byte prosthesesIndex[] = ProsthesesIndex.prosthesesIndex;

	public final int prosthesesIndex(int index) {
		return prosthesesIndex[index];
	}

	public interface IsKeyword {
		public final static byte isKeyword[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0 };
	};

	public final static byte isKeyword[] = IsKeyword.isKeyword;

	public final boolean isKeyword(int index) {
		return isKeyword[index] != 0;
	}

	public interface BaseCheck {
		public final static byte baseCheck[] = { 0, 4, 3, 3, 4, 4, 7, 7, 10, 3,
				6, 4, 2, 4, 4, 5, 3, 2, 3, 3, 7, 3, 2, 4, 5, 3, 3, 8, 10, 10,
				7, 6, 6, 8, 3, 3, 7, 6, 6, 13, 8, 7, 11, 11, 9, 8, 14, 12, 12,
				12, 6, 7, 16, 4, 7, 5, 6, 7, 7, 10, 4, 10, 4, 4, 5 };
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
		public final static char baseAction[] = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 67, 98, 114, 121,
				124, 122, 128, 129, 66, 23, 57, 68, 74, 135, 76, 133, 45, 14,
				82, 138, 61, 80, 140, 42, 32, 91, 141, 144, 146, 40, 85, 145,
				149, 147, 153, 154, 157, 159, 93, 160, 167, 161, 168, 172, 169,
				178, 180, 181, 184, 185, 96, 176, 190, 94, 71, 187, 192, 193,
				105, 194, 195, 198, 204, 197, 208, 148, 22, 210, 211, 212, 217,
				219, 221, 224, 225, 230, 37, 232, 234, 235, 236, 227, 239, 241,
				242, 246, 97, 247, 244, 248, 251, 254, 256, 257, 103, 259, 263,
				199, 264, 267, 213, 269, 270, 271, 275, 278, 119, 272, 281,
				283, 285, 284, 286, 289, 290, 292, 295, 298, 305, 307, 309,
				314, 316, 317, 301, 303, 320, 321, 323, 322, 326, 327, 328,
				332, 330, 336, 337, 339, 344, 341, 347, 348, 349, 351, 356,
				357, 358, 359, 360, 364, 362, 363, 368, 377, 369, 28, 376, 370,
				378, 381, 382, 384, 383, 386, 389, 391, 396, 390, 399, 404,
				405, 409, 407, 410, 414, 416, 418, 417, 400, 423, 425, 426,
				427, 431, 432, 433, 434, 436, 440, 441, 444, 447, 448, 450,
				451, 452, 454, 458, 455, 462, 464, 456, 99, 466, 467, 468, 471,
				472, 473, 476, 483, 481, 485, 487, 486, 488, 491, 503, 490,
				505, 506, 508, 511, 495, 497, 514, 512, 516, 517, 520, 521,
				523, 526, 527, 530, 531, 532, 535, 533, 540, 544, 541, 549,
				538, 547, 551, 555, 558, 561, 563, 564, 565, 566, 569, 572,
				570, 575, 576, 580, 583, 328, 328 };
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
		public final static byte termCheck[] = { 0, 0, 1, 2, 3, 4, 5, 6, 7, 8,
				9, 10, 11, 12, 0, 14, 2, 3, 4, 18, 19, 20, 0, 0, 23, 24, 25,
				26, 0, 7, 29, 30, 0, 10, 2, 34, 4, 0, 37, 17, 0, 9, 0, 3, 12,
				0, 18, 5, 6, 4, 22, 6, 10, 25, 26, 18, 11, 0, 21, 14, 28, 0, 5,
				35, 3, 4, 0, 10, 0, 1, 2, 0, 6, 36, 0, 38, 0, 11, 7, 5, 0, 20,
				0, 3, 10, 0, 10, 2, 6, 13, 10, 0, 1, 0, 0, 2, 0, 0, 0, 0, 6,
				10, 17, 0, 8, 0, 12, 0, 3, 4, 7, 15, 19, 31, 0, 18, 17, 14, 21,
				0, 1, 0, 0, 24, 0, 1, 4, 13, 0, 0, 1, 12, 4, 0, 13, 0, 1, 39,
				0, 1, 0, 0, 1, 10, 0, 0, 0, 0, 0, 0, 10, 5, 3, 0, 0, 8, 3, 0,
				14, 0, 0, 0, 14, 2, 10, 6, 6, 0, 0, 0, 3, 3, 0, 16, 2, 6, 0,
				32, 0, 1, 0, 0, 1, 3, 0, 0, 2, 0, 3, 13, 0, 1, 0, 0, 0, 0, 9,
				0, 0, 0, 8, 2, 8, 10, 0, 1, 11, 9, 0, 1, 0, 0, 0, 0, 3, 2, 6,
				0, 6, 0, 3, 0, 3, 26, 0, 0, 1, 0, 7, 5, 0, 1, 0, 1, 0, 0, 0, 3,
				3, 0, 13, 0, 0, 7, 0, 3, 0, 0, 0, 1, 9, 0, 6, 6, 0, 4, 0, 0, 1,
				0, 21, 7, 18, 0, 0, 9, 3, 0, 9, 0, 0, 0, 0, 4, 3, 0, 6, 2, 0,
				15, 2, 0, 1, 0, 0, 0, 0, 15, 3, 0, 0, 1, 0, 4, 27, 0, 0, 11, 0,
				4, 16, 0, 10, 0, 6, 0, 1, 0, 1, 0, 9, 28, 9, 4, 0, 1, 0, 0, 1,
				3, 0, 0, 0, 0, 4, 2, 0, 0, 0, 1, 0, 5, 0, 1, 12, 5, 0, 0, 17,
				0, 13, 0, 5, 7, 0, 1, 7, 0, 0, 0, 1, 0, 11, 2, 7, 7, 0, 0, 0,
				0, 0, 1, 0, 0, 0, 7, 9, 5, 0, 0, 0, 1, 4, 17, 15, 11, 0, 0, 0,
				16, 3, 0, 0, 0, 0, 9, 0, 9, 6, 0, 0, 0, 11, 2, 25, 11, 0, 1, 8,
				0, 0, 2, 16, 20, 0, 0, 2, 0, 19, 0, 0, 11, 5, 8, 0, 6, 0, 0, 0,
				9, 2, 4, 8, 0, 8, 0, 0, 0, 1, 4, 4, 0, 0, 0, 0, 2, 0, 1, 15, 7,
				0, 0, 2, 2, 0, 1, 15, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 3, 0, 9,
				13, 27, 0, 5, 0, 1, 0, 0, 0, 7, 14, 0, 0, 0, 8, 4, 0, 5, 5, 24,
				29, 0, 14, 0, 1, 0, 0, 0, 0, 1, 0, 0, 2, 8, 7, 0, 15, 0, 22, 4,
				33, 10, 16, 0, 1, 0, 0, 1, 0, 1, 5, 0, 0, 16, 0, 1, 0, 0, 1, 8,
				0, 0, 2, 0, 8, 4, 0, 0, 5, 3, 0, 0, 0, 0, 22, 0, 1, 0, 0, 12,
				0, 0, 9, 11, 0, 5, 2, 0, 7, 0, 12, 0, 1, 23, 23, 0, 7, 2, 0,
				12, 2, 0, 1, 0, 0, 0, 0, 1, 4, 0, 0, 8, 0, 1, 9, 0, 0, 0, 8, 0,
				0, 6, 13, 0, 8, 5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	};

	public final static byte termCheck[] = TermCheck.termCheck;

	public final int termCheck(int index) {
		return termCheck[index];
	}

	public interface TermAction {
		public final static char termAction[] = { 0, 328, 86, 84, 79, 80, 83,
				73, 90, 85, 91, 82, 87, 78, 328, 89, 114, 115, 116, 72, 68, 81,
				22, 328, 74, 77, 69, 71, 328, 170, 76, 88, 328, 100, 130, 75,
				132, 328, 70, 330, 328, 129, 328, 138, 340, 328, 246, 126, 128,
				113, 248, 345, 127, 249, 247, 179, 112, 328, 182, 111, 131,
				328, 102, 250, 121, 122, 328, 101, 328, 104, 103, 328, 99, 180,
				328, 181, 328, 98, 158, 106, 328, 120, 328, 123, 105, 328, 109,
				140, 117, 108, 124, 328, 134, 328, 328, 353, 328, 328, 328,
				328, 157, 133, 139, 328, 344, 328, 337, 328, 162, 163, 195,
				362, 147, 118, 328, 191, 285, 196, 190, 328, 205, 328, 328,
				284, 328, 94, 95, 92, 328, 328, 97, 329, 96, 328, 93, 328, 107,
				327, 328, 119, 328, 328, 135, 110, 328, 328, 328, 328, 328,
				328, 125, 137, 142, 328, 328, 143, 144, 328, 136, 328, 328,
				328, 169, 349, 145, 146, 148, 328, 328, 328, 149, 150, 328,
				354, 347, 346, 328, 141, 328, 151, 328, 328, 363, 152, 328,
				328, 153, 328, 154, 155, 328, 156, 328, 328, 328, 328, 159,
				328, 328, 328, 160, 199, 164, 161, 328, 331, 165, 166, 328,
				168, 328, 328, 328, 328, 172, 332, 171, 328, 173, 328, 174,
				328, 381, 167, 328, 328, 177, 328, 175, 176, 328, 178, 328,
				183, 328, 328, 328, 184, 185, 328, 187, 328, 328, 186, 328,
				388, 328, 328, 328, 351, 189, 328, 391, 390, 328, 341, 328,
				328, 342, 328, 188, 193, 192, 328, 328, 194, 198, 328, 197,
				328, 328, 328, 328, 201, 203, 328, 202, 339, 328, 333, 204,
				328, 383, 328, 328, 328, 328, 392, 207, 328, 328, 211, 328,
				210, 200, 328, 328, 209, 328, 213, 208, 328, 212, 328, 214,
				328, 215, 328, 216, 328, 220, 206, 221, 217, 328, 218, 328,
				328, 352, 219, 328, 328, 328, 328, 222, 224, 328, 328, 328,
				227, 328, 225, 328, 228, 343, 229, 328, 328, 223, 328, 226,
				328, 231, 230, 328, 233, 232, 328, 328, 328, 237, 328, 234,
				366, 235, 236, 328, 328, 328, 328, 328, 241, 328, 328, 328,
				240, 239, 243, 328, 328, 328, 338, 244, 238, 384, 242, 328,
				328, 328, 378, 359, 328, 328, 328, 328, 251, 328, 360, 253,
				328, 328, 328, 252, 258, 245, 254, 328, 259, 260, 328, 328,
				365, 256, 255, 328, 328, 261, 328, 257, 328, 328, 266, 262,
				386, 328, 379, 328, 328, 328, 263, 265, 382, 385, 328, 264,
				328, 328, 328, 270, 268, 269, 328, 328, 328, 328, 273, 328,
				369, 267, 272, 328, 328, 275, 334, 328, 335, 271, 328, 328,
				358, 328, 328, 328, 278, 328, 328, 328, 279, 328, 348, 276,
				274, 328, 280, 328, 355, 328, 328, 328, 282, 283, 328, 328,
				328, 286, 288, 36, 289, 290, 281, 277, 328, 287, 328, 361, 328,
				328, 328, 328, 295, 328, 328, 297, 292, 293, 328, 368, 328,
				291, 302, 373, 296, 294, 328, 372, 328, 328, 299, 328, 300,
				298, 328, 328, 303, 328, 304, 328, 328, 387, 301, 328, 328,
				357, 328, 389, 356, 328, 328, 306, 307, 328, 328, 328, 328,
				305, 328, 336, 328, 328, 308, 328, 328, 312, 311, 328, 313,
				314, 328, 315, 328, 371, 328, 317, 309, 310, 328, 316, 318,
				328, 370, 319, 328, 376, 328, 328, 328, 328, 321, 320, 328,
				328, 375, 328, 323, 377, 328, 328, 328, 367, 328, 328, 324,
				322, 328, 374, 325, 380 };
	};

	public final static char termAction[] = TermAction.termAction;

	public final int termAction(int index) {
		return termAction[index];
	}

	public final int asb(int index) {
		return 0;
	}

	public final int asr(int index) {
		return 0;
	}

	public final int nasb(int index) {
		return 0;
	}

	public final int nasr(int index) {
		return 0;
	}

	public final int terminalIndex(int index) {
		return 0;
	}

	public final int nonterminalIndex(int index) {
		return 0;
	}

	public final int scopePrefix(int index) {
		return 0;
	}

	public final int scopeSuffix(int index) {
		return 0;
	}

	public final int scopeLhs(int index) {
		return 0;
	}

	public final int scopeLa(int index) {
		return 0;
	}

	public final int scopeStateSet(int index) {
		return 0;
	}

	public final int scopeRhs(int index) {
		return 0;
	}

	public final int scopeState(int index) {
		return 0;
	}

	public final int inSymb(int index) {
		return 0;
	}

	public final String name(int index) {
		return null;
	}

	public final int originalState(int state) {
		return 0;
	}

	public final int asi(int state) {
		return 0;
	}

	public final int nasi(int state) {
		return 0;
	}

	public final int inSymbol(int state) {
		return 0;
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
