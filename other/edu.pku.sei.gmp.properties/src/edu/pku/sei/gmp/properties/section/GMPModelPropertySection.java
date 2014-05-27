package edu.pku.sei.gmp.properties.section;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import edu.pku.sei.gmp.properties.core.GMPPropertyCategory;

public class GMPModelPropertySection extends AbstractPropertySection {

	public static final String sectionId = GMPPropertyCategory.MODEL;
	public GMPPropertySection section;

	public void createControls(final Composite parent,
			TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		GMPPropertySectionFactory factory = new GMPPropertySectionFactory();
		section = factory.createSection(sectionId);
		section.createControls(parent, aTabbedPropertySheetPage);
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		section.setInput(part, selection);
	}

	public void refresh() {
		section.refresh();
	}
	
	
}
