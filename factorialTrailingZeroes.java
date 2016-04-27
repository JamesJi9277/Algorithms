// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.
//
public class Solution{
	public int trailingZeroes(int n){
		int numberOf5 = 0;
		int numberOf2 = 0;
		int n1 = n;
		int n2 = n;
		while(n1 >0)
		{
			numberOf5 += (n1)/5;
			n1 = (n1)/5;
			
		}
		while(n2 >0)
		{
			numberOf2 += (n2)/5;
			n2 = (n2)/2;
			
		}
		return Math.min(numberOf5, numberOf2);
	}
}


public class Solution {
    public int trailingZeroes(int n) {
        if(n < 5) {
            return 0;
        }
        int count = 0;
        while(n != 0) {
            count += (n / 5);
            n /= 5;
        }
        return count;
    }
}