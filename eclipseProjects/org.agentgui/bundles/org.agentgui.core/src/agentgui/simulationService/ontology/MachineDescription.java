package agentgui.simulationService.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: MachineDescription
* @author ontology bean generator
* @version 2017/12/6, 09:15:27
*/
public class MachineDescription implements Concept {

   /**
* Protege name: platformName
   */
   private String platformName;
   public void setPlatformName(String value) { 
    this.platformName=value;
   }
   public String getPlatformName() {
     return this.platformName;
   }

   /**
* Protege name: isAvailable
   */
   private boolean isAvailable;
   public void setIsAvailable(boolean value) { 
    this.isAvailable=value;
   }
   public boolean getIsAvailable() {
     return this.isAvailable;
   }

   /**
* Protege name: remoteOS
   */
   private OSInfo remoteOS;
   public void setRemoteOS(OSInfo value) { 
    this.remoteOS=value;
   }
   public OSInfo getRemoteOS() {
     return this.remoteOS;
   }

   /**
* Protege name: contactAgent
   */
   private String contactAgent;
   public void setContactAgent(String value) { 
    this.contactAgent=value;
   }
   public String getContactAgent() {
     return this.contactAgent;
   }

   /**
* Protege name: performance
   */
   private PlatformPerformance performance;
   public void setPerformance(PlatformPerformance value) { 
    this.performance=value;
   }
   public PlatformPerformance getPerformance() {
     return this.performance;
   }

   /**
* Protege name: isThresholdExceeded
   */
   private boolean isThresholdExceeded;
   public void setIsThresholdExceeded(boolean value) { 
    this.isThresholdExceeded=value;
   }
   public boolean getIsThresholdExceeded() {
     return this.isThresholdExceeded;
   }

   /**
* Protege name: platformAddress
   */
   private PlatformAddress platformAddress;
   public void setPlatformAddress(PlatformAddress value) { 
    this.platformAddress=value;
   }
   public PlatformAddress getPlatformAddress() {
     return this.platformAddress;
   }

   /**
* Protege name: benchmarkResult
   */
   private BenchmarkResult benchmarkResult;
   public void setBenchmarkResult(BenchmarkResult value) { 
    this.benchmarkResult=value;
   }
   public BenchmarkResult getBenchmarkResult() {
     return this.benchmarkResult;
   }

   /**
* Protege name: agentGuiVersion
   */
   private AgentGuiVersion agentGuiVersion;
   public void setAgentGuiVersion(AgentGuiVersion value) { 
    this.agentGuiVersion=value;
   }
   public AgentGuiVersion getAgentGuiVersion() {
     return this.agentGuiVersion;
   }

}
