package edu.pku.sei.gmp.controller.editpolicy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPComponentEditPolicy extends ComponentEditPolicy {

	@Override
	protected Command createDeleteCommand(GroupRequest deleteRequest) {
		GMPNode node = (GMPNode) getHost().getModel();
		GMPModel model = node.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);
		if (commandFactory == null) {
			return null;
		} else {
			return commandFactory.getDeleteCommand(node);
		}
	}
}
