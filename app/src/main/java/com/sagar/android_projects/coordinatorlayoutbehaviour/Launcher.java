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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonNormalAppbarLayout = (Button) findViewById(R.id.normal_appbarlayout);
        buttonAppbarLayoutwithTabs = (Button) findViewById(R.id.appbarlayout_with_tabs);

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
    }

}
