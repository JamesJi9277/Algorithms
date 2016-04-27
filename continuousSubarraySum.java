// Given an integer array, find a continuous subarray where the sum of numbers is the biggest. Your code should return the index of the first number and the index of the last number. (If their are duplicate answer, return anyone)
//
// Have you met this question in a real interview? Yes
// Example
// Give [-3, 1, 3, -3, 4], return [1,4].
public class Solution {
  public ArrayList<Integer> continuousSubarraySum(int[] A) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    res.add(-1);
    res.add(-1);
    if(A == null || A.length == 0) {
      return res;
    }
    int max = Integer.MIN_VALUE;

    for(int i = 0; i < A.length; i++) {
      int sum = 0;
      for(int j = i; j < A.length; j++) {
        sum += A[j];
        if(sum > max) {
          res.set(0, i);
          res.set(1, j);
        }
        max = Math.max(sum, max);
      }
    }
    return res;
  }
}
//time complexity On, space complexity O1
public class Solution {
  public ArrayList<Integer> continuousSubarraySum(int[] A) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    if(A == null || A.length == 0) {
      return res;
    }
    int local = A[0];
    int global = A[0];
    int start = 0;
    int end = 0;
    int gstart = start;
    int gend = end;
    for(int i = 1; i < A.length; i++) {
      //local = Math.max(A[i], A[i] + local)
      if(A[i] > local + A[i]) {
        local = A[i];
        start = i;
        end = i;
      }
      else {
        local += A[i];
        end = i;
      }
      //global = Math.max(local, global)
      if(local > global) {
        global = local;
        gstart = start;
        gend = end;
      }
    }
    res.add(gstart);
    res.add(gend);
    return res;
  }
}
