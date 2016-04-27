//preorder
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        helper(res, root);
        return res;
    }
    private void helper(ArrayList<Integer> res, TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	res.add(root.val);
    	helper(res, root.left);
    	helper(res, root.right);
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode temp = stack.pop();
        	res.add(temp.val);
        	if(temp.right != null) {
        		stack.push(temp.right);
        	}
        	if(temp.left != null) {
        		stack.push(temp.left);
        	}
        }
        return res;
    }
}
//inorder
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        helper(res, root);
        return res;
    }
    private void helper(ArrayList<Integer> res, TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	helper(res, root.left);
    	res.add(root.val);
    	helper(res, root.right);
    }
}
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()) {
        	while(root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	TreeNode temp = stack.pop();
        	res.add(temp.val);
        	root = temp.right;
        }
        return res;
    }
}
//postorder
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        helper(res, root);
        return res;
    }
    private void helper(ArrayList<Integer> res, TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	helper(res, root.left);
    	helper(res, root.right);
    	res.add(root.val);
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode cur = null;
        stack.push(root);
        while(!stack.isEmpty()) {
        	cur = stack.peek();
        	if(prev == null || prev.left == cur || prev.right == cur) {
        		if(cur.left != null) {
        			stack.push(cur.left);
        		}
        		else if(cur.right != null) {
        			stack.push(cur.right);
        		}
        	}
        	else if(cur.left == prev) {
        		if(cur.right != null) {
        			stack.push(cur.right);
        		}
        	}
        	else {
        		stack.pop();
        		res.add(cur.val);
        	}
        	prev = cur;
        }
        return res;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null) {
        	return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	TreeNode temp = stack.pop();
        	res.add(temp.val);
        	if(temp.left != null) {
        		stack.push(temp.left);
        	}
        	if(temp.right != null) {
        		stack.push(temp.right);
        	}
        }
        Collections.reverse(res);
        return res;
    }
}
//level order
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
        	return res;
        }
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, ArrayList<ArrayList<Integer>> res, int level) {
    	if(root == null) {
    		return;
    	}
    	if(level == res.size()) {
    		res.add(new ArrayList<Integer>());
    	}
    	res.get(level).add(root.val);
    	helper(root.left, res, level + 1);
    	helper(root.right, res, level + 1);
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
        	return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.size() != 0) {
        	int size = queue.size();
        	ArrayList<Integer> temp = new ArrayList<Integer>();
        	for(int i = 0; i < size; i++) {
        		TreeNode cur = queue.poll();
        		temp.add(cur.val);
        		if(cur.left != null) {
        			queue.offer(cur.left);
        		}
        		if(cur.right != null) {
        			queue.offer(cur.right);
        		}
        	}
        	res.add(temp);
        }
        return res;
    }
}

//zigzag traversal
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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean toLeft = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if(cur.left != null) {
                    queue.offer(cur.left);
                }
                if(cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if(toLeft) {
                res.add(temp);
                toLeft = false;
            }
            else {
                Collections.reverse(temp);
                res.add(temp);
                toLeft = true;
            }
        }
        return res;
    }
}
