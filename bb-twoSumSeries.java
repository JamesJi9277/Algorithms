two sum, one have exactly one pair
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
        	return new int[2];
        }
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(target - nums[i])) {
        		res[0] = map.get(target - nums[i]) + 1;
        		res[1] = i + 1;
        		return res;
        	}
        	else {
        		map.put(nums[i], i);
        	}
        }
        return res;
    }
}

3 sum, find a + b + c = 0
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0) {
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else if(sum > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}

3sum closest
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(minDiff > Math.abs(sum - target)) {
                    res = sum;
                    minDiff = Math.abs(sum - target);
                }
                if(sum == target) {
                    return sum;
                }
                else if(sum > target) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return res;
    }
}
4sum
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) {
        	return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
        	if(i != 0 && nums[i - 1] == nums[i]) {
        		continue;
        	}
        	for(int j = i + 1; j < nums.length - 2; j++) {
        		if(j != i + 1 && nums[j - 1] == nums[j]) {
        			continue;
        		}
        		int left = j + 1;
        		int right = nums.length - 1;
        		while(left < right) {
        			int sum = nums[i] + nums[j] + nums[left] + nums[right];
        			if(sum == target) {
        				List<Integer> temp = new ArrayList<Integer>();
        				temp.add(nums[i]);
        				temp.add(nums[j]);
        				temp.add(nums[left]);
        				temp.add(nums[right]);
        				res.add(temp);
        				left++;
        				right--;
        				while(left < right && nums[left] == nums[left - 1]) {
        					left++;
        				}
        				while(left < right && nums[right] == nums[right + 1]) {
        					right--;
        				}
        			}
        			else if(sum > target) {
        				right--;
        			}
        			else {
        				left++;
        			}
        		}
        	}
        }
        return res;
    }
}


two sum, input array is sorted
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
        	return new int[2];
        }
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
        	int sum = numbers[left] + numbers[right];
        	if(sum == target) {
        		res[0] = left + 1;
        		res[1] = right + 1;
        		return res;
        	}
        	else if(sum > target) {
        		right--;
        	}
        	else {
        		left++;
        	}
        }
        return res;
    }
}

two sum, data structure design
public class TwoSum {
	ArrayList<Integer> nums = new ArrayList<Integer>();
	public void add(int number) {
		nums.add(number);
	}
	public boolean find(int value) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.size(); i++) {
			if(map.containsKey(value - nums.get(i))) {
				return true;
			}
			else {
				map.put(nums.get(i), i);
			}
		}
		return false;
	}
}

3Sum smaller
Given an array of n integers nums and a target, 
find the number of index triplets i, j, k 
with 0 <= i < j < k < n that satisfy the condition 
nums[i] + nums[j] + nums[k] < target.
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) {
        	return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
        	int left = i + 1;
        	int right = nums.length - 1;
        	while(left < right) {
        		int sum = nums[i] + nums[left] + nums[right];
        		if(sum >= target) {
        			right--;
        		}
        		else {
        			count += (right - left);
        			left++;
        		}
        	}
        }
        return count;
    }
}

//import java.util.*;
//public class twoSum {
//  public ArrayList<ArrayList<Integer>> find(int[] nums, int target) {
//      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//      if(nums == null || nums.length == 0) {
//          return res;
//      }
////        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
////        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
////        for(int i = 0; i < nums.length; i++) {
////            if(map.containsKey(target - nums[i])) {
////                ArrayList<Integer> temp = new ArrayList<Integer>();
////                temp.add(target - nums[i]);
////                temp.add(nums[i]);
////                if(!set.contains(temp)) {
////                    res.add(temp);
////                    set.add(temp);
////                }
////            }
////            else {
////                map.put(nums[i], i);
////            }
////        }
//      Arrays.sort(nums);
//      int left = 0;
//      int right = nums.length - 1;
//      while(left < right) {
//          int sum = nums[left] + nums[right];
//          if(sum == target) {
//              ArrayList<Integer> temp = new ArrayList<Integer>();
//              temp.add(nums[left]);
//              temp.add(nums[right]);
//              res.add(temp);
//              left++;
//              right--;
//              while(left < right && nums[left] == nums[left - 1]) {
//                  left++;
//              }
//              while(left < right && nums[right] == nums[right + 1]) {
//                  right--;
//              }
//          }
//          else if(sum > 0) {
//              right--;
//          }
//          else {
//              left++;
//          }
//      }
//      return res;
//  }
//  public static void main(String[] args) {
//      twoSum t = new twoSum();
//      int[] nums = {1,2,3,4,4,4,4,44,4,5,6,7};
//      int target = 8;
//      ArrayList<ArrayList<Integer>> res = t.find(nums, target);
//      int j = 0;
//      for(int i = 0; i < res.size(); i++) {
//          for(j = 0; j < res.get(i).size(); j++) {
//              System.out.print(res.get(i).get(j) + " ");
//          }
//          if(j == res.get(i).size()) {
//              System.out.println(" ");
//          }
//      }
//  }
//}
import java.util.*;
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MAX_VALUE;
        if( nums == null || nums.length < 2 ){
            return result;
        }
        int length = nums.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < length; i++){
            if( map.containsKey(nums[i]) ){
                map.get(nums[i]).add(i);
            }else{
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                map.put(nums[i], temp);
            }
        }

        Arrays.sort(nums);
        int left = 0, right = length - 1;
        while( left < right ){
            if( nums[left] + nums[right] < target ){
                left++;
            }else if( nums[left] + nums[right] > target ){
                right--;
            }else{
                if( nums[left] == nums[right] ){
                    int temp1 = Math.min(map.get(nums[left]).get(0), map.get(nums[left]).get(1));
                    int temp2 = Math.max(map.get(nums[left]).get(0), map.get(nums[left]).get(1));
                    if(temp1 < result[0]) {
                        result[0] = temp1;
                        result[1] = temp2;
                    }
                    return result;
                }else{
                    int temp1 = map.get(nums[left]).get(0);
                    int temp2 = map.get(nums[right]).get(0);
                    if(temp1 < result[0]) {
                        result[0] = temp1;
                        result[1] = temp2;
                    }
                    return result;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        twoSum t = new twoSum();
        int[] nums = {2,1,11,12};
        int target = 13;
        int[] res = t.twoSum(nums, target);
        for(int i = 0; i < 2; i++) {
            System.out.print(res[i] + " ");
        }
    }
}