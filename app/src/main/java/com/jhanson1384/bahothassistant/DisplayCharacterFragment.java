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
    //Index of temporarily selected stat slider items
    private int temp_speed_ind;
    private int temp_might_ind;
    private int temp_sanity_ind;
    private int temp_knowledge_ind;

    public void updateStats(){
        StatType[] all_types = {StatType.SPEED, StatType.MIGHT, StatType.SANITY, StatType.KNOWLEDGE };
        for (StatType st : all_types){
            int temp_ind = getTempStatInd(st);
            //Character dies if a stat index is -1
            if (temp_ind == -1) {
                ((GameActivity) getActivity()).characterDeath();
                return;
            }

            //Un-Highlight previous stat index
            View old_view = getStatView(st, character.getStatInd(st));
            highlightGeneric(old_view, 0, character.getStatInd(st));

            //Update character stat index
            character.setStatInd(st, temp_ind);

            //Highlight new stat index
            int new_ind = character.getStatInd(st);
            highlightGeneric(getStatView(st, new_ind), 2, new_ind);
        }
    }

    protected int getTempStatInd(StatType st){
        switch (st){
            case SPEED:
                return temp_speed_ind;
            case MIGHT:
                return temp_might_ind;
            case SANITY:
                return temp_sanity_ind;
            case KNOWLEDGE:
                return temp_knowledge_ind;
        }
        return temp_speed_ind;
    }

    protected void setTempStatInd(StatType st, int ind){
        switch (st){
            case SPEED:
                temp_speed_ind = ind;
                return;
            case MIGHT:
                temp_might_ind = ind;
                return;
            case SANITY:
                temp_sanity_ind = ind;
                return;
            case KNOWLEDGE:
                temp_knowledge_ind = ind;
                return;
        }
    }

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

    protected int getStatSliderInd(StatType st){
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


    protected View getStatView(StatType st, int ind){
        LinearLayout layout = getView().findViewById(R.id.speed_scale_frame);
        switch (st){
            case SPEED:
                layout = getView().findViewById(R.id.speed_scale_frame);
                break;
            case MIGHT:
                layout = getView().findViewById(R.id.might_scale_frame);
                break;
            case SANITY:
                layout = getView().findViewById(R.id.sanity_scale_frame);
                break;
            case KNOWLEDGE:
                layout = getView().findViewById(R.id.knowledge_scale_frame);
                break;
        }

        return layout.getChildAt(ind + 1);
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
    protected void highlightGeneric(View v, int highlightLevel, int index){
        if (index == -1){
            highlightSkullImg((ImageView) v, highlightLevel);
        } else {
            highlightSliderItem((TextView) v, highlightLevel);
        }
    }
    private void highlightSliderItem(TextView tv, int highlightLevel){
        switch (highlightLevel){
            case 0:
                tv.setBackgroundResource(0);
                tv.setTextColor(Color.parseColor("#1E1E1E"));
                break;
            case 1:
                character.getColor().setBgColorHighlight(tv, true);
                tv.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            default:
                character.getColor().setBgColorHighlight(tv, false);
                tv.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }
    private void highlightSkullImg(ImageView img, int highlightLevel){
        switch (highlightLevel){
            case 0:
                img.setBackgroundResource(0);
                img.setImageResource(R.drawable.skull);
                break;
            case 1:
                character.getColor().setBgColorHighlight(img, true);
                img.setImageResource(R.drawable.white_skull);
                break;
            default:
                character.getColor().setBgColorHighlight(img, false);
                img.setImageResource(R.drawable.white_skull);
        }
    }

    //Set OnClickHandler based on StatType
    public void setStatOCH(View v, StatType st){
        switch (st){
            case SPEED:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH(view, StatType.SPEED); }
                });
                return;
            case MIGHT:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH(view, StatType.MIGHT); }
                });
                return;
            case SANITY:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH(view, StatType.SANITY); }
                });
                return;
            case KNOWLEDGE:
                v.setOnClickListener(new View.OnClickListener() {
                    @Override public void onClick(View view) { sliderItemOCH(view, StatType.KNOWLEDGE); }
                });
                return;
        }
        v.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) { sliderItemOCH(view, StatType.SPEED); }
        });
    }

    //Slider Item On Click Handler
    public void sliderItemOCH(View v, StatType st){
        int new_temp_ind = ((ViewGroup) v.getParent()).indexOfChild(v) - 1;
        int old_temp_ind = getTempStatInd(st);
        int current_ind = getStatSliderInd(st);

        //Set new temp stat index
        setTempStatInd(st, new_temp_ind);

        //De-Select current slider item, if any
        if (old_temp_ind != current_ind){
            View old_view = getStatView(st, old_temp_ind);
            highlightGeneric(old_view, 0, old_temp_ind);
        }

        //Highlight newly selected slider item
        if (new_temp_ind != current_ind){
            highlightGeneric(v, 1, new_temp_ind);
        }

        ((GameActivity) getActivity()).setAdjustmentState(true);
    }

    private void initStatViews(StatType st){
        //Get relevant fields based on StatType
        TextView[] views = getStatSliderViews(st);
        LinearLayout layout = getStatLayout(st);
        int[] data = getStatSliderData(st);
        int ind = getStatSliderInd(st);
        setTempStatInd(st, ind);

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

            //Add view to layout
            layout.addView(tv);
        }

        //Set OnClickHandler for skull img
        View skull_img = layout.getChildAt(0);
        setStatOCH(skull_img, st);
    }
}