package com.example.covid19.security.impl;


import com.example.covid19.model.AuthRequest;
import com.example.covid19.model.UnauthorizedException;
import com.example.covid19.security.AuthManager;
import com.google.gson.Gson;

import java.io.IOException;


public class JwtAuthManager implements AuthManager {


  //  private static final HttpRequest httpRequest= new HttpRequest();

    private static JwtAuthManager instance;

    private static String jwtToken=null;

    private final  static Gson gsonConverter=new Gson();

    private JwtAuthManager(){ }

    public static JwtAuthManager getInstance(){
        if(instance == null) {
            synchronized (JwtAuthManager.class) {
                instance = new JwtAuthManager();
            }
        }
        return instance;
    }


    @Override
    public boolean loginWithUsername(String username, String password)   throws UnauthorizedException {
/*
        String json = gsonConverter.toJson(new AuthRequest( username,null ,password));
        try{
            HttpResponse<String> httpResponse = httpRequest.requestPost(json, "/signin/public/authenticate", false, null);
            if(httpResponse.statusCode() == 200 && !httpResponse.body().isEmpty()){
                jwtToken=httpResponse.body();
                HttpResponse<String> httpResponseIsAdmin=httpRequest.requestGet("/user/isAdmin?token="+jwtToken,true,jwtToken);
                if(httpResponseIsAdmin.statusCode() == 200 && httpResponseIsAdmin.body().equals("true")){
                    return true;
                }else {
                    throw  new UnauthorizedException();
                }
            }else {
                return false;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }

    @Override
    public boolean loginWithEmail(String email, String password) throws UnauthorizedException {
/*
        String json = gsonConverter.toJson(new AuthRequest( null,email ,password));
        try{
            HttpResponse<String> httpResponse = httpRequest.requestPost(json, "/signin/public/authenticate", false, null);
            if(httpResponse.statusCode() == 200 && !httpResponse.body().isEmpty()){
                jwtToken=httpResponse.body();
                HttpResponse<String> httpResponseIsAdmin=httpRequest.requestGet("/user/isAdmin?token="+jwtToken,true,jwtToken);
                if(httpResponseIsAdmin.statusCode() == 200 && httpResponseIsAdmin.body().equals("true")){
                    return true;
                }else {
                    throw  new UnauthorizedException();
                }
            }else {
                return false;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return false;
        }*/
        return true;
    }

    @Override
    public  String getAuthenticationString() {
        return jwtToken;
    }

    @Override
    public void logOut() {
        jwtToken=null;
    }
}
