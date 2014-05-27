package edu.pku.sei.gmp.explorer.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.gmp.project.GMPProject;


public class GMPExplorerActionProvider implements IExplorerActionProvider {

	@Override
	public GMPExplorerActionGroup getActionGroup(TreeViewer tv) {
		return new GMPExplorerActionGroup(tv);
	}

	@Override
	public Action getDoubleClickAction(Object treeObj) {
		return null;
	}

	@Override
	public String getProjectNature() {
		return GMPProject.GMP_COMMON_NATURE;
	}

}
