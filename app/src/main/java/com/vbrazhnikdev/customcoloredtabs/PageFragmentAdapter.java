package com.vbrazhnikdev.customcoloredtabs;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class PageFragmentAdapter extends FragmentPagerAdapter {

    private Context context;

    public PageFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return PageFragment.newInstance(position, "FUTURE", ContextCompat.getColor(context, R.color.tab_future));
            case 1:
                return PageFragment.newInstance(position, "PAST", ContextCompat.getColor(context, R.color.tab_past));
            case 2:
                return PageFragment.newInstance(position, "CALENDAR", ContextCompat.getColor(context, R.color.tab_calendar));
            case 3:
                return PageFragment.newInstance(position, "SETTINGS", ContextCompat.getColor(context, R.color.tab_settings));
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    public View getTabView(int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.page_fragment_adapter, null);

        TextView title = (TextView) view.findViewById(R.id.tab_title);

        switch (position) {
            case 0:
                title.setText("FUTURE");
                title.setTextColor(ContextCompat.getColor(context, R.color.tab_future));
                break;
            case 1:
                title.setText("PAST");
                title.setTextColor(ContextCompat.getColor(context, R.color.tab_past));
                break;
            case 2:
                title.setText("CALENDAR");
                title.setTextColor(ContextCompat.getColor(context, R.color.tab_calendar));
                break;
            case 3:
                title.setText("SETTINGS");
                title.setTextColor(ContextCompat.getColor(context, R.color.tab_settings));
                break;
        }

        return view;
    }

}