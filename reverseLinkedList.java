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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
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

public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverse(next);
        //因为这里newHead是已经reverse好的linkedlist，并且next已经有了指向，如果说直接用newHead.next = head，这样子就会出现断层
        //所以只能呢过用head这个信息来进行指向，也就是head.next.next = head;来指回自己
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}