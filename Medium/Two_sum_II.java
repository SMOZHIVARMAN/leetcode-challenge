/*
Title: Add Two Numbers (Linked List)

Approach:
1. The digits of the numbers are stored in reverse order in two linked lists.
2. Use a dummy node to simplify result list construction.
3. Maintain a `carry` for handling sums greater than 9.
4. Traverse both linked lists while at least one node exists or carry is non-zero:
   - Add values from l1 and l2 (if they exist) along with carry.
   - Create a new node with digit = sum % 10.
   - Update carry = sum / 10.
5. Move forward in the lists and continue until all digits are processed.
6. Return dummy.next as the head of the final summed linked list.

Time Complexity:
- O(max(m, n))
  where m and n are the lengths of l1 and l2.

Space Complexity:
- O(max(m, n))
  because a new linked list is created to store the result.
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummy.next;
    }
}
