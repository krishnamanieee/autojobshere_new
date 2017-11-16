package com.edinbridge.autojobs.autojobshere.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.edinbridge.autojobs.autojobshere.R;

/**
 * Created by Ayothi selvam on 16-11-2017.
 */

public class AdapterHotJob extends BaseAdapter{

    Context context;
    private final String[] companyName;
    private final String[] city;
    private final String[] image;

    public AdapterHotJob(Context context,String[] companyName, String[] city, String[] image) {
        this.context=context;
        this.companyName = companyName;
        this.city = city;
        this.image = image;
    }

    @Override
    public int getCount() {
        return companyName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View grid;
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view ==null ){
            grid=new View(context);
            grid=layoutInflater.inflate(R.layout.item_grid_hotjob,null);

            TextView textView_compnayName=(TextView) grid.findViewById(R.id.textView_gridComName);
            TextView textView_city=(TextView) grid.findViewById(R.id.textView_gridCity);
            ImageView imageView_logo=(ImageView) grid.findViewById(R.id.img_gridHotJobs);




        }
        else {
            grid=new View(context);

        }
        return grid;
    }
}
