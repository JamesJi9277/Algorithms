import java.util.HashSet;
import java.util.Scanner;

public class checkDuplicate {
	public static boolean doDFS(int[][] matrix, int i, int j, boolean[][] isUsed, int steps, int k, HashSet<Integer> set) {
		if(steps == k) {
			return false;
		}
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
			return false;
		}
		if(isUsed[i][j]) {
			return false;
		}
		if(set.contains(matrix[i][j])) {
			return true;
		}
		isUsed[i][j] = true;
		set.add(matrix[i][j]);
		boolean res = doDFS(matrix, i + 1, j, isUsed, steps + 1, k, set) || doDFS(matrix, i - 1, j, isUsed, steps + 1, k, set) || doDFS(matrix, i, j + 1, isUsed, steps + 1, k, set)|| doDFS(matrix, i, j - 1, isUsed, steps + 1, k, set);
		isUsed[i][j] = false;
		set.remove(matrix[i][j]);
		return res;
	}
	public static boolean hasDup(int[][] matrix, int k) {
		if(matrix == null || matrix.length == 0 ||matrix[0].length == 0) {
			return false;
		}
		if(k == 0 ) {
			return true;
		}
		int rowNum = matrix.length;
		int colNum = matrix[0].length;
		boolean[][] isUsed = new boolean[rowNum][colNum];
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0; i < rowNum; i++) {
			for(int j = 0; j < colNum; j++) {
				if(doDFS(matrix, i + 1, j, isUsed, 1, k, set)) {
					return true;
				}
				if(doDFS(matrix, i - 1, j, isUsed, 1, k, set)) {
					return true;
				}
				if(doDFS(matrix, i, j + 1, isUsed, 1, k, set)) {
					return true;
				}
				if(doDFS(matrix, i, j - 1, isUsed, 1, k, set)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix1 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
		int[][] matrix2 = new int[][]{{1,2,3}, {3,5,6}, {7,8,9}, {10,11,12}};
		int[][] matrix3 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}, {10,8,12}};
		int[][] matrix4 = new int[][]{{1}};
		int[][] matrix5 = new int[][]{{1,1}};
		int[][] matrix6 = new int[][]{{1},{1}};
		
		int k = 3; // the number of indices
		
		System.out.println(hasDup(matrix1, k));
		System.out.println(hasDup(matrix2, k));
		System.out.println(hasDup(matrix3, k));
		System.out.println(hasDup(matrix4, k));
		System.out.println(hasDup(matrix5, k));
		System.out.println(hasDup(matrix6, k));
	
	}
}