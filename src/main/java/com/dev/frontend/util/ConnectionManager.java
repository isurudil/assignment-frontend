package com.dev.frontend.util;


import com.dev.frontend.entity.ApiEntity;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class ConnectionManager {

    private static Logger logger = Logger.getLogger(ConnectionManager.class.getName());

    public static ApiEntity POST(String url, ApiEntity apiEntity) throws IOException {
        logger.info("Getting response from API");

        HttpClient httpClient = HttpClientBuilder.create().build();

        RequestConfig requestConfig = buildRequestConfig();

        Gson gson = new Gson();
        HttpPost post = new HttpPost(url);
        post.setConfig(requestConfig);
        StringEntity postingString = new StringEntity(gson.toJson(apiEntity));
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();

        InputStream content = entity.getContent();
        String jsonString = convertInputStreamToString(content);

        return new Gson().fromJson(jsonString, ApiEntity.class);
    }


    public static String GET(String url) throws IOException {
        logger.info("Getting response from API");

        HttpClient httpClient = HttpClientBuilder.create().build();

        RequestConfig requestConfig = buildRequestConfig();

        HttpGet get = new HttpGet(url);
        get.setConfig(requestConfig);
        get.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(get);
        HttpEntity entity = response.getEntity();

        InputStream content = entity.getContent();
        return convertInputStreamToString(content);
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        String result = "";
        while ((line = bufferedReader.readLine()) != null) {
            result += line;
        }
        inputStream.close();
        logger.info("Result : " + result);
        return result;
    }

    private static RequestConfig buildRequestConfig() {
        return RequestConfig.custom()
                .setSocketTimeout(PropertyLoader.getInt("socket.timeout"))
                .setConnectTimeout(PropertyLoader.getInt("connection.timeout"))
                .setConnectionRequestTimeout(PropertyLoader.getInt("connection.request.timeout"))
                .build();
    }
}
