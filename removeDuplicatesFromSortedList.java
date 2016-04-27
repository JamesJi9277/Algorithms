/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
做法可以和removeII联系起来
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        while(head != null && head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return dummy;
    }
}