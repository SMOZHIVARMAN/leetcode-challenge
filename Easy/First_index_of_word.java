/*
Title: Find the First Occurrence of a Substring (strStr)

Approach:
1. Use Java’s built-in String methods:
   - `contains()` to check whether the substring (needle) exists in the main string (haystack).
   - `indexOf()` to find the index of the first occurrence of the substring.
2. If `haystack` contains `needle`, return the index obtained from `indexOf()`.
3. If `needle` is not found, return -1.

Time Complexity:
- O(n * m) in the worst case,
  where n is the length of `haystack` and m is the length of `needle`.
- This is due to internal substring matching performed by `contains()` / `indexOf()`.

Space Complexity:
- O(1)
- No extra space is used apart from constant variables.

Note:
- Java internally optimizes string searching, but algorithmically this is equivalent
  to a naive substring search approach.
*/

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return (haystack.indexOf(needle));
        }
        else
        {
            return -1;
        }
    }
}