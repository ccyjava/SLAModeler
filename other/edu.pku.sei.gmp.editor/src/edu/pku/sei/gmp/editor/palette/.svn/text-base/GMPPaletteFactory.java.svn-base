package edu.pku.sei.gmp.editor.palette;

import java.util.List;

import org.eclipse.gef.palette.ConnectionCreationToolEntry;
import org.eclipse.gef.palette.CreationToolEntry;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.SelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;

import edu.pku.sei.gmp.model.common.GMPModel;

public class GMPPaletteFactory {

	private GMPModel model;

	public GMPPaletteFactory(GMPModel model) {
		this.model = model;
	}

	public PaletteRoot createPalette(String diagramType) {
		List<GMPEntryDescriptor> descs = getEntryList(diagramType);
		if (descs == null || descs.size() < 1) {
			return defaultPalette();
		}

		PaletteRoot root = new PaletteRoot();
		PaletteGroup group = new PaletteGroup("Control Group");
		PaletteDrawer drawer = new PaletteDrawer(diagramType);

		ToolEntry tool = new SelectionToolEntry();
		group.add(tool);
		root.setDefaultEntry(tool);
		tool = new MarqueeToolEntry();
		group.add(tool);

		for (GMPEntryDescriptor desc : descs) {
			CreationToolEntry toolEntry = null;
			GMPCreationFactory creationFactory = new GMPCreationFactory(
					desc.elementType, model);
			if (desc.entryType == GMPEntryType.NODE) {
				toolEntry = new CreationToolEntry(desc.label, desc.shortDesc,
						creationFactory, desc.iconSmall, desc.iconLarge);
			} else if (desc.entryType == GMPEntryType.LINK) {
				toolEntry = new ConnectionCreationToolEntry(desc.label,
						desc.shortDesc, creationFactory, desc.iconSmall,
						desc.iconLarge);
			}
			assert (toolEntry != null);
			drawer.add(toolEntry);
		}

		root.add(group);
		root.add(drawer);
		return root;
	}

	protected List<GMPEntryDescriptor> getEntryList(String diagramType) {
		return null;
	}

	private PaletteRoot defaultPalette() {
		PaletteRoot root = new PaletteRoot();
		PaletteGroup group = new PaletteGroup("Control Group");
		PaletteDrawer drawer = new PaletteDrawer("Default Palette");
		
		ToolEntry tool = new SelectionToolEntry();
		group.add(tool);
		root.setDefaultEntry(tool);
		tool = new MarqueeToolEntry();
		group.add(tool);

		root.add(group);
		root.add(drawer);

		return root;
	}
}
