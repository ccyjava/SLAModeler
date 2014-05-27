package edu.pku.sei.gmp.explorer.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;

import edu.pku.sei.gmp.explorer.actions.GMPExplorerActionGroup;
import edu.pku.sei.gmp.explorer.actions.IExplorerActionProvider;
import edu.pku.sei.gmp.explorer.registry.GMPExplorerActionProviderRegistry;
import edu.pku.sei.gmp.explorer.registry.GMPExplorerPullDownActionProviderRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPExplorerUtils {
	
	public static Action getDoubleClickAction(Object item) {
		String projectNature = "";
		if (item instanceof GMPProject) {
			projectNature = ((GMPProject) item).getProjectNature();
		} else if (item instanceof GMPElement) {
			GMPModel model = ((GMPElement) item).getModel();
			projectNature = GMPProjectUtils.model2project(model)
					.getProjectNature();
		}
		List<IExplorerActionProvider> actionProviders = GMPExplorerActionProviderRegistry
		.getInstance().getActionProviders(projectNature);
		if (actionProviders.size() == 0) {
			return null;
		} else {
			for(IExplorerActionProvider provider : actionProviders){
				Action action = provider.getDoubleClickAction(item);
				if(action != null)
					return action;
			}
			return null;
		}
	}

	public static List<GMPExplorerActionGroup> getActionGroups(
			List<?> treeList, TreeViewer tv) {
		String projectNature = "";
		List<GMPExplorerActionGroup> groups = new ArrayList<GMPExplorerActionGroup>();
		if (treeList.size() < 1)
			return groups;
		Object item = treeList.get(0);
		if (item instanceof GMPProject) {
			projectNature = ((GMPProject) item).getProjectNature();
		} else if (item instanceof GMPElement) {
			GMPModel model = ((GMPElement) item).getModel();
			projectNature = GMPProjectUtils.model2project(model)
					.getProjectNature();
		}
		List<IExplorerActionProvider> actionProviders = GMPExplorerActionProviderRegistry
				.getInstance().getActionProviders(projectNature);
		if (actionProviders.size() == 0) {
			return groups;
		} else {
			for (IExplorerActionProvider provider : actionProviders) {
				GMPExplorerActionGroup group = provider.getActionGroup(tv);
				if (group != null)
					groups.add(group);
			}
		}
		return groups;
	}

	public static List<GMPExplorerActionGroup> getPullDownActionGroups(
			TreeViewer viewer) {
		List<GMPExplorerActionGroup> groups = new ArrayList<GMPExplorerActionGroup>();
		List<IExplorerActionProvider> actionProviders = GMPExplorerPullDownActionProviderRegistry
				.getInstance().getActionProviders();
		if (actionProviders.size() == 0) {
			return groups;
		} else {
			for (IExplorerActionProvider provider : actionProviders) {
				GMPExplorerActionGroup group = provider.getActionGroup(viewer);
				if (group != null)
					groups.add(group);
			}
		}
		return groups;
	}
}
