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
package agentgui.simulationService.environment;

import java.io.Serializable;

import agentgui.simulationService.SimulationService;
import agentgui.simulationService.SimulationServiceHelper;
import agentgui.simulationService.time.TimeModel;

/**
 * This is the generalized environment model to use with the SimulationService.
 * 
 * @see SimulationService
 * 
 * @see SimulationServiceHelper#setEnvironmentModel(EnvironmentModel)
 * @see SimulationServiceHelper#stepSimulation(EnvironmentModel, int)
 * @see SimulationServiceHelper#stepSimulation(EnvironmentModel, int, boolean)
 * 
 * @author Christian Derksen - DAWIS - ICB - University of Duisburg - Essen
 */
public class EnvironmentModel implements Serializable {

	private static final long serialVersionUID = -2845036237763599630L;
	
	private boolean complexEnvironment = false;
	private String complexEnvironmentBase64 = null;
	
	private TimeModel timeModel = null;
	private Object abstractEnvironment = null;
	private Object displayEnvironment	= null;	
	

	
	/**
	 * Returns true if nothing is set yet (e.g. timeModel, abstractEnvironment or displayEnvironment)
	 * @return true, if is empty
	 */
	public boolean isEmpty() {
		if (timeModel==null && abstractEnvironment==null && displayEnvironment==null) {
			return true;
		} else {
			return false;	
		}	
	}
	
	/**
	 * Gets the time model.
	 * @return the timeModel
	 */
	public TimeModel getTimeModel() {
		return timeModel;
	}
	/**
	 * Sets the time model.
	 * @param timeModel the timeModel to set
	 */
	public void setTimeModel(TimeModel timeModel) {
		this.timeModel = timeModel;
	}
	
	/**
	 * Gets the abstract environment.
	 * @return the abstract environment
	 */
	public Object getAbstractEnvironment() {
		return abstractEnvironment;
	}
	/**
	 * Sets the abstract environment.
	 * @param newAbstractEnvironment the new abstract environment
	 */
	public void setAbstractEnvironment(Object newAbstractEnvironment) {
		this.abstractEnvironment = newAbstractEnvironment;
	}
	
	/**
	 * Gets the display environment.
	 * @return the display environment
	 */
	public Object getDisplayEnvironment() {
		return displayEnvironment;
	}
	/**
	 * Sets the display environment.
	 * @param displayEnvironment the new display environment
	 */
	public void setDisplayEnvironment(Object displayEnvironment) {
		this.displayEnvironment = displayEnvironment;
	}

	// --------------------------------------------------------------
	// ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   --
	// --------------------------------------------------------------
	/**
	 * Checks if is complex environment.
	 * @return the complexEnvironment
	 */
	public boolean isComplexEnvironment() {
		return complexEnvironment;
	}
	/**
	 * Sets, that the environment is complex and needs to be serialized by the JAVA on-board tools.
	 * @param complexEnvironment the complexEnvironment to set
	 */
	public void setComplexEnvironment(boolean complexEnvironment) {
		this.complexEnvironment = complexEnvironment;
	}

	/**
	 * Gets the complex environment base64.
	 * @return the complexEnvironmentBase64
	 */
	public String getComplexEnvironmentBase64() {
		return complexEnvironmentBase64;
	}
	/**
	 * Sets the complex environment coded as base64 String.
	 * @param complexEnvironmentBase64 the complexEnvironmentBase64 to set
	 */
	public void setComplexEnvironmentBase64(String complexEnvironmentBase64) {
		this.complexEnvironmentBase64 = complexEnvironmentBase64;
	}
	// --------------------------------------------------------------
	// ---   ---   ---   ---   ---   ---   ---   ---   ---   ---   --
	// --------------------------------------------------------------
}
