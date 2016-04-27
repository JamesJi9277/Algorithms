// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in ZigZag-order.

// Have you met this question in a real interview? Yes
// Example
// Given a matrix:

// [
//   [1, 2,  3,  4],
//   [5, 6,  7,  8],
//   [9,10, 11, 12]
// ]
// return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) 
        	return null;
        int count = matrix.length * matrix[0].length;
        int[] array = new int[count];
        int r = 0, c = 0;
        array[0] = matrix[0][0];
        for (int i = 1; i < count; ) {
        	//横右走一步，不可横右走时竖下走一步
            if (i < count && c < matrix[0].length - 1) {
                array[i++] = matrix[r][++c];
            } else if (i < count && r < matrix.length - 1) {
                array[i++] = matrix[++r][c];
            }
            //斜下走到底
            while(i < count && r < matrix.length - 1 && c - 1 >= 0) {
                array[i++] = matrix[++r][--c];
            }
            //竖下走一步，不可竖下走时横右走一步
            if (i < count && r < matrix.length - 1) {
                array[i++] = matrix[++r][c];
            } else if (i < count && c < matrix[0].length - 1) {
                array[i++] = matrix[r][++c];
            }
            //斜上走到顶
            while(i < count && r - 1 >= 0 && c < matrix[0].length - 1) {
                array[i++] = matrix[--r][++c];
            }
        }
        return array;
    }
}

public class Solution {
	public int[] printZMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return null;
		}
		int r = matrix.length;
		int c = matrix[0].length;
		int total = r * c;
		int[] res = new int[total];
		int k = 0, i = 0, j = 0; 
		boolean bottomUp = true; 
		while(true) {
			res[k++] = matrix[i][j];
			if(k == total) {
				break;
			}
			if(bottomUp) {
				if(isValid( i - 1, j + 1, r, c)) {
					i -= 1;
					j += 1;
				}
				else {
					if(j == c - 1) {
						i = i + 1;
					}
					else {
						j = j + 1;
					}
					bottomUp = false;
				}
			}
			else if(!bottomUp) {
				if(isValid(i + 1, j - 1, r, c)) {
					i += 1;
					j -= 1;
				}
				else {
					if(i == r - 1) {
						j += 1;
					}
					else {
						i += 1;
					}
					bottomUp = true;
				}
			}
		}
		return res;
	}
	private boolean isValid(int i, int j, int m, int n) {
		if(i >= 0 && i < m && j >= 0 && j < n) {
			return true;
		}
		return false;
	}
}
