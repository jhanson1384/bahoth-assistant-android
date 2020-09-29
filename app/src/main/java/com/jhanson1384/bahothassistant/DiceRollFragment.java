package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;

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
        initDiceManager();

        //Set OnClickListener for dice roll button
        Button roll_btn = (Button) v.findViewById(R.id.roll_btn);
        roll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { rollDice(); }
        });

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

    private void initDiceManager(){
        diceManager = new DiceManager(8);
    }

    public void rollDice(){
        diceManager.roll();

        //Clear existing dice from board
        FlexboxLayout dice_board = (FlexboxLayout) getActivity().findViewById(R.id.dice_board);
        dice_board.removeAllViews();
        //Add new dice to board
        for (int i=0; i<diceManager.getNDice(); ++i){
            ImageView die_img = new ImageView(getContext());
            die_img.setImageResource(getDiceImgID(diceManager.getDieVal(i)));
            dice_board.addView(die_img);
        }
    }
}