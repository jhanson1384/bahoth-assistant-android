package com.jhanson1384.bahothassistant;

public class BahothGame {
    //Number of omen cards drawn this game. Determines how many dice are used in haunt roll.
    private int n_omens;
    private PlayerCharacter character;

    //Accessor methods
    public PlayerCharacter getPC(){ return character; }

    public BahothGame(CharacterEnum char_type){
        this.character = new PlayerCharacter(char_type);
        this.n_omens = 0;
    }
}