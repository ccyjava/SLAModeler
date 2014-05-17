package edu.pku.sei.apel.main.palette;

import java.util.ArrayList;
import java.util.List;

import edu.pku.sei.apel.images.ApelImageProvider;

import edu.pku.sei.apel.model.common.SLAModelConst;
import edu.pku.sei.gmp.editor.palette.GMPEntryDescriptor;
import edu.pku.sei.gmp.editor.palette.GMPEntryType;
import edu.pku.sei.gmp.editor.palette.GMPPaletteFactory;
import edu.pku.sei.gmp.model.common.GMPModel;

public class SLAPaletteFactory extends GMPPaletteFactory {

	public SLAPaletteFactory(GMPModel model) {
		super(model);

	}

	@Override
	protected List<GMPEntryDescriptor> getEntryList(String diagramType) {
		if (diagramType.equals(SLAModelConst.__SLAMODELDIAGRAM__)) {
			ArrayList<GMPEntryDescriptor> desc = new ArrayList<GMPEntryDescriptor>();
			GMPEntryDescriptor entry = new GMPEntryDescriptor();
			entry.elementType = SLAModelConst.__COMPUTESERVICE__;
			entry.label = "ComputeService";
			entry.shortDesc = "Crate a ComputeService";
			entry.iconSmall = ApelImageProvider
					.getImageDescriptor(ApelImageProvider.COMPUTESEVICE);
			entry.entryType = GMPEntryType.NODE;
			desc.add(entry);

			entry = new GMPEntryDescriptor();
			entry.elementType = SLAModelConst.__SLAAGREEMENT__;
			entry.label = "SLAAgreement";
			entry.shortDesc = "Crate a SLAAgreement";
			entry.iconSmall = ApelImageProvider
					.getImageDescriptor(ApelImageProvider.SLAAGREEMENT);
			entry.entryType = GMPEntryType.NODE;
			desc.add(entry);

			return desc;
		} else {
			return null;
		}
	}
}
