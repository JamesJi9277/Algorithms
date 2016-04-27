Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

You may assume each number in the sequence is unique.

Follow up:
Could you do it using only constant space complexity?
递归
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return true;
        }
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(int[] preorder, int start, int end, int min, int max) {
        //这里的处理很重要，start > end指的已经全部判断完了在最底层慢慢return true上来
        //或者说是一开始数组为null和只有一个元素的时候，return true
        if(start > end) {
            return true;
        }
        int rootVal = preorder[start];
        if(!(rootVal > min && rootVal < max)) {
            return false;
        }
        int index = 0;
        for(index = start; index <= end; index++) {
            if(preorder[index] > rootVal) {
                break;
            }
        }
        return helper(preorder, start + 1, index - 1, min, rootVal) && helper(preorder, index, end, rootVal, max);
    }
}

非递归
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length < 2) {
            return true;
        }
        int min = Integer.MIN_VALUE;
        int j = 0;
        for(int i = 1; i < preorder.length; i++) {
            if(preorder[i] < min) {
                return false;
            }
            if(preorder[i] > preorder[i - 1]) {
                j = i - 1;
                while(j >= 0 && preorder[j] < preorder[i]) {
                    min = preorder[j];
                    preorder[j] = Integer.MAX_VALUE;
                    j--;
                }
            }
        }
        return true;
    }
}
