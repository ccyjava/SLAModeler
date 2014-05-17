package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;

public class GMPDeleteNodeCommand extends Command {
	private GMPNode node;
	private GMPShapeContainer container;

	public GMPDeleteNodeCommand(GMPNode node) {
		super("Delete Node");
		this.node = node;
		container = (GMPShapeContainer) node.getContainer();
	}

	public boolean canExecute() {
		return node != null && container != null;
	}

	public void execute() {
		if (container.getSubNodes().contains(node)) {
			container.getSubNodes().remove(node);
			node.setContainer(null);
		}
	}

	public void undo() {
		if (!container.getSubNodes().contains(node)) {
			container.getSubNodes().add(node);
			node.setContainer(container);
		}
	}
}
