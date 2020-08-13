package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Get character type that was selected
        Intent i = getIntent();
        CharacterEnum char_type = CharacterEnum.decodeIndex(
                i.getIntExtra(ChooseCharacterActivity.EXTRA_CHAR_TYPE, 0));
        game = new BahothGame(char_type);
    }

    private BahothGame game;
}