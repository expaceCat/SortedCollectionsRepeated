package com.expacecat.sortedcollection;

import java.util.ArrayList;
import java.util.List;

public class Sorted {


    public List<Integer> getSortingRepeated(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> sortedArray = new ArrayList<>();
        int[] result = getSortedArray(getSortedAscendingArray(getArray(firstList)),getSortedAscendingArray(getArray(secondList)));

        for (int j : result) {
            sortedArray.add(j);
        }
        return sortedArray;
    }

    private int[] getSortedArray(int[] first, int[] second) {
        int[] result = new int[first.length];
        int countOfResult = 0; // номер ячейки массива result
        int countOfJ = 0; // значение ячейки массива
        int memory = first[0];

        for (int i = 0; i < first.length; i++) {
            for (int j = countOfJ; j < second.length; j++) {
                if(first[i] == memory) { // если значение равно значению положенному в result;
                    if(first[i] == second[j]) { // если значения равны, то пропускаем эти позиции
                        countOfJ++; // увеличиваем минимальное значение j, чтобы уменьшать количество проходимых сравнений
                        break;
                    }
                }
                if(first[i] == second[j]) { // если значения массива равны
                    result[countOfResult] = first[i]; // то записываем результат массив result
                    countOfResult++; // увеличиваем
                    countOfJ++; // увеличиваем, поскольку следующая
                    memory = first[i]; //присваиваем memory последнее значение
                    break;
                }
                if(first[i] > second[j]) {
                    countOfJ++;
                } if (first[i] < second[j]) {
                    break;
                }
            }
        }
        return cellCountSort(result, countOfResult);
    }

    private int[] getSortedAscendingArray(int[] first) { //получаем сортированный массив, сортировка пузырьком.
        boolean swapped;
        int stepsCount = first.length - 1;
        do {
            swapped = false; //обьявляем каждый раз , если сортировки не произошло, цикл завершится
            for(int i = 0; i < stepsCount; i++ ) {
                if (first[i] > first[i+1]) {
                    int x = first[i];
                    first[i] = first[i+1];
                    first[i+1] = x;
                    swapped = true;
                }
            }
            stepsCount--;
        } while (swapped);

        return first;
    }

    private int[] cellCountSort(int[] i, int count) { // Приводим массив в нужный размер, удаляем все лишнее
        int[] result = new int[count];
        for (int k = 0; k < result.length; k++) {
            result[k] = i[k];
        }
        return result; //на выход получается массив c точным количеством ячеек
    }


    private int[] getArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
