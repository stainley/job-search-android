package ca.appolizer.AppolizerJobSearch.view.jobs;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.salapp.myapplication.R;
import com.salapp.myapplication.databinding.ActivityJobDescriptionBinding;

public class JobDescriptionActivity extends AppCompatActivity {

    private ActivityJobDescriptionBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*requestWindowFeature(Window.FEATURE_ACTION_BAR);*/

        binding = ActivityJobDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        TextView textViewTitle = findViewById(R.id.titleDescription);
        textViewTitle.setText(title);
        toolBarLayout.setTitle(title);
        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(view -> Snackbar.make(view, "Apply to job", Snackbar.LENGTH_LONG)
                .setAction("Confirm", clickListener -> {
                    sendMessage();
                }).show());
    }

    private void sendMessage() {
        Toast.makeText(this, "Send info", Toast.LENGTH_SHORT).show();
    }
}