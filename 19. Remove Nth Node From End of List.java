快慢指针，以及用hashmap来找到n-1个node再改指针，以及递归，维护参数n

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode fast = head;
        ListNode slow = head;
        while(n-- > 0) {
        	if(fast == null) {
        		return null;
        	}
        	fast = fast.next;
        }
        while(fast.next != null) {
        	fast = fast.next;
        	slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
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
    	int count = helper(head.next, n);
    	if(count == n) {
    		head.next = head.next.next;
    	}
    	return count + 1;
    }
}