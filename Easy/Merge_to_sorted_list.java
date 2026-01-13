/**
 * Title: Merge Two Sorted Lists
 *
 * Approach:
 * 1. Create a dummy node to act as the starting point of the merged list.
 * 2. Use a pointer `current` to build the new list.
 * 3. Compare the current nodes of both lists:
 *    - Attach the smaller node to `current.next`
 *    - Move the pointer of the selected list forward.
 * 4. Move `current` forward after each attachment.
 * 5. Once one list is exhausted, attach the remaining nodes
 *    of the other list directly.
 * 6. Return `dummy.next` as the head of the merged list.
 *
 * Time Complexity:
 * O(n + m)
 * where n and m are the lengths of list1 and list2.
 *
 * Space Complexity:
 * O(1)
 * No extra space is used apart from pointers (in-place merge).
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        
        current.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}
