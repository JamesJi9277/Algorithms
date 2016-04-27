public class Solution {
    public int mySqrt(int x) {
        if(x < 1) {
        	return 0;
        }
        if(x == 1) {
        	return 1;
        }
        long num = Math.abs((long)x);
        long start = 1;
        long end = num;
        while(start + 1 < end) {
        	long mid = start + (end - start) / 2;
        	if(mid * mid == num) {
        		return (int)mid;
        	}
        	else if(mid * mid > num) {
        		end = mid;
        	}
        	else {
        		start = mid;
        	}
        }
        if(end * end == num) {
        	return (int)end;
        }
        else {
        	return (int)start;
        }
    }
}


public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) {
        	return 1.0;
        }
        if(x == 0 || n == 1) {
        	return x;
        }
        boolean isInverted = false;
        if(n < 0) {
        	isInverted = true;
        }
        long num = Math.abs((long)n);
        double res = helper(x, num);
        return (isInverted == true) ? (double)1/res : (double)res;
    }
    private double helper(double x, long n) {
    	if(n == 0) {
    		return 1.0;
    	}
    	if(x == 0 || n == 1) {
    		return x;
    	}
    	double half = helper(x, n / 2);
    	double rest = helper(x, n - n / 2 - n / 2);
    	return half * half * rest;
    }
}