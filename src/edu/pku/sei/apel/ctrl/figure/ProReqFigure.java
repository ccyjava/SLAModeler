package edu.pku.sei.apel.ctrl.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.swt.SWT;

@Deprecated
public class ProReqFigure extends PolylineConnection {

	public ProReqFigure() {
		super();
	}

	public void paintFigure(Graphics graphics) {
		graphics.pushState();
		graphics.setAntialias(SWT.ON);
		super.paintFigure(graphics);

		graphics.popState();
	}

	public void setEnd(int sourceType, int targetType ) {
		this.setTargetDecoration(null);
		this.setSourceDecoration(null);
	}
	
}
