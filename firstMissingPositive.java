// Given an unsorted integer array, find the first missing positive integer.

// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//利用数字与数组的下标对应来进行查找，这样子可以保证了时间复杂度是O（n）
public class Solution{
	public int firstMissingPositive(int[] A){
//这里返回值很重要，因为如果说为空的情况下，missing positive应该是1，所以这种情况下返回值应该是1
		if(A == null || A.length == 0)
			return 1;
		for(int i =0;i < A.length;i++)
		{
//有三种异常处理条件，一个是负数，一个是零还有一个是A【i】>A.length，因为肯定超出了first missing的范畴
//按照数组的元素比index多一的情况下，A[i]本来就是等于A[A[i]-1]，所以这样子的操作仅仅是将数组变成我们要的顺序
//对于没有那些已经是按照序列排好的元素，这样子操作不会影响这些元素的位置
			if(A[i] <= A.length && A[i] > 0 && A[A[i]-1] != A[i])
			{
				int temp = A[A[i] -1];
				A[A[i]-1] = A[i];
				A[i] = temp;
				i--;
			}
		}
//上面是排序的过程，下面就是扫描的过程，将不对应的点返回，不然就返回length+1.一共扫了两遍数组，所以时间复杂度还是O（n）
		for(int i =0;i < A.length; i++)
		{
			if(A[i] != i+1)
				return i+1;
		}
		return A.length +1;
	}
}