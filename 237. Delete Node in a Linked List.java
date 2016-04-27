/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
这题直接把后一个节点的值覆盖当前节点
已经说明了except tail node，所以不用考虑这种特殊情况
*/

public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) {
        	return;
        }
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}