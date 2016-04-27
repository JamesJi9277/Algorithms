/*Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5

因为有可能head要remove，所以用dummy*/
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
        	return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(head.next != null) {
        	//分清晰逻辑关系
        	if(head.next.val == val) {
        		head.next = head.next.next;
        	}
        	else {
        		head = head.next;
        	}
        }
        return dummy.next;
    }
}