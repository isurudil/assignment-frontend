package com.dev.frontend.util;


import com.dev.frontend.entity.ApiEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Logger;

public class ConnectionManager {

    private static Logger logger = Logger.getLogger(ConnectionManager.class.getName());


//    public static AsyncTaskResult<String> POST(String url, Activity activity, List<NameValuePair> nameValuePairs) {
//
//        InputStream inputStream;
//        String result = "";
//        if (isConnected(activity)) {
//            try {
//                inputStream = POSTResponse(url, nameValuePairs);
//                result = convertInputStreamToString(inputStream);
//            } catch (ClientProtocolException e) {
//                Log.e(Constants.LOG_TAG, "Error in the client protocol " + e);
//            } catch (UnknownServiceException e) {
//                Log.e(Constants.LOG_TAG, "Unknown service", e);
//            } catch (IOException e) {
//                Log.e(Constants.LOG_TAG, "Error occurred while getting response from core engine", e);
//            } catch (IllegalStateException e) {
//                Log.e(Constants.LOG_TAG, "Error occurred ", e);
//            }
//            return new AsyncTaskResult<String>(result);
//        } else {
//            ConnectionFailureException exception = new ConnectionFailureException("No internet connection");
//            return new AsyncTaskResult<String>(exception);
//        }
//    }

//    public static AsyncTaskResult<String> GET(String url, Activity activity) {
//
//        InputStream inputStream;
//        String result = "";
//        if (isConnected(activity)) {
//            try {
//                inputStream = GETResponse(url);
//                result = convertInputStreamToString(inputStream);
//            } catch (ClientProtocolException e) {
//                Log.e(Constants.LOG_TAG, "Error in the client protocol " + e);
//            } catch (UnknownServiceException e) {
//                Log.e(Constants.LOG_TAG, "Unknown service", e);
//            } catch (IOException e) {
//                Log.e(Constants.LOG_TAG, "Error occurred while getting response from core engine", e);
//            } catch (IllegalStateException e) {
//                Log.e(Constants.LOG_TAG, "Error occurred ", e);
//            }
//            return new AsyncTaskResult<String>(result);
//        } else {
//            ConnectionFailureException exception = new ConnectionFailureException("No internet connection");
//            return new AsyncTaskResult<String>(exception);
//        }
//    }

    public static ApiEntity POST(String url, ApiEntity apiEntity) throws IOException {
        logger.info("Getting response from API");

        HttpClient httpClient = HttpClientBuilder.create().build();

        Gson gson = new Gson();
        HttpPost post = new HttpPost(url);
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

        HttpGet get = new HttpGet(url);
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
}
