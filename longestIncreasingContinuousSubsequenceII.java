// Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).
//
// Have you met this question in a real interview? Yes
// Example
// Given a matrix:
//
// [
//   [1 ,2 ,3 ,4 ,5],
//   [16,17,24,23,6],
//   [15,18,25,22,7],
//   [14,19,20,21,8],
//   [13,12,11,10,9]
// ]
// return 25
//
// Challenge
// O(nm) time and memory.
//DFS + DP
public class Solution {
  public int longestIncreasingContinuousSubsequenceII(int[][] A) {
    if(A == null || A.length == 0 || A[0].length == 0) {
      return 0;
    }

    int res = 0;
    int[][] f = new int[A.length][A[0].length];

    for(int i = 0; i < A.length; i++) {
      for(int j = 0; j < A[0].length; j++) {
        if(f[i][j] == 0) {
          res = Math.max(res, doDFS(A, f, i, j));
        }
      }
    }
    return res;
  }
  private int doDFS(int[][] A, int[][] f, int i, int j) {
    if(f[i][j] != 0) {
      return f[i][j];
    }
    int left = 0, right = 0, up = 0, down = 0;
    if(j + 1 < A[0].length && A[i][j + 1] > A[i][j]) {
      right = doDFS(A, f, i, j + 1);
    }
    if(j > 0 && A[i][j - 1] > A[i][j]) {
      left = doDFS(A, f, i, j - 1);
    }
    if(i + 1 < A.length && A[i + 1][j] > A[i][j]) {
      down = doDFS(A, f, i + 1, j);
    }
    if(i > 0 && A[i - 1][j] > A[i][j]) {
      up = doDFS(A, f, i - 1, j);
    }
    f[i][j] = Math.max(Math.max(up, down), Math.max(left, right)) + 1;
    return f[i][j];
  }
}


//solution from nine ch***er
public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    int[][] f;
    int[][] flag;
    int n, m;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0 || A[0].length == 0) {
          return 0;
        }
        n = A.length;
        m = A[0].length;
        int res = 0;
        f = new int[n][m];
        flag = new int[n][m];

        for(int i = 0; i < n; i++) {
          for(int j = 0; j < m; j++) {
            f[i][j] = doSearch(i, j, A);
            res = Math.max(res, f[i][j]);
          }
        }
        return res;
    }
    private int doSearch(int x, int y, int[][] A) {
      if(flag[x][y] != 0) {
        return f[x][y];
      }

      int res = 1;
      for(int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
          if(A[x][y] > A[nx][ny]) {
            res = Math.max(res, doSearch(nx, ny, A) + 1);
          }
        }
      }
      flag[x][y] = 1;
      f[x][y] = res;
      return res;
    }
}
