package org.example.seminar5.cw3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите римское число: ");
        Scanner scanner = new Scanner(System.in);
        String romanNum = scanner.nextLine();
        //String romanNum = "III";
        System.out.println("Римское число " + romanNum + " будет являться арабским числом "+ calculateRimNumbers(romanNum));
    }

    private static int calculateRimNumbers(String romanNum) {
        Map<Character, Integer> mapRomanNum = new HashMap<>();
        mapRomanNum.put('I', 1);
        mapRomanNum.put('V', 5);
        mapRomanNum.put('X', 10);
        mapRomanNum.put('L', 50);
        mapRomanNum.put('C', 100);
        mapRomanNum.put('D', 500);
        mapRomanNum.put('M', 1000);
        int sum = 0;

        Stack<Integer> stack = new Stack<>();

        for (char c : romanNum.toCharArray()) {
            if (mapRomanNum.containsKey(c)) {
                if (stack.isEmpty() || mapRomanNum.get(c) <= stack.getLast()) {
                    stack.push(mapRomanNum.get(c));
                    //System.out.println("stack = " + stack);
                } else {
                    int index = 0;
                    while (stack.getLast() < mapRomanNum.get(c)) {
                        index -= stack.pop();
                    }
                    stack.push(index);
                    stack.push(mapRomanNum.get(c));
                    //System.out.println("stack = " + stack);
                }
            }
            else {return -1;}
        }
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
