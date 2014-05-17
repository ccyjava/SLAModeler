package edu.pku.sei.gmp.controller.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPNode;

public class GMPChangeConstraintCommand extends Command {
	
	private GMPNode node;
	private Point newLocation, oldLocation;
	private int newWidth, oldWidth;
	private int newHeight, oldHeight;

	public GMPChangeConstraintCommand(GMPNode node, Point newLocation,
			int newWidth, int newHeight) {
		super("Change Constraint");
		setNode(node);
		setNewLocation(newLocation);
		this.newWidth = newWidth;
		this.newHeight = newHeight;
	}

	public boolean canExecute() {
		return node != null && newLocation != null
				&& (newWidth == -1 || newWidth > 0)
				&& (newHeight == -1 || newHeight > 0);
	}

	public void execute() {
		Point p = new Point(node.getLocationX(), node.getLocationY());
		oldLocation = p;
		oldWidth = node.getWidth();
		oldHeight = node.getHeight();
		redo();
	}

	public void redo() {
		node.setLocationX(newLocation.x);
		node.setLocationY(newLocation.y);
		node.setWidth(newWidth);
		node.setHeight(newHeight);
	}

	public void setNode(GMPNode node) {
		this.node = node;
	}

	public void setNewLocation(Point loc) {
		newLocation = loc;
	}

	public void undo() {
		node.setWidth(oldWidth);
		node.setHeight(oldHeight);
		node.setLocationX(oldLocation.x);
		node.setLocationY(oldLocation.y);
	}
}
