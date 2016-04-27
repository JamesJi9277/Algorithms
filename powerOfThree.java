Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
//基本方法，比较常规，以1为临界点来进行比较
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1) {
        	return false;
        }
        while(n > 1) {
        	if(n % 3 != 0) {
        		return false;
        	}
        	n /= 3;
        }
        return true;
    }
}
//利用API，直接求log然后看结果是不是整数
//如果是9的话，那么Math.log10(9) = 2 * Math.log10(3)
//那么计算的结果就是2，是整数，就返回true
public class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}