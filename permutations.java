// 以状态数来分析，最终全排列个数应为 n!n!, 每个节点被遍历的次数为 (n-1)!(n−1)!, 故节点共被遍历的状态数为 O(n!)O(n!),
// 此为时间复杂度的下界，因为这里只算了合法条件下的遍历状态数。若不对 list 中是否包含 nums[i] 进行检查，则总的状态数应为 n^nn
// ​n
// ​​  种。
//
// 由于最终的排列结果中每个列表的长度都为 n, 各列表的相同元素并不共享，故时间复杂度的下界为 O(n \cdot n!)O(n⋅n!), 上界为 n \cdot n^nn⋅n
// ​n
// ​​实测helper中 for 循环的遍历次数在 O(2n \cdot n!)O(2n⋅n!) 以下，注意这里的时间复杂度并不考虑查找列表里是否包含重复元素。

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(nums == null || nums.size() == 0) {
            return res;
        }
        findPermutation(nums, res,  temp);
        return res;
    }
    private void findPermutation(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res,  ArrayList<Integer> temp) {
        if(temp.size() == nums.size()) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
            if(temp.contains(nums.get(i))) {
                continue;
            }
            //如果不用contains的话那么就需要一个boolean数组来标记
            temp.add(nums.get(i));
            findPermutation(nums, res,  temp);
            temp.remove(temp.size() - 1);
        }



for(int i = 0; i < nums.size(); i++) {
            if(!isUsed[i]) {
                temp.add(nums.get(i));
                isUsed[i] = true;
                helper(nums, res, temp, isUsed);
                temp.remove(temp.size() - 1);
                isUsed[i] = false;
            }
        }


    }
}

//non-recursive，不断的调用next permutation的结果来迭代找到permutation
public class Solution {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    if(nums == null || nums.size() == 0) {
      return res;
    }
    if(nums.size() == 1) {
      res.add(new ArrayList<Integer>(nums));
      return res;
    }
    Collections.sort(nums);
    boolean flag = true;
    while(flag) {
      res.add(new ArrayList<Integer>(nums));
      int i = 0;
      for(i = nums.size() - 2; i >= 0; i--) {
        if(nums.get(i) < nums.get(i + 1)) {
          break;
        }
        else if(i == 0) {
          return res;
        }
      }



      int j = 0;
      for(j = nums.size() - 1; j > i; j--) {
        if(nums.get(i) < nums.get(j)) {
          break;
        }
      }

      Collections.swap(nums, i, j);

      doReverse(nums, i + 1, nums.size() - 1);
    }
    return res;
  }
  private void doReverse(ArrayList<Integer> nums, int start, int end) {
    for(int i = 0; start + i < end - i; i++) {
      int temp = nums.get(start + i);
      nums.set(start + i, nums.get(end - i));
      nums.set(end - i, temp);
    }
  }
}
