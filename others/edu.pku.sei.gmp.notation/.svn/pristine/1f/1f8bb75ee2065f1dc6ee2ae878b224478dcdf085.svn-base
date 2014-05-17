package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class CircleFigure extends AbstractNotationFigure {
	protected Rectangle SINGLETON = new Rectangle();

	protected void fillShape(Graphics graphics) {
		if (getLocalBackgroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		int d = Math.min(size.width, size.height);
		SINGLETON.setLocation(size.x + (size.width - d) / 2, size.y
				+ (size.height - d) / 2);
		SINGLETON.setSize(d - lineWidth, d - lineWidth);

		graphics.fillOval(SINGLETON);
	}

	protected void outlineShape(Graphics graphics) {
		if (getLocalForegroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		int d = Math.min(size.width, size.height);
		SINGLETON.setLocation(size.x + (size.width - d) / 2, size.y
				+ (size.height - d) / 2);
		SINGLETON.setSize(d, d);
		SINGLETON.shrink(this.lineWidth, this.lineWidth);
		graphics.drawOval(SINGLETON);
	}
}
