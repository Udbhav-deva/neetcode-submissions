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
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;
            
            if (smallestNode.next != null) {
                pq.offer(smallestNode.next);
            }
        }
        
        return dummy.next;
    }
}
