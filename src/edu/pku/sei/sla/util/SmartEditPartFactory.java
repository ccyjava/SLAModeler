package edu.pku.sei.sla.util;

import org.eclipse.gef.EditPart;

import edu.pku.sei.gmp.controller.editpart.GMPDiagramEditPart;
import edu.pku.sei.gmp.controller.editpart.GMPEditPartFactory;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.sla.ctrl.editpart.sla.ComputeServiceEditPart;
import edu.pku.sei.sla.ctrl.editpart.sla.SLAAgreementEditPart;
import edu.pku.sei.sla.model.sla.ComputeService;
import edu.pku.sei.sla.model.sla.SLAAgreement;
import edu.pku.sei.sla.model.sla.SLAModel;
import edu.pku.sei.sla.model.sla.SLAModelElement;

public class SmartEditPartFactory extends GMPEditPartFactory {
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
		GMPModel m = model.getModel();
		GMPModelElement mElement = m.shape2model(model);
		String ElementName = Tools.getnames(mElement);
		EditPart editpart = null;
		if (!ElementName.equals("")) {
			try {
				String prefix = SmartInfoCenter.getInstance().getPkg_prefix();
				String model_name = SmartInfoCenter.getInstance()
						.getPkg_model_name();
				if (!prefix.equals("")) {
					String pkg_name = prefix + ".ctrl.editpart." + model_name;
					editpart = (EditPart) Class.forName(
							pkg_name + "." + ElementName + "EditPart")
							.newInstance();
					System.out.println("SmartEditPartFactory create :"
							+ pkg_name + "." + ElementName + "EditPart");
				}
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		if (editpart != null)
			return editpart;

		System.out.println("create smart EditPart");
		return new SmartEditPart();

	}
}
