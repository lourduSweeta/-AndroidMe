package com.example.androidme.ui;

import android.util.Log;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.example.androidme.R;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("MainActivity", "activity_main");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
