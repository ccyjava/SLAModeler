package edu.pku.sei.gmp.controller.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.ui.views.properties.IPropertySource;

import edu.pku.sei.gmp.controller.command.GMPDeleteLinkCommand;
import edu.pku.sei.gmp.controller.editpolicy.GMPLinkBendpointEditPolicy;
import edu.pku.sei.gmp.controller.editpolicy.GMPLinkEndpointEditPolicy;
import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPLink;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.properties.core.GMPPropertySource;

public class GMPLinkEditPart extends AbstractConnectionEditPart implements IGMPEditPart {

	protected PropertyChangeListener modelListener = new PropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
				handlePropertyChanged(event);
		}
	};
	
	@Override
	public GMPModelElement getModelElement() {
		GMPModel model = getShapeElement().getModel();
		return model.shape2model(getShapeElement());
	}

	@Override
	public GMPShapeElement getShapeElement() {
		return (GMPShapeElement) this.getModel();
	}
	
	@Override
	public void activate() {
		super.activate();
		getShapeElement().addPropertyChangeListener(modelListener);
		getModelElement().addPropertyChangeListener(modelListener);
	}
	
	@Override
	public void deactivate() {
		getShapeElement().removePropertyChangeListener(modelListener);
		getModelElement().removePropertyChangeListener(modelListener);
		super.deactivate();
	}
	
	
	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new GMPLinkEndpointEditPolicy());

		installEditPolicy(EditPolicy.CONNECTION_ROLE,
				new ConnectionEditPolicy() {
					protected Command getDeleteCommand(GroupRequest request) {
						return new GMPDeleteLinkCommand((GMPLink) getHost()
								.getModel());
					}
				});
		installEditPolicy(EditPolicy.CONNECTION_BENDPOINTS_ROLE,
				new GMPLinkBendpointEditPolicy());

	}

	@Override
	public void handlePropertyChanged(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if (propertyName.equals(GMPConst.LINK_BENDPOINTS)) {
			refreshVisuals();
		} else if (propertyName.equals(GMPConst.LINK_SOURCE)) {
			refreshVisuals();
		}
	}
	
	protected void refreshVisuals() {
		getConnectionFigure().setRoutingConstraint(
				((GMPLink) getModel()).getBendpoints());
	}
	

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == IPropertySource.class) {
			return new GMPPropertySource(this.getModelElement());
		}
		return super.getAdapter(key);
	}
}
