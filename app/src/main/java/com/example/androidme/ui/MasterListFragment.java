package com.example.androidme.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {
    // Define a new interface onImageClickListener that triggers callback in host activity
    // callback is a method named onImageSelected(int position) that contains information about
    // which position on the grid of images a user has clicked
    OnImageClickListener mCallBack;

    public interface  OnImageClickListener {
       public void onImageSelected(int position);
    }

    public MasterListFragment()
    {

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // This is to make sure that the host activity has implemented the call back interface
        // If not throws exception
        try
        {
            mCallBack = (OnImageClickListener)context;

        }catch(ClassCastException exception)
        {
            throw new ClassCastException(context.toString()+" must implement OnImageClickListener");
        }
    }


    // inflates the grid view of all AndroidMe images
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list,container,false);
        // Get a reference to the Grid view in the master_list_grid_view.xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.master_list_grid_view);
        // Create adapter
        //this adapter takes in the context and an arraylist of all the image resources to display
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        // set the adapter to grid view
        gridView.setAdapter(adapter);
        // set a click listener to grid view and trigger callback onImageSelected when an item is clicked
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // trigger the call back method and pass the item selected position
                mCallBack.onImageSelected(position);
            }
        });
        return rootView;
    }
}