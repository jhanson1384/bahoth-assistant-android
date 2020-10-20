package com.jhanson1384.bahothassistant;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HauntRollFragment extends DiceRollFragment {

    private static final String ARG_HAUNT_COUNT = "HauntRollFragment.HAUNT_COUNT";

    private int haunt_count;

    public static HauntRollFragment newInstance(int haunt_count) {
        HauntRollFragment fragment = new HauntRollFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_HAUNT_COUNT, haunt_count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            haunt_count = getArguments().getInt(ARG_HAUNT_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        //Create TextView displaying haunt count
        initRollOverviewText((ViewGroup) v);

        //Modify done_btn text
        Button cancel_btn = (Button) v.findViewById(R.id.done_btn);
        cancel_btn.setText("Cancel");

        return v;
    }

    @Override
    protected void initDiceManager(){
        diceManager = new DiceManager(6);
    }


    private void initRollOverviewText(ViewGroup parent_view){
        TextView roll_overview = new TextView(getContext());
        String message = haunt_count + " omen cards have been drawn";
        roll_overview.setText(message);
        roll_overview.setTextColor(Color.WHITE);

        //Add TextView at top of parent
        parent_view.addView(roll_overview, 0);
    }

    private boolean hauntHasBegun(){
        return (diceManager.sum() < haunt_count);
    }

    @Override
    protected void displayRollSum(){
        TextView roll_sum = (TextView) getActivity().findViewById(R.id.roll_sum);
        int sum = diceManager.sum();

        //Set text based on roll outcome
        String view_text = ((hauntHasBegun()) ? "Haunt has begun!\n" : "Haunt avoided.\n") +
                            "Your roll: " + sum + "; Needed to roll: " + haunt_count;

        roll_sum.setText(view_text);
        //TextView is initially set to visibility:gone, make sure it is now visible
        roll_sum.setVisibility(View.VISIBLE);
    }

    @Override
    public void rollDice(){
        super.rollDice();
        //TODO
    }
}