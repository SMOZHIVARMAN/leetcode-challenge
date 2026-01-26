/*
Title: Minimum Absolute Difference

Approach:
1. Sort the array in ascending order.
2. The minimum absolute difference will always occur between two adjacent
   elements in the sorted array.
3. Traverse the sorted array and compute the difference between consecutive
   elements.
4. Maintain a variable `mindiff` to store the smallest difference found so far.
5. If a smaller difference is found:
   - Update mindiff
   - Clear the previous result list
   - Add the new pair
6. If the difference equals the current mindiff:
   - Add the pair to the result list
7. Return the list of all pairs that have the minimum absolute difference.

Time Complexity:
- O(n log n)
  Sorting takes O(n log n) and scanning the array takes O(n).

Space Complexity:
- O(1) extra space (excluding output list)
  The result list is required for output, but no additional auxiliary space is used.
*/

import java.util.*;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();
        int mindiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];

            if (diff < mindiff) {
                mindiff = diff;
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == mindiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}
