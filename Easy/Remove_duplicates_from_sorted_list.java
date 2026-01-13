/*
Title: Remove Duplicates from Sorted Array

Approach:
1. Since the array is sorted, duplicate elements are adjacent.
2. Use two pointers:
   - slow → tracks the index of the last unique element.
   - fast → scans through the array.
3. Start slow at index 0.
4. For each fast from index 1:
   - If nums[fast] != nums[slow]:
     - Increment slow
     - Copy nums[fast] to nums[slow]
5. The first (slow + 1) elements of the array will contain unique values.
6. Return slow + 1 as the count of unique elements.

Time Complexity:
- O(n), where n is the length of the array.

Space Complexity:
- O(1), in-place modification.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}
