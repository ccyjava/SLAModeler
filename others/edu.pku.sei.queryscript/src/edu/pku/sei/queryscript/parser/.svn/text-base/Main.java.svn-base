package edu.pku.sei.queryscript.parser;

import edu.pku.sei.queryscript.parser.Ast.Ast;

public class Main {
	public static void main(String[] args) {

		QueryScriptLexer Expr_lexer;
		QueryScriptParser Expr_parser;
		Ast ast;

		try {

			String s = "a=2;" + "2>1;" + "a>b;" + "c=a+b;";
			Expr_lexer = // Create the lexer
			new QueryScriptLexer(s.toCharArray(), null);
			Expr_parser = // Create the parser
			new QueryScriptParser(Expr_lexer);

			// Lex the stream to produce the token stream
			Expr_lexer.lexer(Expr_parser);

			// Parse the token stream to produce an AST
			ast = Expr_parser.parser();
			if (ast != null) {
				Integer result = (Integer) ast.accept(new ResultVisitor());
				System.out.println("check only visitor");
				// Context context = new Context();
				// context.registVariable("a", PrimitiveType.TYPE_INTEGER,
				// false).setValue(new Integer(2));
				// context.registVariable("b", PrimitiveType.TYPE_INTEGER,
				// false).setValue(new Integer(1));
				// context.registVariable("c", PrimitiveType.TYPE_INTEGER,
				// false).setValue(new Integer(3));
				// QueryVisitor visitor = new ModelCheckVistor(context);
				// Object obj = ast.accept(visitor);
				// System.out.println("result: "+obj.toString());
			}

			return;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
