package agentgui.core.sim.setup;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import agentgui.core.agents.AgentClassElement4SimStart;
import agentgui.core.application.Project;
import agentgui.graphEnvironment.controller.GraphElementSettings;

@XmlRootElement public class SimulationSetup {

	@XmlTransient private Project currProject = null;	
	@XmlTransient private DefaultListModel agentListModel = null;	
	
	@XmlElementWrapper(name = "agentSetup")
	@XmlElement(name="agent")
	private ArrayList<AgentClassElement4SimStart> agentList = new ArrayList<AgentClassElement4SimStart>();

	@XmlElement(name="distribution")
	public DistributionSetup distributionSetup = new DistributionSetup();
	
	private String environmentFileName = null;
	private String svgFileName = null;
	
	private HashMap<String, GraphElementSettings> graphElementSettings;
	
	/**
	 * @return the elementTypeSettings
	 */
	public HashMap<String, GraphElementSettings> getGraphElementSettings() {
		return graphElementSettings;
	}
	/**
	 * @param graphElementSettings the elementTypeSettings to set
	 */
	public void setGraphElementSettings(HashMap<String, GraphElementSettings> graphElementSettings) {
		this.graphElementSettings = graphElementSettings;
	}
	/**
	 * Constructor without arguments (This is first of all 
	 * for the JAXB-Context and should not be used by any
	 * other context)
	 */
	public SimulationSetup() {
	}
	/**
	 * Default Constructor of this class
	 * @param project
	 */
	public SimulationSetup(Project project) {
		this.currProject = project;
	}
	/**
	 * @param currProject the currProject to set
	 */
	public void setCurrProject(Project currProject) {
		this.currProject = currProject;
	}
	
	/**
	 * This method saves the current Simulation-Setup
	 * @return
	 */
	public boolean save() {
		
		// ------------------------------------------------
		// --- Write Data from GUI to the Model -----------
		this.setAgentList(this.agentListModel);
		
		// ------------------------------------------------
		// --- Save the current simulation setup ----------
		try {			
			// --- prepare context and Marshaller ---------
			JAXBContext pc = JAXBContext.newInstance( this.getClass() ); 
			Marshaller pm = pc.createMarshaller(); 
			pm.setProperty( Marshaller.JAXB_ENCODING, "UTF-8" );
			pm.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE ); 

			// --- Objektwerte in xml-Datei schreiben ----
			Writer pw = new FileWriter( currProject.simSetups.getCurrSimXMLFile() );
			pm.marshal( this, pw );
						
			currProject.setNotChangedButNotify(new SimulationSetupsChangeNotification(SimulationSetups.SIMULATION_SETUP_SAVED));
		} 
		catch (Exception e) {
			System.out.println("XML-Error while saving Setup-File!");
			e.printStackTrace();
		}
		return true;		
	}
	
	/**
	 * @return the agentList
	 */
	@XmlTransient
	public ArrayList<AgentClassElement4SimStart> getAgentList() {
		return agentList;
	}
	/**
	 * @param agentList the agentList to set
	 */
	public void setAgentList(ArrayList<AgentClassElement4SimStart> agentList) {
		this.agentList = agentList;
	}
	/**
	 * This Method transfers a DefaultListModel to 
	 * the localArrayList 'agentList' which is a 
	 * type of 'AgentClassElement4SimStart'
	 * @param lm
	 */
	public void setAgentList(DefaultListModel lm) {
		if (lm==null) return;
		agentList = new ArrayList<AgentClassElement4SimStart>();
		for (int i = 0; i < lm.size(); i++) {
			agentList.add((AgentClassElement4SimStart) lm.get(i));
		}		
	}
	
	/**
	 * @param agentListModel the agentListModel to set
	 */
	public void setAgentListModel(DefaultListModel agentListModel) {
		this.agentListModel = agentListModel;
		this.agentListModel.removeAllElements();
		for (int i = 0; i < agentList.size(); i++) {
			this.agentListModel.addElement(agentList.get(i));
		}
	}
	/**
	 * @return the agentListModel
	 */
	public DefaultListModel getAgentListModel() {
		return agentListModel;
	}
	
	
	/**
	 * @return the svgFileName
	 */
	public String getSvgFileName() {
		return svgFileName;
	}
	/**
	 * @param svgFileName the svgFileName to set
	 */
	public void setSvgFileName(String svgFileName) {
		this.svgFileName = svgFileName;
	}
	public String getEnvironmentFileName() {
		return environmentFileName;
	}
	public void setEnvironmentFileName(String environmentFile) {
		this.environmentFileName = environmentFile;
	}
	
	
	/**
	 * @return the distributionSetup
	 */
	@XmlTransient
	public DistributionSetup getDistributionSetup() {
		return distributionSetup;
	}
	/**
	 * @param distributionSetup the distributionSetup to set
	 */
	public void setDistributionSetup(DistributionSetup distributionSetup) {
		this.distributionSetup = distributionSetup;
	}
	
	
}
