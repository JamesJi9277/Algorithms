
// 给你的第四个题是这样的，intersection of two linked list, 告诉你这个题目是doublye linked list, 让你判断是否会有intersection
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