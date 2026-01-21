/*
Title: 3Sum (Find All Unique Triplets That Sum to Zero)

Approach:
1. Sort the array to easily handle duplicates and use the two-pointer technique.
2. Iterate through the array with index i (0 to n-3):
   - Skip duplicate values for i to avoid repeated triplets.
3. For each nums[i], set a target = -nums[i] and use two pointers:
   - left = i + 1
   - right = n - 1
4. While left < right:
   - Compute sum = nums[left] + nums[right]
   - If sum == target:
       a) Found a valid triplet → add [nums[i], nums[left], nums[right]]
       b) Skip duplicate values for left and right
       c) Move both pointers inward
   - If sum < target → move left forward to increase sum
   - If sum > target → move right backward to decrease sum
5. Return the list of all unique triplets.

Time Complexity:
- Sorting: O(n log n)
- Two-pointer search for each i: O(n)
- Overall: O(n^2)

Space Complexity:
- O(1) extra space (excluding the output list)
- Sorting may use extra space depending on implementation.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
