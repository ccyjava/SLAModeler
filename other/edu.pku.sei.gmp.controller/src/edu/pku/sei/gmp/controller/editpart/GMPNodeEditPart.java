package edu.pku.sei.gmp.controller.editpart;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.views.properties.IPropertySource;

import edu.pku.sei.gmp.controller.editpolicy.GMPComponentEditPolicy;
import edu.pku.sei.gmp.controller.editpolicy.GMPGraphicalNodeEditPolicy;
import edu.pku.sei.gmp.controller.figure.GMPCommonFigure;
import edu.pku.sei.gmp.model.common.GMPConst;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPNode;
import edu.pku.sei.gmp.model.shape.GMPShapeElement;
import edu.pku.sei.gmp.properties.core.GMPPropertySource;

public class GMPNodeEditPart extends AbstractGraphicalEditPart implements
		NodeEditPart, IGMPEditPart {

	private GMPShapeElement shapeElement;
	private GMPModelElement modelElement;
	
	protected AbstractConnectionAnchor anchor;
	protected PropertyChangeListener modelListener = new PropertyChangeListener() {
		@Override
		public void propertyChange(PropertyChangeEvent event) {
				handlePropertyChanged(event);
		}
	};
	
	@Override
	public GMPShapeElement getShapeElement() {
		if (shapeElement == null) {
			shapeElement = (GMPShapeElement) this.getModel();
		}
		return shapeElement;
	}
	
	@Override
	public GMPModelElement getModelElement() {
		if (modelElement == null) {
			GMPModel model = getShapeElement().getModel();
			modelElement = model.shape2model(getShapeElement());
		}
		return modelElement;
	}
	
	@Override
	public void activate() {
		super.activate();
		this.getShapeElement().addPropertyChangeListener(modelListener);
		this.getModelElement().addPropertyChangeListener(modelListener);
	}
	
	@Override
	public void deactivate() {
		this.getShapeElement().removePropertyChangeListener(modelListener);
		this.getModelElement().removePropertyChangeListener(modelListener);
		super.deactivate();
	}
	
	@Override
	protected IFigure createFigure() {
		return null;
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new GMPComponentEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new GMPGraphicalNodeEditPolicy());
		
		/*
		 * Install a default LayoutEditPolicy.
		 */
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new LayoutEditPolicy() {
			@Override
			protected EditPolicy createChildEditPolicy(EditPart child) {
				return null;
			}

			@Override
			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}

			@Override
			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}
		});
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(
			ConnectionEditPart connection) {
		if (anchor == null)
			anchor = new ChopboxAnchor(getFigure());
		return anchor;
	}

	@Override
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		if (anchor == null)
			anchor = new ChopboxAnchor(getFigure());
		return anchor;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(
			ConnectionEditPart connection) {
		if (anchor == null)
			anchor = new ChopboxAnchor(getFigure());
		return anchor;
	}

	@Override
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		if (anchor == null)
			anchor = new ChopboxAnchor(getFigure());
		return anchor;
	}
	
	protected List<?> getModelSourceConnections() {
		return ((GMPNode)getShapeElement()).getOutgoings();
	}

	protected List<?> getModelTargetConnections() {
		return ((GMPNode)getShapeElement()).getIncomings();
	}

	@Override
	public void handlePropertyChanged(PropertyChangeEvent event) {
		String propertyName = event.getPropertyName();
		if (propertyName.equals(GMPConst.NODE_HEIGHT)) {
			refreshVisuals();
		} else if (propertyName.equals(GMPConst.NODE_WIDTH)) {
			refreshVisuals();
		} else if (propertyName.equals(GMPConst.NODE_LOCATIONX)) {
			refreshVisuals();
		} else if (propertyName.equals(GMPConst.NODE_LOCATIONY)) {
			refreshVisuals();
		} else if (propertyName.equals(GMPConst.NODE_INCOMINGS)) {
			refreshTargetConnections();
		} else if (propertyName.equals(GMPConst.NODE_OUTGOINGS)) {
			refreshSourceConnections();
		} else if (propertyName.equals(GMPConst.NODE_COLOR)) {
			if (this.getFigure() instanceof GMPCommonFigure) {
				((GMPCommonFigure) this.getFigure()).changeColor((Color) event
						.getNewValue());
			} else {
				(this.getFigure()).setBackgroundColor((Color) event
						.getNewValue());
			}
		} else if (propertyName.equals(GMPConst.SHAPECONTAINER_SUBNODES)
				|| propertyName.equals(GMPConst.__NODE__)) {
			refreshChildren();
		}
		
	}

	protected void refreshVisuals() {
		super.refreshVisuals();
		Rectangle constraint = new Rectangle(0, 0, -1, -1);
		GMPNode node = (GMPNode) getModel();
		Point p = new Point(node.getLocationX(), node.getLocationY());
		constraint.setLocation(p);
		constraint.width = node.getWidth();
		constraint.height = node.getHeight();
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,
				getFigure(), constraint);
		if (node.getColor() != null){
			if (this.getFigure() instanceof GMPCommonFigure){
				((GMPCommonFigure)this.getFigure()).changeColor(node.getColor());
			}
			else {
				(this.getFigure()).setBackgroundColor(node.getColor());
			}
		}
		if (node.getLineColor() != null) {
			if (this.getFigure() instanceof GMPCommonFigure){
				((GMPCommonFigure)this.getFigure()).changeLineColor(node.getLineColor());
			}
			else {
				(this.getFigure()).setForegroundColor(node.getLineColor());
			}
		}
	}
	
	protected List<GMPNode> getModelChildren() {
		return ((GMPNode)getModel()).getSubNodes();
	}
	
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == IPropertySource.class) {
			return new GMPPropertySource(this.getModelElement());
		}
		return super.getAdapter(key);
	}
}
