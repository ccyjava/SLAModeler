package edu.pku.sei.apel.main.provider;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.apel.main.action.ApelExplorerActionGroup;

import edu.pku.sei.apel.main.action.SLAOpenDiagramAction;

import edu.pku.sei.apel.main.project.ApelModelerProject;

import edu.pku.sei.apel.model.common.SLAModelConst;

import edu.pku.sei.gmp.explorer.actions.GMPExplorerActionGroup;
import edu.pku.sei.gmp.explorer.actions.IExplorerActionProvider;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class ApelExplorerActionProvider implements IExplorerActionProvider {

	@Override
	public GMPExplorerActionGroup getActionGroup(TreeViewer tv) {
		return new ApelExplorerActionGroup(tv);
	}

	@Override
	public Action getDoubleClickAction(Object selectedElement) {
		if (selectedElement instanceof GMPDiagram) {
			String diagramType = ((GMPDiagram) selectedElement).getType();
			
			if (diagramType.equals(SLAModelConst.__SLAMODELDIAGRAM__)) 
				return new SLAOpenDiagramAction(selectedElement);
		}
		return null;
	}

	@Override
	public String getProjectNature() {
		return ApelModelerProject.PROJECT_NATURE;
	}

}
