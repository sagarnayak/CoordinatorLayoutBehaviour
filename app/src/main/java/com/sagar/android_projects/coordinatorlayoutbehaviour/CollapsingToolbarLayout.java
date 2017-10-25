package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

public class CollapsingToolbarLayout extends AppCompatActivity {

    RecyclerView recyclerView;
    AppBarLayout appBarLayout;
    CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_collapsing_toolbar);

        recyclerView.setLayoutManager(new LinearLayoutManager(CollapsingToolbarLayout.this));
        recyclerView.setAdapter(new Adapter());

        appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);

        appBarLayout.post(new Runnable() {
            @Override
            public void run() {
                setAppBarOffset(200);
            }
        });
    }

    private void setAppBarOffset(int offsetPx) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.onNestedPreScroll(coordinatorLayout, appBarLayout, null, 0, offsetPx, new int[]{0, 0});
    }

}
