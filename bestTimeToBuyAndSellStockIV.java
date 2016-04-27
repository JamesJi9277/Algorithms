// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most k transactions.

// Have you met this question in a real interview? Yes
// Example
// Given prices = [4,4,6,1,1,4,2,5], and k = 2, return 6.

// Note
// You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

// Challenge
// O(nk) time.
// First of all, we need to be clear of the definition of transaction. 
// The first question in this series clearly states that "...one transaction (ie, buy one and sell one share of the stock)". 
// Therefore, the whole period from buying to selling is considered one transaction, not two. To avoid confusion, 
// I'll define 'buying' and 'selling' as an 'Operation'.

// Secondly, when it says 'unlimited number of transaction', 
// the number of possible transactions actually have nothing to do with the length of the array in theory. 
// The problem does not prohibit buying and selling on the same day, nor does it say anything about how many operations you can do on one day. 
// So technically, it is wrong to say that you can ONLY perform n/2 transaction; As a matter of fact, 
// you can perform an infinite number of transaction (achievable by buying and selling multiple times on the same day).

// But doing that is pointless because we don't earn any money that way. 
// So what really matters to us is the number of 'MEANINGFUL TRANSACTIONS' in which we actually earns money. 
// That is to say, the transaction must include AT LEAST ONE RISING phase 
// (Otherwise, we are losing money so we might as well not do the transaction at all). In an array of size N. 
// There are at most N/2 rising phases. So we need at most k = N/2 transactions to cover all the rising phases. 
// Therefore, if even more than N/2 transactions are allowed, we only need N/2 transactions to achieve the maximum profit.
//  That's why we k is greater than N/2, we can effectively consider it to be "unlimited"
//这题没思路，直接参考的九章答案
//需要注意的地方就是当我k >= length/2的时候，就相当于我可以进行无数次的买卖，这样就跟II一样了，直接用贪心法可以求解
//当k没有达到length/2的时候，我就需要用到二位DP来做
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k < 1 || prices == null || prices.length < 2) {
            return 0;
        }
        if(k >= prices.length /2) {
            return greedy(prices);
        }
        int length = prices.length;
        //mustsell 表示前i天至多进行j次交易，并且第i天必须sell来获得最大利润
        int[][] mustSell = new int[length + 1][length + 1];
        //global 表示前i天至多进行j次交易，并且第i天可以不需要sell来获取最大利润
        int[][] global = new int[length + 1][length + 1];
        mustSell[0][0] = 0;
        global[0][0] = 0;
        for(int i = 1; i <= k; i++) {
            mustSell[0][i] = 0;
            global[0][i] = 0;
        }
        for(int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            mustSell[i][0] = 0;
            for(int j = 1; j <= k; j++) {
                mustSell[i][j] = Math.max(global[i - 1][j - 1] + diff, mustSell[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], mustSell[i][j]);
            }
        }
        return global[length - 1][k];
    }
    private int greedy(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i + 1] > nums[i]) {
                max += (nums[i + 1] - nums[i]);
            }
        }
        return max;
    }
}
