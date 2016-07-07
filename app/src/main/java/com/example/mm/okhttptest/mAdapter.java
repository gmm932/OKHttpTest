package com.example.mm.okhttptest;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by ÌìÃ÷mm on 2016/7/7.
 */
public abstract class mAdapter<T> extends BaseAdapter {

    private Context context;
    private List<T> datalist;
    private LayoutInflater mInflater;

    public List<T> getDatalist() {
        return datalist;
    }

    public void setDatalist(List<T> datalist) {
        this.datalist = datalist;
    }

    public mAdapter(Context context, List<T> datalist) {
        this.context = context;
        this.datalist = datalist;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int i) {
        return datalist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return getConvertView(i,view,viewGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract View getConvertView(int position, View convertView, ViewGroup parent) throws Exception;
}
