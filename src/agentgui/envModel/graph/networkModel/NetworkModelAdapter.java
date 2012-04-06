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

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.undo.UndoManager;

import agentgui.envModel.graph.commands.MergeNetworkComponents;
import agentgui.envModel.graph.commands.MergeNetworkModel;
import agentgui.envModel.graph.commands.MoveGraphNodes;
import agentgui.envModel.graph.commands.RemoveNetworkComponent;
import agentgui.envModel.graph.commands.SetGeneralGraphSettings4MAS;
import agentgui.envModel.graph.commands.SetNetworkModel;
import agentgui.envModel.graph.commands.SplitNetworkComponent;
import agentgui.envModel.graph.controller.GeneralGraphSettings4MAS;
import agentgui.envModel.graph.controller.GraphEnvironmentController;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.VisualizationViewer;

/**
 * The Class NetworkModelAdapter is used for the action / interaction
 * with the NetworkModel in the context of the GUI.
 * 
 * @author Christian Derksen - DAWIS - ICB - University of Duisburg - Essen
 */
public class NetworkModelAdapter implements NetworkModelInterface {
	
	private GraphEnvironmentController graphController = null;
	private UndoManager undoManager = new UndoManager();
	
	/**
	 * Instantiates a new network model action.
	 * 
	 * @param controller the controller
	 */
	public NetworkModelAdapter(GraphEnvironmentController controller) {
		this.graphController=controller;
	}
	
	/**
	 * Notifies the connected observer of the GraphEnvironmentController.
	 * @param notification the notification
	 */
	private void notifyObservers(NetworkModelNotification notification) {
		this.graphController.notifyObservers(notification);
	}
	
	/**
	 * Returns the undo manager.
	 * @return the undoManager
	 */
	public UndoManager getUndoManager() {
		return undoManager;
	}
	/**
	 * Undo the last action.
	 */
	public void undo() {
		try {
			this.undoManager.undo();	
		} catch (Exception ex) {
			System.out.println("Can't undo");
			ex.printStackTrace();
		}
	}
	/**
	 * Redo's the last action, if possible.
	 */
	public void redo() {
		try {
			this.undoManager.redo();	
		} catch (Exception ex) {
			System.out.println("Can't redo");
			ex.printStackTrace();
		}
	}
	
	/**
	 * Returns the network model.
	 * @return the network model
	 */
	public NetworkModel getNetworkModel() {
		return this.graphController.getNetworkModel();
	}
	/**
	 * Sets a new network model.
	 * @param networkModel the new network model
	 */
	public void setNetworkModel(NetworkModel networkModel) {
		this.undoManager.addEdit(new SetNetworkModel(this.graphController, networkModel));
		this.graphController.setProjectUnsaved();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#setGeneralGraphSettings4MAS(agentgui.envModel.graph.controller.GeneralGraphSettings4MAS)
	 */
	@Override
	public void setGeneralGraphSettings4MAS(GeneralGraphSettings4MAS generalGraphSettings4MAS) {
		this.undoManager.addEdit(new SetGeneralGraphSettings4MAS(this.graphController, generalGraphSettings4MAS));
	}
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getGeneralGraphSettings4MAS()
	 */
	@Override
	public GeneralGraphSettings4MAS getGeneralGraphSettings4MAS() {
		return this.graphController.getNetworkModel().getGeneralGraphSettings4MAS();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#setAlternativeNetworkModel(java.util.HashMap)
	 */
	@Override
	public void setAlternativeNetworkModel(HashMap<String, NetworkModel> alternativeNetworkModel) {
		this.graphController.getNetworkModel().setAlternativeNetworkModel(alternativeNetworkModel);
	}
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getAlternativeNetworkModel()
	 */
	@Override
	public HashMap<String, NetworkModel> getAlternativeNetworkModel() {
		return this.graphController.getNetworkModel().getAlternativeNetworkModel();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getCopy()
	 */
	@Override
	public NetworkModel getCopy() {
		return this.graphController.getNetworkModel().getCopy();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponentsIDs(java.util.HashSet)
	 */
	@Override
	public HashSet<String> getNetworkComponentsIDs(HashSet<NetworkComponent> networkComponents) {
		return this.graphController.getNetworkModel().getNetworkComponentsIDs(networkComponents);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getGraphElement(java.lang.String)
	 */
	@Override
	public GraphElement getGraphElement(String id) {
		return this.graphController.getNetworkModel().getGraphElement(id);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getGraphElements()
	 */
	@Override
	public HashMap<String, GraphElement> getGraphElements() {
		return this.graphController.getNetworkModel().getGraphElements();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getGraphElementsFromNetworkComponent(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public Vector<GraphElement> getGraphElementsFromNetworkComponent(NetworkComponent networkComponent) {
		return this.graphController.getNetworkModel().getGraphElementsFromNetworkComponent(networkComponent);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getGraph()
	 */
	@Override
	public Graph<GraphNode, GraphEdge> getGraph() {
		return this.graphController.getNetworkModel().getGraph();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#setGraph(edu.uci.ics.jung.graph.Graph)
	 */
	@Override
	public void setGraph(Graph<GraphNode, GraphEdge> newGraph) {
		this.graphController.getNetworkModel().setGraph(newGraph);
	}

	/**
	 * Reloads the NetworModel.
	 */
	public void reLoadNetworkModel() {
		NetworkModelNotification notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Reload);
		this.notifyObservers(notification);
	}
	/**
	 * Refreshes the NetworkModel visualization.
	 */
	public void refreshNetworkModel() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Repaint);
		this.notifyObservers(notification);
	}
	
	/**
	 * Zoom fit to window.
	 */
	public void zoomFit2Window() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Zoom_Fit2Window);
		this.notifyObservers(notification);
	}
	/**
	 * Zoom to the original size.
	 */
	public void zoomOne2One() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Zoom_One2One);
		this.notifyObservers(notification);
	}
	/**
	 * Zoom in.
	 */
	public void zoomIn() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Zoom_In);
		this.notifyObservers(notification);
	}
	/**
	 * Zoom out.
	 */
	public void zoomOut() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Zoom_Out);
		this.notifyObservers(notification);
	}
	
	/**
	 * Save the current graph as image.
	 */
	public void saveAsImage() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_ExportGraphAsImage);
		this.notifyObservers(notification);
	}
	
	/**
	 * Sets the graph mouse to transforming mode.
	 */
	public void setGraphMouseTransforming(){
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_GraphMouse_Transforming);
		this.notifyObservers(notification);
	}
	/**
	 * Sets the graph mouse to picking mode.
	 */
	public void setGraphMousePicking() {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_GraphMouse_Picking);
		this.notifyObservers(notification);
	}
	
	/**
	 * Can be used in order to select a NetworkComponent.
	 * @param networkComponent the network component
	 */
	public void selectNetworkComponent(NetworkComponent networkComponent) {
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Component_Select);
		notification.setInfoObject(networkComponent);
		this.notifyObservers(notification);
	}
	
	/**
	 * Clears the current NetworModel.
	 */
	public void clearNetworkModel() {
		this.graphController.setEnvironmentModel(null);
		this.graphController.getAgents2Start().clear();
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#addNetworkComponent(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public NetworkComponent addNetworkComponent(NetworkComponent networkComponent) {
		
		NetworkComponent newComponent = this.graphController.getNetworkModel().addNetworkComponent(networkComponent); 
		this.graphController.addAgent(networkComponent);
		
		NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Component_Added);
		notification.setInfoObject(newComponent);
		this.notifyObservers(notification);

		return newComponent;
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#renameComponent(java.lang.String, java.lang.String)
	 */
	@Override
	public void renameComponent(String oldCompID, String newCompID) {
		this.graphController.getNetworkModel().renameComponent(oldCompID, newCompID);
		this.graphController.renameAgent(oldCompID, newCompID);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#removeNetworkComponent(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public void removeNetworkComponent(NetworkComponent networkComponent) {
		HashSet<NetworkComponent> compHash = new HashSet<NetworkComponent>();
		compHash.add(networkComponent);
		this.removeNetworkComponents(compHash);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#removeNetworkComponents(java.util.HashSet)
	 */
	@Override
	public void removeNetworkComponents(HashSet<NetworkComponent> networkComponents) {
		this.undoManager.addEdit(new RemoveNetworkComponent(this.graphController, networkComponents));
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#removeNetworkComponentsInverse(java.util.HashSet)
	 */
	@Override
	public HashSet<NetworkComponent> removeNetworkComponentsInverse(HashSet<NetworkComponent> networkComponents) {
		
		HashSet<NetworkComponent> removedComponents = this.graphController.getNetworkModel().removeNetworkComponentsInverse(networkComponents);
		for (NetworkComponent networkComponent : removedComponents) {
			
			this.graphController.removeAgent(networkComponent);
			
			NetworkModelNotification  notification = new NetworkModelNotification(NetworkModelNotification.NETWORK_MODEL_Component_Removed);
			notification.setInfoObject(networkComponent);
			this.notifyObservers(notification);
		}
		return removedComponents;
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#adjustNameDefinitionsOfSupplementNetworkModel(agentgui.envModel.graph.networkModel.NetworkModel)
	 */
	public NetworkModel adjustNameDefinitionsOfSupplementNetworkModel(NetworkModel supplementNetworkModel) {
		return this.graphController.getNetworkModel().adjustNameDefinitionsOfSupplementNetworkModel(supplementNetworkModel);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#mergeClusters(agentgui.envModel.graph.networkModel.ClusterNetworkComponent, agentgui.envModel.graph.networkModel.ClusterNetworkComponent)
	 */
	public void mergeClusters(ClusterNetworkComponent clusterNC, ClusterNetworkComponent supplementNC) {
		this.graphController.getNetworkModel().mergeClusters(clusterNC, supplementNC);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#mergeNetworkModel(agentgui.envModel.graph.networkModel.NetworkModel, agentgui.envModel.graph.networkModel.GraphNode, agentgui.envModel.graph.networkModel.GraphNode)
	 */
	public void mergeNetworkModel(NetworkModel supplementNetworkModel, GraphNodePairs node2Merge) {
		this.undoManager.addEdit(new MergeNetworkModel(this.graphController, supplementNetworkModel, node2Merge));
	}
	
	/**
	 * Gets the valid configuration for a GraphNodePair, that can be used for merging nodes.
	 *
	 * @param graphNodePairs the graph node pairs
	 * @return the valid GraphNodePair for merging couples of GraphNodes
	 */
	public GraphNodePairs getValidGraphNodePairConfig4Merging(GraphNodePairs graphNodePairs) {
		return this.graphController.getNetworkModel().getValidGraphNodePairConfig4Merging(graphNodePairs);
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#mergeNodes(agentgui.envModel.graph.networkModel.GraphNode, agentgui.envModel.graph.networkModel.GraphNode)
	 */
	@Override
	public void mergeNodes(GraphNodePairs nodes2Merge) {
		this.undoManager.addEdit(new MergeNetworkComponents(this.graphController, nodes2Merge));
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#splitNetworkModelAtNode(agentgui.envModel.graph.networkModel.GraphNode)
	 */
	@Override
	public void splitNetworkModelAtNode(GraphNode node2SplitAt) {
		this.undoManager.addEdit(new SplitNetworkComponent(this.graphController, node2SplitAt, true));
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#splitNetworkModelAtNode(agentgui.envModel.graph.networkModel.GraphNode, boolean)
	 */
	@Override
	public void splitNetworkModelAtNode(GraphNode node2SplitAt, boolean moveOppositeNode) {
		this.undoManager.addEdit(new SplitNetworkComponent(this.graphController, node2SplitAt, moveOppositeNode));
	}
	
	/**
	 * Sets the movement of GraphNodes to the undoManager.
	 * @param nodesMovedOldPostions the old positions of the moved GraphNodes 
	 */
	public void setGraphNodesMoved(VisualizationViewer<GraphNode,GraphEdge> visViewer, HashMap<String, Point2D> nodesMovedOldPositions) {
		this.undoManager.addEdit(new MoveGraphNodes(this.graphController, visViewer, nodesMovedOldPositions));
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNodesFromNetworkComponent(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public Vector<GraphNode> getNodesFromNetworkComponent(NetworkComponent networkComponent) {
		return this.graphController.getNetworkModel().getNodesFromNetworkComponent(networkComponent);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponent(java.lang.String)
	 */
	@Override
	public NetworkComponent getNetworkComponent(String id) {
		return this.graphController.getNetworkModel().getNetworkComponent(id);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNeighbourNetworkComponents(java.util.HashSet)
	 */
	@Override
	public HashSet<NetworkComponent> getNeighbourNetworkComponents(HashSet<NetworkComponent> networkComponents) {
		return this.graphController.getNetworkModel().getNeighbourNetworkComponents(networkComponents);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNeighbourNetworkComponents(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public Vector<NetworkComponent> getNeighbourNetworkComponents(NetworkComponent networkComponent) {
		return this.graphController.getNetworkModel().getNeighbourNetworkComponents(networkComponent);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponent(agentgui.envModel.graph.networkModel.GraphEdge)
	 */
	@Override
	public NetworkComponent getNetworkComponent(GraphEdge graphEdge) {
		return this.graphController.getNetworkModel().getNetworkComponent(graphEdge);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponents(java.util.Set)
	 */
	@Override
	public HashSet<NetworkComponent> getNetworkComponents(Set<GraphNode> graphNodes) {
		return this.graphController.getNetworkModel().getNetworkComponents(graphNodes);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponentsFullySelected(java.util.Set)
	 */
	@Override
	public HashSet<NetworkComponent> getNetworkComponentsFullySelected(Set<GraphNode> graphNodes) {
		return this.graphController.getNetworkModel().getNetworkComponentsFullySelected(graphNodes);
	}
	
	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponents(agentgui.envModel.graph.networkModel.GraphNode)
	 */
	@Override
	public HashSet<NetworkComponent> getNetworkComponents(GraphNode graphNode) {
		return this.graphController.getNetworkModel().getNetworkComponents(graphNode);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponents()
	 */
	@Override
	public HashMap<String, NetworkComponent> getNetworkComponents() {
		return this.graphController.getNetworkModel().getNetworkComponents();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#setNetworkComponents(java.util.HashMap)
	 */
	@Override
	public void setNetworkComponents(HashMap<String, NetworkComponent> networkComponents) {
		this.graphController.getNetworkModel().setNetworkComponents(networkComponents);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#nextNetworkComponentID()
	 */
	@Override
	public String nextNetworkComponentID() {
		return this.graphController.getNetworkModel().nextNetworkComponentID();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#nextNodeID()
	 */
	@Override
	public String nextNodeID() {
		return this.graphController.getNetworkModel().nextNodeID();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getShiftedPosition(agentgui.envModel.graph.networkModel.GraphNode, agentgui.envModel.graph.networkModel.GraphNode)
	 */
	@Override
	public Point2D getShiftedPosition(GraphNode fixedNode, GraphNode shiftNode) {
		return this.graphController.getNetworkModel().getShiftedPosition(fixedNode, shiftNode);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getNetworkComponentVectorWithDistributionNodeAsLast(java.util.HashSet)
	 */
	@Override
	public Vector<NetworkComponent> getNetworkComponentVectorWithDistributionNodeAsLast(HashSet<NetworkComponent> componentVector) {
		return this.graphController.getNetworkModel().getNetworkComponentVectorWithDistributionNodeAsLast(componentVector);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#containsDistributionNode(java.util.HashSet)
	 */
	@Override
	public NetworkComponent containsDistributionNode(HashSet<NetworkComponent> components) {
		return this.graphController.getNetworkModel().containsDistributionNode(components);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getClusterComponents()
	 */
	@Override
	public ArrayList<ClusterNetworkComponent> getClusterComponents() {
		return this.graphController.getNetworkModel().getClusterComponents();
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getClusterComponents(java.util.Collection)
	 */
	@Override
	public ArrayList<ClusterNetworkComponent> getClusterComponents(Collection<NetworkComponent> components) {
		return this.graphController.getNetworkModel().getClusterComponents(components);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#isStarGraphElement(agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public boolean isStarGraphElement(NetworkComponent comp) {
		return this.graphController.getNetworkModel().isStarGraphElement(comp);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#isCenterNodeOfStar(agentgui.envModel.graph.networkModel.GraphNode, agentgui.envModel.graph.networkModel.NetworkComponent)
	 */
	@Override
	public boolean isCenterNodeOfStar(GraphNode node, NetworkComponent comp) {
		return this.graphController.getNetworkModel().isCenterNodeOfStar(node, comp);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#isFreeGraphNode(agentgui.envModel.graph.networkModel.GraphNode)
	 */
	@Override
	public boolean isFreeGraphNode(GraphNode graphNode) {
		return this.graphController.getNetworkModel().isFreeGraphNode(graphNode);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#replaceComponentsByCluster(java.util.HashSet)
	 */
	@Override
	public ClusterNetworkComponent replaceComponentsByCluster(HashSet<NetworkComponent> networkComponents) {
		return this.graphController.getNetworkModel().replaceComponentsByCluster(networkComponents);
	}

	/*
	 * (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#replaceClusterByComponents()
	 */
	public void replaceClusterByComponents(ClusterNetworkComponent clusterNetworkComponent) {
		this.graphController.getNetworkModel().replaceClusterByComponents(clusterNetworkComponent);
	}

	/* (non-Javadoc)
	 * @see agentgui.envModel.graph.networkModel.NetworkModelInterface#getOuterNetworkComponentIDs()
	 */
	@Override
	public ArrayList<String> getOuterNetworkComponentIDs() {
		return this.graphController.getNetworkModel().getOuterNetworkComponentIDs();
	}

}