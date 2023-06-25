package com.lean.scaryCoders.logical.strings;

import java.util.*;

public class StringUtils {

    /**
     * Sliding window protocol
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
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
    public static void main(String []s){
        System.out.println(lengthOfLongestSubstring("abcdkgfbcbb"));
        System.out.println(lengthOfLongestSubstring("bbab"));
        System.out.println(lengthOfLongestSubstring("bbabc"));
    }
}
