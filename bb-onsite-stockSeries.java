//只允许交易一次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
//可以交易任意次
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
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
//只能交易两次
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