package agentgui.simulationService.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: SlaveRegister
* @author ontology bean generator
* @version 2017/12/6, 09:15:27
*/
public class SlaveRegister implements AgentAction {

   /**
* Protege name: slaveVersion
   */
   private AgentGuiVersion slaveVersion;
   public void setSlaveVersion(AgentGuiVersion value) { 
    this.slaveVersion=value;
   }
   public AgentGuiVersion getSlaveVersion() {
     return this.slaveVersion;
   }

   /**
* Protege name: slaveOS
   */
   private OSInfo slaveOS;
   public void setSlaveOS(OSInfo value) { 
    this.slaveOS=value;
   }
   public OSInfo getSlaveOS() {
     return this.slaveOS;
   }

   /**
* Protege name: slaveAddress
   */
   private PlatformAddress slaveAddress;
   public void setSlaveAddress(PlatformAddress value) { 
    this.slaveAddress=value;
   }
   public PlatformAddress getSlaveAddress() {
     return this.slaveAddress;
   }

   /**
* Protege name: slavePerformance
   */
   private PlatformPerformance slavePerformance;
   public void setSlavePerformance(PlatformPerformance value) { 
    this.slavePerformance=value;
   }
   public PlatformPerformance getSlavePerformance() {
     return this.slavePerformance;
   }

   /**
* Protege name: slaveTime
   */
   private PlatformTime slaveTime;
   public void setSlaveTime(PlatformTime value) { 
    this.slaveTime=value;
   }
   public PlatformTime getSlaveTime() {
     return this.slaveTime;
   }

}
