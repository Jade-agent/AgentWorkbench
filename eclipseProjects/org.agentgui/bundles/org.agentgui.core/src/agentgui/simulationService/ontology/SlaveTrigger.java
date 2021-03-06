package agentgui.simulationService.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: SlaveTrigger
* @author ontology bean generator
* @version 2017/12/6, 09:15:27
*/
public class SlaveTrigger implements AgentAction {

   /**
* Protege name: slaveBenchmarkValue
   */
   private BenchmarkResult slaveBenchmarkValue;
   public void setSlaveBenchmarkValue(BenchmarkResult value) { 
    this.slaveBenchmarkValue=value;
   }
   public BenchmarkResult getSlaveBenchmarkValue() {
     return this.slaveBenchmarkValue;
   }

   /**
* Protege name: slaveLoad
   */
   private PlatformLoad slaveLoad;
   public void setSlaveLoad(PlatformLoad value) { 
    this.slaveLoad=value;
   }
   public PlatformLoad getSlaveLoad() {
     return this.slaveLoad;
   }

   /**
* Protege name: triggerTime
   */
   private PlatformTime triggerTime;
   public void setTriggerTime(PlatformTime value) { 
    this.triggerTime=value;
   }
   public PlatformTime getTriggerTime() {
     return this.triggerTime;
   }

}
