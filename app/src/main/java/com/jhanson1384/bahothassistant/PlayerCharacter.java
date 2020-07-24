package com.jhanson1384.bahothassistant;

public class PlayerCharacter {
    //DATA MEMBERS
    private String name;
    //Player color, no two players can choose a character with the same color
    private PlayerColor color;
    //Sliding scales for each of the four character stats
    private int[] speed_scale;
    private int[] might_scale;
    private int[] sanity_scale;
    private int[] knowledge_scale;
    //Index used to determine character's current stat values, based on the scale for each stat
    private int speed_ind;
    private int might_ind;
    private int sanity_ind;
    private int knowledge_ind;
    //Character age (in years)
    private int age;
    //Character height (broken into feet and inches)
    private int height_ft;
    private int height_in;
    //Character weight (in pounds)
    private int weight;
    //List of character hobbies
    private String[] hobbies;
    //Character birthday (broken into month and day)
    private int birth_month;
    private int birth_day;
    //Brief character description
    private String brief_desc;
    //Character's fears
    private String fears;
}
