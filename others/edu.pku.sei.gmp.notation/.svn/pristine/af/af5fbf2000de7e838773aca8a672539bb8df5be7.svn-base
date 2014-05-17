package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class DiamondFigure extends AbstractNotationFigure implements
		IRefreshFigure {

	protected int[] points = null;

	public DiamondFigure() {
		super();
		points = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
	}

	public void setPoint(int x, int y, int index) {
		points[index + index] = x;
		points[index + index + 1] = y;
	}

	protected Rectangle SINGLETON = new Rectangle();

	public void refresh() {
		SINGLETON.setBounds(getBounds());
		SINGLETON.width -= lineWidth;
		SINGLETON.height -= lineWidth;

		setPoint(SINGLETON.x + SINGLETON.width / 2, SINGLETON.y, 0);
		setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y + SINGLETON.height
				/ 2, 1);
		setPoint(SINGLETON.x + SINGLETON.width / 2, SINGLETON.y
				+ SINGLETON.height, 2);
		setPoint(SINGLETON.x, SINGLETON.y + SINGLETON.height / 2, 3);
	}

	protected void fillShape(Graphics graphics) {
		refresh();
		graphics.fillPolygon(points);
	}

	protected void outlineShape(Graphics graphics) {
		if (getLocalForegroundColor() == null)
			return;
		refresh();
		graphics.drawPolygon(points);

	}

}
