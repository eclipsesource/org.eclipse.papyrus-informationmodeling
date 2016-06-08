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

import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;

public class ContextConfigurator {
	protected static ConfigurationManager configurationManager = ConfigurationManager.getInstance();
	
	public interface Context {
		public static final String ADVANCE_STYLE = "AdvanceStyle"; // AdvanceStyle
		public static final String CSS = "CSS"; // CSS in Diagrams
		public static final String CUSTOMIZATION = "Customization"; // Customization Models
		public static final String NOTATION = "notation"; // Diagram Notation
		public static final String STYLE = "style"; // Diagram Styles
		public static final String SYNCHRONIZATION = "synchronization"; // Diagram Synchronization
		public static final String INFORMATION_MODELING = "Information Modeling"; // Information Modeling
		public static final String SYMBOLS = "Symbols"; // UML Diagram Symbols
		public static final String UML_NOTATION = "UMLNotation"; // UML Graphical Notation
		public static final String UML = "UML"; // UML Metamodel
		public static final String UML_STEREOTYPE_APPLICATION_EXTERNAL_RESOURCE = "UMLStereotypeApplicationExternalResource"; // UML Profile Externalization
		public static final String SEQUENCE_NOTATION = "SequenceNotation"; // UML Sequence Diagram Notation
	}
	
	public static void disableContext(String name) {
		org.eclipse.papyrus.infra.properties.contexts.Context context = configurationManager.getContext(name);			
		if(context != null) {
			try {
				configurationManager.disableContext(context, true);
			} catch(Exception e) {
				; // nothing we can really do
			}
		}
	}
}
