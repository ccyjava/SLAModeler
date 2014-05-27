package edu.pku.sei.gmp.notation.layout.constraint;

import edu.pku.sei.gmp.notation.layout.FreeFormLayout;

public class FreeFormLayoutConstraint implements LayoutConstraint {

	public Class<?> getLayoutManagerType() {
		return FreeFormLayout.class;
	}

	public int left;
	public int top;
	public int right;
	public int bottom;

	public FreeFormLayoutConstraint() {
		this(0, 0, 0, 0);
	}

	public FreeFormLayoutConstraint(int l, int t, int r, int b) {
		left = l;
		top = t;
		right = r;
		bottom = b;
	}

}
