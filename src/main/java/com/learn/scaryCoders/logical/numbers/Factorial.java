package com.learn.scaryCoders.logical.numbers;

import java.util.HashMap;

public class Factorial {
    public static int factorialRecursive(int number){
        if(number<2)
            return 1;
        return number * factorialRecursive(number-1);
    }
    public static String checkIfAllCharsInStringAreUnique(String inputValue){
        HashMap<Character, Integer> map = new HashMap<>();
        //map.com

        return null;

    }

    public static void main(String [] o){
       // System.out.println(factorialRecursive(5));
        int x=3,y=5,z=10;
        System.out.println(++z+y-y+z+x++);
    }
}
