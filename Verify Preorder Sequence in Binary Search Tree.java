// Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.

// You may assume each number in the sequence is unique.
//利用到了递归
// 1.先找到一个比start大的数，记录下这个index，那么就可以将原来的树分成左右子树
// 2.在为了防止右子树中还有下降的元素，找到第一个比index 为start大的元素后，还要遍历index++到end之间的元素,如果发现有比nums[start]小的，就return false
// 3.然后分别对左右子树进行递归函数调用来判断
//时间复杂度，因为每次遍历找到第一个增加的数的时间是On，每次逐个递归的时间复杂度是Ologn，所以总共的时间复杂度是Onlogn
//空间复杂度是Ologn
public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
        	return true;
        }
        return verify(preorder, 0, preorder.length - 1);
    }
    private boolean verify(int[] preorder, int start, int end) {
    	if(start >= end - 1) {
    		return true;
    	}
    	int index = start + 1;
    	while(index <= end) {
    		if(preorder[index] > preorder[start]) {
    			break;
    		}
    		index++;
    	}
    	for(int i = index; i <= end; i++) {
    		if(preorder[i] < preorder[start]) {
    			return false;
    		}
    	}
    	return verify(preorder, start + 1, index - 1) && verify(preorder, index, end);
    }
}


//space, On.利用stack来模拟递归的过程,time On
public class Solution {
	public boolean verifyPreorder(int[] preorder) {
		if(preorder == null || preorder.length == 0 || preorder.length == 1) {
			return true;
		}
		int length = preorder.length;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(preorder[0]);
		int curRoot = Integer.MIN_VALUE;//防止一开始就是单调递减的数组
		for(int i = 1; i < length; i++) {
			if(preorder[i] < stack.peek()) {
				//如果是比peek小的话，就不断地push进栈，curRoot暂时不更新，如果是遇到比curRoot还要小的话，那么就要返回false
				//因为BST的性质决定了我在找到下一个right node节点之前，这个之间的都是右子树，右子树的值都大于root，这样子是一个是否valid的判断条件
				if(preorder[i] < curRoot) {
					return false;
				}
				//不断地把右子树的node压入栈
				stack.push(preorder[i]);
				continue;
			}
			//当遇到right node的时候，我就要更新root，因为之前一个root是我在栈底的元素，所以说我要不断地pop出来，最后将新的root压入栈
			else {
				//更新root
				while(!stack.isEmpty() && preorder[i] > stack.peek()) {
					curRoot = stack.peek();
					stack.pop();
				}
				stack.push(preorder[i]);
			}
		}
		return true;
	}
}

// Follow up:
// Could you do it using only constant space complexity?
public class Solution {
	public boolean verifyPreorder(int[] preorder) {
		if(preorder == null || preorder.length == 0) {
			return true;
		}
		int lowerBound = Integer.MIN_VALUE;
		int i = -1;
		for(int p : preorder) {
			if(p < lowerBound) {
				return false;
			}
			while(i >= 0 && p > preorder[i]) {
				lowerBound = preorder[i--];
			}
			preorder[++i] = p;
		}
		return true;
	}
}