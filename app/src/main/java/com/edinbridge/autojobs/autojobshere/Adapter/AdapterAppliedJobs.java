package com.edinbridge.autojobs.autojobshere.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edinbridge.autojobs.autojobshere.R;

import java.util.List;

/**
 * Created by krish on 11/18/2017.
 */

public class AdapterAppliedJobs extends RecyclerView.Adapter<AdapterAppliedJobs.ViewHolder> {
    private List<JobDetails> jobDetailses;
    private Context context;

    public AdapterAppliedJobs(List<JobDetails> jobDetailses, Context context) {
        this.jobDetailses = jobDetailses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_appliedjob,parent,false);

        return new AdapterAppliedJobs.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        JobDetails jobDetails= jobDetailses.get(position);
        holder.aj_txtCompanyName.setText(jobDetails.getCompanyName());
        holder.aj_txtJobName.setText(jobDetails.getJobName());
        holder.aj_txtCityName.setText(jobDetails.getCityName());
        holder.aj_txtExperience.setText(jobDetails.getExperience());
        holder.aj_txtSalary.setText(jobDetails.getSalary());
        holder.aj_txtDate.setText(jobDetails.getDate());
    }

    @Override
    public int getItemCount() {
        return jobDetailses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView aj_txtJobName,aj_txtCompanyName,aj_txtCityName,aj_txtExperience,aj_txtSalary,aj_txtDate;
        ImageView aj_imgBrandLogo;


        public ViewHolder(View itemView) {
            super(itemView);
            aj_txtJobName =(TextView) itemView.findViewById(R.id.aj_txtJobName);
            aj_txtCompanyName =(TextView) itemView.findViewById(R.id.aj_txtCompanyName);
            aj_txtCityName =(TextView) itemView.findViewById(R.id.aj_txtCityName);
            aj_txtExperience =(TextView) itemView.findViewById(R.id.aj_txtExperience);
            aj_txtSalary =(TextView) itemView.findViewById(R.id.aj_txtSalary);
            aj_txtDate =(TextView) itemView.findViewById(R.id.aj_txtDate);
            aj_imgBrandLogo =(ImageView) itemView.findViewById(R.id.aj_imgBrandLogo);

        }
    }
}
