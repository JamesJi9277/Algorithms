// Given a list, rotate the list to the right by k places, where k is non-negative.
//
// Have you met this question in a real interview? Yes
// Example
// Given 1->2->3->4->5 and k = 2, return 4->5->1->2->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 public class Solution {
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null  || head.next == null || k < 1) {
          return head;
        }
        int length = getLength(head);
        k = k % length;
        ListNode newTail = findNthFromLast(head, k + 1);
        ListNode newHead = newTail.next;
        ListNode tail = findTail(head);
        newTail.next = null;
        tail.next = head;
        return newHead;
    }
    private int getLength(ListNode head) {
      int count = 1;
      while(head.next != null) {
        head = head.next;
        count++;
      }
      return count;
    }
    private ListNode findTail(ListNode head) {
      while(head.next != null) {
        head = head.next;
      }
      return head;
    }
    private ListNode findNthFromLast(ListNode head, int n) {
      ListNode fast = head;
      ListNode slow = head;
      for(int i = 1; i < n; i++) {
        fast = fast.next;
      }
      while(fast.next != null) {
        fast = fast.next;
        slow = slow.next;
      }
      return slow;
    }
}


public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null || k < 1) {
            return head;
        }
        int length = getLength(head);
        k = k % length;
        int temp = length - k;
        ListNode runner = head;
        while(-- temp > 0) {
            runner = runner.next;
        }
        ListNode newHead = runner.next;
        runner.next = null;
        runner = newHead;
        while(runner.next != null) {
            runner = runner.next;
        }
        runner.next = head;
        return newHead;
    }
    private int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
