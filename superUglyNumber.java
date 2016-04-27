iWrite a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
class Node {
	int index;
	int val;
	int prime;
	Node(int index, int val, int prime) {
		this.index = index;
		this.val = val;
		this.prime = prime;
	}
}
public class Solution {
	private class NodeComp implements Comparator<Node> {
		public int compare(Node n1, Node n2) {
			return n1.val - n2.val;
		}
	}
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(primes == null || primes.length == 0 || n < 0) {
			return 0;
		}
		NodeComp cmp = new NodeComp();
		int[] res = new int[n];
		res[0] = 1;
		PriorityQueue<Node> heap = new PriorityQueue<Node>(cmp);
		for(int i = 0; i < primes.length; i++) {
			heap.offer(new Node(0, primes[i], primes[i]));
		}
		for(int i = 1; i < n; i++) {
			Node cur = heap.peek();
			res[i] = cur.val;
			while(!heap.isEmpty() && heap.peek().val == res[i]) {
				cur = heap.poll();
				cur.val = res[++cur.index] * cur.prime;
				heap.offer(cur);
			}
		}
		return res[n - 1];
	}
}


correct but memory limit exceed
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0 || n < 0) {
            return 0;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        int count = 0;
        minHeap.offer(1);
        while(++count < n) {
            int temp = minHeap.poll();
            while(!minHeap.isEmpty() && temp == minHeap.peek()) {
                minHeap.poll();
            }
            for(int i = 0; i < primes.length; i++) {
                minHeap.offer(temp * primes[i]);
            }
        }
        return (int)minHeap.poll();
    }
}