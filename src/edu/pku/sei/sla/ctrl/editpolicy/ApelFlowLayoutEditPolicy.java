package edu.pku.sei.sla.ctrl.editpolicy;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.FlowLayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;

import edu.pku.sei.gmp.controller.command.GMPChangeConstraintCommand;
import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.controller.command.GMPCreateNodeCommand;
import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class ApelFlowLayoutEditPolicy extends FlowLayoutEditPolicy {

	protected Command createAddCommand(EditPart child, EditPart after) {
		GMPNode childModel = (GMPNode) child.getModel();
		GMPShapeContainer container = (GMPShapeContainer) getHost().getModel();
		int index = getHost().getChildren().indexOf(after);
		Rectangle constraint = new Rectangle(childModel.getWidth(), childModel
				.getHeight(), childModel.getLocationX(), childModel
				.getLocationY());
		return null;
	}

	protected EditPolicy createChildEditPolicy(EditPart child) {

		return new NonResizableEditPolicy();
	}

	protected Command createMoveChildCommand(EditPart child, EditPart after) {
		GMPNode childModel = (GMPNode) child.getModel();
		GMPShapeContainer parentModel = (GMPShapeContainer) getHost()
				.getModel();
		List<?> children = getHost().getChildren();
		int oldIndex = children.indexOf(child);
		int newIndex;
		if (after == null)
			newIndex = children.size();
		else
			newIndex = children.indexOf(after);
		if (newIndex > oldIndex)
			newIndex--;

		return null;
		
	}

	protected Command getCreateCommand(CreateRequest request) {

		EditPart after = getInsertionReference(request);
		int index = getHost().getChildren().indexOf(after);
		GMPEntryCreationObject newObj = (GMPEntryCreationObject) request
				.getNewObject();
		GMPNode node = (GMPNode) newObj.getShapeElement();
		Rectangle constraint = new Rectangle(node.getLocationX(), node
				.getLocationY(), node.getWidth(), node.getHeight());
		if (constraint.width <= 0) {
			constraint.width = 100;
		}
		if (constraint.height <= 0) {
			constraint.height = 55;
		}
		GMPShapeContainer container = (GMPShapeContainer) getHost().getModel();

		GMPModel model = node.getModel();
		String projectNature = GMPProjectUtils.model2project(model)
				.getProjectNature();
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance().getCommandFactory(projectNature);

		CompoundCommand cmd = (CompoundCommand) commandFactory
				.getCreateCommand(container, newObj.getModelElement(), node,
						newObj.getTupleElement(), constraint);
		for (Object c : ((CompoundCommand) cmd).getChildren()) {
			
		}
		return cmd;
	}

	public Command getCommand(Request request) {
		if (REQ_RESIZE_CHILDREN.equals(request.getType())) {
			GMPNode boundsElement = (GMPNode) ((AbstractGraphicalEditPart) ((ChangeBoundsRequest) request)
					.getEditParts().get(0)).getModel();
			int height = boundsElement.getHeight()
					+ ((ChangeBoundsRequest) request).getSizeDelta().height;
			int width = boundsElement.getWidth()
					+ ((ChangeBoundsRequest) request).getSizeDelta().width;
			Point p = new Point(boundsElement.getLocationX(), boundsElement
					.getLocationY());
			return new GMPChangeConstraintCommand(boundsElement, p, width,
					height);
		}
		return super.getCommand(request);
	}
}
