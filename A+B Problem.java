x   y   sum carry
0   0   0   0
0   1   1   0
1   0   1   0
1   1   0   1
加法的真值表，从中可以看出，sum正好是 x^y，而carry正好是 x&y，
需要注意的是当carry == 1时，相当于是出现了一个10或者100之类，这时候将carry转换成整数需要左移一位

class Solution {
    public int aplusb(int a, int b) {
        // write your code here, try to do it without arithmetic operators.
        if(a == 0 || b == 0) {
            return (a == 0) ? b : a;
        }
        int digit = a ^ b;
        int carry = (a & b) << 1;
        return aplusb(digit, carry);
    }
};

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        while(b != 0){
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

int Minus(int a,int b)  
{  
    for(int i = 1; i && ((b & i) ==0 ); i <<= 1)
        ;  
    for(int i <<= 1; i; i <<=1 ) 
        b ^= i;  
    return Add(a,b);  
}  


int Mul(int a,int b)  
{  
    int ans = 0;  
    for(int i = 1; i; i <<= 1, a <<= 1)  
        if(b & i)  
            ans += a;  
        return ans;  
} 


int Div(int dividend, int divisor) 
{
    // assert(divisor != 0)
    int sign = 1;
    if(dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0)
        sign = -1;
    unsigned int x = (unsigned int)abs(dividend);
    unsigned int y = (unsigned int)abs(divisor);
    int bitCnt = sizeof(int) << 3;
    int quotient = 0;
    int k = bitCnt-1;
    while(((1 << k) & y) == 0) k--;
    for(int j = bitCnt-1-k; j >= 0; j--)
    {
        if(x >= (y << j))
        {
            x -= (y << j);
            quotient += (1 << j);
        }
    }
    return sign*quotient;
}