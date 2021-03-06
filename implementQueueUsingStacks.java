// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.
// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack2.pop();
    }

    // Get the front element.
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return (stack1.isEmpty() && stack2.isEmpty());
    }
}

//using one stack!
class MyQueue {
    // Push element x to the back of queue.
    Stack<Integer> stack;
    boolean flag;
    int peekVal;
    public MyQueue() {
        stack = new Stack<Integer>();
        flag = false;
        peekVal = 0;
    }
    public void push(int x) {
        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            pop();
            if(flag == true) {
                flag = false;
            }
            else {
                stack.push(val);
            }
        }
        else {
            flag = true;
        }
    }

    // Get the front element.
    public int peek() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            peek();
            if(flag == true) {
                flag = false;
                peekVal = val;
            }
            stack.push(val);
        }
        else {
            flag = true;
        }
        return peekVal;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.isEmpty();
    }
}