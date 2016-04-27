/*
nothing fancy, just do it as nature*/
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
        	return (l1 == null) ? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode head = dummy;
        while(l1 != null && l2 != null) {
        	int val = (l1.val + l2.val + carry) % 10;
        	carry = (l1.val + l2.val + carry) / 10;
        	ListNode temp = new ListNode(val);
        	head.next = temp;
        	head = head.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null) {
        	int val = (l1.val + carry) % 10;
        	carry = (l1.val + carry) / 10;
        	ListNode temp = new ListNode(val);
        	head.next = temp;
        	head = head.next;
        	l1 = l1.next;
        }
        while(l2 != null) {
        	int val = (l2.val + carry) % 10;
        	carry = (l2.val + carry) / 10;
        	ListNode temp = new ListNode(val);
        	head.next = temp;
        	head = head.next;
        	l2 = l2.next;
        }
        if(carry == 1) {
        	ListNode tail = new ListNode(1);
        	head.next = tail;
        }
        return dummy.next;
    }
}