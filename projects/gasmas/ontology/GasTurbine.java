package gasmas.ontology;

import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: GasTurbine
* @author ontology bean generator
* @version 2013/02/22, 16:57:41
*/
public class GasTurbine extends CompStatDrive{ 

   /**
* Protege name: gtPowerFunCoeff
   */
   private Calc9Parameter gtPowerFunCoeff;
   public void setGtPowerFunCoeff(Calc9Parameter value) { 
    this.gtPowerFunCoeff=value;
   }
   public Calc9Parameter getGtPowerFunCoeff() {
     return this.gtPowerFunCoeff;
   }

   /**
* Protege name: gtMaximalPowerMeasurements
   */
   private List gtMaximalPowerMeasurements = new ArrayList();
   public void addGtMaximalPowerMeasurements(CompStatMaxPtoAmbientTemperature elem) { 
     List oldList = this.gtMaximalPowerMeasurements;
     gtMaximalPowerMeasurements.add(elem);
   }
   public boolean removeGtMaximalPowerMeasurements(CompStatMaxPtoAmbientTemperature elem) {
     List oldList = this.gtMaximalPowerMeasurements;
     boolean result = gtMaximalPowerMeasurements.remove(elem);
     return result;
   }
   public void clearAllGtMaximalPowerMeasurements() {
     List oldList = this.gtMaximalPowerMeasurements;
     gtMaximalPowerMeasurements.clear();
   }
   public Iterator getAllGtMaximalPowerMeasurements() {return gtMaximalPowerMeasurements.iterator(); }
   public List getGtMaximalPowerMeasurements() {return gtMaximalPowerMeasurements; }
   public void setGtMaximalPowerMeasurements(List l) {gtMaximalPowerMeasurements = l; }

   /**
* Protege name: gtSpecificEnergyConsumptionMeasurements
   */
   private List gtSpecificEnergyConsumptionMeasurements = new ArrayList();
   public void addGtSpecificEnergyConsumptionMeasurements(CompStatSECmeasurment elem) { 
     List oldList = this.gtSpecificEnergyConsumptionMeasurements;
     gtSpecificEnergyConsumptionMeasurements.add(elem);
   }
   public boolean removeGtSpecificEnergyConsumptionMeasurements(CompStatSECmeasurment elem) {
     List oldList = this.gtSpecificEnergyConsumptionMeasurements;
     boolean result = gtSpecificEnergyConsumptionMeasurements.remove(elem);
     return result;
   }
   public void clearAllGtSpecificEnergyConsumptionMeasurements() {
     List oldList = this.gtSpecificEnergyConsumptionMeasurements;
     gtSpecificEnergyConsumptionMeasurements.clear();
   }
   public Iterator getAllGtSpecificEnergyConsumptionMeasurements() {return gtSpecificEnergyConsumptionMeasurements.iterator(); }
   public List getGtSpecificEnergyConsumptionMeasurements() {return gtSpecificEnergyConsumptionMeasurements; }
   public void setGtSpecificEnergyConsumptionMeasurements(List l) {gtSpecificEnergyConsumptionMeasurements = l; }

}
