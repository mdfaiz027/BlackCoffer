package com.example.myapplication.group;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FilterActivity;
import com.example.myapplication.R;
import com.example.myapplication.adapter.GroupRecyclerViewAdapter;
import com.example.myapplication.model.MyModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GroupFragment extends Fragment {

    private RecyclerView recyclerView;
    private GroupRecyclerViewAdapter adapter;
    private ImageView filter;
    private FloatingActionButton fab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_group, container, false);

        fab = view.findViewById(R.id.fab);
        filter = view.findViewById(R.id.filter);

        filter.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), FilterActivity.class);
            intent.putExtra("fragment_index", 0);
            startActivity(intent);
        });

        // Initialize the RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Create a list of model objects
        List<MyModel> myList = new ArrayList<>();
        myList.add(new MyModel("John Doe", "123 Main St", "5 miles", 60, "Friends", "A community of runners who meet up to train for marathons and other long-distance races.", R.drawable.user));
        myList.add(new MyModel("Jane Smith", "456 Oak St", "10 miles", 30, "Family", "A group of entrepreneurs and business owners who exchange ideas and support each other's ventures.", R.drawable.user_2));
        myList.add(new MyModel("Bob Johnson", "789 Elm St", "3 miles", 80, "Work", "A network of artists who collaborate on projects and share their work with each other.",R.drawable.user_1));
        myList.add(new MyModel("Sara Lee", "10 Cherry St", "15 miles", 20, "Friends", "A group of hikers who explore local trails and organize camping trips.", R.drawable.user));
        myList.add(new MyModel("Mike Scott", "55 Maple Ave", "8 miles", 50, "Family", "A book club that meets monthly to discuss and analyze contemporary literature.",R.drawable.user_1));
        myList.add(new MyModel("Amy Adams", "100 Pine St", "2 miles", 90, "Work", "A forum for pet owners to share advice, anecdotes, and pictures of their furry friends.",R.drawable.user_2));
        myList.add(new MyModel("Tom Jones", "777 Broadway", "4 miles", 70, "Friends", "A collective of musicians who collaborate on original songs and perform at local venues.", R.drawable.user));
        myList.add(new MyModel("Karen Smith", "456 Oak St", "10 miles", 40, "Family", "A social club for young professionals who enjoy networking and socializing after work.", R.drawable.user_2));
        myList.add(new MyModel("Jim Brown", "123 Main St", "1 mile", 100, "Work", "A group of travelers who plan and embark on adventure trips to exotic destinations.",R.drawable.user_1));
        myList.add(new MyModel("Lisa Green", "99 5th Ave", "6 miles", 50, "Friends", "A forum for pet owners to share advice, anecdotes, and pictures of their furry friends.", R.drawable.user_2));

        // Set the adapter for the RecyclerView
        adapter = new GroupRecyclerViewAdapter(myList);
        recyclerView.setAdapter(adapter);

        // Hide floating action button while scrolling the recyclerview
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && fab.getVisibility() == View.VISIBLE) {
                    fab.hide();
                } else if (dy < 0 && fab.getVisibility() != View.VISIBLE) {
                    fab.show();
                }
            }
        });

        // return view
        return view;
    }
}