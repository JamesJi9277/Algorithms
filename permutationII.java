class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code heres
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(nums == null || nums.size() == 0) {
            return res;
        }
        Collections.sort(nums);
        int[] isVisited = new int[nums.size()];
        findPermute(nums, res, temp, isVisited);
        return res;
    }
    private void findPermute(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int[] isVisited) {
        if(temp.size() == nums.size()) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.size();i++) {
            if((i!= 0 && isVisited[i-1] == 0 && nums.get(i) == nums.get(i - 1))||isVisited[i] == 1 ){
                continue;
            }
            isVisited[i] = 1;
            temp.add(nums.get(i));
            findPermute(nums, res, temp, isVisited);
            temp.remove(temp.size() - 1);
            isVisited[i] = 0;
        }
    }
}


class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> eachPermute = new ArrayList<Integer>();
        if( nums == null || nums.size() == 0 ){
            return results;
        }
        Collections.sort(nums);
        results.add( new ArrayList<Integer>(nums) ); // 先将最初排序后的排列加入解集
        while(true){
            int swapPosition = findSwapPosition(nums);
            if( swapPosition == -1){ // 意味着没有顺序对了, 没有交换点, 则退出循环已经找到所有结果
                break;
            }
            swap(nums, swapPosition);
            reverse(nums, swapPosition);
            results.add( new ArrayList<Integer>(nums) );
        }
        return results;
    }

    // 找到第一个顺序对中的小的那个数作为交换点，没有即返回-1
    private int findSwapPosition(ArrayList<Integer> nums){
        int length = nums.size();
        int i = length - 1;
        while( i > 0 && nums.get(i) <= nums.get(i-1) ){  // 等号也即意味着如果有duplicates也算是顺序对，即不会有交换点出现。
            i--;
        }
        return i-1;
    }

    // 交换上一步交换点位置的数和从后往前第一个大于交换点的数的数
    private void swap(ArrayList<Integer> nums, int swapPosition){
        int i = nums.size() - 1;
        while( i > swapPosition && nums.get(i) <= nums.get(swapPosition) ){
            i--;
        }
        int temp = nums.get(swapPosition);
        nums.set(swapPosition, nums.get(i));
        nums.set(i,temp);
    }

    // 将交换点以后的数，全部reverse
    private void reverse(ArrayList<Integer> nums, int swapPosition){
        int start = swapPosition + 1;
        int end = nums.size() - 1;
        while( start <= end ){
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}



//second write
class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(nums == null || nums.size() == 0) {
            return res;
        }
        Collections.sort(nums);
        boolean[] isUsed = new boolean[nums.size()];
        doDFS(nums, res, temp, isUsed);
        return res;
    }
    private void doDFS(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> res,
    ArrayList<Integer> temp, boolean[] isUsed) {
        if(temp.size() == nums.size()) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i = 0; i < nums.size(); i++) {
          //这里要好好体会，因为我做DFS的时候，探索到返回条件的时候，我需要返回，所以说我当i ！= 0并且i之前的为false，就代表i- 1已经探索过了，再加上
          //nums i-1等于numsi。这就代表是两个重复的解，相当于说11的时候，前一个1所有的排列已经找完了，就不需要再找第二个1的了
          //第二种情况说的是当只有一个数的时候并且我这个数已经用过，就直接continue，跟permutationI一样的检查做法，相当于是contains函数
          //所以这个题有两部分的查重作用，要好好体会
            if((i != 0 && isUsed[i - 1] == false && nums.get(i - 1) == nums.get(i) )|| isUsed[i] == true)  {
                continue;
            }
            temp.add(nums.get(i));
            isUsed[i] = true;
            doDFS(nums, res, temp, isUsed);
            temp.remove(temp.size() - 1);
            isUsed[i] = false;
        }
    }
}
