class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(S == null || S.size() == 0) {
            return res;
        }
        Collections.sort(S);
        dfs(S, res, temp, 0);
        return res;
    }
    private void dfs(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> res,
    ArrayList<Integer> temp, int pos) {
      //我这里就相当于不需要加上返回条件，因为在for循环就限制了范围，然后每一次我所探索到的temp都是我所需要的解
      //并且Java是值传递，所以说我每次在添加temp的时候，需要new一个temp然后加入到res中
        res.add(new ArrayList<Integer>(temp));
        for(int i = pos; i < S.size(); i++) {
            temp.add(S.get(i));
            dfs(S, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}





class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0) {
            return res;
        }
        Collections.sort(S);
        ArrayList<Integer> temp = new ArrayList<Integer>();
         res.add(new ArrayList<Integer>(temp));
        findSubset(res, temp, S, 0);
        return res;
    }
    private void findSubset(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, ArrayList<Integer> S, int start){
        for(int i =start; i< S.size();i++){
            temp.add(S.get(i));
            findSubset(res, temp, S, i+1);
            res.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
        }
    }
}

//second write, bug free
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null || S.size() == 0) {
            return res;
        }
        Collections.sort(S);
        ArrayList<Integer> temp = new ArrayList<Integer>();
        res.add(new ArrayList<Integer>(temp));
        findSubsets(S, res, temp, 0);
        return res;
    }
    private void findSubsets(ArrayList<Integer> S, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int index) {
        if(index == S.size()) {
            return;
        }
        //因为这个题返回条件仅仅是找到了底，所以说我找到了底就返回，而不需要找到了底才添加此时的temp，如果是这样的话，会漏解
        //比如说1，2，我只有触碰到了2我才会返回，这样子我单独的1这个解就没有作为subset加入到结果中，
        //所以说加入这个操作应该放到for循环里面，即是找到一步，我就作为subset加入结果，也可以说是因为subset这个特性的原因吧
        for(int i = index; i < S.size(); i++) {
            temp.add(S.get(i));
            findSubsets(S, res, temp, i + 1);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
        }

    }
}
