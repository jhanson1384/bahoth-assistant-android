package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        return v;
    }
}