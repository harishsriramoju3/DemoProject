package com.thrivexcorp.prepview.utils;

public class DataUtility {

    public static String generateNameFromDisplayName(String displayName){
        return displayName.toLowerCase().replace(" ","_");
    }
}
