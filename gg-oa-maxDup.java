import java.util.*;
public class maxDup {
	public int solution(int x) {
		char[] arr = String.valueOf(x).toCharArray();
		StringBuffer sb = new StringBuffer();
		int index = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] >= arr[i + 1]) {
				index = i;
				break;
			}
		}
		for(int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
			if(i == index) {
				sb.append(arr[i]);
			}
		}
		return Integer.parseInt(sb.toString());
	}
	public static void main(String[] args) {
		maxDup m = new maxDup();
		System.out.println(m.solution(100000000 - 1));
	}
}
