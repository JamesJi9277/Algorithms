public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            int base = right - left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, base * h);
            if(left < right && height[left] > height[right]) {
                right--;
            }
            else if(left < right && height[left] <= height[right]) {
                left++;
            }
        }
        return max;
    }
}

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];
        int left = height[0];
        int right = height[length - 1];
        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];
        for(int i = 1; i < length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        for(int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int max = 0;
        for(int i = 0; i < length; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]) - height[i];
            max += Math.max(temp, 0);
        }
        return max;
    }
}

public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[length - 1];
        int res = 0;
        while(left <= right) {
            if(leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[left]);
                res += Math.max(0, leftMax - height[left]);
                left++;
            }
            else {
                res += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }
}