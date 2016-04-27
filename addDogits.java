// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
//
// For example:
//
// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
//
// Follow up:
// Could you do it without any loop/recursion in O(1) runtime?
//
// Hint:
//
// A naive implementation of the above process is trivial. Could you come up with other methods?
// What are all the possible results?
// How do they occur, periodically or randomly?
// You may find this Wikipedia article useful.
//这个题求的是数根，数根直接求的公式就是程序中的公式，dr(n) = 1 + (n - 1) % 9,也可以用递归的方法来做
public class Solution {
    public int addDigits(int num) {
      if(num < 0) {
        return 0;
      }
      return 1 + (num - 1) % 9;
    }
}

//recursive
public class Solution {
  public int addDigits(int num) {
    if(num < 0) {
      return 0;
    }
    if((num + "").length() == 1) {
      return num;
    }
    int sum = 0;
    String s = num + "";
    for(int i = 0; i < s.length(); i++) {
      sum += s.charAt(i) - '0';
    }
    return addDigits(sum);
  }
}


//跟palindrome number这个题目很像
public class Solution {
  public int addDigits(int num) {
    if(num < 10) {
      return num;
    }
    int result = num;
    while(result >= 10) {
      result = digitSum(result);
    }
    return result;
  }
  private int digitSum(int num) {
    int sum = 0;
    while(num != 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}
