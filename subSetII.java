// Given a list of numbers that may has duplicate numbers, return all possible subsets

// Have you met this question in a real interview? Yes
// Example
// If S = [1,2,2], a solution is:

// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
// Note
// Each element in a subset must be in non-descending order.

// The ordering between two subsets is free.

// The solution set must not contain duplicate subsets.
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(S == null || S.size() == 0) {
        	return res;
        }
        Collections.sort(S);
        res.add(new ArrayList<Integer>(temp));
        findSubset(res, temp, S, 0);
        return res;
    }
    private void findSubset(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, ArrayList<Integer> S, int start) {
    	for(int i = start; i < S.size();i++ ) {
    		if(i != start && S.get(i) == S.get(i-1)) {
    			continue;
    		}
    		temp.add(S.get(i));
    		findSubset(res, temp, S, i+1);
    		res.add(new ArrayList<Integer>(temp));
    		temp.remove(temp.size()-1);
    	}
    	return;
    }
}

