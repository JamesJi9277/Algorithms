// You have two numbers represented by a linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.

// Have you met this question in a real interview? Yes
// Example
// Given 7->1->6 + 5->9->2. That is, 617 + 295.

// Return 2->1->9. That is 912.

// Given 3->1->5 and 5->9->2, return 8->0->8.
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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        if(l1 == null || l2 == null) {
            return l1 == null? l2:l1;
        }
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null) {
            //carry = 0;
            int digit1 = l1 == null? 0:l1.val;
            int digit2 = l2 == null? 0:l2.val;
            int digit = (digit1 + digit2 + carry) % 10;
            carry = (digit1 + digit2 + carry) / 10;
            ListNode temp = new ListNode(digit);
            //temp.val = digit;
            head.next = temp;
            head = temp;
            l1 = l1==null? null:l1.next;
            l2 = l2==null? null:l2.next;
        }
        if(carry == 1) {
            ListNode tail = new ListNode(1);
            head.next = tail;
        }
        return dummy.next;
    }
}


//O(1) space, O(n) time
public class Solution {
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        ListNode cur = pre;
        head.next = (l1 == null)?l2:l1;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int val = ((l1 == null)? 0:l1.val) + ((l2 == null)? 0:l2.val) + ((carry == 1)? 1:0);
            if(val > 9) {
                carry = 1;
            }
            else carry = 0;
            val %= 10;
            cur = (l1 == null)? l2:l1;
            cur.val = val;
            pre.next = cur;
            pre = cur;
            l1 = (l1 == null)? null:l1.next;
            l2 = (l2 == null)? null:l2.next;
        }
        if(carry == 1) {
            ListNode tail = new ListNode(1);
            pre.next = tail;
        }
        return head.next;
    }
}
