package com.expacecat.sortedcollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SortedCollection {
    public static void main(String[] args) {
        Sorted sorted = new Sorted();
        SortedMerge sm = new SortedMerge();
        SortedFast sortedFast = new SortedFast();
        List<Integer> first = new ArrayList(Arrays.asList(3, 8, 76544, 231, -42 ,6, 5, 100, 1, 3, 3));
        List<Integer> second = new ArrayList(Arrays.asList(6, 4, 6, 8, 6,231, 232, 1,5,5, 100,5, -100, 3, 6, 2, 12, 64));

        long m = System.currentTimeMillis();

        int[] sortedFirstArr = sm.sortArray(sorted.getArray(first));
        int[] sortedSecondArr = sm.sortArray(sorted.getArray(second));
        int[] finishResult = sorted.getSortedArray(sortedFirstArr, sortedSecondArr);
        for (int inter  : finishResult) {
            System.out.print(inter + " ");
        }
        System.out.println();
        System.out.printf("Программа сортировки массивами слиянием отработала за: %d мс%n", System.currentTimeMillis() - m);
        System.out.println();

        long z = System.currentTimeMillis();
        System.out.println(sorted.getSortingFinishList(first, second));
        System.out.printf("Программа сортировки массивами с пузырьком отработала за: %d мс%n", System.currentTimeMillis() - z);
        System.out.println();

        long n = System.currentTimeMillis();
        System.out.println(sortedFast.getSortedSet(first, second));
        System.out.printf("Программа сортировки коллекцией отработала за: %d мс%n", System.currentTimeMillis() - n);

    }
}
