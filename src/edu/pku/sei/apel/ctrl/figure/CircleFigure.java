package edu.pku.sei.apel.ctrl.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Rectangle;

import edu.pku.sei.gmp.notation.layout.MultiLayout;

public class CircleFigure extends Shape {

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

	public void setLayoutManager(LayoutManager manager) {
		LayoutManager lay = this.getLayoutManager();

		if (lay != null) {
			if (lay instanceof MultiLayout) {
				((MultiLayout) lay).addLayout(manager);
				revalidate();
			} else {
				MultiLayout mlay = new MultiLayout();
				mlay.addLayout(lay);
				mlay.addLayout(manager);
				super.setLayoutManager(mlay);
			}
		} else
			super.setLayoutManager(manager);
	}

	public void setConstraint(IFigure child, Object constraint) {
		super.setConstraint(child, constraint);
	}
}
