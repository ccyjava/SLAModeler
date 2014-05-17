package edu.pku.sei.gmp.controller.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;

import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {
	@Override
	protected Command getConnectionCompleteCommand(
			CreateConnectionRequest request) {
		CompoundCommand cmd = (CompoundCommand) request.getStartCommand();
		GMPNode targetNode = (GMPNode) getHost().getModel();

		GMPModel model = targetNode.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);

		Command completeCmd = commandFactory.getCompleteConnectionCommand(cmd,
				targetNode);
		return completeCmd;
	}

	@Override
	protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
		GMPEntryCreationObject newObj = (GMPEntryCreationObject) request
				.getNewObject();
		GMPLink link = (GMPLink) newObj.getShapeElement();
		GMPTupleElement tuple = newObj.getTupleElement();
		GMPNode sourceNode = (GMPNode) getHost().getModel();
		GMPModelElement linkModel = null;
		if (!newObj.isShapeOnly()) {
			linkModel = newObj.getModelElement();
		}

		GMPModel model = sourceNode.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);

		Command startCmd = commandFactory.getCreateConnectionCommand(
				sourceNode, linkModel, link, tuple);
		request.setStartCommand(startCmd);
		return startCmd;
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

}
