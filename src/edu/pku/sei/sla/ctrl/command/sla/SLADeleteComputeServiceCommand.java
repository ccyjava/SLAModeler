package edu.pku.sei.sla.ctrl.command.sla;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAModel;

public class SLADeleteComputeServiceCommand extends Command {
	private SLAModel model = null;
	private ComputeService cs = null;

	public SLADeleteComputeServiceCommand(ComputeService modelElement) {
		super("Delete CoputeService");
		this.cs = modelElement;
		if (modelElement.getContainer() instanceof SLAModel) {
			model = (SLAModel) modelElement.getContainer();
		}
	}

	public boolean canExecute() {
		return model != null && cs != null;
	}

	public void execute() {
		if (model != null) {
			cs.setContainer(null);
			model.getRootElements().remove(cs);
		}
	}

	public void undo() {
		if (model != null) {
			cs.setContainer(model);
			model.getRootElements().add(cs);
		}
	}

}
