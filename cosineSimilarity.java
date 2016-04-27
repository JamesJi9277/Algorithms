class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            return 2.0000;
        }
        long squareSumOfA = 0L;
        long squareSumOfB = 0L;
        long factor = 0L;
        for(int i = 0; i < A.length; i++) {
            squareSumOfA += (A[i] * A[i]);
            squareSumOfB += (B[i] * B[i]);
            factor += (A[i] * B[i]);
        }
        if(squareSumOfA == 0 || squareSumOfB == 0) {
            return 2.0000;
        }
        return (double)(factor / (Math.sqrt(squareSumOfA) * Math.sqrt(squareSumOfB)));
    }
}

//test case设计的不够严谨，没有考虑overflow。设置成double一样可以过
class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            return 2.0000;
        }
        double squareSumOfA = 0L;
        double squareSumOfB = 0L;
        double factor = 0L;
        for(int i = 0; i < A.length; i++) {
            squareSumOfA += (A[i] * A[i]);
            squareSumOfB += (B[i] * B[i]);
            factor += (A[i] * B[i]);
        }
        if(squareSumOfA == 0 || squareSumOfB == 0) {
            return 2.0000;
        }
        return (double)(factor / (Math.sqrt(squareSumOfA) * Math.sqrt(squareSumOfB)));
    }
}


