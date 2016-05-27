/**
 * Copyright (c) 2016 EclipseSource Services GmbH and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Martin Fleck (EclipseSource) - Initial API and implementation
 */
package org.eclipse.papyrus.information.modeling.simplifiedui.internal;

import org.eclipse.papyrus.infra.newchild.CreationMenuRegistry;
import org.eclipse.papyrus.infra.newchild.elementcreationmenumodel.Folder;

public class CreationMenuCleaner {
	public static final String UML_NEW_CHILD_MENU = "/resource/UML.creationmenumodel";
	public static final String UML_NEW_RELATIONSHIP_MENU = "/resource/UMLEdges.creationmenumodel";

	public static final String IM_NEW_CHILD_MENU = "/resource/newchild/IMNewChild.creationmenumodel";
	public static final String IM_NEW_RELATIONSHIP_MENU = "/resource/newchild/IMNewEdge.creationmenumodel";

	protected static final String[] DEACTIVATED_CHILD_MENUS = new String[] {
		UML_NEW_CHILD_MENU, UML_NEW_RELATIONSHIP_MENU
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
