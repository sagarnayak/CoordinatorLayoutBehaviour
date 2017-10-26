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
 * this activity demonstrate a toolbar with a tab layout. the toolbar is using a scroll flag
 * enter always. and the toolbar is not using any scroll flag. therefore the toolbar hides on every
 * down scroll but not the tab layout.
 */
public class AppbarLayoutWithTabs extends AppCompatActivity {

    //views
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_layout_with_tabs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //view binding
        tabLayout = (TabLayout) findViewById(R.id.tablayout_appbar_layout_with_tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager_appbar_layout_with_tabs);
        ////////////////////////////////////////////////////////////////////////////////////////////

        /*
        set up the view pager and tab layout.
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
