package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class ChooseCharacterActivity extends AppCompatActivity {
    //Array of all characters, so they don't need to be destroyed/re-initialized when filter changes
    private PlayerCharacter[] all_characters;
    //ArrayList of available characters (can be filtered based on color)
    private ArrayList<PlayerCharacter> available_characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_character);

        //Initialize array containing all characters
        init_all_characters();
        //Populate available_characters list, initially contains all characters
        init_avail_characters();
    }

    private void init_all_characters(){
        //There are 12 total characters
        all_characters = new PlayerCharacter[12];
        //Populate array with one instance of each character
        all_characters[0] = new PlayerCharacter(CharacterEnum.MISSY);
        all_characters[1] = new PlayerCharacter(CharacterEnum.ZOE);
        all_characters[2] = new PlayerCharacter(CharacterEnum.JENNY);
        all_characters[3] = new PlayerCharacter(CharacterEnum.HEATHER);
        all_characters[4] = new PlayerCharacter(CharacterEnum.ZOSTRA);
        all_characters[5] = new PlayerCharacter(CharacterEnum.VIVIAN);
        all_characters[6] = new PlayerCharacter(CharacterEnum.DARRIN);
        all_characters[7] = new PlayerCharacter(CharacterEnum.OX);
        all_characters[8] = new PlayerCharacter(CharacterEnum.BRANDON);
        all_characters[9] = new PlayerCharacter(CharacterEnum.PETER);
        all_characters[10] = new PlayerCharacter(CharacterEnum.RHINEHARDT);
        all_characters[11] = new PlayerCharacter(CharacterEnum.LONGFELLOW);
    }

    private void init_avail_characters(){
        available_characters = new ArrayList<>();
        for (PlayerCharacter pc : all_characters){
            available_characters.add(pc);
        }
    }
}