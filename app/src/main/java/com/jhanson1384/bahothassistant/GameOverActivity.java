package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOverActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Display "Game Over" message
        ((TextView) findViewById(R.id.game_over_label)).setVisibility(View.VISIBLE);
    }
}