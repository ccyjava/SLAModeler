package edu.pku.sei.sla.util;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;

import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.controller.figure.SimpleContainerFigure;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.sla.ctrl.editpolicy.ApelXYLayoutEditPolicy;

public class SmartEditPart extends GMPNodeEditPart {
	protected IFigure createFigure() {
		return new SimpleContainerFigure();
	}

	public IFigure getContentPane() {
		if (getFigure() instanceof SimpleContainerFigure) {
			return ((SimpleContainerFigure) getFigure()).getContentPane();
		}
		return super.getContentPane();
	}

	public void handlePropertyChanged(PropertyChangeEvent event) {
		refreshVisuals();
		super.handlePropertyChanged(event);
	}
	
	

	@Override
	protected void createEditPolicies() {

		super.createEditPolicies();

		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ApelXYLayoutEditPolicy());

	}

	protected void refreshVisuals() {
		GMPModelElement element = getModelElement();
		if (figure != null) {
			Label l = (Label) (((SimpleContainerFigure) figure)
					.getCollapsedLabel());
			l.setText(element.getName());
		}
		// ((LinearContainerFigure) figure).setName(modelEle.getName());
		super.refreshVisuals();
	}
}
