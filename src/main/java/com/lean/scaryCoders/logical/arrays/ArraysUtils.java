package com.lean.scaryCoders.logical.arrays;

import java.util.HashSet;
import java.util.stream.IntStream;

public class ArraysUtils {

    public static boolean checkIfArraysHasElementInCommon(int [] array1,int[] array2){
        long millis=System.currentTimeMillis();
        for (int k : array1) {
            for (int i : array2) {
                if (k == i){
                    System.out.println("Time taken for execution int bruteforce= "+(System.currentTimeMillis()-millis));
                    return true;
                }
            }
        }
        System.out.println("Time taken for execution int bruteforce= "+(System.currentTimeMillis()-millis));
        return false;
    }
    public static boolean checkIfArraysHasElementInCommon1(int[] array1, int [] array2){
        long currentTime= System.currentTimeMillis();
        boolean contains=false;
        HashSet<Integer> hs= new HashSet<>();
        for(int i:array1){
            hs.add(i);
        }
        for(int i: array2){
            if (hs.contains(i)) {
                System.out.println("Time take for execution in non bruteforce= "+(System.currentTimeMillis()-currentTime));
                contains = true;
                break;
            }
        }
        System.out.println("Time taken for execution in bruteforce= "+(System.currentTimeMillis()-currentTime));
        return contains;
    }

    public static void main(String s[]){
        int[] arrays1 = IntStream.range(1,1000).toArray();
        int[] arrays2= IntStream.range(1000,10000).toArray();
        System.out.println(checkIfArraysHasElementInCommon(arrays1,arrays2));
        System.out.println(checkIfArraysHasElementInCommon1(arrays1,arrays2));

    }
}
