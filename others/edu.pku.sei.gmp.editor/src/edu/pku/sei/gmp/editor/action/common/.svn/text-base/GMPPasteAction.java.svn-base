package edu.pku.sei.gmp.editor.action.common;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.gmp.controller.command.GMPCreateNodeCommand;
import edu.pku.sei.gmp.editor.GMPModelerEditor;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.common.GMPModelFactory;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.model.shape.GMPNode;

public class GMPPasteAction extends SelectionAction {

	private Clipboard clipboard = null;
	private List<?> contents;

	public GMPPasteAction(IWorkbenchPart part) {
		super(part);
		this.setText(GMPActionConst.PST_NAME);
		this.setDescription(GMPActionConst.PST_DESC);
		ISharedImages si = PlatformUI.getWorkbench().getSharedImages();
		this.setImageDescriptor(si
				.getImageDescriptor(ISharedImages.IMG_TOOL_PASTE));
	}

	@Override
	protected boolean calculateEnabled() {
		Object obj = this.getClipboard().getContents();
		if (obj == null)
			return false;
		if (!(obj instanceof List<?>))
			return false;
		contents = (List<?>) obj;
		if (contents.size() == 0)
			return false;
		return true;
	}

	public Clipboard getClipboard() {
		if (clipboard == null) {
			clipboard = Clipboard.getDefault();
		}
		return clipboard;
	}

	public void run() {
		GMPModelerEditor part = (GMPModelerEditor) getWorkbenchPart();
		GMPDiagram diagram = ((GMPModelerEditor) part).getDiagram();
		if (diagram == null) {
			System.out.println("diagram is null, paste failed");
		}
		GMPModel model = diagram.getModel();
		GMPModelFactory factory = model.getModelFactory();

		for (int i = 0; i < contents.size(); i++) {
			GMPNode orgNode = (GMPNode) contents.get(i);
			String type = factory.id2type(orgNode.getId());
			GMPNode node = (GMPNode) factory.createShapeElement(type);
			GMPModelElement modelElement = model.shape2model(orgNode);
			factory.createTupleElement(modelElement, orgNode);
			Rectangle bound = new Rectangle(orgNode.getLocationX(), orgNode
					.getLocationY(), orgNode.getWidth(), orgNode.getHeight());
			GMPCreateNodeCommand cmd = new GMPCreateNodeCommand(node, diagram,
					bound);
			part.getEditDomain().getCommandStack().execute(cmd);
		}
	}
}
