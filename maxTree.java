// Given an integer array with no duplicates. A max tree building on this array is defined as follow:
//
// The root is the maximum number in the array
// The left subtree and right subtree are the max trees of the subarray divided by the root number.
// Construct the max tree by the given array.
//
// Have you met this question in a real interview? Yes
// Example
// Given [2, 5, 6, 0, 3, 1], the max tree constructed by this array is:
//
//     6
//    / \
//   5   3
//  /   / \
// 2   0   1
// Challenge
// O(n) time and memory.
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
 //naive approach是不成立的，因为按照题目中说的意思我们不好去判断左右子树和叶子节点，因为存在着很多种不同的情况，
 //而题目中说的是要按照输入来构造，比如题目中给我的是2,5,6,0,3,1,那么我首先是由2和5来构造maxTree，所以5只能为2的父节点
 //然后6只能为5的父节点，


 // 参考link
 // http://www.cnblogs.com/lishiblog/p/4187936.html
 // https://richdalgo.wordpress.com/2015/01/28/lintcode-max-tree/
 // https://codesolutiony.wordpress.com/2015/01/28/lintcode-max-tree/
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
          return null;
        }
//not correct
        Arrays.sort(A);
        for()
    }
}

//思考1，可以考虑先找到原数组中的最大，然后左右分别递归调用函数，最后拼接起来
//时间复杂度On2,空间复杂度 Ologn，但是大数据没通过 14/16 test cases passed
public class Solution {
  public TreeNode maxTree(int[] A) {
    if(A == null || A.length == 0) {
      return null;
    }
    return helper(A, 0, A.length - 1);
  }
  private TreeNode helper(int[] A, int start, int end) {
    if(A == null || A.length == 0 || start > end) {
      return null;
    }
    int max = findMax(A, start, end);
    int maxIndex = findMaxIndex(A, start, end);

    TreeNode root = new TreeNode(max);
    root.left = helper(A, start, maxIndex - 1);
    root.right = helper(A, maxIndex + 1, end);
    return root;
  }
  private int findMax(int[] A, int start, int end) {
    int max = Integer.MIN_VALUE;
    for(int i = start; i <= end ; i++) {
      max = Math.max(max, A[i]);
    }
    return max;
  }
  private int findMaxIndex(int[] A, int start, int end) {
    int max = Integer.MIN_VALUE;

    for(int i = start; i <= end; i++) {
      max = Math.max(max, A[i]);
    }
    for(int i = start; i <= end; i++) {
      if(A[i] - max == 0) {
        return i;
      }
    }

    return 0;
  }
}

//考虑到用自下而上的方法来构造tree + recursion
public class Solution {
  public TreeNode maxTree(int[] A) {
    if(A == null || A.length == 0) {
      return null;
    }

    TreeNode root = new TreeNode(A[0]);
    for(int i = 1; i < A.length; i++) {
      if(A[i] > root.val) {
        TreeNode node = new TreeNode(A[i]);
        node.left = root;
        root = node;
      }
      else {
        insertNode(root, null, A[i]);
      }
    }
    return root;
  }
  private void insertNode(TreeNode cur, TreeNode pre, int val) {
    if(cur == null) {
      TreeNode node = new TreeNode(val);
      pre.right = node;
      return;
    }
    if(cur.val < val) {
      TreeNode node = new TreeNode(val);
      pre.right = node;
      node.left = cur;
      return;
    }
    else {
      insertNode(cur.right, cur, val);
    }
  }
}
 //思考2，考虑用stack，逆向思维来构造tree
// 这个题Leetcode上没有，其实这种树叫做笛卡树（ Cartesian tree）。直接递归建树的话复杂度最差会退化到O(n^2)。经典建树方法，用到的是单调堆栈。我们堆栈里存放的树，只有左子树，没有有子树，且根节点最大。
// （1） 如果新来一个数，比堆栈顶的树根的数小，则把这个数作为一个单独的节点压入堆栈。
// （2） 否则，不断从堆栈里弹出树，新弹出的树以旧弹出的树为右子树，连接起来，直到目前堆栈顶的树根的数大于新来的数。然后，弹出的那些数，已经形成了一个新的树，这个树作为新节点的左子树，把这个新树压入堆栈。
//
// 这样的堆栈是单调的，越靠近堆栈顶的数越小。
// 最后还要按照（2）的方法，把所有树弹出来，每个旧树作为新树的右子树。
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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        if (A.length==0) return null;

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(new TreeNode(A[0]));
        for (int i=1;i<A.length;i++)
            if (A[i]<=nodeStack.peek().val){
                TreeNode node = new TreeNode(A[i]);
                nodeStack.push(node);
            } else {
                TreeNode n1 = nodeStack.pop();
                while (!nodeStack.isEmpty() && nodeStack.peek().val < A[i]){
                    TreeNode n2 = nodeStack.pop();
                    n2.right = n1;
                    n1 = n2;
                }
                TreeNode node = new TreeNode(A[i]);
                node.left = n1;
                nodeStack.push(node);
            }


        TreeNode root = nodeStack.pop();
        while (!nodeStack.isEmpty()){
            nodeStack.peek().right = root;
            root = nodeStack.pop();
        }

        return root;
    }
}





public class Solution {
  public TreeNode maxTree(int[] A) {
    if(A == null || A.length == 0) {
      return null;
    }
    Stack<TreeNode> stack = new Stack<TreeNode>();

    TreeNode root = null;

    for(int i = 0; i <= A.length; i++) {
      TreeNode right = (i == A.length) ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
      while(!stack.isEmpty()) {
        if(right.val > stack.peek().val) {
          TreeNode nodeNow = stack.pop();

          if(stack.isEmpty()) {
            right.left = nodeNow;
          }
          else {
            TreeNode left = stack.peek();
            if(left.val > right.val) {
              right.left = nodeNow;
            }
            else {
              left.right = nodeNow;
            }
          }
        }
        else {
          break;
        }
      }
      stack.push(right);
    }
    return stack.peek().left;
  }
}
