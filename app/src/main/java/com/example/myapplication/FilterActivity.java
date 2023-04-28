package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.group_fragments.FilterFragment;

public class FilterActivity extends AppCompatActivity {

    private FilterFragment filterFragment;
    private ImageView cancel_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        filterFragment = new FilterFragment(); // replace MyFragment with the name of your fragment class
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, filterFragment);
        transaction.commit();

        cancel_btn = findViewById(R.id.cancel_button);

        cancel_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

    }
}