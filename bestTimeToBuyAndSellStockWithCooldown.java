Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

public class Solution {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2) {
			return 0;
		}
		int length = prices.length;
		int[] maxProfit = new int[length];
		maxProfit[0] = 0;
		maxProfit[1] = Math.max(0, prices[1] - prices[0]);
		int buy = Math.max(0 - prices[0], 0 - prices[1]);
		for(int i = 2; i < length; i++) {
			maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] + buy);
			buy = Math.max(buy, maxProfit[i - 2] - prices[i]);
		}
		return maxProfit[length - 1];
	}
}