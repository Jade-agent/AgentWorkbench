/**
 * ***************************************************************
 * Agent.GUI is a framework to develop Multi-agent based simulation 
 * applications based on the JADE - Framework in compliance with the 
 * FIPA specifications. 
 * Copyright (C) 2010 Christian Derksen and DAWIS
 * http://www.dawis.wiwi.uni-due.de
 * http://sourceforge.net/projects/agentgui/
 * http://www.agentgui.org 
 *
 * GNU Lesser General Public License
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation,
 * version 2.1 of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA.
 * **************************************************************
 */
package agentgui.core.gui.options.https;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;

import agentgui.core.application.Application;

/**
 * This JPanel allows the user to : 
 * 1- create new TrustStore and protect its integrity with a password 
 * 2- update his TrustStore informations 
 * 3- add or delete certificates from TrustStore
 * @see HttpsConfigWindow
 * 
 * @author Mohamed Amine JEDIDI <mohamedamine_jedidi@outlook.com>
 * @version 1.0
 * @since 05-04-2016
 */

public class TrustStoreConfigPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -4676410555112580221L;

	private final Dimension fieldSize = new Dimension(120, 26);

	private HttpsConfigWindow httpsConfigWindow;

	private JFrame frame;
	private JPanel jPanelButtons;

	private JLabel jLabelTrustStoreInformations;
	private JLabel jLabelTruststoreName;
	private JLabel jLabelTrustStorePassword;
	private JLabel jLabelTrustStoreConfirmPassword;
	private JLabel jLabelCertificatesList;
	private JTextField jTextFieldTrustStoreName;

	private JPasswordField jPasswordFieldTrustStorePassword;
	private JPasswordField jPasswordFieldTrustStoreConfirmPassword;

	private JButton jButtonAddCertificate;
	private JButton jButtonRemoveCertificate;
	private JButton jButtonApplyTrustStore;
	
	private JScrollPane jscrollPane;
	private JList<String> jListCertificatesAlias;
	
	private JFileChooser jFileChooser;
	private JFileChooser jFileChooserFile;

	private final String pathImage = Application.getGlobalInfo().getPathImageIntern();
	private final ImageIcon iconSave = new ImageIcon( this.getClass().getResource( pathImage + "MBsave.png") );
	private final ImageIcon iconAdd = new ImageIcon( this.getClass().getResource( pathImage + "ListPlus.png") );
	private final ImageIcon iconRemove = new ImageIcon( this.getClass().getResource( pathImage + "ListMinus.png") );

	/**
	 * Create the application.
	 */
	public TrustStoreConfigPanel(HttpsConfigWindow httpsConfigWindow) {
		this.httpsConfigWindow = httpsConfigWindow;
		this.initialize();
	}
	/**
	 * Initialize the contents of the Panel.
	 */
	private void initialize() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		GridBagConstraints gbc_jLabelTrustStoreInformations = new GridBagConstraints();
		gbc_jLabelTrustStoreInformations.fill = GridBagConstraints.VERTICAL;
		gbc_jLabelTrustStoreInformations.anchor = GridBagConstraints.WEST;
		gbc_jLabelTrustStoreInformations.insets = new Insets(15, 10, 15, 5);
		gbc_jLabelTrustStoreInformations.gridx = 0;
		gbc_jLabelTrustStoreInformations.gridy = 0;
		add(getJLabelTrustStoreInformations(), gbc_jLabelTrustStoreInformations);
		GridBagConstraints gbc_ButtonApplyTrustStore = new GridBagConstraints();
		gbc_ButtonApplyTrustStore.anchor = GridBagConstraints.EAST;
		gbc_ButtonApplyTrustStore.insets = new Insets(5, 0, 5, 10);
		gbc_ButtonApplyTrustStore.gridx = 2;
		gbc_ButtonApplyTrustStore.gridy = 0;
		add(getJButtonApplyTrustStore(), gbc_ButtonApplyTrustStore);
		GridBagConstraints gbc_jLabelTruststoreName = new GridBagConstraints();
		gbc_jLabelTruststoreName.anchor = GridBagConstraints.WEST;
		gbc_jLabelTruststoreName.insets = new Insets(0, 10, 5, 5);
		gbc_jLabelTruststoreName.gridx = 0;
		gbc_jLabelTruststoreName.gridy = 1;
		add(getJLabelTruststoreName(), gbc_jLabelTruststoreName);
		GridBagConstraints gbc_jLabelTrustStorePassword = new GridBagConstraints();
		gbc_jLabelTrustStorePassword.anchor = GridBagConstraints.WEST;
		gbc_jLabelTrustStorePassword.insets = new Insets(0, 10, 5, 5);
		gbc_jLabelTrustStorePassword.gridx = 0;
		gbc_jLabelTrustStorePassword.gridy = 2;
		add(getJLabelTrustStorePassword(), gbc_jLabelTrustStorePassword);
		GridBagConstraints gbc_jLabelTrustStoreConfirmPassword = new GridBagConstraints();
		gbc_jLabelTrustStoreConfirmPassword.anchor = GridBagConstraints.WEST;
		gbc_jLabelTrustStoreConfirmPassword.insets = new Insets(0, 10, 5, 5);
		gbc_jLabelTrustStoreConfirmPassword.gridx = 0;
		gbc_jLabelTrustStoreConfirmPassword.gridy = 3;
		add(getJLabelTrustStoreConfirmPassword(), gbc_jLabelTrustStoreConfirmPassword);
		GridBagConstraints gbc_jTextFieldTrustStoreName = new GridBagConstraints();
		gbc_jTextFieldTrustStoreName.gridwidth = 2;
		gbc_jTextFieldTrustStoreName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jTextFieldTrustStoreName.insets = new Insets(0, 0, 5, 10);
		gbc_jTextFieldTrustStoreName.gridx = 1;
		gbc_jTextFieldTrustStoreName.gridy = 1;
		add(getJTextFieldTrustStoreName(), gbc_jTextFieldTrustStoreName);
		GridBagConstraints gbc_jPasswordFieldTrustStorePassword = new GridBagConstraints();
		gbc_jPasswordFieldTrustStorePassword.gridwidth = 2;
		gbc_jPasswordFieldTrustStorePassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jPasswordFieldTrustStorePassword.insets = new Insets(0, 0, 5, 10);
		gbc_jPasswordFieldTrustStorePassword.gridx = 1;
		gbc_jPasswordFieldTrustStorePassword.gridy = 2;
		add(getJPasswordFieldTrustStorePassword(), gbc_jPasswordFieldTrustStorePassword);
		GridBagConstraints gbc_jPasswordFieldTrustStoreConfirmPassword = new GridBagConstraints();
		gbc_jPasswordFieldTrustStoreConfirmPassword.gridwidth = 2;
		gbc_jPasswordFieldTrustStoreConfirmPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_jPasswordFieldTrustStoreConfirmPassword.insets = new Insets(0, 0, 5, 10);
		gbc_jPasswordFieldTrustStoreConfirmPassword.gridx = 1;
		gbc_jPasswordFieldTrustStoreConfirmPassword.gridy = 3;
		add(getJPasswordFieldTrustStoreConfirmPassword(), gbc_jPasswordFieldTrustStoreConfirmPassword);
		GridBagConstraints gbc_LabelCertificatesList = new GridBagConstraints();
		gbc_LabelCertificatesList.anchor = GridBagConstraints.WEST;
		gbc_LabelCertificatesList.insets = new Insets(5, 10, 5, 5);
		gbc_LabelCertificatesList.gridx = 0;
		gbc_LabelCertificatesList.gridy = 4;
		add(getJLabelCertificatesList(), gbc_LabelCertificatesList);
		GridBagConstraints gbc_jPanelButtons = new GridBagConstraints();
		gbc_jPanelButtons.anchor = GridBagConstraints.WEST;
		gbc_jPanelButtons.insets = new Insets(0, 0, 5, 5);
		gbc_jPanelButtons.fill = GridBagConstraints.VERTICAL;
		gbc_jPanelButtons.gridx = 1;
		gbc_jPanelButtons.gridy = 4;
		add(getJPanelButtons(), gbc_jPanelButtons);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 10, 10, 10);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 5;
		add(getScrollPane(), gbc_scrollPane);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
	}
	/**
	 * This method initializes jPanelButtons.
	 */
	private JPanel getJPanelButtons() {
		if (jPanelButtons == null) {
			jPanelButtons = new JPanel();
			GridBagLayout gbl_jPanelButtons = new GridBagLayout();
			gbl_jPanelButtons.columnWidths = new int[] { 0, 0, 0 };
			gbl_jPanelButtons.rowHeights = new int[] { 32, 0 };
			gbl_jPanelButtons.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			gbl_jPanelButtons.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			jPanelButtons.setLayout(gbl_jPanelButtons);
			GridBagConstraints gbc_jButtonAddCertificate = new GridBagConstraints();
			gbc_jButtonAddCertificate.insets = new Insets(0, 0, 0, 5);
			gbc_jButtonAddCertificate.gridx = 0;
			gbc_jButtonAddCertificate.gridy = 0;
			jPanelButtons.add(getJButtonAddCertificate(), gbc_jButtonAddCertificate);
			GridBagConstraints gbc_jButtonRemoveCertificate = new GridBagConstraints();
			gbc_jButtonRemoveCertificate.gridx = 1;
			gbc_jButtonRemoveCertificate.gridy = 0;
			jPanelButtons.add(getJButtonRemoveCertificate(), gbc_jButtonRemoveCertificate);
		}
		return jPanelButtons;
	}
	/**
	 * This method initializes jLabelTrustStoreInformations.
	 */
	private JLabel getJLabelTrustStoreInformations() {
		if (jLabelTrustStoreInformations == null) {
			jLabelTrustStoreInformations = new JLabel("TrustStore Informations");
			jLabelTrustStoreInformations.setFont(new Font("Dialog", Font.BOLD, 11));
		}
		return jLabelTrustStoreInformations;
	}
	/**
	 * This method initializes jLabelTruststoreName.
	 */
	private JLabel getJLabelTruststoreName() {
		if (jLabelTruststoreName == null) {
			jLabelTruststoreName = new JLabel("TrustStore Name");
			jLabelTruststoreName.setFont(new Font("Dialog", Font.PLAIN, 11));
		}
		return jLabelTruststoreName;
	}
	/**
	 * This method initializes jLabelTrustStorePassword.
	 */
	private JLabel getJLabelTrustStorePassword() {
		if (jLabelTrustStorePassword == null) {
			jLabelTrustStorePassword = new JLabel("Password");
			jLabelTrustStorePassword.setFont(new Font("Dialog", Font.PLAIN, 11));
		}
		return jLabelTrustStorePassword;
	}
	/**
	 * This method initializes jLabelTrustStoreConfirmPassword.
	 */
	private JLabel getJLabelTrustStoreConfirmPassword() {
		if (jLabelTrustStoreConfirmPassword == null) {
			jLabelTrustStoreConfirmPassword = new JLabel("Confirm Password");
			jLabelTrustStoreConfirmPassword.setFont(new Font("Dialog", Font.PLAIN, 11));
		}
		return jLabelTrustStoreConfirmPassword;
	}
	/**
	 * This method initializes jTextFieldTrustStoreName.
	 */
	protected JTextField getJTextFieldTrustStoreName() {
		if (jTextFieldTrustStoreName == null) {
			jTextFieldTrustStoreName = new JTextField();
			jTextFieldTrustStoreName.setEnabled(false);
			jTextFieldTrustStoreName.setPreferredSize(this.fieldSize);
		}
		return jTextFieldTrustStoreName;
	}
	/**
	 * This method initializes jPasswordFieldTrustStorePassword.
	 */
	protected JPasswordField getJPasswordFieldTrustStorePassword() {
		if (jPasswordFieldTrustStorePassword == null) {
			jPasswordFieldTrustStorePassword = new JPasswordField();
			jPasswordFieldTrustStorePassword.setEnabled(false);
			jPasswordFieldTrustStorePassword.setPreferredSize(this.fieldSize);
		}
		return jPasswordFieldTrustStorePassword;
	}
	/**
	 * This method initializes jPasswordFieldTrustStoreConfirmPassword.
	 */
	protected JPasswordField getJPasswordFieldTrustStoreConfirmPassword() {
		if (jPasswordFieldTrustStoreConfirmPassword == null) {
			jPasswordFieldTrustStoreConfirmPassword = new JPasswordField();
			jPasswordFieldTrustStoreConfirmPassword.setEnabled(false);
			jPasswordFieldTrustStoreConfirmPassword.setPreferredSize(this.fieldSize);
		}
		return jPasswordFieldTrustStoreConfirmPassword;
	}
	/**
	 * Sets JPasswordFieldTrustStoreConfirmPassword.
	 *
	 * @param jPasswordFieldTrustStoreConfirmPassword
	 */
	protected void setJPasswordFieldTrustStoreConfirmPassword(JPasswordField jPasswordFieldTrustStoreConfirmPassword) {
		this.jPasswordFieldTrustStoreConfirmPassword = jPasswordFieldTrustStoreConfirmPassword;
	}
	/**
	 * This method initializes jLabelCertificatesList.
	 */
	protected JLabel getJLabelCertificatesList() {
		if (jLabelCertificatesList == null) {
			jLabelCertificatesList = new JLabel("Trusted Certificates:");
			jLabelCertificatesList.setFont(new Font("Dialog", Font.BOLD, 11));
		}
		return jLabelCertificatesList;
	}
	/**
	 * This method initializes jButtonApplyTrustStore.
	 */
	private JButton getJButtonApplyTrustStore() {
		if (jButtonApplyTrustStore == null) {
			jButtonApplyTrustStore = new JButton("");
			jButtonApplyTrustStore.setToolTipText("Save");
			jButtonApplyTrustStore.setForeground(new Color(0, 0, 255));
			jButtonApplyTrustStore.setFont(new Font("Dialog", Font.BOLD, 12));
			jButtonApplyTrustStore.setPreferredSize(new Dimension(26, 26));
			jButtonApplyTrustStore.setIcon(iconSave);
			jButtonApplyTrustStore.addActionListener(this);
		}
		return jButtonApplyTrustStore;
	}
	/**
	 * This method initializes jButtonAddCertificate.
	 */
	protected JButton getJButtonAddCertificate() {
		if (jButtonAddCertificate == null) {
			jButtonAddCertificate = new JButton();
			jButtonAddCertificate.setToolTipText("Add Certificate ");
			jButtonAddCertificate.setPreferredSize(new Dimension(35, 26));
			jButtonAddCertificate.setFont(new Font("SansSerif", Font.BOLD, 15));
			jButtonAddCertificate.setIcon(iconAdd);
			jButtonAddCertificate.addActionListener(this);
		}
		return jButtonAddCertificate;
	}
	/**
	 * This method initializes jButtonRemoveCertificate.
	 */
	protected JButton getJButtonRemoveCertificate() {
		if (jButtonRemoveCertificate == null) {
			jButtonRemoveCertificate = new JButton();
			jButtonRemoveCertificate.setToolTipText("Remove Certificate");
			jButtonRemoveCertificate.setPreferredSize(new Dimension(35, 26));
			jButtonRemoveCertificate.setFont(new Font("SansSerif", Font.BOLD, 15));
			jButtonRemoveCertificate.setIcon(iconRemove);
			jButtonRemoveCertificate.addActionListener(this);
		}
		return jButtonRemoveCertificate;
	}
	/**
	 * This method initializes scrollPane.
	 */
	protected JScrollPane getScrollPane() {
		if (jscrollPane == null) {
			jscrollPane = new JScrollPane();
			jscrollPane.setViewportView(getListCertificatesAlias());
		}
		return jscrollPane;
	}
	/**
	 * This method initializes jListCertificatesAlias.
	 */
	protected JList<String> getListCertificatesAlias() {
		if (jListCertificatesAlias == null) {
			jListCertificatesAlias = new JList<String>();
			jListCertificatesAlias.setVisibleRowCount(4);
		}
		return jListCertificatesAlias;
	}
	/**
	 * This method initializes jFileChooser.
	 */
	protected JFileChooser getJFileChooser() {
		if (jFileChooser == null) {
			jFileChooser = new JFileChooser();
			jFileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
			jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		}
		return jFileChooser;
	}
	/**
	 * This method initializes jFileChooser.
	 */
	protected JFileChooser getJFileChooserFile() {
		if (jFileChooserFile == null) {
			jFileChooserFile = new JFileChooser();
			jFileChooserFile.setDialogType(JFileChooser.SAVE_DIALOG);
			jFileChooserFile.setFileSelectionMode(JFileChooser.FILES_ONLY);
		}
		return jFileChooserFile;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent ae) {
		// ---- Save changes in case of creating of editing TrustStore ----
		if (ae.getSource() == this.getJButtonApplyTrustStore()) {
			// ----- Create TrustStore ------------------------------------
			if (this.httpsConfigWindow.getTrustStoreButtonPressed() == "CreateTrustStore") {
				// ---- Verify if all the fields are filled --------
				if (jTextFieldTrustStoreName.getText().equals("") 
						|| jPasswordFieldTrustStorePassword.getPassword().equals("")
						|| jPasswordFieldTrustStoreConfirmPassword.getPassword().equals("")) {

					JOptionPane.showMessageDialog(frame, "You must fill out all required fields.");
				}
				/*
				 * ----- Verify if The password and its confirm -----
				 * ---------------- are the same --------------------
				 */
				else if (!Arrays.equals(jPasswordFieldTrustStorePassword.getPassword(),jPasswordFieldTrustStoreConfirmPassword.getPassword())) {
					JOptionPane.showMessageDialog(frame, "The password and its confirm are not the same");
				}
				/*
				 * ----- Verify if the password is at least ----------
				 * ------------- 6 characters in length --------------
				 */
				else if (jPasswordFieldTrustStorePassword.getPassword().length < 6) {
					JOptionPane.showMessageDialog(frame, "The password should be at least 6 characters in length");
				}else {
					String trustStoreName = jTextFieldTrustStoreName.getText() + "TrustStore.jks";
					String trustStorePassword = new String (jPasswordFieldTrustStorePassword.getPassword());
					this.httpsConfigWindow.setTrustStorePassword(trustStorePassword);
					getJFileChooser();
					int jfile = jFileChooser.showSaveDialog(null);
					if (jfile == JFileChooser.APPROVE_OPTION) {
						this.httpsConfigWindow.setTrustStorefilepath(jFileChooser.getSelectedFile().getAbsoluteFile().getAbsolutePath() + "\\"+trustStoreName); 
						TrustStoreController.CreateTrustStore(this.httpsConfigWindow.getTrustStorefilepath(),
								this.httpsConfigWindow.getTrustStorePassword(),this.httpsConfigWindow.getTrustStorefilepath());
						JOptionPane.showMessageDialog(frame, "Your TrustStore has been created successfully");
						this.httpsConfigWindow.getJLabelTrustStoreLocationPath()
								.setText(this.httpsConfigWindow.getTrustStorefilepath());
						jTextFieldTrustStoreName.setEnabled(false);
						jLabelCertificatesList.setVisible(true);
						jscrollPane.setVisible(true);
						jButtonAddCertificate.setVisible(true);
						jButtonRemoveCertificate.setVisible(true);
						jPasswordFieldTrustStoreConfirmPassword.setText(null);
						jPasswordFieldTrustStorePassword.setText(trustStorePassword);
						jTextFieldTrustStoreName.setText(this.httpsConfigWindow.getTrustStorefilepath().substring(this.httpsConfigWindow.getTrustStorefilepath().lastIndexOf("\\") + 1));
						jListCertificatesAlias.setModel(TrustStoreController.CertificatesAliaslist(
								this.httpsConfigWindow.getTrustStorefilepath(), this.httpsConfigWindow.getTrustStorePassword()));
						this.httpsConfigWindow.setTrustStoreButtonPressed("EditTrustStore");
					}
				}

			} else if (this.httpsConfigWindow.getTrustStoreButtonPressed() == "EditTrustStore") {
				// ---- Verify if all the fields are filled ----
				if (jTextFieldTrustStoreName.getText().equals("")
						|| jPasswordFieldTrustStorePassword.getPassword().equals("")
						|| jPasswordFieldTrustStoreConfirmPassword.getPassword().equals("")) {

					JOptionPane.showMessageDialog(frame, "You must fill out all required fields.");
				}
				/*
				 * ----- Verify if The password and its confirm ----
				 * ---------------- are the same -----------------
				 */
				else if (!Arrays.equals(jPasswordFieldTrustStorePassword.getPassword(),jPasswordFieldTrustStoreConfirmPassword.getPassword())) {
					JOptionPane.showMessageDialog(frame, "The password and its confirm are not the same");
				}
				/*
				 * ----- Verify if the password is at least ----------
				 * ------------- 6 characters in length --------------
				 */
				else if (jPasswordFieldTrustStorePassword.getPassword().length < 6) {
					JOptionPane.showMessageDialog(frame, "The password should be at least 6 characters in length");
				} else {
					String newTrustStorePassword = new String(jPasswordFieldTrustStorePassword.getPassword());
					String keystorename = this.httpsConfigWindow.getTrustStorefilepath().substring(this.httpsConfigWindow.getTrustStorefilepath().lastIndexOf("\\") + 1);
					// --- Create JOptionPane to enter the old TrustStore password ---
					JPanel jPanelPassword = new JPanel();
					JLabel jLabelEnterPassword = new JLabel("Please enter the old password for  " + keystorename + "  :");
					jLabelEnterPassword.setFont(new Font("Dialog", Font.BOLD, 11));
					JPasswordField jPasswordField = new JPasswordField(10);
					jPanelPassword.add(jLabelEnterPassword);
					jPanelPassword.add(jPasswordField);
					String[] options = new String[] { "OK", "Cancel" };
					int option = JOptionPane.showOptionDialog(null, jPanelPassword, "Password", JOptionPane.NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, jPasswordField);
					String oldPassword = new String(jPasswordField.getPassword());
					if (option == 0) {
						// ------------ Press OK -------------------------------
						if (this.httpsConfigWindow.getTrustStorePassword().equals(oldPassword)){
							TrustStoreController.EditTrustStore(this.httpsConfigWindow.getTrustStorefilepath(),
									this.httpsConfigWindow.getTrustStorePassword(), newTrustStorePassword);
							JOptionPane.showMessageDialog(frame, "Your TrustStore has been updated successfully ");
							this.httpsConfigWindow.setTrustStorePassword(newTrustStorePassword);
							jPasswordFieldTrustStoreConfirmPassword.setText(null);
							jPasswordFieldTrustStorePassword.setText(newTrustStorePassword);
						}else{
							JOptionPane.showMessageDialog(frame,
									"The password you entered is incorrect. Please try again !",
									"Warning message", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		}else if (ae.getSource() == this.getJButtonAddCertificate()) {
			// ----- Add certificate to TrustStore ----------------------
			// ----- Verify if there is a TrustStore opened ----
			if (this.httpsConfigWindow.getTrustStorefilepath() == null) {
				JOptionPane.showMessageDialog(frame, "Please open a Truststore first !", "Warning message",
						JOptionPane.WARNING_MESSAGE);

			} else {
				// ---- open JfileChooser ---------------------------------
				this.httpsConfigWindow.getJFileChooser();
				int result = this.httpsConfigWindow.getJFileChooser().showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					// ---- Choose the certificate to add ------------
					String certificateToAdd = this.httpsConfigWindow.getJFileChooser().getSelectedFile().getPath();
					// ----- Generate a JOptionDialog to enter ----\\
					// -------------- Certificate alias ------------\\
					JPanel jPanelCertificate = new JPanel();
					JLabel jLabelCertificate = new JLabel("Please Enter Certificate's alias :");
					jLabelCertificate.setFont(new Font("Dialog", Font.BOLD, 11));
					JTextField jTextFieldAlias = new JTextField(10);
					jPanelCertificate.add(jLabelCertificate);
					jPanelCertificate.add(jTextFieldAlias);
					String[] options = new String[] { "OK", "Cancel" };
					int option = JOptionPane.showOptionDialog(null, jPanelCertificate, "Message", JOptionPane.NO_OPTION,
							JOptionPane.PLAIN_MESSAGE, null, options, jTextFieldAlias);
					String certificateAlias = jTextFieldAlias.getText();
					
					if (option == 0) {
						if (certificateAlias.equals("")) {
							JOptionPane.showMessageDialog(frame, "Please enter your certificate's alias !",
									"Warning message", JOptionPane.WARNING_MESSAGE);
						} else {
							// ------------ Press OK Button --------------------
							TrustStoreController.AddCertificateToTrustStore(this.httpsConfigWindow.getTrustStorefilepath(),
									this.httpsConfigWindow.getTrustStorePassword(), certificateToAdd, certificateAlias);
							TrustStoreController.Certificateslist();
							jListCertificatesAlias.setModel(TrustStoreController.CertificatesAliaslist(
									this.httpsConfigWindow.getTrustStorefilepath(),
									this.httpsConfigWindow.getTrustStorePassword()));
						}
					}
				} else {
					this.httpsConfigWindow.getJFileChooser().remove(this.httpsConfigWindow.getJFileChooser());
				}
			}
		}else if (ae.getSource() == this.getJButtonRemoveCertificate()) {
			// ----- Delete certificate to TrustStore ----------------------
			// ----- Verify if there is a TrustStore opened ----------------
			if (this.httpsConfigWindow.getTrustStorefilepath() == null) {
				JOptionPane.showMessageDialog(frame, "Please open a Truststore first !", "Warning message",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (jListCertificatesAlias.isSelectionEmpty()) {
					Component frame = null;
					JOptionPane.showMessageDialog(frame, "You should select a certificate", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else {
					// ------ Get the certificate's alias to delete ----
					String CertificateAliasToDelete = jListCertificatesAlias.getSelectedValue() + "";
					// --------- Generate a ConfirmDialog --------------
					String[] options = new String[] { "Yes", "No" };
					int option = JOptionPane.showOptionDialog(null, "Would You Like to delete this Certificate ?",
							"Warning", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
					if (option == JOptionPane.YES_OPTION) {
						// ----- press OK Button ----------------------
						TrustStoreController.DeleteCertificateFromTrustStore(this.httpsConfigWindow.getTrustStorefilepath(),
								this.httpsConfigWindow.getTrustStorePassword(), CertificateAliasToDelete);
						TrustStoreController.Certificateslist();
						jListCertificatesAlias.setModel(
								TrustStoreController.CertificatesAliaslist(this.httpsConfigWindow.getTrustStorefilepath(),
										this.httpsConfigWindow.getTrustStorePassword()));
					}
				}
			}
		
		}
	}
}