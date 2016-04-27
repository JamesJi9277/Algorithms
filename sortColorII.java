// Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
//
// Have you met this question in a real interview? Yes
// Example
// Given colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4].
//
// Note
// You are not suppose to use the library's sort function for this problem.
//
// Challenge
// A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        Arrays.sort(colors);
    }
}

//需要注意的是这里说到的颜色并没有存在0，所以说我在统计原来颜色的频率的时候，还是可以从0开始往后增加
// 来统计次数，但是我由于要将数组的下标与元素的值对应起来，所以说我在建立数组的时候，要多建立一位，但是数组的第一位是0，
// 也就是颜色是从1开始标号的。相对应的，我在进行overwrite操作的时候，i也是从1 ~ k来完成overwrite
//时间复杂度上面是two pass
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0) {
            return;
        }
        int[] res = new int[k + 1];
        for(int i = 0; i < colors.length; i++) {
            res[colors[i]]++;
        }
        int index = 0;
        for(int i = 1; i <= k; i++) {
            while(res[i] > 0) {
                colors[index++] = i;
                res[i]--;
            }
        }
    }
}

//因为是要求one pass,所以要考虑到利用递归来做，空间复杂度logn是消耗的系统栈的深度
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0) {
            return;
        }
        int leftBound = 0;
        int rightBound = colors.length - 1;
        helper(colors, leftBound, rightBound, 1, k);
        return;
    }
    private void helper(int[] colors, int leftBound, int rightBound, int start, int end) {
        if(leftBound >= rightBound) {
            return;
        }
        if(start >= end) {
            return;
        }
        int i = leftBound;
        while(i <= rightBound) {
            if(colors[i] == start) {
                doSwap(colors, i, leftBound);
                i++;
                leftBound++;
            }
            else if(colors[i] == end) {
                doSwap(colors, i, rightBound);
                rightBound--;
            }
            else {
                i++;
            }
        }
        helper(colors, leftBound, rightBound, start + 1, end - 1);
    }
    private void doSwap(int[] colors, int start, int end) {
        int temp = colors[start];
        colors[start] = colors[end];
        colors[end] = temp;
    }
}


//上面递归消耗的系统空间，所以接下来用迭代来做
class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0) {
            return;
        }
        int leftBound = 0;
        int rightBound = colors.length - 1;
        int start = 1;
        int end = k;
        while(start <= end) {
            int index = leftBound;
            while(index <= rightBound) {
                if(colors[index] == start) {
                    doSwap(colors, index, leftBound);
                    index++;
                    leftBound++;
                }
                else if(colors[index] == end) {
                    doSwap(colors, index, rightBound);
                    rightBound--;
                }
                else {
                    index++;
                }
            }
            start++;
            end--;
        }
    }
    private void doSwap(int[] nums, int i, int j) {
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
}

