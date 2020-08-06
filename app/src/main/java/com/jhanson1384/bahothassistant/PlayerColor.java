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
                v.setBackgroundResource(R.drawable.yellow_bg);
                break;
            case PURPLE:
                v.setBackgroundResource(R.drawable.purple_bg);
                break;
            case BLUE:
                v.setBackgroundResource(R.drawable.blue_bg);
                break;
            case RED:
                v.setBackgroundResource(R.drawable.red_bg);
                break;
            case GREEN:
                v.setBackgroundResource(R.drawable.green_bg);
                break;
            case WHITE:
                v.setBackgroundResource(R.drawable.white_bg);
                break;
        }
    }
}
