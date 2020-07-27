package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ChooseCharacterActivity extends AppCompatActivity {
    //Array of all characters, so they don't need to be destroyed/re-initialized when filter changes
    private PlayerCharacter[] all_characters;
    //ArrayList of available characters (can be filtered based on color)
    private ArrayList<PlayerCharacter> available_characters;
    //RecyclerView for list of characters and associated objects
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_character);

        //Initialize array containing all characters
        initAllCharacters();
        //Populate available_characters list, initially contains all characters
        initAvailCharacters();

        //Setup RecyclerView and associated classes to display characters to choose from
        mRecyclerView = (RecyclerView) findViewById(R.id.choose_character_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChooseCharacterAdapter(available_characters);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void initAllCharacters(){
        //There are 12 total characters
        all_characters = new PlayerCharacter[12];
        //Populate array with one instance of each character
        all_characters[CharacterEnum.MISSY.getIndex()] = new PlayerCharacter(CharacterEnum.MISSY);
        all_characters[CharacterEnum.ZOE.getIndex()] = new PlayerCharacter(CharacterEnum.ZOE);
        all_characters[CharacterEnum.JENNY.getIndex()] = new PlayerCharacter(CharacterEnum.JENNY);
        all_characters[CharacterEnum.HEATHER.getIndex()] = new PlayerCharacter(CharacterEnum.HEATHER);
        all_characters[CharacterEnum.ZOSTRA.getIndex()] = new PlayerCharacter(CharacterEnum.ZOSTRA);
        all_characters[CharacterEnum.VIVIAN.getIndex()] = new PlayerCharacter(CharacterEnum.VIVIAN);
        all_characters[CharacterEnum.DARRIN.getIndex()] = new PlayerCharacter(CharacterEnum.DARRIN);
        all_characters[CharacterEnum.OX.getIndex()] = new PlayerCharacter(CharacterEnum.OX);
        all_characters[CharacterEnum.BRANDON.getIndex()] = new PlayerCharacter(CharacterEnum.BRANDON);
        all_characters[CharacterEnum.PETER.getIndex()] = new PlayerCharacter(CharacterEnum.PETER);
        all_characters[CharacterEnum.RHINEHARDT.getIndex()] = new PlayerCharacter(CharacterEnum.RHINEHARDT);
        all_characters[CharacterEnum.LONGFELLOW.getIndex()] = new PlayerCharacter(CharacterEnum.LONGFELLOW);
    }

    private void initAvailCharacters(){
        available_characters = new ArrayList<>();
        for (PlayerCharacter pc : all_characters){
            available_characters.add(pc);
        }
    }
}