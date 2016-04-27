// Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C unlimited number of times.
//
//
//
// For example, given candidate set 2,3,6,7 and target 7,
// A solution set is:
// [7]
// [2, 2, 3]
//
// Have you met this question in a real interview? Yes
// Example
// given candidate set 2,3,6,7 and target 7,
// A solution set is:
// [7]
// [2, 2, 3]
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
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        //可以不加下面这个判断，加上之后可以让程序运行的更快
        if(i != index && candidates[i] == candidates[i - 1]) {
          continue;
        }
        temp.add(candidates[i]);
        helper(candidates, res, temp, target - candidates[i], i);
        temp.remove(temp.size() - 1);
      }
    }
}

//我的helper函数里面这样写也可以，虽然这样花的时间要多一些，只涉及到了一次剪枝处理
//但是在程序简单上会好很多，不需要去判断target < 0的情况，直接融合到了去判断candidates[i] <= target
//即可，然后就是也不需要去判断有没有重复解
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<Integer>();
        helper(candidates, res, temp, target,0);
        return res;
    }
    private void helper(int[] candidates, List<List<Integer>> res,List<Integer> temp, int target,int index) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = index; i< candidates.length; i++) {
            if(i != index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            helper(candidates, res, temp, target - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}