// 给定一个linked list, 比如1 -> 2 ->3 ->4 ->5 -> 6 要求返回 1 ->6 ->5 ->2 ->4 ->3
//递归
public class partitionReverseList {
	public static void printout(ListNode head){
		while( head != null ){
			System.out.print(head.val + "->");
			head = head.next;
			if(head == null) {
				System.out.print("null");
			}
		}
	}
	
	private int getLength(ListNode head) {
		int count = 0;
		ListNode node = head;
		while(node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	private ListNode doReverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private ListNode findLastTwo(ListNode node) {
		if(node == null || node.next == null) {
			return null;
		}
		ListNode head = node;
		int length = getLength(head);
		int count = 1;
		while(length - count > 2) {
			head = head.next;
			count++;
		}
		ListNode next = head.next;
		head.next = null;
		return next;
	}
	
	private ListNode findTail(ListNode head) {
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}
	
	private ListNode partition(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode node = findLastTwo(head);
		node = doReverse(node);
		ListNode next = head.next;
		head.next = node;
		ListNode tail = findTail(head);
		tail.next = partition(next);
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);ListNode node2 = new ListNode(2);ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);ListNode node5 = new ListNode(5);ListNode node6 = new ListNode(6);
		node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;node5.next = node6;
		partitionReverseList p = new partitionReverseList();
		printout(node1);
		System.out.println(" ");
		System.out.println("The length is : " + p.getLength(node1));
		ListNode newP = p.partition(node1);
		System.out.println(" ");
		System.out.println("After reverse, result is : ");
		printout(newP);
		System.out.println(" ");
	}
	
	
}
1->2->3->4->5->6->null 
The length is : 6
 
After reverse, result is : 
1->6->5->2->4->3->null 



//非递归

public class partitionReverseList {
	public static void printout(ListNode head){
		while( head != null ){
			System.out.print(head.val + "->");
			head = head.next;
			if(head == null) {
				System.out.print("null");
			}
		}
	}
	
	private int getLength(ListNode head) {
		int count = 0;
		ListNode node = head;
		while(node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
	
	private ListNode doReverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private ListNode findLastTwo(ListNode node) {
		if(node == null || node.next == null) {
			return null;
		}
		ListNode head = node;
		int length = getLength(head);
		int count = 1;
		while(length - count > 2) {
			head = head.next;
			count++;
		}
		ListNode next = head.next;
		head.next = null;
		return next;
	}
	
	private ListNode findTail(ListNode head) {
		while(head.next != null) {
			head = head.next;
		}
		return head;
	}
	
	private ListNode partition(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode node = findLastTwo(head);
		node = doReverse(node);
		ListNode next = head.next;
		head.next = node;
		ListNode tail = findTail(head);
		tail.next = partition(next);
		return head;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);ListNode node2 = new ListNode(2);ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);ListNode node5 = new ListNode(5);ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		node1.next = node2;node2.next = node3;node3.next = node4;node4.next = node5;node5.next = node6;node6.next = node7;
		partitionReverseList p = new partitionReverseList();
		printout(node1);
		System.out.println(" ");
		System.out.println("The length is : " + p.getLength(node1));
		ListNode newP = p.partition(node1);
		System.out.println(" ");
		System.out.println("After reverse, result is : ");
		printout(newP);
		System.out.println(" ");
	}
	
	
}






public class Solution {
	public ListNode partitionList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		ListNode mid = findMid(head);
		ListNode newhead = mid.next;
		mid.next = null;
		newHead = doReverse(newHead);
		ListNode newnewHead = doMerge(head, newHead);
		return newnewhead;
	}
	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	private ListNode doReverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	private ListNode doMerge(ListNode head1, ListNode head2) {
		ListNode head = head1;
		while(head1 != null && head2 != null) {
			ListNode next = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			head2 = next;
		}
		return head1;
	}
}