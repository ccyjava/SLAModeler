package edu.pku.sei.gmp.explorer.provider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import edu.pku.sei.gmp.explorer.registry.GMPExplorerProviderRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;

public class GMPLabelProvider implements ILabelProvider {

	@Override
	public Image getImage(Object element) {
		ImageDescriptor iDesc = null;
		if (element instanceof IProject) {
			IProject proj = (IProject) element;
			if (proj.isOpen()) {
				iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.PROJECT_IMG);
			} else {
				iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.PROJECT_CLOSED_IMG);
			}
		} else if (element instanceof IFolder) {
			iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.FOLDER_IMG);
		} else if (element instanceof IFile) {
			iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.FILE_IMG);
		} else if (element instanceof GMPProject) {
			iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.PROJECT);
		} else if (element instanceof GMPElement) {
			GMPModel model = ((GMPElement) element).getModel();
			if (model != null) {
				GMPProject p = GMPProjectUtils.model2project(model);
				if (p != null) {
					ILabelProvider labelProvider = GMPExplorerProviderRegistry
							.getInstance().getLabelProvider(
									p.getProjectNature());
					if (labelProvider != null) {
						return labelProvider.getImage(element);
					}
				}
			} 
		} else {
			iDesc = GMPImageProvider.getImageDescriptor(GMPImageProvider.UNKNOWN);
		}
		return iDesc.createImage();
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IProject) {
			return ((IProject) element).getName();
		} else if (element instanceof IFolder) {
			return ((IFolder) element).getName();
		} else if (element instanceof IFile) {
			return ((IFile) element).getName();
		} else if (element instanceof GMPProject) {
			GMPProject proj = (GMPProject) element;
			return proj.getProject().getName();
		} else if (element instanceof GMPElement) {
			GMPModel model = ((GMPElement) element).getModel();
			if (model != null) {
				String projNature = GMPProjectUtils.model2project(model)
						.getProjectNature();
				ILabelProvider labelProvider = GMPExplorerProviderRegistry
						.getInstance().getLabelProvider(projNature);
				if (labelProvider != null) {
					return labelProvider.getText(element);
				}
			} else
				return new String("default");
		}
		return new String("default");
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}
