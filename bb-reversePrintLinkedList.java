逆序输出一个环状链表  
例如 A -> B->C->D->E->A
输出 E D C B A 

public class Solution {
	public ListNode reversePrint(ListNode head) {
		//假设链表里面已经有环了
		ListNode fast = head;
		ListNode slow = head;
		ListNode tail = slow;
		while(fast != slow) {
			fast = fast.next.next;
			tail = slow;
			slow = slow.next;
		}
		tail.next = null;
		return doReverse(tail);
	}
	private ListNode doReverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return head;
	}
}