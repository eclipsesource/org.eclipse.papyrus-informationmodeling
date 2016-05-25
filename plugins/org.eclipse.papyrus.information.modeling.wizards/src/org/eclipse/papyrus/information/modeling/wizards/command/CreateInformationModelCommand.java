package org.eclipse.papyrus.information.modeling.wizards.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.UMLFactory;

public class CreateInformationModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "org.eclipse.papyrus.information.modeling.wizards.cmd";
	public static final String MODEL_NAME = "InformationModel";
	
	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}
	
	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		((NamedElement) owner).setName(MODEL_NAME);
		
		// add profiles here if necessary
	}
	
}
