package com.example.androidme.ui;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

// Custom adapter for displaying images in grid view
public class MasterListAdapter extends BaseAdapter {

    // Keep track of context and imageids for display
    private Context mContext;
    private List<Integer> mImageIds;

    public MasterListAdapter(Context context, List<Integer> imageIds)
    {
        this.mContext = context;
        this.mImageIds = imageIds;
        Log.v("MasterListAdapter"," constructor");
    }

    @Override
    public int getCount() {
        Log.v("MasterListAdapter"," getCount() invocation ");
        return this.mImageIds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
     * Creates new image view for each item referenced by the adapter
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("MasterListAdapter","getView() invocation ");
        ImageView imageView;
        if(convertView == null)
        {
            // If the view is not recycled, this creates new ImageView to hold an image
            imageView = new ImageView(mContext);
            //Define the layout parameters
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);

        }
        else
        {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(this.mImageIds.get(position));
        return imageView;
    }
}
