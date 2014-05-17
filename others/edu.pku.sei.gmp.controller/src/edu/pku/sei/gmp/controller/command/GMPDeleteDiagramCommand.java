package edu.pku.sei.gmp.controller.command;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class GMPDeleteDiagramCommand extends Command {
	private GMPModel model;
	private GMPDiagram diagram;

	public GMPDeleteDiagramCommand(GMPDiagram diagram) {
		super("Deleta Diagram");
		this.model = diagram.getModel();
		this.diagram = diagram;
	}

	public boolean canExecute() {
		return model != null && diagram != null;
	}

	public void execute() {
		if (model.getDiagrams().contains(diagram)) {
			model.getDiagrams().remove(diagram);
			diagram.setContainer(null);
		}
	}
	
	public void undo() {
		if (!model.getDiagrams().contains(diagram)) {
			model.getDiagrams().add(diagram);
			diagram.setContainer(model);
		}
	}
}
