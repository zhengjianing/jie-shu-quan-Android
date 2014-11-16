package com.tw.jieshuquan.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tw.jieshuquan.R;
import com.tw.jieshuquan.ui.fragment.DummyFragment;
import com.tw.jieshuquan.ui.fragment.LoginRequiredFragment;
import com.tw.jieshuquan.ui.view.TabBar;


public class MainActivity extends ActionBarActivity {
    public static final int NUM_ITEMS = 4;

    SectionsPagerAdapter mSectionsPagerAdapter;

    ViewPager mViewPager;
    TabBar mTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mTabBar = (TabBar) findViewById(R.id.tab_bar);
        mTabBar.setOnTabClickListener(new TabBar.OnTabClickListener() {
            @Override
            public void onTabClick(View tabView, int position) {
                mViewPager.setCurrentItem(position, false);
            }
        });
        mTabBar.setCurrentItem(0);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTabBar.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        private static final int PAGE_SEARCH = 0;
        private static final int PAGE_BOOKS = 1;
        private static final int PAGE_PEOPLE = 2;
        private static final int PAGE_MORE = 3;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case PAGE_SEARCH:
                    return DummyFragment.newInstance();
                case PAGE_BOOKS:
                    return LoginRequiredFragment.newInstance();
                case PAGE_PEOPLE:
                    return LoginRequiredFragment.newInstance();
                case PAGE_MORE:
                    return DummyFragment.newInstance();
                default:
                    return DummyFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }
    }
}
