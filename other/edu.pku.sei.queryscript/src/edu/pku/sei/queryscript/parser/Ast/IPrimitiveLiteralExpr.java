package edu.pku.sei.queryscript.parser.Ast;

/**
 * is always implemented by <b>AstToken</b>. It is also implemented by: <b>
 *<ul>
 *<li>StringPrimitiveLiteralExpr
 *<li>IntegerPrimitiveLiteralExpr
 *<li>BooleanPrimitiveLiteralExpr
 *<li>NullLiteralExpr
 *</ul>
 *</b>
 */
public interface IPrimitiveLiteralExpr extends ILiteralExpr, IAstToken {
}
