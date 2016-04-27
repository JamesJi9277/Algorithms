//Given a 2D binary matrix filled with 0's and 1's, 
//find the largest rectangle containing all ones and return its area.
//time complexity O(n^3)
//比较简单明了，从每一个符合条件的点开始右和向下开始搜索，维护一个maxArea
public class Solution1{
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
        return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int maxArea = 0;
        for(int i =0; i < m;i++)
        {
            for(int j =0;j<n;j++)
            {
                if(matrix[i][j] == '1')//因为给出的matrix是char类型的，所以说不能够只用 matrix[][]==1,要用 == ‘1’
                {
                    int area = helper(matrix, i,j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
    private int helper(char[][] matrix, int row, int col){
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
        return 0;
        int maxArea = 0;
        int minWidth = Integer.MAX_VALUE;//因为是要找最小的延伸，所以说先要将minWidth定义为最大的整数，这样子就可以来进行之后的查找以及筛选的过程
        for(int i = row; i< matrix.length && matrix[i][col] =='1';i++)
        {
            int width = 0;
            while(col + width < matrix[0].length && matrix[i][col+width] == '1' )
            width++;
            minWidth = Math.min(minWidth, width);
            int area = minWidth*(i-row+1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
// 这道题的解法灵感来自于Largest Rectangle in Histogram这道题，
// 假设我们把矩阵沿着某一行切下来，然后把切的行作为底面，将自底面往上的矩阵看成一个直方图（histogram）。
// 直方图的中每个项的高度就是从底面行开始往上1的数量。根据Largest Rectangle in Histogram我们就可以求出当前行作为矩阵下边缘的一个最大矩阵。
// 接下来如果对每一行都做一次Largest Rectangle in Histogram，从其中选出最大的矩阵，那么它就是整个矩阵中面积最大的子矩阵。
// 算法的基本思路已经出来了，剩下的就是一些节省时间空间的问题了。
// 我们如何计算某一行为底面时直方图的高度呢？ 
// 如果重新计算，那么每次需要的计算数量就是当前行数乘以列数。然而在这里我们会发现一些动态规划的踪迹，
// 如果我们知道上一行直方图的高度，我们只需要看新加进来的行（底面）上对应的列元素是不是0，如果是，则高度是0，否则则是上一行直方图的高度加1。
// 利用历史信息，我们就可以在线行时间内完成对高度的更新。我们知道，Largest Rectangle in Histogram的算法复杂度是O(n)。
// 所以完成对一行为底边的矩阵求解复杂度是O(n+n)=O(n)。接下来对每一行都做一次，那么算法总时间复杂度是O(m*n)。
// 空间上，我们只需要保存上一行直方图的高度O(n)，加上Largest Rectangle in Histogram中所使用的空间O(n)，所以总空间复杂度还是O(n)。
public class Solution{
	public int maximalRectangle(char[][]){
		if(matrix == null || matrix.length == 0|| matrix[0].length == 0)
			return 0;
		int maxArea = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] height = new int[m][n+1];
		for(int i = 0;i< m ;i++){
			for(int j =0;j<n;j++){
				if(matrix[i][j] == '0')
					height[i][j] == 0;
				else height[i][j] = i==0?1:height[i-1][j] +1
			}
		}
		for(int i =0;i<m;i++){
			int area = largestRectangleArea(height[i]);
			maxArea =Math.max(area, maxArea);
		}
		return maxArea;
	}
	private int largestRectangleArea(int[] height){
		stack<Integer> stack = new Stack<Integer>();
		int[] h = new int[height.length+1];
		for(int i =0;i<height.length;i++)
			h[i] = height[i];
		int maxArea = 0;
		int i =0;
		while(i<h.length)
		{
			if(stack.isEmpty()|| h[stack.peek()] <= h[i])
				s.push(i++);
			else{
				int top = stack.pop();
				int area = h[top] *(stack.isEmpty()? i: i-s.peek()-1);
				maxArea = Math.max(area,maxArea);
			}
		}
		return maxArea;
	}
}





