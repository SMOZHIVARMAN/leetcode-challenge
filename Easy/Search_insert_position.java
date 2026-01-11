/*
Title: Search Insert Position

Approach:
1. Use Binary Search since the array is sorted.
2. Initialize two pointers:
   - left at the beginning of the array.
   - right at the end of the array.
3. While left <= right:
   - Calculate the middle index to avoid overflow.
   - If nums[mid] equals the target, return mid.
   - If nums[mid] is less than the target, search in the right half.
   - If nums[mid] is greater than the target, search in the left half.
4. If the target is not found, the `left` pointer will indicate
   the correct insertion position.
5. Return `left` as the insert position.

Time Complexity: O(log n)
- Binary search reduces the search space by half each iteration.

Space Complexity: O(1)
- No extra space is used; the algorithm runs in constant space.
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;  
            }
            else if (nums[mid] < target) {
                left = mid + 1;  
            }
            else {
                right = mid - 1;  
            }
        }
        return left;  
    }
}
