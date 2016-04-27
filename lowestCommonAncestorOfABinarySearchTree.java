// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______6______
//        /              \
//     ___2__          ___8__
//    /      \        /      \
//    0      _4       7       9
//          /  \
//          3   5
// For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//lint said TLE
public class Solution{
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return null;
		}
		else if(root == p) {
			return p;
		}
		else if( root == q) {
			return q;
		}
		if(lowestCommonAncestor(root.left, p, q) == null) {
			return lowestCommonAncestor(root.right, p, q);
		}
		else if(lowestCommonAncestor(root.right, p, q) == null) {
			return lowestCommonAncestor(root.left, p, q);
		}
		else {
			return root;
		}
	}
}

//lint and lc can ac
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    // bottom-up recursion: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null) {
            return null;
        }    

        if (root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        } 

        return left != null? left : right;
    }
}

//better solution, somehow straight forward
public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		if(root == A || root == B || root == null) {
			return root;
		}
		boolean aInLeft = containsNode(root.left, A);
		boolean bInLeft = containsNode(root.left, B);
		if((aInLeft&&!bInLeft)||(!aInLeft&&bInLeft)) {
			return root;
		}
		if(aInLeft) {
			return lowestCommonAncestor(root.left, A, B);
		}
		else {
			return lowestCommonAncestor(root.right, A, B);
		}
	}
	private boolean containsNode(TreeNode root, TreeNode node) {
		if(root == null) {
			return node == null;
		}
		if(root == node) {
			return true;
		}
		return containsNode(root.left, node) || containsNode(root.right, node);
	}
}
//selfwrite bug free
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) {
            return root;
        }
        if(p == null || q == null) {
            return (p == null)? q : p;
        }
        if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        if((p.val < root.val && q.val < root.val)) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if((p.val > root.val && q.val > root.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}

