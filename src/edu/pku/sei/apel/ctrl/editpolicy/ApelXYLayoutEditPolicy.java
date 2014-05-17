package edu.pku.sei.apel.ctrl.editpolicy;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;


import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.controller.common.GMPEntryCreationObject;
import edu.pku.sei.gmp.controller.editpolicy.GMPXYLayoutEditPolicy;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

/**
 * Provide support for selecting and positioning a non-resizable editpart. 
 * using in {@link edu.pku.sei.apel.ctrl.editpart.bpel.ProcessEditPart}
 * and {@link edu.pku.sei.apel.ctrl.editpart.bpel.CompoundNodeEditPart}
 */
public class ApelXYLayoutEditPolicy extends GMPXYLayoutEditPolicy {
	
	protected EditPolicy createChildEditPolicy(EditPart child) {
		
		return new NonResizableEditPolicy();
	}
	
	@Override
	protected Command getCreateCommand(CreateRequest request) {
		Rectangle constraint = (Rectangle) getConstraintFor(request);
		if(constraint.width <= 0) {
			constraint.width = 100;
		}
		if(constraint.height <= 0) {
			constraint.height = 55;
		}
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
}
