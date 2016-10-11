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
package org.eclipse.papyrus.information.modeling.simplifiedui.navigator;

import org.eclipse.ui.internal.navigator.resources.actions.OpenActionProvider;

/**
 * An Action Provider that provides the 'Open' and 'Open With' actions in the navigator.
 * 
 * In the Papyrus IM setup, these actions would be provided by the action provider of JDT,
 * which overrides the action provider of the navigator plugin. However, by hiding the JDT
 * contributions through activities, we also lose the action provider. This class restores
 * the lost actions.
 */
@SuppressWarnings("restriction")
public class PackageExplorerOpenActionProvider extends OpenActionProvider {
}
