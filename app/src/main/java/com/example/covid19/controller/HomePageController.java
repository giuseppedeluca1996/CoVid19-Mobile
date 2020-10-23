package com.example.covid19.controller;

import android.content.Context;
import android.content.Intent;

import com.example.covid19.HomePageActivity;


public class HomePageController {

    public static void showHomePage(Context context) {
        context.startActivity(new Intent(context, HomePageActivity.class));
    }











}
