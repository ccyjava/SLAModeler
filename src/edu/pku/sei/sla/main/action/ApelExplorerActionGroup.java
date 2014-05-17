package edu.pku.sei.sla.main.action;

import java.util.List;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.TreeViewer;



import edu.pku.sei.gmp.editor.action.GMPCreateDiagramAction;
import edu.pku.sei.gmp.explorer.actions.GMPDeleteDiagramAction;
import edu.pku.sei.gmp.explorer.actions.GMPExplorerActionGroup;
import edu.pku.sei.gmp.explorer.actions.GMPExplorerUpdateActionManager;
import edu.pku.sei.gmp.explorer.actions.GMPRedoAction;
import edu.pku.sei.gmp.explorer.actions.GMPUndoAction;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.sla.model.common.SLAModel;
import edu.pku.sei.sla.model.common.SLAModelConst;

public class ApelExplorerActionGroup extends GMPExplorerActionGroup {

	public ApelExplorerActionGroup(TreeViewer tv) {
		super(tv);
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {

		MenuManager newMenu = new MenuManager("New");
		menu.add(newMenu);
		menu.add(new Separator());

		List<?> selectedElement = super.getSelection();

		if (selectedElement.size() < 1)
			return;

		Object treeObj = selectedElement.get(0);

		if (treeObj instanceof GMPDiagram) {
			String diagramType = ((GMPDiagram) treeObj).getType();
			
			menu.add(new Separator());

			menu.add((IAction) GMPExplorerUpdateActionManager.getInstance()
					.getAction(GMPUndoAction.ACTION_ID));
			menu.add((IAction) GMPExplorerUpdateActionManager.getInstance()
					.getAction(GMPRedoAction.ACTION_ID));
			menu.add(new GMPDeleteDiagramAction(selectedElement));
		}

		
		if (treeObj instanceof SLAModel) {
			menu.add((IAction) GMPExplorerUpdateActionManager.getInstance()
					.getAction(GMPUndoAction.ACTION_ID));
			menu.add((IAction) GMPExplorerUpdateActionManager.getInstance()
					.getAction(GMPRedoAction.ACTION_ID));
			GMPCreateDiagramAction createAction = new GMPCreateDiagramAction(
					SLAModelConst.__SLAMODELDIAGRAM__, treeObj);
			createAction.setOpenDiagramAction(new SLAOpenDiagramAction());
			newMenu.add(createAction);
		}
		
	}
}
