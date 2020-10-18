package com.jhanson1384.bahothassistant;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ApplyDamageFragment extends DisplayCharacterFragment {

    private static final String ARG_DAMAGE = "ApplyDamageFragment.ARG_DAMAGE";

    private int arg_damage;

    public static ApplyDamageFragment newInstance(int damage) {
        ApplyDamageFragment fragment = new ApplyDamageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_DAMAGE, damage);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            arg_damage = getArguments().getInt(ARG_DAMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}