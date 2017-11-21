package com.edinbridge.autojobs.autojobshere.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edinbridge.autojobs.autojobshere.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Ayothi selvam on 18-11-2017.
 */

public class AdapterInterview extends RecyclerView.Adapter<AdapterInterview.ViewHolder> {

    List<Interview> interviewList;
    Context context;

    public AdapterInterview(List<Interview> interviewList, Context context) {
        this.interviewList = interviewList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_interviewschedule,parent,false);

        return new AdapterInterview.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Interview interview= interviewList.get(position);

        holder.textView_job.setText(interview.getJobName());
        holder.textView_company.setText(interview.getCompanyName());
        holder.textView_ivDate.setText(interview.getIvDate());
        holder.textView_ivTime.setText(interview.getIvTime());
        holder.textView_location.setText(interview.getLocation());
        holder.textView_city.setText(interview.getCityName());
        holder.textView_jobCode.setText("AUTO"+interview.getJobCode());
        Picasso.with(context)
                .load("http://autojobshere.com/admin/"+interview.getLogo()).into(holder.imageView_logo);

    }

    @Override
    public int getItemCount() {
        return interviewList.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView_job,textView_company,textView_ivDate,textView_ivTime,textView_jobCode,textView_location,textView_city;
        ImageView imageView_logo;

        public ViewHolder(View itemView) {
            super(itemView);

            textView_job=(TextView) itemView.findViewById(R.id.is_txtJobName);
            textView_company=(TextView) itemView.findViewById(R.id.is_txtCompanyName);
            textView_ivDate=(TextView) itemView.findViewById(R.id.is_txtIntDate);
            textView_ivTime=(TextView) itemView.findViewById(R.id.is_txtTime);
            textView_location=(TextView) itemView.findViewById(R.id.is_txtLocation);
            textView_city=(TextView) itemView.findViewById(R.id.is_txtCity);
            textView_jobCode=(TextView) itemView.findViewById(R.id.is_txtJobCode);

            imageView_logo=(ImageView) itemView.findViewById(R.id.is_imgLogo);
        }
    }
}
