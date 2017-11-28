package com.edinbridge.autojobs.autojobshere.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Ayothi selvam on 11/28/2017.
 */

public class AdapterHotJob extends BaseAdapter {

    private List<HotJob> hotJobs;
    private Context context;
    private static LayoutInflater inflater=null;

    public AdapterHotJob(List<HotJob> hotJobs, Context context) {
        this.hotJobs = hotJobs;
        this.context = context;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return hotJobs.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class Holder
    {
        TextView cmyName,city;
        ImageView logo;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder=new Holder();
        View rowView;
        return null;
    }
}
