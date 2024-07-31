package org.example.seminar4.cw2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вводите текст, а я его запомню!");
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String text = scanner.nextLine();
            if ("revert".equals(text)) {
                if (list.isEmpty()) {
                    System.out.println("Список пуст!");
                } else {
                    list.removeFirst();
                }

            } else if ("stop".equals(text)) {
                break;
            } else {
                list.addFirst(text);
            }

            System.out.println(list);
        }
    }
}
