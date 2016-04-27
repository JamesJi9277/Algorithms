public class Reorder_list {
	public static ListNode reorderList(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) {
			return head;
		}
		int count = 0;
		ListNode temp = head;
		while(temp != null) {
			temp = temp.next;
			count++;
		}
		ListNode tail = findTail(head, count);
		ListNode newHead = tail.next;
		tail.next = null;
		ListNode head1 = head;
		doMerge(head1, newHead);
		return head;
	}
	private static ListNode findTail(ListNode head, int count) {
		if(count % 2 == 1) {
			ListNode fast = head.next;
			ListNode slow = head;
			ListNode tail = new ListNode(0);
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				tail = slow;
				slow = slow.next;
			}
			return tail;
		}
		else if(count % 2 == 0) {
			ListNode fast = head.next;
			ListNode slow = head;
			while(fast != null && fast.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return slow;
		}
		return null;
	}
	private static void doMerge(ListNode head1, ListNode head2) {
		ListNode temp = new ListNode(0);
		while(head1 != null && head2 != null) {
			ListNode next = head2.next;
			head2.next = head1.next;
			head1.next = head2;
			head1 = head2.next;
			temp = head2;
			head2 = next;
		}
		if(head2 != null) {
			temp.next = head2;
		}
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);ListNode node2 = new ListNode(2);ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		node1.next = node2;node2.next = node3;node3.next = node4;
		printout(node1);
		System.out.println("\nAfter Reorder:");
		ListNode new1 = reorderList(node1);
		printout(new1);
		
		ListNode node11 = new ListNode(1); ListNode node22 = new ListNode(2); ListNode node33 = new ListNode(3);
		ListNode node44 = new ListNode(4);ListNode node55 = new ListNode(5);
		node11.next = node22;node22.next = node33;node33.next = node44;node44.next = node55;
		System.out.println("\n");
		printout(node11);
		System.out.println("\nAfter Reorder:");
		ListNode new2 = reorderList(node11);
		printout(new2);
	}

	public static void printout(ListNode head){
		while( head != null ){
			System.out.print(head.val + "->");
			head = head.next;
			if(head == null) {
				System.out.print("null");
			}
		}
	}
}