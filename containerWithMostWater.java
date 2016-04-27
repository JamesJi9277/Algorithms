// Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Have you met this question in a real interview? Yes
// Example
// Given [1,3,2], the max area of the container is 2.

// Note
// You may not slant the container.
//time On2, space O1
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) {
        	return 0;
        }
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
        	for(int j = i ; j < heights.length; j++) {
        		maxArea = Math.max(maxArea, Math.min(heights[i], heights[j]) * (j - i));
        	}
        }
        return maxArea;
    }
}
//time On, space O1， bug free
//从这个题还可以得出，多设立几个变量有助于提高程序运行的速度，节省时间
public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length == 0) {
            return 0;
        }
        int left = 0;
        int right = heights.length - 1;
        int maxArea = Integer.MIN_VALUE;
        while(left < right) {
            //比如下面就是设立变量的过程
            int height = Math.min(heights[left], heights[right]);
            int base = (right - left);
            maxArea = Math.max(maxArea,  height * base);
            if(heights[left] > heights[right]) {
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}
