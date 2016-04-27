public class Solution {
	public ListNode print(ListNode head) {
		ListNode fast = head.next;
		ListNode slow = head;
		while(fast != head) {
			slow = fast;
			fast = fast.next;
		}
		slow.next = null;
		fast = doReverse(fast);
		return fast;
	}
	private ListNode doReverse(ListNode head) {
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