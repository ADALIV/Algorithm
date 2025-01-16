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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode();
        ListNode current = root;
        int carry = 0;
        int remainder = 0;
        int val1;
        int val2;

        while (!((l1==null) && (l2==null) && (carry==0))) {
            val1 = (l1==null) ? 0 : l1.val;
            val2 = (l2==null) ? 0 : l2.val;
            int sum = val1 + val2 + carry;

            carry = sum / 10;
            remainder = sum % 10;
            current.next = new ListNode(remainder);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}