package org.example.seminar4.cw3;

import java.util.ArrayDeque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String[] arr = {"Apple", "Banana", "Cherry"};
        Stack<String> stack = new Stack<>();

        for (String fruit : arr) {
            stack.push(fruit);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("----------");

        ArrayDeque<String> stack2 = new ArrayDeque<>();
        for (String fruit : arr) {
            stack2.offer(fruit);
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
