Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().

Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

Call next() gets you 1, the first element in the list.

Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.

Show Hint 
Follow up: How would you extend your design to be generic and work with all types, not just integer?




// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
The major challenge of this problem is how to get the value without advancing the iterator. 
It turns out there is a way around it: Use next() when we need to peek(), 
and store the obtained value in an Integer nextValue for future use. If next() is called, 
use nextValue rather than actually perform next() for the iterator.


本题目考查的是设计模式中的装饰器模式decorator pattern
引入两个额外的变量nextElement和peekFlag
nextElement标识peek操作预先获取的下一个元素，peekFlag记录当前是否已经执行过peek操作
若已知所有元素非空，不使用peekFlag变量也可
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    //这里要将nextElement设置成null来方便比较，同时不能设置成int而是要Integer
    //这是一个关键
    private Integer nextElement = null;
    private boolean peekFlag = false;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(!peekFlag) {
            nextElement = iterator.next();
            peekFlag = true;
        }
        return nextElement;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(!peekFlag) {
	        return iterator.next();
	    }
	    peekFlag = false;
	    Integer res = nextElement;
	    nextElement = null;
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return peekFlag || iterator.hasNext();
	}
}