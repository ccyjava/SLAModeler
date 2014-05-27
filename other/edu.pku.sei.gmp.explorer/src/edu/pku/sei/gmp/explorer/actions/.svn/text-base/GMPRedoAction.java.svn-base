package edu.pku.sei.gmp.explorer.actions;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPRedoAction extends Action implements UpdateAction{
	
	public static String ACTION_ID = "GMP_REDO_ACTION";
	
	private TreeViewer tv;
	private Object obj;
	private CommandStack commandStack;

	public GMPRedoAction(TreeViewer tv) {
		this.tv = tv;
		setText("Redo");
		setToolTipText("Redo");
		setImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.REDO));
		setDisabledImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.REDO_DISABLED));
		setEnabled(false);
	}

	protected boolean calculateEnabled() {
		if (commandStack != null && commandStack.canRedo())
			return true;
		return false;
	}

	public void update() {
		if(tv == null || tv.getSelection() == null){
			setText("Redo");
			setToolTipText("Redo");
			setEnabled(false);
			return;
		}
		obj = ((TreeSelection) tv.getSelection()).getFirstElement();
		if(obj == null){
			setText("Redo");
			setToolTipText("Redo");
			setEnabled(false);
			return;
		}
		commandStack = null;
		if (obj instanceof GMPModelElement || obj instanceof GMPDiagram)
			commandStack = ((GMPElement) obj).getCommandStack();
		if (!calculateEnabled()) {
			setText("Redo");
			setToolTipText("Redo");
			setEnabled(false);
			return;
		}
		if (commandStack.getRedoCommand().getLabel() != null) {
			setText("Redo " + commandStack.getRedoCommand().getLabel());
			setToolTipText("Redo " + commandStack.getRedoCommand().getLabel());
		} else {
			setText("Redo");
			setToolTipText("Redo");
		}
		setEnabled(true);
	}
	
	public void run() {
		commandStack.redo();
		GMPExplorerUpdateActionManager.getInstance().updateActions();
	}

}
