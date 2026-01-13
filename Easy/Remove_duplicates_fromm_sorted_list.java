/**
 * Title: Remove Duplicates from Sorted List
 *
 * Approach:
 * 1. Use a pointer `current` starting from the head of the linked list.
 * 2. Traverse the list while both `current` and `current.next` are not null.
 * 3. If the value of the current node is equal to the next node:
 *    - Skip the next node by updating `current.next` to `current.next.next`.
 * 4. If values are different:
 *    - Move the `current` pointer to the next node.
 * 5. Continue until the end of the list is reached.
 * 6. Return the modified head of the linked list.
 *
 * Time Complexity:
 * O(n)
 * where n is the number of nodes in the linked list.
 *
 * Space Complexity:
 * O(1)
 * No extra space is used; duplicates are removed in-place.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; 
            } else {
                current = current.next; 
            }
        }
        return head;
    }
}
