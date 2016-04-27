Write code to remove duplicates from an unsorted linked list.

Have you met this question in a real interview? Yes
Example
Given 1->3->2->1->4.

Return 1->3->2->4

Challenge
(hard) How would you solve this problem if a temporary buffer is not allowed? 
In this case, you dont need to keep the order of nodes.

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
     * @param head: The first node of linked list.
     * @return: head node
     */
    public ListNode removeDuplicates(ListNode head) { 
        // Write your code here
        if(head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode dummy = head;
        ListNode prev = head;
        while(dummy != null) {
            if(!set.contains(dummy.val)) {
                set.add(dummy.val);
                prev = dummy ;
                dummy = dummy.next;
            }
            else {
                prev.next = dummy .next;
                dummy = prev.next;
            }
        }
        return head;
    }  
}
