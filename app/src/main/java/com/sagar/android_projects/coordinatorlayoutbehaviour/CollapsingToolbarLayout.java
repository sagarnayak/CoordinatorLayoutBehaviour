package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.sagar.android_projects.coordinatorlayoutbehaviour.adapter.Adapter;

/**
 * created by SAGAR KUMAR NAYAK on 26 OCT 2017.
 * this is an activity to demonstrate the use of collapsingtoolbar inside the appbar layout.
 * it will have a larger appbar at the start. but on down scroll the appbar will shrink to a small
 * size to make more list items visible to user.
 * it uses a scroll flag exit until collapsed, which results in shrink of appbar to a min height for
 * a down scroll. and at the end of the up scroll it will come to its normal expanded state.
 * this class also allows you to show a required length of appbar with showing the full length of the
 * expanded appbar. this is achieved by the function setAppBarOffset().
 */
public class CollapsingToolbarLayout extends AppCompatActivity {

    //views
    RecyclerView recyclerView;
    AppBarLayout appBarLayout;
    CoordinatorLayout coordinatorLayout;
    android.support.design.widget.CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_collapsing_toolbar);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarlayout);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);
        collapsingToolbarLayout = (android.support.design.widget.CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set layout manager and adapter to recyclerview
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(CollapsingToolbarLayout.this));
        recyclerView.setAdapter(new Adapter());

        /*
        setting up for appbar for the custom length show to the user instead of full length expanded
        view.
         */
        appBarLayout.post(new Runnable() {
            @Override
            public void run() {
                setAppBarOffset(200);
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg);
        //using palette, change the color of collapsing toolbar layout
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int mutedColor = palette.getMutedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
                int mutedDarkColor = palette.getDarkMutedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark));
                int vibrantColor = palette.getVibrantColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                collapsingToolbarLayout.setContentScrimColor(mutedColor);
                collapsingToolbarLayout.setStatusBarScrimColor(mutedDarkColor);
                floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(vibrantColor));
            }
        });
    }

    /**
     * method to show the custom length of appbar instead of showing the full length appbar layout.
     *
     * @param offsetPx offset for length
     */
    private void setAppBarOffset(int offsetPx) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams();
        AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
        behavior.onNestedPreScroll(coordinatorLayout, appBarLayout, null, 0, offsetPx, new int[]{0, 0});
    }

}
