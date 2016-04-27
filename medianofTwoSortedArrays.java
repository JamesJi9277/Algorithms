// 这道题比较直接的想法就是用Merge Sorted Array这个题的方法把两个有序数组合并，
// 当合并到第(m+n)/2个元素的时候返回那个数即可，而且不用把结果数组存起来。
// 算法时间复杂度是O(m+n)，空间复杂度是O(1)

public class Solution2{
	public double findMedianSortedArrays(int A[], int B[]){
		if((A.length+B.length)%2 ==1)
			return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
		else
			return(helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)+
				helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
	}
	private int helper(int A[], int B[], int i,int i2, int j, int j2, int k)
	{
		int m = i2 - i + 1;
		int n = j2 - j + 1;
		if(m > n)
			return helper(B,A,j,j2,i,i2,k);
		if(m == 0)
			return B[j+k-1];
		if(k == 1)
			return Math.min(A[i], B[j]);
		int posA = Math.min(k/2, m);
		int posB = k - posA;
		if(A[i + posA -1] == B[j + posB -1])
			return A[i+posA-1];
		else if (A[i+posA -1] < B[j+posB-1])
			return helper(A,B,i+posA, i2,j,j+posB-1,k-posA);
		else
			return helper(A,B,i+posA-1,j+posB,j2,k-posB);
	}
}




public double findMedianSortedArrays(int A[], int B[]) {
    if((A.length+B.length)%2==1)
        return helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1);
    else
        return (helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2)  
               +helper(A,B,0,A.length-1,0,B.length-1,(A.length+B.length)/2+1))/2.0;
}
private int helper(int A[], int B[], int i, int i2, int j, int j2, int k)
{
    int m = i2-i+1;
    int n = j2-j+1;
    if(m>n)
        return helper(B,A,j,j2,i,i2,k);
    if(m==0)
        return B[j+k-1];
    if(k==1)
        return Math.min(A[i],B[j]);
    int posA = Math.min(k/2,m);
    int posB = k-posA;
    if(A[i+posA-1]==B[j+posB-1])
        return A[i+posA-1];
    else if(A[i+posA-1]<B[j+posB-1])
        return helper(A,B,i+posA,i2,j,j+posB-1,k-posA);
    else
        return helper(A,B,i,i+posA-1,j+posB,j2,k-posB);
}