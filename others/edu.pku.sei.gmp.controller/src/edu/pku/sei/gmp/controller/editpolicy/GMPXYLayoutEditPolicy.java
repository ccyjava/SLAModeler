package edu.pku.sei.gmp.controller.editpolicy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;

import edu.pku.sei.gmp.controller.command.GMPChangeConstraintCommand;
import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		Rectangle bounds = (Rectangle) constraint;
		return new GMPChangeConstraintCommand((GMPNode) child.getModel(), bounds
				.getLocation(), bounds.width, bounds.height);
	}

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Rectangle constraint = (Rectangle) getConstraintFor(request);
		GMPEntryCreationObject newObj = (GMPEntryCreationObject) request
				.getNewObject();
		GMPNode node = (GMPNode) newObj.getShapeElement();
		GMPShapeContainer container = (GMPShapeContainer) getHost().getModel();
		
		GMPModel model = node.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);
		
		
		if (node instanceof GMPNode) {
			if (newObj.isShapeOnly()) {
				return commandFactory.getCreateCommand(container, node, newObj
						.getTupleElement(), constraint);
			} else {
				return commandFactory.getCreateCommand(container, newObj
						.getModelElement(), node, newObj.getTupleElement(),
						constraint);
			}
		} else {
			return null;
		}
	}
	
	@Override
	protected Command createAddCommand(EditPart child, Object constraint) {
		System.out.println(child.getModel() + ":" + constraint);
		
		GMPNode node = (GMPNode) child.getModel();
		GMPShapeContainer container = (GMPShapeContainer) getHost().getModel();
		Rectangle bounds = (Rectangle) constraint;
		GMPModel model = node.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);
		Command cmd = commandFactory.getDndCommand(container, node, bounds);
		
		return cmd;
	}

	
	protected Command getAddCommand(Request generic) {
		return super.getAddCommand(generic);
	}
	
	@Override
	protected Command getOrphanChildrenCommand(Request request) {
		return UnexecutableCommand.INSTANCE;
	}
}
