/**
 * @author Hanno - Felix Wagner, 11.03.2010
 * Copyright 2010 Hanno - Felix Wagner
 * 
 * This file is part of ContMAS.
 *
 * ContMAS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ContMAS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with ContMAS.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package contmas.agents;

import contmas.behaviours.receiveLoadOrders;
import contmas.behaviours.striveForLoading;
import contmas.interfaces.TransportOrderHandler;
import contmas.ontology.Yard;

/**
 * @author Hanno - Felix Wagner
 *
 */
public class YardAgent extends StaticContainerAgent implements TransportOrderHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID= -3774026871349327373L;

	public YardAgent(){
		this(new Yard());
	}

	/**
	 * @param serviceType
	 * @param ontologyRepresentation
	 */
	public YardAgent(Yard ontologyRepresentation){
		super("container-storing",ontologyRepresentation);
		this.targetAgentServiceType="";
		this.targetAbstractDomain=null;
	}

	/* (non-Javadoc)
	 * @see contmas.agents.TransportOrderHandler#handleTransportOrder()
	 */
	@Override
	public void handleTransportOrder(){
		this.addBehaviour(new receiveLoadOrders(this));
	}

	@Override
	public void setup(){
		super.setup();
		this.handleTransportOrder();
		this.addBehaviour(new striveForLoading(this));

	}
}