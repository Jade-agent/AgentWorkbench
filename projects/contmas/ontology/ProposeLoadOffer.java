package contmas.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: ProposeLoadOffer
* @author ontology bean generator
* @version 2010/06/9, 14:40:33
*/
public class ProposeLoadOffer implements AgentAction {

   /**
* Protege name: load_offer
   */
   private TransportOrder load_offer;
   public void setLoad_offer(TransportOrder value) { 
    this.load_offer=value;
   }
   public TransportOrder getLoad_offer() {
     return this.load_offer;
   }

   /**
* Protege name: corresponds_to
   */
   private TransportOrderChain corresponds_to;
   public void setCorresponds_to(TransportOrderChain value) { 
    this.corresponds_to=value;
   }
   public TransportOrderChain getCorresponds_to() {
     return this.corresponds_to;
   }

}
