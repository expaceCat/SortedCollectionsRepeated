package com.expacecat.sortedcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortedCollection {
    public static void main(String[] args) {
        Sorted sorted = new Sorted();
        List<Integer> firstList = new ArrayList(Arrays.asList(3, 8, 76544, 231, -42 ,6, 5, 5,5,5,5, 100, 1, 3, 3));
        List<Integer> secondList = new ArrayList(Arrays.asList(6, 4, 6, 8, 6,231, 232, 1,5,5, 100,5, -100, 3, 6, 2, 12, 64));

        System.out.println(sorted.getSortingRepeated(firstList, secondList));

    }
}
