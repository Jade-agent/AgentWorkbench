/**
 * ***************************************************************
 * Agent.GUI is a framework to develop Multi-agent based simulation 
 * applications based on the JADE - Framework in compliance with the 
 * FIPA specifications. 
 * Copyright (C) 2010 Christian Derksen and DAWIS
 * http://www.dawis.wiwi.uni-due.de
 * http://sourceforge.net/projects/agentgui/
 * http://www.agentgui.org 
 *
 * GNU Lesser General Public License
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation,
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 * **************************************************************
 */
package agentgui.core.environment;

import java.io.Serializable;

import agentgui.simulationService.environment.EnvironmentModel;

/**
 * The Class AbstractEnvironmentModel has to be used in environment models 
 * in order to define an abstract environment model that can exist beside
 * the displayEnvironment model and the time model.
 * 
 * @see EnvironmentModel
 * @see EnvironmentModel#getAbstractEnvironment()
 * @see EnvironmentController
 * @see EnvironmentController#getAbstractEnvironmentModel() 
 * 
 * @author Christian Derksen - DAWIS - ICB - University of Duisburg-Essen
 */
public abstract class AbstractEnvironmentModel implements Serializable {

	private static final long serialVersionUID = 7052170323244857840L;

	/**
	 * Has to return a copy of the current abstract environment.
	 * @return the copy
	 */
	public abstract AbstractEnvironmentModel getCopy();
	
}
