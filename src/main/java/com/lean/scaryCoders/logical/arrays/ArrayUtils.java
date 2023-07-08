package com.lean.scaryCoders.logical.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayUtils {

    /**
     * tim complexity is more, although no extra memory is consumed
     * space complexity
     * @param array1
     * @param array2
     * @return
     */
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

    /**
     * Space complexity is more as we are storing into map, although it's faster for lookup
     * space complexity is O(a) as new variable hm is used
     * @param array1
     * @param array2
     * @return
     */
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


    /**
     * Readability is more
     * @param arrayOne
     * @param arrayTwo
     * @return
     */
    public static boolean checkIfArraysHasElementInCommon2(int [] arrayOne,int [] arrayTwo){
        if(Objects.isNull(arrayOne) || Objects.isNull(arrayTwo))
            return false;
        long timeStart= System.currentTimeMillis();
        List<Integer> arraysTwoInList = Arrays.stream(arrayTwo).boxed().collect(Collectors.toList());
        List<Integer> arrayOneInList = Arrays.stream(arrayOne).boxed().collect(Collectors.toList());
        Optional<Integer> integer = arrayOneInList.stream().filter(arraysTwoInList::contains).findFirst();

        System.out.println("Time taken for execution in javas build in stream= "+ (System.currentTimeMillis()-timeStart));
        return integer.isPresent();
    }

    /**
     *
     * @param array
     * @param sum
     * @return
     */
    public static boolean hasPairWithSum(int[] array,int sum){
        long startTime= System.currentTimeMillis();
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]+array[j]==sum){
                    System.out.println("Time taken to find the first occurrence = "+(System.currentTimeMillis()-startTime));
                    return true;
                }

            }
        }
        System.out.println("Time taken by bruteforce in worst case is= "+(System.currentTimeMillis()-startTime));
        return false;
    }

    public static boolean hasPairWithSum1(int [] array, int sum){
        long startTime= System.currentTimeMillis();
        HashSet<Integer> hs= new HashSet<>();
        int i=0;
        while(i<array.length){
           if(hs.contains(array[i])){
               System.out.println("Best case found match in time= "+(System.currentTimeMillis()-startTime));
               return true;
           }else{
               hs.add(sum-array[i]);
           }
           i++;
        }
        System.out.println("Worst case not found sum pair in time= "+(System.currentTimeMillis()-startTime));
        return false;
    }

    /**
     * https://redquark.org/cotd/sliding_window/
     * @param a
     * @param k
     * @return [1,2,3,4,5,6,7,8]
     */
    public static int maximumSumOfKElements(int a[],int k){
        long currentTime= System.currentTimeMillis();
        if(k>a.length)
            return 0;
        int[] sumOfInts = new int[a.length-k+1];
        int slide=k;

        for(int i=0;i<a.length-k+1;i++){
            int sum=0;
            for(int j=i;j<slide;j++){
                sum+= a[j];
            }
            sumOfInts[i]=sum;
            slide++;
        }

        int max=0;
        for (int sumOfInt : sumOfInts) {
            max = Math.max(sumOfInt, max);
        }
        System.out.println("Time taken to find max= "+(System.currentTimeMillis()-currentTime));
        return max;
    }

    public static void main(String s[]){
        int[] arrays1 = IntStream.range(1,1000).toArray();
        int[] arrays2= IntStream.range(1000,10000).toArray();
        /*System.out.println(checkIfArraysHasElementInCommon(arrays1,arrays2));
        System.out.println(checkIfArraysHasElementInCommon1(arrays1,arrays2));
        System.out.println(checkIfArraysHasElementInCommon2(arrays1,arrays2));*/


        //System.out.println(hasPairWithSum(arrays1,100));
        //System.out.println(hasPairWithSum1(arrays1,100));

        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(maximumSumOfKElements(arrays2,3));
    }
}
