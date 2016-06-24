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
package org.eclipse.papyrus.information.modeling.intro.internal.action;

import java.util.Properties;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWizard;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.intro.IIntroSite;
import org.eclipse.ui.intro.config.IIntroAction;
import org.eclipse.ui.wizards.IWizardDescriptor;

public class ShowWizardAction implements IIntroAction {

	@Override
	public void run(final IIntroSite site, final Properties params) {
		final String wizardId = params.getProperty("id");
		final IWizardDescriptor descriptor = openWizard(wizardId);
		if (descriptor == null) {
			// no wizard found
			return;
		}

		// close intro
		final IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
		final IIntroPart part = introManager.getIntro();
		introManager.closeIntro(part);

		IWizard wizard;
		try {
			wizard = descriptor.createWizard();
			initializeWizard(wizard, site);
			final WizardDialog dialog = new WizardDialog(site.getShell(), wizard);
			dialog.create();
			dialog.open();
		} catch (final CoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the given wizard, if necessary.
	 * 
	 * @param wizard
	 *            wizard to be initialized
	 * @param site
	 *            intro site
	 */
	protected void initializeWizard(final IWizard wizard, final IIntroSite site) {
		if (wizard instanceof IWorkbenchWizard) {
			((IWorkbenchWizard) wizard).init(site.getWorkbenchWindow().getWorkbench(), new StructuredSelection());
		}
	}

	/**
	 * Returns the wizard with the given id or null if the given id is null or no wizard with the id can be found.
	 * 
	 * @param wizardId
	 *            wizard id
	 * @return wizard with given id or null
	 */
	private IWizardDescriptor openWizard(final String wizardId) {
		// First see if this is a "new wizard".
		IWizardDescriptor descriptor = PlatformUI.getWorkbench().getNewWizardRegistry().findWizard(wizardId);

		// If not check if it is an "import wizard".
		if (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getImportWizardRegistry().findWizard(wizardId);
		}

		// Or maybe an export wizard
		if (descriptor == null) {
			descriptor = PlatformUI.getWorkbench().getExportWizardRegistry().findWizard(wizardId);
		}

		return descriptor;
	}

}
