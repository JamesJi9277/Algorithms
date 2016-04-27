//Sort a linked list using insertion sort.

//pre始终指向sorted list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        while(head != null) {
        	ListNode node = dummy;
        	while(node.next != null && node.next.val < head.val) {
        		node = node.next;
        	}
        	ListNode temp = head.next;
        	head.next = node.next;
        	node.next = head;
        	head = temp;
        }
        return dummy.next;
    }
}

public class Solution {
	public ListNode insertionSortList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode newHead = new ListNode(0);
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			ListNode pre = newHead;
			while(pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;
			pre.next = cur;
			cur = next;
		}
		return newHead.next;
	}
}