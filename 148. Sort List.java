/*Sort a linked list in O(n log n) time using constant space complexity.
很自然的想到用merge Sort分治递归的做法*/
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        head = sortList(head);
        newHead = sortList(newHead);
        return mergeTwo(head, newHead);
    }
    private ListNode findMid(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
    private ListNode mergeTwo(ListNode head1, ListNode head2) {
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
