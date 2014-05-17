package edu.pku.sei.gmp.model.shape;

import org.eclipse.draw2d.Bendpoint;
import org.eclipse.draw2d.geometry.Point;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;

public class GMPBendpoint extends GMPShapeElement implements Bendpoint {
	@GMPAnnotation(
			id = "GMPBendpoint.x",
			name = GMPConst.BENDPOINT_X,
			getter = "getX",
			setter = "setX")
	public int x;
	
	@GMPAnnotation(
			id = "GMPBendpoint.y",
			name = GMPConst.BENDPOINT_Y,
			getter = "getY",
			setter = "setY")
	public int y;

	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public GMPBendpoint(){
		super();
	}
	
	public GMPBendpoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public Point getLocation() {
		return new Point(x, y);
	}

}
