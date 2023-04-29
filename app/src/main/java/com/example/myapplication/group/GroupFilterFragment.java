package com.example.myapplication.group;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.slider.LabelFormatter;
import com.google.android.material.slider.RangeSlider;

import java.util.List;

public class GroupFilterFragment extends Fragment {

    private Chip coffee, business, hobbies, friendship, movies, dining, dating, matrimony;
    private ChipGroup gender;

    private TextView headline_score;
    private RangeSlider rangeSlider;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_filter, container, false);

        gender = view.findViewById(R.id.gender_chip_group);

        headline_score = view.findViewById(R.id.headline_score);
        rangeSlider = view.findViewById(R.id.range_slider);

        coffee = view.findViewById(R.id.chip_coffee);
        business = view.findViewById(R.id.chip_business);
        hobbies = view.findViewById(R.id.chip_hobbies);
        friendship = view.findViewById(R.id.chip_friendship);
        movies = view.findViewById(R.id.chip_movies);
        dining = view.findViewById(R.id.chip_dining);
        dating = view.findViewById(R.id.chip_dating);
        matrimony = view.findViewById(R.id.chip_matrimony);

        gender.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.male){
                Toast.makeText(getContext(), "male is clicked", Toast.LENGTH_SHORT).show();
            }else if(checkedId == R.id.female){

            }else{

            }
        });

        rangeSlider.setLabelFormatter(value -> {
            return String.valueOf((int) value); // format the label as an integer value
        });

        rangeSlider.addOnChangeListener((slider, value, fromUser) -> headline_score.setText(slider.getValues().get(0).intValue() + "-" + slider.getValues().get(1).intValue()));

        Chip[] chips = {coffee, business, hobbies, friendship, movies, dining, dating, matrimony};

        for (Chip myChip : chips) {
            myChip.setOnClickListener(v -> {
                myChip.setSelected(!myChip.isSelected());
                myChip.setChipBackgroundColorResource(myChip.isSelected() ? R.color.chip_selected_color : R.color.chip_default_color);
                myChip.setTextColor(getResources().getColor(myChip.isSelected() ? android.R.color.white : R.color.black));
            });
        }

        return view;
    }
}