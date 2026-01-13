/*
Title: Longest Common Prefix

Approach:
1. Handle edge cases:
   - If the input array is null or empty, return an empty string.
2. Assume the first string as the initial prefix.
3. Iterate through the remaining strings:
   - While the current string does not start with the prefix,
     shorten the prefix by removing its last character.
   - Repeat until the prefix matches the start of the current string
     or becomes empty.
4. If the prefix becomes empty at any point, return an empty string.
5. After processing all strings, the remaining prefix is the longest
   common prefix.

Time Complexity: O(n * m)
- n is the number of strings.
- m is the length of the longest string.
- In the worst case, each prefix comparison can take O(m).

Space Complexity: O(1)
- Only a few extra variables are used; no additional space proportional
  to input size.
*/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
