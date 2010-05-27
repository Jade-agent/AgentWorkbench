package gui.projectwindow;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import mas.onto.OntologyClassTreeObject;
import application.Application;
import application.Language;
import application.Project;

public class BaseAgents extends JPanel implements Observer, ActionListener {

	private static final long serialVersionUID = 1L;
	private Project CurrProject;
	private OntologyClassTreeObject CurrOntoObject = null;
	private String agentConfig = null;  //  @jve:decl-index=0:
	private Integer agentConfigPos = null;  //  @jve:decl-index=0:
	private String agentReference = null;  //  @jve:decl-index=0:
	private String ontoReference = null;  //  @jve:decl-index=0:
	
	private JPanel jPanelNorth = null;
	private JLabel jLabelAgent = null;
	private JTextField jTextAgent = null;
	private JLabel jLabelStart = null;
	private JTextField jTextAgentStartAs = null;
	private JButton jButtonStartAgent = null;
	private JButton jButtonAgentListRefresh = null;
	private JScrollPane jAgentScroll = null;
	private JList jAgentList = null;
	private JPanel jPanelReferences = null;
	private JPanel jPanelWest = null;
	private JScrollPane jScrollReferences = null;
	private JList jListReferences = null;
	private JButton jButtonMoveUp = null;
	private JButton jButtonMoveDown = null;
	private JButton jButtonRemoveAll = null;
	private JButton jButtonReferencesAdd = null;
	private JButton jButtonReferencesRemove = null;
	private JSplitPane jSplitHrizontal = null;
	private JSplitPane jSplitEast = null;
	private JScrollPane jScrollOntology = null;
	private JTree jTreeOntology = null;
	private JPanel jPanelOntology = null;
	private JLabel jLabelRecerence = null;
	private JLabel jLabelOntologie = null;
	private JSplitPane jSplitOntologie = null;
	private JPanel jPanelOntoSlots = null;
	/**
	 * This is the default constructor
	 */
	public BaseAgents( Project CP ) {
		super();
		this.CurrProject = CP;
		this.CurrProject.addObserver(this);		
		initialize();	
		
		// --- �bersetzung anschmeissen -------------------
		jLabelAgent.setText(Language.translate("Agent:"));
		jLabelStart.setText(Language.translate("Starten als:"));
		jLabelRecerence.setText(Language.translate("Objekte aus Projekt-Ontologie"));
		jLabelOntologie.setText(Language.translate("Projekt-Ontologie"));
		
		jButtonStartAgent.setToolTipText(Language.translate("Agent starten..."));
		jButtonAgentListRefresh.setToolTipText(Language.translate("Agentenliste aktualisieren"));
		jButtonMoveUp.setToolTipText(Language.translate("Objekt nach oben"));
		jButtonMoveDown.setToolTipText(Language.translate("Objekt nach unten"));
		jButtonRemoveAll.setToolTipText(Language.translate("Alle Objekte l�schen"));
		jButtonReferencesAdd.setToolTipText(Language.translate("Objekt hinzuf�gen"));
		jButtonReferencesRemove.setToolTipText(Language.translate("Objekt entfernen"));
		
		// --- Basis-Verzeichnisse im OntoTree anzeigen -------
		this.OntoTreeExpand2Level(3, true);
		

	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(0);
		borderLayout.setVgap(0);
		jLabelAgent = new JLabel();
		jLabelAgent.setText("Agent:");
		jLabelAgent.setFont(new Font("Dialog", Font.BOLD, 12));
		this.setLayout(borderLayout);
		this.setSize(819, 478);
		this.add(getJPanelNorth(), BorderLayout.NORTH);
		this.add(getJSplitHrizontal(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes jPanelNorth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelNorth() {
		if (jPanelNorth == null) {
			GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
			gridBagConstraints111.gridx = 0;
			gridBagConstraints111.anchor = GridBagConstraints.WEST;
			gridBagConstraints111.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints111.gridy = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.insets = new Insets(10, 10, 10, 5);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 5;
			gridBagConstraints4.insets = new Insets(0, 10, 0, 12);
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 4;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 5);
			gridBagConstraints3.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridy = 0;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridx = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 2;
			gridBagConstraints1.insets = new Insets(10, 10, 10, 5);
			gridBagConstraints1.gridy = 0;
			jLabelStart = new JLabel();
			jLabelStart.setText("Starten als:");
			jLabelStart.setFont(new Font("Dialog", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.weightx = 1.0;
			gridBagConstraints.gridwidth = 1;
			gridBagConstraints.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints.gridx = 1;
			jPanelNorth = new JPanel();
			jPanelNorth.setLayout(new GridBagLayout());
			jPanelNorth.add(jLabelAgent, gridBagConstraints9);
			jPanelNorth.add(getJTextAgent(), gridBagConstraints);
			jPanelNorth.add(jLabelStart, gridBagConstraints1);
			jPanelNorth.add(getJTextAgentStartAs(), gridBagConstraints2);
			jPanelNorth.add(getJButtonStartAgent(), gridBagConstraints3);
			jPanelNorth.add(getJButtonAgentListRefresh(), gridBagConstraints4);
		}
		return jPanelNorth;
	}

	/**
	 * This method initializes jTextAgent	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextAgent() {
		if (jTextAgent == null) {
			jTextAgent = new JTextField();
			jTextAgent.setEditable(false);
			jTextAgent.setPreferredSize(new Dimension(198, 26));
		}
		return jTextAgent;
	}

	/**
	 * This method initializes jTextAgentStartAs	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextAgentStartAs() {
		if (jTextAgentStartAs == null) {
			jTextAgentStartAs = new JTextField();
			jTextAgentStartAs.setPreferredSize(new Dimension(150, 26));
			jTextAgentStartAs.setEditable(true);
		}
		return jTextAgentStartAs;
	}

	/**
	 * This method initializes jButtonStartAgent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonStartAgent() {
		if (jButtonStartAgent == null) {
			jButtonStartAgent = new JButton();
			jButtonStartAgent.setText("OK");
			jButtonStartAgent.setToolTipText("Agent starten...");
			jButtonStartAgent.setPreferredSize(new Dimension(50, 26));			
			jButtonStartAgent.setFont(new Font("Dialog", Font.BOLD, 12));
			jButtonStartAgent.setActionCommand("AgentStart");
			jButtonStartAgent.addActionListener(this);
		}
		return jButtonStartAgent;
	}

	/**
	 * This method initializes jButtonAgentListRefresh	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonAgentListRefresh() {
		if (jButtonAgentListRefresh == null) {
			jButtonAgentListRefresh = new JButton();
			jButtonAgentListRefresh.setIcon(new ImageIcon(getClass().getResource("/img/Refresh.png")));
			jButtonAgentListRefresh.setPreferredSize(new Dimension(30, 26));
			jButtonAgentListRefresh.setToolTipText("Agentenliste aktualisieren");
			jButtonAgentListRefresh.setActionCommand("AgentsRefresh");
			jButtonAgentListRefresh.addActionListener(this);			
		}
		return jButtonAgentListRefresh;
	}

	/**
	 * This method initializes jAgentScroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJAgentScroll() {
		if (jAgentScroll == null) {
			jAgentScroll = new JScrollPane();
			jAgentScroll.setViewportView(getJAgentList());
		}
		return jAgentScroll;
	}

	/**
	 * This method initializes jAgentList	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJAgentList() {
		if (jAgentList == null) {
			Vector<Class<?>> AgentList = CurrProject.getProjectAgents();
			DefaultListModel jAgentListModel = new DefaultListModel();
			for (int i =0; i<AgentList.size();i++) {
				jAgentListModel.addElement( AgentList.get(i).getName() );
			}
			jAgentList = new JList(jAgentListModel);
			jAgentList.setToolTipText("Agenten in diesem Projekt");
			jAgentList.setVisibleRowCount(12);
			jAgentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jAgentList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
				public void valueChanged(javax.swing.event.ListSelectionEvent se) {

					if ( jAgentList.getSelectedValue() != null ) {
						String ToDisplay = jAgentList.getSelectedValue().toString();
						//System.out.println("Agent: " + ToDisplay);
						// -----------------------------------------------------
						// --- Definierte Start-Referenzen anzeigen ------------ 
						jListReferences.setListData( CurrProject.AgentConfig.getListData(ToDisplay) );
						// -----------------------------------------------------
						// --- Eintrag f�r den aktuellen Agenten vornehmen -----
						int maxLenght = 30;
						if ( ToDisplay.length() > maxLenght ) {
							String ToDisplayStart = ToDisplay.substring(0, 4);
							String ToDisplayEnde = ToDisplay.substring( ToDisplay.length() - maxLenght );
							ToDisplay = ToDisplayStart + "..." + ToDisplayEnde;
						}
						jTextAgent.setText( ToDisplay );
						// -----------------------------------------------------
						// --- Vorschlag f�r den Ausf�hrungsnamen finden -------
						String StartAs = jAgentList.getSelectedValue().toString();
						StartAs = StartAs.substring(StartAs.lastIndexOf(".")+1);
						// -----------------------------------------------------
						// --- Alle Gro�buchstaben filtern ---------------------
						String RegExp = "[A-Z]";	
						String StartAsNew = ""; 
						for (int i = 0; i < StartAs.length(); i++) {
							String SngChar = "" + StartAs.charAt(i);
							if ( SngChar.matches( RegExp ) == true ) {
								StartAsNew = StartAsNew + SngChar;	
								// --- ggf. den zweiten Buchstaben mitnehmen ---
								if ( i < StartAs.length() ) {
									String SngCharN = "" + StartAs.charAt(i+1);
									if ( SngCharN.matches( RegExp ) == false ) {
										StartAsNew = StartAsNew + SngCharN;	
									}
								}	
								// ---------------------------------------------
							}						
					    }
						if ( StartAsNew != "" && StartAsNew.length() >= 4 ) {
							StartAs = StartAsNew;
						}
						// -----------------------------------------------------
						// --- Check, ob es dieser Agent schon l�uft -----------
						int i = 1;
						StartAsNew = StartAs;
						while ( Application.JadePlatform.jadeAgentIsRunning( StartAs, CurrProject.getProjectFolder() ) == true ){
							StartAs = StartAsNew + i;
							i++; 
						}
						// -----------------------------------------------------
						// --- Vorschlagsnamen einstellen ----------------------
						jTextAgentStartAs.setText(StartAs);
					}
					// ----------------------------------------------------
					// --- Fertig -----------------------------------------
					// ----------------------------------------------------
				}
			});
		}
		return jAgentList;
	}

	/**
	 * This method initializes jPanelReferences	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelReferences() {
		if (jPanelReferences == null) {
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.anchor = GridBagConstraints.WEST;
			gridBagConstraints15.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints15.gridwidth = 2;
			gridBagConstraints15.gridy = 0;
			jLabelRecerence = new JLabel();
			jLabelRecerence.setText("Objekte aus Projekt-Ontologie");
			jLabelRecerence.setFont(new Font("Dialog", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.insets = new Insets(5, 5, 0, 0);
			gridBagConstraints12.anchor = GridBagConstraints.WEST;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridy = 8;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.EAST;
			gridBagConstraints11.insets = new Insets(5, 0, 0, 5);
			gridBagConstraints11.ipadx = 0;
			gridBagConstraints11.weightx = 1.0;
			gridBagConstraints11.gridy = 8;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 2;
			gridBagConstraints10.insets = new Insets(10, 0, 0, 10);
			gridBagConstraints10.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints10.gridy = 6;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 2;
			gridBagConstraints8.insets = new Insets(0, 0, 5, 10);
			gridBagConstraints8.gridy = 3;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 2;
			gridBagConstraints7.insets = new Insets(0, 0, 3, 10);
			gridBagConstraints7.gridy = 1;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.weighty = 1.0;
			gridBagConstraints6.insets = new Insets(0, 10, 0, 5);
			gridBagConstraints6.gridheight = 6;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.gridy = 1;
			gridBagConstraints6.weightx = 1.0;
			jPanelReferences = new JPanel();
			jPanelReferences.setLayout(new GridBagLayout());
			jPanelReferences.add(getJScrollReferences(), gridBagConstraints6);
			jPanelReferences.add(getJButtonMoveUp(), gridBagConstraints7);
			jPanelReferences.add(getJButtonMoveDown(), gridBagConstraints8);
			jPanelReferences.add(getJButtonRemoveAll(), gridBagConstraints10);
			jPanelReferences.add(getJButtonReferencesAdd(), gridBagConstraints11);
			jPanelReferences.add(getJButtonReferencesRemove(), gridBagConstraints12);
			jPanelReferences.add(jLabelRecerence, gridBagConstraints15);
		}
		return jPanelReferences;
	}

	/**
	 * This method initializes jPanelWest	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelWest() {
		if (jPanelWest == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridx = -1;
			gridBagConstraints5.gridy = -1;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.weighty = 1.0;
			gridBagConstraints5.insets = new Insets(0, 10, 0, 0);
			jPanelWest = new JPanel();
			jPanelWest.setLayout(new GridBagLayout());
			jPanelWest.add(getJAgentScroll(), gridBagConstraints5);
		}
		return jPanelWest;
	}

	/**
	 * This method initializes jScrollReferences	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollReferences() {
		if (jScrollReferences == null) {
			jScrollReferences = new JScrollPane();
			jScrollReferences.setViewportView(getJListReferences());
		}
		return jScrollReferences;
	}

	/**
	 * This method initializes jListReferences	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getJListReferences() {
		if (jListReferences == null) {
			jListReferences = new JList();
		}
		return jListReferences;
	}

	/**
	 * This method initializes jButtonMoveUp	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMoveUp() {
		if (jButtonMoveUp == null) {
			jButtonMoveUp = new JButton();
			jButtonMoveUp.setPreferredSize(new Dimension(15, 15));
			jButtonMoveUp.setIcon(new ImageIcon(getClass().getResource("/img/ArrowUp.png")));
			jButtonMoveUp.setToolTipText("Objekt nach oben");
			jButtonMoveUp.setActionCommand("OntoObjectUp");
			jButtonMoveUp.addActionListener(this);
		}
		return jButtonMoveUp;
	}

	/**
	 * This method initializes jButtonMoveDown	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonMoveDown() {
		if (jButtonMoveDown == null) {
			jButtonMoveDown = new JButton();
			jButtonMoveDown.setIcon(new ImageIcon(getClass().getResource("/img/ArrowDown.png")));
			jButtonMoveDown.setPreferredSize(new Dimension(15, 15));
			jButtonMoveDown.setToolTipText("Objekt nach unten");
			jButtonMoveDown.setActionCommand("OntoObjectDown");
			jButtonMoveDown.addActionListener(this);
		}
		return jButtonMoveDown;
	}

	/**
	 * This method initializes jButtonRemoveAll	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonRemoveAll() {
		if (jButtonRemoveAll == null) {
			jButtonRemoveAll = new JButton();
			jButtonRemoveAll.setIcon(new ImageIcon(getClass().getResource("/img/Delete.png")));
			jButtonRemoveAll.setPreferredSize(new Dimension(15, 15));
			jButtonRemoveAll.setToolTipText("Alle Objekte l�schen");
			jButtonRemoveAll.setActionCommand("OntoObjectsRemoveAll");
			jButtonRemoveAll.addActionListener(this);
		}
		return jButtonRemoveAll;
	}

	/**
	 * This method initializes jButtonReferencesAdd	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonReferencesAdd() {
		if (jButtonReferencesAdd == null) {
			jButtonReferencesAdd = new JButton();
			jButtonReferencesAdd.setIcon(new ImageIcon(getClass().getResource("/img/ArrowUp.png")));
			jButtonReferencesAdd.setSize(15, 15);
			jButtonReferencesAdd.setToolTipText("Objekt hinzuf�gen");
			jButtonReferencesAdd.setActionCommand("OntoObjectAdd");
			jButtonReferencesAdd.addActionListener(this);
		}
		return jButtonReferencesAdd;
	}

	/**
	 * This method initializes jButtonReferencesRemove	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonReferencesRemove() {
		if (jButtonReferencesRemove == null) {
			jButtonReferencesRemove = new JButton();
			jButtonReferencesRemove.setIcon(new ImageIcon(getClass().getResource("/img/ArrowDown.png")));
			jButtonReferencesRemove.setSize(15, 15);
			jButtonReferencesRemove.setToolTipText("Objekt entfernen");
			jButtonReferencesRemove.setActionCommand("OntoObjectRemsove");
			jButtonReferencesRemove.addActionListener(this);
		}
		return jButtonReferencesRemove;
	}

	/**
	 * This method initializes jSplitHrizontal	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitHrizontal() {
		if (jSplitHrizontal == null) {
			jSplitHrizontal = new JSplitPane();
			jSplitHrizontal.setDividerSize(1);
			jSplitHrizontal.setResizeWeight(0.5D);
			jSplitHrizontal.setDividerLocation(290);
			jSplitHrizontal.setRightComponent(getJSplitEast());
			jSplitHrizontal.setLeftComponent(getJPanelWest());
		}
		return jSplitHrizontal;
	}

	/**
	 * This method initializes jSplitEast	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitEast() {
		if (jSplitEast == null) {
			jSplitEast = new JSplitPane();
			jSplitEast.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitEast.setDividerSize(1);
			jSplitEast.setResizeWeight(0.0D);
			jSplitEast.setDividerLocation(160);
			jSplitEast.setBottomComponent(getJSplitOntologie());
			jSplitEast.setTopComponent(getJPanelReferences());
		}
		return jSplitEast;
	}

	/**
	 * This method initializes jScrollOntology	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollOntology() {
		if (jScrollOntology == null) {
			jScrollOntology = new JScrollPane();
			jScrollOntology.setViewportView(getJTreeOntology());
		}
		return jScrollOntology;
	}

	/**
	 * This method initializes jTreeOntology	
	 * 	
	 * @return javax.swing.JTree	
	 */
	private JTree getJTreeOntology() {
		if (jTreeOntology == null) {
			jTreeOntology = new JTree();
			//jTreeOntology = new JTree( CurrProject.Ontology.getOntologyTree() );
			jTreeOntology = new JTree( CurrProject.ontologies4Project.getOntologyTree() );
			jTreeOntology.setName("OntoTree");
			jTreeOntology.setShowsRootHandles(false);
			jTreeOntology.setRootVisible(true);
			jTreeOntology.getSelectionModel().setSelectionMode( TreeSelectionModel.SINGLE_TREE_SELECTION );
			jTreeOntology.addTreeSelectionListener( new TreeSelectionListener() {
				@Override
				public void valueChanged(TreeSelectionEvent ts) {
					
					// ----------------------------------------------------------
					// --- Tree-Selection abfangen --- S T A R T ----------------
					// ----------------------------------------------------------
					// --- Node auslesen und Slots anzeigen ---------------------
					DefaultMutableTreeNode CurrNode = (DefaultMutableTreeNode)ts.getPath().getLastPathComponent();
					CurrOntoObject = (OntologyClassTreeObject) CurrNode.getUserObject();
					JPanel NewSlotView = new OntologyTabClassView( CurrNode ); 
					int DivLoc = jSplitOntologie.getDividerLocation();
					jSplitOntologie.setBottomComponent( NewSlotView );
					jSplitOntologie.setDividerLocation(DivLoc);
					jPanelOntoSlots = NewSlotView; 					
					// ----------------------------------------------------------
					// --- Tree-Selection abfangen --- S T O P ------------------
					// ----------------------------------------------------------
				}// End - valueChanged
			});
		}
		return jTreeOntology;
	}
	// If expand is true, expands all nodes in the tree.
    // Otherwise, collapses all nodes in the tree.
    public void OntoTreeExpand2Level(Integer Up2TreeLevel, boolean expand ) {
    	Integer CurrNodeLevel = 1;
    	if ( Up2TreeLevel == null ) 
    		Up2TreeLevel = 1000;
    	OntoTreeExpand( new TreePath( CurrProject.ontologies4Project.getOntologyTree().getRoot() ), expand, CurrNodeLevel, Up2TreeLevel);
    }
    @SuppressWarnings("unchecked")
	private void OntoTreeExpand( TreePath parent, boolean expand, Integer CurrNodeLevel, Integer Up2TreeLevel) {
    
        TreeNode node = (TreeNode)parent.getLastPathComponent();
        if (CurrNodeLevel >= Up2TreeLevel) {
        	return;
        }
        if (node.getChildCount() >= 0) {
            for ( Enumeration e=node.children(); e.hasMoreElements(); ) {
                TreeNode n = (TreeNode) e.nextElement();
                TreePath path = parent.pathByAddingChild(n);
                OntoTreeExpand(path, expand, CurrNodeLevel+1, Up2TreeLevel);
            }
        }    
        // Expansion or collapse must be done bottom-up
        if (expand) {
        	jTreeOntology.expandPath(parent);
        } else {
        	jTreeOntology.collapsePath(parent);
        }
    }
    
	/**
	 * This method initializes jPanelOntology	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelOntology() {
		if (jPanelOntology == null) {
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.anchor = GridBagConstraints.WEST;
			gridBagConstraints14.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints14.gridy = 0;
			jLabelOntologie = new JLabel();
			jLabelOntologie.setText("Projekt-Ontologie");
			jLabelOntologie.setFont(new Font("Dialog", Font.BOLD, 12));
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.fill = GridBagConstraints.BOTH;
			gridBagConstraints13.weighty = 1.0;
			gridBagConstraints13.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints13.gridy = 1;
			gridBagConstraints13.weightx = 1.0;
			jPanelOntology = new JPanel();
			jPanelOntology.setLayout(new GridBagLayout());
			jPanelOntology.add(getJScrollOntology(), gridBagConstraints13);
			jPanelOntology.add(jLabelOntologie, gridBagConstraints14);
		}
		return jPanelOntology;
	}
	/**
	 * This method initializes jSplitOntologie	
	 * 	
	 * @return javax.swing.JSplitPane	
	 */
	private JSplitPane getJSplitOntologie() {
		if (jSplitOntologie == null) {
			jSplitOntologie = new JSplitPane();
			jSplitOntologie.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitOntologie.setDividerSize(1);
			jSplitOntologie.setDividerLocation(150);
			jSplitOntologie.setResizeWeight(1.0D);
			jSplitOntologie.setBottomComponent(getJPanelOntoSlots());
			jSplitOntologie.setTopComponent(getJPanelOntology());
		}
		return jSplitOntologie;
	}

	/**
	 * This method initializes jPanelOntoSlots	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanelOntoSlots() {
		if (jPanelOntoSlots == null) {
			jPanelOntoSlots = new JPanel();
			jPanelOntoSlots.setLayout(new GridBagLayout());
		}
		return jPanelOntoSlots;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// --- Das ActionCommand und den Ausl�ser des Events ermitteln ---
		String ActCMD = ae.getActionCommand();
		Object Trigger = ae.getSource();

		if ( Trigger == jButtonAgentListRefresh ) {
			// --- AgentList aktualisieren ----------------
			Application.setStatusBar( Language.translate("Aktualisiere Agenten-Liste...") );
			Application.MainWindow.setCursor( Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR) );	
			Application.JadePlatform.jadeFindAgentClasse();
			jTextAgent.setText(null);
			jTextAgentStartAs.setText(null);
			jListReferences.setListData(new Vector<String>());
			CurrProject.filterProjectAgents();
			this.setCurrAgentConfig();
			this.setTmpAgentConfig();
		}
		else if ( Trigger == jButtonStartAgent ) {
			// --- Den ausgew�hlten Agenten starten -------
			if ( jTextAgentStartAs.getText().length() != 0 && jAgentList.getSelectedValue() != null) {
				Application.JadePlatform.jadeAgentStart(
						jTextAgentStartAs.getText(), 
						jAgentList.getSelectedValue().toString(), 
						CurrProject.getProjectFolder());	
				jTextAgent.setText(null);
				jTextAgentStartAs.setText(null);
				jAgentList.clearSelection();
			}
		} else if (Trigger == jButtonMoveUp ) {
			// --- Agenten-Referenz eins h�her ------------
			setTmpAgentConfig();
			setCurrAgentConfig();
			if (CurrProject.AgentConfig.movePosition(agentReference, agentConfig, agentConfigPos, -1) ){
				jListReferences.setSelectedIndex(agentConfigPos-2);
			}
		} else if (Trigger == jButtonMoveDown ) {
			// --- Agenten-Referenz eins runter -----------
			setTmpAgentConfig();
			setCurrAgentConfig();
			if (CurrProject.AgentConfig.movePosition(agentReference, agentConfig, agentConfigPos, 1) ){
				jListReferences.setSelectedIndex(agentConfigPos);
			}
		} else if (Trigger == jButtonRemoveAll) {
			// --- Agenten-Referenzen komplett entfernen --
			setTmpAgentConfig();
			CurrProject.AgentConfig.removeReferencesComplete(agentReference);
		} else if (Trigger == jButtonReferencesAdd ) {
			// --- Agenten-Referenzen hinzuf�gen ----------
			setTmpAgentConfig();
			CurrProject.AgentConfig.addReference(agentReference, ontoReference);
		} else if (Trigger == jButtonReferencesRemove ) {
			// --- Agenten-Referenzen entfernen -----------
			setTmpAgentConfig();
			setCurrAgentConfig();
			CurrProject.AgentConfig.removeReference(agentReference, agentConfig);
		}
		else {
			System.err.println(Language.translate("Unbekannt: ") + "ActionCommand => " + ActCMD);	
		};
		this.repaint();
	}
	/**
	 * updates the List of the AgetnReferences
	 */
	private void updateView4AgentConfig() {
		jListReferences.setListData( CurrProject.AgentConfig.getListData(agentReference) );
	}
	/**
	 * reads the currently selected AgentReference to var. agentConfig
	 */
	private void setCurrAgentConfig() {
		if ( jListReferences.getSelectedValue() == null ) {
			agentConfig = null;
		} else {
			agentConfig = jListReferences.getSelectedValue().toString();
			String[] agentConfigArr = agentConfig.split(":");
			agentConfigPos = Integer.valueOf(agentConfigArr[0].trim()).intValue();
			agentConfig = agentConfigArr[1].trim();
		}
	}
	private void setTmpAgentConfig() {
		// -- configure Var. agentReference -------------------------
		if ( jAgentList.getSelectedValue() == null ) {
			agentReference = null;
		} else {
			agentReference = jAgentList.getSelectedValue().toString();
		}
		// -- configure Var. ontoReference --------------------------		
		if ( CurrOntoObject == null  ) {
			ontoReference = null;
		} else {
			if ( CurrOntoObject.isClass() ) {
				ontoReference = CurrOntoObject.getOntologySubClass().getName();	
			} else {
				ontoReference = null;	
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object OName) {
		
		String ObjectName = OName.toString();
		if ( ObjectName.equalsIgnoreCase( "AgentReferences" ) ) {
			// --- Liste der Agenten-Referenzen aktualisieren ---
			updateView4AgentConfig();			
		} else if ( ObjectName.equalsIgnoreCase( "ProjectOntology" ) ) {
			// --- Ansicht auf die projekt-Ontologie aktualisieren --
			this.jTreeOntology.setModel( CurrProject.ontologies4Project.getOntologyTree() );
			this.OntoTreeExpand2Level(3, true);
		} else {
			System.out.println("Unbekannte Meldung vom Observer: " + ObjectName);
		}
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
