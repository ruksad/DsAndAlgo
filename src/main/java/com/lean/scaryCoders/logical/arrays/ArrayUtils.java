package com.lean.scaryCoders.logical.arrays;

import java.io.IOError;
import java.lang.annotation.Target;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

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
        System.out.println("Time taken for execution in non bruteforce= "+(System.currentTimeMillis()-currentTime));
        return contains;
    }



    public static boolean checkIfArraysHasElementInCommon2(int [] arrayOne,int [] arrayTwo){
        if(Objects.isNull(arrayOne) || Objects.isNull(arrayTwo))
            return false;
        long timeStart= System.currentTimeMillis();
        Optional<Integer> integer = Arrays.stream(arrayOne).boxed().collect(Collectors.toList()).stream().filter(element -> Arrays.stream(arrayTwo).boxed().collect(Collectors.toList()).contains(element)).findFirst();

        System.out.println("Time taken for execution in javas build in stream= "+ (System.currentTimeMillis()-timeStart));
        return integer.isPresent();
    }

    public static void main(String s[]){
        int[] arrays1 = IntStream.range(1,1000).toArray();
        int[] arrays2= IntStream.range(1000,10000).toArray();
        System.out.println(checkIfArraysHasElementInCommon(arrays1,arrays2));
        System.out.println(checkIfArraysHasElementInCommon1(arrays1,arrays2));
        System.out.println(checkIfArraysHasElementInCommon2(arrays1,arrays2));
    }
}
