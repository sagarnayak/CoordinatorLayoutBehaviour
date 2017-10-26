package com.sagar.android_projects.coordinatorlayoutbehaviour.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagar.android_projects.coordinatorlayoutbehaviour.R;

/**
 * Created by sagar on 10/25/2017.
 * this is the adapter that is used to populate the recyclerview in each activity.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.singleview_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 50;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
