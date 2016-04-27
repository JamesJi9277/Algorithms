 __    __   __    __   
/0 \__/6 \_/12\__/  \__
\__/3 \_/9 \__/15\__/  
/1 \_ /7\__/13\__/   \__
\__/4 \_/10\__/16\__/  
/2 \__/8 \__/14\__/  \__
\__/5 \__/11\__/17\__/  

高和宽可以任意输入，相邻的列是上下错开的，设计class + function
给定高和宽，在给定一个数字，顺时针打印出与数字对应的cell相邻的六个cell里面的数字

Example
高和宽input为3和6，输入index为4的时候，按照顺序打印出3，7，8，5，2，1，
如果遇到边缘的ceil，空缺的位置要打印"-1"

import java.util.*;
class Hex {
	int[][] matrix = null;
	public Hex(int row1, int col1) {
		this.matrix = new int[row1 + 2][col1 + 2];
		int row = matrix.length;
		int col = matrix[0].length;
		for(int i = 0; i < col; i++) {
			matrix[0][i] = -1;
			matrix[row - 1][i] = -1;
		}
		for(int i = 0; i < row; i++) {
			matrix[i][0] = -1;
			matrix[i][col - 1] = -1;
		}
		int count = 0;
		for(int i = 1; i < col - 1; i++) {
			for(int j = 1; j < row - 1; j++) {
				matrix[j][i] = count++;
			}
		}
	}
	public void printNeighbor(int x, int y) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		x++;
		y++;
		//尖头向上的五边形
		if(y % 2 == 1) {
			res.add(matrix[x + 1][y]);
			res.add(matrix[x][y + 1]);
			res.add(matrix[x - 1][y + 1]);
			res.add(matrix[x - 1][y]);
			res.add(matrix[x - 1][y - 1]);
			res.add(matrix[x][y - 1]);
		}
		else {
			res.add(matrix[x + 1][y]);
			res.add(matrix[x + 1][y + 1]);
			res.add(matrix[x][y + 1]);
			res.add(matrix[x - 1][y]);
			res.add(matrix[x][y - 1]);
			res.add(matrix[x + 1][y - 1]);
		}
		for(Integer item : res) {
			System.out.print(item + " ");
		}
	}
}
public class hexPrint {
	public static void main(String[] args) {
		Hex h = new Hex(3, 6);
		h.printNeighbor(1, 2);
	}
}
