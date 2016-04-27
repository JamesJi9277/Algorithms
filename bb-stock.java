只许买卖一次，求最大利润
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) {
        	return 0;
        }
        int max = 0;
        int length = prices.length;
        for(int i = 0; i < length; i++) {
        	for(int j = i + 1; j < length; j++) {
        		max = Math.max(max, prices[j] - prices[i]);
        	}
        }
        return max;
    }
}
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