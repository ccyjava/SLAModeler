package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;

public class PolylineFigure extends AbstractNotationFigure implements
		IRefreshFigure {

	protected Rectangle SINGLETON = new Rectangle();
	protected int[] points = null;
	protected Point[] srcPoint = null;

	static public PolylineFigure createVerticalLineFigure() {
		PolylineFigure p = new PolylineFigure(2);
		p.setSrcPoint(50, 0, 0);
		p.setSrcPoint(50, 100, 1);
		return p;
	}

	static public PolylineFigure createHorizontalLineFigure() {
		PolylineFigure p = new PolylineFigure(2);
		p.setSrcPoint(0, 50, 0);
		p.setSrcPoint(100, 50, 1);
		return p;
	}

	public PolylineFigure(int size) {
		super();
		if (size < 1)
			return;
		srcPoint = new Point[size];
		points = new int[size * 2];
	}

	protected void fillShape(Graphics graphics) {
	}

	public void setBounds(Rectangle bounds) {
		super.setBounds(bounds);
		refresh();
	}

	protected void primTranslate(int dx, int dy) {
		super.primTranslate(dx, dy);
		refresh();
	}

	protected void outlineShape(Graphics graphics) {
		if (points == null) {
			SINGLETON.setBounds(getBounds());
			SINGLETON.width -= lineWidth;
			SINGLETON.height -= lineWidth;
			graphics.drawFocus(SINGLETON);
			return;
		}
		// graphics.set
		graphics.drawPolyline(points);
	}

	public void refresh() {
		if (srcPoint == null || srcPoint.length < 2) {
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

	public void setSrcPoint(int x, int y, int index) {
		if (srcPoint[index] == null)
			srcPoint[index] = new Point();
		srcPoint[index].x = x;
		srcPoint[index].y = y;
	}
}
