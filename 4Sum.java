	// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

// Have you met this question in a real interview? Yes
// Example
// For example, given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:

// (-1, 0, 0, 1)

// (-2, -1, 1, 2)

// (-2, 0, 0, 2)

// Note
// Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)

// The solution set must not contain duplicate quadruplets.
//HashSet + 夹逼
public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {     
        //write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numbers == null || numbers.length < 4) {
        	return res;
        }
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 3; i++) {
        	for(int j = i + 1; j < numbers.length - 2; j++) {
        		int left = j + 1;
        		int right = numbers.length - 1;
        		while(left < right) {
        			int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
        			if(sum == target) {
        				ArrayList<Integer> temp = new ArrayList<Integer>();
        				temp.add(numbers[i]);
        				temp.add(numbers[j]);
        				temp.add(numbers[left]);
        				temp.add(numbers[right]);
        				if(!set.contains(temp)) {
        					set.add(temp);
        					res.add(temp);
        				}
        				left++;
        				right--;
        			}
        			else if(target > sum) {
        				left++;
        			}
        			else {
        				right--;
        			}
        		}
        	}
        }
        return res;
    }
}


//纯夹逼
public class Solution {
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(numbers == null || numbers.length < 4) {
			return res;
		}
		Arrays.sort(numbers);
		int length = numbers.length;
		for(int i = 0; i < length; i++) {
			if(i > 0 && numbers[i] == numbers[i - 1]) {
				continue;
			}
			for(int j = i + 1; j < length; j++) {
				if(j > i + 1 && numbers[j] == numbers[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = length - 1;
				while(left < right) {
					int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
					if(sum > target) {
						right--;
					}
					else if(sum < target) {
						left++;
					}
					else {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(numbers[i]);
						temp.add(numbers[j]);
						temp.add(numbers[left]);
						temp.add(numbers[right]);
						res.add(temp);
						left++;
						right--;
						while(left < right && numbers[left] == numbers[left - 1]) {
							left++;
						}
						while(left < right && numbers[right] == numbers[right + 1]) {
							right--;
						}
					}
				}
			}
		}
		return res;
	}
}
