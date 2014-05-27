package edu.pku.sei.gmp.controller.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.FanRouter;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.ShortestPathConnectionRouter;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.gef.editpolicies.SnapFeedbackPolicy;
import org.eclipse.swt.SWT;

import edu.pku.sei.gmp.controller.editpolicy.GMPXYLayoutEditPolicy;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class GMPDiagramEditPart extends AbstractGraphicalEditPart implements
		LayerConstants, PropertyChangeListener{

	public GMPDiagramEditPart(GMPDiagram model) {
		super();
		setModel(model);
	}

	public void activate() {
		super.activate();
		((GMPDiagram) getModel()).addPropertyChangeListener(this);
	}

	public void deactivate() {
		((GMPDiagram) getModel()).removePropertyChangeListener(this);
		super.deactivate();
	}

	@Override
	protected IFigure createFigure() {
		Figure f = new FreeformLayer();
		f.setBorder(new MarginBorder(0));
		f.setLayoutManager(new FreeformLayout());
		ConnectionLayer connLayer = (ConnectionLayer) getLayer(LayerConstants.CONNECTION_LAYER);
		FanRouter router = new FanRouter();
		router.setSeparation(20);
		router.setNextRouter(new ShortestPathConnectionRouter(f));
		connLayer.setConnectionRouter(router);
		connLayer.setAntialias(SWT.ON);

		return f;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new RootComponentEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new GMPXYLayoutEditPolicy());
		installEditPolicy("Snap Feedback", new SnapFeedbackPolicy());
	}

	public void propertyChange(PropertyChangeEvent event) {
		refreshChildren();
	}

	@Override
	protected List<?> getModelChildren() {
		return ((GMPDiagram)this.getModel()).getSubNodes();
	}
}
