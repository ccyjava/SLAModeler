package edu.pku.sei.gmp.editor.action.common;

import java.util.List;

import org.eclipse.gef.ui.actions.Clipboard;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import edu.pku.sei.gmp.controller.editpart.GMPDiagramEditPart;

public class GMPCutAction extends SelectionAction {
	private Clipboard clipboard = null;
	private List<?> selectionList = null;
	
	public GMPCutAction(IWorkbenchPart part) {
		super(part);
		this.setText(GMPActionConst.CUT_NAME);
		this.setDescription(GMPActionConst.CUT_DESC);
		ISharedImages si = PlatformUI.getWorkbench() .getSharedImages(); 
		this.setImageDescriptor(si.getImageDescriptor(ISharedImages.IMG_TOOL_CUT));
	}
	
	@Override
	protected boolean calculateEnabled() {
		selectionList = this.getSelectedObjects();
		if (selectionList.isEmpty()||
				(selectionList.size()==1&&selectionList.get(0) instanceof GMPDiagramEditPart))return false;
		return true;
	}

	public Clipboard getClipboard() {
		if (clipboard == null) {
			clipboard = Clipboard.getDefault();
		}
		return clipboard;
	}

	public void run() {
		getClipboard().setContents(selectionList);
	}

}
