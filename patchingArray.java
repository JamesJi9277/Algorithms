Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.
用covered表示连续和为[1, n]的数，有了这个后表示就简单了
分两种情况，一种是nums[i] <= covered,更新已知范围为[1, covered + nums[i]];
如果nums[i] > covered,要添加covered进数组才有可能达到最大范围，所以更新范围为[1, 2 * covered],并且patch++

public class Solution {
	public int minPatches(int[] nums, int n) {
		int numPatch = 0;
		int i = 0;
		for(long canCover = 1; canCover <= n;){
			if(i < nums.length && nums[i] <= canCover) {
				canCover += nums[i];
				i++;
			}
			else {
				numPatch++;
				canCover *= 2;
			}
		}
		return numPatch;
	}
}

//second write, bug free
public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        int i = 0;
        //注意这里要用long covered
        for(long covered = 1; covered <= n;) {
            if(i < nums.length && nums[i] <= covered) {
                covered += nums[i++];
            }
            else {
                covered <<= 1;
                count++;
            }
        }
        return count;
    }
}