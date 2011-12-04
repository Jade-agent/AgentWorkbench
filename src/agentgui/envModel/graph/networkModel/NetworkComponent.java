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
package agentgui.envModel.graph.networkModel;

import java.io.Serializable;
import java.util.HashSet;

/**
 * This class represents a component of the modelled network. It contains
 * its' ontology representation, its' GraphElementPrototype, the nodes and
 * edges representing it in the environment graph and an ID for easier access. 
 * 
 * @see NetworkModel
 * 
 * @author Nils Loose - DAWIS - ICB University of Duisburg - Essen 
 */
public class NetworkComponent implements Serializable {
	
	private static final long serialVersionUID = 537431665305238609L;

	/** The NetworkComponent's ID */
	private String id;
	/** The NetworkComponent's type */
	private String type;
	/** The IDs of the nodes and edges that are part of this NetworkComponent */
	private HashSet<String> graphElementIDs;
	/** Specifies if the NetworkComponent is directed or undirected */
	private boolean directed;
	/** The NetworkComponent's GraphElementPrototype class name */
	private String prototypeClassName;
	/** The NetworkComponent's GraphElementPrototype class name */
	private String agentClassName;
	/** The ontology object instance representing this component, serialized as a base64 encoded String for saving via JAXB */
	private String encodedOntologyRepresentation;
	
	/**
	 * Default constructor
	 */
	public NetworkComponent(){
		graphElementIDs = new HashSet<String>();
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Returns the graph element IDs present in the component as a HashSet
	 * @return the graphElements
	 */
	public HashSet<String> getGraphElementIDs() {
		return graphElementIDs;
	}
	/**
	 * Sets the graph element IDs as a HashSet
	 * @param graphElementIDs the graphElements to set
	 */
	public void setGraphElementIDs(HashSet<String> graphElementIDs) {
		this.graphElementIDs = graphElementIDs;
	}
	/**
	 * @return the directed
	 */
	public boolean isDirected() {
		return directed;
	}
	/**
	 * @param directed the directed to set
	 */
	public void setDirected(boolean directed) {
		this.directed = directed;
	}
	
	/**
	 * Returns the graph element prototype class name
	 * @return the prototypeClassName
	 */
	public String getPrototypeClassName() {
		return prototypeClassName;
	}
	/**
	 * Sets the graph element prototype class name
	 * @param prototypeClassName the prototypeClassName to set
	 */
	public void setPrototypeClassName(String prototypeClassName) {
		this.prototypeClassName = prototypeClassName;
	}
	
	/**
	 * @return the agentClassName
	 */
	public String getAgentClassName() {
		return agentClassName;
	}
	/**
	 * @param agentClassName the agentClassName to set
	 */
	public void setAgentClassName(String agentClassName) {
		this.agentClassName = agentClassName;
	}
	
	/**
	 * @return the encodedOntologyRepresentation
	 */
	public String getEncodedOntologyRepresentation() {
		return encodedOntologyRepresentation;
	}
	/**
	 * @param encodedOntologyRepresentation the encodedOntologyRepresentation to set
	 */
	public void setEncodedOntologyRepresentation(String encodedOntologyRepresentation) {
		this.encodedOntologyRepresentation = encodedOntologyRepresentation;
	}
	
}
