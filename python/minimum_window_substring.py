def minimum_window_substring(stringTobeSearched, stringToSearch):

    if not stringTobeSearched and not stringToSearch:
        return ""

    if len(stringToSearch) > len(stringTobeSearched):
        return ""

    ss = [0] * 256
    tt = [0] * 256

    for i in range(len(stringToSearch)):
        tt[ord(stringToSearch[i])] += 1

    j = 0
    while j < len(stringToSearch) - 1 and j < len(stringTobeSearched):
        ss[ord(stringTobeSearched[j])] += 1
        j += 1

    left_ptr = 0
    right_ptr = j
    start = end = -1
    min = float('inf')

    while right_ptr < len(stringTobeSearched):
        ss[ord(stringTobeSearched[right_ptr])] += 1

        if isMatch(ss, tt):
            if right_ptr - left_ptr < min:
                min = right_ptr - left_ptr
                start = left_ptr
                end = right_ptr
            while left_ptr < right_ptr:
                ss[ord(stringTobeSearched[left_ptr])] -= 1
                left_ptr += 1
                if isMatch(ss, tt):
                    if right_ptr - left_ptr < min:
                        min = right_ptr - left_ptr
                        start = left_ptr
                        end = right_ptr
                else:
                    break

        right_ptr += 1

    if min == float('inf'):
        return ""

    return stringTobeSearched[start: end + 1]


def isMatch(toBeSearchedArr, toSearchArr):
    i = 0
    while i < 256:
        if toBeSearchedArr[i] < toSearchArr[i]:
            return False
        i += 1
    return True


if __name__ == "__main__":
    print(minimum_window_substring(str("ADOBECODEBANC"), str("EABC")))
