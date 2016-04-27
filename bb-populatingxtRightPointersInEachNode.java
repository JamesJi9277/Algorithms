//这一题给的前提是满二叉树，所以可以这样做
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
        	return;
        }
        if(root.left != null) {
            root.left.next = root.right;
        }
        if(root.right != null) {
            root.right.next =婆 (root.next == null) ? null : root.next.left;
        }
        connect(root.left);
        connect(root.right);
    }
}

//这样子适用于任意的二叉树
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
                TreeLinkNode temp = queue.poll();
                if(i == size - 1) {
                    temp.next = null;
                }
                else {
                    temp.next = queue.peek();
                }
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
                
            }
        }
    }
}
