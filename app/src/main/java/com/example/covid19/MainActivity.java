package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.covid19.model.HttpClient;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    EditText emailTextField;
    EditText passwordTextField;
    Switch singInAsGuestSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTextField=findViewById(R.id.emailTextField);
        passwordTextField=findViewById(R.id.passwordTextField);
        singInAsGuestSwitch=findViewById(R.id.singInAsGuestSwitch);
        singInAsGuestSwitch.setChecked(false);

        singInAsGuestSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    emailTextField.setActivated(false);
                    passwordTextField.setActivated(false);
                }else{
                    emailTextField.setActivated(true);
                    passwordTextField.setActivated(true);
                }
            }
        });

    }

    public void signUp(View view) {


    }

    public void signIn(View view) {

    }
}