Given a sorted linked list, delete all duplicates such that each element appear only once.

Have you met this question in a real interview? Yes
Example
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for ListNode
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
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        while(head.next != null) {
            if(head.val == head.next.val) {
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return dummy;
    }  
}


public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode runner = head;
        while(runner != null && runner.next != null) {
            int val = runner.val;
            //这里必须提前加上对runner.next是否为null的判断，不然这个next为null会出现空指针的情况
            while(runner.next != null && runner.next.val == val) {
                runner.next = runner.next.next;
            }
            runner = runner.next;
        }
        return head;
    }
}