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

/**
 * This class represents a graph edge in an environment model of the type graph / network 
 * 
 * @see GraphNode
 * @see GraphElement
 * 
 * @author Nils Loose - DAWIS - ICB University of Duisburg - Essen 
 *
 */
public class GraphEdge extends GraphElement {
	
	private static final long serialVersionUID = 1043215558300713661L;

	/**
	 * The type identifier of the network component represented by this edge
	 */
	private String componentType;
	/**
	 * The weight / costs of this edge / component
	 */
	private float weight;
	
	/**
	 * Constructor
	 * @param id The id of this GraphEdge
	 * @param componentType The component type identifier for this GraphEdge
	 */
	public GraphEdge(String id, String componentType) {
		super();
		this.id = id;
		this.componentType = componentType;
	}
	/**
	 * Gets the copy of the GraphNode.
	 * @return the copy
	 */
	public GraphEdge getCopy() {
		
		GraphEdge edgceCopy = new GraphEdge( new String(this.id), new String(this.componentType) ); 
		return edgceCopy;
	}
	
	/**
	 * @return the componentType
	 */
	public String getComponentType() {
		return componentType;
	}
	/**
	 * @param componentType the componentType to set
	 */
	public void setComponentType(String componentType) {
		this.componentType = componentType;
	}
	/**
	 * @return the weight
	 */
	public float getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
