package org.eclipse.papyrus.information.modeling.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.information.modeling.wizards.command.CreateInformationModelCommand;
import org.eclipse.papyrus.uml.diagram.wizards.pages.SelectDiagramCategoryPage;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

public class NewInformationModelWizard extends CreateModelWizard {

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New Information Model");
	}
	
	@Override
	public String getModelKindName() {
		return "Papyrus InformationModel";
	}
	
	@Override
	protected String[] getDiagramCategoryIds() {
		return new String[] { CreateInformationModelCommand.COMMAND_ID };
	}
	
	@Override
	protected SelectDiagramCategoryPage createSelectDiagramCategoryPage() {
		selectDiagramCategoryPage = null;
		return null;
	}
	
	@Override
	protected void saveDiagramCategorySettings() {
		// do nothing
	}
	
	@Override
	public boolean isPapyrusRootWizard() {
		return false;
	}
}
