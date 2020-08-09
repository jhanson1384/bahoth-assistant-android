package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class FilterColorActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.jhanson1384.bahothassistant.FILTER_LIST";
    //Maintain list of which filter colors are selected
    private int[] filter_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_color);

        //Setup toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.filter_color_toolbar);
        setSupportActionBar(toolbar);
        //Init data members
        filter_list = new int[6];
        for (int i=0; i<filter_list.length; i++){ filter_list[i] = PlayerColor.NONE.getValue(); }
    }

    public void cbClickedHandler(View v){
        boolean checked = ((CheckBox) v).isChecked();
        PlayerColor color = PlayerColor.YELLOW;
        //Set color based on id
        switch(v.getId()){
            case R.id.filter_yellow_cb:
                color = PlayerColor.YELLOW;
                break;
            case R.id.filter_purple_cb:
                color = PlayerColor.PURPLE;
                break;
            case R.id.filter_blue_cb:
                color = PlayerColor.BLUE;
                break;
            case R.id.filter_red_cb:
                color = PlayerColor.RED;
                break;
            case R.id.filter_green_cb:
                color = PlayerColor.GREEN;
                break;
            case R.id.filter_white_cb:
                color = PlayerColor.WHITE;
                break;
        }
        if (!checked){
            filter_list[color.index()] = PlayerColor.NONE.getValue();
        } else {
            filter_list[color.index()] = color.getValue();
        }
    }

    //Returns true if all boxes are unchecked
    private boolean noBoxesChecked(){
        for (int val : filter_list){
            if (PlayerColor.decodeValue(val) != PlayerColor.NONE) return false;
        }
        return true;
    }

    public void doneBtnHandler(MenuItem mi){
        Intent i = new Intent(this, ChooseCharacterActivity.class);
        //Return RESULT_CANCELED if no boxes were checked
        if (noBoxesChecked()){
            setResult(Activity.RESULT_CANCELED, i);
        } else {
            i.putExtra(EXTRA_NAME, filter_list);
            setResult(Activity.RESULT_OK, i);
        }
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.filter_color_menu, menu);
        return true;
    }

}