package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPBendpoint;
import edu.pku.sei.gmp.model.shape.GMPLink;

public class GMPDeleteBendpointCommand extends Command {
	
	private GMPLink link;
	private GMPBendpoint bendpoint;
	private int index;

	public GMPDeleteBendpointCommand(GMPLink link, int index) {
		super("Delete Bendpoint");
		this.link = link;
		this.index = index;
		bendpoint = (GMPBendpoint) link.getBendpoints().get(index);
	}

	public boolean canExecute() {
		return index >= 0 && bendpoint != null && link != null;
	}

	public void execute() {
		link.getBendpoints().remove(index);
		bendpoint.setContainer(null);
	}

	public void undo() {
		link.getBendpoints().add(index, bendpoint);
		bendpoint.setContainer(link);
	}
	
	public void redo(){
		this.execute();
	}
}
