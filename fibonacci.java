// Find the Nth number in Fibonacci sequence.

// A Fibonacci sequence is defined as follow:

// The first two numbers are 0 and 1.
// The i th number is the sum of i-1 th number and i-2 th number.
// The first ten numbers in Fibonacci sequence is:

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 ...

// Have you met this question in a real interview? Yes
// Example
// Given 1, return 0

// Given 2, return 1

// Given 10, return 34

// Note
// The Nth fibonacci number won't exceed the max value of signed 32-bit integer in the test cases.

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    //time On, space Ologn
    public int fibonacci(int n) {
        // write your code here
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        int res = fibonacci(n - 1) + fibonacci(n - 2);
        return res;
    }
}




class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if( n < 1) {
            return -1;
        }
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        int[] fb = new int[n];
        fb[0] = 0;
        fb[1] = 1;
        for(int i = 2; i < n; i++){
            fb[i] = fb[i - 1] + fb[i - 2];
            
        }
        return fb[n-1];
    }
}

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        // write your code here
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        int first = 0;
        int second = 1;
        int res = 0;
        n-= 2;
        while(n-- > 0) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}





