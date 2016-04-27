Sort a stack in ascending order (with biggest terms on top).

You may use at most one additional stack to hold items, but you may not copy the elements into any other data structure (e.g. array).

Have you met this question in a real interview? Yes
Example
Given stack =

| |
|3|
|1|
|2|
|4|
 -
return:

| |
|4|
|3|
|2|
|1|
 -
public class Solution {
    public void stackSorting(Stack<Integer> stack) {
        if(stack == null || stack.isEmpty()) {
            return;
        }
        Stack<Integer> tempStack = new Stack<Integer>();
        while(!stack.isEmpty()) {
            if(tempStack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            else {
                if(stack.peek() <= tempStack.peek()) {
                    tempStack.push(stack.pop());
                }
                else {
                    int temp = stack.pop();
                    while(!tempStack.isEmpty() && tempStack.peek() < temp) {
                        stack.push(tempStack.pop());
                    }
                    tempStack.push(temp);
                }
            }
        }
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }
}


 //Onlogn, On
 public class Solution {
    public void stackSorting(Stack<Integer> stack) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.sort(res);
        for(int i = 0; i < res.size(); i++) {
            stack.push(res.get(i));
        }
    }
}