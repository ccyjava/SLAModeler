package edu.pku.sei.gmp.properties.view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.CreationFactory;
import org.eclipse.gef.ui.properties.UndoablePropertySheetEntry;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertySheetEntry;

import edu.pku.sei.gmp.properties.command.GMPCreateListItemCommand;
import edu.pku.sei.gmp.properties.command.GMPDeleteListItemCommand;
import edu.pku.sei.gmp.properties.core.GMPPropertySource;
import edu.pku.sei.gmp.properties.view.PropertySheetSorter;


public class GMPListPropertyDialog extends Dialog implements MouseListener,
		PropertyChangeListener {

	private List<Object> list;
	private Class<?> type;
	private CommandStack commandStack;

	private GMPPropertySheetViewer viewer;
	private PropertySheetSorter sorter;
	private Object[] inputValue;
	private ListViewer listViewer;
	private Action[] typeActions = null;
	private Action currentAction;
	private CreationFactory factory;
	private Button add, del, refresh;

	@SuppressWarnings("unchecked")
	public GMPListPropertyDialog(Shell parentShell, List<?> list, Class<?> type) {
		super(parentShell);
		this.list = (List<Object>) list;
		this.type = type;
	}
	
	public CommandStack getCommandStack() {
		return commandStack;
	}
	
	public void setCommandStack(CommandStack stack) {
		this.commandStack = stack;
	}

	public void setCreationFactory(CreationFactory factory) {
		this.factory = factory;
	}
	
	public boolean close() {
		viewer.getRootEntry().dispose();
		return super.close();
	}
	
	protected Control createDialogArea(Composite parent) {
		Composite control = (Composite) super.createDialogArea(parent);
		getShell().setText("GMP Properties");
		GridLayout layout = new GridLayout();
		layout.numColumns = 4;
		control.setLayout(layout);

		GridData layoutData;
		layoutData = new GridData(GridData.FILL_VERTICAL);
		listViewer = new ListViewer(control, SWT.SINGLE | SWT.BORDER
				| SWT.H_SCROLL | SWT.V_SCROLL);
		layoutData.widthHint = 100;
		layoutData.horizontalSpan = 3;

		listViewer.getControl().setLayoutData(layoutData);
		listViewer.setContentProvider(new ListViewContentProvider());
		listViewer.setLabelProvider(new ListViewLabelProvider());
		listViewer.setInput(list);
		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				if (listViewer.getList().getSelectionIndex() == -1)
					return;
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				if (sel.getFirstElement() == null)
					return;
				setInput(sel.getFirstElement());
				viewer.setInput(inputValue);
			}
		});

		viewer = new GMPPropertySheetViewer(control);
		viewer.setSorter(sorter);
		layoutData = new GridData(GridData.FILL_BOTH);
		layoutData.widthHint = 400;
		layoutData.heightHint = 200;
		layoutData.verticalSpan = 2;
		viewer.getControl().setLayoutData(layoutData);
		
		
		if (commandStack == null) {
			viewer.setRootEntry(new PropertySheetEntry());
		} else {
			viewer.setRootEntry(new UndoablePropertySheetEntry(commandStack));
		}

		layoutData = new GridData(SWT.CENTER);
		layoutData.widthHint = 59;
		add = new Button(control, SWT.PUSH);
		add.setText("Add");
		add.addMouseListener(this);
		add.setLayoutData(layoutData);

		del = new Button(control, SWT.PUSH);
		del.setText("Delete");
		del.addMouseListener(this);
		del.setLayoutData(layoutData);

//		refresh = new Button(control, SWT.PUSH);
//		refresh.setText("Refresh");
//		refresh.addMouseListener(this);

		viewer.addPropertyChangedListener(this);

		hookContextMenu();

		return control;
	}
	
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID,
				IDialogConstants.CLOSE_LABEL, true);
	}
	
	protected int getShellStyle() {
		return super.getShellStyle() | SWT.RESIZE | SWT.MAX;
	}

	public void setInput(Object input) {
		if (input instanceof Object[]) {
			MessageDialog.openInformation(this.getShell(),
					"setInput unkown mistake", "illegal input: Object[]");
			return;
		}
		if (input instanceof IAdaptable) {
			input = ((IAdaptable) input).getAdapter(IPropertySource.class);
		} else if (!(input instanceof IPropertySource)) {
			input = new GMPPropertySource(input);
		}
		inputValue = new Object[] { input };
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("ListMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(listViewer.getControl());
		listViewer.getControl().setMenu(menu);
	}

	private void fillContextMenu(IMenuManager manager) {
		if (typeActions == null)
			return;
		currentAction = new CreateCurrentAction(this);
		manager.add(currentAction);
		manager.add(new Separator());
		for (Action a : typeActions) {
			manager.add(a);
		}
	}

	public void setCurrentType(Class<?> t) {
		this.type = t;
	}

	public Class<?> getCurrentType() {
		return this.type;
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
	}

	@Override
	public void mouseUp(MouseEvent e) {
		handleAction(e.getSource());
	}

	public void handleAction(Object source) {
		if (source == add || source == currentAction) {
			Object obj = null;
			try {
				if (factory != null)
					obj = factory.getNewObject();
				if (obj == null)
					obj = type.newInstance();
			} catch (Exception e) {
				MessageDialog.openError(this.getShell(), "Error",
						"cannot create new instance" + e.getMessage());
			}
			
			Command cmd = new GMPCreateListItemCommand(list, obj);
			
			if (commandStack != null) {
				commandStack.execute(cmd);
			} else {
				cmd.execute();
			}
			
			listViewer.refresh();
		} else if (source == del) {
			IStructuredSelection sel = (IStructuredSelection) listViewer
					.getSelection();
			Iterator<?> it = sel.iterator();
			CompoundCommand cmd = new CompoundCommand();
			while (it.hasNext()) {
				cmd.add(new GMPDeleteListItemCommand(list, it.next()));
			}
			
			if (commandStack != null) {
				commandStack.execute(cmd);
			} else {
				cmd.execute();
			}
			
			listViewer.refresh();
		} else if (source == refresh) {
			listViewer.refresh();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		Object source = evt.getSource();
		if (source == viewer)
			listViewer.refresh();
	}

}

class TypeChangeAction extends Action {
	private Class<?> type;
	private GMPListPropertyDialog dlg;

	public TypeChangeAction(GMPListPropertyDialog dlg, Class<?> type) {
		this.type = type;
		this.dlg = dlg;
		this.setText(type.getName());
	}

	@Override
	public void run() {
		dlg.setCurrentType(type);
	}

	@Override
	public boolean isChecked() {
		return dlg.getCurrentType() == type;
	}

}

class CreateCurrentAction extends Action {
	private GMPListPropertyDialog dlg;

	public CreateCurrentAction(GMPListPropertyDialog dlg) {
		this.dlg = dlg;
		this.setText("Create");
	}

	@Override
	public String getText() {
		return "Create:" + dlg.getCurrentType().getSimpleName();
	}

	@Override
	public void run() {
		dlg.handleAction(this);
	}
}

class ListViewContentProvider implements IStructuredContentProvider {
	public void inputChanged(Viewer v, Object oldInput, Object newInput) {
	}

	public void dispose() {
	}

	final static private Object[] elements = new Object[1];

	public Object[] getElements(Object parent) {
		if (parent instanceof List<?>) {
			return ((List<?>) parent).toArray();
		} else if (parent instanceof Object[]) {
			Object[] objs = (Object[]) parent;
			return objs;
		} else {
			elements[0] = parent;
			return elements;
		}
	}
}

class ListViewLabelProvider extends LabelProvider {

	@Override
	public String getText(Object obj) {
		if (obj instanceof EditPart) {
			return getText(((EditPart) obj).getModel());
		}
		return obj.toString();
	}

	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(
				ISharedImages.IMG_OBJ_ELEMENT);
	}
}