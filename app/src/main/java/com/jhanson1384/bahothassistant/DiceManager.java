package com.jhanson1384.bahothassistant;

public class DiceManager {
    private int[] dice;
    private int n_dice;

    public int getNDice(){ return n_dice; }
    public int getDieVal(int ind){ return dice[ind]; }

    public void adjustNDice(int diff){
        n_dice += diff;
        if (n_dice > 8) n_dice = 8;
        if (n_dice < 1) n_dice = 1;
    }

    public DiceManager(int n_dice){
        dice = new int[8];
        for (int i=0; i<dice.length; i++){ dice[i] = 0; }

        this.n_dice = n_dice;
    }

    //Randomize dice (with values 0-2)
    public void roll(){
        for (int i=0; i<dice.length; ++i){
            reroll(i);
        }
    }

    public void reroll(int ind){
        dice[ind] = (int) (Math.random() * 3);
    }

    //Add up dice values
    public int sum(){
        int sum = 0;
        for (int i=0; i<n_dice; ++i){
            sum += dice[i];
        }
        return sum;
    }
}
