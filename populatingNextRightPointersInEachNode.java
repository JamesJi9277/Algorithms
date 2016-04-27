// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
//这个题的前提给的是一个满二叉树，所以不需要进行left或者right是否为空的判断，直接去遍历即可
//time O(n), space O(n)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode tmp = queue.poll();
                if(i == size - 1) {
                    tmp.next = null;
                }
                else {
                    tmp.next = queue.peek();
                }
                if (tmp.left != null) {
        			queue.offer(tmp.left);
        		}
        		if (tmp.right != null) {
        			queue.offer(tmp.right);
        		}
            }
        }
    }
}
//time O(n), space O(n)
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        levelOrder(root);
        return;
    }
    private void levelOrder(TreeLinkNode root) {
        Queue<TreeLinkNode> queue1 = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> queue2 = new LinkedList<TreeLinkNode>();
        queue1.offer(root);
        while(!queue1.isEmpty()) {
            TreeLinkNode temp = queue1.poll();
            if(temp.left != null) {
                queue2.offer(temp.left);
            }
            if(temp.right != null) {
                queue2.offer(temp.right);
            }
            if(queue1.isEmpty()) {
                temp.next = null;
                queue1.addAll(queue2);
                queue2.clear();
            }
            else {
                temp.next = queue1.peek();
            }
        }
    }
}

//Time O(n), space O(logn)
public class Solution {
  public void connect(TreeLinkNode root) {
    if(root == null) {
      return;
    }
    if(root.left != null) {
      root.left.next = root.right;
    }
    if(root.right != null) {
      root.right.next = (root.next != null) ? root.next.left : null;
    }
    connect(root.left);
    connect(root.right);
  }
}




//time O(n), space O(1)

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode firstNode = root;
        TreeLinkNode lowerNode = firstNode.left;
        while(firstNode != null && lowerNode != null) {
            TreeLinkNode tmp = null;
            while(firstNode != null) {
                if(tmp == null) {
                    tmp = firstNode.left;
                }
                else {
                    tmp.next = firstNode.left;
                    tmp = tmp.next;
                }
                tmp.next = firstNode.right;
                tmp = tmp.next;
                firstNode = firstNode.next;
            }
            firstNode = lowerNode;
            lowerNode = firstNode.left;
        }
    }
}

















