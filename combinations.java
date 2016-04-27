// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
public class Solution{
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		findCombine(1,n,k,tmp,res);
		return res;
	}
	private void findCombine(int start, int n, int k, List<Integer> tmp, List<List<Integer>> res){
		//先写出退出条件，这里的退出条件有两个，一个是k的限制，一个是找完了所有的元素
		if(tmp.size() == k)
		{
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		if(start > n)
			return;
		for(int i =start; i<=n;i++)
		{
			if(!tmp.contains(i))
			{
				tmp.add(i);
				findCombine(i+1,n,k,tmp,res);
				tmp.remove(tmp.size()-1);
			}
		}
	}
}

//second write
public class Solution{
	public List<List<Integer>> combine(int n, int k){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		findCombine(res, temp, n, 1);
		return res;
	}
	private void findCombine(List<List<Integer>> res, List<Integer> temp, int n, int pointer){
		if(temp.size() == k){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		if(pointer > n){
			return;
		}
		for(int i =pointer;i<=n;i++){
			if(!temp.contains(i)){
				temp.add(i);
				findCombine(res, temp, n,i+1);
				temp.remove(temp.size()-1);
			}
		}
	}
}

//third write, bug free
public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();
		helper(res, temp, n ,k, 1);
		return res;
	}
	private void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int pos) {
		if(pos == n + 2) {
			return;
		}
		if(temp.size() == k) {
			res.add(new ArrayList<Integer>(temp));
		}
		for(int i = pos; i < n + 1; i++) {
			if(temp.contains(i)) {
				continue;
			}
			temp.add(i);
			helper(res, temp, n, k, i + 1);
			temp.remove(temp.size() - 1);
		}
	}
}


public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] check = new int[n];
        for(int i = 0 ; i < n; i++) {
        	if(i < k) {
        		check[i] = 1;
        	}
        	else {
        		check[i] = 0;
        	}
        }
        if(n < 1) {
        	return res;
        }
        for(int i = 0; i < n - 1; i++) {
        	if(check[i] == 1 && check[i + 1] == 0) {
        		swap(check[i], check[i + 1]);
        		setZero(check, i-1);
        		int[] A = new int[n];
        		for(int j = 0; j < n; j++) {
        		    A[j] = j * check[j];
        		}
        		List<Integer> temp = toArrayList(check);
        		List<Integer> temp1 = new ArrayList<Integer>();
        		for(int k = 0; k < temp.size(); k++) {
        		    if(temp.get(k) != 0) {
        		        temp1.add(temp.get(k));
        		    }
        		}
        		res.add(temp1);
        	}
        }
        return res;
    }
    private void swap(int a, int b) {
    	int temp = a;
    	a = b;
    	b = temp;
    	return;
    }
    private List<Integer> toArrayList(int[] nums) {
    	List<Integer> res = new ArrayList<Integer>();
    	int length = nums.length;
    	for(int i = 0; i < length; i++) {
    		res.add(nums[i]);
    	}
    	return res;
    }
    private void setZero(int[] nums, int pos) {
    	int count = 0;
    	for(int i = 0; i < pos; i++) {
    		if(nums[i] == 1) {
    			count++;
    		}
    	}
    	for(int i = 0; i < pos; i++) {
    		if(i <= count) {
    			nums[i] = 1;
    		}
    		else {
    			nums[i] = 0;
    		}
    	}
    	return;
    }
}




public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		// List<Integer> eachComb = new ArrayList<Integer>();
		if( k == 0 ){
			return results;
		}
		for(int i = 1; i <= n; i++){
			List<Integer> eachComb = new ArrayList<Integer>();
			eachComb.add(i);
			results.add(eachComb);
		}
		k--;
		while( k-->0 ){
			List<List<Integer>> newResult = new ArrayList<List<Integer>>();
			for(int i = 0; i < results.size(); i++){
				List<Integer> prevComb = results.get(i);
				int prevLast = prevComb.get(prevComb.size()-1);
				for(int j = prevLast + 1; j <= n; j++){
					if( n - j < k - 1){
						continue;
					}
					List<Integer> combNext = new ArrayList<Integer>(prevComb);
					combNext.add(j);
					newResult.add(combNext);
				}
			}
			results = newResult;
		}
		return results;
    }
}

