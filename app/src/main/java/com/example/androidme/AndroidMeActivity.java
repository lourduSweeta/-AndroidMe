package com.example.androidme;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.example.androidme.data.AndroidImageAssets;
import com.example.androidme.ui.BodyPartFragment;

import java.util.List;

// Display custom android imaged composed of three parts: head, body and legs
public class AndroidMeActivity extends AppCompatActivity {

        private List<Integer> mImageIds ;

    // (1) Create a layout file that displays one body part image named fragment_body_part.xml
    // This layout should contain a single ImageView
    // (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
    // In this class, you'll need to implement an empty constructor and the onCreateView method
    // (3) Show the first image in the list of head images

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        Bundle bundle = getIntent().getExtras();

        if(savedInstanceState ==null)
        {
            //(5) Create a new BodyPartFragment instance and display it using the FragmentManager
            BodyPartFragment headPartFragment = new BodyPartFragment();
            headPartFragment.setImageIds(AndroidImageAssets.getHeads());
            headPartFragment.setImageIndex(bundle.getInt("headIndex"));

            BodyPartFragment bodyPartFragment = new BodyPartFragment();
            bodyPartFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyPartFragment.setImageIndex(bundle.getInt("bodyIndex"));

            BodyPartFragment legPartFragment = new BodyPartFragment();
            legPartFragment.setImageIds(AndroidImageAssets.getLegs());
            legPartFragment.setImageIndex(bundle.getInt("legIndex"));

            // Use fragment manager and transaction to add fragment to the screen
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.head_container,headPartFragment)
                    .add(R.id.body_container,bodyPartFragment)
                    .add(R.id.leg_container,legPartFragment)
                    .commit();
        }
    }
}
