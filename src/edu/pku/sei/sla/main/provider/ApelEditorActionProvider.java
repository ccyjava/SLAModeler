package edu.pku.sei.sla.main.provider;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;

import edu.pku.sei.gmp.editor.action.GMPEditorActionGroup;
import edu.pku.sei.gmp.editor.action.IEditorActionProvider;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.sla.main.project.ApelModelerProject;

public class ApelEditorActionProvider implements IEditorActionProvider {

	@Override
	public GMPEditorActionGroup getActionGroup(EditPartViewer partViewer,
			ActionRegistry defaultRegistry, GMPDiagram diagram) {
		return null;
	}

	@Override
	public String getProjectNature() {
		return ApelModelerProject.PROJECT_NATURE;
	}

}
