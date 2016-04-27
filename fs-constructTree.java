public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
        	return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
    	if(inStart > inEnd || postStart > postEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(postorder[postEnd]);
    	int index = 0;
    	for(int i = inStart; i <= inEnd; i++) {
    		if(inorder[i] == root.val) {
    			index = i;
    			break;
    		}
    	}
    	int length = index - inStart;
    	root.left = helper(inorder, inStart, index - 1, postorder, postStart, postStart + length - 1);
    	root.right = helper(inorder, index + 1, inEnd, postorder, postStart + length,postEnd - 1);
    	return root;
    }
}


public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
        	return null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer, Integer> map) {
    	if(preStart > preEnd || inStart > inEnd) {
    		return null;
    	}
    	TreeNode root = new TreeNode(preorder[preStart]);
    	int index = map.get(root.val);
    	int length = index - inStart;
    	root.left = helper(preorder, preStart + 1, preStart + length, inorder, inStart, index - 1, map);
    	root.right = helper(preorder, preStart + length + 1, preEnd, inorder, index + 1, inEnd, map);
    	return root;
    }
}