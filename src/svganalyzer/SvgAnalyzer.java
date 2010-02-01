package svganalyzer;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import org.w3c.dom.events.EventListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import mas.display.BasicSvgGUI;
import mas.environment.AgentObject;
import mas.environment.BasicObject;
import mas.environment.EnvironmentController;
import mas.environment.ObstacleObject;
import mas.environment.Playground;


import org.apache.batik.swing.JSVGCanvas;
import org.apache.batik.swing.svg.SVGDocumentLoaderAdapter;
import org.apache.batik.swing.svg.SVGDocumentLoaderEvent;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventTarget;

import application.Project;
import javax.swing.JTextField;

/**
 * Umgebungssetup im Projektfenster, zur Bearbeitung der Umgebung
 * @author Nils
 *
 */
public class SvgAnalyzer extends JSplitPane {
	
	

	private static final long serialVersionUID = 1L;
	private JSVGCanvas canvas = null;
		
	private JSplitPane splitControlls = null;
	private JPanel pnlTop = null;
	private JButton btnOpen = null;
	private JTree treeEnvironment = null;
	private JScrollPane scrollEnvironment = null;
	private JPanel pnlBottom = null;
	private JComboBox cbType = null;
	private JComboBox cbClass = null;
	private JButton btnApply = null;
	private JFileChooser fcOpen = null;
		
	private Project currentProject = null;	
	private Element selectedElement = null;
	
	private EnvironmentController ec = null;

	private JTextField tfId = null;

	private JLabel lblType = null;

	private JLabel lblAgentClass = null;

	private JLabel lblId = null;

	private JButton btnDelete = null;

	private JLabel lblSettings = null;

	private JButton btnSave = null;
	
	private HashMap<String, String> agentClasses = null;

	/**
	 * This is the default constructor
	 */
	public SvgAnalyzer(Project project) {
		super();
		this.currentProject = project;
		this.ec = new EnvironmentController(this, currentProject);

				
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 300);
		this.setRightComponent(getSplitControlls());
		this.canvas = getCanvas();
		this.setLeftComponent(new BasicSvgGUI(canvas));
		this.addComponentListener(new ComponentAdapter(){
			public void componentResized(ComponentEvent ce){
				SvgAnalyzer.this.setDividerLocation(SvgAnalyzer.this.getWidth()-220);
				splitControlls.setDividerLocation(SvgAnalyzer.this.getHeight()-250);				
			}
		});
	}

	

	/**
	 * This method initializes splitControlls	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getSplitControlls() {
		if (splitControlls == null) {
			splitControlls = new JSplitPane();
			splitControlls.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitControlls.setTopComponent(getPnlTop());
			splitControlls.setBottomComponent(getPnlBottom());
			splitControlls.setDividerLocation(50);
		}
		return splitControlls;
	}

	/**
	 * This method initializes pnlTop	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlTop() {
		if (pnlTop == null) {
			pnlTop = new JPanel();
			pnlTop.setLayout(new BorderLayout());
			pnlTop.add(getBtnOpen(), BorderLayout.NORTH);
			pnlTop.add(getScrollEnvironment(), BorderLayout.CENTER);
		}
		return pnlTop;
	}

	/**
	 * This method initializes btnOpen	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnOpen() {
		if (btnOpen == null) {
			btnOpen = new JButton();
			btnOpen.setText("SVG-Datei �ffnen");
			btnOpen.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(SvgAnalyzer.this.getFcOpen().showOpenDialog(SvgAnalyzer.this)==JFileChooser.APPROVE_OPTION){
						ec.setNewEnv(true);
						ec.loadSvgFile(fcOpen.getSelectedFile());						
					}					
				}				
			});
		}
		return btnOpen;
	}

	/**
	 * This method initializes treeEnvironment	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getTreeEnvironment() {
		if (treeEnvironment == null) {
			treeEnvironment = new JTree();
			DefaultMutableTreeNode root = new DefaultMutableTreeNode("Kein SVG geladen");
			treeEnvironment.setModel(new DefaultTreeModel(root));
			treeEnvironment.setEnabled(false);
			treeEnvironment.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			treeEnvironment.addTreeSelectionListener(new TreeSelectionListener(){

				@Override
				public void valueChanged(TreeSelectionEvent arg0) {
					if(treeEnvironment.getLastSelectedPathComponent()!=null){
						String selection = treeEnvironment.getLastSelectedPathComponent().toString();
						BasicObject object = ec.getMainPlayground().getObjects().get(treeEnvironment.getLastSelectedPathComponent().toString());
						setInputValues(object);
						if(object!=null){
							SvgAnalyzer.this.setSelectedElement(canvas.getSVGDocument().getElementById(selection));
						}
						canvas.paint(canvas.getGraphics());
					}
				}
				
			});
		}
		return treeEnvironment;
	}
	
	private JScrollPane getScrollEnvironment(){
		if(scrollEnvironment == null){
			scrollEnvironment = new JScrollPane(getTreeEnvironment());			
		}
		return scrollEnvironment;
		
	}
	

	/**
	 * This method initializes pnlBottom	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPnlBottom() {
		if (pnlBottom == null) {
			lblSettings = new JLabel();
			lblSettings.setText("Objekt-Eigenschaften");
			lblSettings.setSize(new Dimension(122, 16));
			lblSettings.setLocation(new Point(5, 5));
			lblId = new JLabel();
			lblId.setText("Objekt-ID");
			lblId.setSize(new Dimension(52, 16));
			lblId.setLocation(new Point(5, 35));
			lblAgentClass = new JLabel();
			lblAgentClass.setText("Agentenklasse");
			lblAgentClass.setSize(new Dimension(85, 16));
			lblAgentClass.setLocation(new Point(5, 105));
			lblType = new JLabel();
			lblType.setText("Objekt-Typ");
			lblType.setSize(new Dimension(64, 16));
			lblType.setLocation(new Point(5, 70));
			pnlBottom = new JPanel();
			pnlBottom.setLayout(null);
			pnlBottom.add(getCbType(), null);
			pnlBottom.add(getCbClass(), null);
			pnlBottom.add(getBtnApply(), null);
			pnlBottom.add(getTfId(), null);
			pnlBottom.add(lblType, null);
			pnlBottom.add(lblAgentClass, null);
			pnlBottom.add(lblId, null);
			pnlBottom.add(getBtnRemove(), null);
			pnlBottom.add(lblSettings, null);			
			pnlBottom.add(getBtnSave(), null);
		}
		return pnlBottom;
	}

	/**
	 * This method initializes cbType	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbType() {
		if (cbType == null) {
			cbType = new JComboBox();
			String[] types = {"Undefiniert", "Agent", "Hinderniss"};
			cbType.setModel(new DefaultComboBoxModel(types));
			cbType.setLocation(new Point(100, 62));
			cbType.setSize(new Dimension(100, 25));
			cbType.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(cbType.getSelectedItem().equals("Agent")){
						cbClass.setEnabled(true);
					}else{
						cbClass.setEnabled(false);
					}
					if(cbType.getSelectedItem().equals("Undefiniert")){
						btnApply.setEnabled(false);
					}else{
						btnApply.setEnabled(true);
					}
					
				}
				
			});
		}
		return cbType;
	}

	/**
	 * This method initializes cbAgentClass	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getCbClass() {
		if (cbClass == null) {
			cbClass = new JComboBox();
			cbClass.setVisible(true);
			cbClass.setSize(new Dimension(100, 25));
			cbClass.setLocation(new Point(100, 97));
			
			agentClasses = new HashMap<String, String>(); 
			
			Vector<Class<?>> classes = currentProject.getProjectAgents();
			Vector<String> names = new Vector<String>();		
			for (int i =0; i<classes.size();i++) {
				String fullName = classes.get(i).getName();
				String shortName = fullName.substring(fullName.lastIndexOf('.')+1);
				names.add(shortName);
				agentClasses.put(shortName, fullName);				
			}
			cbClass.setModel(new DefaultComboBoxModel(names));
			cbClass.setEnabled(false);
		}
		return cbClass;
	}

	/**
	 * This method initializes btnSet	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnApply() {
		if (btnApply == null) {
			btnApply = new JButton();
			btnApply.setText("Objekt �bernehmen");
			btnApply.setSize(new Dimension(150, 26));
			btnApply.setLocation(new Point(10, 135));
			btnApply.addActionListener(new ActionListener(){

				
				@Override
				/**
				 * Erzeugt zu dem ausgew�hlten SVG Element ein Umgebungsobjekt und f�gt es zum Haupt-Playground hinzu
				 */
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					if(id.length()>0){
						selectedElement.setAttributeNS(null, "id", id);
					}else{
						id = selectedElement.getAttributeNS(null, "id");
					}
					
					Playground pg = ec.getMainPlayground();
					// Falls f�r diese ID schon ein Objekt definiert war, vorher l�schen
					if(pg.getObjects().get(id)!=null){
						pg.removeElement(id);
					}
					if(cbType.getSelectedItem().equals("Object")){
						ObstacleObject newObject = new ObstacleObject(id, selectedElement);
						System.out.println("Neues Objekt "+id);
						System.out.println("Position "+newObject.getPosX()+":"+newObject.getPosY());
						System.out.println("Gr��e "+newObject.getWidth()+"x"+newObject.getHeight());
						pg.addObstacle(newObject);
						setInputValues(newObject);
					}else if(cbType.getSelectedItem().equals("Agent")){
						AgentObject newAgent = new AgentObject(id, selectedElement, agentClasses.get(cbClass.getSelectedItem().toString()));
						System.out.println("Neuer Agent "+id);
						System.out.println("Position "+newAgent.getPosX()+":"+newAgent.getPosY());
						System.out.println("Gr��e "+newAgent.getWidth()+"x"+newAgent.getHeight());
						pg.addAgent(newAgent);
						setInputValues(newAgent);
					}
					// Aktualisiere Umgebungsbaum
					treeEnvironment.setModel(new DefaultTreeModel(buildPlaygroundTree(pg)));
					treeEnvironment.paint(treeEnvironment.getGraphics());
//					currentProject.ProjectUnsaved=true;
				}
				
			});
			
		}
		return btnApply;
	}
	
	/**
	 * This method initializes canvas	
	 * 	
	 * @return javax.swing.JFileChooser	
	 */
	private JFileChooser getFcOpen(){
		if(fcOpen == null){
			fcOpen = new JFileChooser();
			fcOpen.setFileFilter(new FileNameExtensionFilter("SVG Files", "svg"));
			fcOpen.setCurrentDirectory(new File(currentProject.getProjectFolderFullPath()+"/ressources"));
		}
		return fcOpen;
	}

	/**
	 * This method initializes canvas	
	 * 	
	 * @return org.apache.batik.swing.JSVGCanvas	
	 */
	public JSVGCanvas getCanvas(){
		if(canvas == null){
			canvas = new JSVGCanvas();
			canvas.setDocumentState(JSVGCanvas.ALWAYS_DYNAMIC);
			
			// EventListener wird ausgel�st, wenn die SVG-Datei vollst�ndig geladen ist
			canvas.addSVGDocumentLoaderListener(new SVGDocumentLoaderAdapter(){
				// Wird aufgerufen, wenn das SVG vollst�ndig geladen ist
				public void documentLoadingCompleted(SVGDocumentLoaderEvent e){
					ec.setSvgDoc(canvas.getSVGDocument());
					// Erzeugt onClick-Listener f�r die SVG-Elemente
					addElementListeners(canvas.getSVGDocument().getDocumentElement());
					
					// Wenn neue Umgebung, erzeuge mainPlayground aus SVG root
					if(ec.isNewEnv()){
						ec.setMainPlayground  (new Playground(canvas.getSVGDocument().getDocumentElement()));
//						ec.buildNewEnv(canvas.getSVGDocument().getDocumentElement());
					}
					// Initialisiert den Baum
					
					treeEnvironment.setModel(new DefaultTreeModel(buildPlaygroundTree(ec.getMainPlayground())));
					treeEnvironment.setEnabled(true);
				};
			});
		}
		return canvas;
	}
	
	/**
	 * Erzeugt onClick-Listener f�r das �bergebene Element und seine Kindelemente, falls sinnvoll  
	 * @param root 
	 */
	private void addElementListeners(Node root){
		// Element-Typen, die Listener bekommen 
		String tags[] = {"rect", "circle", "ellipse", "path"};
		if(Arrays.asList(tags).contains(root.getNodeName())){
			((EventTarget) root).addEventListener("click", new EventListener(){

				@Override
				public void handleEvent(Event arg0) {
					// Markiert das Element
					setSelectedElement((Element)arg0.getTarget());
					
					// �berpr�fung, ob zu dem SVG-Element schon ein Umgebungsobjekt existiert
					// und passende Belegung der GUI-Elemente
					String id = selectedElement.getAttributeNS(null, "id");
					BasicObject object = ec.getMainPlayground().getObjects().get(id);
					if(object != null){						
						setInputValues(object);
					}else{						
						tfId.setText(id);
						cbType.setSelectedItem("Undefiniert");
						cbClass.setEnabled(false);
						btnDelete.setEnabled(false);
					}
				}
				
			}, false);			
		}
		if(root.hasChildNodes()){
			NodeList children = root.getChildNodes();
			for(int i=0; i<children.getLength(); i++){
				addElementListeners(children.item(i));
			}
		}
	}
	
	/**
	 * Analysiert den �bergebenen Playground und erzeugt eine Baumstruktur der enthaltenen Objekte
	 * @param pg Der zu verarbeitende PlayGround
	 * @return Teilbaum mit den Objekten des PlayGround 
	 */
	private DefaultMutableTreeNode buildPlaygroundTree(Playground pg){
		String id = pg.getId();
		if( (id == null) || (id.length())==0){
			id="Playground";
		}
		// Playground Root
		DefaultMutableTreeNode pgRoot = new DefaultMutableTreeNode(id);
		// �ste f�r die Objektarten
		DefaultMutableTreeNode objectsRoot = new DefaultMutableTreeNode("Hindernisse");
		DefaultMutableTreeNode agentsRoot = new DefaultMutableTreeNode("Agenten");
		DefaultMutableTreeNode playgroundsRoot = new DefaultMutableTreeNode("Kind-Umgebungen");
		
		if(pg!=null){
			// Objekte werden ausgelesen und je nach Klasse in den Teilbaum eingeh�ngt
			Iterator<BasicObject> objects = pg.getObjects().values().iterator();
			while(objects.hasNext()){
				BasicObject object = objects.next();
				if(object instanceof Playground){
					playgroundsRoot.add(buildPlaygroundTree((Playground) object));				
				}else if(object instanceof AgentObject){
					agentsRoot.add(new DefaultMutableTreeNode(object.getId()));
				}else if(object instanceof ObstacleObject){
					objectsRoot.add(new DefaultMutableTreeNode(object.getId()));
				}
				
			}
		}
		
		pgRoot.add(agentsRoot);
		pgRoot.add(objectsRoot);
		pgRoot.add(playgroundsRoot);
		
		
		return pgRoot;
	}

	/**
	 * This method initializes tfId	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setLocation(new Point(100, 32));
			tfId.setText("");
			tfId.setPreferredSize(new Dimension(4, 20));
			tfId.setSize(new Dimension(100, 25));
		}
		return tfId;
	}

	/**
	 * This method initializes btnDelete	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnRemove() {
		if (btnDelete == null) {
			btnDelete = new JButton();
			btnDelete.setText("Objekt l�schen");
			btnDelete.setSize(new Dimension(150, 26));
			btnDelete.setEnabled(false);
			btnDelete.setLocation(new Point(10, 170));
			btnDelete.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ec.getMainPlayground().removeElement(tfId.getText());
					treeEnvironment.setModel(new DefaultTreeModel(buildPlaygroundTree(ec.getMainPlayground())));
					setSelectedElement(null);
					setInputValues(null);
				}
				
			});
		}
		return btnDelete;
	}
	
	/**
	 * Setzt bei Auswahl eines Umgebungsobjektes den Status der GUI-Elemente passend 
	 * @param object
	 */
	private void setInputValues(BasicObject object){
		if(object != null){
			tfId.setText(object.getId());
			if(object instanceof AgentObject){
				cbType.setSelectedItem("Agent");
				cbClass.setSelectedItem(((AgentObject) object).getAgentClass());
				cbClass.setEnabled(true);
			}else{
				cbType.setSelectedItem("Hinderniss");
				cbClass.setEnabled(false);
			}
			btnDelete.setEnabled(true);
		}else{
			if(selectedElement!=null){
				tfId.setText(selectedElement.getAttributeNS(null, "id"));
			}else{
				tfId.setText("");
			}
			cbType.setSelectedItem("Undefiniert");
			cbClass.setEnabled(false);
			btnDelete.setEnabled(false);
		}
	}
	
	/**
	 * Setzt und markiert das aktuell ausgew�hlte SVG-Element 
	 * @param element
	 */
	private void setSelectedElement(Element element){
		// Entferne Markierung des vorherigen Elements
		if(selectedElement!=null){
			selectedElement.setAttributeNS(null, "stroke", "none");
		}
		selectedElement = element;
		
		if(selectedElement!=null){
			selectedElement.setAttributeNS(null, "stroke", "black");
			selectedElement.setAttributeNS(null, "stroke-width", "5px");
		}
	}
	
	/**
	 * This method initializes btnSave	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton();
			btnSave.setLocation(new Point(10, 205));
			btnSave.setText("Umgebung speichern");
			btnSave.setSize(new Dimension(150, 26));
			btnSave.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ec.saveEnvironment();
				}
				
			});
		}
		return btnSave;
	}	
}
