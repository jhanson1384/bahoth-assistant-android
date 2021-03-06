package com.jhanson1384.bahothassistant;

import android.graphics.Color;
import android.view.View;

//Player color determines which characters are available to pick from the start of the game
//Each player must have a different color character
public enum PlayerColor {
    NONE(0),
    YELLOW(1),
    PURPLE(2),
    BLUE(3),
    RED(4),
    GREEN(5),
    WHITE(6);

    private final int value;

    PlayerColor(int val) { this.value = val; }

    public int getValue(){ return value; }
    public int index(){ return value - 1; }

    //Decode PlayerColor from int value (used when sending via Intent)
    public static PlayerColor decodeValue(int val){
        switch(val){
            case 1:
                return YELLOW;
            case 2:
                return PURPLE;
            case 3:
                return BLUE;
            case 4:
                return RED;
            case 5:
                return GREEN;
            case 6:
                return WHITE;
            default:
                return NONE;
        }
    }

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

    public void setBgColorBorder(View v){
        switch(this){
            case YELLOW:
                v.setBackgroundResource(R.drawable.yellow_bg_border);
                break;
            case PURPLE:
                v.setBackgroundResource(R.drawable.purple_bg_border);
                break;
            case BLUE:
                v.setBackgroundResource(R.drawable.blue_bg_border);
                break;
            case RED:
                v.setBackgroundResource(R.drawable.red_bg_border);
                break;
            case GREEN:
                v.setBackgroundResource(R.drawable.green_bg_border);
                break;
            case WHITE:
                v.setBackgroundResource(R.drawable.white_bg_border);
                break;
        }
    }

    public void setBgColorHighlight(View v, boolean isLight){
        if (isLight){
            v.setBackgroundResource(R.drawable.white_bg_light_highlight);
        }else {
            v.setBackgroundResource(R.drawable.white_bg_highlight);
        }
    }
}
