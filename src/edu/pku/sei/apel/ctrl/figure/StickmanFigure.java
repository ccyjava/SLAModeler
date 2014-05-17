package edu.pku.sei.apel.ctrl.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

@Deprecated
public class StickmanFigure extends Shape {
	
	public static final org.eclipse.swt.graphics.Color ACTOR_COLOR = ColorConstants.lightBlue;
	protected static final int ACTOR_THICKNESS = 1;
	
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setAntialias(SWT.ON);
		Rectangle actorArea = getBounds();
		
		int height = actorArea.height;
		int width = actorArea.width;			
		
		// Calculate points 
		Point rightArm = new Point(actorArea.getBottomRight().x,(int)(actorArea.y + 5*height/12));
		Point leftArm = new Point(actorArea.getBottomLeft().x,(int)(actorArea.y + 5*height/12));
		
		Point middleLeg = new Point((int)(actorArea.x + width/2),(int)(actorArea.y + 2*height/3));
		Point rightLeg = actorArea.getBottomRight();
		Point leftLeg = actorArea.getBottomLeft();
		
		Point neck = new Point((int)(actorArea.x + width/2),(int)(actorArea.y + height/3));
		Point positionHead = new Point((int)(actorArea.x + width/4),actorArea.getTop().y);
		
		// Draw body and head
		graphics.setLineWidth(ACTOR_THICKNESS);
		graphics.setForegroundColor(ACTOR_COLOR);
		graphics.drawLine(rightArm, leftArm);
		graphics.drawLine(middleLeg, rightLeg);
		graphics.drawLine(middleLeg, leftLeg);
		graphics.drawLine(middleLeg, neck);
		
		graphics.drawOval(positionHead.x, positionHead.y, width/2, height/3);
		graphics.popState();

	}

	protected void outlineShape(Graphics graphics) {

	}

}
