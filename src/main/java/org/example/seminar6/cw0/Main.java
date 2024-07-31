package org.example.seminar6.cw0;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 8, 2, 8, 5, 6, 4);

        Set<Integer> set1 = new HashSet<>(list);
        Set<Integer> set2 = new LinkedHashSet<>(list);
        Set<Integer> set3 = new TreeSet<>(list);

        System.out.println("Set1: " + set1);
        System.out.println("Set2: " + set2);
        System.out.println("Set3: " + set3);
    }
}
