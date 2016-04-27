// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Have you met this question in a real interview? Yes
// Example
// Given [1, 0, 1, 2], return [0, 1, 1, 2].
//
// Note
// You are not suppose to use the library's sort function for this problem.
//
// Challenge
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's,
//then overwrite array with total number of 0's, then 1's and followed by 2's.
//
// Could you come up with an one-pass algorithm using only constant space?
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        return;
    }
}
//count sort
class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return;
        }
        int numberOf0 = 0;
        int numberOf1 = 0;
        int numberOf2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
              numberOf0++;
            }
            else if(nums[i] == 1) {
              numberOf1++;
            }
            else {
              numberOf2++;
            }
        }
        for(int i = 0; i < numberOf0; i++) {
          nums[i] = 0;
        }
        for(int i = numberOf0; i < numberOf1 + numberOf0; i++) {
          nums[i] = 1;
        }
        for(int i = numberOf0 + numberOf1; i < nums.length; i++) {
          nums[i] = 2;
        }
        return;
    }
}
//简化版count sort, two pass
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for(int i = 0; i < 3; i++) {
            while(count[i]-- > 0) {
                nums[index++] = i;
            }
        }
    }
}



//one pass,通过置换
// 有点类似快速排序partition的思想，以1为pivot元素对原始数组的元素进行划分，
// 使其左侧分布0，右侧分布为2, 中间分布1. 需要借助三个指针，一个遍历指针，一个左侧元素0分布指针，还有一个右侧元素2分布指针。
// 时间复杂度O(n), 空间复杂度O(1), one pass.
//   题目要求one pass的情况下，就要把所有元素都重置在相应的位置上。我们先看，排序好后的元素分步是左边为0，右边为2，中间为1. 
//   也就是说，当我们的遍历指针，在遍历每一个元素时，如果发现其位置不在它应该出现的位置上，我们就需要把它重置到相应位置去。
//   因为只有三个数来排序，我们选择中间的数作为pivot. 这样，我们才能保证，在只有三种数据的情况下，
//   我们每当看到一个数时不管它是0还是1还是2，我们都知道该将它往哪儿放置。
//   首先针对左侧元素0的分布，我们设置一个指针叫zeroNext, 它始终指向当前元素分布时，左侧元素0分布的最后一个0的位置的后一个位置。
//   换句话说，要是再遍历到0时，就要将0放置到该位置。初始时，zeroNext = 0, 也表示当遍历到第一个0时要将其放置在该位置，然后它再指向下一个要放0的位置。
//   针对右侧元素2的分布，我们设置一个指针叫做twoPrev, 它始终指向当前元素分布时，右侧元素2分布的第一个2的位置的前一个位置。
//   换句话说，要是再遍历到2时，就要将2放置到该位置。初始时，twoPrev = length – 1, 
//   也表示当遍历到第一个2时要将其放置在该位置，然后他在指向前一个位置也就是再有2时要放的位置。
//   还有一个遍历指针i, 初始为0, 遍历所有元素，注意其遍历范围应当是【0, twoPrev】，注意是从左到右正向遍历
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        int nextRed = 0;//red pointer
        int nextBlue = nums.length - 1;//blue pointer
        int index = 0;//white pointer
        //之所以加上等号是因为有可能出现没有2的情况，这时候nextTwo就相当于是一个边界index，所以要<=
        while(index <= nextBlue) {//so the quit requirement should write like this
            if(nums[index] == 1) {
                index++;
            }
            else if(nums[index] == 0) {
                doSwap(nums, index, nextRed);
                nextRed++;
                index++;
            }
            else {
                doSwap(nums, index, nextBlue);
                nextBlue--;
            }
        }
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//纯quickSort的实现，不断地调用递归函数，如果是kTh的话那就是直接在left排好序后用left与k的值去对比
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length < 2) {
            return;
        }
        doQuickSort(nums, 0, nums.length - 1);
    }
    private void doQuickSort(int[] nums, int start, int end) {
        if(start > end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = nums[left];
        while(left < right) {
            while(left < right && nums[right] > pivot) {
                right--;
            }
            if(left < right) {
                nums[left] = nums[right];
                left++;
            }
            while(left < right && nums[left] <= pivot) {
                left++;
            }
            if(left < right) {
                nums[right] = nums[left];
                right--;
            }
        }
        nums[left] = pivot;
        doQuickSort(nums, start, left - 1);
        doQuickSort(nums, left + 1, end);
    }
}