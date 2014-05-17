package edu.pku.sei.sla.main.provider;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;





import edu.pku.sei.gmp.explorer.actions.GMPExplorerActionGroup;
import edu.pku.sei.gmp.explorer.actions.IExplorerActionProvider;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.sla.main.action.ApelExplorerActionGroup;
import edu.pku.sei.sla.main.action.SLAOpenDiagramAction;
import edu.pku.sei.sla.main.project.ApelModelerProject;
import edu.pku.sei.sla.model.common.SLAModelConst;

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
