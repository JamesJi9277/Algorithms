Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.

Examples: 
[2,3,4] , the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:

add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2



//brute force, TLE
class MedianFinder {
    List<Integer> array = new ArrayList<Integer>();
    // Adds a number into the data structure.
    public void addNum(int num) {
        array.add(num);
    }

    // Returns the median of current data stream
    public double findMedian() {
        Collections.sort(array);
        int size = array.size();
        if(size % 2 == 0) {
            return (array.get(size/2) + array.get(size/2 - 1)) / 2.0;
        }
        else {
            return array.get(size / 2);
        }
    }
};

//using two heap, minHeap and maxHeap, as for maxHeap, we need to overide method

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
//关键点是除了在heap元素交换的时候用poll，其余都是用peek的操作来返回，因为处理的数据是一个data stream
class MedianFinder {
    Cmp cmp1 = new Cmp();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(cmp1);
    private class Cmp implements Comparator<Integer> {
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        minHeap.offer(num);
        maxHeap.offer(minHeap.poll());
        if(maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return (minHeap.size() > maxHeap.size()) ? minHeap.peek() : ((minHeap.peek() + maxHeap.peek()) / 2.0);
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();