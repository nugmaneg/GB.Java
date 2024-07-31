package org.example.seminar5.cw3;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        String rimData = "MMXXII";

        Map<Character, Integer> data = new HashMap<>();
        data.put('I', 1);
        data.put('V', 5);
        data.put('X', 10);
        data.put('L', 50);
        data.put('C', 100);
        data.put('D', 500);
        data.put('M', 1000);


        Integer arabData = data.get(rimData.charAt(rimData.length() - 1));


        for (int i = 0; i < rimData.length() - 1; i++) {
            if (data.get(rimData.charAt(i)) > data.get(rimData.charAt(i + 1))) {
                arabData += data.get(rimData.charAt(i));
            }
            else {
                arabData -= data.get(rimData.charAt(i));
            }

        }
        System.out.println(arabData);
    }
}
