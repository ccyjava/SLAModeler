package edu.pku.sei.apel.ctrl.command.sla;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.apel.model.common.SLAModel;
import edu.pku.sei.apel.model.sla.ComputeService;

public class SLACreateComputeServiceCommand extends Command {
	private SLAModel model = null;
	private ComputeService cs = null;

	public SLACreateComputeServiceCommand(SLAModel model, ComputeService cs) {
		super("create computeservice");
		this.model = model;
		this.cs = cs;
	}

	public boolean canExecute() {
		return model != null && cs != null;
	}

	public void execute() {
		if (model != null) {
			cs.setContainer(model);
			model.getRootElements().add(cs);
		}
	}

	public void undo() {
		if (model != null) {
			model.getRootElements().remove(cs);
		}
		cs.setContainer(null);
	}

	public void redo() {
		this.execute();
	}
}