package ca.appolizer.AppolizerJobSearch.view.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.salapp.myapplication.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button completeRegister = findViewById(R.id.btnCompleteRegister);
        completeRegister.setOnClickListener(view -> {
            finish();
        });
    }
}