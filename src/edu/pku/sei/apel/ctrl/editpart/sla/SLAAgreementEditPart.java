package edu.pku.sei.apel.ctrl.editpart.sla;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;

import edu.pku.sei.apel.ctrl.editpolicy.ApelXYLayoutEditPolicy;
import edu.pku.sei.apel.model.sla.SLAAgreement;
import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.controller.figure.BasicViewFigure;

public class SLAAgreementEditPart extends GMPNodeEditPart {
	protected IFigure createFigure() {
		return new BasicViewFigure(new Label("SLAAgreement"));
	}

	public void handlePropertyChanged(PropertyChangeEvent event) {
		refreshVisuals();
		super.handlePropertyChanged(event);
	}
	protected void createEditPolicies() {
		
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ApelXYLayoutEditPolicy());
		
	}
	protected void refreshVisuals() {
		SLAAgreement am = getSLAAgreement();
		// ((LinearContainerFigure) figure).setName(modelEle.getName());
		super.refreshVisuals();
	}

	private SLAAgreement getSLAAgreement() {
		return (SLAAgreement) getModelElement();

	}
}
