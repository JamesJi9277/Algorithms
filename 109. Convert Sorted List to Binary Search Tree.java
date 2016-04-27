/*
pay attention that requirement is make a height balanced BST
*/
/*
 这里我要做的是不仅找到root还要找到root之前的那个节点作为左边界
        但是边界情况是我只有一个root，root左边没有元素了，所以我要将temp的初值
        设定成null，然后在判断的时候经过一轮的找中点判断后
        如果temp的值是null则代表原来的list只有一个元素，那么我就讲head设置成null，在下一个地柜会自动返回
        不然的话就是常规做法，将temp.next == null 做一个截断处理
        这题这一点真是个关键
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
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
