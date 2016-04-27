// Evaluate the value of an arithmetic expression in Reverse Polish Notation.

// Valid operators are +, -, *, /. Each operand may be an integer or another expression.

// Some examples:
//   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
//   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
//给你的就是valid逆波兰表达式，不需要重新再判断是否合适了，直接计算出数值即可
public class Solution{
	public int evalRPN(String[] tokens){
		Stack<String> number = new Stack<String>();
		for(int i =0; i< tokens.length; i++)
		{
			if(tokens[i].equals("+"))
			{
				int x = Integer.parseInt(number.pop());
				int y = Integer.parseInt(number.pop());
				int z = x+y;
				number.push( z + "");
			}
			else if(tokens[i].equals("*"))
			{
				int x = Integer.parseInt(number.pop());
				int y = Integer.parseInt(number.pop());
				int z = x*y;
				number.push( z + "");
			}
			else if(tokens[i].equals("-"))
			{
				int x = Integer.parseInt(number.pop());
				int y = Integer.parseInt(number.pop());
				int z = y-x;//stack是FILO，所以这里是y-x
				number.push( z + "");
			}
			else if(tokens[i].equals("/"))
			{
				int x = Integer.parseInt(number.pop());
				int y = Integer.parseInt(number.pop());
				int z = y/x; //stack是FILO，所以这里是y-x;
				number.push( z + "");
			}
			else
				number.push(token[i]);
		}
		return Integer.parseInt(number.pop());
	}
}