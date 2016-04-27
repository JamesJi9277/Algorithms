Implement a stack. You can use any data structure inside a stack except stack itself to implement it.

Have you met this question in a real interview? Yes
Example
push(1)
pop()
push(2)
top()  // return 2
pop()
isEmpty() // return true
push(3)
isEmpty() // return false


class Stack {
    // Push a new item into the stack
    Queue<Integer> queue = new LinkedList<Integer>();
    int size = 0;
    public void push(int x) {
        Write your code here
        size++;
        queue.offer(x);
        int temp = size;
        while(--temp > 0) {
            queue.offer(queue.poll());
        }
    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        if(!queue.isEmpty()) {
            size--;
            queue.poll();
        }
    }

    // Return the top of the stack
    public int top() {
        // Write your code here
            return queue.peek();

    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return queue.isEmpty();
    }    
}