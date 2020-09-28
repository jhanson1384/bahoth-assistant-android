package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class DiceRollMenuFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dice_roll_menu, container, false);

        //Set onClick listener for N-Roll button
        Button n_roll_btn = (Button) v.findViewById(R.id.n_roll_menu_btn);
        n_roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { nRollBtnHandler(); }
        });

        //Set onClick listener for Haunt Roll button
        Button haunt_roll_btn = (Button) v.findViewById(R.id.haunt_roll_menu_btn);
        haunt_roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { hauntRollBtnHandler(); }
        });

        //Set onClick listener for Stat Roll button
        Button stat_roll_btn = (Button) v.findViewById(R.id.stat_roll_menu_btn);
        stat_roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { statRollBtnHandler(); }
        });

        //Set onClick listener for Attack Roll button
        Button damage_roll_btn = (Button) v.findViewById(R.id.damage_roll_menu_btn);
        damage_roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { damageRollBtnHandler(); }
        });

        return v;
    }

    public void nRollBtnHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.clearFragments();

        //Add NDiceRollFragment to parent activity
        FragmentTransaction transaction = game_activity.getFragManager().beginTransaction();
        NDiceRollFragment n_dice_roll = new NDiceRollFragment();
        transaction.add(R.id.game_activity, n_dice_roll).commit();
    }

    public void hauntRollBtnHandler(){
        Toast.makeText(getContext(), "Haunt Roll Button", Toast.LENGTH_SHORT).show();
    }

    public void statRollBtnHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.clearFragments();

        //Add ChooseRollStatFragment to parent activity
        FragmentTransaction transaction = game_activity.getFragManager().beginTransaction();
        ChooseRollStatFragment choose_roll_stat = new ChooseRollStatFragment();
        transaction.add(R.id.game_activity, choose_roll_stat).commit();
    }

    public void damageRollBtnHandler(){
        Toast.makeText(getContext(), "Damage Roll Button", Toast.LENGTH_SHORT).show();
    }
}