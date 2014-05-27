package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class AbstractPolygonFigure extends AbstractNotationFigure implements
		IRefreshFigure {
	protected Rectangle SINGLETON = new Rectangle();
	protected int[] points = null;
	protected Point[] srcPoint = null;

	protected void fillShape(Graphics graphics) {
		if (points == null)
			return;
		graphics.fillPolygon(points);
	}

	protected void outlineShape(Graphics graphics) {
		if (points == null) {
			SINGLETON.setBounds(getBounds());
			SINGLETON.width -= lineWidth;
			SINGLETON.height -= lineWidth;
			graphics.drawFocus(SINGLETON);
			return;
		}
		graphics.drawPolygon(points);
	}

	public void refresh() {
		if (srcPoint == null || srcPoint.length < 3) {
			points = null;
			return;
		}
		SINGLETON.setBounds(getBounds());
		SINGLETON.width -= lineWidth;
		SINGLETON.height -= lineWidth;

		double x_scale = ((double) SINGLETON.width) / (100.0);
		double y_scale = ((double) SINGLETON.height) / (100.0);

		if (points == null || points.length != srcPoint.length * 2) {
			points = new int[srcPoint.length * 2];
		}

		for (int i = 0; i < srcPoint.length; i++) {
			points[i + i] = (int) (srcPoint[i].x * x_scale) + SINGLETON.x;
			points[i + i + 1] = (int) (srcPoint[i].y * y_scale) + SINGLETON.y;
		}
	}

	public void setSrcPoint(Point[] srcPoint) {
		this.srcPoint = srcPoint;
	}
}
