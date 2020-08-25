package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class DisplayCharacterFragment extends Fragment {
    public static final String EXTRA_CHAR_BUNDLE = "com.jhanson1384.bahothassistant.CHARACTER_BUNDLE";

    private PlayerCharacter character;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Read arguments
        if (getArguments() != null){
            character = (PlayerCharacter) getArguments().getSerializable(EXTRA_CHAR_BUNDLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_display_character, container, false);
    }
}