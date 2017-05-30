package com.example.kai.qfarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private List<Fragment> mTabs = new ArrayList<Fragment>();
    private String[] mTitles = new String[]{"1", "2", "3"};
    private FragmentPagerAdapter mAdapter;

    private List<ChangeColorWithText> mTabIndicators = new ArrayList<ChangeColorWithText>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
        initDatas();
        mViewPager.setAdapter(mAdapter);
        initEvent();

    }

    private void initEvent() {
        mViewPager.setOnPageChangeListener(this);
    }

    private void initView() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        ChangeColorWithText one = (ChangeColorWithText)findViewById(R.id.tab_1);
        mTabIndicators.add(one);
        ChangeColorWithText two = (ChangeColorWithText)findViewById(R.id.tab_2);
        mTabIndicators.add(two);
        ChangeColorWithText three = (ChangeColorWithText)findViewById(R.id.tab_3);
        mTabIndicators.add(three);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);

        one.setIconAlpha(1.0f);
    }

    private void initDatas() {
        for (String title : mTitles) {
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString(TabFragment.TITLE, title);
            tabFragment.setArguments(bundle);
            mTabs.add(tabFragment);
        }
        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mTabs.get(position);
            }

            @Override
            public int getCount() {
                return mTabs.size();
            }
        };
    }

    @Override
    public void onClick(View v) {
        resetOtherTabs();

        switch (v.getId()){
            case R.id.tab_1:
                mTabIndicators.get(0).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(0,false);
                break;
            case R.id.tab_2:
                mTabIndicators.get(1).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(1,false);
                break;
            case R.id.tab_3:
                mTabIndicators.get(2).setIconAlpha(1.0f);
                mViewPager.setCurrentItem(2,false);
                break;
        }

    }

    private void resetOtherTabs() {
        for (int i = 0;i<mTabIndicators.size();i++){
            mTabIndicators.get(i).setIconAlpha(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (positionOffset>0){
            ChangeColorWithText left = mTabIndicators.get(position);
            ChangeColorWithText right = mTabIndicators.get(position+1);
            left.setIconAlpha(1-positionOffset);
            right.setIconAlpha(position);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}