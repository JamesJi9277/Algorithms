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
/*
这一题可以先统计两个list长度，然后将长的那一个移动到跟短的一样的距离，然后再两个同时走，直到相遇为止
注意如果没有相交的就直接返回null*/
//时间On，空间O1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
        	return null;
        }

        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if(lengthA > lengthB) {
        	int count = lengthA - lengthB;
        	while(count > 0) {
        		if(headA == null) {
        			return null;
        		}
        		headA = headA.next;
        		count--;
        	}
        }
        if(lengthA < lengthB) {
        	int count = lengthB - lengthA;
        	while(count > 0) {
        		if(headB == null) {
        			return null;
        		}
        		headB = headB.next;
        		count--;
        	}
        }

        while(headA != headB) {
        	headA = headA.next;
        	headB = headB.next;
        }
        return headA;
    }
    private int getLength(ListNode head) {
    	int count = 0;
    	ListNode temp = head;
    	while(temp != null) {
    		count++;
    		temp = temp.next;
    	}
    	return count;
    }
}

//时间On，空间On，用hashset来存
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();

        ListNode tempA = headA;
        while(tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }

        ListNode tempB = headB;
        while(tempB != null) {
            if(set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
}

//
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;

        while(tempA != tempB) {
            tempA = (tempA == null) ? headB : tempA.next;
            tempB = (tempB == null) ? headA : tempB.next;
        }
        return tempA;
    }
}