package agentgui.simulationService.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: RemoteContainerConfig
* @author ontology bean generator
* @version 2012/07/23, 00:15:35
*/
public class RemoteContainerConfig implements Concept {

   /**
* Protege name: hostExcludeIP
   */
   private List hostExcludeIP = new ArrayList();
   public void addHostExcludeIP(String elem) { 
     List oldList = this.hostExcludeIP;
     hostExcludeIP.add(elem);
   }
   public boolean removeHostExcludeIP(String elem) {
     List oldList = this.hostExcludeIP;
     boolean result = hostExcludeIP.remove(elem);
     return result;
   }
   public void clearAllHostExcludeIP() {
     List oldList = this.hostExcludeIP;
     hostExcludeIP.clear();
   }
   public Iterator getAllHostExcludeIP() {return hostExcludeIP.iterator(); }
   public List getHostExcludeIP() {return hostExcludeIP; }
   public void setHostExcludeIP(List l) {hostExcludeIP = l; }

   /**
* Protege name: jadeHost
   */
   private String jadeHost;
   public void setJadeHost(String value) { 
    this.jadeHost=value;
   }
   public String getJadeHost() {
     return this.jadeHost;
   }

   /**
* Protege name: jadeIsRemoteContainer
   */
   private boolean jadeIsRemoteContainer;
   public void setJadeIsRemoteContainer(boolean value) { 
    this.jadeIsRemoteContainer=value;
   }
   public boolean getJadeIsRemoteContainer() {
     return this.jadeIsRemoteContainer;
   }

   /**
* Protege name: jadeShowGUI
   */
   private boolean jadeShowGUI;
   public void setJadeShowGUI(boolean value) { 
    this.jadeShowGUI=value;
   }
   public boolean getJadeShowGUI() {
     return this.jadeShowGUI;
   }

   /**
* Protege name: jadeJarIncludeList
   */
   private List jadeJarIncludeList = new ArrayList();
   public void addJadeJarIncludeList(String elem) { 
     List oldList = this.jadeJarIncludeList;
     jadeJarIncludeList.add(elem);
   }
   public boolean removeJadeJarIncludeList(String elem) {
     List oldList = this.jadeJarIncludeList;
     boolean result = jadeJarIncludeList.remove(elem);
     return result;
   }
   public void clearAllJadeJarIncludeList() {
     List oldList = this.jadeJarIncludeList;
     jadeJarIncludeList.clear();
   }
   public Iterator getAllJadeJarIncludeList() {return jadeJarIncludeList.iterator(); }
   public List getJadeJarIncludeList() {return jadeJarIncludeList; }
   public void setJadeJarIncludeList(List l) {jadeJarIncludeList = l; }

   /**
* Protege name: jadeServices
   */
   private String jadeServices;
   public void setJadeServices(String value) { 
    this.jadeServices=value;
   }
   public String getJadeServices() {
     return this.jadeServices;
   }

   /**
* Protege name: jadeContainerName
   */
   private String jadeContainerName;
   public void setJadeContainerName(String value) { 
    this.jadeContainerName=value;
   }
   public String getJadeContainerName() {
     return this.jadeContainerName;
   }

   /**
* Protege name: jvmMemAllocInitial
   */
   private String jvmMemAllocInitial;
   public void setJvmMemAllocInitial(String value) { 
    this.jvmMemAllocInitial=value;
   }
   public String getJvmMemAllocInitial() {
     return this.jvmMemAllocInitial;
   }

   /**
* Protege name: preventUsageOfUsedComputer
   */
   private boolean preventUsageOfUsedComputer;
   public void setPreventUsageOfUsedComputer(boolean value) { 
    this.preventUsageOfUsedComputer=value;
   }
   public boolean getPreventUsageOfUsedComputer() {
     return this.preventUsageOfUsedComputer;
   }

   /**
* Protege name: jadePort
   */
   private String jadePort;
   public void setJadePort(String value) { 
    this.jadePort=value;
   }
   public String getJadePort() {
     return this.jadePort;
   }

   /**
* Protege name: jvmMemAllocMaximum
   */
   private String jvmMemAllocMaximum;
   public void setJvmMemAllocMaximum(String value) { 
    this.jvmMemAllocMaximum=value;
   }
   public String getJvmMemAllocMaximum() {
     return this.jvmMemAllocMaximum;
   }

}
