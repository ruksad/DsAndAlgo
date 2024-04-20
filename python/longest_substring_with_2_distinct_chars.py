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
    print(longestSubstring("ccaaabbbbbbc"))
