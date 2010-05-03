/**
 * @author Hanno - Felix Wagner Copyright 2010 Hanno - Felix Wagner This file is
 *         part of ContMAS. ContMAS is free software: you can redistribute it
 *         and/or modify it under the terms of the GNU Lesser General Public
 *         License as published by the Free Software Foundation, either version
 *         3 of the License, or (at your option) any later version. ContMAS is
 *         distributed in the hope that it will be useful, but WITHOUT ANY
 *         WARRANTY; without even the implied warranty of MERCHANTABILITY or
 *         FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 *         License for more details. You should have received a copy of the GNU
 *         Lesser General Public License along with ContMAS. If not, see
 *         <http://www.gnu.org/licenses/>.
 */

package contmas.behaviours;

import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.proto.AchieveREResponder;
import contmas.agents.ContainerAgent;
import contmas.agents.HarborMasterAgent;
import contmas.main.MatchAgentAction;
import contmas.ontology.ProvideHarbourSetup;
import contmas.ontology.RequestHarbourSetup;

public class listenForHarbourAreaReq extends AchieveREResponder{
	private static final long serialVersionUID= -4440040520781720185L;

	private static MessageTemplate createMessageTemplate(Agent a){
		MessageTemplate mt=AchieveREResponder.createMessageTemplate(FIPANames.InteractionProtocol.FIPA_REQUEST);
		mt=MessageTemplate.and(mt,new MessageTemplate(new MatchAgentAction(a,new RequestHarbourSetup())));
		return mt;
	}

	public listenForHarbourAreaReq(Agent a){
		super(a,listenForHarbourAreaReq.createMessageTemplate(a));
	}

	@Override
	protected ACLMessage handleRequest(ACLMessage request){
		ACLMessage reply=request.createReply();
		reply.setPerformative(ACLMessage.INFORM);
		ProvideHarbourSetup act=new ProvideHarbourSetup();

		act.setCurrent_harbour_layout(((HarborMasterAgent) this.myAgent).getHarbourArea());

		((ContainerAgent) this.myAgent).fillMessage(reply,act);
		return reply;

	}

	@Override
	protected ACLMessage prepareResultNotification(ACLMessage request,ACLMessage response){
		return null;
	}
}