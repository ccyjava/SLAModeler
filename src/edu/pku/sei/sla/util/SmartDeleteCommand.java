package edu.pku.sei.sla.util;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAAgreement;

public class SmartDeleteCommand extends Command {
	private GMPModelElement parent_element = null;
	private GMPModelElement element = null;

	public SmartDeleteCommand(GMPModelElement am) {
		super("delete slaagreement");
		this.element = am;
		parent_element = (ComputeService) am.getContainer();

	}

	@Override
	public boolean canExecute() {

		return parent_element != null && element != null;
	}

	@Override
	public void execute() {
		if (parent_element != null && element != null) {
			element.setContainer(null);
			if (parent_element instanceof GMPModel) {
				((GMPModel) parent_element).getRootElements().remove(element);
			} else {
				parent_element.getChildren().remove(element);
			}
			System.out.println("Smart Delete Command delete: "
					+ Tools.getnames(parent_element) + " "
					+ Tools.getnames(element));
		}
	}

	@Override
	public void undo() {
		if (parent_element != null) {
			element.setContainer(parent_element);
			if (parent_element instanceof GMPModel) {
				((GMPModel) parent_element).getRootElements().add(element);
			} else {
				parent_element.getChildren().add(element);
			}
		}
	}
}
