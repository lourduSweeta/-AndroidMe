package com.example.androidme.ui;

import android.util.Log;
import android.widget.Toast;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.example.androidme.R;

public class MainActivity extends FragmentActivity implements MasterListFragment.OnImageClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // define the behavior for onImageSelected ; create a toast that displays the position clicked
    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this,"position clicked= "+position,Toast.LENGTH_SHORT).show();
    }
}
