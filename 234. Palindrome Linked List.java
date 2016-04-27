这题很基本，两种方法，stack或者找到中点后reverse再比较
时间都是On，空间一个On一个O1

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
        	return true;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while(temp != null) {
        	stack.push(temp);
        	temp = temp.next;
        }
        while(head != null) {
        	if(!stack.isEmpty() && head.val != stack.pop().val) {
        		return false;
        	}
        	head = head.next;
        }
        return true;
    }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
        	return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = reverseList(mid.next);
        mid.next = null;
        while(head != null && newHead != null) {
        	if(head.val != newHead.val) {
        		return false;
        	}
        	head = head.next;
        	newHead = newHead.next;
        }
        return true;
    }
    private ListNode findMid(ListNode head) {
    	ListNode fast = head;
    	ListNode slow = head;
    	while(fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
    private ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	while(head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	return prev;
    }
}