package edu.pku.sei.gmp.controller.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class GMPCommonFigure extends Figure {
	
	public GMPCommonFigure() {
	}
	
	protected void paintFigure(Graphics g) {
		g.pushState();
		g.setForegroundColor(ColorConstants.white);
		g.fillGradient(getBounds(), true);
		g.popState();
	}
	
	protected void paintShadow(Graphics g) {
		g.pushState();
		Rectangle rect = getBounds().getCopy().translate(2, 2);
		g.setClip(rect);
		g.setBackgroundColor(ColorConstants.buttonDarker);
		g.fillRectangle(rect);
		g.popState();
	}
	
	public void changeColor(Color color){
		this.setBackgroundColor(color);
	}
	
	public void changeLineColor(Color color) {
		if (color != null)
			this.setForegroundColor(color);
	}
}
