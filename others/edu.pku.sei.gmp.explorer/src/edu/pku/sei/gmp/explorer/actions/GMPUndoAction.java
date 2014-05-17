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

public class GMPUndoAction extends Action implements UpdateAction {
	
	public static String ACTION_ID = "GMP_UNDO_ACTION";
	
	private TreeViewer tv;
	private Object obj;
	private CommandStack commandStack;

	public GMPUndoAction(TreeViewer tv) {
		this.tv = tv;
		setText("Undo");
		setToolTipText("Undo");
		setImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.UNDO));
		setDisabledImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.UNDO_DISABLED));
		setEnabled(false);
	}

	protected boolean calculateEnabled() {
		if (commandStack != null && commandStack.canUndo())
			return true;
		return false;
	}

	public void update() {
		if(tv == null || tv.getSelection() == null){
			setText("Undo");
			setToolTipText("Undo");
			setEnabled(false);
			return;
		}
		obj = ((TreeSelection) tv.getSelection()).getFirstElement();
		if(obj == null){
			setText("Undo");
			setToolTipText("Undo");
			setEnabled(false);
			return;
		}
		commandStack = null;
		if (obj instanceof GMPModelElement || obj instanceof GMPDiagram)
			commandStack = ((GMPElement) obj).getCommandStack();
		if (!calculateEnabled()) {
			setText("Undo");
			setToolTipText("Undo");
			setEnabled(false);
			return;
		}
		if (commandStack.getUndoCommand().getLabel() != null) {
			setText("Undo " + commandStack.getUndoCommand().getLabel());
			setToolTipText("Undo " + commandStack.getUndoCommand().getLabel());
		} else {
			setText("Undo");
			setToolTipText("Undo");
		}
		setEnabled(true);
	}
	
	public void run() {
		commandStack.undo();
		GMPExplorerUpdateActionManager.getInstance().updateActions();		
	}
}
