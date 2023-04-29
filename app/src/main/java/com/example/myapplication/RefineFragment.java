package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;

public class RefineFragment extends Fragment {

    private Chip coffee, business, hobbies, friendship, movies, dining, dating, matrimony;
    private TextView characterCountTextView;
    private TextInputEditText textInputEditText;
    private final int maxCharacters = 250;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_refine, container, false);

        Spinner mySpinner = view.findViewById(R.id.availabilitySpinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.my_spinner_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);

        characterCountTextView = view.findViewById(R.id.characterCountTextView);

        textInputEditText = view.findViewById(R.id.textInputEditText);
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Update the character count TextView
                int currentCharacterCount = s.length();
                characterCountTextView.setText(String.format("%d/%d", currentCharacterCount, maxCharacters));
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });

        coffee = view.findViewById(R.id.chip_coffee);
        business = view.findViewById(R.id.chip_business);
        hobbies = view.findViewById(R.id.chip_hobbies);
        friendship = view.findViewById(R.id.chip_friendship);
        movies = view.findViewById(R.id.chip_movies);
        dining = view.findViewById(R.id.chip_dining);
        dating = view.findViewById(R.id.chip_dating);
        matrimony = view.findViewById(R.id.chip_matrimony);

        Chip[] chips = {coffee, business, hobbies, friendship, movies, dining, dating, matrimony};

        for (Chip myChip : chips) {
            myChip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myChip.setSelected(!myChip.isSelected());
                    myChip.setChipBackgroundColorResource(myChip.isSelected() ? R.color.chip_selected_color : R.color.chip_default_color);
                    myChip.setTextColor(getResources().getColor(myChip.isSelected() ? android.R.color.white : R.color.black));
                }
            });
        }
        return view;
    }
}