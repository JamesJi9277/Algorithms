public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)) {
            return countNode(root);
        }
        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);
        return Math.max(left, right);
    }
    private boolean isValidBST(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }
        if(!((long)root.val > min && (long)root.val < max)) {
            return false;
        }
        return isValidBST(root.left, min, (long)root.val) && isValidBST(root.right, (long)root.val, max);
    }
    private int countNode(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        int left = countNode(root.left);
        int right = countNode(root.right);
        return left + right + 1;
    }
}


public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int[] res = recursive(root);
        return res[2];
    }
    private int[] recursive(TreeNode root) {
        int[] res = new int[5];
        res[0] = 1;
        res[3] = Integer.MAX_VALUE;
        res[4] = Integer.MIN_VALUE;
        //0-whether BST, 1-number of nodes, 2-maxNode,3-max, 4-min
        if(root == null) {
            return res;
        }
        int[] resL = recursive(root.left);
        int[] resR = recursive(root.right);
        if(resL[0] == 0 || resR[0] == 0 || resL[4] > root.val || root.val > resR[3]) {
            res[0] = 0;
        }
        res[1] = resL[1] + resR[1] + 1;
        res[2] = (res[0] > 0) ? res[1] : Math.max(resL[2], resR[2]);
        res[3] = Math.min(root.val, Math.min(resL[3], resR[3]));
        res[4] = Math.max(root.val, Math.max(resL[4], resR[4]));
        return res;
    }
}