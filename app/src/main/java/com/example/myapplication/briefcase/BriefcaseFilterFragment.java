package com.example.myapplication.briefcase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myapplication.R;
import com.google.android.material.slider.RangeSlider;

public class BriefcaseFilterFragment extends Fragment {

    private RangeSlider experienceRangeSlider, profileRangeSlider;

    private Spinner briefcaseAvailabilitySpinner;

    private TextView experienceScore, profileScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_briefcase_filter, container, false);

        experienceRangeSlider = view.findViewById(R.id.experience_range_slider);
        profileRangeSlider = view.findViewById(R.id.profile_range_slider);

        experienceScore = view.findViewById(R.id.experience_score);
        profileScore = view.findViewById(R.id.profile_score);

        briefcaseAvailabilitySpinner = view.findViewById(R.id.availabilitySpinner);

        experienceRangeSlider.setLabelFormatter(value -> {
            return String.valueOf((int) value); // format the label as an integer value
        });

        experienceRangeSlider.addOnChangeListener((slider, value, fromUser) -> experienceScore.setText(slider.getValues().get(0).intValue() + "-" + slider.getValues().get(1).intValue()));

        profileRangeSlider.setLabelFormatter(value -> {
            return String.valueOf((int) value); // format the label as an integer value
        });

        profileRangeSlider.addOnChangeListener((slider, value, fromUser) -> profileScore.setText(slider.getValues().get(0).intValue() + "-" + slider.getValues().get(1).intValue()));

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.my_briefcase_spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        briefcaseAvailabilitySpinner.setAdapter(adapter);

        return view;
    }
}