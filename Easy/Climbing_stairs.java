/*
Title: Climbing Stairs

Approach:
1. This problem follows a Fibonacci sequence pattern.
   - To reach step i, you can come from step (i - 1) or (i - 2).
   - Therefore: ways[i] = ways[i - 1] + ways[i - 2].
2. Handle base cases:
   - If n <= 2, return n.
3. Use an iterative approach with constant space:
   - `prev` stores the number of ways to reach step (i - 2).
   - `curr` stores the number of ways to reach step (i - 1).
4. For each step from 3 to n:
   - Compute the next value as prev + curr.
   - Update prev and curr.
5. Return the number of ways to reach step n.

Time Complexity: O(n)
- Single loop from 3 to n.

Space Complexity: O(1)
- Only a few integer variables are used; no extra space required.
*/

class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev = 1;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
