package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sagar.android_projects.coordinatorlayoutbehaviour.adapter.Adapter;

/**
 * created by SAGAR KUMAR NAYAK on 26 OCT 2017.
 * this is an activity to demonstrate the use of scroll flag in appbar layout.
 * this will use a enter always scroll flag. due to which the toolbar will auto hide on the down scroll
 * and show up in every up scroll.
 */
public class NormalAppbarLayout extends AppCompatActivity {

    //views
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_appbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_normal_appbar_layout);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set up layout manager and adapter for recyclerview.
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(NormalAppbarLayout.this));
        recyclerView.setAdapter(new Adapter());
    }

}
