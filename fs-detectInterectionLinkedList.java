求出长度差之后再每次一个走一步，相遇的点就是intersection
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
            while(temp != null && temp2 != null && temp != temp2) {
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
            while(temp != null && temp2 != null && temp != temp2) {
                temp = temp.next;
                temp2 = temp2.next;
            }
            return temp;
        }
        else if(lengthA == lengthB){
            ListNode temp = headB;
            ListNode temp2 = headA;
            while(temp != null && temp2 != null && temp != temp2) {
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


将一个链表尾部append到另外一个链表头部，然后相当于是链表找环问题了
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode tail = headA;
        while(tail.next != null) {
            tail = tail.next;
        }
        tail.next = headB;
        ListNode fast = headA;
        ListNode slow = headA;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast.next == null || fast.next.next == null) {
            return null;
        }
        fast = headA;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}