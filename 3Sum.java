// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Have you met this question in a real interview? Yes
// Example
// For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

// (-1, 0, 1)
// (-1, -1, 2)
// Note
// Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
//仅仅是个测试
// The solution set must not contain duplicate triplets.
//brute force, time On3, space On
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length == 0 || numbers.length < 3) {
            return res;
        }
        Arrays.sort(numbers);
        int length = numbers.length;
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        for(int i = 0; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                for(int k = j + 1; k < length; k++) {
                    if(numbers[i] + numbers[j] + numbers[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[k]);
                        if(set.contains(temp)) {
                            continue;
                        }

                        
                        set.add(temp);
                        res.add(temp);
                    }
                }
            }
        }
        return res;
    }
}

//without hash, time On, space O1
public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length == 0) {
        	return res;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++) {
        	if(i != 0 && numbers[i] == numbers[i - 1]) {
        		continue;
        	}
        	int left = i + 1;
        	int right = numbers.length - 1;
        	while(left < right) {
        		int sum = numbers[i] + numbers[left] + numbers[right];
        		if(sum == 0) {
        			ArrayList<Integer> temp = new ArrayList<Integer>();
        			temp.add(numbers[i]);
        			temp.add(numbers[left]);
        			temp.add(numbers[right]);
        			res.add(temp);
        			left++;
        			right--;
        			while( left < right && numbers[left] == numbers[left - 1]) {
        				left++;
        			}
        			while(left < right && numbers[right] == numbers[right + 1]) {
        				right--;
        			}
        		}
        		else if (sum < 0) {
        			left++;
        		}
        		else {
        			right--;
        		}
        	}
        }
        return res;
    }
}
