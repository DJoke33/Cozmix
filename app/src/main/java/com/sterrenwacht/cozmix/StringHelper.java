package com.sterrenwacht.cozmix;

public class StringHelper {

    static public String capitalise(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        else if (s.substring(0, 1).toLowerCase().equals("i") && s.substring(1, 2).toLowerCase().equals("j")) {
            return s.substring(0, 2).toUpperCase() + s.substring(2);
        }
        else {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }
}