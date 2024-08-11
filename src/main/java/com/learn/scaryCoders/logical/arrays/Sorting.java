package com.learn.scaryCoders.logical.arrays;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] array = {23, 20, 19, 10, 2, 2, -1, -5, -100};
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 10, 12, -3};
        long startTime = System.currentTimeMillis();
        int[] ints = insertionSort(array);
        long endTime = System.currentTimeMillis();

        long startTime1 = System.currentTimeMillis();
        int[] ints1 = mergeSort(array1, 0, array1.length);
        long endTime1 = System.currentTimeMillis();
        System.out.println("Time taken by sorting=" + (endTime1 - startTime1) + " Sorted array=" + Arrays.toString(ints1));

    }


    //Comparing the adjacent element

    /**
     * In Bubble Sort algorithm     *
     * traverse from left and compare adjacent elements and the higher one is placed at right side.
     * In this way, the largest element is moved to the rightmost end at first.
     * This process is then continued to find the second largest and place it and so on until the data is sorted.
     *
     * @param array
     * @return
     */
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

    /**
     * Selection sort is a simple and efficient sorting algorithm that works by repeatedly
     * selecting the smallest (or largest) element from the unsorted portion of the list and moving
     * it to the sorted portion of the list.
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int pos = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[pos]) {  // check if first element is bigger than then next in the arrya
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


    /**
     * Insertion sort is a simple sorting algorithm that works by iteratively inserting each element of an unsorted list into its correct position
     * in a sorted portion of the list.
     * It is a stable sorting algorithm, meaning that elements with equal values maintain their relative order in the sorted output.
     * https://www.geeksforgeeks.org/insertion-sort-algorithm/
     *
     * @param array {23, 20, 19, 10, 2, 2, -1, -5, -100};
     * @return
     */
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];

            int j = i - 1;
            for (; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                }
            }
            array[j + 1] = temp;
        }
        return array;
    }

    public static int[] mergeSort(int a[], int lower, int upper) {
        if (lower < upper) {
            int middle = lower + (upper - lower) / 2;
            merge(a, lower, middle);
            merge(a, middle + 1, upper);
        }
        return a;
    }

    public static int[] merge(int a[], int lower, int upper) {

    }
}
