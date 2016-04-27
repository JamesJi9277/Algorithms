//remove Nth node fron end of list
recursive
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy, n);
        return dummy.next;
    }
    private int helper(ListNode head, int n) {
        if(head == null) {
            return 0;
        }
        int res = helper(head.next, n);
        if(res == n) {
            head.next = head.next.next;
        }
        return res + 1;
    }
}
