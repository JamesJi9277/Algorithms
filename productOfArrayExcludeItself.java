// Given an integers array A.
//
// Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.
//
// Have you met this question in a real interview? Yes
// Example
// For A = [1, 2, 3], return [6, 3, 2]
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> res = new ArrayList<Long>();
        if(A == null || A.size() == 0) {
          return res;
        }

        int size = A.size();
        for(int i = 0; i < size; i++) {
          if(i == 0) {
            res.add((long)1);
          }
          else {
            res.add(res.get(i - 1) * A.get(i - 1));
          }
        }
        long temp = 1;
        for(int i = size - 1; i >= 0; i--) {
          res.set(i, res.get(i) * temp);
          temp *= A.get(i);
        }
        return res;
    }
}

//second write, bug free
public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> res = new ArrayList<Long>();
        if(A == null || A.size() == 0) {
            return res;
        }
        long weight = 1;
        res.add((long)weight);
        for(int i = 1; i < A.size(); i++) {
            res.add((long)(res.get(i - 1) * A.get(i - 1)));
        }
        for(int i = A.size() - 1; i >= 0; i--) {
            res.set(i, res.get(i) * weight);
            weight *= A.get(i);
        }
        return res;
    }
}
