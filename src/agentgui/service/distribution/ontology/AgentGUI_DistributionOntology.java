// file: AgentGUI_DistributionOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package mas.service.distribution.ontology;

import jade.content.onto.*;
import jade.content.schema.*;
import jade.util.leap.HashMap;
import jade.content.lang.Codec;
import jade.core.CaseInsensitiveString;

/** file: AgentGUI_DistributionOntology.java
 * @author ontology bean generator
 * @version 2010/09/2, 16:06:42
 */
public class AgentGUI_DistributionOntology extends jade.content.onto.Ontology  {
  //NAME
  public static final String ONTOLOGY_NAME = "AgentGUI-Distribution";
  // The singleton instance of this ontology
  private static ReflectiveIntrospector introspect = new ReflectiveIntrospector();
  private static Ontology theInstance = new AgentGUI_DistributionOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String CLIENTUNREGISTER="ClientUnregister";
    public static final String CLIENTREGISTER_CLIENTPERFORMANCE="clientPerformance";
    public static final String CLIENTREGISTER_CLIENTADDRESS="clientAddress";
    public static final String CLIENTREGISTER_CLIENTTIME="clientTime";
    public static final String CLIENTREGISTER="ClientRegister";
    public static final String CONTAINERLOADINFORM_CURRENTLOAD="currentLoad";
    public static final String CONTAINERLOADINFORM_CONTAINERNAME="containerName";
    public static final String CONTAINERLOADINFORM="ContainerLoadInform";
    public static final String SLAVEREGISTER_SLAVETIME="slaveTime";
    public static final String SLAVEREGISTER_SLAVEADDRESS="slaveAddress";
    public static final String SLAVEREGISTER_SLAVEPERFORMANCE="slavePerformance";
    public static final String SLAVEREGISTER="SlaveRegister";
    public static final String CLIENTREMOTECONTAINERREQUEST_REMOTECONFIG="RemoteConfig";
    public static final String CLIENTREMOTECONTAINERREQUEST="ClientRemoteContainerRequest";
    public static final String SLAVEUNREGISTER="SlaveUnregister";
    public static final String SLAVETRIGGER_TRIGGERTIME="triggerTime";
    public static final String SLAVETRIGGER="SlaveTrigger";
    public static final String PLATFORMTIME_TIMESTAMPASSTRING="TimeStampAsString";
    public static final String PLATFORMTIME="PlatformTime";
    public static final String PLATFORMLOAD_LOADEXCEEDED="loadExceeded";
    public static final String PLATFORMLOAD_LOADCPU="loadCPU";
    public static final String PLATFORMLOAD_LOADNOTHREADS="loadNoThreads";
    public static final String PLATFORMLOAD_LOADMEMORY="loadMemory";
    public static final String PLATFORMLOAD="PlatformLoad";
    public static final String PLATFORMADDRESS_PORT="port";
    public static final String PLATFORMADDRESS_URL="url";
    public static final String PLATFORMADDRESS_HTTP4MTP="http4mtp";
    public static final String PLATFORMADDRESS_IP="ip";
    public static final String PLATFORMADDRESS="PlatformAddress";
    public static final String REMOTECONTAINERCONFIG_JADEHOST="jadeHost";
    public static final String REMOTECONTAINERCONFIG_JADEPORT="jadePort";
    public static final String REMOTECONTAINERCONFIG_JADECONTAINERNAME="jadeContainerName";
    public static final String REMOTECONTAINERCONFIG_JADESERVICES="jadeServices";
    public static final String REMOTECONTAINERCONFIG_JADEISREMOTECONTAINER="jadeIsRemoteContainer";
    public static final String REMOTECONTAINERCONFIG_JADESHOWGUI="jadeShowGUI";
    public static final String REMOTECONTAINERCONFIG_JVMMEMALLOCINITIAL="jvmMemAllocInitial";
    public static final String REMOTECONTAINERCONFIG_JVMMEMALLOCMAXIMUM="jvmMemAllocMaximum";
    public static final String REMOTECONTAINERCONFIG="RemoteContainerConfig";
    public static final String PLATFORMPERFORMANCE_CPU_NUMBEROF="cpu_numberOf";
    public static final String PLATFORMPERFORMANCE_CPU_MODEL="cpu_model";
    public static final String PLATFORMPERFORMANCE_MEMORY_TOTALMB="memory_totalMB";
    public static final String PLATFORMPERFORMANCE_CPU_SPEEDMHZ="cpu_speedMhz";
    public static final String PLATFORMPERFORMANCE_CPU_VENDOR="cpu_vendor";
    public static final String PLATFORMPERFORMANCE="PlatformPerformance";

  /**
   * Constructor
  */
  private AgentGUI_DistributionOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema platformPerformanceSchema = new ConceptSchema(PLATFORMPERFORMANCE);
    add(platformPerformanceSchema, mas.service.distribution.ontology.PlatformPerformance.class);
    ConceptSchema remoteContainerConfigSchema = new ConceptSchema(REMOTECONTAINERCONFIG);
    add(remoteContainerConfigSchema, mas.service.distribution.ontology.RemoteContainerConfig.class);
    ConceptSchema platformAddressSchema = new ConceptSchema(PLATFORMADDRESS);
    add(platformAddressSchema, mas.service.distribution.ontology.PlatformAddress.class);
    ConceptSchema platformLoadSchema = new ConceptSchema(PLATFORMLOAD);
    add(platformLoadSchema, mas.service.distribution.ontology.PlatformLoad.class);
    ConceptSchema platformTimeSchema = new ConceptSchema(PLATFORMTIME);
    add(platformTimeSchema, mas.service.distribution.ontology.PlatformTime.class);

    // adding AgentAction(s)
    AgentActionSchema slaveTriggerSchema = new AgentActionSchema(SLAVETRIGGER);
    add(slaveTriggerSchema, mas.service.distribution.ontology.SlaveTrigger.class);
    AgentActionSchema slaveUnregisterSchema = new AgentActionSchema(SLAVEUNREGISTER);
    add(slaveUnregisterSchema, mas.service.distribution.ontology.SlaveUnregister.class);
    AgentActionSchema clientRemoteContainerRequestSchema = new AgentActionSchema(CLIENTREMOTECONTAINERREQUEST);
    add(clientRemoteContainerRequestSchema, mas.service.distribution.ontology.ClientRemoteContainerRequest.class);
    AgentActionSchema slaveRegisterSchema = new AgentActionSchema(SLAVEREGISTER);
    add(slaveRegisterSchema, mas.service.distribution.ontology.SlaveRegister.class);
    AgentActionSchema containerLoadInformSchema = new AgentActionSchema(CONTAINERLOADINFORM);
    add(containerLoadInformSchema, mas.service.distribution.ontology.ContainerLoadInform.class);
    AgentActionSchema clientRegisterSchema = new AgentActionSchema(CLIENTREGISTER);
    add(clientRegisterSchema, mas.service.distribution.ontology.ClientRegister.class);
    AgentActionSchema clientUnregisterSchema = new AgentActionSchema(CLIENTUNREGISTER);
    add(clientUnregisterSchema, mas.service.distribution.ontology.ClientUnregister.class);

    // adding AID(s)

    // adding Predicate(s)


    // adding fields
    platformPerformanceSchema.add(PLATFORMPERFORMANCE_CPU_VENDOR, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformPerformanceSchema.add(PLATFORMPERFORMANCE_CPU_SPEEDMHZ, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    platformPerformanceSchema.add(PLATFORMPERFORMANCE_MEMORY_TOTALMB, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    platformPerformanceSchema.add(PLATFORMPERFORMANCE_CPU_MODEL, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformPerformanceSchema.add(PLATFORMPERFORMANCE_CPU_NUMBEROF, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JVMMEMALLOCMAXIMUM, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JVMMEMALLOCINITIAL, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADESHOWGUI, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADEISREMOTECONTAINER, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADESERVICES, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADECONTAINERNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADEPORT, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    remoteContainerConfigSchema.add(REMOTECONTAINERCONFIG_JADEHOST, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformAddressSchema.add(PLATFORMADDRESS_IP, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformAddressSchema.add(PLATFORMADDRESS_HTTP4MTP, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformAddressSchema.add(PLATFORMADDRESS_URL, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    platformAddressSchema.add(PLATFORMADDRESS_PORT, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    platformLoadSchema.add(PLATFORMLOAD_LOADMEMORY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    platformLoadSchema.add(PLATFORMLOAD_LOADNOTHREADS, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    platformLoadSchema.add(PLATFORMLOAD_LOADCPU, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    platformLoadSchema.add(PLATFORMLOAD_LOADEXCEEDED, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    platformTimeSchema.add(PLATFORMTIME_TIMESTAMPASSTRING, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    slaveTriggerSchema.add(SLAVETRIGGER_TRIGGERTIME, platformTimeSchema, ObjectSchema.OPTIONAL);
    clientRemoteContainerRequestSchema.add(CLIENTREMOTECONTAINERREQUEST_REMOTECONFIG, remoteContainerConfigSchema, ObjectSchema.OPTIONAL);
    slaveRegisterSchema.add(SLAVEREGISTER_SLAVEPERFORMANCE, platformPerformanceSchema, ObjectSchema.OPTIONAL);
    slaveRegisterSchema.add(SLAVEREGISTER_SLAVEADDRESS, platformAddressSchema, ObjectSchema.OPTIONAL);
    slaveRegisterSchema.add(SLAVEREGISTER_SLAVETIME, platformTimeSchema, ObjectSchema.OPTIONAL);
    containerLoadInformSchema.add(CONTAINERLOADINFORM_CONTAINERNAME, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    containerLoadInformSchema.add(CONTAINERLOADINFORM_CURRENTLOAD, platformLoadSchema, ObjectSchema.OPTIONAL);
    clientRegisterSchema.add(CLIENTREGISTER_CLIENTTIME, platformTimeSchema, ObjectSchema.OPTIONAL);
    clientRegisterSchema.add(CLIENTREGISTER_CLIENTADDRESS, platformAddressSchema, ObjectSchema.OPTIONAL);
    clientRegisterSchema.add(CLIENTREGISTER_CLIENTPERFORMANCE, platformPerformanceSchema, ObjectSchema.OPTIONAL);

    // adding name mappings

    // adding inheritance

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }
