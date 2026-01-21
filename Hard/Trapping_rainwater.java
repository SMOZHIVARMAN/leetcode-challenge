/*
Title: Trapping Rain Water

Approach:
1. Use two pointers:
   - left starts at the beginning of the array.
   - right starts at the end of the array.
2. Maintain two variables:
   - leftMax  → maximum height encountered so far from the left side.
   - rightMax → maximum height encountered so far from the right side.
3. While left < right:
   - Update leftMax and rightMax.
   - If leftMax <= rightMax:
       a) Water trapped at `left` = leftMax - height[left]
       b) Move left pointer to the right
   - Else:
       a) Water trapped at `right` = rightMax - height[right]
       b) Move right pointer to the left
4. Add trapped water at each step into `result`.
5. Return result as total trapped rain water.

Time Complexity: O(n)
- Each element is processed at most once using two pointers.

Space Complexity: O(1)
- Uses only constant extra space.
*/

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftmax = 0, rightmax = 0;
        int result = 0;

        while (left < right) {
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);

            if (leftmax <= rightmax) {
                result += leftmax - height[left];
                left++;
            } else {
                result += rightmax - height[right];
                right--;
            }
        }
        return result;
    }
}
