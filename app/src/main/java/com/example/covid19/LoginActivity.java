package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.covid19.controller.SignInController;
import com.example.covid19.model.HttpClient;

import okhttp3.OkHttpClient;

public class LoginActivity extends AppCompatActivity {

    EditText emailTextField;
    EditText passwordTextField;
    Switch singInAsGuestSwitch;
    Button signInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailTextField=findViewById(R.id.emailTextField);
        passwordTextField=findViewById(R.id.passwordTextField);
        singInAsGuestSwitch=findViewById(R.id.singInAsGuestSwitch);
        signInButton=findViewById(R.id.signInButton);

        singInAsGuestSwitch.setChecked(false);

        signInButton.setClickable(false);
        signInButton.setEnabled(false);
        signInButton.setFocusable(false);
        signInButton.setAlpha(0.3F);


        singInAsGuestSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    emailTextField.setEnabled(false);
                   emailTextField.setCursorVisible(false);
                    emailTextField.setTextColor(Color.GRAY);
                    passwordTextField.setEnabled(false);
                    passwordTextField.setCursorVisible(false);
                    passwordTextField.setTextColor(Color.GRAY);
                    signInButton.setClickable(true);
                    signInButton.setEnabled(true);
                    signInButton.setAlpha(1F);
                } else {
                    emailTextField.setEnabled(true);
                    emailTextField.setCursorVisible(true);
                    emailTextField.setClickable(true);
                    emailTextField.setTextColor(Color.BLACK);
                    passwordTextField.setEnabled(true);
                    passwordTextField.setCursorVisible(true);
                    passwordTextField.setClickable(true);
                    passwordTextField.setTextColor(Color.BLACK);
                    if(emailTextField.getText().toString().isEmpty()){
                        signInButton.setClickable(false);
                        signInButton.setEnabled(false);
                        signInButton.setAlpha(0.3F);

                    }
                }
            }
        });

        emailTextField.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    signInButton.setEnabled(false);
                    signInButton.setClickable(false);
                    signInButton.setAlpha(0.3F);
                } else {
                    signInButton.setEnabled(true);
                    signInButton.setClickable(true);
                    signInButton.setAlpha(1F);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }
        });


        passwordTextField.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(emailTextField.getText().toString().isEmpty()){
                    emailTextField.setError("Email  or username not is empty!");
                }else {
                    emailTextField.setError(null);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });

        SignInController.setContext(this);

    }

    public void signUp(View view) {


    }

    public void signIn(View view) {
        if(signInButton.isEnabled()){
            if(singInAsGuestSwitch.isChecked()){
               SignInController.signIn(emailTextField.getText().toString(),passwordTextField.getText().toString(),true);

            }else {
                if(!SignInController.signIn(emailTextField.getText().toString(),passwordTextField.getText().toString(),false)){
                    passwordTextField.getText().clear();
                    emailTextField.getText().clear();
                }
            }
        }
    }
}