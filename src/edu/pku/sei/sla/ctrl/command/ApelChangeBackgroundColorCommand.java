package edu.pku.sei.sla.ctrl.command;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.graphics.Color;

import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.model.shape.GMPNode;

public class ApelChangeBackgroundColorCommand extends Command {
	private List<GMPNodeEditPart> editparts;
	private Color nc;
	private HashMap<GMPNodeEditPart,Color> ocs = new HashMap<GMPNodeEditPart,Color>();
	
	public ApelChangeBackgroundColorCommand(List<GMPNodeEditPart> editparts,Color nc){
		super("Change Background Color");
		this.editparts = editparts;
		this.nc = nc;
	}
	public boolean canExecute() {
		return editparts != null && nc != null;
	}

	public void execute() {
		Iterator<GMPNodeEditPart> it = editparts.iterator();
		GMPNode node;
		GMPNodeEditPart part;
		while(it.hasNext()) {
			part = it.next();
			node = (GMPNode) part.getModel();
			ocs.put(part, node.getColor());
			node.setColor(nc);
		}
	}

	public void undo() {
		Iterator<GMPNodeEditPart> it = editparts.iterator();
		GMPNode node;
		GMPNodeEditPart part;
		while(it.hasNext()) {
			part = it.next();
			node = (GMPNode) part.getModel();
			node.setColor(ocs.get(part));
		}
	}
}
