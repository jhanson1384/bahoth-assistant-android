package com.jhanson1384.bahothassistant;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChooseCharacterAdapter
        extends RecyclerView.Adapter<ChooseCharacterAdapter.CharacterOverviewViewHolder>{

    private ArrayList<PlayerCharacter> available_characters;
    private ItemClickListener ic_listener;

    public interface ItemClickListener {
        void onItemClick(int position);
    }

    public void setItemClickListener(ItemClickListener listener){
        ic_listener = listener;
    }

    public static class CharacterOverviewViewHolder extends RecyclerView.ViewHolder {
        public TextView character_name;
        public TextView speed;
        public TextView might;
        public TextView sanity;
        public TextView knowledge;
        public ImageView portrait;

        CharacterOverviewViewHolder(View v, final ItemClickListener listener){
            super(v);
            character_name = (TextView) v.findViewById(R.id.character_overview_name);
            speed = (TextView) v.findViewById(R.id.character_overview_speed);
            might = (TextView) v.findViewById(R.id.character_overview_might);
            sanity = (TextView) v.findViewById(R.id.character_overview_sanity);
            knowledge = (TextView) v.findViewById(R.id.character_overview_knowledge);
            portrait = (ImageView) v.findViewById(R.id.character_overview_portrait);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
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

        CharacterOverviewViewHolder vh = new CharacterOverviewViewHolder(v, ic_listener);
        return vh;
    }

    @Override
    public void onBindViewHolder(CharacterOverviewViewHolder holder, int index){
        PlayerCharacter pc = available_characters.get(index);

        holder.character_name.setText(pc.getName());
        holder.speed.setText(pc.displaySpeed());
        holder.might.setText(pc.displayMight());
        holder.sanity.setText(pc.displaySanity());
        holder.knowledge.setText(pc.displayKnowledge());
        holder.portrait.setImageResource(pc.getPortraitID());
        pc.getColor().setBgColor(holder.portrait.getRootView().getRootView());
    }

    @Override
    public int getItemCount() {
        return available_characters.size();
    }
}
