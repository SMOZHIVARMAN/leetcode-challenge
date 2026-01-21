/*
Title: Group Anagrams

Approach:
1. Use a HashMap where:
   - Key   = sorted version of the string (anagram signature)
   - Value = list of all strings that match this signature
2. For each string in the input array:
   - Convert it to a character array
   - Sort the character array
   - Convert it back to a string (this becomes the key)
   - Insert the original string into the map under that key
3. Finally, return all grouped anagrams as a list of lists.

Time Complexity:
- O(n * k log k)
  where:
  - n = number of strings
  - k = average length of each string
  Sorting each string takes O(k log k)

Space Complexity:
- O(n * k)
  HashMap stores all strings and their grouped lists.
*/

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
