// implement pow(x,n)
//brute force, but indicate that time limit exceeded

//要好好理解的版本
public class Solution {
	public double myPow(double x, int n) {
		//先讨论 a^b，a和b的不同取值特殊的corner case
		if(Math.abs((x - 0.0)) < Math.pow(10, -6)) {
			return 0.0;//讨论的是当x等于0的时候，没有意义，直接返回0.0,这里的技巧是比较两个数是否相等，精度准确到10^-6即可
		}
		if(n == 0) {
			return 1.0;
		}
		boolean isInverted = false;
		if(n < 0) {
			isInverted = true;
		}
		long newPow = Math.abs((long)n);//这里的n有可能是-2347483648的情况，取绝对值后就会溢出
		double res = 0.0;
		res = divideAndConquer(x, newPow);
		return (isInverted) ? 1/res : res;
	}

	private double divideAndConquer(double x, long n) {
		if(n == 0) {
			return 1.0;
		}
		if(n == 1) {
			return x;
		}

		double halfPart = divideAndConquer(x, n / 2);
		double restPart = divideAndConquer(x, n - (n/2) * 2);//考虑进来了奇偶数的情况

		return halfPart * halfPart * restPart;
	}
}
//binary => reduce time complexity to O(logn)
//相当于是对half进行不断地二分，递归来求解子问题，虽然没有明确说half是多少，
//但是每次在调用half的时候就相当于进行了一次递归的操作，所以时间复杂度可以降到O(logn)
public class Solution2{
	public double myPow(double x, int n){
		if(n == 0)
			return 1.0;
		double half = myPow(x, n/2);
		if(n%2 == 0)
			return half*half;
		else if(n >0)
			return half*half*x;
		else
			return half*half /x;
	}
}

//就是把n看成是以2为基的位构成的，因此每一位是对应x的一个幂数，
// 然后迭代直到n到最高位。比如说第一位对应x，第二位对应x*x,第三位对应x^4,...,
// 第k位对应x^(2^(k-1)),可以看出后面一位对应的数等于前面一位对应数的平方，所以可以进行迭代。
// 因为迭代次数等于n的位数，所以算法的时间复杂度是O(logn)。
// 举个栗子，2^10 = 1024, 10用二进制表示是1010，位数上分别对应2,2^2,2^4,2^8
// 所以结果相当于2^8 * 2^2 = 2^10，相当于把计算步骤进行了二分来做，所以时间复杂度也是O(logn)
public class Solution{
	public double myPow(double x, int n){
		if(n == 0)
			return 1.0;
		double res = 1.0;
		if(n <0)
		{
			if(x>= 1.0/Double.MAX_VALUE || x <= 1.0/-Double.MAX_VALUE)
				x = 1.0/x;
			else
				return Double.MAX_VALUE;
			if(n == Integer.MIN_VALUE)
			{
				res *= x;
				n++;
			}
		}
		n = Math.abs(n);
		boolean isNeg = false;
		if(n%2 == 1 && x<0)
			isNeg = true;
		x = Math.abs(x);
		while(n >0)
		{
			if((n&1) == 1)
			{
				if(res>Double.MAX_VALUE/x)
					return Double.MAX_VALUE;
				res = res*x;
			}
			x *= x;
			n = n>>1;
		}
		return isNeg?-res:res;
	}
}

