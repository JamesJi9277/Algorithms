// Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
//
// Have you met this question in a real interview? Yes
// Example
// Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]
//
// Challenge
// O(nlogn) time
//On2，遍历数组两次，一次是找到minDiff，第二次是找出产生minDiff的区间，然后返回区间即可
//但是会TLE，所以考虑到优化
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length == 0) {
          return res;
        }
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
          int sum = 0;
          for(int j = i; j < nums.length; j++) {
            sum += nums[j];
            minDiff = Math.min(minDiff, Math.abs(sum));
          }
        }
        for(int i = 0; i < nums.length; i++) {
          int target = 0;
          for(int j = i; j < nums.length; j++) {
            target += nums[j];
            if(Math.abs(target) == minDiff) {
              res.add(i);
              res.add(j);
              return res;
            }
          }
        }
        return null;
    }
}
//在On2上的优化，将比较次数减少到一次，利用到set而不是最后找到解，将解add上去,只不过这种做法
//需要去初始化res，不然就会报错

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(nums == null || nums.length == 0) {
          return res;
        }
        //如果不进行这个初始化的步骤的话，就会报错
        res.add(0);
        res.add(0);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
          int sum = 0;
          for(int j = i; j < nums.length; j++) {
            sum += nums[j];
            if(Math.abs(sum) < minDiff) {
              minDiff = Math.abs(sum);
              res.set(0, i);
              res.set(1, j);
            }
            return res;
          }
        }
        return null;
    }
}
//O(nlogn)，用到了前缀和数组，
// 既然不能直接focus在subarray上通过双指针维护同向sliding window来找到subarray,
// 我们就通过prefix sum来间接找到这个subarray.
// 首先，我们可以得到一个前缀和prefix sum数组，记录了B[j]表示原始数组中【0,j】区间内的元素和比如为[-3, 4, 3, 1, 5]，
// 根据题目提示O(nlogn)的时间复杂度，我们可以先考虑对prefix sum数组进行一个排序，
// 此时结果为[-3, 1, 3, 4, 5], 我们要找的是subarray sum closest,
// 实际上就转化为了我们先找到两个连续的且差值最小的前缀和，
// 然后他们所对应的index之间即为subarray的区间。
// 比如，上面的例子，最小的差值可以是3和4，也可以是4和5，
// 根据排序前的情况B[2] = 3也就是原始数组的index 0, 1, 2三个元素的和是3，
// B[1] = 4也就是原始数组的index 0, 1两个元素的和是4,
// 那么subarray的区间就是[1+1, 2]也即[2]类似这样的一个过程。
// 注意：还是有特殊情况，比如原始数组为[1,-1]的情况，
// 因此我们的前缀和数组要比原始数组多一个空间，存放最初的sum为0的情况，
// 且要预置sum为0, Index为-1的情况再HashMap中。

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        if(nums == null || nums.length == 0) {
            return res;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        int[] prefixSum = new int[nums.length + 1];
        //corner case,对于比如[-1, 1]的处理
        prefixSum[0] = 0;
        temp.add(-1);
        map.put(prefixSum[0], temp);

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
          sum += nums[i];
          prefixSum[i + 1] = sum;
          if(map.containsKey(sum)) {
            map.get(sum).add(i);
          }
          else {
            temp = new ArrayList<Integer>();
            temp.add(i);
            map.put(sum, temp);
          }
        }
        Arrays.sort(prefixSum);
        int minDiff = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int i = 0, j = 1;
        while(j < nums.length + 1) {
          if(prefixSum[j] - prefixSum[i] <= minDiff) {
            minDiff = prefixSum[j] - prefixSum[i];
            left = i;
            right = j;
          }
          i = j;
          j = j + 1;
        }
        int temp1 = Math.min(map.get(prefixSum[left]).get(0), map.get(prefixSum[right]).get(0));
        int temp2 = Math.max(map.get(prefixSum[left]).get(0), map.get(prefixSum[right]).get(0));
        //排序后两个连续差值最小的前缀和相等的时候，就取该前缀和的两个数作为index
        if(prefixSum[left] == prefixSum[right]) {
          temp1 = Math.min(map.get(prefixSum[left]).get(0), map.get(prefixSum[right]).get(0));
          temp2 = Math.max(map.get(prefixSum[left]).get(0), map.get(prefixSum[right]).get(0));
        }
        res.add(temp1 + 1);
        res.add(temp2);
        return res;
    }
}
