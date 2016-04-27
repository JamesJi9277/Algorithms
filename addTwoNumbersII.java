You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in forward order, 
such that the 1s digit is at the head of the list. 
Write a function that adds the two numbers and returns the sum as a linked list.

Have you met this question in a real interview? Yes
Example
Given 6->1->7 + 2->9->5. That is, 617 + 295.

Return 9->1->2. That is, 912.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;      
 *     }
 * }
 */
public class Solution {
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null || l2 == null) {
            return (l1 == null)? l2 : l1;
        }
        ListNode ll1 = doReverse(l1);
        ListNode ll2 = doReverse(l2);
        ListNode newHead = add(ll1, ll2);
        return doReverse(newHead);
    }  
    private ListNode doReverse(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    private ListNode add(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int val = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode next = new ListNode(val);
            head.next = next;
            head = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            ListNode next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            head.next = next;
            head = next;
            l1 = l1.next;
        }
        while(l2 != null) {
            ListNode next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            head.next = next;
            head = head.next;
            l2 = l2.next;
        }
        if(carry == 1) {
            ListNode tail = new ListNode(1);
            head.next = tail;
            tail.next = null;
        }
        return dummy.next;
    }
}
