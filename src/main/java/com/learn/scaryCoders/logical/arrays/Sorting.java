package com.learn.scaryCoders.logical.arrays;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {23, 20, 19, 10, 2, 2, -1, -5, -100};

        long startTime = System.currentTimeMillis();
        int[] ints = selectionSort(array);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken by sorting="+(endTime-startTime)+" Sorted array="+Arrays.toString(ints));

    }


    //Comparing the adjacent element
    public static int[] bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // Placing the smallest element at start
    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int pos = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[pos] > array[j]) {  // check if first element is bigger than then next in the arrya
                    pos = j;
                }
            }

            // when you found the smallest then place it at the front
            int temp = array[pos];
            array[pos] = array[i];
            array[i] = temp;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }


}
