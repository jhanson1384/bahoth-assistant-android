package com.jhanson1384.bahothassistant;

public enum CharacterEnum {
    MISSY(0),
    ZOE(1),
    JENNY(2),
    HEATHER(3),
    ZOSTRA(4),
    VIVIAN(5),
    DARRIN(6),
    OX(7),
    BRANDON(8),
    PETER(9),
    RHINEHARDT(10),
    LONGFELLOW(11);

    //Used as a key to find specific character in array
    private final int index;

    CharacterEnum(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}
