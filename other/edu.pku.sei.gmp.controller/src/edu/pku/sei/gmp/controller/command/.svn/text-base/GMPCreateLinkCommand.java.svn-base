package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPNode;

public class GMPCreateLinkCommand extends Command {
	private GMPNode sourceNode;
	private GMPNode targetNode;
	private GMPLink link;

	public GMPCreateLinkCommand(GMPLink link,
			GMPNode sourceNode) {
		super("Create Link");
		this.link = link;
		this.sourceNode = sourceNode;
	}

	public void setTarget(GMPNode targetNode) {
		this.targetNode = targetNode;
	}

	public boolean canExecute(){
		return sourceNode != null && targetNode != null && link != null;
	}
	
	public void execute() {
		sourceNode.getOutgoings().add(link);
		targetNode.getIncomings().add(link);
		link.setContainer(sourceNode);
		link.setSource(sourceNode);
		link.setTarget(targetNode);
	}

	public void undo() {
		link.setContainer(null);
		link.setSource(null);
		link.setTarget(null);
		sourceNode.getOutgoings().remove(link);
		targetNode.getIncomings().remove(link);
	}
}
