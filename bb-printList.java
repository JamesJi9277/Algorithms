一个链表，每个node除了next还有另一个pointer。这个pointer有可能是Null，也有可能不是。比如：

23 -> 11 -> 20
          |
          V
         78 -> 50 -> 90
          |
          V.1point3acres缃�
         21 -> 30

题目：写一个function，按这样的顺序打印出这个链表：23 11 78 21 30 50 90 20

public class Solution {
	public void print(ListNode head) {
		if(head == null) {
			return;
		}
		System.out.print(head.val + " ");
		print(head.down);
		print(head.right);
	}
}