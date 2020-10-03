package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;

import org.w3c.dom.Text;

public class DiceRollFragment extends Fragment {
    protected DiceManager diceManager;
    private boolean isSpecificRerollState = false;

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

        //Set OnClickListener for done button
        Button done_btn = (Button) v.findViewById(R.id.done_btn);
        done_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { doneBtnHandler(); }
        });

        //Set OnClickListener for specific reroll button
        Button specific_reroll_btn = (Button) v.findViewById(R.id.specific_reroll_btn);
        specific_reroll_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { specificRerollBtnHandler(); }
        });

        //Set OnClickListener for specific reroll cancel button
        Button specific_reroll_cancel_btn = (Button) v.findViewById(R.id.specific_reroll_cancel);
        specific_reroll_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { specificRerollDone(); }
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
            die_img.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    dieImgHandler((ImageView) view);
                }
            });
            die_img.setImageResource(getDiceImgID(diceManager.getDieVal(i)));
            die_img.setAdjustViewBounds(true);
            die_img.setLayoutParams(new LinearLayout.LayoutParams(150,150));
            dice_board.addView(die_img);
        }
        displayRollSum();

        //Change button text from "Roll" to "Reroll"
        Button roll_btn = (Button) getActivity().findViewById(R.id.roll_btn);
        roll_btn.setText("Reroll");

        //Make specific reroll button visible
        Button specific_reroll_btn = (Button) getActivity().findViewById(R.id.specific_reroll_btn);
        specific_reroll_btn.setVisibility(View.VISIBLE);
    }

    private void displayRollSum(){
        TextView roll_sum = (TextView) getActivity().findViewById(R.id.roll_sum);
        String view_text = "Sum: " + diceManager.sum();
        roll_sum.setText(view_text);
        //TextView is initially set to visibility:gone, make sure it is now visible
        roll_sum.setVisibility(View.VISIBLE);
    }

    public void doneBtnHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.clearFragments();

        //Go back to main game screen
        FragmentTransaction transaction = game_activity.getFragManager().beginTransaction();
        //Create DisplayCharacterFragment
        DisplayCharacterFragment disp_char_frag = new DisplayCharacterFragment();
        Bundle character_bundle = new Bundle();
        character_bundle.putSerializable(DisplayCharacterFragment.EXTRA_CHAR_BUNDLE,
                                         game_activity.getGame().getPC());
        disp_char_frag.setArguments(character_bundle);
        //Create MainActionsFragment
        MainActionsFragment main_actions = new MainActionsFragment();

        //Add fragments to activity
        transaction.add(R.id.game_activity, disp_char_frag);
        transaction.add(R.id.game_activity, main_actions);
        transaction.commit();
    }

    public void specificRerollBtnHandler(){
        isSpecificRerollState = true;

        Button roll_btn = (Button) getActivity().findViewById(R.id.roll_btn);
        roll_btn.setVisibility(View.GONE);

        Button specific_reroll_btn = (Button) getActivity().findViewById(R.id.specific_reroll_btn);
        specific_reroll_btn.setVisibility(View.GONE);

        Button cancel_btn = (Button) getActivity().findViewById(R.id.specific_reroll_cancel);
        cancel_btn.setVisibility(View.VISIBLE);

        Button specific_reroll_confirm_btn = (Button) getActivity().findViewById(R.id.specific_reroll_confirm);
        specific_reroll_confirm_btn.setVisibility(View.VISIBLE);

        TextView specific_reroll_msg = (TextView) getActivity().findViewById(R.id.specific_reroll_msg);
        specific_reroll_msg.setVisibility(View.VISIBLE);
    }

    public void dieImgHandler(ImageView dieImg){
        //Do nothing if not choosing dice for specific reroll
        if (!isSpecificRerollState) return;

        dieImg.setImageResource(R.drawable.reroll_die);
    }

    private void specificRerollDone(){
        isSpecificRerollState = false;

        TextView specific_reroll_msg = (TextView) getActivity().findViewById(R.id.specific_reroll_msg);
        specific_reroll_msg.setVisibility(View.GONE);

        Button roll_btn = (Button) getActivity().findViewById(R.id.roll_btn);
        roll_btn.setVisibility(View.VISIBLE);

        Button specific_reroll_btn = (Button) getActivity().findViewById(R.id.specific_reroll_btn);
        specific_reroll_btn.setVisibility(View.VISIBLE);

        Button cancel_btn = (Button) getActivity().findViewById(R.id.specific_reroll_cancel);
        cancel_btn.setVisibility(View.GONE);

        Button specific_reroll_confirm_btn = (Button) getActivity().findViewById(R.id.specific_reroll_confirm);
        specific_reroll_confirm_btn.setVisibility(View.GONE);
    }
}
//TODO reset die image from reroll img when clicked again, or when specific reroll cancelled