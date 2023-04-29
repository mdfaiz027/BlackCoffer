package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.briefcase.BriefcaseFilterFragment;
import com.example.myapplication.group.GroupFilterFragment;
import com.example.myapplication.group.GroupFragment;
import com.example.myapplication.market.MarketFilterFragment;

public class FilterActivity extends AppCompatActivity {
    private static final String TAG = FilterActivity.class.getSimpleName();
    private ImageView cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        // assuming a default value of 0
        int fragmentIndex = getIntent().getIntExtra("fragment_index", 0);
        Log.d(TAG, "onCreate: "+fragmentIndex);
        Fragment fragment = new GroupFragment();

        if (fragmentIndex == 0){
            fragment = new GroupFilterFragment();
        } else if (fragmentIndex == 1){
            fragment = new BriefcaseFilterFragment();
        } else if (fragmentIndex == 2){
            fragment = new MarketFilterFragment();
        }

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, fragment);
        transaction.commit();

        cancel_btn = findViewById(R.id.cancel_button);

        cancel_btn.setOnClickListener(view -> {
            finish();
        });

    }
}