package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NDiceRollFragment extends DiceRollFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState);

        //Add View to allow user to modify number of die being rolled
        View choose_n_dice_container = inflater.inflate(R.layout.choose_n_dice, v, false);
        v.addView(choose_n_dice_container, 0);
        displayNDice((TextView) choose_n_dice_container.findViewById(R.id.n_dice_label));
        //Set OnClickListener for increment/decrement buttons
        Button incr_n_dice_btn = (Button) choose_n_dice_container.findViewById(R.id.incr_n_dice_btn);
        Button decr_n_dice_btn = (Button) choose_n_dice_container.findViewById(R.id.decr_n_dice_btn);
        incr_n_dice_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { adjustNDice(1); }
        });
        decr_n_dice_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { adjustNDice(-1); }
        });

        return v;
    }

    protected void displayNDice(TextView label){
        TextView tv =
                (label == null) ? (TextView) getActivity().findViewById(R.id.n_dice_label) : label;

        String text = "Number of Dice: " + diceManager.getNDice();
        tv.setText(text);
    }

    public void adjustNDice(int diff){
        if (isSpecificRerollState) return;
        diceManager.adjustNDice(diff);
        displayNDice(null);
    }
}