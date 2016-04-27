给一个BST，每一个节点里存有包含自己节点的子节点的个数，让返回nth smallest number
class TreeNode {
	int val;
	TreeNode left, right;
	int subChild;
	TreeNode(int val, int subChild) {
		this.val = val;
		this.subChild = subChild;
		this.left = this.right = null;
	}
}
public class nthSmallestInBST {
	public TreeNode findNthSmallestInBST(TreeNode root, int n) {
		if(root == null || n < 1) {
			return null;
		}
		int left = (root.left == null) ? 0 : root.left.subChild;
		if(left == n - 1) {
			return root;
		}
		if(left >= n) {
			return findNthSmallestInBST(root.left, n);
		}
		else {
			return findNthSmallestInBST(root.right, n - 1 - left);
		}
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(6,7);
		TreeNode node2 = new TreeNode(4,3);
		TreeNode node3 = new TreeNode(9,3);
		TreeNode node4 = new TreeNode(3,1);
		TreeNode node5 = new TreeNode(5,1);
		TreeNode node6 = new TreeNode(7,1);
		TreeNode node7 = new TreeNode(10,1);
		node1.left = node2; node1.right = node3;
		node2.left = node4; node2.right = node5;
		node3.left = node6; node3.right = node7;
		nthSmallestInBST n = new nthSmallestInBST();
		TreeNode res = n.findNthSmallestInBST(node1, 2);
		System.out.println(res.val);
	}
}
