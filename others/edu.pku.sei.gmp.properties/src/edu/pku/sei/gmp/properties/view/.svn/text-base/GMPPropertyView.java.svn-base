package edu.pku.sei.gmp.properties.view;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class GMPPropertyView extends PageBookView implements
		ITabbedPropertySheetPageContributor, ISelectionListener {

	private IPropertySheetPage currentPage = null;
	private IWorkbenchPart currentPart = null;

	public GMPPropertyView() {
		super();
	}

	protected IPage createDefaultPage(PageBook book) {
		currentPage = new TabbedPropertySheetPage(this);
		initPage((IPageBookViewPage) currentPage);
		currentPage.createControl(book);
		return currentPage;
	}

	@Override
	public String getContributorId() {
		// TODO Auto-generated method stub
		return getSite().getId();
	}

	@SuppressWarnings("unchecked")
	public Object getAdapter(Class key) {
		if (key == TabbedPropertySheetPage.class) {
			if (currentPage == null)
				currentPage = new TabbedPropertySheetPage(this);
			return currentPage;
		}
		return super.getAdapter(key);
	}

	@Override
	public void createPartControl(Composite parent) {

		super.createPartControl(parent);

	}

	protected IWorkbenchPart getBootstrapPart() {
		IWorkbenchPage page = getSite().getPage();
		if (page != null)
			return page.getActiveEditor();
		return null;
	}

	public void init(IViewSite site) throws PartInitException {
		site.getPage().addSelectionListener(this);
		super.init(site);
	}

	// TODO:to check
	protected boolean isImportant(IWorkbenchPart part) {
		return (part instanceof IViewPart);
	}

	public void partActivated(IWorkbenchPart part){
		if( isImportant(part))
			currentPart = part;
		super.partActivated(part);
	}
	
	public void partBroughtToTop(IWorkbenchPart part) {
		partActivated(part);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		getSelectionProvider().selectionChanged(event);
	}

	protected PageRec doCreatePage(IWorkbenchPart part) {
		if (currentPage != null && this.equals(part))
			return new PageRec(part, currentPage);
		else {
			if(part instanceof IAdaptable){
				IAdaptable adaptable = (IAdaptable)part;
				Object result = adaptable.getAdapter(TabbedPropertySheetPage.class);
				if(result instanceof TabbedPropertySheetPage){
					currentPage = (IPropertySheetPage) result;
					initPage((IPageBookViewPage) currentPage);
					currentPage.createControl(getPageBook());
					return new PageRec(part,currentPage);
				}
			}
		}
		return null;
	}

	protected void doDestroyPage(IWorkbenchPart part, PageRec rec) {
		IPropertySheetPage page = (IPropertySheetPage) rec.page;
		page.dispose();
		rec.dispose();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		if(selection.isEmpty())
			return;
		if(!(selection instanceof IStructuredSelection))
			return;
		if(currentPage != null && !part.equals(currentPart)) {
			((TabbedPropertySheetPage) currentPage).selectionChanged(part,
					selection);
		}
	}

}