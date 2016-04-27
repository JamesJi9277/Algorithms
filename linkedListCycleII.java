// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Have you met this question in a real interview? Yes
// Example
// Given -21->10->4->5, tail connects to node index 1，返回10

// Challenge
// Follow up:
// Can you solve it without using extra space?
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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        //这里一个部分是对链表有没有cycle的一个判断
        if(fast.next == null || fast.next.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//九章做法，精简 + 理解
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        while (head != slow.next) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }
}