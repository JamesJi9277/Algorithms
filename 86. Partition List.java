/*
比x value小的全部在他左边
用两个dummy node。然后进行链表重新排序连接，再连接两个dummy*/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode lessThanX = new ListNode(0);
        ListNode dummy1 = lessThanX;
        ListNode biggerOrEqual = new ListNode(0);
        ListNode dummy2 = biggerOrEqual;
        ListNode temp = head;
        while(temp != null) {
        	if(temp.val < x) {
        		dummy1.next = temp;
        		temp = temp.next;
        		dummy1 = dummy1.next;
        	}
        	else {
        		dummy2.next = temp;
        		temp = temp.next;
        		dummy2 = dummy2.next;
        	}
        }
        dummy1.next = biggerOrEqual.next;
        dummy2.next = null;
        return lessThanX.next;
    }
}