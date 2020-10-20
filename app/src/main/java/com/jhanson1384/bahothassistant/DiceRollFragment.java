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
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

import org.w3c.dom.Text;

public class DiceRollFragment extends Fragment {
    protected DiceManager diceManager;
    protected boolean isSpecificRerollState = false;
    private boolean[] rerollMask;

    private void resetRerollMask(){
        //Reset mask values to false
        for (int i=0; i<rerollMask.length; ++i){
            rerollMask[i] = false;
        }
    }

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

        //Set OnClickListener for specific reroll confirm button
        Button specific_reroll_confirm_btn = (Button) v.findViewById(R.id.specific_reroll_confirm);
        specific_reroll_confirm_btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { rollDiceSpecific(); }
        });

        rerollMask = new boolean[8];
        resetRerollMask();

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

    protected void initDiceManager(){
        diceManager = new DiceManager(1);
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

    public void rollDiceSpecific(){
        ViewGroup dice_board = (ViewGroup) getActivity().findViewById(R.id.dice_board);

        for (int i=0; i<diceManager.getNDice(); ++i){
            if (rerollMask[i]){
                diceManager.reroll(i);

                ImageView die_img = (ImageView) dice_board.getChildAt(i);
                die_img.setImageResource(getDiceImgID(diceManager.getDieVal(i)));
            }
        }
        displayRollSum();

        setSpecificRerollState(false);
    }

    public void dieImgHandler(ImageView dieImg){
        //Do nothing if not choosing dice for specific reroll
        if (!isSpecificRerollState) return;

        int ind = ((ViewGroup) dieImg.getParent()).indexOfChild(dieImg);

        if (rerollMask[ind]){
            dieImg.setImageResource(getDiceImgID(diceManager.getDieVal(ind)));
            rerollMask[ind] = false;
        }else{
            dieImg.setImageResource(R.drawable.reroll_die);
            rerollMask[ind] = true;
        }
    }

    public void specificRerollBtnHandler(){
        setSpecificRerollState(true);
    }

    private void specificRerollDone(){
        setSpecificRerollState(false);

        //Restore original view images
        ViewGroup parent = getActivity().findViewById(R.id.dice_board);
        for (int i=0; i<parent.getChildCount(); ++i){
            ((ImageView) parent.getChildAt(i)).setImageResource(getDiceImgID(diceManager.getDieVal(i)));
        }
    }

    private void setSpecificRerollState(boolean isSpecificRerollState){
        this.isSpecificRerollState = isSpecificRerollState;

        if (isSpecificRerollState) resetRerollMask();

        int originalViewVisibility = (isSpecificRerollState) ? View.GONE : View.VISIBLE;
        int rerollViewVisibility = (isSpecificRerollState) ? View.VISIBLE : View.GONE;

        Button roll_btn = (Button) getActivity().findViewById(R.id.roll_btn);
        roll_btn.setVisibility(originalViewVisibility);

        Button specific_reroll_btn = (Button) getActivity().findViewById(R.id.specific_reroll_btn);
        specific_reroll_btn.setVisibility(originalViewVisibility);

        Button cancel_btn = (Button) getActivity().findViewById(R.id.specific_reroll_cancel);
        cancel_btn.setVisibility(rerollViewVisibility);

        Button specific_reroll_confirm_btn = (Button) getActivity().findViewById(R.id.specific_reroll_confirm);
        specific_reroll_confirm_btn.setVisibility(rerollViewVisibility);

        TextView specific_reroll_msg = (TextView) getActivity().findViewById(R.id.specific_reroll_msg);
        specific_reroll_msg.setVisibility(rerollViewVisibility);
    }

    protected void displayRollSum(){
        TextView roll_sum = (TextView) getActivity().findViewById(R.id.roll_sum);
        String view_text = "Sum: " + diceManager.sum();
        roll_sum.setText(view_text);
        //TextView is initially set to visibility:gone, make sure it is now visible
        roll_sum.setVisibility(View.VISIBLE);
    }

    public void doneBtnHandler(){
        GameActivity game_activity = (GameActivity) getActivity();
        game_activity.initMainFragments();
    }
}