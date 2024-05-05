##
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
# Given a string s, return the length of the longest substring that contains at most two distinct characters.
# <p>
# Input: s = "eceba"
# Output: 3
# Explanation: The substring is "ece" which its length is 3.
# <p>
# Input: s = "ccaabbb"
# Output: 5
# Explanation: The substring is "aabbb" which its length is 5.
# /
# import sys

def longest_substring_with_k_distinct_chars(string:str,char_nos:int) -> str:
    freq_of_chars= [0] * 256
    left_ptr=right_ptr=unique_char_count=start_string= end_string= 0
    max_long_string=-1

    while right_ptr < len(string):
        char_freq= freq_of_chars[ord(string[right_ptr])]

        if char_freq==0:
            unique_char_count+=1

        freq_of_chars[ord(string[right_ptr])]+=1

        while unique_char_count >char_nos:
            freq= freq_of_chars[ord(string[left_ptr])]

            if freq==1:
                unique_char_count-=1

            freq_of_chars[ord(string[left_ptr])]-=1
            left_ptr+=1

        if right_ptr-left_ptr > max_long_string :
            max_long_string=right_ptr-left_ptr
            start_string=left_ptr
            end_string=right_ptr

        right_ptr+=1

    return string[start_string : end_string+1]



def longestSubstring(ss):
    freq = [0] * 256
    leftPtr = 0
    rightPtr = 0
    start = 0
    end = 0
    count = 0
    max = -1

    while rightPtr < len(ss):
        rfreq= freq[ord(ss[rightPtr])]
        if rfreq == 0:
            count += 1

        freq[ord(ss[rightPtr])] = rfreq+1

        while count > 2:
            lfreq= freq[ord(ss[leftPtr])]
            if lfreq == 1:
                count -= 1

            freq[ord(ss[leftPtr])] = lfreq-1
            leftPtr += 1

        if rightPtr - leftPtr > max:
            max = rightPtr - leftPtr
            start = leftPtr
            end = rightPtr

        rightPtr += 1

    return ss[start: end + 1]


if __name__ == "__main__":
    print(longestSubstring("ccaaaebbbbbbeeec"))
    print(longest_substring_with_k_distinct_chars("ccaaaebbbbbbeeec",3))
