// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Have you met this question in a real interview? Yes
// Example
// Given an example [4,4,6,1,1,4,2,5], return 6.

// Note
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//这一题跟买卖股票1不一样的是，最多只能够进行两次交易，也就是说我需要找到两个差距最大的空间或者说找到一个差距最大的空间也行
//首先想到的是先考虑进行一次买卖来维护一个最大值
//
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length < 2) {
        	return 0;
        }
        int oneTimeProfit = oneTime(prices,0, prices.length - 1);
        int twoTimeProfit = twoTime(prices);
        return Math.max(oneTimeProfit, twoTimeProfit);
    }
    private int oneTime(int[] prices,int start, int end) {
    	if(start >= end) {
    	    return 0;
    	}
    	int min = prices[start];
    	int res = 0;
    	for(int i = start + 1; i <= end; i++) {
    		res = Math.max(res, prices[i] - min);
    		if(prices[i] < min) {
    			min = prices[i];
    		}
    	}
    	return res;
    }
    private int twoTime(int[] prices) {
    	int max = 0;
    	for(int index = 0; index < prices.length; index++) {
    		max = Math.max(max, oneTime(prices, 0, index) + oneTime(prices, index , prices.length - 1));
    	}
    	return max;
    }
};


//开始考虑优化的问题，因为上一个程序之所以超时是因为子函数多次重复计算
//所以考虑利用动态规划来减少重复计算
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int length = prices.length;
        int[] front = new int[length];
        int[] end = new int[length];
        front[0] = 0;
        end[length - 1] = 0;
        int min = prices[0];
        int max = prices[length - 1];
        for(int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            front[i] = Math.max(front[i - 1], prices[i] - min);
        }
        for(int i = length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            end[i] = Math.max(end[i + 1], max - prices[i]);
        }
        int res = 0;
        for(int i = 0; i < length; i++) {
            res = Math.max(res, front[i] + end[i]);
        }
        return res;
    }
}

//简化后的代码
//因为我可以在一天内进行多次买卖只不过买卖的前提是必须得先进行一次买卖之后再进行下一次，也就是说不能够进行连续买入或者卖出，
// 所以说这个题我进行正反双向遍历，找的都是在第i天以i天卖出的最大利润，之所以要进行正反两次遍历，目的就是为了使买卖不重复，但是又可以使买卖在同一天进行，也就是所说的第i天的最大利润
// 不同之处是在于我从正向遍历的时候，我需要找的是min，然后通过prices[i]与min的差值来得到profit，
// 在反向遍历的时候，相当于是我已经知道了结果，所以我要维护的是一个max，然后通过max - prices[i]来找刀maxProfit
// 然后有一个减少判断次数的优化方法就是我不需要每一次都去比较min或者max，
// 正向的时候，当只有prices[i] < prices[i - 1]的时候才可能更新min
// 同理，当反向的时候，只有prices[i - 1] > prices[i]的时候，才可能更新max
//简单来说正向存的是当前点往左看的最好结果，反向存的是当前点往右看的最好结果
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int length = prices.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        
        int min = prices[0];
        leftMax[0] = 0;
        for(int i = 1; i < length; i++) {
            min = Math.min(min, prices[i]);
            leftMax[i] = Math.max(prices[i] - min, leftMax[i - 1]);
        }
        
        int max = prices[length - 1];
        rightMax[length - 1] = 0;
        for(int i = length - 2; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            rightMax[i] = Math.max(max - prices[i], rightMax[i + 1]);
        }
        
        int res = 0;
        for(int i = 0; i < length; i++) {
            res = Math.max(res, leftMax[i] + rightMax[i]);
        }
        return res;
    }
}
