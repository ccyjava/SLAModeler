package edu.pku.sei.gmp.controller.command;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeContainer;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;

public abstract class GMPCommandFactory {

	/**
	 * This method returns a command that can delete the element and all its
	 * related elements.
	 * <p>
	 * For an object of {@code GMPShapeElement}, the command includes a delete
	 * command for the element itself and the related tuple element. And if the
	 * element is an instance of {@code GMPNode}, it also delete the related
	 * links and their tuples.
	 * <p>
	 * For an object of {@code GMPModelElement}, this method returns a compound
	 * command that can delete the model element itself, all the related shape
	 * elements, and, the related model elements with their shape elements.
	 * 
	 * @param element
	 * @return
	 */
	public Command getDeleteCommand(GMPElement element) {
		if (element instanceof GMPShapeElement) {
			return getDeleteShapeCommand((GMPShapeElement) element);
		} else if (element instanceof GMPModelElement) {
			return getDeleteModelElementCommand((GMPModelElement) element);
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param shape
	 * @return
	 */
	protected Command getDeleteShapeCommand(GMPShapeElement shape) {
		GMPModel model = shape.getModel();
		GMPTupleElement tuple = model.shape2tuple(shape);

		CompoundCommand cmd = new CompoundCommand();

		if (shape instanceof GMPShapeContainer) {
			for (GMPNode node : ((GMPShapeContainer) shape).getSubNodes()) {
				cmd.add(getDeleteCommand(node));
			}
		}

		if (shape instanceof GMPNode) {
			GMPNode node = (GMPNode) shape;
			for (GMPLink link : node.getOutgoings()) {
				cmd.add(getDeleteCommand(link));
			}
			for (GMPLink link : node.getIncomings()) {
				cmd.add(getDeleteCommand(link));
			}
			cmd.add(getDeleteNodeCommand(node));
		} else if (shape instanceof GMPLink) {
			GMPLink link = (GMPLink) shape;
			cmd.add(getDeleteLinkCommand(link));
		} else if (shape instanceof GMPDiagram) {
			GMPDiagram diagram = (GMPDiagram) shape;
			cmd.add(getDeleteDiagramCommand(diagram));
		}

		cmd.add(getDeleteTupleCommand(tuple));

		return cmd;
	}

	protected Command getDeleteDiagramCommand(GMPDiagram diagram) {
		return new GMPDeleteDiagramCommand(diagram);
	}
	
	protected Command getDeleteNodeCommand(GMPNode node) {
		return new GMPDeleteNodeCommand(node);
	}

	protected Command getDeleteLinkCommand(GMPLink link) {
		return new GMPDeleteLinkCommand(link);
	}

	protected Command getDeleteTupleCommand(GMPTupleElement tuple) {
		return new GMPDeleteTupleCommand(tuple);
	}

	/**
	 * Get a compound delete command of the model element. Generally it includes
	 * all the delete commands for its corresponding shape elements, the delete
	 * commands for related model elements(e.g. we have to delete associations
	 * when delete a UML class), and the delete command for model element
	 * itself.
	 * 
	 * @param modelElement
	 * @return
	 */
	protected Command getDeleteModelElementCommand(GMPModelElement modelElement) {
		CompoundCommand cmd = new CompoundCommand();
		buildDeleteSubModelElementCommand(cmd, modelElement);
		buildDeleteRelatedShapeCommands(cmd, modelElement);
		cmd.add(getDeleteDirectModelElementCommand(modelElement));
		return cmd;
	}

	protected abstract Command getDeleteDirectModelElementCommand(
			GMPModelElement modelElement);

	protected abstract void buildDeleteSubModelElementCommand(
			CompoundCommand cmd, GMPModelElement modelElement);

	/**
	 * Get the delete command of all the shapes that associated with the model
	 * element. This method is initially designed to be invoked by {@code
	 * getDeleteModelElementCommand}, which generates the delete command of the
	 * model element and make use of the return value of this method to delete
	 * the corresponding shape elements.
	 * 
	 * @param modelElement
	 * @return
	 */
	protected void buildDeleteRelatedShapeCommands(CompoundCommand cmd,
			GMPModelElement modelElement) {
		GMPModel model = modelElement.getModel();
		List<GMPShapeElement> shapes = model.model2shape(modelElement);
		for (GMPShapeElement shape : shapes) {
			cmd.add(getDeleteCommand(shape));
		}
	}

	public Command getCreateDiagramCommand(GMPDiagram diagram,
			GMPTupleElement tuple) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(getCreateTupleCommand(tuple));
		cmd.add(getCreateDiagramCommand(diagram));
		return cmd;
	}

	public Command getCreateCommand(GMPShapeContainer container,
			GMPModelElement modelElement, GMPNode node, GMPTupleElement tuple,
			Rectangle rect) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(getCreateTupleCommand(tuple));
		cmd.add(getCreateNodeCommand(container, node, rect));
		if (modelElement != null) {
			GMPModel model = modelElement.getModel();
			GMPModelElement parent = model.shape2model(container);
			Command modelCmd = buildCreateModelElementCommand(parent,
					modelElement);
			if (modelCmd == null) {
				return null;
			} else {
				cmd.add(modelCmd);
			}
		}
		return cmd;
	}

	public Command getCreateCommand(GMPShapeContainer container, GMPNode node,
			GMPTupleElement tuple, Rectangle rect) {
		return getCreateCommand(container, null, node, tuple, rect);
	}

	protected abstract Command buildCreateModelElementCommand(
			GMPModelElement parent, GMPModelElement modelElement);

	public Command getCreateConnectionCommand(GMPNode sourceNode,
			GMPModelElement linkModel, GMPLink link, GMPTupleElement tuple) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(getCreateTupleCommand(tuple));
		cmd.add(getCreateLinkCommand(link, sourceNode));
		if (linkModel != null) {
			GMPModel model = sourceNode.getModel();
			GMPModelElement sourceModel = model.shape2model(sourceNode);
			Command relationCmd = getCreateRelationCommand(sourceModel,
					linkModel);
			if (relationCmd == null) {
				return null;
			} else {
				cmd.add(relationCmd);
			}
		}

		return cmd;
	}

	public Command getCompleteConnectionCommand(Command cmd, GMPNode targetNode) {
		if (cmd instanceof CompoundCommand) {
			for (Object c : ((CompoundCommand) cmd).getChildren()) {
				if (c instanceof GMPCreateLinkCommand) {
					((GMPCreateLinkCommand) c).setTarget(targetNode);
				} else if (c instanceof GMPCreateRelationCommand) {
					GMPCreateRelationCommand relationCmd = (GMPCreateRelationCommand) c;
					GMPModelElement targetModel = targetNode.getModel()
							.shape2model(targetNode);
					if (!buildCompleteRelationCommand(relationCmd, targetModel)) {
						return null;
					}
				}
			}
		}
		return cmd;
	}

	protected abstract boolean buildCompleteRelationCommand(
			GMPCreateRelationCommand cmd, GMPModelElement targetModel);

	protected abstract Command getCreateRelationCommand(
			GMPModelElement sourceModel, GMPModelElement linkModel);

	protected Command getCreateTupleCommand(GMPTupleElement tuple) {
		return new GMPCreateTupleCommand(tuple);
	}

	protected Command getCreateDiagramCommand(GMPDiagram diagram) {
		return new GMPCreateDiagramCommand(diagram);
	}

	protected Command getCreateNodeCommand(GMPShapeContainer container,
			GMPNode node, Rectangle rect) {
		return new GMPCreateNodeCommand(node, container, rect);
	}

	protected Command getCreateLinkCommand(GMPLink link, GMPNode sourceNode) {
		return new GMPCreateLinkCommand(link, sourceNode);
	}
	
	public Command getDndCommand(GMPShapeContainer newContainer, GMPNode node,
			Rectangle rect) {
		CompoundCommand cmd = new CompoundCommand();
		cmd.add(new GMPDeleteNodeCommand(node));
		cmd.add(this.getCreateNodeCommand(newContainer, node, rect));
		return cmd;
	}
}
