// Merge two sorted (ascending) linked lists and return it as a new sorted list. The new sorted list should be made by splicing together the nodes of the two lists and sorted in ascending order.

// Have you met this question in a real interview? Yes
// Example
// Given 1->3->8->11->15->null, 2->null , return 1->2->3->8->11->15->null.
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null || l2 == null) {
            return (l1 == null)? l2:l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(l1!=null && l2!= null) {
            if(l1.val >= l2.val) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
            else if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
        }
        if(l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return dummy.next;
    }
}



//second write, 
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
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null || l2 == null) {
            return (l1 == null)? l2 : l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        //这个题不能够跟merge two sorted list相提并论，在那个题里面只可以用一个while判断就好了，但是在这个题里面
        //我们如果说if l1 == null 并且l1 = l1.next，是不行的，因为null没有next，所以会出现null pointer的报错
        while(l1 != null && l2 != null) {
            int val1 =  l1.val;
            int val2 =  l2.val;
            if(val1 <= val2) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
            else if(val1 > val2) {
               head.next = l2;
               head = head.next;
               l2 = l2.next;
            }
        }
        if(l1 != null) {
            head.next = l1;
        }
        else {
            head.next = l2;
        }
        return dummy.next;
    }
}
