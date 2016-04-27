/*简单题，merge sort分治递归下去*/
public class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
        	return head1 == null ? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(head1 != null && head2 != null) {
        	if(head1.val < head2.val) {
        		head.next = head1;
        		head1 = head1.next;
        		head = head.next;
        	}
        	else {
        		head.next = head2;
        		head2 = head2.next;
        		head = head.next;
        	}
        }
        if(head1 != null) {
        	head.next = head1;
        }
        if(head2 != null) {
        	head.next = head2;
        }
        return dummy.next;
    }
}