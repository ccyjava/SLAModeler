package edu.pku.sei.gmp.resource.font;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;

public class GMPFontProvider {
	private static Font FONT_ITALICS;
	private static Font FONT_HEAD;
	private static Font FONT_HEAD_ITALICS;
	
	static {
		FONT_ITALICS = new Font(Display.getDefault(), "Arial", 9, SWT.ITALIC);
		FONT_HEAD = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD);
		FONT_HEAD_ITALICS = new Font(Display.getDefault(), "Arial", 9, SWT.BOLD|SWT.ITALIC);
	}
	
	public static Font getItalicsFont() {
		return FONT_ITALICS;
	}
	
	public static Font getHeadFont() {
		return FONT_HEAD;
	}
	
	public static Font getHeadItalicsFont() {
		return FONT_HEAD_ITALICS;
	}
}
