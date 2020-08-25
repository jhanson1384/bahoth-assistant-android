package com.jhanson1384.bahothassistant;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayCharacterFragment extends Fragment {
    public static final String EXTRA_CHAR_BUNDLE = "com.jhanson1384.bahothassistant.CHARACTER_BUNDLE";

    private PlayerCharacter character;

    //View objects for character data
    private TextView name;
    private ImageView portrait;
    private TextView age;
    private TextView height;
    private TextView weight;
    private TextView hobbies;
    private TextView birthday;
    private TextView description;
    private TextView fears;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Read arguments
        if (getArguments() != null){
            character = (PlayerCharacter) getArguments().getSerializable(EXTRA_CHAR_BUNDLE);
        }

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_character, container, false);

        //Create View objects
        initViews(view);

        return view;
    }

    private void initViews(View v){
        name = (TextView) v.findViewById(R.id.display_character_name);
        portrait = (ImageView) v.findViewById(R.id.display_character_portrait);
        age = (TextView) v.findViewById(R.id.display_character_age);
        height = (TextView) v.findViewById(R.id.display_character_height);
        weight = (TextView) v.findViewById(R.id.display_character_weight);
        hobbies = (TextView) v.findViewById(R.id.display_character_hobbies);
        birthday = (TextView) v.findViewById(R.id.display_character_birthday);
        description = (TextView) v.findViewById(R.id.display_character_description);
        fears = (TextView) v.findViewById(R.id.display_character_fears);

        //Initialize view contents
        updateViewContents();
    }

    private void updateViewContents(){
        name.setText(character.getName());
        portrait.setImageResource(character.getPortraitID());
        age.setText(character.displayAge());
        height.setText(character.displayHeight());
        weight.setText(character.displayWeight());
        hobbies.setText(character.displayHobbies());
        birthday.setText(character.displayBirthday());
        description.setText(character.displayDescription());
        fears.setText(character.displayFears());
        
        //Set background color
        character.getColor().setBgColor(name.getRootView());
    }
}