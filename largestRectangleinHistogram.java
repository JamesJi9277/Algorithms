// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
// histogram
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
// histogram
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
// Have you met this question in a real interview? Yes
// Example
// Given height = [2,1,5,6,2,3],
// return 10.
// we are storing index into stack,
// since we can always get height through index.
//We only push index into stack if its corresponding height is higher than the peek 's height.
//So each time when we meet with the condition of pop(),
//we are sure the index popped out will have the min height from it to the origin peek before popping.
//这个题的关键是我存在stack里面的都是index

//将每一块板都假设为最短板，然后往左有无限延伸直到找到比他小的一块，就停止，时间复杂度是On3或者On
//当发现有这种需求的时候，即找一个数左边第一个比他大或者比他小和右边比他大或者比他小的数， 想到用stack
//找最长递增序列，需要求两次来分别找出往左最远延伸和往右的最远延伸
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0) {
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while(!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int width = stack.isEmpty()? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}


//bug free
public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;

        for(int i = 0; i <= height.length; i++) {
            int cur = (i == height.length)? (-1) : height[i];
            while(!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
