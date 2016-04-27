public class Solution {
	public int searchBigSortedArray(int[] A, int target) {
		if(A == null || A.length == 0) {
			return -1;
		}
		int start = 0;
		int end = 0;
		while(A[end] < target && end < A.length / 2) {
			end = end * 2 + 1;
		}
		if(A[end] >= target) {
			return doSearch(A, 0, end, target);
		}
		else if(A[end] < target) {
			return doSearch(A, end, A.length - 1, target);
		}
		return -1;
	}
	private int doSearch(int[] A, int start, int end, int target) {
		while(start + 1 < end) {
			int mid = start + ( end - start) / 2;
			if(A[mid] >= target) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		if(A[start] == target) {
			return start;
		}
		else if(A[end] == target) {
			return end;
		}
		return -1;
	}
}

public class Solution {
	public int searchBigSortedArray(int[] A, int target) {
		if(A == null || A.length == 0) {
			return -1;
		}
		int start = 0;
		int end = 0;
		while(end < A.length && A[end] < target) {
			end = end * 2 + 1;
		}
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(A[mid] >= target) {
				end = mid;
			}
			else {
				start = mid;
			}
		}
		if(A[start] == target) {
			return start;
		}
		else if(A[end] == target) {
			return end;
		}
		return -1;
	}
}
//last position of target
public class Solution {
    public int lastPosition(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}
//closest number
public class Solution {
    public int closestNumber(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        int diff1 = Math.abs(target - A[start]);
        int diff2 = Math.abs(target - A[end]);
        return (diff1 > diff2) ? end : start;
    }
}
//longest incresing subsequence
public class Solution {
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] res = new int[length];
        for(int i = 0; i < length; i++) {
            res[i] = 1;
        }
        int max = 0;
        for(int i = 1; i < length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }
}
