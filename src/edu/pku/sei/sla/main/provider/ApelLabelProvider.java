package edu.pku.sei.sla.main.provider;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;




import edu.pku.sei.gmp.model.shape.GMPDiagram;
import edu.pku.sei.gmp.resource.image.GMPImageProvider;
import edu.pku.sei.sla.images.ApelImageProvider;
import edu.pku.sei.sla.model.common.SLAModel;
import edu.pku.sei.sla.model.sla.ComputeService;

public class ApelLabelProvider implements ILabelProvider {

	@Override
	public Image getImage(Object element) {
		ImageDescriptor iDesc;
		if (element instanceof Process) {
			iDesc = ApelImageProvider
					.getImageDescriptor(ApelImageProvider.PROCESS);
		} else if (element instanceof GMPDiagram) {
			iDesc = GMPImageProvider
					.getImageDescriptor(GMPImageProvider.DIAGRAM);
		} else if (element instanceof SLAModel) {
			iDesc = GMPImageProvider
					.getImageDescriptor(GMPImageProvider.MODEL_VIEW);
		} else {
			iDesc = GMPImageProvider
					.getImageDescriptor(GMPImageProvider.UNKNOWN);
		}
		return iDesc.createImage();
	}

	@Override
	public String getText(Object element) {
		if (element instanceof GMPDiagram) {
			return new String(((GMPDiagram) element).getName());
		} else if (element instanceof SLAModel) {
			return new String("SLA Model");
		} else if (element instanceof ComputeService) {
			return new String("ComputeService");
		}
		return new String("unknown");
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

}
