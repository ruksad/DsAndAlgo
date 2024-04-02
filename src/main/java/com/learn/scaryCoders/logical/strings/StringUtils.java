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
     * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".The testcases will be generated such that the answer is unique.
     */

    public static String minWindow(String s, String t) {
        int[] hash = new int[256];
        int[] curr = new int[256];

        if (s.isEmpty() && t.isEmpty()) return "";
        if (t.length() > s.length()) return "";
        int start = -1, end = -1, min = Integer.MAX_VALUE;
        for (int i = 0, l = t.length(); i < l; i++) {
            hash[t.charAt(i)]++;
        }

        for (int i = 0, l = t.length() - 1; i < l; i++) {
            curr[s.charAt(i)]++;
        }

        for (int i = 0, j = t.length() - 1, l = s.length(); j < l; ) {
            curr[s.charAt(j)]++;
            if (isMatch(curr,hash)) {
                if (j - i < min) {
                    min = j - i;
                    start = i;
                    end = j;
                }
                while (j > i) {
                    curr[s.charAt(i)]--;
                    i++;
                    if (isMatch(curr, hash)) {
                        if (j - i < min) {
                            min = j - i;
                            start = i;
                            end = j;
                        }
                    } else break;
                }
            }
            j++;
        }
        if (min == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, end + 1);
    }

    private static boolean isMatch(int[] curr, int[] hash) {
        for (int i = 0; i < 256; i++) {
            if (curr[i] < hash[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []s){
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("abcdkgfbcbb"));
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("bbab"));
        //System.out.println(lengthOfLongestSubstringWithNonRepOfChars("bbabc"));

        String s1 = minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s1);
    }
}
