package mas.projects.contmas.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
   * announces address of block, where designated container should be transported to
* Protege name: AssignBlockAddress
* @author ontology bean generator
* @version 2009/08/25, 14:09:14
*/
public class AssignBlockAddress implements AgentAction {

   /**
* Protege name: store_in
   */
   private BlockAddress store_in;
   public void setStore_in(BlockAddress value) { 
    this.store_in=value;
   }
   public BlockAddress getStore_in() {
     return this.store_in;
   }

}
