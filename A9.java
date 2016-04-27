// 1. Given an array of integers and a number N, write a function to rotate the array to the right by N positions
// For example
// Given an array = [A,B,C,D,E,F,G,H] with N=3, the result will be [F,G,H,A,B,C,D,E]
// follow up:  protect your function against malicious inputs
//三步翻转法
//Leetcode #189 Rotate Array
public class Solution {
	public char[] rightShift(char[] str, int n) {
		if(str == null || str.length == 0) {
			return str;
		}
		int length = str.length;
		n = n % length;
		doReverse(str, 0, length - n - 1);
		doReverse(str, length - n, length - 1);
		doReverse(str, 0, length - 1);
		return str;
	}
	private void doReverse(char[] str, int start, int end) {
		for(int i = 0; start + i < end - i; i++) {
			char temp = str[start + i];
			str[start + i] = str[end - i];
			str[end - i] = temp;
		}
	}
}

// 2.Given 3 arrays of Strings. 

// Array one = {Red, Green, Blue} 
// Array two = {Large, Medium, Small} 
// Array three={giant, monster}
// Print out combinations of all three array. . 1point3acres.com/
//这相当于是一个二维的DFS或者说二维的回溯，要分析出来回溯的处理条件探索条件以及返回条件
//参考generate parenthesis这个题
public class Solution {
	public void combinations(String[][] arrays) {
		if(arrays == null || arrays.length == 0 || arrays[0].length == 0) {
			return;
		}
		boolean[] isUsed = new boolean[arrays.length];
		doDFS(arrays, isUsed, 0, "");
	}
	private void doDFS(String[][] arrays, boolean[] isUsed, int k, String temp) {
		if(k == 3) {
			System.out.println(temp);
			return;
		}
		for(int i = 0; i < arrays.length; i++) {
			if(isUsed[i] == true) {
				continue;
			}
			isUsed[i] = true;
			for(int j = 0; j < arrays[i].length; j++) {
				doDFS(arrays, isUsed, k + 1, temp + arrays[i][j]);
			}
			isUsed[i] = false;
		}
	}
}



import java.util.ArrayList;

public class mergeThreeArray {
    public void mergeThreeArray(String[][] arrays) {
        //int arrayNum = arrays.length;
        ArrayList<String> temp = new ArrayList<String>();
        doDFS(0, arrays, temp);
    }
    private void doDFS(int start, String[][] arrays, ArrayList<String> temp) {
        if(start == arrays.length && temp.size() == arrays.length) {
            System.out.println(temp);
        }
        for(int i = start; i < arrays.length; i++) {
            String[] cur = arrays[i];
            for(int j = 0; j < cur.length; j++) {
                temp.add(cur[j]);
                doDFS(i + 1, arrays, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        String[] array1 = {"Red", "Green", "Blue"};
        String[] array2 = {"Large", "Medium", "Small"};
        String[] array3 = {"giant", "monster", "pig"};
        String[][] input = {array1, array2, array3};
        mergeThreeArray m = new mergeThreeArray();
        m.mergeThreeArray(input);
    }
}

// 3.题1:二维square数组spirally shift一位，顺时针。
// 如果输入的不是square数组，输出error，否则输出处理后的二维数组
public class Solution {
	public void spirallyShift(char[][] S) {
		if(S == null || S.length == 0 || S[0].length == 0 || S.length != S[0].length) {
			return;
		}
		
	}
}

