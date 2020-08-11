package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ChooseCharacterActivity extends AppCompatActivity {

    //Request code for launching FilterColorActivity
    public static final int LAUNCH_FILTER_COLOR = 1;

    //Array of all characters, so they don't need to be destroyed/re-initialized when filter changes
    private PlayerCharacter[] all_characters;
    //ArrayList of available characters (can be filtered based on color)
    private ArrayList<PlayerCharacter> available_characters;
    //RecyclerView for list of characters and associated objects
    private RecyclerView mRecyclerView;
    private ChooseCharacterAdapter mAdapter;
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
        initRecyclerView();
    }

    //Starts FilterColorActivity, which will return selected colors to filter
    public void filterColorBtnHandler(View v){
        Intent i = new Intent(this, FilterColorActivity.class);
        startActivityForResult(i, LAUNCH_FILTER_COLOR);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode != LAUNCH_FILTER_COLOR) return;

        //resultCode will be RESULT_CANCELED if no filter colors were selected.
        //If this is the case, the previous filter remains the same, since an empty list isn't intended
        if (resultCode == Activity.RESULT_OK){
            int[] filter_list = data.getIntArrayExtra(FilterColorActivity.EXTRA_NAME);
            applyFilterChange(filter_list);
        }
    }

    //Update the list of characters based on list of colors to filter
    private void applyFilterChange(int[] filter_list){
        //Update available_characters based on filter colors
        available_characters.clear();
        for (int val : filter_list){
            switch(PlayerColor.decodeValue(val)){
                case YELLOW:
                    available_characters.add(all_characters[CharacterEnum.MISSY.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.ZOE.getIndex()]);
                    break;
                case PURPLE:
                    available_characters.add(all_characters[CharacterEnum.JENNY.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.HEATHER.getIndex()]);
                    break;
                case BLUE:
                    available_characters.add(all_characters[CharacterEnum.ZOSTRA.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.VIVIAN.getIndex()]);
                    break;
                case RED:
                    available_characters.add(all_characters[CharacterEnum.DARRIN.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.OX.getIndex()]);
                    break;
                case GREEN:
                    available_characters.add(all_characters[CharacterEnum.BRANDON.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.PETER.getIndex()]);
                    break;
                case WHITE:
                    available_characters.add(all_characters[CharacterEnum.RHINEHARDT.getIndex()]);
                    available_characters.add(all_characters[CharacterEnum.LONGFELLOW.getIndex()]);
                    break;
            }
        }
        //Update the adapter
        mAdapter.notifyDataSetChanged();
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

    private void initRecyclerView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.choose_character_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ChooseCharacterAdapter(available_characters);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setItemClickListener(new ChooseCharacterAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                String pc = available_characters.get(position).getName();
                Toast.makeText(ChooseCharacterActivity.this, pc, Toast.LENGTH_SHORT).show();
            }
        });
    }
}