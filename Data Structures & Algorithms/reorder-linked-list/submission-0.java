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
    public void reorderList(ListNode head) {


        // If list is empty or has only one node,
        // no reordering is needed
        if (head == null || head.next == null) {
            return;
        }



        // Step 1: Find the middle of the list

        ListNode slow = head;
        ListNode fast = head;


        // fast moves 2 steps, slow moves 1 step
        // when fast reaches end, slow will be at middle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }



        // Split the list into two halves

        // second half starts after middle
        ListNode second = slow.next;


        // cut the connection
        // first half ends at slow
        slow.next = null;



        // Step 2: Reverse the second half

        ListNode prev = null;
        ListNode curr = second;


        while (curr != null) {

            // save next node
            ListNode next = curr.next;


            // reverse pointer
            curr.next = prev;


            // move pointers
            prev = curr;
            curr = next;
        }


        // prev is now the head of reversed second half
        second = prev;




        // Step 3: Merge both halves

        ListNode first = head;


        while (second != null) {


            // Save next nodes before changing links
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;



            // Connect first node with second node
            first.next = second;


            // Connect second node with next first node
            second.next = temp1;



            // Move forward
            first = temp1;
            second = temp2;
        }
    }
}
