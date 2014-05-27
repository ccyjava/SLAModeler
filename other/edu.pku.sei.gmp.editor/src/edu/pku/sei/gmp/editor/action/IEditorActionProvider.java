package edu.pku.sei.gmp.editor.action;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;

import edu.pku.sei.gmp.model.shape.GMPDiagram;

public interface IEditorActionProvider {
	
	public GMPEditorActionGroup getActionGroup(EditPartViewer partViewer,ActionRegistry defaultRegistry,GMPDiagram diagram);
	
	public String getProjectNature();

}
