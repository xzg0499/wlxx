package com.xzg.wlxx.demo.huang;

import cn.hutool.core.util.XmlUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: xzgang
 * Date: 2020/12/22
 */
public class Test4 {
    public static void main(String[] args) throws Exception{
        String urlStr = "http://39.104.73.237:7077/createToken";

        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("Content-Type","application/json");
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        String req = "{\n" +
                "    \"userName\": \"oadevtest\",\n" +
                "    \"passWord\": \"ceaf891fcbb5b299b8\"\n" +
                "}";
        OutputStream os = conn.getOutputStream();
        os.write(req.getBytes());
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String res = "";
        String inputLien = "";
        while((inputLien = br.readLine())!=null){
            res+= inputLien;
        }
        System.out.println(res);

    }
}
