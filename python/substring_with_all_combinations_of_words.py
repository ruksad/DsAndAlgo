# https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
#  <p>
# You are given a string s and an array of strings words. All the strings of words are of the same length.
# <p>
# A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
# <p>
# For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings.
# "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
# Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
# <p>
# <p>
# Example 1:
# <p>
# Input: s = "barfoothefoobarman", words = ["foo","bar"]
# <p>
# Output: [0,9]
# <p>
# Explanation:
# <p>
# The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
# The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
# <p>
# Example 2:
# <p>
# Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
# <p>
# Output: []
# <p>
# Explanation:
# <p>
# There is no concatenated substring.
# <p>
# Example 3:
# Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
# <p>
# Output: [6,9,12]
# <p>
# Explanation:
# <p>
# The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
# The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
# The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].


def find_all_substring_combination_of_strings(string, words)->[]:
    string_length = len(string)
    array_size = len(words)
    word_length = len(words[0])
    word_to_freq = array_to_dict(words)
    substring_length = word_length * array_size
    i = k= 0
    indices=[None]*int(string_length/word_length)
    while i <= string_length-substring_length:
        temp = string[i: i + substring_length]

        j = 0
        temp_words = [0]* int(len(temp)/word_length)
        counter = 0
        while j < len(temp):
            temp_words[counter] = temp[j: j + word_length]
            counter += 1
            j += word_length

        word_to_freq2 = array_to_dict(temp_words)

        if compare_dict(word_to_freq,word_to_freq2):
            indices[k]=i
            k+=1
        i += 1
    return indices

def compare_dict(map1:dict, map2:dict)-> bool:
    return all( (map1.get(k)==v for k,v in map2.items()))
def array_to_dict(words) -> dict:
    dict = {}
    for element in words:
        if dict.get(element) is not None:
            dict[element] += 1
        else:
            dict[element] = 1
    return dict


if __name__ == "__main__":
    print(find_all_substring_combination_of_strings("barfoothefoobarman", ["foo", "bar"]))
