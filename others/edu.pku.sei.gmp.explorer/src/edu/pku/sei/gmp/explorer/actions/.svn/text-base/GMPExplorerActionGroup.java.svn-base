package edu.pku.sei.gmp.explorer.actions;

import java.util.List;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.actions.ActionGroup;

public class GMPExplorerActionGroup extends ActionGroup {
	private TreeViewer tv;
	
	public GMPExplorerActionGroup(TreeViewer tv) {
		this.tv = tv;
	}
	
	@Override
	public void fillContextMenu(IMenuManager menu){
		menu.add(new GMPReloadAction(tv));
	}
	
	protected List<?> getSelection() {
		return ((TreeSelection)tv.getSelection()).toList();
	}
	
	protected TreeViewer getTreeViewer() {
		return tv;
	}
}
