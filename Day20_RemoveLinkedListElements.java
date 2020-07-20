/**
 * Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
 */
public class Day20_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        
        ListNode curr = head;
        
        
        if (head.val == val) {
            curr = curr.next;
        }
        
        ListNode prev = new ListNode(-1);
        ListNode Head = prev;
        
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev.next = curr;
                prev = prev.next;
            }
            
            curr = curr.next;
        }
        
        return Head.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}