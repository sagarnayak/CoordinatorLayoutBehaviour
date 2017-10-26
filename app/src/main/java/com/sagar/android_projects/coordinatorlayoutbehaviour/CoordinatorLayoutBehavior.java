package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sagar.android_projects.coordinatorlayoutbehaviour.adapter.Adapter;

/**
 * created by SAGAR KUMAR NAYAK on 26 OCT 2017.
 * this is the activity to demonstrate the use of custom behavior in coordinator layout.
 * it will use a image view to transform according to the changes in the appbar. in expanded state
 * the picture will be shown in larger imageview. but as the appbar is collapsed the image will transformed
 * to smaller size to fit into the toolbar.
 * the same is used for some text. these text are in the collapsing toolbar and it will only show in the
 * expanded state.
 * the toolbar text is hidden in collapsed state and it wil be shown when the toolbar is fully collapsed.
 */
public class CoordinatorLayoutBehavior extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{

    //views
    FloatingActionButton fab;
    RecyclerView recyclerView;
    private LinearLayout mTitleContainer;
    private TextView mTitle;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;

    //constants for view transformation
    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION = 200;

    //boolean to keep track of changes during the appbar transformation.
    private boolean mIsTheTitleVisible = false;
    private boolean mIsTheTitleContainerVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout_behavior);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_coordinator_behavior);
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mTitle = (TextView) findViewById(R.id.main_textview_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout = (AppBarLayout) findViewById(R.id.main_appbar);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set up the layout manager and adapter for the recyclerview
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(CoordinatorLayoutBehavior.this));
        recyclerView.setAdapter(new Adapter());

        /*
        set up the offset change listener for the appbar. it will be used for the alpha change animation
        for the title in toolbar, when the appbar transformation is going on.
         */
        mAppBarLayout.addOnOffsetChangedListener(this);

        mToolbar.inflateMenu(R.menu.menu_main);
        /*
        start the initial alpha animation. it will hide the title completely.
         */
        startAlphaAnimation(mTitle, 0, View.INVISIBLE);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    /**
     * method to handle the alpha change animation for the toolbar title.
     * @param percentage percentage for the alpha of the title
     */
    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation(View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }

}
