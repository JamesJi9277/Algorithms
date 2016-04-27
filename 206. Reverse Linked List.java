/*
题目比较基础，两种方法，递归+迭代*/
public class Solution {
    public ListNode reverseList(ListNode head) {
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
}

public class Solution {
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode next = reverseList(head.next);
		head.next.next = head;
		//这里一定要记得做截断处理
		head.next = null;
		return next;
	}
}