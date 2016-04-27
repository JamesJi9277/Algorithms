public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //有node pair可以去swap
        while(head.next != null && head.next.next != null) {
        	//搞清楚指针的指向以及下一次开始的位置就没问题
        	ListNode first = head.next;
        	ListNode second = first.next;
        	ListNode third = second.next;
        	head.next = second;
        	second.next = first;
        	first.next = third;
        	head = first;
        }
        return dummy.next;
    }
}