// Given a list of integers, which denote a permutation.
//
// Find the next permutation in ascending order.
//
// Have you met this question in a real interview? Yes
// Example
// For [1,3,2,3], the next permutation is [1,3,3,2]
//
// For [4,3,2,1], the next permutation is [1,2,3,4]
//
// Note
// The list may contains duplicate integers.
// 找下一个升序排列，C++ STL 源码剖析一书中有提及，Permutation 一小节中也有详细介绍，下面简要介绍一下字典序算法：
//
// 从后往前寻找索引满足 a[k] < a[k + 1], 如果此条件不满足，则说明已遍历到最后一个。
// 从后往前遍历，找到第一个比a[k]大的数a[l], 即a[k] < a[l].
// 交换a[k]与a[l].
// 反转k + 1 ~ n之间的元素。
// 由于这道题中规定对于[4,3,2,1], 输出为[1,2,3,4], 故在第一步稍加处理即可。
//时间复杂度On，空间O1
public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return nums;
        }
        //int[] res = new int[nums.length];
        if(nums.length == 1) {
            return nums;
        }
        int i = 0;
        //对于重复元素，只要在判断大小的时候不取等号即可
        for(i = nums.length - 2; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {
                break;
            }
            else if(i == 0) {
              //这里直接反转即可返回答案，跟permutationII不一样
                doReverse(nums, 0, nums.length - 1);
                return nums;
            }
        }

        int j = 0;
        for(j = nums.length - 1; j > i; j--) {
            if(nums[j] > nums[i]) {
                break;
            }
        }

        doSwap(nums, i, j);
        doReverse(nums, i + 1, nums.length - 1);
        return nums;
    }
    private void doReverse(int[] nums, int start, int end) {
        for(int i = 0; start + i < end - i; i++) {
            int temp = nums[start + i];
            nums[start + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
