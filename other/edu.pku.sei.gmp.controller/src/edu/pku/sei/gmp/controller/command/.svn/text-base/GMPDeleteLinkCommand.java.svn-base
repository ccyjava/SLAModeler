package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPNode;

public class GMPDeleteLinkCommand extends Command {
	private GMPNode sourceNode;
	private GMPNode targetNode;
	private GMPLink link;

	public GMPDeleteLinkCommand(GMPLink link) {
		super("Delete Link");
		this.link = link;
		this.sourceNode = link.getSource();
		this.targetNode = link.getTarget();
	}

	public boolean canExecute() {
		return sourceNode != null && targetNode != null && link != null;
	}

	public void execute() {
		if (sourceNode.getOutgoings().contains(link)
				&& targetNode.getIncomings().contains(link)) {
			sourceNode.getOutgoings().remove(link);
			targetNode.getIncomings().remove(link);
			link.setSource(null);
			link.setTarget(null);
			link.setContainer(null);
		}
	}

	public void undo() {
		if ((!sourceNode.getOutgoings().contains(link))
				&& (!targetNode.getIncomings().contains(link))) {
			sourceNode.getOutgoings().add(link);
			targetNode.getIncomings().add(link);
			link.setSource(sourceNode);
			link.setTarget(targetNode);
			link.setContainer(sourceNode);
		}
	}
}
