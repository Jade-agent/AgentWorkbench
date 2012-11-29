// file: GasGridOntology.java generated by ontology bean generator.  DO NOT EDIT, UNLESS YOU ARE REALLY SURE WHAT YOU ARE DOING!
package gasmas.ontology;

import jade.content.onto.*;
import jade.content.schema.*;
import jade.util.leap.HashMap;
import jade.content.lang.Codec;
import jade.core.CaseInsensitiveString;

/** file: GasGridOntology.java
 * @author ontology bean generator
 * @version 2012/10/24, 18:22:29
 */
public class GasGridOntology extends jade.content.onto.Ontology  {
  //NAME
  public static final String ONTOLOGY_NAME = "GasGrid";
  // The singleton instance of this ontology
  private static ReflectiveIntrospector introspect = new ReflectiveIntrospector();
  private static Ontology theInstance = new GasGridOntology();
  public static Ontology getInstance() {
     return theInstance;
  }


   // VOCABULARY
    public static final String CLUSTERNOTIFICATION="ClusterNotification";
    public static final String DIRECTIONSETTINGNOTIFICATION="DirectionSettingNotification";
    public static final String NOTIFICATION_NOTIFICATIONOBJECT="notificationObject";
    public static final String NOTIFICATION_REASON="reason";
    public static final String NOTIFICATION="Notification";
    public static final String SHORTPIPE="ShortPipe";
    public static final String VALUETYPE_VALUE="Value";
    public static final String VALUETYPE_UNIT="Unit";
    public static final String VALUETYPE="ValueType";
    public static final String FLOWPARAMETERS_MASSFLOW="massFlow";
    public static final String FLOWPARAMETERS_REYNOLDSNUMBER="reynoldsNumber";
    public static final String FLOWPARAMETERS_PRESSURE="pressure";
    public static final String FLOWPARAMETERS_FLOW="flow";
    public static final String FLOWPARAMETERS_TEMPERATURE="temperature";
    public static final String FLOWPARAMETERS_FLUIDVELOCITY="fluidVelocity";
    public static final String FLOWPARAMETERS="FlowParameters";
    public static final String GEOCOORDINATE_GEOY="geoY";
    public static final String GEOCOORDINATE_GEOX="geoX";
    public static final String GEOCOORDINATE_GEOW="geoW";
    public static final String GEOCOORDINATE_GEOZ="geoZ";
    public static final String GEOCOORDINATE="GeoCoordinate";
    public static final String HEATCAPACITYCOEFFICIENT_C="c";
    public static final String HEATCAPACITYCOEFFICIENT_A="a";
    public static final String HEATCAPACITYCOEFFICIENT_B="b";
    public static final String HEATCAPACITYCOEFFICIENT="HeatCapacityCoefficient";
    public static final String COMPRESSOR_PRESSURELOSSOUT="pressureLossOut";
    public static final String COMPRESSOR_FUELGASVERTEX="fuelGasVertex";
    public static final String COMPRESSOR_DRAGFACTORIN="dragFactorIn";
    public static final String COMPRESSOR_PRESSURELOSSIN="pressureLossIn";
    public static final String COMPRESSOR_PRESSUREINMIN="pressureInMin";
    public static final String COMPRESSOR_GASCOOLEREXISTING="gasCoolerExisting";
    public static final String COMPRESSOR_VALUE="value";
    public static final String COMPRESSOR_COOLEDOUTPUTTEMPERATURE="cooledOutputTemperature";
    public static final String COMPRESSOR_PRESSUREOUTMAX="pressureOutMax";
    public static final String COMPRESSOR_DRAGFACTOROUT="dragFactorOut";
    public static final String COMPRESSOR_DIAMETEROUT="diameterOut";
    public static final String COMPRESSOR_INTERNALBYPASSREQUIRED="internalBypassRequired";
    public static final String COMPRESSOR_FLOWDIRECTION="flowDirection";
    public static final String COMPRESSOR_DIAMETERIN="diameterIn";
    public static final String COMPRESSOR="Compressor";
    public static final String EXIT_FLOWMAX="flowMax";
    public static final String EXIT_FLOWMIN="flowMin";
    public static final String EXIT="Exit";
    public static final String VALVE_PRESSUREDIFFERENTIALMAX="pressureDifferentialMax";
    public static final String VALVE_VALUE="value";
    public static final String VALVE_FLOWDIRECTION="flowDirection";
    public static final String VALVE="Valve";
    public static final String INNODE_PRESSUREMIN="pressureMin";
    public static final String INNODE_PRESSUREMAX="pressureMax";
    public static final String INNODE_HEIGHT="height";
    public static final String INNODE_GEOCOORDINATE="geoCoordinate";
    public static final String INNODE="Innode";
    public static final String FLUIDPARAMETERS_THERMALCONDUCTIVITY="thermalConductivity";
    public static final String FLUIDPARAMETERS_KINEMATICVISCOSITY="kinematicViscosity";
    public static final String FLUIDPARAMETERS_DENSITY="density";
    public static final String FLUIDPARAMETERS_DYNAMICVISCOSITY="dynamicViscosity";
    public static final String FLUIDPARAMETERS="FluidParameters";
    public static final String CONTROLVALVE_PRESSUREOUTMAX="pressureOutMax";
    public static final String CONTROLVALVE_INCREASEDOUTPUTTEMPERATURE="increasedOutputTemperature";
    public static final String CONTROLVALVE_DRAGFACTOROUT="dragFactorOut";
    public static final String CONTROLVALVE_DIAMETEROUT="diameterOut";
    public static final String CONTROLVALVE_DRAGFACTORIN="dragFactorIn";
    public static final String CONTROLVALVE_PRESSURESET="pressureSet";
    public static final String CONTROLVALVE_INTERNALBYPASSREQUIRED="internalBypassRequired";
    public static final String CONTROLVALVE_PRESSUREINMIN="pressureInMin";
    public static final String CONTROLVALVE_GASPREHEHEATEREXISTING="gasPreheheaterExisting";
    public static final String CONTROLVALVE_PRESSUREDIFFERENTIALMIN="pressureDifferentialMin";
    public static final String CONTROLVALVE_DIAMETERIN="diameterIn";
    public static final String CONTROLVALVE="ControlValve";
    public static final String GRIDCOMPONENT_ALIAS="alias";
    public static final String GRIDCOMPONENT_ID="ID";
    public static final String GRIDCOMPONENT="GridComponent";
    public static final String CONNECTION_FLOWMAX="flowMax";
    public static final String CONNECTION_CURRENTFLOW="currentFlow";
    public static final String CONNECTION_FROM="from";
    public static final String CONNECTION_TO="to";
    public static final String CONNECTION_FLOWMIN="flowMin";
    public static final String CONNECTION="Connection";
    public static final String GASANALYSIS_GASCOMPONENTS="gasComponents";
    public static final String GASANALYSIS="GasAnalysis";
    public static final String PIPE_ROUGHNESS="roughness";
    public static final String PIPE_DIAMETER="Diameter";
    public static final String PIPE_PRESSUREMAX="pressureMax";
    public static final String PIPE_LENGTH="Length";
    public static final String PIPE_HEATTRANSFERCOEFFICIENT="heatTransferCoefficient";
    public static final String PIPE_LINEOFSIGHT="lineOfSight";
    public static final String PIPE="Pipe";
    public static final String BRANCH="Branch";
    public static final String ENTRY_CALORIFICVALUE="calorificValue";
    public static final String ENTRY_MOLARMASS="molarMass";
    public static final String ENTRY_HEATCAPACITYCOEFFICIENT="heatCapacityCoefficient";
    public static final String ENTRY_GASTEMPERATURE="gasTemperature";
    public static final String ENTRY_PSEUDOCRICALPRESSURE="pseudocricalPressure";
    public static final String ENTRY_PSEUDOCRITICALTEMPERATURE="pseudocriticalTemperature";
    public static final String ENTRY_NORMDENSITY="normDensity";
    public static final String ENTRY="Entry";
    public static final String RESISTOR_DIAMETER="Diameter";
    public static final String RESISTOR_DRAGFACTOR="dragFactor";
    public static final String RESISTOR_PRESSURELOSS="pressureLoss";
    public static final String RESISTOR="Resistor";
    public static final String STORAGE="Storage";

  /**
   * Constructor
  */
  private GasGridOntology(){ 
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try { 

    // adding Concept(s)
    ConceptSchema storageSchema = new ConceptSchema(STORAGE);
    add(storageSchema, gasmas.ontology.Storage.class);
    ConceptSchema resistorSchema = new ConceptSchema(RESISTOR);
    add(resistorSchema, gasmas.ontology.Resistor.class);
    ConceptSchema entrySchema = new ConceptSchema(ENTRY);
    add(entrySchema, gasmas.ontology.Entry.class);
    ConceptSchema branchSchema = new ConceptSchema(BRANCH);
    add(branchSchema, gasmas.ontology.Branch.class);
    ConceptSchema pipeSchema = new ConceptSchema(PIPE);
    add(pipeSchema, gasmas.ontology.Pipe.class);
    ConceptSchema gasAnalysisSchema = new ConceptSchema(GASANALYSIS);
    add(gasAnalysisSchema, gasmas.ontology.GasAnalysis.class);
    ConceptSchema connectionSchema = new ConceptSchema(CONNECTION);
    add(connectionSchema, gasmas.ontology.Connection.class);
    ConceptSchema gridComponentSchema = new ConceptSchema(GRIDCOMPONENT);
    add(gridComponentSchema, gasmas.ontology.GridComponent.class);
    ConceptSchema controlValveSchema = new ConceptSchema(CONTROLVALVE);
    add(controlValveSchema, gasmas.ontology.ControlValve.class);
    ConceptSchema fluidParametersSchema = new ConceptSchema(FLUIDPARAMETERS);
    add(fluidParametersSchema, gasmas.ontology.FluidParameters.class);
    ConceptSchema innodeSchema = new ConceptSchema(INNODE);
    add(innodeSchema, gasmas.ontology.Innode.class);
    ConceptSchema valveSchema = new ConceptSchema(VALVE);
    add(valveSchema, gasmas.ontology.Valve.class);
    ConceptSchema exitSchema = new ConceptSchema(EXIT);
    add(exitSchema, gasmas.ontology.Exit.class);
    ConceptSchema compressorSchema = new ConceptSchema(COMPRESSOR);
    add(compressorSchema, gasmas.ontology.Compressor.class);
    ConceptSchema heatCapacityCoefficientSchema = new ConceptSchema(HEATCAPACITYCOEFFICIENT);
    add(heatCapacityCoefficientSchema, gasmas.ontology.HeatCapacityCoefficient.class);
    ConceptSchema geoCoordinateSchema = new ConceptSchema(GEOCOORDINATE);
    add(geoCoordinateSchema, gasmas.ontology.GeoCoordinate.class);
    ConceptSchema flowParametersSchema = new ConceptSchema(FLOWPARAMETERS);
    add(flowParametersSchema, gasmas.ontology.FlowParameters.class);
    ConceptSchema valueTypeSchema = new ConceptSchema(VALUETYPE);
    add(valueTypeSchema, gasmas.ontology.ValueType.class);
    ConceptSchema shortPipeSchema = new ConceptSchema(SHORTPIPE);
    add(shortPipeSchema, gasmas.ontology.ShortPipe.class);

    // adding AgentAction(s)
    AgentActionSchema notificationSchema = new AgentActionSchema(NOTIFICATION);
    add(notificationSchema, gasmas.ontology.Notification.class);
    AgentActionSchema directionSettingNotificationSchema = new AgentActionSchema(DIRECTIONSETTINGNOTIFICATION);
    add(directionSettingNotificationSchema, gasmas.ontology.DirectionSettingNotification.class);
    AgentActionSchema clusterNotificationSchema = new AgentActionSchema(CLUSTERNOTIFICATION);
    add(clusterNotificationSchema, gasmas.ontology.ClusterNotification.class);

    // adding AID(s)

    // adding Predicate(s)


    // adding fields
    resistorSchema.add(RESISTOR_PRESSURELOSS, valueTypeSchema, ObjectSchema.OPTIONAL);
    resistorSchema.add(RESISTOR_DRAGFACTOR, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    resistorSchema.add(RESISTOR_DIAMETER, valueTypeSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_NORMDENSITY, valueTypeSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_PSEUDOCRITICALTEMPERATURE, valueTypeSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_PSEUDOCRICALPRESSURE, valueTypeSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_GASTEMPERATURE, valueTypeSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_HEATCAPACITYCOEFFICIENT, heatCapacityCoefficientSchema, ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_MOLARMASS, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    entrySchema.add(ENTRY_CALORIFICVALUE, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_LINEOFSIGHT, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_HEATTRANSFERCOEFFICIENT, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_LENGTH, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_PRESSUREMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_DIAMETER, valueTypeSchema, ObjectSchema.OPTIONAL);
    pipeSchema.add(PIPE_ROUGHNESS, valueTypeSchema, ObjectSchema.OPTIONAL);
    gasAnalysisSchema.add(GASANALYSIS_GASCOMPONENTS, (TermSchema)getSchema(BasicOntology.FLOAT), 0, ObjectSchema.UNLIMITED);
    connectionSchema.add(CONNECTION_FLOWMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    connectionSchema.add(CONNECTION_TO, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    connectionSchema.add(CONNECTION_FROM, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    connectionSchema.add(CONNECTION_CURRENTFLOW, flowParametersSchema, ObjectSchema.OPTIONAL);
    connectionSchema.add(CONNECTION_FLOWMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    gridComponentSchema.add(GRIDCOMPONENT_ID, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.MANDATORY);
    gridComponentSchema.add(GRIDCOMPONENT_ALIAS, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_DIAMETERIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_PRESSUREDIFFERENTIALMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_GASPREHEHEATEREXISTING, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_PRESSUREINMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_INTERNALBYPASSREQUIRED, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_PRESSURESET, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_DRAGFACTORIN, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_DIAMETEROUT, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_DRAGFACTOROUT, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_INCREASEDOUTPUTTEMPERATURE, valueTypeSchema, ObjectSchema.OPTIONAL);
    controlValveSchema.add(CONTROLVALVE_PRESSUREOUTMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    fluidParametersSchema.add(FLUIDPARAMETERS_DYNAMICVISCOSITY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    fluidParametersSchema.add(FLUIDPARAMETERS_DENSITY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    fluidParametersSchema.add(FLUIDPARAMETERS_KINEMATICVISCOSITY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    fluidParametersSchema.add(FLUIDPARAMETERS_THERMALCONDUCTIVITY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    innodeSchema.add(INNODE_GEOCOORDINATE, geoCoordinateSchema, ObjectSchema.OPTIONAL);
    innodeSchema.add(INNODE_HEIGHT, valueTypeSchema, ObjectSchema.OPTIONAL);
    innodeSchema.add(INNODE_PRESSUREMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    innodeSchema.add(INNODE_PRESSUREMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    valveSchema.add(VALVE_FLOWDIRECTION, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    valveSchema.add(VALVE_VALUE, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    valveSchema.add(VALVE_PRESSUREDIFFERENTIALMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    exitSchema.add(EXIT_FLOWMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    exitSchema.add(EXIT_FLOWMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_DIAMETERIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_FLOWDIRECTION, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_INTERNALBYPASSREQUIRED, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_DIAMETEROUT, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_DRAGFACTOROUT, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_PRESSUREOUTMAX, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_COOLEDOUTPUTTEMPERATURE, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_VALUE, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_GASCOOLEREXISTING, (TermSchema)getSchema(BasicOntology.BOOLEAN), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_PRESSUREINMIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_PRESSURELOSSIN, valueTypeSchema, ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_DRAGFACTORIN, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_FUELGASVERTEX, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    compressorSchema.add(COMPRESSOR_PRESSURELOSSOUT, valueTypeSchema, ObjectSchema.OPTIONAL);
    heatCapacityCoefficientSchema.add(HEATCAPACITYCOEFFICIENT_B, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    heatCapacityCoefficientSchema.add(HEATCAPACITYCOEFFICIENT_A, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    heatCapacityCoefficientSchema.add(HEATCAPACITYCOEFFICIENT_C, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    geoCoordinateSchema.add(GEOCOORDINATE_GEOZ, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    geoCoordinateSchema.add(GEOCOORDINATE_GEOW, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    geoCoordinateSchema.add(GEOCOORDINATE_GEOX, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    geoCoordinateSchema.add(GEOCOORDINATE_GEOY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_FLUIDVELOCITY, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_TEMPERATURE, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_FLOW, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_PRESSURE, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_REYNOLDSNUMBER, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    flowParametersSchema.add(FLOWPARAMETERS_MASSFLOW, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    valueTypeSchema.add(VALUETYPE_UNIT, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    valueTypeSchema.add(VALUETYPE_VALUE, (TermSchema)getSchema(BasicOntology.FLOAT), ObjectSchema.OPTIONAL);
    notificationSchema.add(NOTIFICATION_REASON, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    notificationSchema.add(NOTIFICATION_NOTIFICATIONOBJECT, new ConceptSchema("Concept"), ObjectSchema.OPTIONAL);

    // adding name mappings

    // adding inheritance
    storageSchema.addSuperSchema(entrySchema);
    resistorSchema.addSuperSchema(connectionSchema);
    entrySchema.addSuperSchema(exitSchema);
    branchSchema.addSuperSchema(gridComponentSchema);
    pipeSchema.addSuperSchema(connectionSchema);
    connectionSchema.addSuperSchema(gridComponentSchema);
    controlValveSchema.addSuperSchema(valveSchema);
    innodeSchema.addSuperSchema(gridComponentSchema);
    valveSchema.addSuperSchema(connectionSchema);
    exitSchema.addSuperSchema(innodeSchema);
    compressorSchema.addSuperSchema(connectionSchema);
    shortPipeSchema.addSuperSchema(connectionSchema);
    directionSettingNotificationSchema.addSuperSchema(notificationSchema);
    clusterNotificationSchema.addSuperSchema(notificationSchema);

   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }
