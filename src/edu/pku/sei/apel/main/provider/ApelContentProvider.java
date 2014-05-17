package edu.pku.sei.apel.main.provider;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import edu.pku.sei.apel.main.project.ApelModelerProject;

import edu.pku.sei.apel.model.common.SLAModel;


import edu.pku.sei.apel.model.sla.ComputeService;


public class ApelContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof ApelModelerProject) {
			ApelModelerProject project = (ApelModelerProject) parentElement;
			return project.getModels().toArray();
		} 
		 else if (parentElement instanceof SLAModel) {
			return getChildrenOfSLAModel((SLAModel) parentElement);
		} else if (parentElement instanceof ComputeService) {
			return getChildrenofComputeService((ComputeService) parentElement);
		}
		return new Object[0];
	}

	

	private Object[] getChildrenOfSLAModel(SLAModel m) {
		ArrayList<Object> children = new ArrayList<Object>();
		children.addAll(m.getDiagrams());
		children.addAll(m.getRootElements());
		return children.toArray();
	}

	private Object[] getChildrenofComputeService(ComputeService cs) {
		return cs.getAgreements().toArray();
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		return false;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return null;
	}

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

}
