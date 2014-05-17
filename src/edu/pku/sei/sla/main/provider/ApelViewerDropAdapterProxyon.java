package edu.pku.sei.sla.main.provider;

import edu.pku.sei.gmp.explorer.dnd.GMPViewerDropAdapter;
import edu.pku.sei.gmp.explorer.dnd.IGMPViewerDropAdapterProxyon;

public class ApelViewerDropAdapterProxyon implements
		IGMPViewerDropAdapterProxyon {

	@Override
	public boolean performDrop(GMPViewerDropAdapter adapter) {
		return false;
	}

	@Override
	public boolean validateDrop(GMPViewerDropAdapter adapter) {
		return false;
	}

}
