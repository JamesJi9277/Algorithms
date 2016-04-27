Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.

Have you met this question in a real interview? Yes
Example
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(k < 2) {
            return head; 
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int count = 0;
        while(cur != null) {
            ListNode next = cur.next;
            count++;
            if(count == k) {
                pre = doReverse(pre, next);
                count = 0;
            }
            cur = next;
        }
        return dummy.next;
    }
    private ListNode doReverse(ListNode pre, ListNode end) {
        if(pre == null || pre.next == null) {
            return pre;
        }
        ListNode head = pre.next;
        ListNode cur = head.next;
        while(cur != end) {
            ListNode next = cur.next;
            //这里是一个循环指向的操作，不要写成了head，head相当于是tail，要在最后才能够指向end，所以这里要用pre.next代替head
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        head.next = end;
        return head;
    }
}

