package com.javastream.utils;

import com.javastream.configs.Settings;
import com.javastream.uriParamsCreator.UriParamsCreator;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class PushRunner {

    private static final Logger logger = LoggerFactory.getLogger(PushRunner.class);

    private final static String HTTPS_ADDRESS = "https://";
    private final static String SLASH_PATTERN = "/";
    private final static String REST_FIELD = "rest";

    public static JSONObject post(UriParamsCreator params, String method) {
        JSONObject jsonResult = null;
        HttpClient httpClient = HttpClientBuilder.create().build();

        String url = HTTPS_ADDRESS + getAccount() + SLASH_PATTERN + REST_FIELD + SLASH_PATTERN + getRestID() + SLASH_PATTERN +
                getToken() + SLASH_PATTERN + method + params;

        HttpPost request = new HttpPost(url);
        request.addHeader("content-type", "application/json");

        try {
            HttpResponse response = httpClient.execute(request);
            logger.info("Request {}, status of response: {}", method, response.getStatusLine().getStatusCode());

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String result;
                while ((result = rd.readLine()) != null) {
                    jsonResult = new JSONObject(result);
                }
            }
        } catch (Exception e) {
            logger.error("An error occurred while getting HttpResponse, method: {}", method, e);
        }
        return jsonResult;
    }

    public static JSONObject get(UriParamsCreator params, String method) {
        JSONObject jsonResult = null;
        HttpClient httpClient = HttpClientBuilder.create().build();

        String url = HTTPS_ADDRESS + getAccount() + SLASH_PATTERN + REST_FIELD + SLASH_PATTERN + getRestID() + SLASH_PATTERN +
                getToken() + SLASH_PATTERN + method + params;

        HttpPost request = new HttpPost(url);
        request.addHeader("content-type", "application/json");

        try {
            HttpResponse response = httpClient.execute(request);
            logger.info("Request {}, status of response: {}", method, response.getStatusLine().getStatusCode());

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String result;
                while ((result = rd.readLine()) != null) {
                    jsonResult = new JSONObject(result);
                }
            }
        } catch (Exception e) {
            logger.error("An error occurred while getting HttpResponse, method: {}", method, e);
        }
        return jsonResult;
    }

    private static String getToken() {
        return Settings.getToken();
    }

    private static String getAccount() {
        return Settings.getAccount();
    }

    private static String getRestID() {
        return Settings.getRestID().toString();
    }
}
