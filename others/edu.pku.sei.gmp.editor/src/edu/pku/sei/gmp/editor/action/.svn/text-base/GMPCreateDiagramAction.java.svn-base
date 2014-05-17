package edu.pku.sei.gmp.editor.action;

import org.eclipse.jface.action.Action;

import edu.pku.sei.gmp.controller.command.GMPCommandFactory;
import edu.pku.sei.gmp.controller.command.GMPCommandFactoryRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.tuple.GMPTupleElement;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPCreateDiagramAction extends Action {
	private String diagramType;

	private Object treeObject;

	private AbstractOpenDiagramAction openDiagramAction;

	public GMPCreateDiagramAction(String diagramType, Object treeObject) {
		super();
		this.diagramType = diagramType;
		this.setText("Create a " + diagramType);
		setToolTipText("Create a " + diagramType);
		this.setImageDescriptor(GMPImageProvider
				.getImageDescriptor(GMPImageProvider.DIAGRAM));
		this.treeObject = treeObject;
	}

	public void setOpenDiagramAction(AbstractOpenDiagramAction action) {
		this.openDiagramAction = action;
	}

	public void run() {
		if (!(treeObject instanceof GMPModelElement)) {
			return;
		}
		GMPModelElement modelElement = (GMPModelElement) treeObject;
		GMPModel model = modelElement.getModel();
		GMPModelFactory modelFactory = model.getModelFactory();
		GMPDiagram diagram = (GMPDiagram) modelFactory
				.createShapeElement(diagramType);
		GMPTupleElement tuple = (GMPTupleElement) modelFactory
				.createTupleElement(modelElement, diagram);
		GMPCommandFactory commandFactory = GMPCommandFactoryRegistry
				.getInstance()
				.getCommandFactory(
						GMPProjectUtils.model2project(model).getProjectNature());
		assert (commandFactory != null);
		model.getCommandStack().execute(
				commandFactory.getCreateDiagramCommand(diagram, tuple));

		if (openDiagramAction != null) {
			openDiagramAction.setTreeObject(diagram);
			openDiagramAction.run();
		}
	}
}
