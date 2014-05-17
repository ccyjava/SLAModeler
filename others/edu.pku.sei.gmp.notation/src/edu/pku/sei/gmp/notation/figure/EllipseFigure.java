package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class EllipseFigure extends AbstractNotationFigure {
	protected Rectangle SINGLETON = new Rectangle();

	protected void fillShape(Graphics graphics) {
		if (getLocalBackgroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		SINGLETON.setLocation(size.x, size.y);
		SINGLETON.setSize(size.width, size.height);
		SINGLETON.height -= lineWidth;
		SINGLETON.width -= lineWidth;

		graphics.fillOval(SINGLETON);
	}

	protected void outlineShape(Graphics graphics) {
		if (getLocalForegroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		SINGLETON.setLocation(size.x, size.y);
		SINGLETON.setSize(size.width, size.height);
		SINGLETON.height -= lineWidth;
		SINGLETON.width -= lineWidth;
		graphics.drawOval(SINGLETON);
	}
}
