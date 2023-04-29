package com.example.myapplication.group;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.group.GroupFilterFragment;

public class GroupFilterActivity extends AppCompatActivity {

    private GroupFilterFragment groupFilterFragment;
    private ImageView cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        groupFilterFragment = new GroupFilterFragment(); // replace MyFragment with the name of your fragment class
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, groupFilterFragment);
        transaction.commit();

        cancel_btn = findViewById(R.id.cancel_button);

        cancel_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}