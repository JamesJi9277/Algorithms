// Given a linked list, remove the nth node from the end of list and return its head.

// Have you met this question in a real interview? Yes
// Example
// Given linked list: 1->2->3->4->5->null, and n = 2.

// After removing the second node from the end, the linked list becomes 1->2->3->5->null.
// Note
// The minimum number of nodes in list is n.

// Challenge
// O(n) time
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int length = getLength(head);
        length = length - n ;
        ListNode crt = dummy;
        while(length-- > 0) {
            crt = crt.next;
        }
        crt.next = crt.next.next;
        return dummy.next;
    }
    private int getLength(ListNode head) {
        ListNode crt = head;
        int count = 1;
        while(crt.next != null) {
            crt = crt.next;
            count++;
        }
        return count;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return (remove(head, n) == 0? head.next : head);
    }
    private int remove(ListNode node, int n) {
        if(node.next == null) {
            return n - 1;
        }
        int rest = remove(node.next, n);
        if(rest == 0) {
            node.next = node.next.next;
            return -1;
        }
        else {
            return rest - 1;
        }
    }
}

//屌逼的recursive
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        doRemove(dummy, n);
        return dummy.next;
    }
    private int doRemove(ListNode head, int n) {
        if(head == null) {
            return 0;
        }
        int res = doRemove(head.next, n);
        if(res == n) {
            head.next = head.next.next;
        }
        return res + 1;
    }
}
