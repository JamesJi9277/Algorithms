/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
//这题思路比较简单，要注意观察构造函数来确定如何新建一个ListNode节点
//再就是dummy node指向head后，通过移动来查找该删除的元素，这样子必须要复制一个dummy，不能够直接移动dummy，不然返回值不好表达，赋值dummy node之后，
//通过对复制点的移动即可，返回时候还是直接返回dummy.next
public class Solution{
	public ListNode removeElements(ListNode head, int val){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		while(p.next!= null)
		{
			if(p.next.val == val)
				p.next = p.next.next;
			else
				p = p.next;
		}
		return dummy.next;
	}
}



//九章的做法
public class Solution{
	public ListNode removeElements(ListNode head, int val){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		for(head = dummy; head != null;)
		{
			while(head.next != null && head.next.val == val)
				head.next = head.next.next;
			head = head.next;
		}
		return dummy.next;
	}
}

//second write, time complexity O(n), space complexity 0(1)
//bug free
public class Solution{
	public ListNode removeElements(ListNode head, int val){
		if(head == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode temp = dummy;
		while(temp.next != null)
		{
			if(temp.next.val == val)
				temp.next = temp.next.next;
			else
				temp = temp.next;
		}
		return dummy.next;
	}
}




































