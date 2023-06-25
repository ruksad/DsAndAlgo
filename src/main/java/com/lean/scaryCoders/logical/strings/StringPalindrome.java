package com.lean.scaryCoders.logical.strings;

public class StringPalindrome {

    public static boolean isStringPalindrome1(String string){

        for(int i=0,j=string.length()-1;i<j;i++,j--){
            if(string.charAt(i)!=string.charAt(j))
                return false;
        }
        return true;
    }
    public static boolean isStringPalindrome2(String string){
        char[] chars=string.toCharArray();
        for(int i=0,j=chars.length-1;i<j;i++,j--){
            if(chars[i]!=chars[j])
                return false;
        }
        return true;
    }
    public static void main(String [] s){
        System.out.println(isStringPalindrome1("aba"));
        System.out.println(isStringPalindrome2("Ruksad"));
    }
}
