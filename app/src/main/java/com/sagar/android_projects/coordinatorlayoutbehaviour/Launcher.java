package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Launcher extends AppCompatActivity {

    Button buttonNormalAppbarLayout;
    Button buttonAppbarLayoutwithTabs;
    Button buttonCollapsingToolbar;
    Button buttonCollapsingToolbarWitTabs;
    Button buttonCoordinatorBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonNormalAppbarLayout = (Button) findViewById(R.id.normal_appbarlayout);
        buttonAppbarLayoutwithTabs = (Button) findViewById(R.id.appbarlayout_with_tabs);
        buttonCollapsingToolbar = (Button) findViewById(R.id.collapsing_toolbar);
        buttonCollapsingToolbarWitTabs = (Button) findViewById(R.id.collapsing_toolbar_with_tabs);
        buttonCoordinatorBehavior = (Button) findViewById(R.id.coordinator_layout_behavior);

        buttonNormalAppbarLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, NormalAppbarLayout.class));
            }
        });

        buttonAppbarLayoutwithTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, AppbarLayoutWithTabs.class));
            }
        });

        buttonCollapsingToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CollapsingToolbarLayout.class));
            }
        });

        buttonCollapsingToolbarWitTabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CollapsingToolbarWithTabs.class));
            }
        });

        buttonCoordinatorBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Launcher.this, CoordinatorLayoutBehavior.class));
            }
        });
    }

}
