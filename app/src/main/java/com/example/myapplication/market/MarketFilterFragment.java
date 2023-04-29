package com.example.myapplication.market;

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

public class MarketFilterFragment extends Fragment {

    private Spinner marketAvailabilitySpinner;

    private RangeSlider rangeSlider;

    private TextView profileScore;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_market_filter, container, false);

        marketAvailabilitySpinner = view.findViewById(R.id.availabilitySpinner);
        rangeSlider = view.findViewById(R.id.profile_range_slider);
        profileScore = view.findViewById(R.id.profile_score);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.my_market_spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marketAvailabilitySpinner.setAdapter(adapter);

        rangeSlider.setLabelFormatter(value -> {
            return String.valueOf((int) value); // format the label as an integer value
        });

        rangeSlider.addOnChangeListener((slider, value, fromUser) -> profileScore.setText(slider.getValues().get(0).intValue() + "-" + slider.getValues().get(1).intValue()));

        return view;
    }
}