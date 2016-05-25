package org.eclipse.papyrus.information.modeling.ui;

import org.eclipse.papyrus.infra.newchild.CreationMenuRegistry;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder;

public class CreationMenuCleaner {
	public static final String UML_NEW_CHILD_MENU = "/resource/UML.creationmenumodel";
	public static final String UML_NEW_RELATIONSHIP_MENU = "/resource/UMLEdges.creationmenumodel";

	public static final String IM_NEW_CHILD_MENU = "/resource/newchild/IMNewChild.creationmenumodel";

	protected static final String[] DEACTIVATED_CHILD_MENUS = new String[] {
		UML_NEW_CHILD_MENU
	};
	
	public static void clean() {
		CreationMenuRegistry instance = org.eclipse.papyrus.infra.newchild.CreationMenuRegistry.getInstance();
		for(Folder folder : instance.getRootFolder()) {
			for(String childMenuPath : DEACTIVATED_CHILD_MENUS) {
				if(folder.eResource().getURI().toString().endsWith(childMenuPath)) {
					instance.setCreationMenuVisibility(folder, false);
				}
			}
		}
	}
}
