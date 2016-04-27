import java.util.*;
public class sub {
	public ArrayList<ArrayList<Character>> find(String s) {
		ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> temp = new ArrayList<Character>();
		helper(s, res, temp, 0);
		return res;
	}
	private void helper(String s, ArrayList<ArrayList<Character>> res, ArrayList<Character> temp, int index) {
		
		for(int i = index; i < s.length(); i++) {
			if(i != index && s.charAt(i) == s.charAt(i - 1)) {
				continue;
			}
			temp.add(s.charAt(i));
			helper(s, res, temp, i + 1);
			res.add(new ArrayList<Character>(temp));
			temp.remove(temp.size() - 1);
		}
	}
	public static void main(String[] args) {
		sub su =  new sub();
		String s = "abc";
		ArrayList<ArrayList<Character>> res = su.find(s);
		int j = 0;
		for(int i = 0; i < res.size(); i++) {
			for( j = 0; j < res.get(i).size(); j++) {
				System.out.print(res.get(i).get(j) + " ");
			}
			if(j == res.get(i).size()) {
				System.out.println(" ");
			}
		}
	}
}