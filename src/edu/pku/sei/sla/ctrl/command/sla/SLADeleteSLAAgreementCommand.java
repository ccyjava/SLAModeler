package edu.pku.sei.sla.ctrl.command.sla;

import org.eclipse.gef.commands.Command;

import edu.pku.sei.sla.model.common.SLAModel;
import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAAgreement;

public class SLADeleteSLAAgreementCommand extends Command {
	ComputeService cs = null;
	SLAAgreement am = null;

	public SLADeleteSLAAgreementCommand(SLAAgreement am) {
		super("delete slaagreement");
		this.am = am;

		if (am.getContainer() instanceof ComputeService) {
			cs = (ComputeService) am.getContainer();
		}
	}

	@Override
	public boolean canExecute() {

		return cs != null && am != null;
	}

	@Override
	public void execute() {
		if (cs != null && am != null) {
			am.setContainer(null);
			cs.getAgreements().remove(am);
		}
	}

	@Override
	public void undo() {
		if (cs != null && am != null) {
			am.setContainer(cs);
			cs.getAgreements().add(am);
		}
	}
}
