package com.vbrazhnikdev.customcoloredtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {

    private int page;
    private String text;
    private int color;

    public static PageFragment newInstance(int page, String text, int color) {

        PageFragment fragment = new PageFragment();
        fragment.setPage(page);
        fragment.setText(text);
        fragment.setColor(color);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.page_fragment, container, false);
        TextView tv = (TextView) view.findViewById(R.id.tab_text);

        tv.setText(text);
        tv.setTextColor(color);

        return view;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}