package com.jhanson1384.bahothassistant;

import android.graphics.Color;
import android.os.Bundle;

import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayCharacterFragment extends Fragment {
    public static final String EXTRA_CHAR_BUNDLE = "com.jhanson1384.bahothassistant.CHARACTER_BUNDLE";

    private PlayerCharacter character;

    //View objects for character data
    private TextView name;
    private ImageView portrait;
    private TextView age;
    private TextView height;
    private TextView weight;
    private TextView hobbies;
    private TextView birthday;
    private TextView description;
    private TextView fears;
    private TextView[] speed_values = new TextView[8];
    private TextView[] might_values = new TextView[8];
    private TextView[] sanity_values = new TextView[8];
    private TextView[] knowledge_values = new TextView[8];
    //Parent layouts for stat value arrays
    private LinearLayout speed_scale;
    private LinearLayout might_scale;
    private LinearLayout sanity_scale;
    private LinearLayout knowledge_scale;

    private TextView[] getStatSliderViews(StatType st){
        switch (st){
            case SPEED:
                return speed_values;
            case MIGHT:
                return might_values;
            case SANITY:
                return sanity_values;
            case KNOWLEDGE:
                return knowledge_values;
        }
        return speed_values;
    }

    private int[] getStatSliderData(StatType st){
        switch (st){
            case SPEED:
                return character.getSpeedScale();
            case MIGHT:
                return character.getMightScale();
            case SANITY:
                return character.getSanityScale();
            case KNOWLEDGE:
                return character.getKnowledgeScale();
        }
        return character.getSpeedScale();
    }

    private int getStatSliderInd(StatType st){
        switch (st){
            case SPEED:
                return character.getSpeedInd();
            case MIGHT:
                return character.getMightInd();
            case SANITY:
                return character.getSanityInd();
            case KNOWLEDGE:
                return character.getKnowledgeInd();
        }
        return character.getSpeedInd();
    }

    private LinearLayout getStatLayout(StatType st){
        switch (st){
            case SPEED:
                return speed_scale;
            case MIGHT:
                return might_scale;
            case SANITY:
                return sanity_scale;
            case KNOWLEDGE:
                return knowledge_scale;
        }
        return speed_scale;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Read arguments
        if (getArguments() != null){
            character = (PlayerCharacter) getArguments().getSerializable(EXTRA_CHAR_BUNDLE);
        }

        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_display_character, container, false);

        //Create View objects
        initViews(view);

        return view;
    }

    private void initViews(View v){
        name = (TextView) v.findViewById(R.id.display_character_name);
        portrait = (ImageView) v.findViewById(R.id.display_character_portrait);
        age = (TextView) v.findViewById(R.id.display_character_age);
        height = (TextView) v.findViewById(R.id.display_character_height);
        weight = (TextView) v.findViewById(R.id.display_character_weight);
        hobbies = (TextView) v.findViewById(R.id.display_character_hobbies);
        birthday = (TextView) v.findViewById(R.id.display_character_birthday);
        description = (TextView) v.findViewById(R.id.display_character_description);
        fears = (TextView) v.findViewById(R.id.display_character_fears);
        speed_scale = (LinearLayout) v.findViewById(R.id.speed_scale_frame);
        might_scale = (LinearLayout) v.findViewById(R.id.might_scale_frame);
        sanity_scale = (LinearLayout) v.findViewById(R.id.sanity_scale_frame);
        knowledge_scale = (LinearLayout) v.findViewById(R.id.knowledge_scale_frame);
        initStatViews(StatType.SPEED);
        initStatViews(StatType.MIGHT);
        initStatViews(StatType.SANITY);
        initStatViews(StatType.KNOWLEDGE);

        //Initialize view contents
        updateViewContents();
    }

    private void updateViewContents(){
        name.setText(character.getName());
        portrait.setImageResource(character.getPortraitID());
        age.setText(character.displayAge());
        height.setText(character.displayHeight());
        weight.setText(character.displayWeight());
        hobbies.setText(character.displayHobbies());
        birthday.setText(character.displayBirthday());
        description.setText(character.displayDescription());
        fears.setText(character.displayFears());
        
        //Set background color
        character.getColor().setBgColor(name.getRootView());
        character.getColor().setBgColorBorder(speed_scale);
        character.getColor().setBgColorBorder(might_scale);
        character.getColor().setBgColorBorder(sanity_scale);
        character.getColor().setBgColorBorder(knowledge_scale);
    }

    private LinearLayout.LayoutParams sliderItemLayoutParams(){
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5, 0, 5, 0);

        return params;
    }

    //Highlight a slider item with a circle
    //highlightLevel determines the shade of the highlight: 0=none, 1=light, 2=dark
    private void highlightSliderItem(TextView tv, int highlightLevel){
        switch (highlightLevel){
            case 0:
                tv.setTextColor(Color.parseColor("#1E1E1E"));
                break;
            default:
                character.getColor().setBgColorHighlight(tv);
                tv.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }

    //Set OnClickHandler based on StatType
    public void setStatOCH(TextView tv, StatType st){
        switch (st){
            case SPEED:
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH((TextView) view, StatType.SPEED); }
                });
                return;
            case MIGHT:
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH((TextView) view, StatType.MIGHT); }
                });
                return;
            case SANITY:
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH((TextView) view, StatType.SANITY); }
                });
                return;
            case KNOWLEDGE:
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH((TextView) view, StatType.KNOWLEDGE); }
                });
                return;
        }
        tv.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { sliderItemOCH((TextView) view, StatType.SPEED); }
        });
    }

    //Slider Item On Click Handler
    public void sliderItemOCH(TextView tv, StatType st){
        Toast.makeText(getContext(), "Slider Item Clicked", Toast.LENGTH_SHORT).show();
    }

    private void initStatViews(StatType st){
        //Get relevant fields based on StatType
        TextView[] views = getStatSliderViews(st);
        LinearLayout layout = getStatLayout(st);
        int[] data = getStatSliderData(st);
        int ind = getStatSliderInd(st);

        TextView tv;
        for (int i=0; i<views.length; ++i){
            tv = views[i];
            tv = new TextView(getContext());

            tv.setLayoutParams(sliderItemLayoutParams());
            tv.setPadding(15, 0, 15, 0);
            tv.setText(Integer.toString(data[i]));
            tv.setTextSize(17);
            tv.setTypeface(ResourcesCompat.getFont(getContext(), R.font.abril_fatface));

            if (i==ind){
                highlightSliderItem(tv, 2);
            }else{
                highlightSliderItem(tv, 0);
            }

            //Set OnClickHandler
            setStatOCH(tv, st);

            layout.addView(tv);
        }
    }
}