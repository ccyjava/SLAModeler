package edu.pku.sei.gmp.notation.layout.constraint;

import org.eclipse.draw2d.geometry.Rectangle;

import edu.pku.sei.gmp.notation.layout.VectorGraphLayout;

public class VectorGraphLayoutConstraint implements LayoutConstraint {

	public double x;
	public double y;
	public double w;
	public double h;

	public Class<?> getLayoutManagerType() {
		return VectorGraphLayout.class;
	}

	public VectorGraphLayoutConstraint(Rectangle mbound, Rectangle sbound) {
		double hRate, vRate;
		hRate = 100.0 / ((double) mbound.width);
		vRate = 100.0 / ((double) mbound.height);

		x = ((double) (sbound.x - mbound.x)) * hRate;
		y = ((double) (sbound.y - mbound.y)) * vRate;
		w = ((double) sbound.width) * hRate;
		h = ((double) sbound.height) * vRate;
	}

}
