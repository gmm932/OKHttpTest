package com.example.mm.okhttptest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ÌìÃ÷mm on 2016/7/7.
 */
public class TestAdapter extends mAdapter<Student> {
    public TestAdapter(Context context, List<Student> datalist) {
        super(context, datalist);
    }

    @Override
    public View getConvertView(int position, View convertView, ViewGroup parent) throws Exception {
        return null;
    }
}
