// Sort a linked list in O(n log n) time using constant space complexity.

// Have you met this question in a real interview? Yes
// Example
// Given 1-3->2->null, sort it to 1->2->3->null
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
//这个相当于是一个归并排序，因为通过不断的递归调用sortList这个函数来不断地把问题缩小到最小，然后在不断地把最小的通过merge函数来合并成大的
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode middle = findMiddle(head);
        ListNode newHead = sortList(middle.next);
        middle.next = null;
        head = sortList(head);
        return merge(head, newHead);
    }
    private ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode head1, ListNode head2) {
        if(head1 == null || head2 == null) {
            return (head1 == null) ? head2 : head1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            }
            else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        if(head1 != null) {
            temp.next = head1;
        }
        if(head2 != null) {
            temp.next = head2;
        }
        return dummy.next;
    }
}


public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(head != null) {
            nums.add(head.val);
            head = head.next;
        }
        Collections.sort(nums);
        ListNode newHead = new ListNode(nums.get(0));
        ListNode temp = newHead;
        for(int i = 1; i < nums.size(); i++) {
            ListNode next = new ListNode(nums.get(i));
            temp.next = next;
            temp = next;
        }
        return newHead;
    }
}
