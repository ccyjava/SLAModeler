package edu.pku.sei.gmp.controller.command;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;

public class GMPCreateNodeCommand extends Command {
	
	protected Rectangle constraint;
	protected GMPNode node;
	protected GMPShapeContainer container;

	public GMPCreateNodeCommand(GMPNode node, GMPShapeContainer container,
			Rectangle constraint) {
		super("Create Node");
		this.node = node;
		this.container = container;
		this.constraint = constraint;
		this.node.setLocationX(constraint.getLocation().x);
		this.node.setLocationY(constraint.getLocation().y);
		this.node.setWidth(constraint.width);
		this.node.setHeight(constraint.height);
	}

	public boolean canExecute() {
		return node != null && container != null && constraint != null;
	}

	public void execute() {
		container.getSubNodes().add(node);
		node.setContainer(container);
	}
	
	public void undo() {
		container.getSubNodes().remove(node);
		node.setContainer(null);
	}
}
