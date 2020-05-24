package com.example.androidme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;

public class BodyPartFragment extends Fragment {
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
        ImageView imageView=rootView.findViewById(R.id.body_part_image_view);
        // Set the image resource to display
        imageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        //return the root view
        return rootView;
    }
}
