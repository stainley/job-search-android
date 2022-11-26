package ca.appolizer.AppolizerJobSearch.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.salapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ca.appolizer.AppolizerJobSearch.model.Job;
import ca.appolizer.AppolizerJobSearch.view.jobs.JobDescriptionActivity;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder> {

    private List<Job> jobs;

    private ArrayList<Job> arrayListJobs = new ArrayList<>();
    private final Context context;

    public JobsAdapter(ArrayList<Job> jobs, Context context) {
        this.jobs = jobs;
        this.context = context;
        this.arrayListJobs.addAll(jobs);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View jobView = inflater.inflate(R.layout.job_card_layout, parent, false);

        RecyclerView.ViewHolder viewHolder = new ViewHolder(jobView);

        return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.jobTitleTxt.setText(jobs.get(position).getTitle());
        holder.jobDescriptionTxt.setText(jobs.get(position).getDescription());

        holder.jobCardView.setOnClickListener(view -> {
            Toast.makeText(holder.itemView.getContext(), "Job: " + position + " " + jobs.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            Intent jobIntent = new Intent(context, JobDescriptionActivity.class);
            jobIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            Bundle bundle = new Bundle();
            bundle.putString("title", jobs.get(position).getTitle());
            bundle.putString("description", jobs.get(position).getDescription());
            jobIntent.putExtras(bundle);
            context.startActivity(jobIntent);
        });
    }

    public void filter(String text) {
        text = text.toLowerCase();
        jobs.clear();

        if (text.length() == 0) {
            jobs.addAll(arrayListJobs);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            jobs = arrayListJobs.stream().filter(job -> job.getTitle().toLowerCase().contains(sb))
                    .collect(Collectors.toList());
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.jobs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView jobTitleTxt;
        public TextView jobDescriptionTxt;

        private CardView jobCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            jobTitleTxt = itemView.findViewById(R.id.jobTitle);
            jobDescriptionTxt = itemView.findViewById(R.id.jobDescription);
            jobCardView = itemView.findViewById(R.id.jobPost);

        }
    }
}
