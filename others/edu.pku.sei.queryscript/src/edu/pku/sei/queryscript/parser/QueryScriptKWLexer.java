package edu.pku.sei.queryscript.parser;


public class QueryScriptKWLexer extends QueryScriptKWLexerprs // implements
																// QueryScriptParsersym
{
	private char[] inputChars;
	private final int keywordKind[] = new int[64 + 1];

	public int[] getKeywordKinds() {
		return keywordKind;
	}

	public int lexer(int curtok, int lasttok) {
		int current_kind = getKind(inputChars[curtok]), act;

		for (act = tAction(START_STATE, current_kind); act > NUM_RULES
				&& act < ACCEPT_ACTION; act = tAction(act, current_kind)) {
			curtok++;
			current_kind = (curtok > lasttok ? QueryScriptKWLexersym.Char_EOF
					: getKind(inputChars[curtok]));
		}

		if (act > ERROR_ACTION) {
			curtok++;
			act -= ERROR_ACTION;
		}

		return keywordKind[act == ERROR_ACTION || curtok <= lasttok ? 0 : act];
	}

	public void setInputChars(char[] inputChars) {
		this.inputChars = inputChars;
	}

	final static int tokenKind[] = new int[128];
	static {
		tokenKind['$'] = QueryScriptKWLexersym.Char_DollarSign;

		tokenKind['a'] = QueryScriptKWLexersym.Char_a;
		tokenKind['b'] = QueryScriptKWLexersym.Char_b;
		tokenKind['c'] = QueryScriptKWLexersym.Char_c;
		tokenKind['d'] = QueryScriptKWLexersym.Char_d;
		tokenKind['e'] = QueryScriptKWLexersym.Char_e;
		tokenKind['f'] = QueryScriptKWLexersym.Char_f;
		tokenKind['g'] = QueryScriptKWLexersym.Char_g;
		tokenKind['h'] = QueryScriptKWLexersym.Char_h;
		tokenKind['i'] = QueryScriptKWLexersym.Char_i;
		tokenKind['j'] = QueryScriptKWLexersym.Char_j;
		tokenKind['k'] = QueryScriptKWLexersym.Char_k;
		tokenKind['l'] = QueryScriptKWLexersym.Char_l;
		tokenKind['m'] = QueryScriptKWLexersym.Char_m;
		tokenKind['n'] = QueryScriptKWLexersym.Char_n;
		tokenKind['o'] = QueryScriptKWLexersym.Char_o;
		tokenKind['p'] = QueryScriptKWLexersym.Char_p;
		tokenKind['q'] = QueryScriptKWLexersym.Char_q;
		tokenKind['r'] = QueryScriptKWLexersym.Char_r;
		tokenKind['s'] = QueryScriptKWLexersym.Char_s;
		tokenKind['t'] = QueryScriptKWLexersym.Char_t;
		tokenKind['u'] = QueryScriptKWLexersym.Char_u;
		tokenKind['v'] = QueryScriptKWLexersym.Char_v;
		tokenKind['w'] = QueryScriptKWLexersym.Char_w;
		tokenKind['x'] = QueryScriptKWLexersym.Char_x;
		tokenKind['y'] = QueryScriptKWLexersym.Char_y;
		tokenKind['z'] = QueryScriptKWLexersym.Char_z;

		tokenKind['A'] = QueryScriptKWLexersym.Char_A;
		tokenKind['B'] = QueryScriptKWLexersym.Char_B;
		tokenKind['C'] = QueryScriptKWLexersym.Char_C;
		tokenKind['D'] = QueryScriptKWLexersym.Char_D;
		tokenKind['E'] = QueryScriptKWLexersym.Char_E;
		tokenKind['F'] = QueryScriptKWLexersym.Char_F;
		tokenKind['G'] = QueryScriptKWLexersym.Char_G;
		tokenKind['H'] = QueryScriptKWLexersym.Char_H;
		tokenKind['I'] = QueryScriptKWLexersym.Char_I;
		tokenKind['J'] = QueryScriptKWLexersym.Char_J;
		tokenKind['K'] = QueryScriptKWLexersym.Char_K;
		tokenKind['L'] = QueryScriptKWLexersym.Char_L;
		tokenKind['M'] = QueryScriptKWLexersym.Char_M;
		tokenKind['N'] = QueryScriptKWLexersym.Char_N;
		tokenKind['O'] = QueryScriptKWLexersym.Char_O;
		tokenKind['P'] = QueryScriptKWLexersym.Char_P;
		tokenKind['Q'] = QueryScriptKWLexersym.Char_Q;
		tokenKind['R'] = QueryScriptKWLexersym.Char_R;
		tokenKind['S'] = QueryScriptKWLexersym.Char_S;
		tokenKind['T'] = QueryScriptKWLexersym.Char_T;
		tokenKind['U'] = QueryScriptKWLexersym.Char_U;
		tokenKind['V'] = QueryScriptKWLexersym.Char_V;
		tokenKind['W'] = QueryScriptKWLexersym.Char_W;
		tokenKind['X'] = QueryScriptKWLexersym.Char_X;
		tokenKind['Y'] = QueryScriptKWLexersym.Char_Y;
		tokenKind['Z'] = QueryScriptKWLexersym.Char_Z;
	};

	final int getKind(char c) {
		return (((c & 0xFFFFFF80) == 0) /* 0 <= c < 128? */? tokenKind[c] : 0);
	}

	public QueryScriptKWLexer(char[] inputChars, int identifierKind) {
		this.inputChars = inputChars;
		keywordKind[0] = identifierKind;

		//
		// Rule 1: KeyWord ::= s e l f
		//

		keywordKind[1] = (QueryScriptParsersym.TK_self);

		//
		// Rule 2: KeyWord ::= i n v
		//

		keywordKind[2] = (QueryScriptParsersym.TK_inv);

		//
		// Rule 3: KeyWord ::= p r e
		//

		keywordKind[3] = (QueryScriptParsersym.TK_pre);

		//
		// Rule 4: KeyWord ::= p o s t
		//

		keywordKind[4] = (QueryScriptParsersym.TK_post);

		//
		// Rule 5: KeyWord ::= b o d y
		//

		keywordKind[5] = (QueryScriptParsersym.TK_body);

		//
		// Rule 6: KeyWord ::= c o n t e x t
		//

		keywordKind[6] = (QueryScriptParsersym.TK_context);

		//
		// Rule 7: KeyWord ::= p a c k a g e
		//

		keywordKind[7] = (QueryScriptParsersym.TK_package);

		//
		// Rule 8: KeyWord ::= e n d p a c k a g e
		//

		keywordKind[8] = (QueryScriptParsersym.TK_endpackage);

		//
		// Rule 9: KeyWord ::= d e f
		//

		keywordKind[9] = (QueryScriptParsersym.TK_def);

		//
		// Rule 10: KeyWord ::= d e r i v e
		//

		keywordKind[10] = (QueryScriptParsersym.TK_derive);

		//
		// Rule 11: KeyWord ::= i n i t
		//

		keywordKind[11] = (QueryScriptParsersym.TK_init);

		//
		// Rule 12: KeyWord ::= i f
		//

		keywordKind[12] = (QueryScriptParsersym.TK_if);

		//
		// Rule 13: KeyWord ::= t h e n
		//

		keywordKind[13] = (QueryScriptParsersym.TK_then);

		//
		// Rule 14: KeyWord ::= e l s e
		//

		keywordKind[14] = (QueryScriptParsersym.TK_else);

		//
		// Rule 15: KeyWord ::= e n d i f
		//

		keywordKind[15] = (QueryScriptParsersym.TK_endif);

		//
		// Rule 16: KeyWord ::= a n d
		//

		keywordKind[16] = (QueryScriptParsersym.TK_and);

		//
		// Rule 17: KeyWord ::= o r
		//

		keywordKind[17] = (QueryScriptParsersym.TK_or);

		//
		// Rule 18: KeyWord ::= x o r
		//

		keywordKind[18] = (QueryScriptParsersym.TK_xor);

		//
		// Rule 19: KeyWord ::= n o t
		//

		keywordKind[19] = (QueryScriptParsersym.TK_not);

		//
		// Rule 20: KeyWord ::= i m p l i e s
		//

		keywordKind[20] = (QueryScriptParsersym.TK_implies);

		//
		// Rule 21: KeyWord ::= l e t
		//

		keywordKind[21] = (QueryScriptParsersym.TK_let);

		//
		// Rule 22: KeyWord ::= i n
		//

		keywordKind[22] = (QueryScriptParsersym.TK_in);

		//
		// Rule 23: KeyWord ::= t r u e
		//

		keywordKind[23] = (QueryScriptParsersym.TK_true);

		//
		// Rule 24: KeyWord ::= f a l s e
		//

		keywordKind[24] = (QueryScriptParsersym.TK_false);

		//
		// Rule 25: KeyWord ::= S e t
		//

		keywordKind[25] = (QueryScriptParsersym.TK_Set);

		//
		// Rule 26: KeyWord ::= B a g
		//

		keywordKind[26] = (QueryScriptParsersym.TK_Bag);

		//
		// Rule 27: KeyWord ::= S e q u e n c e
		//

		keywordKind[27] = (QueryScriptParsersym.TK_Sequence);

		//
		// Rule 28: KeyWord ::= C o l l e c t i o n
		//

		keywordKind[28] = (QueryScriptParsersym.TK_Collection);

		//
		// Rule 29: KeyWord ::= O r d e r e d S e t
		//

		keywordKind[29] = (QueryScriptParsersym.TK_OrderedSet);

		//
		// Rule 30: KeyWord ::= i t e r a t e
		//

		keywordKind[30] = (QueryScriptParsersym.TK_iterate);

		//
		// Rule 31: KeyWord ::= f o r A l l
		//

		keywordKind[31] = (QueryScriptParsersym.TK_forAll);

		//
		// Rule 32: KeyWord ::= e x i s t s
		//

		keywordKind[32] = (QueryScriptParsersym.TK_exists);

		//
		// Rule 33: KeyWord ::= i s U n i q u e
		//

		keywordKind[33] = (QueryScriptParsersym.TK_isUnique);

		//
		// Rule 34: KeyWord ::= a n y
		//

		keywordKind[34] = (QueryScriptParsersym.TK_any);

		//
		// Rule 35: KeyWord ::= o n e
		//

		keywordKind[35] = (QueryScriptParsersym.TK_one);

		//
		// Rule 36: KeyWord ::= c o l l e c t
		//

		keywordKind[36] = (QueryScriptParsersym.TK_collect);

		//
		// Rule 37: KeyWord ::= s e l e c t
		//

		keywordKind[37] = (QueryScriptParsersym.TK_select);

		//
		// Rule 38: KeyWord ::= r e j e c t
		//

		keywordKind[38] = (QueryScriptParsersym.TK_reject);

		//
		// Rule 39: KeyWord ::= c o l l e c t N e s t e d
		//

		keywordKind[39] = (QueryScriptParsersym.TK_collectNested);

		//
		// Rule 40: KeyWord ::= s o r t e d B y
		//

		keywordKind[40] = (QueryScriptParsersym.TK_sortedBy);

		//
		// Rule 41: KeyWord ::= c l o s u r e
		//

		keywordKind[41] = (QueryScriptParsersym.TK_closure);

		//
		// Rule 42: KeyWord ::= o c l I s K i n d O f
		//

		keywordKind[42] = (QueryScriptParsersym.TK_oclIsKindOf);

		//
		// Rule 43: KeyWord ::= o c l I s T y p e O f
		//

		keywordKind[43] = (QueryScriptParsersym.TK_oclIsTypeOf);

		//
		// Rule 44: KeyWord ::= o c l A s T y p e
		//

		keywordKind[44] = (QueryScriptParsersym.TK_oclAsType);

		//
		// Rule 45: KeyWord ::= o c l I s N e w
		//

		keywordKind[45] = (QueryScriptParsersym.TK_oclIsNew);

		//
		// Rule 46: KeyWord ::= o c l I s U n d e f i n e d
		//

		keywordKind[46] = (QueryScriptParsersym.TK_oclIsUndefined);

		//
		// Rule 47: KeyWord ::= o c l I s I n v a l i d
		//

		keywordKind[47] = (QueryScriptParsersym.TK_oclIsInvalid);

		//
		// Rule 48: KeyWord ::= o c l I s I n S t a t e
		//

		keywordKind[48] = (QueryScriptParsersym.TK_oclIsInState);

		//
		// Rule 49: KeyWord ::= a l l I n s t a n c e s
		//

		keywordKind[49] = (QueryScriptParsersym.TK_allInstances);

		//
		// Rule 50: KeyWord ::= S t r i n g
		//

		keywordKind[50] = (QueryScriptParsersym.TK_String);

		//
		// Rule 51: KeyWord ::= I n t e g e r
		//

		keywordKind[51] = (QueryScriptParsersym.TK_Integer);

		//
		// Rule 52: KeyWord ::= U n l i m i t e d N a t u r a l
		//

		keywordKind[52] = (QueryScriptParsersym.TK_UnlimitedNatural);

		//
		// Rule 53: KeyWord ::= R e a l
		//

		keywordKind[53] = (QueryScriptParsersym.TK_Real);

		//
		// Rule 54: KeyWord ::= B o o l e a n
		//

		keywordKind[54] = (QueryScriptParsersym.TK_Boolean);

		//
		// Rule 55: KeyWord ::= T u p l e
		//

		keywordKind[55] = (QueryScriptParsersym.TK_Tuple);

		//
		// Rule 56: KeyWord ::= O c l A n y
		//

		keywordKind[56] = (QueryScriptParsersym.TK_OclAny);

		//
		// Rule 57: KeyWord ::= O c l V o i d
		//

		keywordKind[57] = (QueryScriptParsersym.TK_OclVoid);

		//
		// Rule 58: KeyWord ::= I n v a l i d
		//

		keywordKind[58] = (QueryScriptParsersym.TK_Invalid);

		//
		// Rule 59: KeyWord ::= O c l M e s s a g e
		//

		keywordKind[59] = (QueryScriptParsersym.TK_OclMessage);

		//
		// Rule 60: KeyWord ::= n u l l
		//

		keywordKind[60] = (QueryScriptParsersym.TK_null);

		//
		// Rule 61: KeyWord ::= O c l I n v a l i d
		//

		keywordKind[61] = (QueryScriptParsersym.TK_OclInvalid);

		//
		// Rule 62: KeyWord ::= a t t r
		//

		keywordKind[62] = (QueryScriptParsersym.TK_attr);

		//
		// Rule 63: KeyWord ::= o p e r
		//

		keywordKind[63] = (QueryScriptParsersym.TK_oper);

		//
		// Rule 64: KeyWord ::= q u e r y
		//

		keywordKind[64] = (QueryScriptParsersym.TK_query);

		for (int i = 0; i < keywordKind.length; i++) {
			if (keywordKind[i] == 0)
				keywordKind[i] = identifierKind;
		}
	}
}
