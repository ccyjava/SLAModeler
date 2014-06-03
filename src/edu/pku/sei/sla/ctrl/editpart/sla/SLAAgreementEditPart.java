package edu.pku.sei.sla.ctrl.editpart.sla;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;

import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.controller.figure.BasicViewFigure;
import edu.pku.sei.gmp.controller.figure.SimpleContainerFigure;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.sla.ctrl.editpolicy.ApelXYLayoutEditPolicy;
import edu.pku.sei.sla.model.sla.SLAAgreement;

public class SLAAgreementEditPart extends GMPNodeEditPart {

	@Override
	protected IFigure createFigure() {
		return new SimpleContainerFigure();
//		return new BasicViewFigure(new Label("SLAAgreement"));
	}

	@Override
	public void handlePropertyChanged(PropertyChangeEvent event) {
		refreshVisuals();
		super.handlePropertyChanged(event);
	}

	@Override
	public IFigure getContentPane() {
		if (getFigure() instanceof SimpleContainerFigure) {
			return ((SimpleContainerFigure) getFigure()).getContentPane();
		}
		return super.getContentPane();
	}

	@Override
	protected void createEditPolicies() {

		super.createEditPolicies();

		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ApelXYLayoutEditPolicy());

	}

	@Override
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

	private SLAAgreement getSLAAgreement() {
		return (SLAAgreement) getModelElement();

	}
}
