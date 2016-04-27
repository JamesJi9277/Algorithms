// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
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
 // 题 Unique Binary Search Trees 的升级版，这道题要求的不是二叉搜索树的数目，而是要构建这样的树。
 // 分析方法仍然是可以借鉴的，核心思想为利用『二叉搜索树』的定义，
 // 如果以 i 为根节点，那么其左子树由[1, i - 1]构成，右子树由[i + 1, n] 构成。
 // 要构建包含1到n的二叉搜索树，只需遍历1到n中的数作为根节点，
 // 以i为界将数列分为左右两部分，小于i的数作为左子树，大于i的数作为右子树，
 // 使用两重循环将左右子树所有可能的组合链接到以i为根节点的节点上。
 //可行的二叉查找树的数量是相应的卡特兰数，不是一个多项式时间的数量级
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return buildBST(1, n);
    }
    private ArrayList<TreeNode> buildBST(int left, int right) {
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if(left > right) {
    		res.add(null);
    		return res;
    	}
    	for(int i = left; i <= right; i++) {
    		ArrayList<TreeNode> leftRes = buildBST(left, i - 1);
    		ArrayList<TreeNode> rightRes = buildBST(i + 1, right);
    		for(int j = 0; j < leftRes.size(); j++) {
    			for(int k = 0; k < rightRes.size(); k++) {
    				TreeNode root = new TreeNode(i);
    				root.left = leftRes.get(j);
    				root.right = rightRes.get(k);
    				res.add(root);
    			}
    		}
    	}
    	return res;
    }
}



//second write
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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return formBST(1, n);
    }
    private List<TreeNode> formBST(int start, int end) {
      List<TreeNode> res = new ArrayList<TreeNode>();
      if(start > end) {
        res.add(null);
        return res;
      }
      for(int i = start; i <= end; i++) {
        List<TreeNode> leftTree = formBST(start, i - 1);
        List<TreeNode> rightTree = formBST(i + 1, end);
        for(TreeNode left : leftTree) {
          for(TreeNode right : rightTree) {
            TreeNode root = new TreeNode(i);
            root.left = left;
            root.right = right;
            res.add(root);
          }
        }
      }
      return res;
    }
}
