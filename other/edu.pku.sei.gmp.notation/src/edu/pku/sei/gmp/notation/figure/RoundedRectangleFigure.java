package edu.pku.sei.gmp.notation.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class RoundedRectangleFigure extends AbstractNotationFigure {

	protected int cornerWidth;
	protected int cornerHeight;

	protected Rectangle SINGLETON = new Rectangle();

	protected void fillShape(Graphics graphics) {
		if (getLocalBackgroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		SINGLETON.setLocation(size.x, size.y);
		SINGLETON.setSize(size.width, size.height);
		SINGLETON.height -= lineWidth;
		SINGLETON.width -= lineWidth;
		graphics.fillRoundRectangle(SINGLETON, cornerWidth, cornerHeight);

	}

	protected void outlineShape(Graphics graphics) {
		if (getLocalForegroundColor() == null)
			return;
		Rectangle size = this.getBounds();
		SINGLETON.setLocation(size.x, size.y);
		SINGLETON.setSize(size.width, size.height);
		SINGLETON.height -= lineWidth;
		SINGLETON.width -= lineWidth;
		graphics.drawRoundRectangle(SINGLETON, cornerWidth, cornerHeight);
	}

	public int getCornerWidth() {
		return cornerWidth;
	}

	public void setCornerWidth(int cornerWidth) {
		this.cornerWidth = cornerWidth;
	}

	public int getCornerHeight() {
		return cornerHeight;
	}

	public void setCornerHeight(int cornerHeight) {
		this.cornerHeight = cornerHeight;
	}
}
