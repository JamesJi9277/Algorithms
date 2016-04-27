Implement a function to check if a linked list is a palindrome.

Have you met this question in a real interview? Yes
Example
Given 1->2->1, return true

Challenge
Could you do it in O(n) time and O(1) space?

time On, space On
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head == null || head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<Integer>();
        ListNode head1 = head;
        while(head1!= null) {
            stack.push(head1.val);
            head1 = head1.next;
        }
        while(!stack.isEmpty() && head != null) {
            if(stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}

time On, space O1
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head == null || head.next == null) {
            return true;
        }
        ListNode mid = findMid(head);
        ListNode newHead = mid.next;
        mid.next = null;
        newHead = doReverse(newHead);
        while(head != null && newHead != null) {
            if(head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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

