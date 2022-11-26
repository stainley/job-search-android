package ca.appolizer.AppolizerJobSearch.view.jobs;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.salapp.myapplication.R;
import com.salapp.myapplication.databinding.ActivityJobListBinding;
import com.salapp.myapplication.databinding.ActivityJobPostedBinding;

import java.util.ArrayList;

import ca.appolizer.AppolizerJobSearch.adapter.JobsAdapter;
import ca.appolizer.AppolizerJobSearch.model.Job;

public class JobListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView jobSearchView;

    private RecyclerView recyclerViewJobList;

    private JobsAdapter jobsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);


        recyclerViewJobList = findViewById(R.id.recyclerViewJob);
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Java Developer", "7 year job"));
        jobs.add(new Job("Python", "1 year job"));
        jobsAdapter = new JobsAdapter(jobs, getApplicationContext());

        jobSearchView = findViewById(R.id.jobSearch);
        jobSearchView.setOnQueryTextListener(this);

        recyclerViewJobList.setHasFixedSize(true);
        recyclerViewJobList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewJobList.setAdapter(jobsAdapter);

        // TODO: create a card list jobs. When clicked invoke the job description
        Intent jobDescriptionIntent = new Intent(this, JobDescriptionActivity.class);

        //startActivity(jobDescriptionIntent, bundle);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String search = newText;
        jobsAdapter.filter(newText);
        return false;
    }
}