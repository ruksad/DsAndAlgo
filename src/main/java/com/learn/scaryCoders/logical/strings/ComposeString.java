package com.learn.scaryCoders.logical.strings;

import java.util.Arrays;

public class ComposeString {

    public static int composeString(int n,int q,String s,int []l,int []r){
        int result=-404;
        if(l.length!=r.length || q>l.length)
            return result;

        String[] subString =new String[l.length];

        for(int i=0;i<l.length;i++){
            subString[i]= s.substring(0, l[i]);
        }

        Arrays.sort(subString);
        int end=Math.min(subString[0].length(),subString[subString.length-1].length());

        int i=0;
        while(i<end && subString[0].charAt(i)==subString[subString.length-1].charAt(i))
            i++;

        return subString[0].substring(0,i).length();
    }

    public static void main(String[] args) {

        String testString="This is test string thi this is how you learn th";
        int [] l={1,2,10,1};
        int[] r = {10,8,20,48};
        System.out.println(composeString(testString.length(),4,testString,l,r));
    }
}
