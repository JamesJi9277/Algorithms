// Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
//
// Note:
// Given target value is a floating point.
// You may assume k is always valid, that is: k ≤ total nodes.
// You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
// Follow up:
// Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
//
// Hint:
//
// Consider implement these two helper functions:
// getPredecessor(N), which returns the next smaller node to N.
// getSuccessor(N), which returns the next larger node to N.
// Try to assume that each node has a parent pointer, it makes the problem much easier.
// Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
// You would need two stacks to track the path in finding predecessor and successor node separately.
//参考discuss
public class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<Integer>();
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    inorderTraversal(root, target, false, stack1);
    inorderTraversal(root, target, true, stack2);
    while(k-- > 0) {
      if(stack1.isEmpty()) {
        res.add(stack2.pop());
      }
      else if(stack2.isEmpty()) {
        res.add(stack1.pop());
      }
      else if(Math.abs(stack1.peek() - target) < Math.abs(stack2.peek() - target)) {
        res.add(stack1.pop());
      }
      else {
        res.add(stack2.pop());
      }
    }
    return res;
  }
  private void inorderTraversal(TreeNode root, double target, boolean reverse, Stack<Integer> stack) {
    if(root == null) {
      return;
    }
    inorderTraversal(reverse? root.right : root.left, target, reverse, stack);
    if((reverse && root.val <= target) || (!reverse && root.val > target)) {
      return;
    }
    //track the value of current node
    stack.push(root.val);
    inorderTraversal(reverse? root.left : root.right, target, reverse, stack);
  }
}








public class Solution {
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    Stack<TreeNode> smaller = new Stack<TreeNode>();
    Stack<TreeNode> bigger = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur != null) {
      if((double)cur.val > target) {
        bigger.push(cur);
        //题目中要求的是找与target接近的，所以说我们应该不断的缩小范围
        //当此时的cur大于target的时候，我如果要继续想cur的右边来探索的话，那么我所添加的结果是回距离target越来越远
        //此时我需要做的就是要找与target近的，所以我的cur = cur.left
        cur = cur.left;
      }
      else {
        smaller.push(cur);
        cur = cur.right;
      }
    }

    List<Integer> res = new ArrayList<Integer>();
    while(res.size() < k) {
      if(bigger.isEmpty() || !smaller.isEmpty() &&
      (((double)bigger.peek().val - target) > (target - (double)smaller.peek().val))) {
        cur = smaller.pop();
        res.add(cur.val);

        cur = cur.left;
        while(cur != null) {
          smaller.push(cur);
          cur = cur.right;
        }
      }
      else {
        cur = bigger.pop();
        res.add(cur.val);

        cur = cur.right;
        while(cur != null) {
          bigger.push(cur);
          cur = cur.left;
        }
      }
    }
    return res;
  }
}





//https://csjobinterview.wordpress.com/2012/06/29/find-k-nodes-in-bst-that-are-closest-to-a-value-key/
//https://csjobinterview.wordpress.com/2012/06/29/find-k-nodes-in-bst-that-are-closest-to-a-value-key-part-ii/
// Main Test Function, step 3)
public static List<Tree> findKClosestNodeInBST(Tree root, int key, int k)
{
    List<Tree> list = new List<Tree>();
    Tree closestNode = findTreeWithKeyNearestToTheKey(root, key);
    k--;
    list.Add(closestNode);
    Tree nextlarger = nextLargerNodeInBST(closestNode);
    Tree nextSmaller = nextSmallerNodeInBST(closestNode);
    while (k > 0)
    {
        if (nextlarger == null && nextSmaller == null)
            throw new StackOverflowException();
        else if (nextlarger != null && nextSmaller != null)
        {
            if (Math.Abs(nextlarger.node - key) >= Math.Abs(nextSmaller.node - key))
            {
                list.Add(nextSmaller);
                k--;
                nextSmaller = nextSmallerNodeInBST(nextSmaller);
            }
            else
            {
                list.Add(nextlarger);
                k--;
                nextlarger = nextLargerNodeInBST(nextlarger);
            }
        }
        else if (nextlarger != null)
        {
            list.Add(nextlarger);
            k--;
            nextlarger = nextLargerNodeInBST(nextlarger);
        }
        else
        {
            list.Add(nextSmaller);
            k--;
            nextSmaller = nextSmallerNodeInBST(nextSmaller);
        }
    }
    return list;
}

//find out the node that is closed to the key, step 1)
public static Tree findTreeWithKeyNearestToTheKey(Tree root, int key)
{
    Tree desiredRoot = root;
    int diff = Math.Abs(root.node - key);
    while (root != null)
    {
        if (diff > Math.Abs(root.node - key))
        {
            diff = Math.Abs(root.node - key);
            desiredRoot = root;
        }
        if (root.node > key)
            root = root.leftChild;
        else if (root.node < key)
            root = root.rightChild;
        else
            return root;
        }
    return desiredRoot;
}

//step 2) find its next larger node in BST
public static Tree nextLargerNodeInBST(Tree current)
{
    if (current.rightChild != null)
    {
        Tree nextTree = current.rightChild;
        while (nextTree.leftChild != null)
            nextTree = nextTree.leftChild;
        return nextTree;
    }
    else
   {
        while (current.parentTree!=null)
        {
            if (current != current.parentTree.rightChild)
                return current.parentTree;
            else
            {
                while(current.parentTree!=null&&current==current.parentTree.rightChild)
                    current = current.parentTree;
                return current.parentTree;
            }
        }
        return null;
    }
}

//step 2) find its next smaller node in BST
public static Tree nextSmallerNodeInBST(Tree current)
{
    if (current.leftChild != null)
    {
        Tree nextTree = current.leftChild;
        while (nextTree.rightChild != null)
            nextTree = nextTree.rightChild;
        return nextTree;
    }
    else
    {
        while (current.parentTree != null)
        {
            if (current == current.parentTree.rightChild)
                return current.parentTree;
            else
           {
                while (current.parentTree != null && current == current.parentTree.leftChild)
                    current = current.parentTree;
                return current.parentTree;
            }
        }
        return null;
    }
}
