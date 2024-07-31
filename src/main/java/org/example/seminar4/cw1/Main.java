package org.example.seminar4.cw1;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("~");
        if ("print".equals(input[0])) {
            Integer num = Integer.parseInt(input[1]);
            list.add(num, input[0]);
        } else {
            System.out.println(list.get(Integer.parseInt(input[1])));
        }

    }
}
