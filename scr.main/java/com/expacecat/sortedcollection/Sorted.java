package com.expacecat.sortedcollection;

import java.util.ArrayList;
import java.util.List;

public class Sorted {


    public List<Integer> getSortingFinishList(List<Integer> firstList, List<Integer> secondList) {
       List<Integer> sortedArray = new ArrayList<>();
       int[] result = getSortedArray(getSortedAscendingArray(getArray(firstList)),getSortedAscendingArray(getArray(secondList)));

       for (int j : result) {
            sortedArray.add(j);
       }
        return sortedArray;
    }

    public int[] getSortedArray(int[] firstArray, int[] secondArray) {

        int[] result = new int[firstArray.length];
        int indexOfResult = 0; // номер ячейки массива result
        int indexOfJ = 0; // значение ячейки массива
        int memory = firstArray[0];

        for (int value : firstArray) {
            for (int j = indexOfJ; j < secondArray.length; j++) {
                if (value == memory) { // если значение равно значению положенному в result;
                    if (value == secondArray[j]) { // если значения равны, то пропускаем эти позиции
                        indexOfJ++; // увеличиваем минимальное значение j, чтобы уменьшать количество проходимых сравнений
                        break;
                    }
                }
                if (value == secondArray[j]) { // если значения массива равны
                    result[indexOfResult] = value; // то записываем результат массив result
                    indexOfResult++; // увеличиваем
                    indexOfJ++; // увеличиваем
                    memory = value; //присваиваем memory последнее значение
                    break;
                }
                if (value > secondArray[j]) {
                    indexOfJ++;
                }
                if (value < secondArray[j]) {
                    break;
                }
            }
        }
        return cellCountSort(result, indexOfResult);
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
        System.arraycopy(i, 0, result, 0, result.length);
        return result; //на выход получается массив c точным количеством ячеек
    }


    public int[] getArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for(int i = 0; i < array.length; i ++) {
            array[i] = list.get(i);
        }
        return array;
    }

}
