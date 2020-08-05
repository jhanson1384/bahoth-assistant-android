package com.jhanson1384.bahothassistant;

import android.graphics.Color;
import android.view.View;

//Player color determines which characters are available to pick from the start of the game
//Each player must have a different color character
public enum PlayerColor {
    YELLOW,
    PURPLE,
    BLUE,
    RED,
    GREEN,
    WHITE;

    public void setBgColor(View v){
        switch(this){
            case YELLOW:
                v.setBackgroundColor(Color.YELLOW);
                break;
            case PURPLE:
                v.setBackgroundColor(Color.parseColor("#800080"));
                break;
            case BLUE:
                v.setBackgroundColor(Color.BLUE);
                break;
            case RED:
                v.setBackgroundColor(Color.RED);
                break;
            case GREEN:
                v.setBackgroundColor(Color.GREEN);
                break;
            case WHITE:
                v.setBackgroundColor(Color.LTGRAY);
                break;
        }
    }
}
