package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class TriangleFigure extends AbstractNotationFigure implements
		IRefreshFigure {
	protected int direction;
	protected int[] points = null;
	static public final int NORTH = 0;
	static public final int SOUTH = 1;
	static public final int EAST = 2;
	static public final int WEST = 3;

	public TriangleFigure(int dir) {
		super();
		direction = dir;
		points = new int[] { 0, 0, 0, 0, 0, 0 };
	}

	public TriangleFigure() {
		this(NORTH);
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

		switch (direction) {
		case NORTH:
			setPoint(SINGLETON.x + SINGLETON.width / 2, SINGLETON.y, 0);
			setPoint(SINGLETON.x, SINGLETON.y + SINGLETON.height, 1);
			setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y
					+ SINGLETON.height, 2);
			break;
		case SOUTH:
			setPoint(SINGLETON.x + SINGLETON.width / 2, SINGLETON.y
					+ SINGLETON.height, 0);
			setPoint(SINGLETON.x, SINGLETON.y, 1);
			setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y, 2);
			break;
		case EAST:
			setPoint(SINGLETON.x, SINGLETON.y + SINGLETON.height / 2, 0);
			setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y, 1);
			setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y
					+ SINGLETON.height, 2);
			break;
		case WEST:
			setPoint(SINGLETON.x + SINGLETON.width, SINGLETON.y
					+ SINGLETON.height / 2, 0);
			setPoint(SINGLETON.x, SINGLETON.y, 1);
			setPoint(SINGLETON.x, SINGLETON.y + SINGLETON.height, 2);
			break;
		}

	}

	protected void fillShape(Graphics graphics) {
		if (getLocalBackgroundColor() == null)
			return;
		refresh();
		graphics.fillPolygon(points);
	}

	protected void outlineShape(Graphics graphics) {
		if (getLocalForegroundColor() == null)
			return;
		refresh();
		graphics.drawPolygon(points);
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}
