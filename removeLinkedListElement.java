Remove all elements from a linked list of integers that have value val.

Have you met this question in a real interview? Yes
Example
Given 1->2->3->3->4->5->3, val = 3, you should return the list as 1->2->4->5

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
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null ) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        while(fast.next != null) {
        	//这里的fast并没有移动，所以说相当于是一个while不断检测的过程
            if(fast.next.val == val) {
                fast.next = fast.next.next;
            }
            else{
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
