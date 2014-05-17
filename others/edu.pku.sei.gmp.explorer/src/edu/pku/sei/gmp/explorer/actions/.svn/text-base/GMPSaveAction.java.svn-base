package edu.pku.sei.gmp.explorer.actions;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.ui.actions.UpdateAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.concept.GMPModelElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.exception.ProjectSaveException;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPSaveAction extends Action implements UpdateAction {
	
	public static String ACTION_ID = "GMP_SAVE_ACTION";
	
	private TreeViewer tv;
	private Object obj;
	private GMPProject pro;
	private Set<CommandStack> cmdStacks = new HashSet<CommandStack>();

	public GMPSaveAction(TreeViewer tv) {
		this.tv = tv;
		setText("Save");
		setToolTipText("Save");
		setImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.SAVE));
		setDisabledImageDescriptor(GMPImageProvider.getImageDescriptor(GMPImageProvider.SAVE_DISABLED));
		setEnabled(false);
	}

	protected boolean calculateEnabled() {
		if (cmdStacks.size() > 0) {
			for (CommandStack c : cmdStacks) {
				if (c.isDirty())
					return true;
			}
		}
		return false;
	}

	public void update() {
		if(tv == null || tv.getSelection() == null){
			setEnabled(false);
			return;
		}
		obj = ((TreeSelection) tv.getSelection()).getFirstElement();
		if(obj == null){
			setEnabled(false);
			return;
		}
		if (obj instanceof GMPModelElement || obj instanceof GMPDiagram)
			pro = GMPProjectUtils.model2project(((GMPElement) obj).getModel());
		if (obj instanceof GMPProject)
			pro = (GMPProject) obj;
		if(pro == null){
			setEnabled(false);
			return;
		}
		cmdStacks.clear();
		for (GMPModel m : pro.getModels()) {
			if (m.getCommandStack() != null)
				cmdStacks.add(m.getCommandStack());
		}
		
		if (!calculateEnabled()) {
			setEnabled(false);
		} else {
			setEnabled(true);
		}
	}

	public void run() {
		try {
			pro.save();
			List<CommandStack> copy = new ArrayList<CommandStack>();
			copy.addAll(cmdStacks);
			for (CommandStack c : copy) {
				if (c.isDirty())
					c.markSaveLocation();
			}
		} catch (ProjectSaveException e) {
			e.printStackTrace();
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
		GMPExplorerUpdateActionManager.getInstance().updateActions();
	}

}
