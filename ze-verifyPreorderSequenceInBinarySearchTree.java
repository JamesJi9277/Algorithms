public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return true;
        }
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private boolean helper(int[] preorder, int start, int end, int min, int max) {
        //这里的处理很重要，start > end指的已经全部判断完了在最底层慢慢return true上来
        //或者说是一开始数组为null和只有一个元素的时候，return true
        if(start > end) {
            return true;
        }
        int rootVal = preorder[start];
        if(!(rootVal > min && rootVal < max)) {
            return false;
        }
        int index = 0;
        for(index = start; index <= end; index++) {
            if(preorder[index] > rootVal) {
                break;
            }
        }
        return helper(preorder, start + 1, index - 1, min, rootVal) && helper(preorder, index, end, rootVal, max);
    }
}



n = input()
A = []
D = [0] * n. From 1point 3acres bbs

for _ in range(n):
    cmds = raw_input().split().1point3acres缃�
    op = cmds[0]
    if op == 'push':
        num = int(cmds[1])
        A.append(num). from: 1point3acres.com/bbs 
        print A[-1]

    elif cmd == 'pop':
        l = len(A)
        A.pop(). From 1point 3acres bbs
        if l-2 >= 0:-google 1point3acres
            D[l-2] += D[l-1]
        D[l-1] = 0
        if l == 1:
            print 'EMPTY'
        else:
            print A[-1] + D[l-2]
    
    else:. 鐗涗汉浜戦泦,涓€浜╀笁鍒嗗湴
        x, d = map(int, cmds[1:])
        D[x-1] += d
        l = len(A). 涓€浜�-涓夊垎-鍦帮紝鐙鍙戝竷
        print A[-1] + D[l-1] 









        class SuperStack {
    Stack<Long> stack;
    Stack<Long> stack2;
    PrintWriter p;
    public SuperStack() {
        stack = new Stack<Long>();
        stack2 = new Stack<Long>();
        p = new PrintWriter(System.out);
    }
    public void push(int num) {
        stack.push((long)num);
        p.println(stack.peek());
        p.flush();
    }
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
        if(stack.isEmpty()) {
           p.println("EMPTY"); 
           p.flush();
        }
        else {
            p.println(stack.peek());
            p.flush();
        } 
    }
    public void increase(int count, int addNum) {
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        } 
        while(count-- > 0) {
            if(stack2.isEmpty()) {
                return;
            }
            long num = stack2.pop();
            num += addNum;
            stack.push(num);
        }
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        p.println(stack.peek());
        p.flush();
    }
}



class SuperStack {
    Stack<Long> stack;
    Stack<Long> stack2;
    PrintWriter p;
    public SuperStack() {
        stack = new Stack<Long>();
        stack2 = new Stack<Long>();
        p = new PrintWriter(System.out);
    }
    public void push(int num) {
        stack.push((long)num);
        p.println(stack.peek());
        p.flush();
    }
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        stack.pop();
        if(stack.isEmpty()) {
           p.println("EMPTY"); 
           p.flush();
        }
        else {
            p.println(stack.peek());
            p.flush();
        } 
    }
    public void increase(int count, int addNum) {
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        } 
        while(count-- > 0) {
            if(stack2.isEmpty()) {
                return;
            }
            long num = stack2.pop();
            num += addNum;
            stack.push(num);
        }
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        p.println(stack.peek());
        p.flush();
    }
}