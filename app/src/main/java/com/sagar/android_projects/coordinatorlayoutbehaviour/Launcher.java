package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * created by SAGAR KUMAR NAYAK on 26 OCT 2017.
 * this is an activity that is used as a index for this app.
 * this app shows different ways in which we can use a coordinator layout to make awesome UI for
 * mobile applications.
 */
public class Launcher extends AppCompatActivity {

    //views
    Button buttonNormalAppbarLayout;
    Button buttonAppbarLayoutWithTabs;
    Button buttonCollapsingToolbar;
    Button buttonCollapsingToolbarWitTabs;
    Button buttonCoordinatorBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        buttonNormalAppbarLayout = (Button) findViewById(R.id.normal_appbarlayout);
        buttonAppbarLayoutWithTabs = (Button) findViewById(R.id.appbarlayout_with_tabs);
        buttonCollapsingToolbar = (Button) findViewById(R.id.collapsing_toolbar);
        buttonCollapsingToolbarWitTabs = (Button) findViewById(R.id.collapsing_toolbar_with_tabs);
        buttonCoordinatorBehavior = (Button) findViewById(R.id.coordinator_layout_behavior);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        on click for normal appbar layout animation. this shows the animation if auto hide toolbar in
        an scrollable activity.
         */
        buttonNormalAppbarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, NormalAppbarLayout.class));
            }
        });

        /*
        on click for appbar layout with tabs. this is an activity to show the animation of toolbar
        with a tab layout. on scroll the tab layout will be shown but the toolbar will hide.
         */
        buttonAppbarLayoutWithTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, AppbarLayoutWithTabs.class));
            }
        });

        /*
        on click for collapsing toolbar layout. this wil show animation of a normal collapsing toolbar.
        it will collapse at down scroll and expand at up scroll.
         */
        buttonCollapsingToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CollapsingToolbarLayout.class));
            }
        });

        /*
        on click for collapsing toolbar with tabs. this will have a tab layout along with a toolbar
        layout. it will collapse in a down scroll and also show at up scroll.
         */
        buttonCollapsingToolbarWitTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CollapsingToolbarWithTabs.class));
            }
        });

        /*
        on click for custom behavior in a coordinator layout. it will show the use of custom behaviour
        of in a coordinator layout to auto collapse and re position different views as the appbar is
        collapsed and expanded.
         */
        buttonCoordinatorBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CoordinatorLayoutBehavior.class));
            }
        });
    }

}
