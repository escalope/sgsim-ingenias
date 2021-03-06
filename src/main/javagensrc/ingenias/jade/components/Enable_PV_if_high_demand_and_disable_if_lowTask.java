/*
 Copyright (C) 2005 Jorge Gomez Sanz

 This file is part of INGENIAS Agent Framework, an agent infrastructure linked
 to the INGENIAS Development Kit, and availabe at http://grasia.fdi.ucm.es/ingenias or
 http://ingenias.sourceforge.net. 

 INGENIAS Agent Framework is free software; you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation; either version 2 of the License, or
 (at your option) any later version.

 INGENIAS Agent Framework is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with INGENIAS Agent Framework; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

 */

package ingenias.jade.components;

import java.util.*;
import ingenias.jade.exception.*;
import ingenias.jade.comm.*;
import ingenias.jade.mental.*;
import ingenias.editor.entities.*;

/**
 * 
 * <p>
 * The Task Enable_PV_if_high_demand_and_disable_if_low has the following
 * inputs, sets of possible outputs, and available applications:
 * </p>
 * Inputs:
 * <ul>
 * <li>_TimeTick1</li>
 * <li>AssociatedUnit</li>
 * 
 * 
 * 
 * </ul>
 * Expected output:
 * <ul>
 * 
 * </ul>
 * Available apps:
 * <ul>
 * <li>SMClientApp</li>
 * 
 * </ul>
 */
public class Enable_PV_if_high_demand_and_disable_if_lowTask extends Task {

	public Enable_PV_if_high_demand_and_disable_if_lowTask(String id) {
		super(id, "Enable_PV_if_high_demand_and_disable_if_low");

	}

	public void execute() throws TaskException {
		YellowPages yp = null; // only available for initiators of interactions

		_TimeTick1 ei_TimeTick1 = (_TimeTick1) this
				.getFirstInputOfType("_TimeTick1");

		AssociatedUnit eiAssociatedUnit = (AssociatedUnit) this
				.getFirstInputOfType("AssociatedUnit");

		SMClientApp eaSMClient = (SMClientApp) this.getApplication("SMClient");

		Vector<TaskOutput> outputs = this.getOutputs();

		// sets the first possible alternative to be the default one
		if (!this.getOutputs().isEmpty())
			this.setFinalOutput(outputs.firstElement());

		// --------------------------------------------------------
		// End of automatically generated code
		// --------------------------------------------------------
		// Expected output summary:

		// Available apps:
		// SMClientApp</li>

		// Summary of alternatives available to this task
		// --------------------------------------------------------

		// Code Area
		// #start_node:INGENIASCodeComponent0 <--- DO NOT REMOVE THIS
		System.out.println(getAgentID() + " executing -> " + getID() + ":"
				+ getType());
		if (!eaSMClient.isReady())
			eaSMClient.tryItAgainAfter(5);
		try {
			// Switches on the PV
			eaSMClient.sendOrder(new mired.ucm.remote.orders.RemoteSwitchOn(
					eiAssociatedUnit.getdevice()));
			System.out.println(eaSMClient.getTransformationCentreSensors());
		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// #end_node:INGENIASCodeComponent0 <--- DO NOT REMOVE THIS

	}

}
