package org.example.seminar5.cw1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("areIsomorphic(\"adg\", \"egg\") = " + areIsomorphic("paser", "title")); // true

    }

    private static boolean areIsomorphic(String string1, String string2) {
        if (string1.length() != string2.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < string1.length(); i++) {
            char c1 = string1.charAt(i);
            char c2 = string2.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (!map.containsValue(c2)) {
                    map.put(c1, c2);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}