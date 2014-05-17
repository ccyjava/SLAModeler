package edu.pku.sei.sla.ctrl.command.sla;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAAgreement;

public class SLACreateSLAAgreementCommand extends Command {
	ComputeService cs = null;
	SLAAgreement am = null;

	public SLACreateSLAAgreementCommand(ComputeService cs, SLAAgreement am) {
		super("create slaagreement");
		this.cs = cs;
		this.am = am;
	}

	@Override
	public boolean canExecute() {

		return cs != null && am != null;
	}

	@Override
	public void execute() {
		if (cs != null && am != null) {
			am.setContainer(cs);
			cs.getAgreements().add(am);
		}
	}

	@Override
	public void redo() {
		this.execute();
	}

	@Override
	public void undo() {
		if (cs != null & am != null) {
			cs.getAgreements().remove(am);
			am.setContainer(null);
		}
	}

}
