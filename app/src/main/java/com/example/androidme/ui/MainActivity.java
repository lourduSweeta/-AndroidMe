package com.example.androidme.ui;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.androidme.AndroidMeActivity;
import com.example.androidme.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener{

    // variables to store head , body and leg index of selected images
    // default value will be index 0
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // define the behavior for onImageSelected ; create a toast that displays the position clicked
    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this,"position clicked= "+position,Toast.LENGTH_SHORT).show();
        //Based on where a user has clicked, store the selected list index for the head , body and leg
        int bodyPartNumber = position/12;
        Log.v("Info","onImageSelected"+position);

        int listIndex = position- 12*bodyPartNumber;
        Log.v("info","list index number "+bodyPartNumber);
        switch (bodyPartNumber)
        {
            case 0:
                headIndex = listIndex;
                break;
            case 1:
                bodyIndex = listIndex;
                break;
            case 2:
                legIndex = listIndex;
                break;
            default:
                break;
        }
        //Put this information in a Bundle and attach it to an Intent that will launch an AndroidMeActivity
        Bundle bundle = new Bundle();
        bundle.putInt("headIndex", headIndex);
        bundle.putInt("bodyIndex", bodyIndex);
        bundle.putInt("legIndex", legIndex);

        //Attach the bundle to an intent
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(bundle);

        //Get a reference to the Next button and launch the intent when this button is clicked
        Button button = (Button) findViewById(R.id.next_button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
