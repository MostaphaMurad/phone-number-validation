package com.arpu.shofha.msisdnvalidation.Service.Imp;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class CountryDetectionServiceImp {
    private static String URL="http://51.15.161.205/Country/country/";
    public String getCountryNameByIpAddress(String ipAddress) {
        String geoName = getCountryName(URL+ ipAddress);
        if (geoName == null || geoName.isEmpty() || geoName.equals("null") || geoName.equalsIgnoreCase("N/A")) {
            geoName = "Egypt";
        }
        return geoName;
    }
    private String getCountryName(String targetUrl) {
        HttpURLConnection httpUrlConn;
        try {
            httpUrlConn = (HttpURLConnection) new URL(targetUrl).openConnection();
            httpUrlConn.setConnectTimeout(30000);
            httpUrlConn.setReadTimeout(30000);
            BufferedReader in = new BufferedReader(new InputStreamReader(httpUrlConn.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } catch (Exception e) {

        }
        return null;
    }
}
