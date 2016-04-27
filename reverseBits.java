// Reverse bits of a given 32 bits unsigned integer.

// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

// Follow up:
// If this function is called many times, how would you optimize it?


//初始状态为01，这样子就慢慢地移动来判断每一位的是1还是0，如果是0就不管，是一的话就反向添加

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        int bit = 0;
        for(int i = 0; i < 32; i++) {
            bit = n & (1 << i);
            if(bit != 0) {
                res += (1 << (31 - i));
            }
        }
        return res;
    }
}


public class Solution1{
	public int reverseBits(int n){
		for(int i =0; i < 16; i++)
			n = swapBits(n,i,32-1-i);
		return n;
	}
	private int swapBits(int n, int i, int j)
	{
		int a = (n>>i)&1;
		int b = (n>>j)&1;
		if((a^b) != 0)
			return n^= (1<<i) |(1<<j);
		return n;
	}
}