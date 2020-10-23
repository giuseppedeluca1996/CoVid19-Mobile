package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.covid19.controller.HomePageController;
import com.example.covid19.controller.ResearchController;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        HomePageController.setContext(this);
        ResearchController.setContext(this);
    }
    public static void showHomePageScreen(Context context) {
        context.startActivity(new Intent(context,HomePageActivity.class));
    }
}