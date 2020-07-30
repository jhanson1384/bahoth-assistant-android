package com.jhanson1384.bahothassistant;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseCharacterAdapter
        extends RecyclerView.Adapter<ChooseCharacterAdapter.CharacterOverviewViewHolder>{

    private ArrayList<PlayerCharacter> available_characters;

    public static class CharacterOverviewViewHolder extends RecyclerView.ViewHolder {
        public TextView character_name;
        public TextView speed;
        public TextView might;
        public TextView sanity;
        public TextView knowledge;

        CharacterOverviewViewHolder(View v){
            super(v);
            character_name = (TextView) v.findViewById(R.id.character_overview_name);
            speed = (TextView) v.findViewById(R.id.character_overview_speed);
            might = (TextView) v.findViewById(R.id.character_overview_might);
            sanity = (TextView) v.findViewById(R.id.character_overview_sanity);
            knowledge = (TextView) v.findViewById(R.id.character_overview_knowledge);
        }
    }

    public ChooseCharacterAdapter(ArrayList<PlayerCharacter> available){
        this.available_characters = available;
    }

    @Override
    public ChooseCharacterAdapter.CharacterOverviewViewHolder onCreateViewHolder(ViewGroup parent,
                                                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.character_overview_item, parent, false);

        CharacterOverviewViewHolder vh = new CharacterOverviewViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CharacterOverviewViewHolder holder, int index){
        holder.character_name.setText(available_characters.get(index).getName());
        holder.speed.setText(Integer.toString(available_characters.get(index).getSpeed()));
        holder.might.setText(Integer.toString(available_characters.get(index).getMight()));
        holder.sanity.setText(Integer.toString(available_characters.get(index).getSanity()));
        holder.knowledge.setText(Integer.toString(available_characters.get(index).getKnowledge()));
    }

    @Override
    public int getItemCount() {
        return available_characters.size();
    }
}
