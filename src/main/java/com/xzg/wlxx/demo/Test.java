package com.xzg.wlxx.demo;

import javax.net.ssl.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.Permission;
import java.security.cert.CertificateException;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/12/21
 */
public class Test {
    public static void main(String[] args) throws Exception{
//        String urlStr = "https://my300522-api.saps4hanacloud.cn/sap/opu/odata/sap/YY1_API_EMPLOYEE_CDS/YY1_api_Employee?sap-language=zh";
        String urlStr = "http://39.104.73.237:7077/createToken";
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Authorization","Basic VEVTVFVTRVJJTjpXcVhka0pkR2t0RHV4M1JDd1NCS3Fub3Z1WkUrUFlOd1VnS0N4RVZu");
        conn.addRequestProperty("Cookie","sap-usercontext=sap-language=zh&sap-client=100; SAP_SESSIONID_TWE_100=lGThiU1NizfNAhu77szLnF1l5edDlRHrnkb6Fj6_RGI%3d");
//        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("GET");
//        conn.setInstanceFollowRedirects(false);

//        OutputStream os = conn.getOutputStream();

        Reader read = new InputStreamReader(conn.getInputStream());
        String res = "";
        int n = -1;
        while((n=read.read())!=-1){
            res += (char)n+"";
        }
        System.out.println(res);
    }
    public static void disableSslVerification() {
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] x509Certificates, String s) throws CertificateException {

                }

                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }
            };
            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };
            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
