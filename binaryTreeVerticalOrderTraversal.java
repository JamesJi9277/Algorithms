Given a binary tree, return the vertical order traversal of its nodes values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,20,4,5,2,7],
    _3_
   /   \
  9    20
 / \   / \
4   5 2   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,5,2],
  [20],
  [7]
]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        queue.offer(root);
        level.offer(0);
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int curLevel = level.poll();
            if(!map.containsKey(curLevel)) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(temp.val);
                map.put(curLevel, list);
            }
            else {
                List<Integer> list = map.get(curLevel);
                list.add(temp.val);
                map.put(curLevel, list);
            }
            if(temp.left != null) {
                queue.offer(temp.left);
                level.offer(curLevel - 1);
            }
            if(temp.right != null) {
                queue.offer(temp.right);
                level.offer(curLevel + 1);
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer item : map.keySet()) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }
        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}

错误代码！！！要用BFS而不是DFS，DFS的话顺序就会乱掉虽然同样的是vertical来打印
public class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
          return res;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        helper(root, map, 0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Integer item : map.keySet()) {
            min = Math.min(min, item);
            max = Math.max(max, item);
        }
        for(int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
    private void helper(TreeNode root,  HashMap<Integer, ArrayList<Integer>> map, int level) {
      if(root == null) {
        return;
      }
      if(map.containsKey(level)) {
        ArrayList<Integer> temp = map.get(level);
        temp.add(root.val);
        map.put(level, temp);
      }
      else {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        map.put(level, temp);
      }
      helper(root.left, map, level - 1);
      helper(root.right,  map, level + 1);
    }
}