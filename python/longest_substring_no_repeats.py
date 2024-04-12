# https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s and len(s)==0:
            return 0

        pos=[0]* 256;
        max= int(0)
        i=0

        for j in range(len(s)):
            if pos[ord(s[j])] !=0 and pos[ord(s[j])] > i:
                i= pos[ord(s[j])]

            pos[ord(s[j])]=j+1 # as oth char in ord will have 0 only so +1 in all the places
            if max< j-i:
                max=j-i

        return max+1



if __name__=="__main__":
    s= Solution()
    print(s.lengthOfLongestSubstring("abcabcbb"))