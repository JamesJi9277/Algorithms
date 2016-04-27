//找到每一个A[i]所能存水的量，然后遍历一边累加即可
//以A[i]为基准点，向左向右分别找到左边最高与右边最高，左右最高的最小值与A[i]的差值就是A[i]可以存水量
//初始化时，左右边界分别对应原始数组的左右边
public class Solution {
    public int trapRainWater(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int length = heights.length;
        int res = 0;
        if(length <= 2) {
            return 0;
        }
        int leftMax = heights[0];
        int rightMax = heights[length - 1];
        int left = 0;
        int right = length - 1;
        while(left <= right) {
            //虽然理论上我分别需要比较的是leftMax和rightMax然后去一个比较小的值，但是真正的短板还是left或者right的最小值
            //所以我只需要在最小值上做文章，每次更新最大值的最小值后再去比较，然后把结果加入到最后的res中即可
            if(leftMax <= rightMax) {
                res += Math.max(0, leftMax - heights[left]);
                leftMax = Math.max(leftMax, heights[left]);
                left++;
            }
            else {
                res += Math.max(0, rightMax - heights[right]);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }
        return res;
    }
}


public class trapWater {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWaterWithLeak(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = heights[0];
        int leftMax = heights[0];
        int rightMax = heights[length - 1];
        right[length - 1] = heights[length - 1];
        for(int i = 1; i < length; i++) {
            if(heights[i] == 0) {
                leftMax = 0;
            }
            left[i] = Math.max(leftMax, heights[i]);
            leftMax = Math.max(leftMax, heights[i]);

        }
        for(int i = length - 2; i >= 0; i--) {
            if(heights[i] == 0) {
                rightMax = 0;
            }
            right[i] = Math.max(rightMax, heights[i]);
            rightMax = Math.max(rightMax, heights[i]);

        }
        int res = 0;
        for(int i = 0; i < length; i++) {
            res += (Math.min(left[i], right[i]) - heights[i]);
        }
        return res;
    }
    public int trapRainWaterWithoutLeak(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int leftMax = heights[0];
        int rightMax = heights[heights.length - 1];
        int res = 0;
        while(left <= right) {
            if(leftMax <= rightMax) {
                leftMax = Math.max(leftMax, heights[left]);
                res += Math.max(0, leftMax - heights[left]);
                left++;
            }
            else {
                res += Math.max(0, rightMax - heights[right]);
                rightMax = Math.max(rightMax, heights[right]);
                right--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        trapWater t = new trapWater();
        System.out.println("---------------------------");
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print("The input is: ");
        for(int item : a) {
            System.out.print(" "+ item);
        }
        System.out.println(" ");
        System.out.println("---------------------------");
        System.out.println("Max water contain without leak is : " + t.trapRainWaterWithoutLeak(a));
        System.out.println(" ");
        System.out.println("---------------------------");
        System.out.println(" ");
        System.out.println("Max water contain with leak is : " + t.trapRainWaterWithLeak(a));
    }
}

public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = heights[0];
        right[length - 1] = heights[length - 1];
        int leftMax = heights[0];
        int rightMax = heights[length - 1];
        for(int i = 1; i < length; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            left[i] = Math.max(leftMax, heights[i]);
        }
        for(int i = length - 2; i >= 0; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            right[i] = Math.max(rightMax, heights[i]);
        }
        int res = 0;
        for(int i = 0; i < length; i++) {
            int temp = Math.min(left[i], right[i]) - heights[i];
            res += temp;
        }
        return res;
    }
}

