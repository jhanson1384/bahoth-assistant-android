package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DamageRollFragment extends NDiceRollFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected void displayNDice(TextView label){
        TextView tv =
                (label == null) ? (TextView) getActivity().findViewById(R.id.n_dice_label) : label;

        String text = "Number of Damage Dice: " + diceManager.getNDice();
        tv.setText(text);
    }

    @Override
    protected void displayRollSum(){
        TextView roll_sum = (TextView) getActivity().findViewById(R.id.roll_sum);
        String view_text = "Damage Taken: " + diceManager.sum();
        roll_sum.setText(view_text);
        //TextView is initially set to visibility:gone, make sure it is now visible
        roll_sum.setVisibility(View.VISIBLE);
    }
}