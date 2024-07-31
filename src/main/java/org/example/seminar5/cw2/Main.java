package org.example.seminar5.cw2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("checkBrackets(\"a+(d*3)\") = " + checkBrackets("a+(d*3)"));
        System.out.println("checkBrackets(\"[6+(3*3)]\") = " + checkBrackets("[6+(3*3)]"));
        System.out.println("checkBrackets(\"{a}[+]{(d*3)}\") = " + checkBrackets("{a}[+]{(d*3)}"));
        System.out.println("checkBrackets(\"<{a}+{(d*3)}>\") = " + checkBrackets("<{a}+{(d*3)}>"));
        System.out.println("checkBrackets(\"<{a+]}{(d*3)}\") = " + checkBrackets("{a+]}{(d*3)}"));
    }

    //[a+(1*3) - ложь
    //Пример 3: [6+(3*3)] - истина
    //Пример 4: {a}[+]{(d*3)} - истина
    //Пример 5: <{a}+{(d*3)}> - истина
    //Пример 6: {a+]}{(d*3)}

    private static boolean checkBrackets(String string) {
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('{', 0);
        charMap.put('}', 0);
        charMap.put('(', 0);
        charMap.put(')', 0);
        charMap.put('[', 0);
        charMap.put(']', 0);
        charMap.put('<', 0);
        charMap.put('>', 0);

        for (int i = 0; i < string.length(); i++) {


            char c = string.charAt(i);
            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) + 1);
            }
        }
        if (    charMap.get('{') == charMap.get('}') &&
                charMap.get('[') == charMap.get(']') &&
                charMap.get('<') == charMap.get('>') &&
                charMap.get('(') == charMap.get(')')
        ) {
            return true;
        } else {
            return false;
        }
    }
}
