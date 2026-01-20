/*
Title: Longest Nice Substring

Approach:
1. A substring is called "nice" if for every letter in the substring,
   both its lowercase and uppercase forms are present.
   Example:
   - "aA" is nice
   - "abA" is not nice because 'b' does not have 'B'
2. Use brute force to generate all substrings:
   - Fix starting index i
   - Fix ending index j
   - Extract substring s[i..j-1]
3. For each substring, check if it is nice using the helper function isNice().
4. Keep updating the longest nice substring found so far.
5. Return the longest nice substring.

Helper Function (isNice):
1. Use two bitmasks:
   - lower → stores which lowercase letters are present
   - upper → stores which uppercase letters are present
2. For each character:
   - If lowercase, set the corresponding bit in lower.
   - If uppercase, set the corresponding bit in upper.
3. A substring is nice if lower == upper,
   meaning every character appears in both cases.

Time Complexity:
- O(n^3)
  Explanation:
  - There are O(n^2) substrings.
  - For each substring, isNice() can take O(n) time in worst case.
  - Total: O(n^2 * n) = O(n^3)

Space Complexity:
- O(1) extra space
  (Only bitmasks and a few variables are used.)
*/

class Solution {
    public String longestNiceSubstring(String s) {
        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substr = s.substring(i, j);

                if (isNice(substr) && substr.length() > longest.length()) {
                    longest = substr;
                }
            }
        }

        return longest;
    }

    private boolean isNice(String str) {
        int lower = 0, upper = 0;

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lower |= 1 << (c - 'a');
            } else if (Character.isUpperCase(c)) {
                upper |= 1 << (c - 'A');
            }
        }

        return lower == upper;
    }
}
