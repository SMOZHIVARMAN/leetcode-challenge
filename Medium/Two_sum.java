/*
Title: Two Sum II - Input Array Is Sorted

Approach:
1. Use a HashMap to store numbers and their 1-based indices.
2. Traverse the array:
   - For the current number, compute complement = target - numbers[i].
   - If the complement exists in the map, we found the pair:
       return [index_of_complement, i + 1]
   - Otherwise, store the current number with its index (1-based) in the map.
3. If no valid pair is found, return an empty array.

Time Complexity: O(n)
- We iterate through the array once.
- HashMap operations (insert/search) take O(1) average time.

Space Complexity: O(n)
- HashMap can store up to n elements in the worst case.
*/

import java.util.*;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int compliment = target - numbers[i];

            if (map.containsKey(compliment)) {
                return new int[]{map.get(compliment), i + 1};
            }

            map.put(numbers[i], i + 1);
        }

        return new int[]{};
    }
}
