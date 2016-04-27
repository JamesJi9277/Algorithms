// You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).

// Have you met this question in a real interview? Yes
// Example
// Given a matrix

// [
//     [1,2],
//     [3,4]
// ]
// rotate it by 90 degrees (clockwise), return

// [
//     [3,1],
//     [4,2]
// ]
// Challenge
// Do it in-place.
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int level = m/2;
        for(int i = 0; i < level; i++) {
            for(int j = i; j < m - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - j][i];
                matrix[m - 1 - j][i] = matrix[m - 1 - i][m - 1 - j];
                matrix[m - 1 - i][m - 1 - j] = matrix[j][m - 1 - i];
                matrix[j][m - 1 - i] = temp;
            }
        }
        return;
    }
}


//拓展，一道rotate m*n matrix，
// 没有很难，跟leetcode rotate image差不多，只不过是m*n而已；

// 解析：
//     注意 m * n的数组, 
//     有可能是rotate clockwise也有可能是rotate counter clockwise，
//     并且rotate后的是新数组是n * m, 返回的是一个新的数组。
//     还是先从位置的变化方面观察看是否能得出坐标(i,j)的变换公式，
//     可以发现原m*n数组的(i,j)位置将会移动到新数组n*m的(j,rowNum-1-i)
//     这是向右clockwise旋转。同理也可以找到规律向左counter clockwise旋转。
//方向上如果是res[][i] = matrix[i][]，需要改变的是最外面的两个数，那么久将原matrix的colNum与心得进行对照
//同理，如果说是res[i][] = matrix[][i],需要改动的是matrix的row部分，那么就去找两个row之间的关系
//rotate clockwise，因为长宽不一样所以说不能够直接inplace而是要开辟一个新的矩阵
public class Solution {
    public static int[][] rotateClockwise(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] res = new int[colNum][rowNum];
        for(int i = 0; i < colNum; i++) {
            for(int j = 0; j < rowNum; j++) {
                res[i][j] = matrix[rowNum - 1 - j][i];
            }
        }
        return res;
    }

    public static int[][] rotateCounterClockwise(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rolNum = matrix.length;
        int colNum = matrix[0].length;
        int[][] res = new int[colNum][rolNum];
        for(int i = 0; i < colNum; i++) {
            for(int j = 0; j < rowNum; j++) {
                res[i][j] = matrix[j][colNum - 1 - i];
            }
        }
        return res;
    }
}

