package edu.pku.sei.queryscript.parser;

public interface QueryScriptKWLexersym {
	public final static int Char_DollarSign = 40, Char_a = 5, Char_b = 30,
			Char_c = 11, Char_d = 8, Char_e = 1, Char_f = 12, Char_g = 16,
			Char_h = 31, Char_i = 7, Char_j = 32, Char_k = 27, Char_l = 3,
			Char_m = 28, Char_n = 4, Char_o = 10, Char_p = 14, Char_q = 19,
			Char_r = 6, Char_s = 9, Char_t = 2, Char_u = 13, Char_v = 17,
			Char_w = 33, Char_x = 20, Char_y = 15, Char_z = 41, Char_A = 21,
			Char_B = 29, Char_C = 34, Char_D = 42, Char_E = 43, Char_F = 44,
			Char_G = 45, Char_H = 46, Char_I = 18, Char_J = 47, Char_K = 35,
			Char_L = 48, Char_M = 36, Char_N = 22, Char_O = 23, Char_P = 49,
			Char_Q = 50, Char_R = 37, Char_S = 24, Char_T = 25, Char_U = 26,
			Char_V = 38, Char_W = 51, Char_X = 52, Char_Y = 53, Char_Z = 54,
			Char_EOF = 39;

	public final static String orderedTerminalSymbols[] = { "", "e", "t", "l",
			"n", "a", "r", "i", "d", "s", "o", "c", "f", "u", "p", "y", "g",
			"v", "I", "q", "x", "A", "N", "O", "S", "T", "U", "k", "m", "B",
			"b", "h", "j", "w", "C", "K", "M", "R", "V", "EOF", "DollarSign",
			"z", "D", "E", "F", "G", "H", "J", "L", "P", "Q", "W", "X", "Y",
			"Z" };

	public final static int numTokenKinds = orderedTerminalSymbols.length;
	public final static boolean isValidForParser = true;
}
