package com.edinbridge.autojobs.autojobshere.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.edinbridge.autojobs.autojobshere.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ayothi selvam on 20-11-2017.
 */

public class AdapterSavedJob extends RecyclerView.Adapter<AdapterSavedJob.ViewHolder> {

    private List<JobDetails> jobDetailses;
    private Context context;

    public AdapterSavedJob(List<JobDetails> jobDetailses, Context context) {
        this.jobDetailses = jobDetailses;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_savedjobs,parent,false);

        return new AdapterSavedJob.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        JobDetails jobDetails= jobDetailses.get(position);

        holder.textView_job.setText(jobDetails.getJobName());
        holder.textView_comName.setText(jobDetails.getCompanyName());
        holder.textView_city.setText(jobDetails.getCityName());
        holder.textView_exp.setText(jobDetails.getMinExp()+" - "+jobDetails.getMaxExp()+" Yrs");
        holder.textView_salary.setText(jobDetails.getMinSalary()+" - "+jobDetails.getMaxSalary()+" PM");
        Picasso.with(context)
                .load("http://autojobshere.com/admin/"+jobDetails.getLogo()).into(holder.imageView_logo);

    }

    @Override
    public int getItemCount() {
        return jobDetailses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_job,textView_comName,textView_city,textView_exp,textView_salary;
        ImageView imageView_logo;
        Button button_apply,button_remove;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_job=(TextView) itemView.findViewById(R.id.sj_textView_jobName);
            textView_comName=(TextView) itemView.findViewById(R.id.sj_textView_comName);
            textView_city=(TextView) itemView.findViewById(R.id.sj_textView_city);
            textView_exp=(TextView) itemView.findViewById(R.id.sj_textView_exp);
            textView_salary=(TextView) itemView.findViewById(R.id.sj_textView_salary);
            imageView_logo=(ImageView) itemView.findViewById(R.id.img_sj_logo);

            button_apply=(Button) itemView.findViewById(R.id.sj_button_apply);
            button_remove=(Button) itemView.findViewById(R.id.sj_button_remove);
        }
    }
}
