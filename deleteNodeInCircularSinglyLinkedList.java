
我先找环，找入口的同时，记录前一个节点，也就是相当于最后一个节点

再判断要删除的是不是入口，再对最后一个节点进行指针的移动
public ListNode remove(ListNode head) {
	if(head == null) {
		return;
	}
	ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode fast = dummy;
	while(fast.next != null) {
		if(fast.next.val == target) {
			fast.next = fast.next.next;
		}
		else {
			fast = fast.next;
		}
	}
	return dummy.next;
}