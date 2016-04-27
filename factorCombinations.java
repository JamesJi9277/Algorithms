// Numbers can be regarded as product of its factors. For example,

// 8 = 2 x 2 x 2;
//   = 2 x 4.
// Write a function that takes an integer n and return all possible combinations of its factors.

// Note: 
// Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
// You may assume that n is always positive.
// Factors should be greater than 1 and less than n.
// Examples: 
// input: 1
// output: 
// []
// input: 37
// output: 
// []
// input: 12
// output:
// [
//   [2, 6],
//   [2, 2, 3],
//   [3, 4]
// ]
// input: 32
// output:
// [
//   [2, 16],
//   [2, 2, 8],
//   [2, 2, 2, 4],
//   [2, 2, 2, 2, 2],
//   [2, 4, 4],
//   [4, 8]
// ]
//time Onlogn
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        if(n < 3) {
          return res;
        }
        helper(res, temp, n, 2);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> temp, int n, int start) {
      if(n == 1) {
        if(temp.size() > 1) {
          res.add(new ArrayList<Integer>(temp));
        }
        return;        
      }
      for(int i = start; i <= n; i++) {//这里加上等于号是因为有可能出现平方数，2*2，如果没有等号，4的下一个循环就是2，i = 2, i < 2，
        //这样子就不会进行循环从而漏掉[2, 2]这个解
        if(n % i == 0) {
          temp.add(i);
          helper(res, temp, n / i, i);
          temp.remove(temp.size() - 1);
        }
      }
    }
}