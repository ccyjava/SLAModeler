package edu.pku.sei.gmp.editor.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.ActionRegistry;

import edu.pku.sei.gmp.editor.action.GMPEditorActionGroup;
import edu.pku.sei.gmp.editor.action.IEditorActionProvider;
import edu.pku.sei.gmp.editor.registry.GMPEditorActionProviderRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPEditorUtils {
	
	public static List<GMPEditorActionGroup> getActionGroups(EditPartViewer viewer, ActionRegistry defaultActionRegistry, GMPDiagram diagram) {
		List<?> elements = viewer.getSelectedEditParts();
		List<GMPEditorActionGroup> groups = new ArrayList<GMPEditorActionGroup>();
		
		String projectNature = "";
		if (elements != null && elements.size() > 0) {
			Object element = elements.get(0);
			if(element instanceof AbstractGraphicalEditPart){
				AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) element;
				if(part.getModel() instanceof GMPElement){
					GMPModel model = ((GMPElement)part.getModel()).getModel();
					projectNature = GMPProjectUtils.model2project(model).getProjectNature();
				}
			}
		} else {
			GMPModel model = diagram.getModel();
			projectNature = GMPProjectUtils.model2project(model).getProjectNature();
		}
		
		List<IEditorActionProvider> actionProviders = GMPEditorActionProviderRegistry
		.getInstance().getActionProviders(projectNature);
		if (actionProviders.size() >0){
			for(IEditorActionProvider provider : actionProviders){
				GMPEditorActionGroup group = provider.getActionGroup(viewer,defaultActionRegistry,diagram);
				if(group != null)
					groups.add(group);
			}
		}
		return groups;
	}
}
