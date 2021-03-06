// Write a function that takes an unsigned integer and returns the number of ’1' bits 
// it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, 
// so the function should return 3.
// 跟reverseBit一个思路
public class Solution{
	public int hammingWeight(int n){
		int count = 0;
		int bit = 0;
		for(int i =0; i< 32;i++)
		{
			bit = n & (1<<i);
			if(bit != 0)
				count++;
		}
		return count;
	}
}