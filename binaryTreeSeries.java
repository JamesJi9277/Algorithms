balanced binary tree
时间On2，空间Ologn or Oh
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
          return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if(Math.abs(left - right) > 1) {
          return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    private int getHeight(TreeNode root) {
      if(root == null) {
        return 0;
      }
      int left = getHeight(root.left);
      int right = getHeight(root.right);
      return Math.max(left, right) + 1;
    }
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	private int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}

lowest common ancestor of a binary tree
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) {
            return root;
        }
        else {
            return (left == null) ? right : left;
        }
    }
}
升级版，变成binary search tree，加入BST性质，值的判断
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) {
            return root;
        }
        if(p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if(p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}