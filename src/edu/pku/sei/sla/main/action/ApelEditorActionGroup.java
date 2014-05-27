package edu.pku.sei.sla.main.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.ui.actions.ActionRegistry;
import org.eclipse.jface.action.IMenuManager;

import edu.pku.sei.gmp.controller.editpart.GMPNodeEditPart;
import edu.pku.sei.gmp.editor.action.GMPEditorActionGroup;
import edu.pku.sei.gmp.model.shape.GMPDiagram;

public class ApelEditorActionGroup extends GMPEditorActionGroup {

	public ApelEditorActionGroup(EditPartViewer viewer,
			ActionRegistry defaultActionRegistry, GMPDiagram diagram) {
		super(viewer, defaultActionRegistry, diagram);
	}
	
	public void fillContextMenu(IMenuManager menu) {
		ApelJPEGExportAction eAction = new ApelJPEGExportAction();
		menu.add(eAction);
		
		List<?> selectedElements = super.getSelection();
		if (selectedElements.size() < 1)
			return;
		
		
		ArrayList<GMPNodeEditPart> nodes = new ArrayList<GMPNodeEditPart>(); 
		Iterator<?> it = selectedElements.iterator();
		Object part;
		while(it.hasNext()){
			part = it.next();
			if(part instanceof GMPNodeEditPart)
				nodes.add((GMPNodeEditPart) part);
		}
		ApelChangeBColorAction bAction = new ApelChangeBColorAction(nodes);
		menu.add(bAction);
		ApelChangeLColorAction lAction = new ApelChangeLColorAction(nodes);
		menu.add(lAction);
	}

}
