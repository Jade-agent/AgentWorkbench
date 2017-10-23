package de.enflexit.common;

import java.awt.HeadlessException;

import javax.swing.JDialog;

/**
 * The Class SystemEnvironmentHelper provides some (hopeful) useful methods to information .
 * about the execution environment.
 * 
 * @author Christian Derksen - DAWIS - ICB - University of Duisburg - Essen
 */
public class SystemEnvironmentHelper {

	
	/**
	 * Returns the operating system by calling <code>System.getProperty("os.name")</code>.
	 * @return the operating system
	 */
	public static String getOperatingSystem() {
		return System.getProperty("os.name");
	}
	/**
	 * Checks if the current operating system is windows.
	 * @return true, if is windows operating system
	 */
	public static boolean isWindowsOperatingSystem() {
		return getOperatingSystem().toLowerCase().startsWith("windows");
	}
	/**
	 * Checks if the current operating system is Linux.
	 * @return true, if is Linux operating system
	 */
	public static boolean isLinuxOperatingSystem() {
		return getOperatingSystem().toLowerCase().startsWith("linux");
	}
	/**
	 * Checks if the current operating system is Mac OS X.
	 * @return true, if is Mac OS X operating system
	 */
	public static boolean isMacOperatingSystem() {
		return getOperatingSystem().toLowerCase().startsWith("mac");
	}

	/**
	 * Return the version of the operating systems by calling <code>System.getProperty("os.version")</code>.
	 * @return the operating systems version
	 */
	public static String getOperatingSystemsVersion() {
		return System.getProperty("os.version");
	}
	/**
	 * Return the architecture of the operating systems by calling <code>System.getProperty("os.arch")</code>.
	 * @return the operating systems version
	 */
	public static String getOperatingSystemsArchitecture() {
		return System.getProperty("os.arch");
	}

	
	/**
	 * Checks if the current system environment is executed headless (without any GUI).
	 * @return true, if is headless operation
	 */
	public static boolean isHeadlessOperation() {

		boolean headlessOperation=false;
		// --- Do headless check ----------------------
		JDialog jDialog;
		try {
			jDialog = new JDialog();
			jDialog.validate();
//			jDialog.dispose();
			jDialog = null;
			headlessOperation = false;
			
		} catch (HeadlessException he) {
			headlessOperation = true;
		}
		return headlessOperation;
	}
	
}
