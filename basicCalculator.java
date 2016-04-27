// Implement a basic calculator to evaluate a simple expression string.

// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

// You may assume that the given expression is always valid.

// Some examples:
// "1 + 1" = 2
// " 2-1 + 2 " = 3
// "(1+(4+5+2)-3)+(6+8)" = 23
public class Solution{
	public int calculate(String s){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
		int res = 0;
		for(int i =0;i<s.length();i++)
		{
			char tmp = s.charAt(i);
			if(Character.isDigit(tmp))
			{
				int num = tmp -'0';
				int j = i+1;
				while( j<s.length() && Character.isDigit(s.charAt(j)))
				{
					num = num*10 + s.charAt(j) - '0';
					j++
				}
				i = j-1;
				res += stack.pop()*num;
			}
			else if(tmp == '+' || tmp == '(')
				stack.push(stack.peek());
				else if(tmp == '-')
					stack.push(-1*stack.peek());
				else if(tmp == ')')
					stack.pop();
		}
		return res;
	}
}



public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim();
        int val = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                //直接将符号位加入
                stack.push(sign);
            }
            else if(c == ')') {
            	//把当前记录的sign pop出来
                stack.pop();
            }
            else if(c == '+' || c == '-') {
                //开始进行计算
                res += sign * val;
                //计算完后将当前val置0，并重置sign的值
                val = 0;
                if(!stack.isEmpty()) {
                    sign = (c == '-') ? stack.peek() * (-1) : stack.peek();
                }
                else {
                    sign = (c == '-') ? -1 : 1;
                }
            }
            //否则就只更新sign的值
            else if(c != ' ') {
                val = val * 10 + (c - '0');
            }
        }
        res += sign * val;
        return res;
    }
}

//second write at GU, bug free
public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int val = 0;
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(sign);
            }
            else if(c == ')') {
                stack.pop();
            }
            else if(c == '+' || c == '-') {
                res += val * sign;
                val = 0;
                if(stack.isEmpty()) {
                    sign = (c == '+') ? 1 : -1;
                }
                else {
                    sign = (c == '-') ? stack.peek() * (-1) : stack.peek();
                }
            }
            else if(c != ' ') {
                val = val * 10 + (c - '0');
            }
        }
        res += val * sign;
        return res;
    }
}






