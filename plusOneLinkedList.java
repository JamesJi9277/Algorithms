public class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null) {
        	return new ListNode(1);
        }
        ListNode head2 = new ListNode(1);
        ListNode head1 = reverseListNode(head);
        ListNode newHead = addTwo(head1, head2);
        return reverseListNode(newHead);
    }
    private ListNode reverseListNode(ListNode head) {
    	if(head == null || head.next == null) {
    		return head;
    	}
    	ListNode prev = null;
    	while(head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }
    private ListNode addTwo(ListNode head1, ListNode head2) {
    	if(head1 == null || head2 == null) {
    	    return head1 == null ? head2 : head1;
    	}
    	ListNode dummy = new ListNode(0);
    	int carry = 0;
    	ListNode temp = dummy;
    	while(head1 != null || head2 != null) {
    	    int digit1 = head1 == null ? 0 : head1.val;
    	    int digit2 = head2 == null ? 0 : head2.val;
    		int digit = (digit1 + digit2 + carry) % 10;
    		carry = (digit1 + digit2 + carry) / 10;
    		ListNode next = new ListNode(digit);
    		temp.next = next;
    		temp = temp.next;
    		head1 = head1 == null ? null : head1.next;
    		head2 = head2 == null ? null : head2.next;
    	}
    	if(carry == 1) {
    	    ListNode tail = new ListNode(1);
    	    temp.next = tail;
    	}
    	return dummy.next;
    }
    private ListNode addTwo1(ListNode head1, ListNode head2) {
    	if(head1 == null || head2 == null) {
    		return head1 == null ? head2 : head1;
    	}
    	ListNode dummy = new ListNode(0);
    	ListNode head = dummy;
    	int carry = 0;
    	while(head1 != null && head2 != null) {
    		int digit = (head1.val + head2.val + carry) % 10;
    		carry = (head1.val + head2.val + carry) / 10;
    		ListNode next = new ListNode(digit);
    		head.next = next;
    		head = next;
    		head1 = head1.next;
    		head2 = head2.next;
    	}
    	while(head1 != null) {
    		int digit = (head1.val + carry) % 10;
    		carry = (head1.val + carry) / 10;
    		head.next = new ListNode(digit);
    		head = head.next;
    		head1 = head1.next;
    	}
    	while(head2 != null) {
    		int digit = (head2.val + carry) % 10;
    		carry = (head2.val + carry) / 10;
    		head.next = new ListNode(digit);
    		head = head.next;
    		head2 = head2.next;
    	}
    	if(carry == 1) {
    		ListNode tail = new ListNode(1);
    		head.next = tail;
    		tail.next = null;
    	}
    	return dummy.next;
    }
}


public class Solution {
	public ListNode plusOne(ListNode head) {
		if(head == null) {
			return new ListNode(1);
		}
		ListNode plused = plusOne(head.next);
		if(plused != head.next) {
			head.val++;
		}
		if(head.val <= 9) {
			return head;
		}
		head.val = 0;
		plused.next = head;
		return plused;
	}
}