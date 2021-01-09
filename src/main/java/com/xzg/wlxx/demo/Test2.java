package com.xzg.wlxx.demo;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/12/21
 */
public class Test2 {
    public static void main(String[] args) throws Exception{
        String urlStr = "https://my300522-api.saps4hanacloud.cn/sap/bc/srt/scs_ext/sap/journalentrycreaterequestconfi?wsdl";
        URL url = new URL(urlStr);

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Authorization","Basic VEVTVFVTRVJJTjpXcVhka0pkR2t0RHV4M1JDd1NCS3Fub3Z1WkUrUFlOd1VnS0N4RVZu");
        conn.addRequestProperty("Cookie","sap-usercontext=sap-language=zh&sap-client=100; SAP_SESSIONID_TWE_100=lGThiU1NizfNAhu77szLnF1l5edDlRHrnkb6Fj6_RGI%3d");
//        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestMethod("POST");
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
}
