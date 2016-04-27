Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.

There is no limit of how you deserialize or serialize a binary tree, you only need to make sure you can serialize a binary tree to a string and deserialize this string to the original structure.

Have you met this question in a real interview? Yes
Example
An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

  3
 / \
9  20
  /  \
 15   7
Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.

You can use other method to do serializaiton and deserialization.
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
     public String serialize(TreeNode root) {
     // write your code here
     StringBuffer sb = new StringBuffer();
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     if(root == null) {
         return sb.toString();
     }
     
    	 queue.offer(root);
         while(!queue.isEmpty()) {
             int size = queue.size();
             for(int i = 0; i < size; i++) {
                 TreeNode node = queue.poll();
                 if(node != null) {
                	 sb.append(node.val);
                	 sb.append(" ");
                 }
                 else {
                	 sb.append("#");
                	 sb.append(" ");
                 }
                 if(node != null) {
                     queue.offer(node.left);
                     queue.offer(node.right);
                 }
             }
     }
     
     return sb.toString();
 }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data == "#" || data.length() == 0) {
            return null;
        }
        data = data.trim();
        String[] strs = data.split(" ");
        int len = strs.length;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        LinkedList<TreeNode> parents = new LinkedList<TreeNode>();
        parents.add(root);
        int i = 1;
        while (i < len) {
            int size = parents.size();
            for (int j = 0; j < size; j++) {
                TreeNode temp = parents.removeFirst();
                temp.left = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                temp.right = strs[i].equals("#")? null: new TreeNode(Integer.parseInt(strs[i]));
                i++;
                if (temp.left != null)
                    parents.add(temp.left);
                if (temp.right != null)
                    parents.add(temp.right);
            }
        }
        return root;
    }
    public TreeNode deserialize(String data) {
    	if(data == null || data.length() == 0) {
    		return null;
    	}
    	data = data.trim();
    	String[] str = data.split(" ");
    	int length = str.length;
    	TreeNode root = new TreeNode(Integer.parseInt(str[0]));
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	queue.offer(root);
    	for(int i = 1; i < length; i++) {
    		TreeNode temp = queue.poll();
    		if(!str[i].equals("#")) {
    			TreeNode left = new TreeNode(Integer.parseInt(str[i]));
    			temp.left = left;
    			queue.offer(left);
    		}
    		if(!str[i + 1].equals("#")) {
    			TreeNode right = new TreeNode(Integer.parseInt(str[i+1]));
    			temp.right = right;
    			queue.offer(right);
    		}
    		i++;
    	}
    	return root;
    }
}

