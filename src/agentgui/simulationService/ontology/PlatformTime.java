package agentgui.simulationService.ontology;


import jade.content.*;
import jade.util.leap.*;
import jade.core.*;

/**
* Protege name: PlatformTime
* @author ontology bean generator
* @version 2010/11/17, 22:51:09
*/
public class PlatformTime implements Concept {

   /**
* Protege name: TimeStampAsString
   */
   private String timeStampAsString;
   public void setTimeStampAsString(String value) { 
    this.timeStampAsString=value;
   }
   public String getTimeStampAsString() {
     return this.timeStampAsString;
   }

}
