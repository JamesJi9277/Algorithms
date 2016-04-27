/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        while(head != null) {
            ListNode node = dummy;
            while(node.next != null && node.next.val < head.val) {
                node = node.next;
            }
            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode preNode = head;
        ListNode insertNode = head.next;
        while(insertNode != null) {
            ListNode nextInsert = insertNode.next;
            if(insertNode.val <= head.val) {
                preNode.next = insertNode.next;
                insertNode.next = head;
                head = insertNode;
            }
            else if(insertNode.val >= preNode.val) {
                preNode = preNode.next;
            }
            else {
                ListNode compareNode = head;
                while(compareNode.next.val < insertNode.val) {
                    compareNode = compareNode.next;
                }
                preNode.next = insertNode.next;
                insertNode.next = compareNode.next;
                compareNode.next = insertNode;
            }
            insertNode = nextInsert;
        }
        return head;
    }
}