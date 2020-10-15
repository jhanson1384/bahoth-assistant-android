package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private FragmentManager frag_manager;
    private BahothGame game;

    public FragmentManager getFragManager(){ return frag_manager; }
    public BahothGame getGame(){ return game; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Get character type that was selected
        Intent i = getIntent();
        CharacterEnum char_type = CharacterEnum.decodeIndex(
                i.getIntExtra(ChooseCharacterActivity.EXTRA_CHAR_TYPE, 0));
        game = new BahothGame(char_type);

        //Init fragment manager
        frag_manager = getSupportFragmentManager();
        //Setup initial layout
        initDisplayCharFragment();
        initConfirmCharFragment();
    }

    public void clearFragments(){
        for (Fragment frag : frag_manager.getFragments()){
            frag_manager.beginTransaction().remove(frag).commit();
        }
    }

    //Initialize the DisplayCharacterFragment
    private void initDisplayCharFragment() {
        //Create Fragment
        FragmentTransaction transaction = frag_manager.beginTransaction();
        DisplayCharacterFragment disp_char_frag = new DisplayCharacterFragment();

        //Send PlayerCharacter data via Bundle
        Bundle character_bundle = new Bundle();
        character_bundle.putSerializable(DisplayCharacterFragment.EXTRA_CHAR_BUNDLE, game.getPC());
        disp_char_frag.setArguments(character_bundle);

        //Add fragment to layout
        transaction.add(R.id.game_activity, disp_char_frag);
        transaction.commit();
    }

    //Initialize the ConfirmCharacterFragment
    private void initConfirmCharFragment() {
        //Create Fragment
        FragmentTransaction transaction = frag_manager.beginTransaction();
        ConfirmCharacterFragment confirm_char_frag = new ConfirmCharacterFragment();

        //Add fragment to layout
        transaction.add(R.id.game_activity, confirm_char_frag);
        transaction.commit();
    }


    public void setAdjustmentState(boolean isAdjustmentState){
        Fragment fragment = frag_manager.getFragments().get(1);
        if (!(fragment instanceof MainActionsFragment)) return;
        MainActionsFragment main_actions_frag = (MainActionsFragment) fragment;
        main_actions_frag.setAdjustmentState(isAdjustmentState);
    }

    public void updateStats(){
        Fragment fragment = frag_manager.getFragments().get(0);
        if (!(fragment instanceof DisplayCharacterFragment)) return;
        ((DisplayCharacterFragment) fragment).updateStats();
    }
}