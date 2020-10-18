package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DamageRollFragment extends NDiceRollFragment {
    private Button apply_dmg_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = super.onCreateView(inflater, container, savedInstanceState);

        //Change done button text to emphasize this option exits without applying damage
        Button done_btn = (Button) v.findViewById(R.id.done_btn);
        done_btn.setText("Done (No Damage)");

        //Add Apply Damage button to view, initially gone from layout
        apply_dmg_btn = new Button(getContext());
        apply_dmg_btn.setVisibility(View.GONE);
        apply_dmg_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                applyDmgHandler();
            }
        });
        ViewGroup done_btn_container = (ViewGroup) v.findViewById(R.id.done_btn_container);
        done_btn_container.addView(apply_dmg_btn);

        return v;
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

        String apply_dmg_text = "Apply *" + diceManager.sum() + "* Damage";
        apply_dmg_btn.setText(apply_dmg_text);
    }

    @Override
    public void rollDice(){
        super.rollDice();
        apply_dmg_btn.setVisibility(View.VISIBLE);
    }

    public void applyDmgHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.clearFragments();

        //Add ApplyDamageFragment to parent activity
        FragmentTransaction transaction = game_activity.getFragManager().beginTransaction();
        PlayerCharacter character = ((GameActivity) getActivity()).getGame().getPC();
        ApplyDamageFragment apply_dmg_frag = ApplyDamageFragment.newInstance(diceManager.sum(), character);
        transaction.add(R.id.game_activity, apply_dmg_frag).commit();
    }
}