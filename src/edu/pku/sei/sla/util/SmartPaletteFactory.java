package edu.pku.sei.sla.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import edu.pku.sei.gmp.editor.palette.GMPEntryDescriptor;
import edu.pku.sei.gmp.editor.palette.GMPEntryType;
import edu.pku.sei.gmp.editor.palette.GMPPaletteFactory;
import edu.pku.sei.gmp.model.common.GMPModel;
import edu.pku.sei.sla.images.ApelImageProvider;
import edu.pku.sei.sla.model.common.SLAModelConst;

public class SmartPaletteFactory extends GMPPaletteFactory {

	public SmartPaletteFactory(GMPModel model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	// static ArrayList<GMPEntryDescriptor> desc = null;
	static String path;
	static String p_name;

	public static void register(String p_name, String path) {
		SmartPaletteFactory.p_name = p_name;
		SmartPaletteFactory.path = path;
	}

	public List<GMPEntryDescriptor> alalysis(Map<String, Set<String>> crt,
			String p_name) {
		Set<String> elements = new HashSet<String>();
		ArrayList<GMPEntryDescriptor> desc = new ArrayList<GMPEntryDescriptor>();
		for (Entry<String, Set<String>> e : crt.entrySet()) {
			elements.addAll(e.getValue());
		}

		for (String s : elements) {
			try {
				Class.forName(p_name + "." + s);
				System.out.println("create " + s + " to palette");
				GMPEntryDescriptor entry = new GMPEntryDescriptor();
				entry.elementType = s;
				entry.label = s;
				entry.shortDesc = "Crate a " + s;
				entry.iconSmall = ApelImageProvider
						.getImageDescriptor(ApelImageProvider.COMPUTESEVICE);
				entry.entryType = GMPEntryType.NODE;
				desc.add(entry);
				System.out.println("SmartPaletteFactory Create " + s);
			} catch (Exception e) {
				System.err.println("Smart PaletteFactory can not found :"
						+ p_name + "." + s);
			}
		}

		return desc;
	}

	@Override
	protected List<GMPEntryDescriptor> getEntryList(String diagramType) {
		if (p_name != null && path != null) {
			Map<String, Set<String>> crt = Tools.getCRT(path);
			return this.alalysis(crt, p_name);
		}

		return null;
	}

}
