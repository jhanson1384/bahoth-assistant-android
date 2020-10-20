package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActionsFragment extends Fragment {
    private boolean isAdjustmentState;

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

        //Initialize Omen Counter label
        updateOmenCounter(v);

        //Set onClick listeners for increment/decrement omen counter buttons
        Button incr_omen_count_btn = (Button) v.findViewById(R.id.increment_omen_btn);
        Button decr_omen_count_btn = (Button) v.findViewById(R.id.decrement_omen_btn);
        incr_omen_count_btn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                ((GameActivity) getActivity()).getGame().adjustOmenCounter(1);
                updateOmenCounter(null);
            }
        });
        decr_omen_count_btn.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View view){
                ((GameActivity) getActivity()).getGame().adjustOmenCounter(-1);
                updateOmenCounter(null);
            }
        });

        if (((GameActivity) getActivity()).getGame().isHauntStarted()){
            incr_omen_count_btn.setVisibility(View.GONE);
            decr_omen_count_btn.setVisibility(View.GONE);
        }

        return v;
    }

    public void diceRollBtnHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.clearFragments();

        //Add DiceRollMenuFragment to parent activity
        FragmentTransaction transaction = game_activity.getFragManager().beginTransaction();
        DiceRollMenuFragment dice_roll_menu_frag = new DiceRollMenuFragment();
        transaction.add(R.id.game_activity, dice_roll_menu_frag).commit();
    }

    public void updateOmenCounter(View view){
        View v = (view == null) ? getView() : view;
        TextView omen_counter_label = (TextView) v.findViewById(R.id.omen_counter_label);
        omen_counter_label.setText(((GameActivity) getActivity()).getGame().displayOmenCounter());
    }


    public void adjustStatsBtnHandler(){
        if (!isAdjustmentState) return;
        GameActivity game_activity = (GameActivity) getActivity();

        game_activity.updateStats();

        setAdjustmentState(false);
    }

    public void setAdjustmentState(boolean isAdjustmentState){
        this.isAdjustmentState = isAdjustmentState;

        //Update button text
        Button adjust_stats_btn = (Button) getActivity().findViewById(R.id.adjust_stats_btn);
        if (isAdjustmentState){
            adjust_stats_btn.setText("Update Stats");
        }else{
            adjust_stats_btn.setText("Tap above to adjust character stats");
        }
    }

}