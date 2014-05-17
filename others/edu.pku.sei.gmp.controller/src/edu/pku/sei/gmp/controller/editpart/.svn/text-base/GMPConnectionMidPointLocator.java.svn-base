package edu.pku.sei.gmp.controller.editpart;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;

public class GMPConnectionMidPointLocator extends ConnectionLocator {
	private int index;
	
	public GMPConnectionMidPointLocator(Connection c) {
		super(c);
		index = 0;
	}
	
	/**
	 * 计算connection的中点，作为该connectionLocator的index
	 */
	protected void calculateIndex(){
		Connection targetConnection = this.getConnection();
		PointList points = targetConnection.getPoints();
		int endIndex = points.size()-1;
		index = (endIndex-0)/2;
	}

	/**
	 * Returns this GMPConnectionMidPointLocator's index. 
	 * This integer represents the position of the start 
	 * point in this ConnectionMidPointLocator's associated 
	 * {@link Connection} from where midpoint calculation will be made.
	 * 
	 * @return the locator's index  
	 */
	protected int getIndex() {
		calculateIndex();
		return index;
	}

	/**
	 * Returns the point of reference associated with this locator. 
	 * This point will be midway between points at 'index' and 'index' + 1.
	 * 
	 * @return the reference point
	 */
	protected Point getReferencePoint() {
		Connection conn = getConnection();
		Point p = Point.SINGLETON;
		PointList l = conn.getPoints();
		if((l.size()/2*2)-l.size() !=0 ){
			p = l.getMidpoint();
		}
		else{
		Point p1 = conn.getPoints().getPoint(getIndex());
		Point p2 = conn.getPoints().getPoint(getIndex() + 1);
		conn.translateToAbsolute(p1);
		conn.translateToAbsolute(p2);
		p.x = (p2.x - p1.x) / 2 + p1.x;
		p.y = (p2.y - p1.y) / 2 + p1.y;
		}
		return p;
	}
}
