package ca.appolizer.AppolizerJobSearch;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ca.appolizer.AppolizerJobSearch.view.jobs.JobDescriptionActivity;
import ca.appolizer.AppolizerJobSearch.view.jobs.JobListActivity;
import ca.appolizer.AppolizerJobSearch.view.register.RegisterActivity;
import com.salapp.myapplication.R;


public class LoginActivity extends AppCompatActivity {

    public static final String LOCATION_TAG = "Message From: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.btnSignin);
        loginButton.setOnClickListener(view -> {
            Intent jobPosting = new Intent(this, JobListActivity.class);
            startActivity(jobPosting);
        });

        Button btnCreateAccount = findViewById(R.id.btnCreateAccount);
        btnCreateAccount.setOnClickListener(view -> {
            Intent registerActivity = new Intent(getApplicationContext(), RegisterActivity.class);

            startActivity(registerActivity);
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