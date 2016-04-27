// Write a program to find the n-th ugly number.
//
// Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
//
// Note that 1 is typically treated as an ugly number.
//
// Hint:
//
// The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
// An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
// The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
// Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
public class Solution {
    public int nthUglyNumber(int n) {
        if(n < 1) {
          return 0;
        }
        if(n == 1) {
          return 1;
        }
        Queue<Integer> q2 = new LinkedList<Integer>();
        Queue<Integer> q3 = new LinkedList<Integer>();
        Queue<Integer> q5 = new LinkedList<Integer>();
        q2.offer(2);
        q3.offer(3);
        q5.offer(5);
        int uglyNumber = 1;
        int count = 1;
        while(count != n) {
          int min = Math.min(q2.peek(), Math.min(q3.peek(), q5.peek()));
          if(q2.peek() == min) {
            q2.poll();
          }
          else if(q3.peek() == min) {
            q3.poll();
          }
          else {
            q5.poll();
          }
          if(min != uglyNumber) {
            count++;
            uglyNumber = min;
            q2.offer(min * 2);
            q3.offer(min * 3);
            q5.offer(min * 5);
          }

        }
        return uglyNumber;
    }
}

//heap
public class Solution {
  public int nthUglyNumber(int n) {
    if(n < 1) {
      return 0;
    }
    if(n == 1) {
      return 1;
    }
    PriorityQueue<Long> heap = new PriorityQueue<Long>();
    heap.offer((long)1);
    long uglyNumber = 0;
    while(n-- > 0) {
      while(heap.peek() == uglyNumber) {
        heap.poll();
      }
      uglyNumber = heap.poll();
      heap.offer(uglyNumber * 2);
      heap.offer(uglyNumber * 3);
      heap.offer(uglyNumber * 5);
    }
    return (int)uglyNumber;
  }
}



//naive , and TLE, time complexity Onlogn, space, O1
public class Solution {
    public int nthUglyNumber(int n) {
        	if( n == 1 ){
        		return 1;
        	}
        	int find = 1; // 先找到第一个1了
        	for(int i = 2; i <= Integer.MAX_VALUE; i++){
        		if(isUglyNumeber(i)){
        			find++;
        		}
        		if( find == n ){
        			return i;
        		}
        	}
        	return -1;
    }

    private boolean isUglyNumeber(int num){
    	while( num != 1 ){
    		if( num % 2 == 0 ){
    			num = num/2;
    		}else if( num % 3 == 0 ){
    			num = num/3;
    		}else if( num % 5 == 0 ){
    			num = num/5;
    		}else{
    			return false;
    		}
    	}
    	return true;
    }
}
