package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DiceRollFragment extends Fragment {
    private DiceManager diceManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dice_roll, container, false);

        //Init dice manager
        diceManager = new DiceManager(8);

        return v;
    }

    //Get resource ID for dice image of given value
    private int getDiceImgID(int dice_val){
        switch (dice_val){
            case 0:
                return R.drawable.zero_die;
            case 1:
                return R.drawable.one_die;
            case 2:
                return R.drawable.two_die;
        }
        return R.drawable.zero_die;
    }
}