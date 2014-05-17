package edu.pku.sei.gmp.model.shape;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;
import org.w3c.dom.Element;

import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.util.GMPTypedList;
import edu.pku.sei.gmp.properties.annotation.GMPAnnotation;
import edu.pku.sei.gmp.resource.GMPResourceGroupManager;

public class GMPNode extends GMPShapeContainer {
	@GMPAnnotation(
			id = "GMPNode.locationX", 
			name = GMPConst.NODE_LOCATIONX, 
			getter = "getLocationX", 
			setter = "setLocationX"
			)
	private int locationX;

	@GMPAnnotation(
			id = "GMPNode.locationY", 
			name = GMPConst.NODE_LOCATIONY, 
			getter = "getLocationY", 
			setter = "setLocationY"
			)
	private int locationY;

	@GMPAnnotation(
			id = "GMPNode.width", 
			name = GMPConst.NODE_WIDTH, 
			getter = "getWidth", 
			setter = "setWidth"
			)
	private int width;

	@GMPAnnotation(
			id = "GMPNode.height", 
			name = GMPConst.NODE_HEIGHT, 
			getter = "getHeight", 
			setter = "setHeight"
			)
	private int height;

	@GMPAnnotation(
			id = "GMPNode.incomings", 
			name = GMPConst.NODE_INCOMINGS, 
			getter = "getIncomings", 
			reference = true
			)
	private GMPTypedList<GMPLink> incomings = new GMPTypedList<GMPLink>(
			GMPConst.NODE_INCOMINGS, GMPTypedList.BAG, this, GMPLink.class,
			false);

	@GMPAnnotation(
			id = "GMPNode.outgoings", 
			name = GMPConst.NODE_OUTGOINGS, 
			getter = "getOutgoings"
			)
	private GMPTypedList<GMPLink> outgoings = new GMPTypedList<GMPLink>(
			GMPConst.NODE_OUTGOINGS, GMPTypedList.BAG, this, GMPLink.class,
			true);

	@GMPAnnotation(
			id = "GMPNode.color", 
			name = GMPConst.NODE_COLOR, 
			getter = "getColor", 
			setter = "setColor"
			)
	private Color color = ColorConstants.white;

	@GMPAnnotation(
			id = "GMPNode.lineColor", 
			name = GMPConst.NODE_LINECOLOR, 
			getter = "getLineColor", 
			setter = "setLineColor"
			)
	private Color lineColor = ColorConstants.black;

	public int getLocationX() {
		return locationX;
	}

	public void setLocationX(int locationX) {
		this.locationX = locationX;
	}

	public int getLocationY() {
		return locationY;
	}

	public void setLocationY(int locationY) {
		this.locationY = locationY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public GMPTypedList<GMPLink> getIncomings() {
		return incomings;
	}

	public GMPTypedList<GMPLink> getOutgoings() {
		return outgoings;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public void serialize(Element root) {
		super.serialize(root);
		this.getModel().getXMLUtils(this).serializeAttribute(
						root,GMPConst.NODE_COLOR,
						color.getRed() + "," + color.getGreen() + "," + color.getBlue());
		this.getModel().getXMLUtils(this).serializeAttribute(
				root,GMPConst.NODE_LINECOLOR,
				lineColor.getRed() + "," + lineColor.getGreen() + "," + lineColor.getBlue());
	}
	
	public void deSerialize(Element root){
		super.deSerialize(root);
		String c = this.getModel().getXMLUtils(this).deSerializeString(root, GMPConst.NODE_COLOR);
		if (c != null && !c.equals("")) {
			int first = c.indexOf(",");
			int second = c.indexOf(",", first+1);
			int r = Integer.parseInt(c.substring(0, first));
			int g = Integer.parseInt(c.substring(first+1, second));
			int b = Integer.parseInt(c.substring(second+1));
			this.setColor(GMPResourceGroupManager.getSWTColor(r,g,b));
		}
		c = this.getModel().getXMLUtils(this).deSerializeString(root, GMPConst.NODE_LINECOLOR);
		if (c != null && !c.equals("")) {
			int first = c.indexOf(",");
			int second = c.indexOf(",", first+1);
			int r = Integer.parseInt(c.substring(0, first));
			int g = Integer.parseInt(c.substring(first+1, second));
			int b = Integer.parseInt(c.substring(second+1));
			this.setLineColor(GMPResourceGroupManager.getSWTColor(r,g,b));
		}
	}
}
