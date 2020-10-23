package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.covid19.controller.HomePageController;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        HomePageController.setContext(this);
    }
}