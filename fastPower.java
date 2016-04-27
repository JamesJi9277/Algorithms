// Calculate the an % b where a, b and n are all 32bit integers.
//
// Have you met this question in a real interview? Yes
// Example
// For 2^31 % 3 = 2
//
// For 100^1000 % 1000 = 0
//
// Challenge
// O(logn)
//a^n % b
public class Solution {
  public int fastPower(int a, int b, int n) {
    if(n == 0) {
      return 1 % b;
    }
    if(n == 1) {
      return a % b;
    }
    long res = fastPower(a, b, n / 2);
    res = (res * res) % b;
    if(n % 2 == 1) {
      res = (res * a) % b;
    }
    return (int)res;
  }
}
