// Given a linked list, swap every two adjacent nodes and return its head.

// Have you met this question in a real interview? Yes
// Example
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Challenge
// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = head;
        while(second != null && second.next != null) {
            ListNode third = second.next;
            ListNode next = third.next;
            third.next = second;
            first.next = third;
            second.next = next;
            first = second;
            second = next;
        }
        return dummy.next;
    }
}