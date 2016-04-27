class MinStack {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int x) {
        if(stack2.isEmpty() || stack2.peek() >= x) {
        	stack2.push(x);
        }
        stack1.push(x);
    }

    public void pop() {
        if(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().equals(stack2.peek())) {
        	stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
