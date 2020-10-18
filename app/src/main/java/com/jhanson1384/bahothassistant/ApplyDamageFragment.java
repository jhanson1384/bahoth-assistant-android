package com.jhanson1384.bahothassistant;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ApplyDamageFragment extends DisplayCharacterFragment {

    private static final String ARG_DAMAGE = "ApplyDamageFragment.ARG_DAMAGE";

    private int arg_damage;

    private Button apply_dmg_btn;

    public static ApplyDamageFragment newInstance(int damage, PlayerCharacter character) {
        ApplyDamageFragment fragment = new ApplyDamageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_DAMAGE, damage);
        args.putSerializable(DisplayCharacterFragment.EXTRA_CHAR_BUNDLE, character);
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
        ViewGroup v = (ViewGroup) super.onCreateView(inflater, container, savedInstanceState);

        apply_dmg_btn = new Button(getContext());
        updateApplyDmgBtnText();
        v.addView(apply_dmg_btn);

        return v;
    }

    private int sumDmgAllocated(){
        int sum = 0;
        StatType[] all_types = {StatType.SPEED, StatType.MIGHT, StatType.SANITY, StatType.KNOWLEDGE};

        for (StatType st : all_types) {
            sum += getStatSliderInd(st) - getTempStatInd(st);
        }
        return sum;
    }

    private void updateApplyDmgBtnText(){
        int damage_left = arg_damage - sumDmgAllocated();
        String btn_text;

        if (damage_left == 0){
            btn_text = "Apply Damage";
        }else{
            btn_text = "Tap above to allocate damage (" + damage_left + " pts left)";
        }

        apply_dmg_btn.setText(btn_text);
    }

    @Override
    public void sliderItemOCH(View v, StatType st){
        int old_temp_ind = getTempStatInd(st);
        int current_ind = getStatSliderInd(st);
        int new_temp_ind = ((ViewGroup) v.getParent()).indexOfChild(v) - 1;

        //Make sure new_temp_ind is within possible bounds
        if (new_temp_ind > current_ind){
            Toast.makeText(getContext(), "Cannot increase stats", Toast.LENGTH_SHORT).show();
            return;
        }
        int new_sum_dmg = sumDmgAllocated() + old_temp_ind - new_temp_ind;
        if (new_sum_dmg > arg_damage){
            Toast.makeText(getContext(), "Exceeds needed damage", Toast.LENGTH_SHORT).show();
            return;
        }

        //Set new temp stat index
        setTempStatInd(st, new_temp_ind);

        //De-Select current slider item, if any
        if (old_temp_ind != current_ind){
            View old_view = getStatView(st, old_temp_ind);
            highlightGeneric(old_view, 0, old_temp_ind);
        }

        //Highlight newly selected slider item
        if (new_temp_ind != current_ind){
            highlightGeneric(v, 1, new_temp_ind);
        }

        updateApplyDmgBtnText();
    }
}