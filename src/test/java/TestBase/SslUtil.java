package TestBase;//package com.pinelabs.alpService;

//import com.pinelabs.alpService.Logger.LoggerClass;

import org.apache.http.client.HttpClient;
import org.testng.annotations.Test;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SslUtil {
    private static HttpsURLConnection connection;

    @Test
    public void m1() throws IOException {
        URL url = new URL("https://14.141.92.54:8202/API/IrisService/V2/auth/getJWTToken");
        connection = (HttpsURLConnection) url.openConnection();
        connection.setHostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return false;
            }
        });
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status = connection.getResponseCode();
        System.out.println(status);
    }
}
