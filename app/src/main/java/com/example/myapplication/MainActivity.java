package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        // Begin a new FragmentTransaction
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        /*// Instantiate your Fragment
        RefineFragment myFragment = new RefineFragment();

        // Add the Fragment to the container view with an ID of "fragment_container"
        fragmentTransaction.add(R.id.fragment_container, myFragment);*/

        ExploreFragment exploreFragment = new ExploreFragment();

        fragmentTransaction.add(R.id.fragment_container, exploreFragment);

        // Commit the FragmentTransaction
        fragmentTransaction.commit();

    }
}