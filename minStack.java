// Implement a stack with min() function, which will return the smallest number in the stack.
//
// It should support push, pop and min operation all in O(1) cost.
//
// Have you met this question in a real interview? Yes
// Example
// Operations: push(1), pop(), push(2), push(3), min(), push(1), min() Return: 1, 2, 1
public class Solution {
  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  public Solution() {
    stack = new Stack<Integer>();
    minStack = new Stack<Integer>();
  }

  public void push(int number) {
    stack.push(number);
    if(minStack.isEmpty()) {
      minStack.push(number);
    }
    else if (number <= Integer.parseInt(minStack.peek().toString())) {
      minStack.push(number);
    }
  }

  public int pop() {
    if(stack.peek().equals(minStack.peek())) {
      minStack.pop();
    }
    return stack.pop();
  }

  public int min() {
    return minStack.peek();
  }
}
