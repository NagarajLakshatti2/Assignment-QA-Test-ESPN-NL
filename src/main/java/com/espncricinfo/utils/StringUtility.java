package com.espncricinfo.utils;

public class StringUtility {

    public String removeSpecialChar(String word) {
        return word.replace('"', ' ');
    }
}
