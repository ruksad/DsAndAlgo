package com.learn.scaryCoders.logical.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */


public class LongestSubstringWithoutRepeatingCharacter {

    private static int longestSubstring(String originalString){
        if (originalString == null || originalString.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, max = Integer.MIN_VALUE;
        for (int j = 0, lengthOfString = originalString.length(); j < lengthOfString; j++) {
            if (map.containsKey(originalString.charAt(j))) {
                i = Math.max(map.get(originalString.charAt(j)) + 1, i);
            }
            map.put(originalString.charAt(j), j);
            max = Math.max(max, (j - i) + 1);
        }
        return max;

    }

    public static void main(String[] args) {
        System.out.println("string= "+longestSubstringWithoutRepeatsUsingArray("abcdbcbb"));
    }

    public static String longestSubstring1(String ss){

        if(ss==null || ss.length()==0)
            return "";
        int leftPtr=0;
        int max= Integer.MIN_VALUE;
        int start=0, end=0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(int rightPtr=0;rightPtr<ss.length();rightPtr++){

            if(hashMap.containsKey(ss.charAt(rightPtr))){
                if(leftPtr< hashMap.get(ss.charAt(rightPtr))){
                    leftPtr=hashMap.get(ss.charAt(rightPtr));
                }
            }
            hashMap.put(ss.charAt(rightPtr),rightPtr);
            if(rightPtr-leftPtr > max){
                max= rightPtr-leftPtr;
                start=leftPtr;
                end=rightPtr;
            }
        }

        return ss.substring(start,end+1);
    }


    public static String longestSubstringWithoutRepeatsUsingArray(String ss){
        int [] pos= new int[256];

        int i=0,start=0,end=0,max=Integer.MIN_VALUE;

        for(int j=0;j<ss.length();j++){

            if(pos[ss.charAt(j)]!=0){
                if(i<pos[ss.charAt(j)]){
                    i=pos[ss.charAt(j)];
                }
            }

            pos[ss.charAt(j)]=j;
            if(j-i > max){
                max=j-i;
                start=i;
                end=j;
            }
        }
        return ss.substring(start,end+1);
    }
}
