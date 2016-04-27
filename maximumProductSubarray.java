// Find the contiguous subarray within an array (containing at least one number) 
// which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.
public class Solution{
	public int maxProduct(int[] A){
		if(A == null || A.length ==0)
			return 0;
		if(A.length ==1)
			return A[0];
		int maxlocal = A[0];
		int minlocal = A[0];
		int global = A[0];
		for(int i =1;i<A.length;i++)
		{
			int maxcopy = maxlocal;
			//求最小和求最大的方法是一样的，只不过因为考虑到了负数的存在，所以说每次需要加一个最小值
			//最小值*A[i]有可能就会变成最大值。然后更新maxlocal就好了
			maxlocal = Math.max(Math.max(A[i]*maxlocal,A[i]),A[i]*minlocal);
			minlocal = Math.min(Math.min(A[i]*maxcopy,A[i]), A[i]*minlocal);
			global = Math.max(global, maxlocal);
		}
		return global;
	}
}