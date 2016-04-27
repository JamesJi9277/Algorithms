// Ugly number is a number that only have factors 3, 5 and 7.
//
// Design an algorithm to find the Kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15 ...
//
// Have you met this question in a real interview? Yes
// Example
// If K=4, return 9.
//
// Challenge
// O(K log K) or O(K) time.
//heap

class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        if(k < 1) {
            return 0;
        }
        PriorityQueue<Long> minHeap = new PriorityQueue<Long>();
        minHeap.offer(1L);
        int count = 0;
        long res = 0;
        //因为我先offer了1进去，所以要offset一位，变成count != k + 1
        while(count != k + 1) {
          //这里利用while来去重
            while(res == minHeap.peek()) {
                minHeap.poll();
            }
            res = minHeap.poll();
            minHeap.offer(res * 3);
            minHeap.offer(res * 5);
            minHeap.offer(res * 7);
            count++;
        }
        return res;
    }
};



//three queue implement heap
class Solution {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        if(k < 1) {
          return (long)0;
        }
        Queue<Long> q3 = new LinkedList<Long>();
        Queue<Long> q5 = new LinkedList<Long>();
        Queue<Long> q7 = new LinkedList<Long>();
        q3.offer((long)3);
        q5.offer((long)5);
        q7.offer((long)7);
        long uglyNumber = 1;
        int count = 0;
        while(count != k) {
          long min = Math.min(q3.peek(), Math.min(q5.peek(), q7.peek()));
          if(q3.peek() == min) {
            q3.poll();
          }
          else if(q5.peek() == min) {
            q5.poll();
          }
          else {
            q7.poll();
          }
          if(min != uglyNumber) {
            count++;
            uglyNumber = min;
            q3.offer(min * 3);
            q5.offer(min * 5);
            q7.offer(min * 7);
          }

        }
        return uglyNumber;
    }
};
