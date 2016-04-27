/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }
    private ListNode helper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return (head1 == null)? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            temp.next = head1;
        }
        else {
            temp.next = head2;
        }
        return dummy.next;
    }
}