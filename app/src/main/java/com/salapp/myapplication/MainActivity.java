package com.salapp.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String LOCATION_TAG = "Message From: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOCATION_TAG, "onCreate");

        EditText usernameTxt = findViewById(R.id.editTextText);
        EditText passwordTxt = findViewById(R.id.editTextTextPassword);
        String username = "user1";
        String password = "pass1";

        Button loginButton = findViewById(R.id.btnLogin);

        loginButton.setOnClickListener(view -> {

            if (usernameTxt.getText().toString().equals(username) && passwordTxt.getText().toString().equals(password)) {
                Toast.makeText(getApplicationContext(), "Successfully", Toast.LENGTH_LONG).show();
            } else if (usernameTxt.getText().toString().equals(username) && !passwordTxt.getText().toString().equals(password)) {
                Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_LONG).show();
            } else if(!usernameTxt.getText().toString().equals(username) && passwordTxt.getText().toString().equals(password)) {
                Toast.makeText(getApplicationContext(), "Invalid User", Toast.LENGTH_LONG).show();
            } else if (!usernameTxt.getText().toString().equals(username) && !passwordTxt.getText().toString().equals(password)) {
                Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOCATION_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOCATION_TAG, "onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOCATION_TAG, "onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOCATION_TAG, "onDestroy");
    }
}