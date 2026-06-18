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
    public ListNode reverseKGroup(ListNode head, int k) {

        // Check if there are k nodes available
        ListNode temp = head;

        for (int i = 0; i < k; i++) {

            // Not enough nodes, don't reverse
            if (temp == null) {
                return head;
            }

            temp = temp.next;
        }


        // Reverse k nodes
        ListNode prev = null;
        ListNode curr = head;


        for (int i = 0; i < k; i++) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;

            curr = next;
        }


        // head is now the end of reversed group
        // connect it with remaining reversed groups
        head.next = reverseKGroup(curr, k);


        // prev is the new head of this group
        return prev;
    }
}
