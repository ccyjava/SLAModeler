package edu.pku.sei.gmp.editor.action;

import java.util.List;

import org.eclipse.gef.ContextMenuProvider;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.gef.ui.actions.GEFActionConstants;
import org.eclipse.jface.action.IMenuManager;

import edu.pku.sei.gmp.editor.util.GMPEditorUtils;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class GMPEditorContextMenuProvider extends ContextMenuProvider {
	
	private EditPartViewer viewer;
	private ActionRegistry actionRegistry;
	private Object diagram;
	
	private GMPEditorActionProvider defaultActionProvider = new GMPEditorActionProvider();

	public GMPEditorContextMenuProvider(EditPartViewer viewer, Object diagram,
			ActionRegistry registry) {
		super(viewer);
		this.viewer = viewer;
		this.diagram = diagram;
		this.actionRegistry = registry;
	}

	public void buildContextMenu(IMenuManager menu) {
		GEFActionConstants.addStandardActionGroups(menu);
		GMPEditorActionGroup defaultGroup = defaultActionProvider.getActionGroup(viewer, actionRegistry, (GMPDiagram)diagram);
		defaultGroup.fillContextMenu(menu);
		
		List<GMPEditorActionGroup> actionGroups = GMPEditorUtils.getActionGroups(getViewer(), this.actionRegistry,
						(GMPDiagram) diagram);
		if(actionGroups.size()>0){
			for (GMPEditorActionGroup actionGroup : actionGroups) {
				actionGroup.fillContextMenu(menu);
			}
		}
	}

}
