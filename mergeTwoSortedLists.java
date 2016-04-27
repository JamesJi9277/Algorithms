// Merge two sorted linked lists and return it as a new list. 
// The new list should be made by splicing together the nodes of the first two lists.
// 题目中最后一句话的意思就是说要我们用O(1)的空间，直接进行指针的穿插而不是新建一个linkedlist
public class Solution{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0);//记住这里不能够写成dummy = null，不然的话会ac不了，必须要给dumy赋一个新的值
		ListNode virtualHead = dummy;
		if(l1==null||l2==null)
    			return l1==null?l2:l1;
		while(l1!= null && l2!= null)
		{
			if(l1.val < l2.val)
			{
				virtualHead.next = l1;
				l1 = l1.next;
			}
			else{
				virtualHead.next = l2;
				l2 = l2.next;
			}
			virtualHead = virtualHead.next;
		}
		if(l1 != null)
			virtualHead.next = l1;
		else
			virtualHead.next = l2;
		virtualHead = null;//gc
		return dummy.next;
	}
}


//second write, bug free
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)
        return l1==null?l2:l1;
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while(l1 != null && l2 != null)
        {
            if(l1.val < l2.val)
            {
                temp.next = l1;
                
                l1 = l1.next;
            }
           else
            {
                temp.next = l2;
                
                l2 = l2.next;
            }
         temp = temp.next;
        }
        if(l1 != null)
        temp.next = l1;
        else
        temp.next = l2;
        return dummy.next;
    }
}