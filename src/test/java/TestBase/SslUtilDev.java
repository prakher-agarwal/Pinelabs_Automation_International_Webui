package TestBase;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

//import com.pinelabs.alpService.//Logger.//LoggerClass;

public class SslUtilDev {

	private String m_ClientCertificatePath;

	private String m_ServerCertificatePath;
	
	private String m_ClientCertificatePassword;
	
	public SslUtilDev(String ClientCertificatePath, String ServerCertificatePath, String ClientCertificatePassword) {
		this.m_ClientCertificatePath = ClientCertificatePath;
		this.m_ServerCertificatePath = ServerCertificatePath;
		this.m_ClientCertificatePassword = ClientCertificatePassword;
	}
	
	public SSLContext addCertificates() {
        //LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_INFORMATION, "inside addCertificates");

        SSLContext sslContext = null;
        try {
            KeyAndTrustManagers keyAndTrustManagers = trustManagerForCertificates();

            sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(keyAndTrustManagers.keyManagers, keyAndTrustManagers.trustManagers, new SecureRandom());
        }
        catch (NoSuchAlgorithmException e) {
        	//LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_ERROR, "inside addCertificatesToBpclHttpClient Error: " + e.getMessage());
            e.printStackTrace();
        }
        catch (KeyManagementException e) {
        	//LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_ERROR, "inside addCertificatesToBpclHttpClient Error: " + e.getMessage());
            e.printStackTrace();
        }
        return sslContext;
    }

    private KeyAndTrustManagers trustManagerForCertificates() {
        //LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_INFORMATION, "inside trustManagerForCertificates");
        
        KeyManagerFactory keyManagerFactory = null;
        TrustManagerFactory trustManagerFactory = null;
        try {
        	//For KeyManager
            InputStream stream = ReadCertificates(m_ClientCertificatePath);
            if(stream != null) {	
    			char[] password = m_ClientCertificatePassword != null ? m_ClientCertificatePassword.toCharArray() : new char[] {};
				KeyStore keyStoreClientCert = KeyStore.getInstance(KeyStore.getDefaultType());
				keyStoreClientCert.load(stream, password);
				stream.close();
			
				keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
				keyManagerFactory.init(keyStoreClientCert, password);
    		}
    		
            //For TrustManager
            stream = ReadCertificates(m_ServerCertificatePath);
            if(stream != null) {
    	        CertificateFactory cfCA = CertificateFactory.getInstance("X.509");
	        	Certificate caCA = cfCA.generateCertificate(stream);
	        	stream.close();
	        	
	        	KeyStore keyStoreCAs = KeyStore.getInstance(KeyStore.getDefaultType());
	        	keyStoreCAs.load(null);
				keyStoreCAs.setCertificateEntry("ca", caCA);
			
				// Use it to build an X509 trust manager.
				trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
				trustManagerFactory.init(keyStoreCAs);
            }
        }
        catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NoSuchAlgorithmException e) {
			// TODO Auto-generate\d catch block
			e.printStackTrace();
		} 
		catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        catch (UnrecoverableKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return new KeyAndTrustManagers(
			keyManagerFactory != null ? keyManagerFactory.getKeyManagers() : null,
			trustManagerFactory != null ? trustManagerFactory.getTrustManagers() : null);
    }

    private InputStream ReadCertificates(String filepath) {
        //LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_INFORMATION, "inside ReadCertificates");
        
        InputStream inputStream = null;
        try {
            if (filepath != null && new File(filepath).exists()) {
                FileInputStream fis = new FileInputStream(filepath);
                inputStream = new BufferedInputStream(fis);
            }
            else {
            	//LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_INFORMATION, "File Not present: " + filepath);
            }
        }
        catch (IOException e) {
            //LoggerClass.LogMessage(//LoggerClass.eMessageType.MT_ERROR, "Exception Occurred!" + e.getMessage());
            e.printStackTrace();
            inputStream = null;
        }
        return inputStream;
    }

    private static class KeyAndTrustManagers {
        final KeyManager[] keyManagers;
        final TrustManager[] trustManagers;

        KeyAndTrustManagers(KeyManager[] keyManagers, TrustManager[] trustManagers) {
            this.keyManagers = keyManagers;
            this.trustManagers = trustManagers;
        }
    }
	
}
