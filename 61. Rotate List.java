public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
        	return head;
        }
        int length = getLength(head);
        k %= length;
        ListNode dummy = head;
        for(int i = 1; i < length - k; i++) {
        	head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;
        ListNode temp = newHead;
        while(temp.next != null) {
        	temp = temp.next;
        }
        temp.next = dummy;
        return newHead;
    }
    private int getLength(ListNode head) {
    	ListNode temp = head;
    	int count = 0;
    	while(temp != null) {
    		temp = temp.next;
    		count++;
    	}
    	return count;
    }
}