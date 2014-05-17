package edu.pku.sei.queryscript.parser;

import edu.pku.sei.queryscript.parser.Ast.Ast;

public class ScriptParser {
	static public Ast parse(String s) {
		Ast ast = null;
		// System.out.println("parse : "+s);
		try {
			QueryScriptLexer Expr_lexer = new QueryScriptLexer(s.toCharArray(),
					null);
			QueryScriptParser Expr_parser = new QueryScriptParser(Expr_lexer);
			Expr_lexer.lexer(Expr_parser);
			ast = Expr_parser.parser();
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Error e) {
			// e.printStackTrace();
		}
		return ast;
	}
}
