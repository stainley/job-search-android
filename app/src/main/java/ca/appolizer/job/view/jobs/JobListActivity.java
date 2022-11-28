package ca.appolizer.AppolizerJobSearch.view.jobs;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.salapp.myapplication.R;

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
        jobs.add(new Job("Senior Back-End Developers, Java/Spring Boot", "7 year job", "Procom", "Toronto, Ontario, Canada (On-site)"));
        jobs.add(new Job("Senior Java Developer - Payments", "1 year job", "Bally's Interactive", "Toronto, Ontario, Canada"));
        jobs.add(new Job("Android Developer", "", "Allegis Group", "Markham, ON"));
        jobs.add(new Job("Senior iOS Engineer", "", "Motion Recruitment", "Toronto, ON (Hybrid)"));
        jobsAdapter = new JobsAdapter(jobs, getApplicationContext());

        jobSearchView = findViewById(R.id.jobSearch);
        jobSearchView.setOnQueryTextListener(this);

        recyclerViewJobList.setHasFixedSize(true);
        recyclerViewJobList.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewJobList.setAdapter(jobsAdapter);

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