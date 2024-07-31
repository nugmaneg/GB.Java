package org.example.seminar6.cw1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] array = fillArray(1000, 24);
        double sortPercent = sortArray(array);
        System.out.println("sortPercent = " + sortPercent);
    }

    public static int[] fillArray(int size, int bound) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(bound) + 1;
        }
        return array;
    }

    public static double sortArray(int[] array) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : array) {
            uniqueSet.add(num);
        }
        return (double) uniqueSet.size() * 100 / array.length;
    }
}
