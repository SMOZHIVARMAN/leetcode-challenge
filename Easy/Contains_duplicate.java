/*
Title: Contains Duplicate

Approach:
1. Use a HashSet to store elements that have been seen so far.
2. Traverse through the array:
   - Try to add the current number to the HashSet.
   - If adding fails (means number already exists), return true (duplicate found).
3. If the loop ends without finding duplicates, return false.

Time Complexity:
- O(n)
  Each insertion/check in HashSet takes average O(1), and we traverse n elements.

Space Complexity:
- O(n)
  In the worst case, all elements are unique and stored in the HashSet.
*/

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            boolean flag = seen.add(num);
            if (!flag) {
                return true;
            }
        }
        return false;
    }
}
