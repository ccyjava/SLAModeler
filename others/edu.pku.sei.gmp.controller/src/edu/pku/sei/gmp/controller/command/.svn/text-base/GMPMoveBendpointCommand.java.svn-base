package edu.pku.sei.gmp.controller.command;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.shape.GMPBendpoint;
import edu.pku.sei.gmp.model.shape.GMPLink;

public class GMPMoveBendpointCommand extends Command {
	
	private GMPLink link;
	private int index;
	private GMPBendpoint oldBendpoint, newBendpoint;

	public GMPMoveBendpointCommand(GMPLink link, Point location, int index) {
		super("Move Bendpoint");
		this.link = link;
		this.index = index;
		try {
			newBendpoint = new GMPBendpoint();
			newBendpoint.setModel(link.getModel().getModel());
			newBendpoint.x = location.x;
			newBendpoint.y = location.y;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		oldBendpoint = (GMPBendpoint) link.getBendpoints().get(index);
	}

	public boolean canExecute() {
		return link != null && index >= 0 && newBendpoint != null
				&& oldBendpoint != null;
	}

	public void execute() {
		link.getBendpoints().set(index, newBendpoint);
		newBendpoint.setContainer(link);
		oldBendpoint.setContainer(link);
	}

	public void undo() {
		link.getBendpoints().set(index, oldBendpoint);
		oldBendpoint.setContainer(link);
		newBendpoint.setContainer(null);
	}
	
	public void redo(){
		this.execute();
	}
}
