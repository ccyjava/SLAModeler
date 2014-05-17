package edu.pku.sei.queryscript.parser;

import edu.pku.sei.queryscript.parser.Ast.AbstractResultVisitor;

public class ResultVisitor extends AbstractResultVisitor {

	@Override
	public Object unimplementedVisitor(String s) {
		System.out.println(s);
		return null;
	}

}
