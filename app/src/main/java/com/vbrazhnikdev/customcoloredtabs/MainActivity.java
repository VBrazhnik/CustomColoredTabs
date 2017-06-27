package com.vbrazhnikdev.customcoloredtabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        configurePagerView();
    }

    private void configurePagerView() {

        PageFragmentAdapter adapter = new PageFragmentAdapter(getSupportFragmentManager(), MainActivity.this);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setSelectedTabIndicatorHeight(0);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setCustomView(adapter.getTabView(i));
        }

        tabLayout.addOnTabSelectedListener(this);
        changeTabLayout(true, tabLayout.getTabAt(0));

    }

    private void changeTabLayout(boolean select, TabLayout.Tab tab) {
        View view = tab.getCustomView();

        if (view != null) {
            ((TextView) view.findViewById(R.id.tab_title)).setTextSize(select ? 19 : 14);
        }
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

        changeTabLayout(true, tab);
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        changeTabLayout(false, tab);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
}