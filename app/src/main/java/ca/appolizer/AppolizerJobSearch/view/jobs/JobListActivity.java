package ca.appolizer.AppolizerJobSearch.view.jobs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.salapp.myapplication.R;

import java.util.ArrayList;

import ca.appolizer.AppolizerJobSearch.adapter.JobsAdapter;
import ca.appolizer.AppolizerJobSearch.model.Job;

public class JobListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        RecyclerView recyclerViewJobList = findViewById(R.id.recyclerViewJob);
        ArrayList<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Java Developer", "7 year job"));
        jobs.add(new Job("Junior JavaScript", "1 year job"));
        JobsAdapter jobsAdapter = new JobsAdapter(jobs, getApplicationContext());

        recyclerViewJobList.setHasFixedSize(true);
        recyclerViewJobList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewJobList.setAdapter(jobsAdapter);

        // TODO: create a card list jobs. When clicked invoke the job description
        Intent jobDescriptionIntent = new Intent(this, JobDescriptionActivity.class);

        //startActivity(jobDescriptionIntent, bundle);
    }
}