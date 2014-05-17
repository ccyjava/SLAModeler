package edu.pku.sei.gmp.explorer.actions;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPReloadAction extends Action {
	
	private TreeViewer tv;
	public GMPReloadAction(TreeViewer tv) {
		this.tv = tv;
		this.setText("Reload workspace");
		this.setImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.MODEL_VIEW));
	}
	
	public void run(){
		updateInput();
	}
	/**
	 * update the EditorInput, reload the workspace.
	 */
	public void updateInput() {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		try {
			root.refreshLocal(5, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (root == null) {
			MessageDialog.openInformation(null, "debug_information",
					"workspace root is null!");
		} else {
			tv.setInput(root);
			tv.refresh(true);
		}
	}
}
