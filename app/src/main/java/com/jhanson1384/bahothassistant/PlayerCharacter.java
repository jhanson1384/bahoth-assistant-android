package com.jhanson1384.bahothassistant;

import java.io.Serializable;

//If PlayerCharacter is serialized often, Parcelable should be implemented instead of Serializable
//Currently only passed once when DisplayCharacterFragment is created, so Serializable is OK
public class PlayerCharacter implements Serializable {
    //CONSTRUCTOR
    public PlayerCharacter(CharacterEnum character){
        this.character_type = character;
        switch(character){
            case MISSY:
                this.name = "Missy Dubourde";
                this.color = PlayerColor.YELLOW;
                this.speed_scale = new int[] {3,4,5,6,6,6,7,7};
                this.might_scale = new int[] {2,3,3,3,4,5,6,7};
                this.sanity_scale = new int[] {1,2,3,4,5,5,6,7};
                this.knowledge_scale = new int[] {2,3,4,4,5,6,6,6};
                this.speed_ind = 2;
                this.might_ind = 3;
                this.sanity_ind = 2;
                this.knowledge_ind = 3;
                this.age = 9;
                this.height_ft = 4;
                this.height_in = 2;
                this.weight = 62;
                this.hobbies = "Swimming, Medicine";
                this.birth_month = 2;
                this.birth_day = 14;
                this.brief_desc = "A creepy little girl, who wants to be a doctor. She cuts up dead things, for fun. Missy then has nightmares about them.";
                this.fears = "Dead things coming back to life to haunt her.";
                this.portrait_id = R.drawable.missy_circle_img;
                break;
            case ZOE:
                this.name = "Zoe Ingstrom";
                this.color = PlayerColor.YELLOW;
                this.speed_scale = new int[] {4,4,4,4,5,6,8,8};
                this.might_scale = new int[] {2,2,3,3,4,4,6,7};
                this.sanity_scale = new int[] {3,4,5,5,6,6,7,8};
                this.knowledge_scale = new int[] {1,2,3,4,4,5,5,5};
                this.speed_ind = 3;
                this.might_ind = 3;
                this.sanity_ind = 2;
                this.knowledge_ind = 2;
                this.age = 8;
                this.height_ft = 3;
                this.height_in = 9;
                this.weight = 49;
                this.hobbies = "Dolls, Music";
                this.birth_month = 11;
                this.birth_day = 5;
                this.brief_desc = "Zoe has an implied tragic story. Raised in an unhappy home, she uses dolls to express her emotions.";
                this.fears = "The Boogeyman.";
                this.portrait_id = R.drawable.zoe_circle_img;
                break;
            case JENNY:
                this.name = "Jenny LeClerc";
                this.color = PlayerColor.PURPLE;
                this.speed_scale = new int[] {2,3,4,4,4,5,6,8};
                this.might_scale = new int[] {3,4,4,4,4,5,6,8};
                this.sanity_scale = new int[] {1,1,2,4,4,4,5,6};
                this.knowledge_scale = new int[] {2,3,3,4,4,5,6,8};
                this.speed_ind = 3;
                this.might_ind = 2;
                this.sanity_ind = 4;
                this.knowledge_ind = 2;
                this.age = 21;
                this.height_ft = 5;
                this.height_in = 7;
                this.weight = 142;
                this.hobbies = "Reading, Soccer";
                this.birth_month = 3;
                this.birth_day = 4;
                this.brief_desc = "A quiet bookworm whose mother disappeared when she was younger. Jenny feels always alone.";
                this.fears = "Being trapped in a crowd or lost in the open air.";
                this.portrait_id = R.drawable.jenny_circle_img;
                break;
            case HEATHER:
                this.name = "Heather Granville";
                this.color = PlayerColor.PURPLE;
                this.speed_scale = new int[] {3,3,4,5,6,6,7,8};
                this.might_scale = new int[] {3,3,3,4,5,6,7,8};
                this.sanity_scale = new int[] {3,3,3,4,5,6,6,6};
                this.knowledge_scale = new int[] {2,3,3,4,5,6,7,8};
                this.speed_ind = 2;
                this.might_ind = 2;
                this.sanity_ind = 2;
                this.knowledge_ind = 4;
                this.age = 18;
                this.height_ft = 5;
                this.height_in = 2;
                this.weight = 120;
                this.hobbies = "Television, Shopping";
                this.birth_month = 8;
                this.birth_day = 2;
                this.brief_desc = "Seen as perfect in both her eyes and the eyes of others, when things aren’t perfect she suffers from headaches. She keeps smiling anyway.";
                this.fears = "Not being perfect.";
                this.portrait_id = R.drawable.heather_circle_img;
                break;
            case ZOSTRA:
                this.name = "Madame Zostra";
                this.color = PlayerColor.BLUE;
                this.speed_scale = new int[] {2,3,3,5,5,6,6,7};
                this.might_scale = new int[] {2,3,3,4,5,5,5,6};
                this.sanity_scale = new int[] {4,4,4,5,6,7,8,8};
                this.knowledge_scale = new int[] {1,3,4,4,4,5,6,6};
                this.speed_ind = 2;
                this.might_ind = 3;
                this.sanity_ind = 2;
                this.knowledge_ind = 3;
                this.age = 37;
                this.height_ft = 5;
                this.height_in = 0;
                this.weight = 150;
                this.hobbies = "Astrology, Cooking, Baseball";
                this.birth_month = 12;
                this.birth_day = 10;
                this.brief_desc = "Also known as Belladina, Madame Zostra is a tarot card reader and tea-leaf reader with her own stay-at-home astrology business.";
                this.fears = "Death, especially that of her self.";
                this.portrait_id = R.drawable.zostra_circle_img;
                break;
            case VIVIAN:
                this.name = "Vivian Lopez";
                this.color = PlayerColor.BLUE;
                this.speed_scale = new int[] {3,4,4,4,4,6,7,8};
                this.might_scale = new int[] {2,2,2,4,4,5,6,6};
                this.sanity_scale = new int[] {4,4,4,5,6,7,8,8};
                this.knowledge_scale = new int[] {4,5,5,5,5,6,6,7};
                this.speed_ind = 3;
                this.might_ind = 2;
                this.sanity_ind = 2;
                this.knowledge_ind = 3;
                this.age = 42;
                this.height_ft = 5;
                this.height_in = 5;
                this.weight = 142;
                this.hobbies = "Old Movies, Horses";
                this.birth_month = 1;
                this.birth_day = 11;
                this.brief_desc = "A small bookshop owner who, when finances become difficult, has thoughts of arson.";
                this.fears = "The same as one of her greatest loves – fire.";
                this.portrait_id = R.drawable.vivian_circle_img;
                break;
            case DARRIN:
                this.name = "Darrin \"Flash\" Williams";
                this.color = PlayerColor.RED;
                this.speed_scale = new int[] {4,4,4,5,6,7,7,8};
                this.might_scale = new int[] {2,3,3,4,5,6,6,7};
                this.sanity_scale = new int[] {1,2,3,4,5,5,5,7};
                this.knowledge_scale = new int[] {2,3,3,4,5,5,5,7};
                this.speed_ind = 4;
                this.might_ind = 2;
                this.sanity_ind = 2;
                this.knowledge_ind = 2;
                this.age = 20;
                this.height_ft = 5;
                this.height_in = 11;
                this.weight = 188;
                this.hobbies = "Track, Music, Shakespearean Literature";
                this.birth_month = 6;
                this.birth_day = 6;
                this.brief_desc = "Flash is a paranoid runner, who can’t help but shake the feeling that something is chasing him.";
                this.fears = "Getting caught by that which is chasing him.";
                this.portrait_id = R.drawable.flash_circle_img;
                break;
            case OX:
                this.name = "Ox Bellows";
                this.color = PlayerColor.RED;
                this.speed_scale = new int[] {2,2,2,3,4,5,5,6};
                this.might_scale = new int[] {4,5,5,6,6,7,8,8};
                this.sanity_scale = new int[] {2,2,3,4,5,5,6,7};
                this.knowledge_scale = new int[] {2,2,3,3,5,5,6,6};
                this.speed_ind = 4;
                this.might_ind = 2;
                this.sanity_ind = 2;
                this.knowledge_ind = 2;
                this.age = 20;
                this.height_ft = 6;
                this.height_in = 4;
                this.weight = 288;
                this.hobbies = "Football, Shiny Objects";
                this.birth_month = 10;
                this.birth_day = 18;
                this.brief_desc = "A big kid who once had to lash out. Ox is now haunted by his past and what he did that one time.";
                this.fears = "The dark.";
                this.portrait_id = R.drawable.ox_circle_img;
                break;
            case BRANDON:
                this.name = "Brandon Jaspers";
                this.color = PlayerColor.GREEN;
                this.speed_scale = new int[] {3,4,4,4,5,6,7,8};
                this.might_scale = new int[] {2,3,3,4,5,6,6,7};
                this.sanity_scale = new int[] {3,3,3,4,5,6,7,8};
                this.knowledge_scale = new int[] {1,3,3,5,5,6,6,7};
                this.speed_ind = 2;
                this.might_ind = 3;
                this.sanity_ind = 3;
                this.knowledge_ind = 2;
                this.age = 12;
                this.height_ft = 5;
                this.height_in = 1;
                this.weight = 109;
                this.hobbies = "Computers, Camping, Hockey";
                this.birth_month = 5;
                this.birth_day = 12;
                this.brief_desc = "A kid who never liked playing with traditional toys, Brandon could swear his old puppet was moving closer to him when he slept.";
                this.fears = "Puppets, especially those of the clown variety.";
                this.portrait_id = R.drawable.brandon_circle_img;
                break;
            case PETER:
                this.name = "Peter Akimoto";
                this.color = PlayerColor.GREEN;
                this.speed_scale = new int[] {3,3,3,4,6,6,7,7};
                this.might_scale = new int[] {2,3,3,4,5,5,6,8};
                this.sanity_scale = new int[] {3,4,4,4,5,6,6,7};
                this.knowledge_scale = new int[] {3,4,4,5,6,7,7,8};
                this.speed_ind = 3;
                this.might_ind = 2;
                this.sanity_ind = 3;
                this.knowledge_ind = 2;
                this.age = 13;
                this.height_ft = 4;
                this.height_in = 11;
                this.weight = 98;
                this.hobbies = "Bugs, Basketball";
                this.birth_month = 9;
                this.birth_day = 3;
                this.brief_desc = "Seriously bullied by his family, Peter liked to hide under his house and look at bugs. He wants to be an entomologist.";
                this.fears = "Getting caught somewhere he can’t get out.";
                this.portrait_id = R.drawable.peter_circle_img;
                break;
            case RHINEHARDT:
                this.name = "Father Rhinehardt";
                this.color = PlayerColor.WHITE;
                this.speed_scale = new int[] {2,3,3,4,5,6,7,7};
                this.might_scale = new int[] {1,2,2,4,4,5,5,7};
                this.sanity_scale = new int[] {3,4,5,5,6,7,7,8};
                this.knowledge_scale = new int[] {1,3,3,4,5,6,6,8};
                this.speed_ind = 2;
                this.might_ind = 2;
                this.sanity_ind = 4;
                this.knowledge_ind = 3;
                this.age = 62;
                this.height_ft = 5;
                this.height_in = 9;
                this.weight = 185;
                this.hobbies = "Fencing, Gardening";
                this.birth_month = 4;
                this.birth_day = 29;
                this.brief_desc = "A man who turned to religion to escape persecution, Father Rhinehardt is haunted by the mad whispers of the confessional booth.";
                this.fears = "Going mad.";
                this.portrait_id = R.drawable.rhinehardt_circle_img;
                break;
            case LONGFELLOW:
                this.name = "Professor Longfellow";
                this.color = PlayerColor.WHITE;
                this.speed_scale = new int[] {2,2,4,4,5,5,6,6};
                this.might_scale = new int[] {1,2,3,4,5,5,6,6};
                this.sanity_scale = new int[] {1,3,3,4,5,5,6,7};
                this.knowledge_scale = new int[] {4,5,5,5,5,6,7,8};
                this.speed_ind = 3;
                this.might_ind = 2;
                this.sanity_ind = 2;
                this.knowledge_ind = 4;
                this.age = 57;
                this.height_ft = 5;
                this.height_in = 11;
                this.weight = 153;
                this.hobbies = "Gaelic Music, Drama, Fine Wines";
                this.birth_month = 7;
                this.birth_day = 27;
                this.brief_desc = "An aristocrat by birth, Professor Longfellow now lives with his mother, broke and wondering about her life insurance policy.";
                this.fears = "Losing everything he has.";
                this.portrait_id = R.drawable.longfellow_circle_img;
                break;
        }
    }


    //Accessor methods
    public String getName() { return this.name; }
    public CharacterEnum getCharType() { return this.character_type; }
    public int getPortraitID() { return this.portrait_id; }
    public PlayerColor getColor() { return this.color; }
    public int getSpeedInd() { return this.speed_ind; }
    public int getMightInd() { return this.might_ind; }
    public int getSanityInd() { return this.sanity_ind; }
    public int getKnowledgeInd() { return this.knowledge_ind; }
    public int[] getSpeedScale() { return this.speed_scale; }
    public int[] getMightScale() { return this.might_scale; }
    public int[] getSanityScale() { return this.sanity_scale; }
    public int[] getKnowledgeScale() { return this.knowledge_scale; }

    public void setStatInd(StatType st, int ind){
        switch (st){
            case SPEED:
                speed_ind = ind;
                return;
            case MIGHT:
                might_ind = ind;
                return;
            case KNOWLEDGE:
                knowledge_ind = ind;
                return;
            case SANITY:
                sanity_ind = ind;
                return;
        }
    }

    //Redundant with other getters, which are now depreciated
    public int getStatInd(StatType st){
        switch (st){
            case SPEED:
                return speed_ind;
            case MIGHT:
                return might_ind;
            case KNOWLEDGE:
                return knowledge_ind;
            case SANITY:
                return sanity_ind;
        }
        return speed_ind;
    }

    //Determine speed by indexing into stats scale
    public int getSpeed() {
        //Index may be zero if character is dead
        if (speed_ind < 0) return 0;
        return speed_scale[speed_ind];
    }
    //Determine might by indexing into stats scale
    public int getMight() {
        //Index may be zero if character is dead
        if (might_ind < 0) return 0;
        return might_scale[might_ind];
    }
    //Determine sanity by indexing into stats scale
    public int getSanity() {
        //Index may be zero if character is dead
        if (sanity_ind < 0) return 0;
        return sanity_scale[sanity_ind];
    }
    //Determine knowledge by indexing into stats scale
    public int getKnowledge() {
        //Index may be zero if character is dead
        if (knowledge_ind < 0) return 0;
        return knowledge_scale[knowledge_ind];
    }

    //Returns formatted strings for displaying character info
    public String displayAge() { return "Age: " + Integer.toString(age); }
    public String displayHeight() {
        return "Height: " + Integer.toString(height_ft) + "' " + Integer.toString(height_in) + "\"";
    }
    public String displayWeight() { return "Weight: " + Integer.toString(weight) + " lbs"; }
    public String displayHobbies() { return "Hobbies: " + hobbies; }
    public String displayDescription() { return brief_desc; }
    public String displayFears() { return "Fears: " + fears; }
    public String displaySpeed(){
        return "Speed: " + Integer.toString(this.getSpeed());
    }
    public String displayMight(){
        return "Might: " + Integer.toString(this.getMight());
    }
    public String displaySanity(){
        return "Sanity: " + Integer.toString(this.getSanity());
    }
    public String displayKnowledge(){ return "Knowledge: " + Integer.toString(this.getKnowledge()); }
    public String displayBirthday() {
        String month_str;
        String day_str;

        switch (birth_month){
            case 1:
                month_str = "January";
                break;
            case 2:
                month_str = "February";
                break;
            case 3:
                month_str = "March";
                break;
            case 4:
                month_str = "April";
                break;
            case 5:
                month_str = "May";
                break;
            case 6:
                month_str = "June";
                break;
            case 7:
                month_str = "July";
                break;
            case 8:
                month_str = "August";
                break;
            case 9:
                month_str = "September";
                break;
            case 10:
                month_str = "October";
                break;
            case 11:
                month_str = "November";
                break;
            case 12:
                month_str = "December";
                break;
            default:
                month_str = "ERROR";
                break;
        }

        switch (birth_day){
            case 1:
                day_str = "1st";
                break;
            case 2:
                day_str = "2nd";
                break;
            case 3:
                day_str = "3rd";
                break;
            default:
                day_str = Integer.toString(birth_day) + "th";
                break;
        }

        return "Birthday: " + month_str + " " + day_str;
    }



    //DATA MEMBERS
    private String name;
    private CharacterEnum character_type;
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
    private String hobbies;
    //Character birthday (broken into month and day)
    private int birth_month;
    private int birth_day;
    //Brief character description
    private String brief_desc;
    //Character's fears
    private String fears;
    //ID for character picture
    private int portrait_id;
}
