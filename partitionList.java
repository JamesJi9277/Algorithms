// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2->null and x = 3,
// return 1->2->2->4->3->5->null.



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
//bug free
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode dummy11 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode dummy22 = dummy2;
        while(head != null) {
            if(head.val < x) {
                dummy11.next = head;
                head = head.next;
                dummy11 = dummy11.next;
            }
            else if(head.val >= x) {
                dummy22.next = head;
                head = head.next;
                dummy22 = dummy22.next;
            }
        }
        dummy22.next = null;//必须要做截断处理，不然容易产生环，因为原来链表中有的指向顺序并没有发生改变，所以说一定要做截断处理
        dummy11.next = dummy2.next;
        return dummy1.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy1 = new ListNode(0);
        ListNode head1 = dummy1;
        ListNode dummy2 = new ListNode(0);
        ListNode head2 = dummy2;
        while(head != null) {
            if(head.val < x) {
                head1.next = head;
                head = head.next;
                head1 = head1.next;
            }
            else {
                head2.next = head;
                head = head.next;
                head2 = head2.next;
            }
        }
        head1.next = dummy2.next;
        head2.next = null;
        return dummy1.next;
    }
}
