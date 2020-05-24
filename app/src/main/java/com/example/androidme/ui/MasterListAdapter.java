package com.example.androidme.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

// Custom adapter for displaying images in grid view
public class MasterListAdapter extends BaseAdapter {

    // Keep track of context and imageids for display
    private Context mContext;
    private List<Integer> mImageIds;

    public MasterListAdapter(Context context, List<Integer> imageids)
    {
        context = mContext;
        imageids = mImageIds;
    }

    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
