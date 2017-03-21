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
package agentgui.core.config.auth;

import java.awt.Dimension;
import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JDialog;

import com.nimbusds.oauth2.sdk.ParseException;
import com.nimbusds.oauth2.sdk.token.AccessToken;

import agentgui.core.application.Application;

/**
 * This class provides a simple interface to the OpenID Connect authorisation.
 * Use with getInstance(), getDialog()/connect() and getUserID().
 */
public class OIDCAuthorization {

	/** The claim representing the user ID in OIDC (subject) */
	private static final String OIDC_ID_CLAIM_USERID = "sub";

	/** The single instance of this singleton class. */
	private static OIDCAuthorization instance;

	/** The OIDC client. */
	private SimpleOIDCClient oidcClient;

	/** The accessed resource URI, initialized with @see OIDCPanel.DEBUG_RESOURCE_URI. */
	private String resourceURI = OIDCPanel.DEBUG_RESOURCE_URI;

	/** The URI of the OIDC provider/issuer. */
	private String issuerURI = OIDCPanel.DEBUG_ISSUER_URI;

	/** The availability handler called when the resource is available. */
	private OIDCResourceAvailabilityHandler availabilityHandler;

	/** The URLProcessor used for the network communication. */
	private URLProcessor urlProcessor;

	/** The authorization dialog. */
	private JDialog authDialog;

	/**
	 * Instantiates a new OIDC authorization.
	 */
	private OIDCAuthorization() {
		urlProcessor = new URLProcessor();
	}

	/**
	 * Gets the single instance of OIDCAuthorization.
	 *
	 * @return single instance of OIDCAuthorization
	 */
	public static OIDCAuthorization getInstance() {
		if (instance == null) {
			instance = new OIDCAuthorization();
		}
		return instance;
	}

	/**
	 * Gets the OIDC client.
	 * 
	 * @return the OIDC client
	 */
	public SimpleOIDCClient getOIDCClient() {
		if (oidcClient == null) {
			oidcClient = new SimpleOIDCClient();
		}
		return oidcClient;
	}

	/**
	 * Gets the url processor.
	 *
	 * @return the url processor
	 */
	public URLProcessor getUrlProcessor() {
		return urlProcessor;
	}

	/**
	 * Sets the trust store.
	 *
	 * @param truststoreFile the new trust store
	 */
	public void setTrustStore(File truststoreFile) {
		getOIDCClient();
		oidcClient.setTrustStore(truststoreFile);
	}

	/**
	 * Sets the availability handler.
	 *
	 * @param availabilityHandler the availability handler
	 * @return the OIDC authorization
	 */
	public OIDCAuthorization setAvailabilityHandler(OIDCResourceAvailabilityHandler availabilityHandler) {
		this.availabilityHandler = availabilityHandler;
		return this;
	}

	/**
	 * Gets the issuer URI.
	 * 
	 * @return the issuer URI
	 */
	public String getIssuerURI() {
		return issuerURI;
	}

	/**
	 * Sets the issuer URI.
	 *
	 * @param issuerURI the new issuer URI
	 */
	public void setIssuerURI(String issuerURI) {
		this.issuerURI = issuerURI;
	}

	/**
	 * Gets the resource URI.
	 * 
	 * @return the resource URI
	 */
	public String getResourceURI() {

		return resourceURI;
	}

	/**
	 * Sets the resource URI.
	 *
	 * @param resourceURI the new resource URI
	 */
	public void setResourceURI(String resourceURI) {
		this.resourceURI = resourceURI;
	}

	/**
	 * Gets the client id.
	 * 
	 * @return the client id
	 */
	public String getClientID() {
		return OIDCPanel.DEBUG_CLIENT_ID;
	}

	/**
	 * Gets the client secret.
	 * 
	 * @return the client secret
	 */
	public String getClientSecret() {
		return OIDCPanel.DEBUG_CLIENT_SECRET;
	}

	/**
	 * Gets the authorization dialog (with null defaults).
	 *
	 * @return the dialog
	 */
	public JDialog getDialog() {
		if (authDialog == null) {
			authDialog = getDialog("", null);
		}
		return authDialog;
	}

	/**
	 * Gets the authorization dialog.
	 *
	 * @param presetUsername username which should be shown preset when displaying the dialog
	 * @param ownerFrame the frame to which the dialog should belong (to center etc.)
	 * @return the dialog
	 */
	public JDialog getDialog(String presetUsername, Frame ownerFrame) {

		authDialog = new JDialog(ownerFrame);
		OIDCPanel oidcPanel = new OIDCPanel(this);
		if (presetUsername != null) {
			oidcPanel.getJTextFieldUsername().setText(presetUsername);
		}
		authDialog.setContentPane(oidcPanel);
		authDialog.setSize(new Dimension(500, 190));
		authDialog.setLocationRelativeTo(null);
		return authDialog;
	}

	/**
	 * Checks if OIDC token is valid, so access has been granted.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		if (getOIDCClient().getAccessToken() != null) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the unique ID of the user authenticated.
	 *
	 * @return the user ID
	 * @throws OIDCProblemException if the token is not valid/the user is not authenticated yet
	 */
	public String getUserID() throws OIDCProblemException {
		String userID;
		if (!isValid()) {
			throw new OIDCProblemException();
		}
		Map<String, Object> allClaims = getOIDCClient().getIdClaims().getClaims();
		userID = (String) allClaims.get(OIDC_ID_CLAIM_USERID);

		if (userID != null) {
			return userID;
		}
		return "";
	}

	/**
	 * Inits the authorization process.
	 */
	public void init() {
		getOIDCClient();
		oidcClient.reset();
		urlProcessor = new URLProcessor();

		try {
			oidcClient.setIssuerURI(getIssuerURI());
			oidcClient.retrieveProviderMetadata();
			oidcClient.setClientMetadata(getResourceURI());
			oidcClient.setClientID(getClientID(), getClientSecret());
			oidcClient.setRedirectURI(getResourceURI());
			urlProcessor.prepare(oidcClient.getRedirectURI().toURL());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Connect to the authorization server and get a valid token.
	 *
	 * @param username the username
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean connect(String username, String password) {
		String authRedirection = "";
		AccessToken accessToken = null;

		try {
//			System.out.println("try a direct access to the resource");
			authRedirection = urlProcessor.process();

			if (authRedirection == null) { 	// no authentication required
				System.out.println("resource available");
				if (availabilityHandler != null) {
					availabilityHandler.onResourceAvailable(urlProcessor);
				}
				return true;
			}

//			System.out.println("authentication redirection necessary");

//			System.out.println("parse authentication parameters from redirection");
			oidcClient.parseAuthenticationDataFromRedirect(authRedirection, false); // don't override clientID
//			System.out.println("set USER credentials");
			oidcClient.setResourceOwnerCredentials(username, password);

			oidcClient.requestToken();
			accessToken = oidcClient.getAccessToken();

//			System.out.println("This is the access token");
//			System.out.println(accessToken);
			urlProcessor.setAccessToken(accessToken);

//			System.out.println("access the resource again, this time sending an access token");
			authRedirection = urlProcessor.prepare(oidcClient.getRedirectURI().toURL()).process();
			if (authRedirection == null) { 	// authenticated
//				System.out.println("resource available now");

				if (availabilityHandler != null) {
					availabilityHandler.onResourceAvailable(urlProcessor);
				}
				return true;
			} else {
				System.err.println("OIDC authorization failed");
				System.err.println("authRedirection=" + authRedirection);
				return false;
			}

		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Access resource.
	 *
	 * @param url the url
	 * @param presetUsername the preset username
	 * @param ownerFrame the owner frame
	 */
	public void accessResource(String url, String presetUsername, Frame ownerFrame) {
		try {
			setResourceURI(url);
			String result = urlProcessor.prepare(new URL(getResourceURI())).process();
			if (result == null) {
				// all good (unlikely on first call)
			} else {
				getDialog(presetUsername, ownerFrame).setVisible(true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Optional: UserInfo request
	/**
	 * Try to access a resource secured by OIDC (currently that means: print user ID ).
	 *
	 * @param accessToken the access token
	 * @return the string
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Alternatively: pass Access Token on to another client, use it to access a resource there
	public String accessUserID(AccessToken accessToken) throws ParseException, IOException {

		if (accessToken != null) {
//			System.out.println(OIDCAuthorization.getInstance().getUserID());

//			getOIDCClient().dumpTokenInfo();
			// only for debugging
//			getOIDCClient().requestUserInfo();
//			System.out.println("UserInfoJSON:");
//			System.out.println(getOIDCClient().getUserInfoJSON() + "");
		}
		return urlProcessor.prepare(getOIDCClient().getRedirectURI().toURL()).process();
	}

	/**
	 * The Class URLProcessor.
	 */
	public class URLProcessor {

		/** The Constant CHARSET_UTF_8. */
		private static final String CHARSET_UTF_8 = "UTF-8";

		/** The Constant CRLF. */
		private static final String CRLF = "\r\n"; // Line separator required by multipart/form-data.

		/** The Constant CONTENT_DISPOSITION_NAME. */
		private static final String CONTENT_DISPOSITION_NAME = "file";

		/** The Constant HTTP_METHOD_POST. */
		private static final String HTTP_METHOD_POST = "POST";

		/** The debug. */
		private boolean debug = false;

		/** The upload file. */
		private File uploadFile;

		/** The connection. */
		private HttpsURLConnection connection = null;

		/** The access token. */
		private AccessToken accessToken;

		/** The redirection URL. */
		private String redirectionURL = null;

		/** The response code. */
		private int responseCode = -1;

		/**
		 * Sets the upload file.
		 *
		 * @param uploadFile the new upload file
		 */
		public void setUploadFile(File uploadFile) {
			this.uploadFile = uploadFile;
			injectUpload();
		}

		/**
		 * Gets the upload file.
		 *
		 * @return the upload file
		 */
		public File getUploadFile() {
			return uploadFile;
		}

		/**
		 * Gets the connection.
		 *
		 * @return the connection
		 */
		public HttpsURLConnection getConnection() {
			return connection;
		}

		/**
		 * Gets the redirection URL.
		 *
		 * @return the redirection URL
		 */
		public String getRedirectionURL() {
			return redirectionURL;
		}

		/**
		 * Gets the response code.
		 *
		 * @return the response code
		 */
		public int getResponseCode() {
			return responseCode;
		}

		/**
		 * Sets the access token.
		 *
		 * @param accessToken the access token
		 * @return the URL processor
		 */
		public URLProcessor setAccessToken(AccessToken accessToken) {
			this.accessToken = accessToken;
			return this;
		}

		/**
		 * Prepare.
		 *
		 * @param requestURL the request URL
		 * @return the URL processor
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public URLProcessor prepare(URL requestURL) throws IOException {
//			System.out.println("requestURL=");
//			System.out.println(requestURL);

			connection = (HttpsURLConnection) requestURL.openConnection();
			connection.setInstanceFollowRedirects(false);
			Trust.trustSpecific(connection, new File(Application.getGlobalInfo().getPathProperty(true) + Trust.OIDC_TRUST_STORE));

			connection.setRequestMethod("GET");
			if (accessToken != null) {
				connection.setRequestProperty("Authorization", "Bearer " + accessToken);
			}

			if (uploadFile != null) {
				injectUpload();
			}

			return this;
		}

		/**
		 * Process a URL, that is: try to access it's resource, display error if any, return a redirection URL if indicated by the server.
		 *
		 * @return null if the access succeeded, a redirectionURL as string in case the authorization is not valid yet
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public String process() throws IOException {
			connection.connect();

			responseCode = connection.getResponseCode();

			if (responseCode == 200) { //
				redirectionURL = null;
			} else if (responseCode == 302) {
				redirectionURL = connection.getHeaderField("Location");
				if (debug) {
					System.out.println("redirection to:");
					System.out.println(redirectionURL);
				}
			} else {
				if (debug) {
					System.out.println("other response code");
				}
			}
			if (debug) {
				System.out.println("responseCode = " + responseCode);
			}
			return redirectionURL;
		}

		/**
		 * Inject upload.
		 */
		public void injectUpload() {
			String charset = CHARSET_UTF_8;
			String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.

			try {
				connection.setRequestMethod(HTTP_METHOD_POST);
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

				OutputStream output = connection.getOutputStream();
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, charset), true);

				// Send binary file.
				writer.append("--" + boundary).append(CRLF);
				writer.append("Content-Disposition: form-data; name=\"" + CONTENT_DISPOSITION_NAME + "\"; filename=\"" + uploadFile.getName() + "\"").append(CRLF);

				String mediaType = URLConnection.guessContentTypeFromName(uploadFile.getName());
				if (mediaType != null) {
					writer.append("Content-Type: " + mediaType).append(CRLF);
				}

				writer.append("Content-Transfer-Encoding: binary").append(CRLF);
				writer.append(CRLF).flush();
				Files.copy(uploadFile.toPath(), output);
				output.flush(); // Important before continuing with writer
				writer.append(CRLF).flush(); // CRLF is important, indicates end o)f boundary

				// End of multipart/form-data
				writer.append("--" + boundary + "--").append(CRLF).flush();
			} catch (ProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * The Class OIDCProblemException, indicating a problem in the authorization process.
	 */
	class OIDCProblemException extends RuntimeException {

		/** The Constant serialVersionUID. */
		private static final long serialVersionUID = -6015464771451068526L;

	}
}
