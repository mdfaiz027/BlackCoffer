package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.MyModel;
import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.List;

public class GroupRecyclerViewAdapter extends RecyclerView.Adapter<GroupRecyclerViewAdapter.MyViewHolder> {

    private List<MyModel> myList; // List of model objects

    public GroupRecyclerViewAdapter(List<MyModel> myList) {
        this.myList = myList;
    }

    @NonNull
    @Override
    public GroupRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout for each item in the RecyclerView
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.group_custom_layout, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupRecyclerViewAdapter.MyViewHolder holder, int position) {
        // Set the data for each item in the RecyclerView
        MyModel model = myList.get(position);
        holder.name.setText(model.getName());
        holder.address.setText(model.getAddress());
        holder.group.setText(model.getGroup());
        holder.group_description.setText(model.getGroup_description());
        holder.progress.setProgress(model.getProgress());
        holder.profile_pic.setImageResource(model.getImage());
    }

    @Override
    public int getItemCount() {
        // Return the number of items in the RecyclerView
        return myList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name, address, group, group_description;
        LinearProgressIndicator progress;

        ImageView profile_pic;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            group = itemView.findViewById(R.id.group);
            group_description = itemView.findViewById(R.id.group_description);
            progress = itemView.findViewById(R.id.progress);
            profile_pic = itemView.findViewById(R.id.imageView);
        }
    }
}
