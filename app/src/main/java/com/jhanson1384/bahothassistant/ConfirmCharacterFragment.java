package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmCharacterFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_confirm_character, container, false);

        //Set onClick behavior for Confirm Character button
        Button btn = (Button) v.findViewById(R.id.confirm_character_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { confirmCharBtnHandler(); }
        });

        return v;
    }

    public void confirmCharBtnHandler(){
        //Get FragmentManager from parent activity
        FragmentManager frag_manager = ((GameActivity) getActivity()).getFragManager();

        //Remove this fragment
        FragmentTransaction transaction = frag_manager.beginTransaction();
        transaction.remove(this);
        //Replace with MainActionsFragment
        MainActionsFragment main_actions = new MainActionsFragment();
        transaction.add(R.id.game_activity, main_actions);

        transaction.commit();
    }
}