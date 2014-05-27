package edu.pku.sei.gmp.editor.action;

import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionGroup;

import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class GMPEditorActionGroup extends ActionGroup {
	
	private EditPartViewer viewer;
	private GMPDiagram diagram;
	private ActionRegistry defaultActionRegistry;
	
	public EditPartViewer getViewer() {
		return viewer;
	}
	
	public List<?> getSelection(){
		return viewer.getSelectedEditParts();
	}
	public GMPDiagram getDiagram() {
		return diagram;
	}

	public ActionRegistry getDefaultActionRegistry() {
		return defaultActionRegistry;
	}

	public GMPEditorActionGroup(EditPartViewer viewer, ActionRegistry defaultActionRegistry, GMPDiagram diagram) {
		this.viewer = viewer;
		this.diagram = diagram;
		this.defaultActionRegistry = defaultActionRegistry;
	}
	
	@Override
	public void fillContextMenu(IMenuManager menu){
		menu.add(new Separator(GEFActionConstants.GROUP_UNDO));
		menu.add(new Separator(GEFActionConstants.GROUP_COPY));
		menu.add(new Separator(GEFActionConstants.GROUP_EDIT));
		
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, defaultActionRegistry.getAction(ActionFactory.UNDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_UNDO, defaultActionRegistry.getAction(ActionFactory.REDO.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_COPY, defaultActionRegistry.getAction(ActionFactory.COPY.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_COPY, defaultActionRegistry.getAction(ActionFactory.CUT.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_COPY, defaultActionRegistry.getAction(ActionFactory.PASTE.getId()));
		menu.appendToGroup(GEFActionConstants.GROUP_EDIT, defaultActionRegistry.getAction(ActionFactory.DELETE.getId()));
	
	}
}
