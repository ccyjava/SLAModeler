package edu.pku.sei.gmp.properties.section;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import edu.pku.sei.gmp.properties.view.GMPPropertyDefaultViewer;

public class GMPModelPropertySectionImpl extends GMPPropertySection {

	private GMPPropertyDefaultViewer viewer;
	private DefaultAction action;

	public void setInput(IWorkbenchPart part, ISelection selection) {
		if (selection.isEmpty())
			return;
		if (viewer != null && selection instanceof IStructuredSelection)
			viewer.setInput(((IStructuredSelection) selection).toArray());

	}

	public void refresh() {
		if (viewer != null)
			viewer.setInput(viewer.getInput());
	}

	private void initViewer(Composite parent,
			TabbedPropertySheetWidgetFactory factory) {

		viewer = new GMPPropertyDefaultViewer(parent, factory);
		action = new DefaultAction();
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				if (selection.isEmpty()){
					action.setEnabled(false);
					return;
				}
				if (viewer.getActiveCellEditor() != null) {
					action.setEnabled(true);
				}
			}
		});

		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.add(action);
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);

	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage page) {

		parent.setLayout(new GridLayout(1, false));
		parent.setLayoutData(new GridData(GridData.FILL_BOTH));
		Section section = page.getWidgetFactory().createSection(parent,
				Section.TITLE_BAR | Section.TWISTIE);
		section.setText("Model Sepecification");
		section.setLayout(new GridLayout(1, false));
		section.setLayoutData(new GridData(GridData.FILL_BOTH));

		Composite composite = page.getWidgetFactory().createComposite(section,
				SWT.NONE);
		composite.setLayout(new GridLayout(1, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		section.setClient(composite);

		Group group = page.getWidgetFactory().createGroup(composite,
				"");
		group.setLayout(new GridLayout(1, false));
		group.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		initViewer(group, page.getWidgetFactory());
		GridData data = new GridData(GridData.FILL_BOTH);
		data.horizontalSpan = 2;
		viewer.getControl().setLayoutData(data);

	}

	class DefaultAction extends Action {

	}

}
