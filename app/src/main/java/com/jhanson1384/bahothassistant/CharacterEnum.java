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

    public static CharacterEnum decodeIndex(int ind){
        switch(ind){
            case 0:
                return MISSY;
            case 1:
                return ZOE;
            case 2:
                return JENNY;
            case 3:
                return HEATHER;
            case 4:
                return ZOSTRA;
            case 5:
                return VIVIAN;
            case 6:
                return DARRIN;
            case 7:
                return OX;
            case 8:
                return BRANDON;
            case 9:
                return PETER;
            case 10:
                return RHINEHARDT;
            case 11:
                return LONGFELLOW;
        }
        return MISSY;
    }
}
