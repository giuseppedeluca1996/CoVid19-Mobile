package com.example.covid19.security;

import android.content.Context;

import com.example.covid19.util.Util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

 public abstract class AuthManagerFactory {

    private String authManagerType;

    public abstract AuthManager  getAuthManager();

    public AuthManagerFactory getAuthManagerFactory(Context context){

        try {
            authManagerType=Util.getProperty("authManager.type", context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        switch (authManagerType) {
            case "jwt" : {
                return new JwtAuthManagerFactory();
            }
            default : {
                return null;
            }
        }

    }

    public  String getAuthManagerType() {
        return authManagerType;
    }

    public  void setAuthManagerType(String authManagerType) {
        this.authManagerType = authManagerType;
    }

}
