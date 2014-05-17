package edu.pku.sei.gmp.notation.layout.constraint;

import edu.pku.sei.gmp.notation.layout.FlowLayout;

public class FlowLayoutConstraint implements LayoutConstraint {
	
	public int width;
	public int height;
	public int align;
	final static public int ALIGN_LEFT = 0;
	final static public int ALIGN_TOP = 0;
	final static public int ALIGN_CENTER = 1;
	final static public int ALIGN_RIGHT = 2;
	final static public int ALIGN_BOTTOM = 2;
	
	public FlowLayoutConstraint() {
		this(10,10);
	}
	public FlowLayoutConstraint(int w,int h) {
		this(w,h,-1);
	}
	public FlowLayoutConstraint(int w,int h,int a) {
		width = w;
		height = h;
		align = a;
	}
	@Override
	public Class<?> getLayoutManagerType() {
		return FlowLayout.class;
	}

}
