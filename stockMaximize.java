// Problem Statement

// Your algorithms have become so good at predicting the market that you now know what the share price of Wooden Orange Toothpicks Inc. (WOT) will be for the next N days.

// Each day, you can either buy one share of WOT, sell any number of shares of WOT that you own, or not make any transaction at all. What is the maximum profit you can obtain with an optimum trading strategy?

// Input

// The first line contains the number of test cases T. T test cases follow:

// The first line of each test case contains a number N. The next line contains N integers, denoting the predicted price of WOT shares for the next N days.

// Output

// Output T lines, containing the maximum profit which can be obtained for the corresponding test case.

// Constraints

// 1 <= T <= 10 
// 1 <= N <= 50000

// All share prices are between 1 and 100000

// Sample Input

// 3
// 3
// 5 3 2
// 3
// 1 2 100
// 4
// 1 3 1 2
// 我们还是画出股票价格走势图，分析递增区间，递减区间，波峰，波谷这些特殊的位置。因为可以连续的每天买入股票（注意只能一天买入one share）。
// 先分析递增区间，我们要想达到maximal profit, 一定是不断的买入最后在峰值卖出这样才能有最大profit, 
// 相当于假设最大值前面有k个递增序列，最大值为m, 则相当于不断的再累加 (m-k1), (m-k2), (m-k3), …… 一共k个。
// 分析递减区间，我们也可以举具体的数据例子，递减区间上其实我们也可以买进股票，因为只要再次出现波峰时，
// 且该波峰比刚开始递减时要大，那么根据上面的计算式，我们的累加的子式子也都是大于0的，
// 因此可以保证不断累加正值，使得max profit更大。但是如果再次出现波峰时，该波峰的位置没有刚递减时大，
// 如下图所示：那实际上该买入的位置应该是从递减区间中和下一个波峰平行的位置处开始买入，
// 这样之后再次到达波峰时可以得到一段最大max profit有了上面分析后，我们意识到我们需要预知下一个波峰的具体值到底是多少，
// 这样才能决定当前处于的递减区间上要不要进行买入，这就意味着我们正向forward遍历数组会有问题，每个元素遍历的次数增加了。因此，我们考虑从end到start, backward来遍历。
// 从end开始backward遍历时，如果是一个递增区间（正着走过来则是递减区间），
// 那么我们不应该进行transaction或者说profit为0. 直到出现了a[j-1]<a[j]时，意味着递增区间结束了，a[j]到达波峰，
// 我们维护一个全局的峰值crtMax, 之后的值a[i]只要小于a[j], 都可以进行a[j]-a[i]的累加（就想上面正着走在递增区间时一样）。
// 当走到某一个递增区间（正着走过来是递减区间）如上图所示时，如果此时元素值大于crtMax了，理论上我们就不该再累加值了，且此时我们要更新一下这个全局crtMax了。
// 同理，继续往回走看能否继续走到一个新的全局波峰



public class Solution {
    public static long maxProfit(int[] arr) {
        if(arr == null || arr.length < 2) {
            return 0;
        }
        int length = arr.length;
        long maxProfit = 0;
        int global = arr[length - 1];
        for(int i = length - 2; i >= 0; i--) {
            if(arr[i] >= arr[i + 1]) {
                if(arr[i] > global) {
                    global = Math.max(global, arr[i]);
                }
                else {
                    maxProfit += global - arr[i];
                }
            }
            else {
                maxProfit += global - arr[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int numTestCase = Integer.parseInt(in.nextLine());
        for(int i = 0; i < numTestCase; i++){
            int numDays = Integer.parseInt(in.nextLine());
            int[] arr = new int[numDays];
            String[] prices = in.nextLine().split(" ");
            for(int j = 0; j < arr.length; j++){
                arr[j] = Integer.parseInt(prices[j]);
            }
            System.out.println(maxProfit(arr));
        }
    }
}