package com.learn.scaryCoders.logical.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 * <p>
 * You are given a string s and an array of strings words. All the strings of words are of the same length.
 * <p>
 * A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
 * <p>
 * For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
 * "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
 * Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * <p>
 * Output: [0,9]
 * <p>
 * Explanation:
 * <p>
 * The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
 * The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * <p>
 * Output: []
 * <p>
 * Explanation:
 * <p>
 * There is no concatenated substring.
 * <p>
 * Example 3:
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * <p>
 * Output: [6,9,12]
 * <p>
 * Explanation:
 * <p>
 * The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
 * The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
 * The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
 */
public class SubstringWithAllCombinationOfAllWords {

    public static List findAllSubstringIndexes(String s, String[] words) {

        int aWordLen = words[0].length();
        int noOfWords = words.length;
        int wordsLength = aWordLen * noOfWords;

        if (wordsLength > s.length())
            return Collections.EMPTY_LIST;

        Map<String, Integer> map1 = collectMapOfWordsFromArray(words);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= s.length() - wordsLength; i+=1) {
            String temp = s.substring(i,i+wordsLength);
            int counter = 0;
            String sWords[] = new String[temp.length()/aWordLen];

            for (int j = 0; j < temp.length(); j += aWordLen ) {
                sWords[counter++] = temp.substring(j, j+aWordLen);
            }
            Map<String, Integer> map2 = collectMapOfWordsFromArray(sWords);
            if (compareTwoMaps(map2, map1))
                list.add(i);
        }
        return list;
    }

    public static Map<String, Integer> collectMapOfWordsFromArray(String s[]) {
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : s) {
            wordsMap.putIfAbsent(word, 0);
            wordsMap.put(word, wordsMap.get(word) + 1);
        }
        return wordsMap;
    }

    public static boolean compareTwoMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        if (map1.size() != map2.size())
            return false;
        return  map1.entrySet().stream().allMatch(x->x.getValue().equals(map2.get(x.getKey())));
    }

    public static void main(String[] args) {
        //System.out.println(findAllSubstringIndexes("barfoothefoobarman", new String[]{"foo", "bar"}));
        //System.out.println(findAllSubstringIndexes("foobar", new String[]{"foo", "bar"}));

        //System.out.println(findAllSubstringIndexes("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
        System.out.println(findAllSubstringIndexes("barfoothefoobarman", new String[]{"foo","bar"}));
        System.out.println(findAllSubstringIndexes("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }
}
