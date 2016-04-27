/*
1.左右判断维护一个count
2.得到中序遍历结果后找到第k个*/
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) {
          return -1;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res.get(k - 1);
    }
    private void helper(TreeNode root, ArrayList<Integer> res) {
      if(root == null) {
        return;
      }
      helper(root.left, res);
      res.add(root.val);
      helper(root.right, res);
    }
}
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k < 1) {
          return -1;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(!stack.isEmpty() || root != null) {
          while(root != null) {
            stack.push(root);
            root = root.left;
          }
          TreeNode temp = stack.pop();
          k--;
          if(k == 0) {
            return temp.val;
          }
          root = temp.right;
        }
        return 0;
  }
}
