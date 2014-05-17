package edu.pku.sei.apel.ctrl.command;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;


import edu.pku.sei.apel.ctrl.command.sla.SLACreateComputeServiceCommand;
import edu.pku.sei.apel.ctrl.command.sla.SLACreateSLAAgreementCommand;
import edu.pku.sei.apel.ctrl.command.sla.SLADeleteComputeServiceCommand;
import edu.pku.sei.apel.ctrl.command.sla.SLADeleteSLAAgreementCommand;

import edu.pku.sei.apel.model.common.SLAModel;
import edu.pku.sei.apel.model.sla.ComputeService;
import edu.pku.sei.apel.model.sla.SLAAgreement;
import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCreateRelationCommand;
import edu.pku.sei.gmp.model.concept.GMPModelElement;

public class ApelCommandFactory extends GMPCommandFactory {

	private static ApelCommandFactory instance;

	public static ApelCommandFactory getInstance() {
		if (instance == null) {
			instance = new ApelCommandFactory();
		}
		return instance;
	}

	@Override
	protected Command getCreateRelationCommand(GMPModelElement sourceModel,
			GMPModelElement linkModel) {
		
		return null;
	}

	@Override
	protected boolean buildCompleteRelationCommand(
			GMPCreateRelationCommand cmd, GMPModelElement targetModel) {
		
		return false;
	}

	@Override
	protected Command buildCreateModelElementCommand(GMPModelElement parent,
			GMPModelElement modelElement) {
		
		if (parent instanceof SLAModel) {
			if (modelElement instanceof ComputeService) {
				return new SLACreateComputeServiceCommand((SLAModel) parent,
						(ComputeService) modelElement);
			}

		}
		if (parent instanceof ComputeService) {
			if (modelElement instanceof SLAAgreement) {
				return new SLACreateSLAAgreementCommand(
						(ComputeService) parent, (SLAAgreement) modelElement);
			}
		}
		return null;
	}

	@Override
	protected Command getDeleteDirectModelElementCommand(
			GMPModelElement modelElement) {
		if (modelElement instanceof ComputeService) {
			return new SLADeleteComputeServiceCommand(
					(ComputeService) modelElement);
		} else if (modelElement instanceof SLAAgreement) {
			return new SLADeleteSLAAgreementCommand((SLAAgreement) modelElement);
		}
		return null;
	}

	@Override
	protected void buildDeleteSubModelElementCommand(CompoundCommand cmd,
			GMPModelElement modelElement) {
		 if (modelElement instanceof ComputeService) {
			ComputeService contact = (ComputeService) modelElement;
			for (SLAAgreement slaagreement : contact.getAgreements()) {
				cmd.add(getDeleteCommand(slaagreement));
			}
		}
	}
}
