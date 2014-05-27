package edu.pku.sei.gmp.explorer.dnd;

import java.util.List;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import edu.pku.sei.gmp.explorer.registry.GMPExplorerDropAdapterProxyonRegistry;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.gmp.model.concept.GMPElement;
import edu.pku.sei.gmp.project.GMPProject;
import edu.pku.sei.gmp.project.util.GMPProjectUtils;

public class GMPViewerDropAdapter extends ViewerDropAdapter {

	public GMPViewerDropAdapter(Viewer viewer) {
		super(viewer);
	}
	
	@Override
	public boolean performDrop(Object data) {
		List<?> objects = (List<?>) data;
		
		if(objects.size()<1)
			return false;
		
		//make sure all the object in data is GMPElement
		for (int i = 0; i < objects.size(); i++) {
			if(!(objects.get(i) instanceof GMPElement))
				return false;
		}
		
		GMPModel model = ((GMPElement) objects.get(0)).getModel();
		if (model != null) {
			GMPProject p = GMPProjectUtils.model2project(model);
			if (p != null) {
				IGMPViewerDropAdapterProxyon adapterProxyon = GMPExplorerDropAdapterProxyonRegistry.getInstance().getProxyon(p.getProjectNature());
				if (adapterProxyon == null)
					return false;
				if(adapterProxyon.performDrop(this)){
					getViewer().setSelection(new StructuredSelection(getCurrentTarget()),true);
					getViewer().refresh();
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		if (target instanceof GMPElement){
			GMPModel model = ((GMPElement) target).getModel();
			if (model != null) {
				GMPProject p = GMPProjectUtils.model2project(model);
				if (p != null) {
					IGMPViewerDropAdapterProxyon adapterProxyon = GMPExplorerDropAdapterProxyonRegistry.getInstance().getProxyon(p.getProjectNature());
					if (adapterProxyon != null) {
						return adapterProxyon.validateDrop(this);
					}
				}
			}
		} else
			return false;
		return false;
	}
	
	public Object getCurrentTarget(){
		return super.getCurrentTarget();
	}
	
	public int getCurrentLocation(){
		return super.getCurrentLocation();
	}
	
	public DropTargetEvent getCurrentEvent() {
    	return super.getCurrentEvent();
    }
}
