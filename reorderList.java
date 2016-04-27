// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You must do this in-place without altering the nodes' values.



// Have you met this question in a real interview? Yes
// Example
// For example,
// Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {
            return ;
        }
        ListNode middle = findMiddle(head);
        ListNode head1 = middle.next;
        middle.next = null;
        ListNode newHead = doReverse(head1);
        merge(head, newHead);
        return;
    }
    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode doReverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    private void merge(ListNode head1, ListNode head2) {
        while(head1 != null && head2 != null) {
            ListNode next = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = next;
        }
        return;
    }
}



