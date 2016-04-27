
public class sort {
	public void sort(char[] array, int length) {
		int[] count = new int[26];
		for(int i = 0; i < length; i++) {
			count[array[i] - 'a']++;
		}
		char[] res = new char[length];
		int index = 0;
		for(int i = 0; i < 26; i++) {
			while(count[i]-- > 0) {
				res[index++] = (char)('a' + i);
			}
		}
		for(int i = 0; i < length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	public static void main(String[] args) {
		sort s = new sort();
		char[] array = {'c','b','c','d','e'};
		int length = 5;
		s.sort(array, length);
	}
}
