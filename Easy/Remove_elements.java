/*
Title: Remove Element from Array

Approach:
1. Use a two-pointer technique.
2. Initialize a pointer `k` to track the position for the next valid element.
3. Traverse the array using index `i`:
   - If nums[i] is not equal to the given value `val`,
     place it at index `k` and increment `k`.
4. After traversal, the first `k` elements of the array
   contain all elements except `val`.
5. Return `k` as the new length of the modified array.

Time Complexity: O(n)
- Single pass through the array of length n.

Space Complexity: O(1)
- In-place modification; no extra space is used.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] != val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}