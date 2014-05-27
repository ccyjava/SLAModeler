package edu.pku.sei.gmp.editor.dnd;

import java.util.List;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.dnd.AbstractTransferDropTargetListener;
import org.eclipse.gef.dnd.TemplateTransfer;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;

import edu.pku.sei.gmp.editor.registry.GMPEditorDropTargetListenerProxyonRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPEditorDropTargetListener extends
		AbstractTransferDropTargetListener {

	protected GMPDropElementCreationFactory dropFactory;

	public GMPDropElementCreationFactory getDropFactory() {
		return dropFactory;
	}

	public void setDropFactory(GMPDropElementCreationFactory dropFactory) {
		this.dropFactory = dropFactory;
	}

	public GMPEditorDropTargetListener(EditPartViewer viewer) {
		super(viewer);
		dropFactory = new GMPDropElementCreationFactory();
		this.setTransfer(TemplateTransfer.getInstance());
	}

	protected Request createTargetRequest() {
		CreateRequest request = new CreateRequest();
		request.setFactory(dropFactory);
		return request;
	}

	@Override
	protected void updateTargetRequest() {
		((CreateRequest) getTargetRequest()).setLocation(getDropLocation());
	}

	public boolean isEnabled(DropTargetEvent event) {
		boolean result = super.isEnabled(event);
		return result;
	}

	protected void handleDragOver() {
		getCurrentEvent().detail = DND.DROP_COPY;
		super.handleDragOver();
	}

	public void setViewer(EditPartViewer viewer) {
		super.setViewer(viewer);
	}

	@SuppressWarnings("unchecked")
	protected void handleDrop() {
		List objects = (List) getCurrentEvent().data;

		if (objects.size() < 1)
			return;

		// make sure all the object in data is GMPElement
		for (int i = 0; i < objects.size(); i++) {
			if (!(objects.get(i) instanceof GMPElement))
				return;
		}

		GMPModel model = ((GMPElement) objects.get(0)).getModel();
		if (model != null) {
			GMPProject p = GMPProjectUtils.model2project(model);
			if (p != null) {
				IGMPEditorDropTargetListenerProxyon listenerProxyon = GMPEditorDropTargetListenerProxyonRegistry
						.getInstance().getProxyon(p.getProjectNature());
				if (listenerProxyon != null) {
					listenerProxyon.handleDrop(this);
				}
			}
		}
	}

	public EditPartViewer getViewer() {
		return super.getViewer();
	}

	public void updateTargetEditPart() {
		super.updateTargetEditPart();
	}

	public EditPart getTargetEditPart() {
		return super.getTargetEditPart();
	}

	public Point getDropLocation() {
		return super.getDropLocation();
	}
}
