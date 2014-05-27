package edu.pku.sei.gmp.editor.action;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;

import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.project.GMPProject;

public class GMPEditorActionProvider implements IEditorActionProvider {

	@Override
	public GMPEditorActionGroup getActionGroup(EditPartViewer partViewer,
			ActionRegistry defaultRegistry, GMPDiagram diagram) {
		return new GMPEditorActionGroup(partViewer,defaultRegistry,diagram);
	}

	@Override
	public String getProjectNature() {
		return GMPProject.GMP_COMMON_NATURE;
	}

}
