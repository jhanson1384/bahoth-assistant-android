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

        CharacterOverviewViewHolder(View v){
            super(v);
            character_name = (TextView) v.findViewById(R.id.character_overview_name);
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
    }

    @Override
    public int getItemCount() {
        return available_characters.size();
    }
}
