package com.learn.scaryCoders.logical.strings;

import java.util.*;

public class StringUtils {

    /**
     * Sliding window protocol
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringWithNonRepOfChars(String s){
        if(Objects.isNull(s))
            return 0;

        int start=0,end=0,maxLength=0;
        Set set=new HashSet<Character>();

        while(end<s.length()){
            if(set.add(s.charAt(end))){
                end++;
                maxLength=Math.max(set.size(),maxLength);
            }else{
               set.remove(s.charAt(start));
               start++;
            }
        }
        return maxLength;
    }

    /**
     * Given two strings s and t of lengths m and n respectively,
     * return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
     * If there is no such substring, return the empty string "".The testcases will be generated such that the answer is unique.
     */

    public static String minWindow(String mainString, String subStringToFind) {
        int[] freqOfCharToBeFound = new int[256];
        int[] freqCalc = new int[256];

        if (mainString.isEmpty() && subStringToFind.isEmpty()) return "";
        if (subStringToFind.length() > mainString.length()) return "";

        int start = -1, end = -1, min = Integer.MAX_VALUE;

        for (int i = 0, l = subStringToFind.length(); i < l; i++) {
            freqOfCharToBeFound[subStringToFind.charAt(i)]++;
        }

        for (int i = 0, l = subStringToFind.length() - 1; i < l; i++) {
            freqCalc[mainString.charAt(i)]++;
        }

        for (int leftPtr = 0, rightPtr = subStringToFind.length() - 1, l = mainString.length(); rightPtr < l; ) {
            freqCalc[mainString.charAt(rightPtr)]++;
            if (isMatch(freqCalc,freqOfCharToBeFound)) {
                if (rightPtr - leftPtr < min) {
                    min = rightPtr - leftPtr;
                    start = leftPtr;
                    end = rightPtr;
                }
                while (rightPtr > leftPtr) {
                    freqCalc[mainString.charAt(leftPtr)]--;
                    leftPtr++;
                    if (isMatch(freqCalc, freqOfCharToBeFound)) {
                        if (rightPtr - leftPtr < min) {
                            min = rightPtr - leftPtr;
                            start = leftPtr;
                            end = rightPtr;
                        }
                    } else break;
                }
            }
            rightPtr++;
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return mainString.substring(start, end + 1);
    }

    private static boolean isMatch(int[] curr, int[] freqOfCharToBeFound) {
        for (int i = 0; i < 256; i++) {
            if (curr[i] < freqOfCharToBeFound[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []s){
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("abcdkgfbcbb"));
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("bbab"));
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("bbabc"));

        String s1 = minimumWindowSubstring1("ADOBECODEBANC", "EABC");
        System.out.println(s1);
    }





    public static String minimumWindowSubstring1(String toBeSearched, String toSearch){

        int toBeSearchedArr[]=new int[256];
        int toSearchArr[]=new int[256];

        int i=0;
        while(i<toSearch.length()){
            toSearchArr[toSearch.charAt(i)]++;
            i++;
        }

         i=0;
        while(i<toSearch.length()-1 && i< toBeSearched.length()){
            toBeSearchedArr[toBeSearched.charAt(i)]++;
            i++;
        }

        int  start=0, end=0, min= Integer.MAX_VALUE;
        for(int leftPtr=0,rightPtr=toSearch.length()-1;  rightPtr<toBeSearched.length();){

            // Expand the window
            toBeSearchedArr[toBeSearched.charAt(rightPtr)]++;

            if(isMatch1(toBeSearchedArr,toSearchArr)){

                if(rightPtr-leftPtr < min){
                    min= rightPtr-leftPtr;
                    start= leftPtr;
                    end= rightPtr;
                }

                while(leftPtr < rightPtr){

                    // shrink the window
                    toBeSearchedArr[toBeSearched.charAt(leftPtr)]--;
                    leftPtr ++;
                    if(isMatch1(toBeSearchedArr,toSearchArr)){
                        if(rightPtr-leftPtr < min){
                            min= rightPtr- leftPtr;
                            start= leftPtr;
                            end= rightPtr;
                        }
                    }else break;


                }
            }

            rightPtr++;
        }

        if (min==Integer.MAX_VALUE)
            return " ";


        return toBeSearched.substring(start,end+1);


    }

    private static boolean isMatch1(int [] toBeSearched, int [] toSearch){
        for(int i=0;i<256;i++){
            if(toBeSearched[i] < toSearch[i])
                return false;
        }
        return true;
    }
}
