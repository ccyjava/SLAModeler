package edu.pku.sei.sla.ctrl.editpart.sla;

import java.beans.PropertyChangeEvent;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;


import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.controller.editpolicy.GMPXYLayoutEditPolicy;
import edu.pku.sei.gmp.controller.figure.LinearContainerFigure;
import edu.pku.sei.gmp.controller.figure.SimpleContainerFigure;
import edu.pku.sei.gmp.resource.font.GMPFontProvider;
import edu.pku.sei.sla.ctrl.editpolicy.ApelXYLayoutEditPolicy;
import edu.pku.sei.sla.ctrl.figure.AgentFigure;
import edu.pku.sei.sla.images.ApelImageProvider;
import edu.pku.sei.sla.model.sla.ComputeService;

public class ComputeServiceEditPart extends GMPNodeEditPart {

	protected IFigure createFigure() {
		return new SimpleContainerFigure();
		// LinearContainerFigure figure = new LinearContainerFigure();
		// ToolbarLayout layout = new ToolbarLayout();
		// layout.setVertical(false);
		// layout.setSpacing(2);
		// layout.setStretchMinorAxis(true);
		// layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		// figure.setLayerLayout(layout);
		// return figure;
	}

	public IFigure getContentPane() {
		if (getFigure() instanceof SimpleContainerFigure) {
			return ((SimpleContainerFigure) getFigure()).getContentPane();
		}
		return super.getContentPane();
	}

	private ComputeService getComputeService() {
		return (ComputeService) getModelElement();
	}

	public void handlePropertyChanged(PropertyChangeEvent event) {
		refreshVisuals();
		super.handlePropertyChanged(event);
	}

	@Override
	protected void createEditPolicies() {
		// TODO Auto-generated method stub
		super.createEditPolicies();
		// installEditPolicy(EditPolicy.COMPONENT_ROLE,
		// new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ApelXYLayoutEditPolicy());
		// installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
	}

	protected void refreshVisuals() {
		ComputeService cs = getComputeService();
		if (figure != null) {
			Label l = (Label) (((SimpleContainerFigure) figure)
					.getCollapsedLabel());
			l.setText(cs.getName()); 
		}
		// ((LinearContainerFigure) figure).setName(modelEle.getName());
		super.refreshVisuals();
	}
}
