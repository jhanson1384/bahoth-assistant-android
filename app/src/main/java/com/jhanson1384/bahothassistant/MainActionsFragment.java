package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActionsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main_actions, container, false);

        //Set onClick listener for Dice Roll button
        Button dice_roll_btn = (Button) v.findViewById(R.id.dice_roll_btn);
        dice_roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { diceRollBtnHandler(); }
        });

        //Set onClick listener for Adjust Stats button
        Button adjust_stats_btn = (Button) v.findViewById(R.id.adjust_stats_btn);
        adjust_stats_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { adjustStatsBtnHandler(); }
        });

        return v;
    }

    public void diceRollBtnHandler(){
        Toast.makeText(getContext(), "Dice Roll Button", Toast.LENGTH_SHORT).show();
    }

    public void adjustStatsBtnHandler(){
        Toast.makeText(getContext(), "Adjust Stats Button", Toast.LENGTH_SHORT).show();
    }
}