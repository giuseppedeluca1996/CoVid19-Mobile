package com.example.covid19.model;


import java.util.Objects;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpClient {

    private final OkHttpClient client = new OkHttpClient();
    private  HttpUrl httpUrl;


    private  String serverUrl;
    private  String initEndPoint;

    public String requestGet(String endPoint){

        httpUrl = Objects.requireNonNull(HttpUrl.parse(serverUrl+initEndPoint+endPoint)).newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .build();

        try {
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()){
                return response.body().string();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    public String requestPost(String endPoint, String body){

        httpUrl = Objects.requireNonNull(HttpUrl.parse(serverUrl+initEndPoint+endPoint)).newBuilder()
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .post(RequestBody.create(body,MediaType.parse("application/json; charset=utf-8")))
                .build();
        try {
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()){
                return response.body().string();
            }
        }catch (Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getInitEndPoint() {
        return initEndPoint;
    }

    public void setInitEndPoint(String initEndPoint) {
        this.initEndPoint = initEndPoint;
    }
}
