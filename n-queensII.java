// Follow up for N-Queens problem.
//
// Now, instead outputting board configurations, return the total number of distinct solutions.
//
// Have you met this question in a real interview? Yes
// Example
// For n=4, there are 2 distinct solutions.
//在n queen的基础上直接返回result.size()即可
public class Solution {
    public static int sum;
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
    List<String> temp = new ArrayList<String>();
    getQueens(result, temp, n, 0);
    return result.size();
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


//solution from nine cha**ers,不需要画棋盘，只需要检测出是不是valid然后就可以count++了
public class Solution {
    public static int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueen(usedColumns, 0);
        return sum;
    }
    public void placeQueen(int[] usedColumns, int row) {
        int n = usedColumns.length;

        if (row == n) {
            sum ++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1);
            }
        }
    }
    public boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == col) {
                return false;
            }
            if ((row - i) == Math.abs(col-usedColumns[i])) {
                return false;
            }
        }
        return true;
    }
}
