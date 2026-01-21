/*
Title: Valid Anagram

Approach:
1. Convert both strings into character arrays.
2. Sort both character arrays.
3. Convert the sorted character arrays back into strings.
4. If the sorted strings are equal, then both strings are anagrams.
   Otherwise, they are not anagrams.

Time Complexity:
- O(n log n)
  Sorting takes O(n log n), where n is the length of the strings.

Space Complexity:
- O(n)
  Extra space is used for the character arrays created from the strings.
*/

import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        String str1 = new String(ch1);

        char[] ch2 = t.toCharArray();
        Arrays.sort(ch2);
        String str2 = new String(ch2);

        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }
}
