// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].
//using BFS
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size() != 0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.offer(temp.left);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                }
                if(i == size - 1) {
                    res.add(temp.val);
                }
            }
        }
        return res;
    }
}


//using DFS
//同一个level，不断地从左往右更新value的值，最后取出新的value就好了
public class Solution{
	public List<Integer> rightSideView(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		if(root == null)
			return res;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int depth = 1;
		preOrderTraversal(root, map, 1);
		if(map.containsKey(depth))
		{
			res.add(map.get(depth));
			depth++;
		}
		return res;
	}
	private void preOrderTraversal(TreeNode root, HashMap<Integer, Integer> map, int level){
		if(root == null)
			return;
		map.put(level, root.val);//注意这个顺序，level应该作为是key，而root.val才是value
		preOrderTraversal(root.left, map,level+1);
		preOrderTraversal(root.right, map, level+1);
	}
}

public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if(root == null) {
			return res;
		}
		helper(root, 0, res);
		return res;
	}
	private void helper(TreeNode root, int level, List<Integer> res) {
		if(root == null) {
			return;
		}
		if(res.size() == level) {
			res.add(root.val);
		}
		helper(root.right, level + 1, res);
		helper(root.left, level + 1, res);
	}
}



















