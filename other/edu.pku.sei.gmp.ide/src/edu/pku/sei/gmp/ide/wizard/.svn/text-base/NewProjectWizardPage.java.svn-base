package edu.pku.sei.gmp.ide.wizard;

import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import edu.pku.sei.gmp.project.registry.GMPProjectRegistry;

/**
 * @author zl
 *
 */
public class NewProjectWizardPage extends WizardPage {
	private Text projectName;
	private Combo projectType;
	
	public NewProjectWizardPage() {
		super("new meta-modeling project wizard");
		setTitle("new project");
		setDescription("This wizard creates a new meta-modeling project");
	}
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;

		GridData gd = new GridData(GridData.BEGINNING);
		Label label = new Label(container, SWT.NULL);
		label.setText("&Project name:");
		label.setLayoutData(gd);

		projectName = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		projectName.setLayoutData(gd);
		projectName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});
		

		
		gd = new GridData(GridData.BEGINNING);
		label = new Label(container, SWT.NULL);
		label.setText("&Project type:");
		label.setLayoutData(gd);
		
		projectType = new Combo(container, SWT.BORDER | SWT.SINGLE | SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
		initialize();
		dialogChanged();
		setControl(container);
	}
	
	private void initialize() {
		projectName.setText("new project");
		List<String> natures = GMPProjectRegistry.getInstance().getNatures();
		if(natures.size()==0) {
			projectType.add("No type is registered");
			projectType.select(0);
			return;
		}
		for(int i=0; i<natures.size(); i++) {
			projectType.add((String)natures.get(i));
		}
		projectType.select(0);
	}
	/**
	 * Ensures that all text fields are set.
	 */

	private void dialogChanged() {
		String projectName = getProjectName();
		if (projectName.length() == 0) {
			updateStatus("Project name must be specified");
			return;
		}
		if (projectName.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("Project name must be valid");
			return;
		}
		
	//added by zsj to check whether the project has already existed.	
	  boolean project= ResourcesPlugin.getWorkspace().getRoot().exists(new Path(projectName));
	  if (project ) {
		  updateStatus(projectName + " has already existed");
			return;
	  }
	  //end of adding
	  
	  updateStatus(null);
	}
	
	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	public String getProjectName() {
		return projectName.getText();
	}
	
	public String getProjectType() {
		return projectType.getItem(projectType.getSelectionIndex());
	}
}
