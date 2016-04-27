// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
//
// Have you met this question in a real interview? Yes
// Example
//                2
// 1->2->3  =>   / \
//              1   3
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if(head == null) {
          return null;
        }
        if(head.next == null) {
          return new TreeNode(head.val);
        }
        int length = getLength(head);
        return formBST(head, 0, length - 1);
    }
    private int getLength(ListNode head) {
      int count = 1;
      if(head == null) {
        return 0;
      }
      while(head.next != null) {
        head = head.next;
        count++;
      }
      return count;
    }
    private TreeNode formBST(ListNode head, int start, int end) {
      if(head == null) {
        return null;
      }
      if(start >= end) {
        TreeNode root = new TreeNode(head.val);
        return root;
      }
      int mid = start + (end - start) / 2;
      ListNode preMid = findNodeBeforeMid(head);
      ListNode middle = preMid.next;
      preMid.next = null;
      ListNode postMid = middle.next;
      TreeNode root = new TreeNode(middle.val);
      root.left = formBST(head, start, mid - 1);
      root.right = formBST(postMid, mid + 1, end);
      return root;
    }
    private ListNode findNodeBeforeMid(ListNode head) {
      if(head == null || head.next == null) {
        return head;
      }
      ListNode fast = head;
      ListNode slow = head;
      ListNode tracker = head;
      while(fast.next != null && fast.next.next != null) {
        fast = fast.next.next;
        tracker = slow;
        slow = slow.next;
      }
      return tracker;
    }
}




/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = null;
        //这里我要做的是不仅找到root还要找到root之前的那个节点作为左边界
        //但是边界情况是我只有一个root，root左边没有元素了，所以我要将temp的初值
        //设定成null，然后在判断的时候经过一轮的找中点判断后
        //如果temp的值是null则代表原来的list只有一个元素，那么我就讲head设置成null，在下一个地柜会自动返回
        //不然的话就是常规做法，将temp.next == null 做一个截断处理
        //这题这一点真是个关键
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }
        if(temp != null) {
            temp.next = null;
        }
        else {
            head = null;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
