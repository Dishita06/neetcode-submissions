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

    public ListNode mergeKLists(ListNode[] lists) {


        // If no lists exist
        if (lists == null || lists.length == 0) {
            return null;
        }



        // Min heap
        // It stores nodes and always gives smallest value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>(
                (a,b) -> a.val - b.val
            );



        // Step 1:
        // Add first node of every list

        for (ListNode list : lists) {

            if (list != null) {
                pq.add(list);
            }
        }



        // Dummy node to build answer
        ListNode dummy = new ListNode(0);

        ListNode tail = dummy;



        // Step 2:
        // Keep taking smallest node

        while (!pq.isEmpty()) {


            // Remove smallest node
            ListNode smallest = pq.poll();



            // Add it to result
            tail.next = smallest;


            // Move tail forward
            tail = tail.next;



            // If this node has next node,
            // add it to heap

            if (smallest.next != null) {

                pq.add(smallest.next);
            }
        }



        return dummy.next;
    }
}