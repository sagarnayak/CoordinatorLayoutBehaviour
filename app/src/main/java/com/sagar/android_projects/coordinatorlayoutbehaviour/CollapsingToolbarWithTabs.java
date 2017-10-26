package com.sagar.android_projects.coordinatorlayoutbehaviour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

/**
 * created by SAGAR KUMAR NAYAK on 26 OCT 2017.
 * this is an activity to show the use of tab layout in coordinator layout.
 * this also uses the exit until collapsed scroll flag for the toolbar. the toolbar and tab layout,
 * both views are shown when the appbar is fully collapsed.
 */
public class CollapsingToolbarWithTabs extends AppCompatActivity {

    //views
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsing_toolbar_with_tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        tabLayout = (TabLayout) findViewById(R.id.tablayout_collapsing_toolbar_with_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager_collapsing_toolbar_with_tabs);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set up hte view pager and tab layout
         */
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * method to setup the view pager and tab layout.
     * @param viewPager view pager id
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragForViewPager(), "ONE");
        adapter.addFragment(new FragForViewPager(), "TWO");
        adapter.addFragment(new FragForViewPager(), "THREE");
        viewPager.setAdapter(adapter);
    }

    /**
     * view pager adapter.
     */
    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
