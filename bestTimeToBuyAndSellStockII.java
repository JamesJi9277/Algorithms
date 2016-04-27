// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

// Have you met this question in a real interview? Yes
// Example
// Given an example [2,1,2,0,1], return 2
//如果说可以买卖多次的话，那么我只需要继续下每一次的diff，进行贪心算法不断的累加到最后的结果就好了
//这个贪心的思想需要好好的掌握，或者说这题是允许当天同时卖出后再买进的
//比如我给出123，我的最大利润是2，因为第一天1买，第二天2卖，赚了1，然后同时2买，再3卖，这样子又赚了1，总利润就是2

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
            return 0;
        }
        int max = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i]) {
                max += (prices[i + 1] - prices[i]);
            }
        }
        return max;
    }
}
