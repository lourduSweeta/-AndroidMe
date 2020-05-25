package com.example.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {

    public static final  String IMAGE_ID_LIST = "image_ids";
    public static final String LIST_INDEX="list_index";

    //TAG for Logging
    private static final String TAG = "BodyPartFragment";

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setImageIndex(int mImageIndex) {
        this.mImageIndex = mImageIndex;
    }

    // create variables to store imageIds and image index
    private List<Integer> mImageIds;
    private int mImageIndex;

    //Mandatory constructor for instantiating the fragment
    public BodyPartFragment(){

    }

    /**
     * Inflates the fragment layout and sets any image resources
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // inflate the fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container,false);
        // get the reference to imageView in the fragment layout
        final ImageView imageView=rootView.findViewById(R.id.body_part_image_view);

        if(savedInstanceState!=null)
        {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mImageIndex = savedInstanceState.getInt(LIST_INDEX);
        }

        // Set the image resource to display
        if(mImageIds!=null)
        {
            imageView.setImageResource(mImageIds.get(mImageIndex));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mImageIndex < mImageIds.size()-1)
                    {
                        mImageIndex++;
                    }
                    else
                    {
                        mImageIndex=0;
                    }
                    imageView.setImageResource(mImageIds.get(mImageIndex));
                }
            });

        }
        else {
            Log.v(TAG,"This fragment has null list of image ids");
        }
        //return the root view
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle currentState)
    {
        currentState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList <Integer>) mImageIds);
        currentState.putInt(LIST_INDEX,mImageIndex);
    }
}
