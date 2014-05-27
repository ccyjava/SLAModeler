package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPBendpoint;
import edu.pku.sei.gmp.model.shape.GMPLink;

public class GMPAddBendpointCommand extends Command {

	private GMPLink link;
	private GMPBendpoint point;
	private int index = -1;

	public GMPAddBendpointCommand(GMPLink link, GMPBendpoint bendpoint,
			int index) {
		super("Add Bendpoint");
		this.link = link;
		this.point = bendpoint;
		this.index = index;
	}

	public boolean canExecute() {
		return link != null && point != null;
	}

	public void execute() {
		link.getBendpoints().add(index, point);
		point.setContainer(link);
	}

	public void undo() {
		link.getBendpoints().remove(index);
		point.setContainer(null);
	}

	public void redo() {
		this.execute();
	}
}
