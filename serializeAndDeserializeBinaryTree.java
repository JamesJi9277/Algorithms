//在进行serialize时，因为要保存root信息，我们可以选用前序遍历或者是BFS
//serialize的过程如下
      1
     /  \
    2    3
     \   /     
      4 5     
     / \
    6   7

[Thoughts]
一个比较简单直接的做法是，通过前序遍历来做，把所有空节点当做“#”来标示。那么这棵树可以表示为
      1
     /   \
    2        3
   /  \      / \    
  #   4     5   #  
     / \    /\
    6   7  #  #
   / \ / \
  #   ##  #

那么前序遍历的结果就是： {'1','2','#','4','6','#','#','7','#','#','3','5','#','#','#'}
具体参见lintcode原题
///////

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
        if(root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp != null) {
                    sb.append(temp.val);
                    sb.append(" ");
                }
                else {
                    sb.append("#");
                    sb.append(" ");
                }
                if(temp != null) {
                    queue.offer(temp.left);
                    queue.offer(temp.right);
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
        // write your code here
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
                TreeNode right = new TreeNode(Integer.parseInt(str[i + 1]));
                temp.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }
}



///////
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;  
  
public class BinaryTreeSerialize {  
  
   
 public static class TreeNode  
 {  
  int val;  
  TreeNode left;  
  TreeNode right;  
  TreeNode(int val)  
  {  
   this.val=val;  
  }  
 }  

  // Iterative solution  
 public ArrayList<String> preorderSerialize(TreeNode root) {
		ArrayList<String> res = new ArrayList<String>();
		if(root == null) {
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			res.add(temp.val + "");
			if(temp.right != null) {
				stack.push(temp.right);
			}
			if(temp.left != null) {
				stack.push(temp.left);
			}
			if(temp.right == null) {
				res.add("#");
			}
			if(temp.left == null) {
				res.add("#");
			}
		}
		return res;
	}
 
 public ArrayList<String> preorderRecursive(TreeNode root) {
	 ArrayList<String> res = new ArrayList<String>();
	 doTraverse1(res, root);
	 return res;
 }
 private void doTraverse1(ArrayList<String> res, TreeNode root) {
	 if(root == null) {
		 res.add("#");
	 }
	 else{
		 res.add(root.val + "");
		 doTraverse1(res, root.left);
		 doTraverse1(res, root.right);
	 }
 }
 
 public ArrayList<String> postorderRecursive(TreeNode root) {
	 ArrayList<String> res = new ArrayList<String>();
	 doTraverse2(res, root);
	 //doReverse(res);
	 return res;
 }
 private void doTraverse2(ArrayList<String> res, TreeNode root) {
	 if(root == null) {
		 res.add("#");
	 }
	 else{
		 doTraverse2(res, root.left);
		 doTraverse2(res, root.right);
		 res.add(root.val + "");
	 }
 }
 private void doReverse(ArrayList<String> res) {
	 int start = 0;
	 int end = res.size() - 1;
	 for(int i = 0; start + i < end - i; i++) {
		 String temp = res.get(start + i);
		 res.set(start + i, res.get(end - i));
		 res.set(end - i, temp);
	 }
	 return;
 }
 
 public ArrayList<String> bfsSerialize(TreeNode root) {
	 Queue<TreeNode> queue = new LinkedList<TreeNode>();
	 ArrayList<String> res = new ArrayList<String>();
	 if(root == null) {
		 return res;
	 }
	 else {
		 queue.offer(root);
		 while(!queue.isEmpty()) {
			 int size = queue.size();
			 for(int i = 0; i < size; i++) {
				 TreeNode node = queue.poll();
				 res.add(node.val + "");
				 if(node.left != null) {
					 queue.offer(node.left);
				 }
				 else {
					 res.add("#");
				 }
				 if(node.right != null) {
					 queue.offer(node.right);
				 }
				 else {
					 res.add("#");
				 }
			 }
	 }
	 }
	 return res;
 }
 
 public String serialize(TreeNode root) {
     // write your code here
     StringBuffer sb = new StringBuffer();
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     if(root == null) {
         return sb.toString();
     }
     else {
    	 queue.offer(root);
         while(!queue.isEmpty()) {
             int size = queue.size();
             for(int i = 0; i < size; i++) {
                 TreeNode node = queue.poll();
                 sb.append(node.val);
                 if(node.left != null) {
                     queue.offer(node.left);
                 }
                 else {
                     sb.append("#");
                 }
                 if(node.right != null) {
                     queue.offer(node.right);
                 }
                 else {
                     sb.append("#");
                 }
             }
     }
     }
     return sb.toString();
 }
 
 public static void main(String[] args)  
 {  
	 BinaryTreeSerialize bi=new BinaryTreeSerialize();  
  // Creating a binary tree  
  TreeNode rootNode=createBinaryTree();  
  System.out.println("-------------------------");  
  System.out.println("Using DFS(Preorder) solution:");  
  ArrayList<String> res = bi.preorderSerialize(rootNode);
  for(int i = 0; i < res.size(); i++) {
	  System.out.print(res.get(i) + " ");
  }
  System.out.println(" ");
  System.out.println("-------------------------");  
  System.out.println("Using BFS solution:");  
  ArrayList<String> res1 = bi.bfsSerialize(rootNode);
  for(int i = 0; i < res1.size(); i++) {
	  System.out.print(res1.get(i) + " ");
  }
  
  System.out.println(" ");
  System.out.println("-------------------------");  
  System.out.println("Using recursive preorder solution:");  
  ArrayList<String> res2 = bi.preorderRecursive(rootNode);
  for(int i = 0; i < res2.size(); i++) {
	  System.out.print(res2.get(i) + " ");
  }
  
  System.out.println(" ");
  System.out.println("-------------------------");  
  System.out.println("Using recursive postorder solution:");  
  ArrayList<String> res3 = bi.postorderRecursive(rootNode);
  for(int i = 0; i < res3.size(); i++) {
	  System.out.print(res3.get(i) + " ");
  }
  
  System.out.println(" ");
  System.out.println("-------------------------"); 
  System.out.println(bi.serialize(rootNode));
 }  
   
 public static TreeNode createBinaryTree()  
 {  
    
  TreeNode rootNode =new TreeNode(40);  
  TreeNode node20=new TreeNode(20);  
  TreeNode node10=new TreeNode(10);  
  TreeNode node30=new TreeNode(30);  
  TreeNode node60=new TreeNode(60);  
  TreeNode node50=new TreeNode(50);  
  TreeNode node70=new TreeNode(70);  
    
  rootNode.left=node20;  
  rootNode.right=node60;  
    
  node20.left=node10;  
  node20.right=node30;  
    
  node60.left=node50;  
  node60.right=node70;  
    
  return rootNode;  
 }  
}  
