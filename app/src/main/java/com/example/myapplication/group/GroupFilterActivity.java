package com.example.myapplication.group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.briefcase.BriefcaseFilterFragment;
import com.example.myapplication.briefcase.BriefcaseFragment;
import com.example.myapplication.group.GroupFilterFragment;
import com.example.myapplication.market.MarketFilterFragment;
import com.example.myapplication.market.MarketFragment;

public class GroupFilterActivity extends AppCompatActivity {
    private static final String TAG = GroupFilterActivity.class.getSimpleName();
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
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}