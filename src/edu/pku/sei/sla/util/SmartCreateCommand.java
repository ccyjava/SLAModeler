package edu.pku.sei.sla.util;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAModel;

public class SmartCreateCommand extends Command {
	private GMPModelElement parent_element = null;
	private GMPModelElement element = null;

	public SmartCreateCommand(GMPModelElement model, GMPModelElement element) {
		super("create " + Tools.getnames(element));
		this.parent_element = model;
		this.element = element;
	}

	public boolean canExecute() {
		return parent_element != null && element != null;
	}

	public void execute() {
		if (parent_element != null) {
			if (parent_element instanceof GMPModel) {
				element.setContainer(parent_element);
				((GMPModel) parent_element).getRootElements().add(element);
			} else {
				element.setContainer(parent_element);
				parent_element.getChildren().add(element);
			}
			System.out.println("SmartCreateCommand create: "
					+ Tools.getnames(parent_element) + " "
					+ Tools.getnames(element));
		}
	}

	public void undo() {
		if (parent_element != null && element != null) {
			if (parent_element instanceof GMPModel) {
				((GMPModel) parent_element).getRootElements().remove(element);
			} else {
				parent_element.getChildren().remove(element);
			}
			element.setContainer(null);
		}

	}

	public void redo() {
		this.execute();
	}
}
