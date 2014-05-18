package edu.pku.sei.sla.ctrl.editpart;

import org.eclipse.gef.EditPart;



import edu.pku.sei.gmp.controller.editpart.GMPDiagramEditPart;
import edu.pku.sei.gmp.controller.editpart.GMPEditPartFactory;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.sla.ctrl.editpart.sla.ComputeServiceEditPart;
import edu.pku.sei.sla.ctrl.editpart.sla.SLAAgreementEditPart;
import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAAgreement;
import edu.pku.sei.sla.model.sla.SLAModel;
import edu.pku.sei.sla.model.sla.SLAModelElement;

public class SLAEditPartFactory extends GMPEditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {

		EditPart part = null;
		if (model instanceof GMPDiagram)
			part = new GMPDiagramEditPart((GMPDiagram) model);
		else if (model instanceof GMPShapeElement)
			part = createShapeEditPart((GMPShapeElement) model);
		if (part != null) {
			part.setModel(model);
			return part;
		} else {
			return super.createEditPart(context, model);
		}
	}

	@Override
	public EditPart createShapeEditPart(GMPShapeElement model) {
		SLAModel m = (SLAModel) model.getModel();
		SLAModelElement mElement = (SLAModelElement) m.shape2model(model);
		if (mElement instanceof ComputeService) {
			return new ComputeServiceEditPart();
		} else if (mElement instanceof SLAAgreement) {
			return new SLAAgreementEditPart();
		} else {

			return super.createShapeEditPart(model);
		}
	}

}
