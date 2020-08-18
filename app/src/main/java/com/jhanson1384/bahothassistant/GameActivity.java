package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {
    private FragmentManager frag_manager;

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
        //Setup initial character display layout
        FragmentTransaction transaction = frag_manager.beginTransaction();
        DisplayCharacterFragment disp_char_frag = new DisplayCharacterFragment();
        transaction.add(R.id.game_activity, disp_char_frag);
        transaction.commit();
    }

    private BahothGame game;
}