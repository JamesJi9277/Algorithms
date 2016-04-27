// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Have you met this question in a real interview? Yes
// Example
// Given an example [3,2,3,1,2], return 1
// 这个题要仔细读题，题目中说的意思是你只能够完成一次买卖，意思就是说我给顶你一个数组，买卖只能够一次
// 于是我们找到数组中最大的差值即可,需要注意的是length == 1的时候，我的利润是0
//space O1, time On2，维护一个max变量
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
        	return 0;
        }
        int length = prices.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < length - 1; i++) {
        	for(int j = i; j < length; j++) {
        		max = Math.max(max, prices[j] - prices[i]);
        	}
        }
        return max;
    }
}

//在上述的过程中我们可以简化，只需要维护两个变量然后遍历数组一遍即可,
//这个思路要好好掌握，比较好，再遍历二叉树的题目的时候也会用到这种思路，
//一方面不断更新profit，一方面也不断地去找最小的prices[i]，这样子即可以保证有序性又可以找到结果
//space O1, time On
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int length = prices.length;
        for(int i = 0; i < length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
