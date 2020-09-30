package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return v;
    }
}