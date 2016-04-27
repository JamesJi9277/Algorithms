// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


// Notes:

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.
//先将指针移动到同一个起点，再开始同时移动
//http://weibo.com/3948019741/BseJ6ukI3
//链表大总结
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        if(lengthA > lengthB) {
            ListNode temp = headA;
            int diff = lengthA - lengthB;
            while(diff-- > 0) {
                temp = temp.next;
            }
            ListNode temp2 = headB;
            while(temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
        else if(lengthA < lengthB) {
            ListNode temp = headB;
            int diff = lengthB - lengthA;
            while(diff-- > 0) {
                temp = temp.next;
            }
            ListNode temp2 = headA;
            while( temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
        else if(lengthA == lengthB){
            ListNode temp = headB;
            ListNode temp2 = headA;
            while(temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
        return null;
    }
    private int getLength(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}