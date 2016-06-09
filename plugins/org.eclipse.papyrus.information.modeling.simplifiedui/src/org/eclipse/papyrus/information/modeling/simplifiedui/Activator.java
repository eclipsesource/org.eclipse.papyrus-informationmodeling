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
package org.eclipse.papyrus.information.modeling.simplifiedui;

import org.eclipse.papyrus.information.modeling.simplifiedui.internal.ContextConfigurator;
import org.eclipse.papyrus.information.modeling.simplifiedui.internal.ContextConfigurator.Context;
import org.eclipse.papyrus.information.modeling.simplifiedui.internal.CreationMenuCleaner;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin {

	/** The id of the plug-in. */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.information.modeling.simplifiedui"; //$NON-NLS-1$

	private static Activator plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		CreationMenuCleaner.clean();
		ContextConfigurator.disableContext(Context.UML);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	public static Activator getDefault() {
		return plugin;
	}
}
