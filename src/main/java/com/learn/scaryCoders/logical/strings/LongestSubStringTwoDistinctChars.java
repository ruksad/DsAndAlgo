package com.learn.scaryCoders.logical.strings;

import java.util.HashMap;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 * <p>
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * <p>
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 */
public class LongestSubStringTwoDistinctChars {


    public String lengthOfLongestSubstringTwoDistinct1(String s) {
        int[] freq = new int[256];
        int cnt = 0, max = Integer.MIN_VALUE, leftPtr = 0;
        int start = 0, end = 0;
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            if (freq[s.charAt(rightPtr)]++ == 0) {
                cnt++;
            }

            while (cnt > 2) {
                if (freq[s.charAt(leftPtr++)]-- == 1)
                    cnt--;
            }

            if (rightPtr - leftPtr > max) {
                max = rightPtr - leftPtr;
                start = leftPtr;
                end = rightPtr;
            }
        }
        return s.substring(start, end + 1);

    }

    public static void main(String[] args) {
        LongestSubStringTwoDistinctChars lst = new LongestSubStringTwoDistinctChars();
        //System.out.println(lst.lengthOfLongestSubstringTwoDistinct1("ccaabbb"));

        System.out.println(lst.longestSubstringWithTwoDistinctChars("ccaaabbbbbbc"));
    }

    private String longestSubstringWithTwoDistinctChars(String ss) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int count = 0, max = Integer.MIN_VALUE, start = 0, end = 0, leftPtr = 0;
        for (int rightPtr = 0; rightPtr < ss.length(); rightPtr++) {

            Integer integer = hashMap.get(ss.charAt(rightPtr));
            if (integer==null || integer==0) {
                count++;
            }

            int i = (null == integer) ? 1 : integer+1;
            hashMap.put(ss.charAt(rightPtr), i);


            while (count > 2) {
                Integer integer1 = hashMap.get(ss.charAt(leftPtr));
                if (hashMap.containsKey(ss.charAt(leftPtr)) && integer1 == 1) {
                    count--;
                }
                // if(null!=integer1){
                integer1 -= 1;
                hashMap.put(ss.charAt(leftPtr), integer1);
                //}
                leftPtr++;
            }

            if (rightPtr - leftPtr > max) {
                max = rightPtr - leftPtr;
                start = leftPtr;
                end = rightPtr;
            }
        }
        return ss.substring(start, end + 1);
    }

}
