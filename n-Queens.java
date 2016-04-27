// The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
//
// Given an integer n, return all distinct solutions to the n-queens puzzle.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
//
// Have you met this question in a real interview? Yes
// Example
// There exist two distinct solutions to the 4-queens puzzle:
//
// [
//
//     [".Q..", // Solution 1
//
//      "...Q",
//
//      "Q...",
//
//      "..Q."],
//
//     ["..Q.", // Solution 2
//
//      "Q...",
//
//      "...Q",
//
//      ".Q.."]
//
// ]
// 解析：这个题相当于还是permutation这个题，不一样的就是我在permutation的基础上还需要加上是不是valid的判断
//因为n queen这个题说两个皇后不可以在同一行同一列和斜对角线上，所以要额外加上判断
//然后就是对结果的转换，比如说permutation这个题存在着结果比如是[2,1,3,4],对应的n queen就是说
//在第一行的第二个位置，第二行的第一个位置，第三行的第三个位置，第四行的第四个位置可以摆放皇后
// Challenge
// Can you do it without recursion?
class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
     ArrayList<String[]> solveNQueens(int n) {
        // write your code here
        ArrayList<String[]> res = new ArrayList<String[]>();

        if(n < 1) {
          return res;
        }
        doSesrch(n, new ArrayList<Integer>(), res);
        return res;
    }
    private String[] drawChessBoard(ArrayList<Integer> cols) {
      String[] chessboard = new String[col.size()];
      for(int i = 0; i < cols.size(); i++) {
        chessboard[i] = "";
        for(int j = 0; j < cols.size(); j++) {
          if(j == cols.get(i)) {
            chessboard[i] += "Q";
          }
          else {
            chessboard[i] += ".";
          }
        }
      }
      return chessboard;
    }
    private boolean isValid(ArrayList<Integer> cols, int col) {
      int row = cols.size();
      for(int i = 0; i < row; i++) {
        //same column
        if(cols.get(i) == col) {
          return false;
        }
        //left-top to right-bottom
        if(i - cols.get(i) == row - col) {
          return false;
        }
        //right-top to left-bottom
        if(i + cols.get(i) == row + col) {
          return false;
        }
      }
      return true;
    }
    private void search(int n, ArrayList<Integer> cols, ArrayList<String[]> res) {
      if(cols.size() == n) {
        res.add(drawChessBoard(cols));
        return;
      }
      for(int col = 0; col < n; col++) {
        if(!isValid(cols, col)) {
          continue;
        }
        cols.add(col);
        doSesrch(n, cols, res);
        cols.remove(cols.size() - 1);
      }
    }
};

//straight forword, and easy to understand
public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> temp = new ArrayList<String>();
    getQueens(result, temp, n, 0);
    return result;
  }
  private void getQueens(List<List<String>> result, List<String> temp, int n, int crt) {
    if(crt == n) {
      result.add(new ArrayList<String>(temp));
      return;
    }

    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < n; i++) {
      sb.append('.');
    }
    for(int i = 0; i < n; i++) {
      sb.setCharAt(i , 'Q');
      temp.add(sb.toString());
      if(isValid(temp)) {
        getQueens(result, temp, n, crt + 1);
      }
      sb.setCharAt(i , '.');
      temp.remove(temp.size() - 1);
    }
  }
  private boolean isValid(List<String> temp) {

    int row = temp.size();
    int col = temp.get(0).length();
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(temp.get(i).charAt(j) == 'Q') {
          //check current column
          for(int k = 0; k < row; k++) {
            if(temp.get(k).charAt(j) == 'Q' && k != i) {
              return false;
            }
          }
          //check current row
          for(int k = 0; k < col; k++) {
            if(temp.get(i).charAt(k) == 'Q' && k != j) {
              return false;
            }
          }
          //check diagnol
          int temp1 = i - 1;
          int temp2 = j - 1;
          while(temp1 >= 0 && temp1 < row && temp2 >= 0 && temp2 < col) {
            if(temp.get(temp1).charAt(temp2) == 'Q') {
              return false;
            }
            temp1--;
            temp2--;
          }

          temp1 = i - 1;
          temp2 = j + 1;
          while(temp1 >= 0 && temp1 < row && temp2 >= 0 && temp2 < col) {
            if(temp.get(temp1).charAt(temp2) == 'Q') {
              return false;
            }
            temp1--;
            temp2++;
          }
        }
      }
    }
    return true;
  }
}
