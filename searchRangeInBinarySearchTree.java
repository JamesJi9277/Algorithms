// Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree. Find all the keys of tree in range k1 to k2. i.e. print all x such that k1<=x<=k2 and x is a key of given BST. Return all the keys in ascending order.

// Have you met this question in a real interview? Yes
// Example
// If k1 = 10 and k2 = 22, then your function should return [12, 20, 22].

//     20
//    /  \
//   8   22
//  / \
// 4   12
/**
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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> res1 = new ArrayList<Integer>();
        doInorderTraverse(root, res);
        for(int i = 0; i < res.size(); i++) {
            if(k1 <= res.get(i) && res.get(i) <= k2) {
                res1.add(res.get(i));
            }
        }
        return res1;
    }
    private void doInorderTraverse(TreeNode root, ArrayList<Integer> res) {
        if(root == null) {
            return;
        }
        doInorderTraverse(root.left, res);
        res.add(root.val);
        doInorderTraverse(root.right, res);
    }
}


public class Solution {
	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode runner = root;
		while(runner != null || !stack.isEmpty()) {
			while(runner != null) {
				stack.push(runner);
				runner = runner.left;
			}
			runner = stack.pop();
			if(runner.val >= k1 && runner.val <= k2) {
				res.add(runner.val);
			}
			runner = runner.right;
		}
		return res;
	}
}
