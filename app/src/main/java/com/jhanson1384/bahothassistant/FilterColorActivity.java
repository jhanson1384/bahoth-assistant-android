package com.jhanson1384.bahothassistant;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FilterColorActivity extends AppCompatActivity {
    public static final String EXTRA_NAME = "com.jhanson1384.bahothassistant.FILTER_LIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_color);

        testFunction();
    }

    public void testFunction(){
        Intent i = new Intent(this, ChooseCharacterActivity.class);
        int[] data = {PlayerColor.RED.getValue(),
                      PlayerColor.NONE.getValue(),
                      PlayerColor.WHITE.getValue(),
                      PlayerColor.BLUE.getValue()};
        i.putExtra(EXTRA_NAME, data);
        setResult(Activity.RESULT_OK, i);
        finish();
    }
}