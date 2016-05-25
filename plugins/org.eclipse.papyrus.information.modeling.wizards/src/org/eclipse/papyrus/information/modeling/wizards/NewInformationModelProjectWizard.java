package org.eclipse.papyrus.information.modeling.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.information.modeling.wizards.command.CreateInformationModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.NewPapyrusProjectWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewInformationModelProjectWizard extends NewPapyrusProjectWizard {
	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New InformationModel Project");
	}
	
	@Override
	protected WizardNewProjectCreationPage createNewProjectCreationPage() {
		WizardNewProjectCreationPage newProjectPage = super.createNewProjectCreationPage();
		newProjectPage.setTitle("Papyrus InformationModel Project");
		newProjectPage.setDescription("Create a New InformationModel Project");
		return newProjectPage;
	}
	
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		return null;
	}
	
	@Override
	protected void saveDiagramCategorySettings() {
		// do nothing
	}
	
	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[]{ CreateInformationModelCommand.COMMAND_ID };
	}

	@Override
	public boolean isPapyrusRootWizard() {
		return false;
	}
}
