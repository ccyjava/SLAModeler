package edu.pku.sei.gmp.editor.action.common;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.gmp.controller.editpart.GMPDiagramEditPart;
import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.editor.GMPModelerEditor;
import edu.pku.sei.gmp.model.shape.GMPNode;


public class GMPCopyAction extends SelectionAction {
	
	private Clipboard clipboard = null;
	private List<?> selectionList = null;

	public GMPCopyAction(IWorkbenchPart part) {
		super(part);
		this.setText(GMPActionConst.CPY_NAME);
		this.setDescription(GMPActionConst.CPY_DESC);
		ISharedImages si = PlatformUI.getWorkbench() .getSharedImages(); 
		this.setImageDescriptor(si.getImageDescriptor(ISharedImages.IMG_TOOL_COPY));
	}

	@Override
	protected boolean calculateEnabled() {
		selectionList = this.getSelectedObjects();
		if (selectionList.isEmpty()||
				(selectionList.size()==1&&selectionList.get(0) instanceof GMPDiagramEditPart))
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
		ArrayList<GMPNode> contents = new ArrayList<GMPNode>();
		for(int i=0; i<selectionList.size(); i++) {
			Object obj = selectionList.get(i);
			if(obj instanceof GMPNodeEditPart) {
				Object shape = ((GMPNodeEditPart)obj).getModel();
				if(shape instanceof GMPNode) {
					contents.add((GMPNode)shape);
				}
			}
		}
		getClipboard().setContents(contents);
		if(!(getWorkbenchPart() instanceof GMPModelerEditor))
			return;
		((GMPModelerEditor)getWorkbenchPart()).updatePaste();
	}
}
