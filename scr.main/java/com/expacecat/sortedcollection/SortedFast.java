package com.expacecat.sortedcollection;

import java.util.*;

public class SortedFast {

    public List<Integer> getSortedSet(List<Integer> firstList, List<Integer> secondList){
        Date date = new Date();
        TreeSet<Integer> firstSet = new TreeSet<>(firstList);
        TreeSet<Integer> secondSet = new TreeSet<>(secondList);
        firstSet.removeIf(secondSet::add);
        return new ArrayList<>(firstSet);
    }

    public List<Integer> getRandomList() {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 1000; i ++) {
            int rand = (int) (Math.random()*10) + 9;
           result.add(rand);
        }
        return result;
    }


}
