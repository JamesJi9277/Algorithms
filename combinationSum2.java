// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Have you met this question in a real interview? Yes
// Example
// For example, given candidate set 10,1,6,7,2,1,5 and target 8,
//
// A solution set is:
// 
// [1,7]
//
// [1,2,5]
//
// [2,6]
//
// [1,1,6]
//
// Note
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();

        if(candidates == null || candidates.length == 0) {
          return res;
        }
        Arrays.sort(candidates);
        helper(candidates, res, temp, target, 0);
        return res;
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> temp, int target, int index) {
      if(target < 0) {
        return;
      }
      if(target == 0) {
        res.add(new ArrayList<Integer>(temp));
        return;
      }
      //因为说可以用重复的元素，但是为了避免重复的解，所以说我在for循环的时候，用到了跟subsetII一样的剪枝的手段
      //其实这个题也是subsetII的一个变种，我们的返回条件是target < 0和target == 0，不同的就是在target < 0的时候，
      //我是直接来返回，做的是一个剪枝处理，同时也避免了stack overflow，但是当target == 0的时候，这是我需要的一个解，我就可以直接将这个满足条件的解加入到res里面
      for(int i = index; i < candidates.length; i++) {
        if(i != index && candidates[i] == candidates[i - 1]) {
          continue;
        }
        temp.add(candidates[i]);
        helper(candidates, res, temp, target - candidates[i], i+1);
        temp.remove(temp.size() - 1);
      }
    }
}
