package edu.pku.sei.gmp.controller.editpart;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;

import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;

public class GMPEditPartFactory implements EditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		EditPart part = null;
		if (model instanceof GMPDiagram)
			part = new GMPDiagramEditPart((GMPDiagram) model);
		else if (model instanceof GMPShapeElement)
			part = createShapeEditPart((GMPShapeElement) model);
		if (part != null)
			part.setModel(model);
		return part;
	}

	public EditPart createShapeEditPart(GMPShapeElement model) {
		if(model instanceof GMPNode)
			return new GMPNodeEditPart();
		if(model instanceof GMPLink)
			return new GMPLinkEditPart();
		return null;
	}
}
